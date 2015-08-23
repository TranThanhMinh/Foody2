package com.android.contactslist;

import android.R.color;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class informationUse extends Activity {
	
	
	Button dangxuat,btnthietlap;
	ImageView ima;
	TextView htt;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.information_use);
		ima=(ImageView) findViewById(R.id.imageView1);
		htt=(TextView) findViewById(R.id.textView1);
		
		Intent i=getIntent();
		Bundle b=i.getExtras();
		int im=b.getInt("im");
		final String ht=b.getString("ht");
		ima.setBackgroundResource(im);
		htt.setText(ht);
		dangxuat =(Button) findViewById(R.id.btndangxuat);
		btnthietlap =(Button) findViewById(R.id.btnthietlap);
		OnClickListener v=new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v==dangxuat){
					Intent i=new Intent(informationUse.this, MainActivity.class);
					startActivity(i);
				}
				if(v==btnthietlap){
					Intent i=new Intent(informationUse.this, layout_thongtin.class);
					Bundle b=new Bundle();
					b.putString("ht",ht);
					i.putExtras(b);
					startActivity(i);
				}
			}
		};
		dangxuat.setOnClickListener(v);
		btnthietlap.setOnClickListener(v);
}
}
