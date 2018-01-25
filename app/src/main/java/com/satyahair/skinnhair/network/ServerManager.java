package com.satyahair.skinnhair.network;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.conn.params.ConnManagerParams;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;


/**
 * Created by Sandeep on 09/01/2016.
 */
public class ServerManager {
    private static ServerManager mInstance = new ServerManager();

    private ServerManager() {
    }

    public synchronized static ServerManager getInstance() {
        if (mInstance == null) {
            mInstance = new ServerManager();
        }
        return mInstance;
    }


    public void requestDataFromServer(String url, IServerResponseListener listener, List<NameValuePair> nameValuePair, int type) {
        PostFetcher fetcher = new PostFetcher(url,listener, nameValuePair,type);
        fetcher.execute();
    }




    private class PostFetcher extends AsyncTask<Void, Void, String> {
        private static final String TAG = "PostFetcher";
        public String SERVER_URL = "";
        private int type;
        List<NameValuePair> nameValuePair = null;
        IServerResponseListener listener = null;
        JSONObject jsonObject = null;

        public PostFetcher(String api, IServerResponseListener listener, List<NameValuePair> nameValuePair, int type) {
            this.listener = listener;
            SERVER_URL = IServerResponseListener.SERVER_URL + api;
            this.nameValuePair = nameValuePair;
            this.type = type;
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                HttpResponse response = null;

                 if (type == IServerResponseListener.REQUEST_GET) {
                    response = collectGetResponse(SERVER_URL);
                } else if (type == IServerResponseListener.REQUEST_POST) {
                     response = collectPostResponse(SERVER_URL, nameValuePair);;
                }

                StatusLine statusLine = response.getStatusLine();
                if (statusLine.getStatusCode() == IServerResponseListener.RESPONSE_OK) {
                    HttpEntity entity = response.getEntity();
                    InputStream content = entity.getContent();
                    try {
                        String resultString = convertStreamToString(content);
                        Log.v(TAG, "resultString: " + resultString);
                        content.close();
                        return resultString;
                    } catch (Exception ex) {
                        Log.e(TAG, "Failed to parse JSON due to: " + ex);
                    }
                } else if (statusLine.getStatusCode() == IServerResponseListener.RESPONSE_ERROR_500) {
                    Log.e(TAG, "Server responded with status code: " + statusLine.getStatusCode());
                    return IServerResponseListener.RESPONSE_EXCEPTION_500;
                } else {
                    Log.e(TAG, "Server responded with status code: " + statusLine.getStatusCode());
                    return IServerResponseListener.RESPONSE_EXCEPTION_UNKNOWN;
                }
            } catch (Exception ex) {
                Log.e(TAG, "Failed to send HTTP POST request due to: " + ex);
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject json = null;
                // If Server has exception
                if (s == IServerResponseListener.RESPONSE_EXCEPTION_500) {
                    listener.onErrorResponse(IServerResponseListener.RESPONSE_ERROR_500, s);
                    return;
                } else if (s == IServerResponseListener.RESPONSE_EXCEPTION_UNKNOWN) {
                    listener.onErrorResponse(IServerResponseListener.RESPONSE_ERROR_UNKNOWN, s);
                    return;
                } else if (s == null) {
                    // if Server didn't respond any data
                    listener.onErrorResponse(IServerResponseListener.RESPONSE_ERROR_DATA_NULL, s);
                    return;
                } else if (s.equals("")) {
                    // if Server didn't respond any data
                    listener.onErrorResponse(IServerResponseListener.RESPONSE_ERROR_DATA_NULL, s);
                    return;
                }

                json = new JSONObject(s);
                String status = null;
                if (json.has("Status")) {
                    status = json.getString("Status");
                } else {
                    listener.onResponse(s);
                    return;
                }
                if (status.equalsIgnoreCase("Success") || status.equalsIgnoreCase("True") || status.equalsIgnoreCase("Valid") || status.equalsIgnoreCase("ok")
                        || status.equalsIgnoreCase("Updated Successfully")) {
                    listener.onResponse(s);
                } else if (status.equalsIgnoreCase("FAILURE")) {
                    listener.onErrorResponse(IServerResponseListener.RESPONSE_ERROR_FAILURE, s);
                } else {
                    listener.onErrorResponse(IServerResponseListener.RESPONSE_ERROR_UNKNOWN, s);
                }
            } catch (JSONException e) {
                listener.onResponse(s);
                e.printStackTrace();
            }
        }

        private HttpResponse collectGetResponse(String server_url) throws IOException {
            Log.d(TAG, "SERVER_URL : " + server_url);
            HttpParams httpParameters = new BasicHttpParams();
            // Set the timeout in milliseconds until a connection is established.
            // The default value is zero, that means the timeout is not used.
            int timeoutConnection = 4000;
            HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
            // Set the default socket timeout (SO_TIMEOUT)
            // in milliseconds which is the timeout for waiting for data.
            int timeoutSocket = 6000;
            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

            HttpClient httpClient = new DefaultHttpClient(httpParameters);

            HttpGet httpGet = new HttpGet(server_url);
            httpGet.setParams(httpParameters);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            return httpResponse;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        private String convertStreamToString(InputStream is) throws UnsupportedEncodingException {
            String line = "";
            StringBuilder total = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
            try {
                while ((line = rd.readLine()) != null) {
                    total.append(line);
                }
            } catch (Exception e) {
            }
            return total.toString();
        }


        private HttpResponse collectPostResponse(String server_url, List<NameValuePair> nameValuePair) throws IOException {

            HttpParams httpParameters = new BasicHttpParams();
            ConnManagerParams.setTimeout(httpParameters, 10000);
            // Set the timeout in milliseconds until a connection is established.
            // The default value is zero, that means the timeout is not used.
            int timeoutConnection = 4000;
            HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
            // Set the default socket timeout (SO_TIMEOUT)
            // in milliseconds which is the timeout for waiting for data.
            int timeoutSocket = 6000;
            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

            HttpClient httpClient = new DefaultHttpClient(httpParameters);
            HttpPost httpPost = new HttpPost(server_url);
            httpPost.setParams(httpParameters);
            Log.d(TAG, "SERVER_URL : " + server_url);
            try {
                if (nameValuePair != null) {
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return httpClient.execute(httpPost);
        }
    }
}
