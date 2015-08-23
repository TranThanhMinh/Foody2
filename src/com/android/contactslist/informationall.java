package com.android.contactslist;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class informationall extends LinearLayout{

	public informationall(Context context,String im,String tenquan1,String diachi1,String sdt1,String tien1,String open,String close) {
        super(context);
        init(im,tenquan1,diachi1,sdt1,tien1,open,close);
    }

    public informationall(Context context, AttributeSet attrs,String im,String tenquan1,String diachi1,String sdt1,String tien1,String open,String close) {
        super(context, attrs);
        init(im,tenquan1,diachi1,sdt1,tien1,open,close);
    }

    @SuppressLint("NewApi")
	public informationall(Context context, AttributeSet attrs, int defStyle,String im,String tenquan1,String diachi1,String sdt1,String tien1,String open,String close) {
        super(context, attrs, defStyle);
        init(im,tenquan1,diachi1,sdt1,tien1,open,close);
    }

    private void init(String im,String tenquan1,final String diachi1,String sdt1,String tien1,String open,String close) {
    	TextView tenquan,diachi,sdt,tien,gio;
    	int loader=R.drawable.foody;
    	ImageView loadmap,image;
        inflate(getContext(), R.layout.informationfd, this);
        image=(ImageView) findViewById(R.id.imView);
		loadmap=(ImageView) findViewById(R.id.maphello);
		tenquan=(TextView) findViewById(R.id.txtten);
		diachi=(TextView) findViewById(R.id.txtdiachi);
		sdt=(TextView) findViewById(R.id.txtsdt);
		tien=(TextView) findViewById(R.id.txttien);
		gio=(TextView) findViewById(R.id.txtgio);	
		ImageLoader im1=new ImageLoader(getContext());
		im1.DisplayImage(im,loader,image);
		tenquan.setText(tenquan1);
		diachi.setText(diachi1);
		sdt.setText(sdt1);		
		tien.setText(tien1);
		gio.setText(open+" - "+ close);
    }
}
