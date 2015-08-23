package com.android.contactslist;

import java.util.List;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Arrayapdater extends ArrayAdapter<gmail> {
	int resource;
	List<gmail> list;
	Context c;
	public Arrayapdater(Context context, int resource, List<gmail> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.resource =resource;
		this.c =  context;	
		this.list = objects;
				}
	public View getView(int post,View convertView,ViewGroup gruop){

	 View row=convertView;
		gmail data=getItem(post);
	
			LayoutInflater layout=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row=layout.inflate(this.resource, null);
		TextView stt=(TextView) row.findViewById(R.id.htstt);
		TextView ten=(TextView) row.findViewById(R.id.htname);
		
		stt.setText(data.getMail());
		ten.setText(data.getPass());
		
		return row;
		
	}

}


