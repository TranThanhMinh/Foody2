package com.android.contactslist;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class search extends Activity{
	EditText txtsearch;
	ImageButton search;
	String url="http://minh1.comyr.com/new/search.php";
	ArrayList<Quan> apdater;
	Arrayapdater ARRAY;
	
	ListView listview;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
	
		listview=(ListView) findViewById(R.id.listsearch);
		txtsearch=(EditText) findViewById(R.id.txtsearch);
		 listview.setTextFilterEnabled(true);
		 listview.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					Intent i=new Intent(search.this, informationfd.class);
					Quan quan=ARRAY.getItem(position);
					
					String idquan=quan.getIdquan().toString();
					String tenquan=quan.getTenquan().toString();
					String sdt=quan.getSdt().toString();
					String im=quan.getImage().toString();
					String tien=quan.getTien().toString();
					String diachi=quan.getDiachi().toString();
					String datcho=quan.getDatCho().toString();
					String open=quan.getTimeopen().toString();
					String close=quan.getTimeclose().toString();
					Log.e("",""+idquan);
					Bundle b=new Bundle();
					Quan employ=new Quan(idquan, tenquan, sdt, im, tien, diachi,datcho, open, close);				
					b.putSerializable("IdQuan", employ);

					i.putExtras(b); 		
					startActivity(i);
				
//					LinearLayout f=(LinearLayout) findViewById(R.id.listfoody1);
//					
//					 informationall m=new informationall(getApplication(),im,tenquan,diachi,sdt,tien,open,close);
//			         f.addView(m);
				}
			});
		txtsearch.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				listview.setAdapter(null);
				new JSONPaser().execute();
				
				
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public class JSONPaser extends AsyncTask<String, String,String>{

		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			
			
			
			super.onPostExecute(result);
			ARRAY =new Arrayapdater(search.this,R.layout.item,apdater); 
			listview.setAdapter(ARRAY);
		}
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			List<NameValuePair> array=new ArrayList<NameValuePair>();
			String tim=txtsearch.getText().toString();
			array.add(new BasicNameValuePair("search",tim));
			Log.e("", "d: "+tim);
			JSONParse js=new JSONParse();
			JSONObject json=js.getJSONFromUrl(url, array);
			JSONArray jsonarray;
			apdater=new ArrayList<Quan>();
			try {
				jsonarray=json.getJSONArray("result");	
				
				for(int i=0;i<jsonarray.length();i++){
					
					JSONObject j=jsonarray.getJSONObject(i);
					Log.e("",""+jsonarray);
					Quan quan=new Quan();
					quan.setIdquan(j.getString("IdQuan"));
					quan.setTenquan(j.getString("TenQuan"));
					quan.setSdt(j.getString("SDT"));
					quan.setImage(j.getString("Image"));
					quan.setTien(j.getString("GiaCa"));	
					quan.setDiachi(j.getString("DiaChi"));
					quan.setDatCho(j.getString("DatCho"));
					quan.setTimeopen(j.getString("TimeOpen"));
					quan.setTimeclose(j.getString("TimeClose"));
					apdater.add(quan);
					
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
}
