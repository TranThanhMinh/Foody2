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
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.app.Activity;
import android.app.ProgressDialog;
 
public class FooDyView extends Activity{
 
    /** Called when the activity is first created. */
    
	static ListView listview;
      ArrayList<Quan> apdater =new ArrayList<Quan>();
      Arrayapdater array1;
      String url="http://minh1.comyr.com/new/loadQuan.php";
      Button b;
      EditText tt;
      ProgressDialog mProgressDialog;
      @Override
      public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.listfoody);
         new JSONPaser().execute(url);
        b =(Button) findViewById(R.id.imageButton7);        
        listview=(ListView) findViewById(R.id.listfoody);
        
       
       
         listview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent i=new Intent(FooDyView.this, informationfd.class);
				Quan quan=array1.getItem(position);
				
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
			
//				LinearLayout f=(LinearLayout) findViewById(R.id.listfoody1);
//				
//				 informationall m=new informationall(getApplication(),im,tenquan,diachi,sdt,tien,open,close);
//		         f.addView(m);
			}
		});
          // Get TabHost Refference
      }   
         
 class JSONPaser extends AsyncTask<String, String, String>{

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		List<NameValuePair> name=new ArrayList<NameValuePair>();
		jSon js=new jSon();
		JSONObject json=js.getJSONFromUrl(url,"GET", name);
		try {
			JSONArray array=json.getJSONArray("result");
			for(int i=0;i<array.length();i++){
				JSONObject ob=array.getJSONObject(i);
				Log.e("",""+array);
				Quan quan=new Quan();
				quan.setIdquan(ob.getString("IdQuan"));
				quan.setTenquan(ob.getString("TenQuan"));
				quan.setSdt(ob.getString("SDT"));
				quan.setImage(ob.getString("Image"));	
				quan.setTien(ob.getString("GiaCa"));
				quan.setDiachi(ob.getString("DiaChi"));
				quan.setDatCho(ob.getString("DatCho"));
				quan.setTimeopen(ob.getString("TimeOpen"));
				quan.setTimeclose(ob.getString("TimeClose"));
				apdater.add(quan);
				
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 protected void onPostExecute(String result) {
		
		super.onPostExecute(result);
		array1 =new Arrayapdater(getApplicationContext(),R.layout.item,apdater); 
		listview.setAdapter(array1);
		mProgressDialog.dismiss();
	}
	 @Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		mProgressDialog = new ProgressDialog(FooDyView.this);
		// Set progressdialog title
		mProgressDialog.setTitle("Android JSON Parse Tutorial");
		// Set progressdialog message
		mProgressDialog.setMessage("Loading...");
		mProgressDialog.setIndeterminate(false);
		// Show progressdialog
		mProgressDialog.show();
	}
 }
 
}
