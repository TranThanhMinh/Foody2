package com.android.contactslist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class listfoody extends Activity{
	ListView listview;
	String url="http://minh1.comyr.com/new/loadQuan.php";
	static JSONArray array =null;
	ImageView im;
	ArrayList<HashMap<String, String>> haspmap=new ArrayList<HashMap<String,String>>();
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listfoody);
		listview =(ListView) findViewById(R.id.listfoody);
		im =(ImageView) findViewById(R.id.httenquan);
		new JSONPares().execute();
		
	}
	public class JSONPares extends AsyncTask<String, String, JSONObject>{
		protected void onPreExecute() {
          super.onPreExecute();
       
     }
		@Override
		protected JSONObject doInBackground(String... params) {
			// TODO Auto-generated method stub
			List<NameValuePair> name=new ArrayList<NameValuePair>();
			jSon js=new jSon();
			JSONObject result=js.getJSONFromUrl(url, "GET", name);
			return result;
		}
		protected void onPostExecute(JSONObject result){
			super.onPostExecute(result);
			 JSONArray newitem;
			try {
				newitem=result.getJSONArray("result");
				for(int i=0;i<newitem.length();i++){
					JSONObject c=newitem.getJSONObject(i);
					String Image=c.getString("Image");
					String TenQuan=c.getString("TenQuan");
					String DiaChi=c.getString("DiaChi");
					  HashMap<String, String> map = new HashMap<String, String>();
	                 map.put("Image", Image);
		                 map.put("TenQuan", TenQuan);
		                 map.put("DiaChi", DiaChi);
		                 haspmap.add(map);
		                 
		                    ListAdapter adapter = new SimpleAdapter(listfoody.this, haspmap,
		                            R.layout.item,
		                            new String[] { "Image"}, new int[] {
		                            R.id.httenquan});
		                   listview.setAdapter(adapter);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
