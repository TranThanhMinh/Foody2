package com.android.contactslist;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Apdapterinformation extends ArrayAdapter<String> {
	int postion;
	LayoutInflater layout;
	ArrayList<String> list;
	public Apdapterinformation(Context context, int textViewResourceId,
			ArrayList<String> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		this.postion=textViewResourceId;
		this.list=objects;
		layout=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v=convertView;
	
		TextView sdt=(TextView) v.findViewById(R.id.htspin);
		
	
	
		return v;
		
	}
}
