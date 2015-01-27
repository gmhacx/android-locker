package com.smyersdev.androidlocker;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class WebGetter {

	public static void getHttpMessage(final ConnectivityManager mngr,
			final String url, final Context context) {
	
		AsyncTask<String, Integer, String> task = new AsyncTask<String, Integer, String>() {
			protected String doInBackground(String... urls) {

				Reader reader = null;
				StringBuilder builder = new StringBuilder();
				try {
					URL uurl = new URL(urls[0]);
					HttpURLConnection conn = (HttpURLConnection) uurl
							.openConnection();

					conn.setReadTimeout(1000);
					conn.setConnectTimeout(5000);
					conn.setRequestMethod("GET");
					conn.setDoInput(true);

					conn.connect();

					int response = conn.getResponseCode();
					Log.d("Web", "The response is " + response);

					InputStream is = conn.getInputStream();

					int bufferSize = 1000;
					char[] buffer = new char[bufferSize];
					reader = new InputStreamReader(is, "UTF-8");
					while (true) {
						int read = reader.read(buffer, 0, bufferSize);
						if (read < 0) {
							break;
						}
						builder.append(buffer, 0, read);
					}

				} catch (MalformedURLException e) {
					Log.e("Web", "Connection failed", e);
				} catch (IOException e) {
					Log.e("Web", "Connection failed", e);
				} finally {
					if (reader != null) {
						try {
							reader.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				return builder.toString();
			}

			@Override
			protected void onPostExecute(String result) {
				Toast.makeText(context, "Received text \"" + result + "\"", Toast.LENGTH_LONG).show();

			}
		};
		
		task.execute(url);

	}

	public static boolean checkConnection(ConnectivityManager mngr) {

		NetworkInfo info = mngr.getActiveNetworkInfo();
		if (info != null && info.isConnected()) {
			return true;
		}

		return false;
	}
}
