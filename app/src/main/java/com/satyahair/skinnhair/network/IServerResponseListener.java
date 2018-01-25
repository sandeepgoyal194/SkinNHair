package com.satyahair.skinnhair.network;

/**
 * Created by Sandeep on 09/01/2016.
 */
public interface IServerResponseListener {
 // public String SERVER_URL = "http://122.160.30.50:8080/PC_Test/";
 public String SERVER_URL = "";
//  public String SERVER_URL = "http://10.0.0.14:8080/PC/"; // testing server
 //public String SERVER_URL = "http://192.168.1.12:8080/PC/";
 //public String SERVER_URL =  "http://tomcat.softminesol.in/PC160516/";

    public int REQUEST_GET = 1;
    public int REQUEST_POST = 2;
    public int RESPONSE_OK = 200;

    public int RESPONSE_ERROR_500 = 500;
    public int RESPONSE_ERROR_DATA_NULL = 501;
    public int RESPONSE_ERROR_UNKNOWN = -1;
    public int RESPONSE_ERROR_FAILURE = 0;

    public String RESPONSE_EXCEPTION_500 = "RESPONSE_EXCEPTION_500";
    public String RESPONSE_EXCEPTION_UNKNOWN = "RESPONSE_EXCEPTION_UNKNOWN";

    public void onResponse(String response);

    public void onErrorResponse(int errorType, String response);
}
