package com.android.contactslist;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.android.contactslist.layout_datcho.insert;

import android.app.Activity;
import android.content.Entity.NamedContentValues;
import android.content.Intent;
import android.graphics.Paint.Join;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class layout_thongtin extends Activity{
		String TenKH,TaiKhoan,MatKhau,Email,GioiTinh,SDT,DiaChi;
		String ht;
		Button btndoi,btntt;
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.layout_thongtin);
			btndoi=(Button) findViewById(R.id.btnchangepass);
			btntt=(Button) findViewById(R.id.btnthongtin);
			Intent i=getIntent();
			Bundle b=i.getExtras();
			ht=b.getString("ht");
			new listthongtin().execute();
			OnClickListener v=new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(v==btndoi){
						Intent i=new Intent(layout_thongtin.this,changepassword.class);
						startActivity(i);
					}
					if(v==btntt){
						Intent i=new Intent(layout_thongtin.this,layout_chitiet.class);
						Bundle b=new Bundle();
						b.putString("TenKH",TenKH);
						b.putString("SDT",SDT);
						b.putString("Email",Email);						
						b.putString("DiaChi",DiaChi);
						i.putExtras(b);
						startActivity(i);
					}
				}
			};
			btndoi.setOnClickListener(v);
			btntt.setOnClickListener(v);
		}
		class listthongtin extends AsyncTask<String, String, String>{

			@Override
			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub
				List<NameValuePair> name=new ArrayList<NameValuePair>();
				name.add(new BasicNameValuePair("TaiKhoan", ht));
				jSon json=new jSon();
				JSONObject obj=json.getJSONFromUrl("http://minh1.comyr.com/new/kiemtrathongtin.php","POST", name);
				try {
					JSONArray jsonarray=obj.getJSONArray("result");
					for(int i=0;i<jsonarray.length();i++){
						JSONObject ob=jsonarray.getJSONObject(i);
											
						TenKH=ob.getString("TenKH");
						TaiKhoan=ob.getString("TaiKhoan");
						MatKhau=ob.getString("MatKhau");
						Email=ob.getString("Email");
						GioiTinh=ob.getString("GioiTinh");
						SDT=ob.getString("SDT");
						DiaChi=ob.getString("DiaChi");
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			}
			
		}
}
