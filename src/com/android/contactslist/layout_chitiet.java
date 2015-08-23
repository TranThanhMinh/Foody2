package com.android.contactslist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class layout_chitiet extends Activity {
		
		String[] spin;
		EditText txtten,txtdiachi,txtsdt,txtemail;
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.layout_chitiet);
			txtten=(EditText) findViewById(R.id.edittenKH);
			txtsdt=(EditText) findViewById(R.id.editSDT);
			txtdiachi=(EditText) findViewById(R.id.editDIACHI);
			txtemail=(EditText) findViewById(R.id.editMAIL);
		
				Intent i=getIntent();
				Bundle b= i.getExtras();
				String ten=b.getString("TenKH");
				String sdt=b.getString("SDT");
				String diachi=b.getString("DiaChi");
				String mail=b.getString("Email");
				txtten.setText(ten);
				txtsdt.setText(sdt);
				txtemail.setText(mail);
				txtdiachi.setText(diachi);
				spin=new String[2];			 
				spin[0]="   nam";
				spin[1]="   nu";
//		        array_spinner[2]="option 3";
//		        array_spinner[3]="option 4";
//		        array_spinner[4]="option 5
		        Spinner s = (Spinner) findViewById(R.id.spingioitinh);
		        ArrayAdapter adapter = new ArrayAdapter(this,
		        android.R.layout.simple_spinner_item,spin);
		        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
		        s.setAdapter(adapter);
		}
}
