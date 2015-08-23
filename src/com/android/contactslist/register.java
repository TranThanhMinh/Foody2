package com.android.contactslist;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class register extends Activity {
	
	ImageButton ex;
	EditText txttk,txtpass,txtlpass,txtht;
	Button dk;
	 @SuppressLint("NewApi") 
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			 StrictMode.ThreadPolicy poly=new StrictMode.ThreadPolicy.Builder().permitAll().build();
		        StrictMode.setThreadPolicy(poly);
			super.onCreate(savedInstanceState);
			setContentView(R.layout.register);
			txttk=(EditText) findViewById(R.id.edittk);
			txtpass=(EditText) findViewById(R.id.editpass);
			txtlpass=(EditText) findViewById(R.id.editlpass);
			txtht=(EditText) findViewById(R.id.editht);
			ex=(ImageButton) findViewById(R.id.btntrove);
			dk=(Button) findViewById(R.id.btnregister);
			dk.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					InputStream is=null;
					// TODO Auto-generated method stub
					String tk=txttk.getText().toString();
					String mk=txtpass.getText().toString();
					String lmk=txtlpass.getText().toString();
					String tenht=txtht.getText().toString();
					if(tk.equals("")){
						Toast.makeText(getApplicationContext(), "Please add account! ",Toast.LENGTH_SHORT).show();
					}
					if(mk.equals("")){
						Toast.makeText(getApplicationContext(), "Please add password! ",Toast.LENGTH_SHORT).show();
					}
//					else if(mk!=lmk){
//						Toast.makeText(getApplicationContext(), "unlike password! ",Toast.LENGTH_SHORT).show();
//					}
					else{
					List<NameValuePair> params=new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("TK",tk));	
					params.add(new BasicNameValuePair("MK",mk));
					params.add(new BasicNameValuePair("LMK",lmk));
					params.add(new BasicNameValuePair("TenHT",tenht));
					try {
						HttpClient client=new DefaultHttpClient();
					
						HttpPost post=new HttpPost("http://minh1.comyr.com/new/insert.php");
						Log.e("ClientProtocol","Log_tag1");
						post.setEntity(new UrlEncodedFormEntity(params));
						Log.e("ClientProtocol","Log_tag2");
						HttpResponse reponse=client.execute(post);
						Log.e("ClientProtocol","Log_tag3");
						HttpEntity entity=reponse.getEntity();
						Log.e("ClientProtocol","Log_tag4");
						is=entity.getContent();
						Toast.makeText(getApplicationContext(), "Thanh COng",Toast.LENGTH_LONG).show();
					} catch (ClientProtocolException e) {
						Log.e("ClientProtocol","Log_tag");
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {					
						e.printStackTrace();
					}
				}
				}
			});
			OnClickListener v=new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(v==ex){
						Intent i=new Intent(register.this,loginfd.class);
						startActivity(i);
					}
					
					
				}
			};
			ex.setOnClickListener(v);
			
			
		}
}
