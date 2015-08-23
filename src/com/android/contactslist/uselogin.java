package com.android.contactslist;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.app.TabActivity;
import android.widget.TabHost.OnTabChangeListener;
 
public class uselogin extends TabActivity implements OnTabChangeListener{
 
    /** Called when the activity is first created. */
      TabHost tabHost;
      Spinner spin,spin1;
      ArrayList<Quan> apdater;
      Arrayapdater array1;
      Intent intent;
      int ht;
      @Override
      public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.uselogin);
          spin=(Spinner) findViewById(R.id.spiner);
     	ArrayAdapter<CharSequence> ar=ArrayAdapter.createFromResource(this,R.array.foody,android.R.layout.simple_list_item_1);
      	ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
      	spin.setAdapter(ar);
      	spin1=(Spinner) findViewById(R.id.spiner1);
      	ArrayAdapter<CharSequence> arr=ArrayAdapter.createFromResource(this,R.array.foody,android.R.layout.simple_list_item_1);
      	arr.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
      	spin1.setAdapter(arr);
      	Intent i=getIntent();
        Bundle b=i.getExtras();
       ht=b.getInt("tk");
      String htt=b.getString("ht");
        
          // Get TabHost Refference
          tabHost = getTabHost();
           
          // Set TabChangeListener called when tab changed
          tabHost.setOnTabChangedListener(this);
       
          TabHost.TabSpec spec;
         
     
           /************* TAB1 ************/
          // Create  Intents to launch an Activity for the tab (to be reused)
          intent = new Intent().setClass(this,FooDyView.class);
          spec = tabHost.newTabSpec("First").setIndicator("")
                        .setContent(intent);
		         
		     
		  
          //Add intent to tab
          tabHost.addTab(spec);
     
          /************* TAB2 ************/
          intent = new Intent().setClass(this, listdatcho.class);
          spec = tabHost.newTabSpec("Second").setIndicator("")
                        .setContent(intent);  
          Bundle b1=new Bundle();
        	
			b1.putInt("im", ht);
			b1.putString("ht", htt);
			intent.putExtras(b1);
          tabHost.addTab(spec);
     
          /************* TAB3 ************/
          intent = new Intent().setClass(this, search.class);
          spec = tabHost.newTabSpec("Third").setIndicator("")
                        .setContent(intent);
          tabHost.addTab(spec);
          /************* TAB4 ************/
          
          intent = new Intent().setClass(this,loginfd.class);
          spec = tabHost.newTabSpec("Third").setIndicator("")
                        .setContent(intent);
          tabHost.addTab(spec);
          /************* TAB5 ************/
          intent = new Intent().setClass(this, listdatcho.class);
         
          
          spec = tabHost.newTabSpec("Third").setIndicator("")
                        .setContent(intent);
          tabHost.addTab(spec);
          /************* TAB6 ************/
          intent = new Intent().setClass(this, informationUse.class);
          Bundle bb=new Bundle();
      	
			bb.putInt("im", ht);
			bb.putString("ht", htt);
			intent.putExtras(bb);
			
          spec = tabHost.newTabSpec("Third").setIndicator("")
                        .setContent(intent);
          tabHost.addTab(spec);
          // Set drawable images to tab
         
          tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.foody);
          tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.ecart);
          tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.tim);  
          tabHost.getTabWidget().getChildAt(3).setBackgroundResource(R.drawable.thongbao); 
          tabHost.getTabWidget().getChildAt(4).setBackgroundResource(R.drawable.mune);  
          tabHost.getTabWidget().getChildAt(5).setBackgroundResource(ht);   
       
          
     
       }
 
    public void onTabChanged(String tabId) {
         
        /************ Called when tab changed *************/
         
        //********* Check current selected tab and change according images *******/
         
        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            if(i==0)
            {
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.foody);
            }
            else if(i==1)
            {
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.ecart);
            }
            else if(i==2){
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tim);
            }
            else if(i==3){
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.thongbao);
            }
            else if(i==4){
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.mune);
                Log.e("tabs", "minh");
            }
            else if(i==5){
            	tabHost.getTabWidget().getChildAt(i).setBackgroundResource(ht);
            	
            	
            }
   
        }
         
         
        
         
   
    }
 
 
}