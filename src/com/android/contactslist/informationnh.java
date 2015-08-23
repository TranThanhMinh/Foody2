package com.android.contactslist;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class informationnh extends LinearLayout{

	public informationnh(Context context,String ten,String ho) {
        super(context);
        init(ten,ho);
    }

    public informationnh(Context context, AttributeSet attrs,String ten,String ho) {
        super(context, attrs);
        init(ten,ho);
    }

    @SuppressLint("NewApi")
	public informationnh(Context context, AttributeSet attrs, int defStyle,String ten,String ho) {
        super(context, attrs, defStyle);
        init(ten,ho);
    }

    private void init(String ten,String ho) {
        inflate(getContext(), R.layout.layout_datcho, this);
        
    
    }
}
