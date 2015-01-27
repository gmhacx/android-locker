package com.smyersdev.androidlocker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class UnlockReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Unlocked", Toast.LENGTH_SHORT).show();
		
		ConnectivityManager mngr = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
		
		
		boolean connect = WebGetter.checkConnection(mngr);
		
		if(connect){
			Toast.makeText(context, "Connection available", Toast.LENGTH_SHORT).show();
			
			WebGetter.getHttpMessage(mngr, "http://10.0.2.2/unlock.txt", context);
			
			
		} else {
			Toast.makeText(context, "Connection failed", Toast.LENGTH_SHORT).show();
		}
	}

}
