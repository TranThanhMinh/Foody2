package com.android.contactslist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class LoginFoody extends Activity{
	private ImageButton exit;
	private ImageButton fd;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mlogin);
		exit=(ImageButton) findViewById(R.id.imtrove);
		fd=(ImageButton) findViewById(R.id.loginfoody);
		OnClickListener v=new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v==exit){
					Intent i=new Intent(LoginFoody.this, MainActivity.class);
					startActivity(i);
				}
				if(v==fd){
					Intent i=new Intent(LoginFoody.this, loginfd.class);
					startActivity(i);
				}
			}
		};
		exit.setOnClickListener(v);
		fd.setOnClickListener(v);
	}
}
