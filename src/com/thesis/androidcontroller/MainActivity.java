package com.thesis.androidcontroller;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
       setContentView(R.layout.activity_main);
      
		Thread t = new Thread() {
			public void run() {
				try {
					sleep(5000);
					pass();
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally { finish();  }
			}
		}; t.start();
	}
	
	private void pass() {
		Intent intent = new Intent(MainActivity.this, ActivityLogin.class);
		startActivity(intent);
	}

}
