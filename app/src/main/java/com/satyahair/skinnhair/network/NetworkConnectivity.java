package com.satyahair.skinnhair.network;

import android.net.ConnectivityManager;
import android.widget.Toast;

import com.satyahair.skinnhair.SkinNHair;

/**
 * Created by Sandeep on 21/01/2016.
 */
public class NetworkConnectivity {

    private boolean checkInternetConenction() {
        // get Connectivity Manager object to check connection
        ConnectivityManager connec
                = (ConnectivityManager) SkinNHair.getApplication().getSystemService(SkinNHair.getApplication().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() ==
                android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {
            return true;
        } else if (
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() ==
                                android.net.NetworkInfo.State.DISCONNECTED) {
            return false;
        }
        return true;
    }
}