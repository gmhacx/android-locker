package com.smyersdev.androidlocker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    

	@Override
	public void onBackPressed() {
		Toast.makeText(this.getBaseContext(), "Back", Toast.LENGTH_LONG).show();
	}


	@Override
	protected void onPause() {
		Toast.makeText(this.getBaseContext(), "Pause", Toast.LENGTH_LONG).show();
		super.onPause();
	}


	@Override
	protected void onStop() {
		Toast.makeText(this.getBaseContext(), "Stop", Toast.LENGTH_LONG).show();
		super.onStop();
		restart();
	}


	@Override
	protected void onDestroy() {
		Toast.makeText(this.getBaseContext(), "Destroy", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}
    
	void restart(){
		Intent intent = getIntent();
		finish();
		startActivity(intent);
	}
    
}
