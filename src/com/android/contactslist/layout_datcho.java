package com.android.contactslist;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class layout_datcho extends Activity{
	
	TextView tenquan,diachi,sdt,tien,gio;
	ImageView loadmap,image,imngay;
	int loader=R.drawable.foody;
	Button btndat;
	EditText date,time;
	String tk;
	String TenKH,TaiKhoan,MatKhau,Email,GioiTinh,SDT,DiaChi;
	 private int day;
	 private int month;
	 private int year;
	 private int hour;
	 private int min;
	 private Calendar cal;
	 private int thoigian=0;
	 private int ngaythang=1;
	 private String array_spinner[],array_spinner1[];
	 String ngay1,gio1;
	 String idq;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_datcho);
		ImageLoader im=new ImageLoader(getApplicationContext());
		Quan quan= (Quan)getIntent().getSerializableExtra("IdQuan");
		btndat=(Button) findViewById(R.id.btndatcho);
		  Intent i=getIntent();
	        Bundle b=i.getExtras();
	         tk=b.getString("ht");
	         new insert().execute();
	        date=(EditText) findViewById(R.id.editngay);
	        time=(EditText) findViewById(R.id.editgio);
			image=(ImageView) findViewById(R.id.imView1);
			loadmap=(ImageView) findViewById(R.id.maphello1);
			imngay=(ImageView) findViewById(R.id.imngay);
			tenquan=(TextView) findViewById(R.id.txtten1);
			diachi=(TextView) findViewById(R.id.txtdiachi1);
			sdt=(TextView) findViewById(R.id.txtsdt1);
			tien=(TextView) findViewById(R.id.txttien1);
			gio=(TextView) findViewById(R.id.txtgio1);		
			final Quan e=(Quan) getIntent().getSerializableExtra("IdQuan");
			im.DisplayImage(e.getImage(), loader, image);
			idq=e.getIdquan();
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
		btndat.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(tk.equals("nologin")){
					Intent i=new Intent(layout_datcho.this,LoginFoody.class);
					startActivity(i);
				}
				else{
					
					Intent i=new Intent(layout_datcho.this,insert_datcho.class);
					Bundle b=new Bundle();
					b.putString("TenKH",TenKH);
					b.putString("SDT",SDT);
					b.putString("Email",Email);
					b.putString("Date",ngay1);
					b.putString("Time",gio1);
					b.putString("IdQuan",idq);
					b.putString("TaiKhoan",TaiKhoan);
					i.putExtras(b);
					startActivity(i);
				}
			}
		});
		cal = Calendar.getInstance();
		 day = cal.get(Calendar.DAY_OF_MONTH);
		  month = cal.get(Calendar.MONTH);
		  year = cal.get(Calendar.YEAR);
		  hour=cal.get(cal.HOUR_OF_DAY);
		  min=cal.get(cal.MINUTE);
		  //so nguoi lon
		  array_spinner=new String[50];
		  for(int j=0;j<50;j++){
			  array_spinner[j]=j+" ";
		  }
//	        array_spinner[0]="option 1";
//	        array_spinner[1]="option 2";
//	        array_spinner[2]="option 3";
//	        array_spinner[3]="option 4";
//	        array_spinner[4]="option 5";
	        EditText snl=(EditText) findViewById(R.id.editsnl);
	        snl.setText("          người lớn");
	       Spinner s = (Spinner) findViewById(R.id.spinner1);
	        ArrayAdapter adapter = new ArrayAdapter(this,
	        android.R.layout.simple_spinner_item, array_spinner);
	        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
	        s.setAdapter(adapter);
	        //so tre em
	        array_spinner=new String[50];
			  for(int j=0;j<50;j++){
				  array_spinner[j]=j+" ";
			  }
//		        array_spinner[0]="option 1";
//		        array_spinner[1]="option 2";
//		        array_spinner[2]="option 3";
//		        array_spinner[3]="option 4";
//		        array_spinner[4]="option 5";
		        EditText ste=(EditText) findViewById(R.id.editsotre);
		        ste.setText("          trẻ em");
		       Spinner s1 = (Spinner) findViewById(R.id.spinner2);
		        ArrayAdapter adapter1 = new ArrayAdapter(this,
		        android.R.layout.simple_spinner_item, array_spinner);
		        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_1);
		        s1.setAdapter(adapter1);
		  OnClickListener v=new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v==date){
					showDialog(ngaythang);
				}
				if(v==time){
					showDialog(thoigian);
				}
			}
		};
		  date.setOnClickListener(v);
		  time.setOnClickListener(v);
	}
		@Override
		protected Dialog onCreateDialog(int id) {
			// TODO Auto-generated method stub
			if(id==ngaythang){
			return new DatePickerDialog(this, datePickerDialog, year, month, day);
			}
			if(id==thoigian){
			return new TimePickerDialog(this, timePickerListener, hour, min,false);
			}
			return null;
		}
		
		
		private DatePickerDialog.OnDateSetListener datePickerDialog=new OnDateSetListener() {
			
			public void onDateSet(DatePicker arg0, int nam, int thang, int ngay) {
				// TODO Auto-generated method stub
				ngay1="    "+ngay +"-"+(thang+1)+"-"+nam;
				date.setText(ngay1);
				
			}
		};
		 private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
			  public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			   int hour;
			   String am_pm;
			   if (hourOfDay > 12) {
			    hour = hourOfDay - 12;
			    am_pm = "PM";
			   } else {
			    hour = hourOfDay;
			    am_pm = "AM";
			   }
			   gio1="     "+hour + " : " + minute + " " + am_pm;
			   time.setText(gio1);
			  }

			 };
			 class insert extends AsyncTask<String , String, String>{
				 String url="http://minh1.comyr.com/new/kiemtrathongtin.php";

				protected String doInBackground(String... params) {
					// TODO Auto-generated method stub
					List<NameValuePair> name=new ArrayList<NameValuePair>();
					name.add(new BasicNameValuePair("TaiKhoan", tk));
					jSon js=new jSon();
					JSONObject json=js.getJSONFromUrl(url,"POST", name);
					try {
						JSONArray jsonarray=json.getJSONArray("result");
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
				 @Override
				protected void onPostExecute(String result) {
					// TODO Auto-generated method stub
					super.onPostExecute(result);
				}
				@Override
				protected void onPreExecute() {
					// TODO Auto-generated method stub
					super.onPreExecute();
				}
			 }
}
