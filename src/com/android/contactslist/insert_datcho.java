package com.android.contactslist;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

@SuppressLint("NewApi")
public class insert_datcho extends Activity{
	String url="http://minh1.comyr.com/new/insertDatcho.php";
	 private int day;
	 private int month;
	 private int year;
	 private int hour;
	 private int min;
	 private Calendar cal;
	 private int thoigian=0;
	 private int ngaythang=1;
	 private String array_spinner[],array_spinner1[];
	 String ngay;
	 String gio;
	 Button btndatcho;
	 String idquan;
	 String SoNL,SoTre;
	EditText txttenkh,txtsdt,txtemail,txtngay,txtgio;
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			StrictMode.ThreadPolicy poly=new StrictMode.ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(poly);
			super.onCreate(savedInstanceState);
			setContentView(R.layout.insert_datcho);
			btndatcho=(Button) findViewById(R.id.btn_insertdat);
			txttenkh=(EditText) findViewById(R.id.txttenkh);
			txtsdt=(EditText) findViewById(R.id.txtsdt);
			txtemail=(EditText) findViewById(R.id.txtemail);
			txtngay=(EditText) findViewById(R.id.editngay1);
			txtgio=(EditText) findViewById(R.id.editgio1);
			Intent i=getIntent();
			Bundle b=i.getExtras();
			String ten=b.getString("TenKH");
			String sdt=b.getString("SDT");
			String email=b.getString("Email");
			ngay=b.getString("Date");
			gio=b.getString("Time");
			idquan=b.getString("IdQuan");
			final String taikhoan=b.getString("TaiKhoan");
			txttenkh.setText(ten);
			txtsdt.setText(sdt);
			txtemail.setText(email);
			txtngay.setText(ngay);
			txtgio.setText(gio);
			Log.e("",""+ten);
			
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
//		        array_spinner[0]="option 1";
//		        array_spinner[1]="option 2";
//		        array_spinner[2]="option 3";
//		        array_spinner[3]="option 4";
//		        array_spinner[4]="option 5";
		        EditText snl=(EditText) findViewById(R.id.editsnl);
		        snl.setText("          người lớn");
		       final Spinner s = (Spinner) findViewById(R.id.spinner3);
		        ArrayAdapter adapter = new ArrayAdapter(this,
		        android.R.layout.simple_spinner_item, array_spinner);
		        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
		        s.setAdapter(adapter);
		        s.setOnItemSelectedListener(new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
						// TODO Auto-generated method stub
						SoNL=arg0.getItemAtPosition(arg2)+"";
						Toast.makeText(getApplicationContext(), SoNL, Toast.LENGTH_LONG).show();
					}

					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}
				});
		        //so tre em
		        array_spinner=new String[50];
				  for(int j=0;j<50;j++){
					  array_spinner[j]=j+" ";
				  }
//			        array_spinner[0]="option 1";
//			        array_spinner[1]="option 2";
//			        array_spinner[2]="option 3";
//			        array_spinner[3]="option 4";
//			        array_spinner[4]="option 5";
			        EditText ste=(EditText) findViewById(R.id.editsotre);
			        ste.setText("          trẻ em");
			       Spinner s1 = (Spinner) findViewById(R.id.spinner4);
			        ArrayAdapter adapter1 = new ArrayAdapter(this,
			        android.R.layout.simple_spinner_item, array_spinner);
			        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_1);
			        s1.setAdapter(adapter1);
			        s1.setOnItemSelectedListener(new OnItemSelectedListener() {

						public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
							// TODO Auto-generated method stub
							SoTre=arg0.getItemAtPosition(arg2)+"";
							Toast.makeText(getApplicationContext(), SoTre, Toast.LENGTH_LONG).show();
						}

						public void onNothingSelected(AdapterView<?> arg0) {
							// TODO Auto-generated method stub
							
						}
					});
			  OnClickListener v=new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(v==txtngay){
						showDialog(ngaythang);
					}
					if(v==txtgio){
						showDialog(thoigian);
					}
					
					if(v==btndatcho){
						List<NameValuePair> params=new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("IdQuan",idquan));
						params.add(new BasicNameValuePair("TaiKhoan",taikhoan));
						params.add(new BasicNameValuePair("Ngay",ngay));
						params.add(new BasicNameValuePair("Gio",gio));
						params.add(new BasicNameValuePair("SoNL",SoNL));
						params.add(new BasicNameValuePair("SoTre",SoTre));
						
						jSon json=new jSon();
						JSONObject ob=json.getJSONFromUrl(url,"POST", params);
						Toast.makeText(getApplicationContext(),"Thanh Cong", Toast.LENGTH_LONG).show();
						Log.e("",""+gio);
					}
				}
			};
			
			btndatcho.setOnClickListener(v);
			txtngay.setOnClickListener(v);
			txtgio.setOnClickListener(v);
		}
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
			
			public void onDateSet(DatePicker arg0, int nam, int thang, int ngay1) {
				// TODO Auto-generated method stub
				ngay="    "+ngay1 +"-"+(thang+1)+"-"+nam;
				txtngay.setText(ngay);
				
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
			   gio="     "+hour + " : " + minute + " " + am_pm;
			   txtgio.setText(gio);
			  }

			 };
}
