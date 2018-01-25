package com.satyahair.skinnhair.model.hair;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.LogPrinter;

import com.satyahair.skinnhair.model.bean.BitmapMap;
import com.satyahair.skinnhair.model.bean.ContactUsInfo;
import com.satyahair.skinnhair.network.IServerResponseListener;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Sandeep on 18/02/2017.
 */

public class HairContactUsIntractorImpl implements IHairContactUsIntarctor {

    @Override
    public void onSubmitClick(ContactUsInfo info, final OnQuerySubmitted listener) {
        SendHttpRequestTask requestTask = new SendHttpRequestTask("https://www.satyahairtransplantclinic.com/web-services/api.php", info, new IServerResponseListener() {
            @Override
            public void onResponse(String response) {
                LogPrinter printer = new LogPrinter(1, "hair");
                printer.println(response+"");
                listener.onQuerySubmittedSuccesfully();
            }

            @Override
            public void onErrorResponse(int errorType, String response) {

            }
        });
        requestTask.execute();
    }


    private class SendHttpRequestTask extends AsyncTask<Void, Void, String> {
        private OutputStream os;
        private HttpURLConnection con;
        ContactUsInfo info;
        private String url;
        private String boundary = "SwA" + Long.toString(System.currentTimeMillis()) + "SwA";
        private String delimiter = "--";
        private IServerResponseListener mListener;

        public SendHttpRequestTask(String url, ContactUsInfo info, IServerResponseListener listener) {
            this.url = url;
            this.info = info;
            mListener = listener;
        }

        @Override
        protected String doInBackground(Void... params) {
            String data = null;
            try {
                connectForMultipart();
                addFormPart("uid", "satyaapi");
                addFormPart("name", info.getName());
                addFormPart("email", info.getEmail());
                addFormPart("phone", info.getPhoneno());
                addFormPart("message", info.getMessage());
                if (info.getType().equals("Appointment")) {
                    addFormPart("dr_name", info.getDr_name());
                    addFormPart("clinic_name", info.getClinic_name());
                }
                addFormPart("type", info.getType());
                addFilePart("image_front_view", "", getByteArrayFromBitmap(info.getFrontpic()));
                addFilePart("image_back_view", "", getByteArrayFromBitmap(info.getBackpic()));
                addFilePart("image_top_view", "", getByteArrayFromBitmap(info.getToppic()));
                addFilePart("image_right_view", "", getByteArrayFromBitmap(info.getRightpic()));
                addFilePart("image_left_view", "", getByteArrayFromBitmap(info.getLeftpic()));
                finishMultipart();
                data = getResponse();

            } catch (Throwable t) {
                t.printStackTrace();
            }
            return data;
        }

        byte[] getByteArrayFromBitmap(BitmapMap pic) {
            if (pic == null) {
                return null;
            }
            Bitmap bitmap = null;
            if (pic.getPath() != null) {
                bitmap = BitmapFactory.decodeFile(pic.getPath());
            } else if (pic.getBitmap() != null) {
                bitmap = pic.getBitmap();
            }
            if (bitmap == null) {
                return null;
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, baos);
            return baos.toByteArray();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mListener.onResponse(s);
        }

        public void connectForMultipart() throws Exception {
            con = (HttpURLConnection) (new URL(url)).openConnection();
            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestProperty("Connection", "Keep-Alive");
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.connect();
            os = con.getOutputStream();
        }

        public void addFormPart(String paramName, String value) throws Exception {
            writeParamData(paramName, value);
        }

        public void addFilePart(String paramName, String fileName, byte[] data) throws Exception {
            if (data == null) {
                return;
            }
            os.write((delimiter + boundary + "\r\n").getBytes());
            os.write(("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"\r\n").getBytes());
            os.write(("Content-Type: application/octet-stream\r\n").getBytes());
            os.write(("Content-Transfer-Encoding: binary\r\n").getBytes());
            os.write("\r\n".getBytes());

            os.write(data);

            os.write("\r\n".getBytes());
        }

        public void finishMultipart() throws Exception {
            os.write((delimiter + boundary + delimiter + "\r\n").getBytes());
        }

        public String getResponse() throws Exception {
            InputStream is = con.getInputStream();
            byte[] b1 = new byte[1024];
            StringBuffer buffer = new StringBuffer();

            while (is.read(b1) != -1)
                buffer.append(new String(b1));

            con.disconnect();

            return buffer.toString();
        }

        private void writeParamData(String paramName, String value) throws Exception {


            os.write((delimiter + boundary + "\r\n").getBytes());
            os.write("Content-Type: text/plain\r\n".getBytes());
            os.write(("Content-Disposition: form-data; name=\"" + paramName + "\"\r\n").getBytes());
            os.write(("\r\n" + value + "\r\n").getBytes());


        }
    }
}
