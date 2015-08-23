package com.android.contactslist;


import java.io.IOException;
import java.net.MalformedURLException;



import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Facebook.DialogListener;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginFoody extends Activity{
	private ImageButton exit,loginfc;
	private ImageButton fd;
	ProgressDialog	mProgressDialog;
	Facebook fc;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mlogin);
		exit=(ImageButton) findViewById(R.id.imtrove);
		loginfc=(ImageButton) findViewById(R.id.btnloginfc);
		fd=(ImageButton) findViewById(R.id.loginfoody);
		String App_id=getString(R.string.facebook_id);
		fc=new Facebook(App_id);
		
		mProgressDialog = new ProgressDialog(LoginFoody.this);
		// Set progressdialog title
		mProgressDialog.setTitle("Loggin in....");
		// Set progressdialog message
		mProgressDialog.setMessage(" ");
		mProgressDialog.setIndeterminate(false);
		// Show progressdialog
		mProgressDialog.show();
		mProgressDialog.dismiss();
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
				if(v==loginfc){
					updateImage();
				}
				if(fc.isSessionValid()){
					try {
						fc.logout(getApplicationContext());
						updateImage();
						Intent i=new Intent(LoginFoody.this,uselogin.class);
						startActivity(i);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					fc.authorize(LoginFoody.this, new DialogListener() {
						
						public void onFacebookError(FacebookError e) {
							// TODO Auto-generated method stub
							Toast.makeText(getApplicationContext(), "onFacebookError", Toast.LENGTH_LONG).show();
						}
						
						
						public void onError(DialogError e) {
							// TODO Auto-generated method stub
							Toast.makeText(getApplicationContext(), "onError", Toast.LENGTH_LONG).show();
						}
						
						
						public void onComplete(Bundle values) {
							// TODO Auto-generated method stub
							updateImage();
						}
						
						
						public void onCancel() {
							// TODO Auto-generated method stub
							Toast.makeText(getApplicationContext(), "onCancel", Toast.LENGTH_LONG).show();
						}
					});
				}
			
			}
		};
		exit.setOnClickListener(v);
		fd.setOnClickListener(v);
		loginfc.setOnClickListener(v);
	}
	private void updateImage() {
		// TODO Auto-generated method stub
		if(fc.isSessionValid()){
			
				postToWall();
				
				}
		else{
		
		}
	}
	public void postToWall() {
		  // post on user's wall.
		  fc.dialog(this, "feed", new DialogListener() {
		
		
		   public void onFacebookError(FacebookError e) {
		   }
		 
		  
		   public void onError(DialogError e) {
		   }
		 
		   
		   public void onComplete(Bundle values) {
			  
		   }
		 
		  
		   public void onCancel() {
		   }
		  });
		 
		 }
	
	
}
