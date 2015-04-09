package com.thesis.androidcontroller;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		
		Button btnLight			= (Button) findViewById(R.id.btnLight);
		Button btnTv 			= (Button) findViewById(R.id.btnTv);
		Button btnRadio		= (Button) findViewById(R.id.btnRadio);
		Button btnAirCon		= (Button) findViewById(R.id.btnAircon);
	
		
		btnLight.setOnClickListener(new View.OnClickListener() {
		
		@Override
			public void onClick(View view) {
			 //Put up the Yes/No message box
	    	AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
	    	builder
	    	.setTitle("Action")
	    	.setMessage("do you want to turn on or turn off this appliances?")
	    	.setIcon(android.R.drawable.ic_dialog_alert)
	    	.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	    	    public void onClick(DialogInterface dialog, int which) {			      	
	    	    	passLightController();
	    	    }
	    	})
	    	.setNegativeButton("No", null)						//Do nothing on no
	    	.show();
			//passLightController();
			}
		});
		
		btnTv .setOnClickListener(new View.OnClickListener() {
		@Override
			public void onClick(View view) {
			 //Put up the Yes/No message box
	    	AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
	    	builder
	    	.setTitle("Action")
	    	.setMessage("do you want to turn on or turn off this appliances?")
	    	.setIcon(android.R.drawable.ic_dialog_alert)
	    	.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	    	    public void onClick(DialogInterface dialog, int which) {			      	
	    	    	pass1();
	    	    }
	    	})
	    	.setNegativeButton("No", null)						//Do nothing on no
	    	.show();	
			
			
			}
		});
		
		
		btnRadio.setOnClickListener(new View.OnClickListener() {
			@Override
				public void onClick(View view) {
				 //Put up the Yes/No message box
		    	AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
		    	builder
		    	.setTitle("Action")
		    	.setMessage("do you want to turn on or turn off this appliances?")
		    	.setIcon(android.R.drawable.ic_dialog_alert)
		    	.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		    	    public void onClick(DialogInterface dialog, int which) {			      	
		    	    	 passRadioController();
		    	    }
		    	})
		    	.setNegativeButton("No", null)						//Do nothing on no
		    	.show();	
				
				
				}
			});
		
		btnAirCon.setOnClickListener(new View.OnClickListener() {
			@Override
				public void onClick(View view) {
				AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
		    	builder
		    	.setTitle("Action")
		    	.setMessage("do you want to turn on or turn off this appliances?")
		    	.setIcon(android.R.drawable.ic_dialog_alert)
		    	.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		    	    public void onClick(DialogInterface dialog, int which) {			      	
		    	    	pass2();
		    	    }
		    	})
		    	.setNegativeButton("No", null)						//Do nothing on no
		    	.show();	
				}
			});
	}
	
	
	
	
	private void passLightController() {
		Intent intent = new Intent(DashboardActivity.this, LightActivityTemporary.class);
		startActivity(intent);
	}
	

	private void passRadioController() {
		Intent intent = new Intent(DashboardActivity.this, ActivityRadio.class);
		startActivity(intent);
	}
	
	private void pass1() {
		Intent intent = new Intent(DashboardActivity.this, ActivityTelevision.class);
		startActivity(intent);
	}
	
	private void pass2() {
		Intent intent = new Intent(DashboardActivity.this, ActivityAircondition.class);
		startActivity(intent);
	}
	
	
	

}
