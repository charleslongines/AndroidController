package com.thesis.androidcontroller;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends Activity implements OnClickListener {
	final Context context = this;
	private EditText txtUsername, txtPassword;
	DatabaseHandler db;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		 txtUsername = (EditText) findViewById(R.id.sys_username);
		 txtPassword = (EditText) findViewById(R.id.sys_password);
		
		Button btnLogin 	= (Button) findViewById(R.id.btnLogin);
		Button btnRegister  = (Button) findViewById(R.id.btnRegister);
		
		btnLogin.setOnClickListener(this);
		btnRegister.setOnClickListener(this);
		
		db = new DatabaseHandler(this);

		
	}

	@Override
	public void onClick(View v) {
		
		String user = txtUsername.getText().toString();
		String pass = txtPassword.getText().toString();
				
		
		switch (v.getId()) {
		
		case R.id.btnLogin:
			
			
			if (db.login(user , pass)) {
				Toast.makeText(this,"Successfully Logged In", Toast.LENGTH_LONG).show();
				pass3();
				finish();
			} else {
				Toast.makeText(this,"Failure to Logged In", Toast.LENGTH_LONG).show();
			}
			
			break;
		
		case R.id.btnRegister:
			
			pass2();
		
		}
		
	}
	
	private void pass2() {
		Intent intent = new Intent(ActivityLogin.this, ActivityRegister.class);
		startActivity(intent);
	}
	
	private void pass3() {
		Intent intent = new Intent(ActivityLogin.this, DashboardActivity.class);
		startActivity(intent);
	}

}
