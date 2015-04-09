package com.thesis.androidcontroller;

import android.app.Activity;
import android.hardware.Camera.Parameters;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ActivityAircondition extends Activity {

	ImageButton btnSwitch;
	private boolean isFlashOn;
	
	Parameters params;
	MediaPlayer mp;
	
	boolean onOff = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aircon_controller);
		
		btnSwitch = (ImageButton) findViewById(R.id.btnSwitch);
		
		/*
		 * Switch button click event to toggle flash on/off
		 */
		turnOffFlash();
		btnSwitch.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (onOff) {
					turnOffFlash();
				} else {
					// turn on flash
					turnOnFlash();
				}
			}
		});
	}
	
	/*
	 * Playing sound
	 * will play button toggle sound on flash on / off
	 * */
	private void playSound(){
		if(isFlashOn){
			mp = MediaPlayer.create(ActivityAircondition.this, R.raw.light_switch_off);
		}else{
			mp = MediaPlayer.create(ActivityAircondition.this, R.raw.light_switch_on);
		}
		mp.setOnCompletionListener(new OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }
        }); 
		mp.start();
	}
	


	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	private void turnOnFlash() {
		// play sound
					playSound();
					btnSwitch.setImageResource(R.drawable.btn_switch_on);
					onOff = true;
	}

	

	/*
	 * Turning Off flash
	 */
	private void turnOffFlash() {
		// play sound
					playSound();
					btnSwitch.setImageResource(R.drawable.btn_switch_off);
					onOff = false;
		}
	


}
