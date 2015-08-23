package com.android.contactslist;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class arraySearch extends ArrayAdapter<Quan> {
	ArrayList<Quan> list;
	int resource;
	LayoutInflater lay;
	public arraySearch(Context context, int textViewResourceId,
			ArrayList<Quan> objects) {
		super(context, textViewResourceId, objects);
		lay=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.list=objects;
		this.resource=textViewResourceId;
	}
	
		
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v=convertView;
		Quan employ=getItem(position);
		v=lay.inflate(resource, null);
		ImageView im=(ImageView) v.findViewById(R.id.image2);
		TextView tenquan=(TextView) v.findViewById(R.id.httenquan1);
		TextView diachi=(TextView) v.findViewById(R.id.htdiachi1);	
		
		
		
		new IMAGE(im).execute(employ.getImage());
		tenquan.setText(employ.getTenquan());
		diachi.setText(employ.getDiachi());
		return v;
		// TODO Auto-generated method stub
		
	}
 private  class IMAGE extends AsyncTask<String, Void, Bitmap>{
	 ImageView image;
	  @SuppressWarnings("unused")
	public IMAGE(ImageView view) {
		// TODO Auto-generated constructor stub
		  this.image=view;
	}
	@Override
	protected Bitmap doInBackground(String... url) {
		String urlIm=url[0];
		Bitmap bitmap=null;
		try {
			InputStream in = new java.net.URL(urlIm).openStream();
			bitmap=BitmapFactory.decodeStream(in);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bitmap;
	}
	 @Override
	protected void onPostExecute(Bitmap result) {
		// TODO Auto-generated method stub
		image.setImageBitmap(result);
	}
 }
}


