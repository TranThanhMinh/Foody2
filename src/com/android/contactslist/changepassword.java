package com.android.contactslist;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class changepassword extends Activity{

		Button btnluu;
		EditText mkc,mkm,lmkm;
		@SuppressLint("NewApi")
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			StrictMode.ThreadPolicy poly=new StrictMode.ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(poly);
			super.onCreate(savedInstanceState);
			setContentView(R.layout.changepassword);
			mkc=(EditText) findViewById(R.id.editmkht);
			mkm=(EditText) findViewById(R.id.editmkm);
			lmkm=(EditText) findViewById(R.id.editlmkm);
			btnluu=(Button) findViewById(R.id.btnluu);
			btnluu.setOnClickListener(new  OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String mkht=mkc.getText().toString();
					String mkm1=mkm.getText().toString();
					String lmkm1=lmkm.getText().toString();
					List<NameValuePair> name=new ArrayList<NameValuePair>();
					name.add(new BasicNameValuePair("MatKhau", mkht));
					name.add(new BasicNameValuePair("MatKhauMoi", lmkm1));
					jSon js=new jSon();
					JSONObject ob=js.getJSONFromUrl("http://minh1.comyr.com/new/UpdateMK.php","POST", name);
					Toast.makeText(getApplicationContext(), "Thành Công!...",Toast.LENGTH_LONG).show();
					
				}
			});
		}
}