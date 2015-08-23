package com.android.contactslist;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;



import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Arrayapdater extends ArrayAdapter<Quan> {
	ArrayList<Quan> list;
	int resource;
	LayoutInflater lay;
	ImageLoader imgLoader =new ImageLoader(getContext()) ;
	public Arrayapdater(Context context, int textViewResourceId,
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
		ImageView im=(ImageView) v.findViewById(R.id.image1);
		TextView tenquan=(TextView) v.findViewById(R.id.httenquan);
		TextView diachi=(TextView) v.findViewById(R.id.htdiachi);	
		
		 int loader = R.drawable.ic_launcher;
		
		//new ImageLoader(employ.getImage(),im,80,80).execute();getApplicationContext()
		
         
	        // whenever you want to load an image from url
	        // call DisplayImage function
	        // url - image url to load
	        // loader - loader image, will be displayed before getting image
	        // image - ImageView 
	        imgLoader.DisplayImage(employ.getImage().toString(),loader, im);
		tenquan.setText(employ.getTenquan());
		diachi.setText(employ.getDiachi());
		return v;
		// TODO Auto-generated method stub
		
	}
	
}


