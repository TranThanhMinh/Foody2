package com.android.contactslist;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class informationfd<fragment>extends Activity {
	
	TextView tenquan,diachi,sdt,tien,gio;
	ImageView loadmap,image;
	int loader=R.drawable.foody;
	Button bb;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ImageLoader im=new ImageLoader(getApplicationContext());
		setContentView(R.layout.informationfd);
		
		
		
		image=(ImageView) findViewById(R.id.imView);
		loadmap=(ImageView) findViewById(R.id.maphello);
		tenquan=(TextView) findViewById(R.id.txtten);
		diachi=(TextView) findViewById(R.id.txtdiachi);
		sdt=(TextView) findViewById(R.id.txtsdt);
		tien=(TextView) findViewById(R.id.txttien);
		gio=(TextView) findViewById(R.id.txtgio);		
		final Quan e=(Quan) getIntent().getSerializableExtra("IdQuan");
		im.DisplayImage(e.getImage(), loader, image);
		tenquan.setText(e.getTenquan());
		diachi.setText(e.getDiachi());
		sdt.setText(e.getSdt());		
		tien.setText(e.getTien());
		gio.setText(e.getTimeopen()+" - "+ e.getTimeclose());
		

		
		loadmap.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri gmmIntentUri = Uri.parse("geo:0,0?q="+ e.getDiachi());
				Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
				mapIntent.setPackage("com.google.android.apps.maps");
				startActivity(mapIntent);
			}
		});
	}
		
}
