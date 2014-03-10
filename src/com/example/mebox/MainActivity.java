package com.example.mebox;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * added note
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		Toast.makeText(MainActivity.this,"Initialized", Toast.LENGTH_SHORT).show();
		final Button tvBtn = (Button) findViewById(R.id.tvBtn);
		final ImageButton wifiBtn = (ImageButton) findViewById(R.id.wifiBtn);

		tvBtn.setOnClickListener(new OnClickListener()  {
			@Override
			public void onClick(View v) {
				// Perform action on click   

				//            	Create the intent to start another activity
				//                Intent intent = new Intent(v.getContext(), AnotherActivity.class);
				//                startActivity(intent);
				Toast.makeText(MainActivity.this,"TV Button clicked", Toast.LENGTH_SHORT).show();
			}
		});

		wifiBtn.setOnClickListener(new OnClickListener()  {
			public void onClick(View v) {
				WifiManager wifi =(WifiManager)getSystemService(Context.WIFI_SERVICE); 
				if(wifi.isWifiEnabled()) {
					wifi.setWifiEnabled(false);
					Toast.makeText(MainActivity.this,"Wifi disabled", Toast.LENGTH_SHORT).show();
				}
				else {
					wifi.setWifiEnabled(true);
					Toast.makeText(MainActivity.this,"Wifi enabled", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		// Trigger the initial hide() shortly after the activity has been
		// created, to briefly hint to the user that UI controls
		// are available.
	}


}
