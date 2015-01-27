package com.smyersdev.androidlocker;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class WebGetter {

	public static void getHttpMessage(ConnectivityManager mngr, String url){
		
	}
	
	public static boolean checkConnection(ConnectivityManager mngr){
		
		NetworkInfo info = mngr.getActiveNetworkInfo();
		if(info != null && info.isConnected()){
			return true;
		}		
		
		return false;
	}
}
