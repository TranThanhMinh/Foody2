package com.android.contactslist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class loginfd extends Activity{
	private ImageButton ex;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginfd);
		ex=(ImageButton) findViewById(R.id.imexit);
		OnClickListener v=new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v==ex){
					Intent i=new Intent(loginfd.this,LoginFoody.class);
					startActivity(i);
				}
			}
		};
		ex.setOnClickListener(v);
	}
}
