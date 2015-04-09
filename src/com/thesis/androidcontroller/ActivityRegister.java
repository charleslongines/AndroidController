package com.thesis.androidcontroller;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegister extends Activity implements OnClickListener {
	final Context context = this;
	private EditText txtU, txtP, txtF;
	private Button btnRegg;
	DatabaseHandler db;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		 txtU = (EditText) findViewById(R.id.reg_username);
		 txtP = (EditText) findViewById(R.id.reg_password);
		 txtF = (EditText) findViewById(R.id.reg_fullname);
		
		btnRegg  = (Button) findViewById(R.id.btnNxt);
		
		btnRegg.setOnClickListener(this);
		
		db = new DatabaseHandler(this);

		
	}

	@Override
	public void onClick(View v) {
		
		String u = txtU.getText().toString();
		String p = txtP.getText().toString();
		String f = txtF.getText().toString();
		
		switch (v.getId()) {
		
		case R.id.btnNxt:
			db = new DatabaseHandler(this);
			 db.addUser(new LoginCredentials(u, p, f));
			 db.close();
			 Toast.makeText(context, "New User Successfully Save!", Toast.LENGTH_SHORT).show();
			 finish();
		
		}
		
	}
	
	


}
