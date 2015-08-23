package com.android.contactslist;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class loginfd extends Activity{
	private ImageButton ex;
	Button dk,login;
	EditText txttk,txtpass;
	String tk,mk;
	private static final String TAG_SUCCESS = "success";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginfd);
		txttk=(EditText) findViewById(R.id.txttk);
		txtpass=(EditText) findViewById(R.id.txtpass);
		
		ex=(ImageButton) findViewById(R.id.imexit);
		dk=(Button) findViewById(R.id.btndk);
		login=(Button) findViewById(R.id.btnlogin);
		OnClickListener v=new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v==ex){
					Intent i=new Intent(loginfd.this,LoginFoody.class);
					startActivity(i);
				}
				if(v==dk){
					Intent i=new Intent(loginfd.this,register.class);
					startActivity(i);
				}
				if(v==login){
					
					new Login().execute();
					
				}
			}
		};
		ex.setOnClickListener(v);
		dk.setOnClickListener(v);
		login.setOnClickListener(v);
	}
	public class Login extends AsyncTask<String, String, String>{

		@Override
		protected String doInBackground(String... params) {
			 int success;
			
			 try {
				 tk=txttk.getText().toString();
				 mk=txtpass.getText().toString();
				 jSon j=new jSon();
				List<NameValuePair> param=new ArrayList<NameValuePair>();
				param.add(new BasicNameValuePair("TK",tk));
				param.add(new BasicNameValuePair("MK",mk));
				JSONObject json=j.getJSONFromUrl("http://minh1.comyr.com/new/kiemtralogin.php","POST", param);
				success = json.getInt(TAG_SUCCESS);
				
				if (success == 1) {
					
					
					Log.d("Login Successful!", json.toString());
					Intent i=new Intent(loginfd.this,uselogin.class);
					int ht=R.drawable.imgres;
					Bundle b=new Bundle();
					b.putInt("tk", ht);
					b.putString("ht", tk);
					i.putExtras(b);
					startActivity(i);
				}else{

                    Log.d("Login Failure!","loi");
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
	}
}

