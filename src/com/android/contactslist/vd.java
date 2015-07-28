//package com.android.contactslist;
//
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import org.apache.http.NameValuePair;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import android.R.color;
//import android.app.Activity;
//import android.app.TabActivity;
//import android.content.Intent;
//import android.database.Cursor;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Color;
//import android.net.Uri;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationUtils;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//import android.widget.Spinner;
//import android.widget.TabHost;
//
//public class  vd extends TabActivity implements AnimationListener {
//	private Spinner spin,spin1;
//	TabHost tabhost;
//	ArrayList<HashMap<String, String>> oslist=new ArrayList<HashMap<String,String>>();
//	String url="http://minh1.comyr.com/new/getall.php";
//	EditText txtmail,txtpass,txtlink;
//	Button btntim;
//	ImageView btnchon;
//	jSon jso;
//	private String imagepath=null;
//	static JSONArray array=null;
//	  static ArrayList<gmail> gmailList;
//	  ListView list;
//	  LinearLayout l2,laymap;
//	  Animation animFadein;
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		tabhost=getTabHost();
//		TabHost.TabSpec spec;
//		Intent intent=new Intent().setClass(this,map.class);
//		   spec = tabhost.newTabSpec("First").setIndicator("")
//                   .setContent(intent);
//      
//     //Add intent to tab
//     tabhost.addTab(spec);
//     tabhost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.tim);
//	spin=(Spinner) findViewById(R.id.spiner);
//	
//	txtmail=(EditText) findViewById(R.id.editmail);
//	txtpass=(EditText) findViewById(R.id.editpass);
//	txtlink=(EditText) findViewById(R.id.editlink);
//	btntim=(Button) findViewById(R.id.btntim);
//	btnchon=(ImageView) findViewById(R.id.btnload);
//	 oslist=new ArrayList<HashMap<String,String>>();
//	 list = (ListView) findViewById(R.id.listView);
//	 l2=(LinearLayout) findViewById(R.id.l2);
//	 l2=(LinearLayout) findViewById(R.id.laymap);
//	 animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
//             R.layout.map);
//      
//     // set animation listener
//     animFadein.setAnimationListener(this);
//	
//	
//	ArrayAdapter<CharSequence> ar=ArrayAdapter.createFromResource(this,R.array.foody,android.R.layout.simple_list_item_1);
//	ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//	spin.setAdapter(ar);
//	spin1=(Spinner) findViewById(R.id.spiner1);
//	ArrayAdapter<CharSequence> arr=ArrayAdapter.createFromResource(this,R.array.foody,android.R.layout.simple_list_item_1);
//	arr.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//	spin1.setAdapter(arr);
//	}
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		// TODO Auto-generated method stub
//		super.onActivityResult(requestCode, resultCode, data);
//		
//		if (resultCode == RESULT_OK){
//
//            Uri selectedImageUri = data.getData();
//            imagepath = getPath(selectedImageUri);
//            Bitmap bitmap=BitmapFactory.decodeFile(imagepath);
//            btnchon.setImageBitmap(bitmap);
//            txtlink.setText("Uploading file path:" +imagepath);
//		}
//	}
//	  public String getPath(Uri uri) {
//          String[] projection = { MediaStore.Images.Media.DATA };
//          Cursor cursor = managedQuery(uri, projection, null, null, null);
//          int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//          cursor.moveToFirst();
//          return cursor.getString(column_index);
//      }
//	 private class JSONParse extends AsyncTask<String, String, JSONObject> {
//		  @Override
//          protected void onPreExecute() {
//              super.onPreExecute();
//            
//          }
//		@Override
//		protected JSONObject doInBackground(String... params) {
//			List<NameValuePair> na=new ArrayList<NameValuePair>()	;
//             jso=new jSon();
//            JSONObject result= jso.getJSONFromUrl(url,"GET",na);
//    
//			return result;
//		}
//		 @SuppressWarnings("unused")
//		protected void onPostExecute(JSONObject result) {
//             super.onPostExecute(result);
//        
//                // Getting JSON Array from URL
//          
//             JSONArray newitem;
//			try {
//				newitem = result.getJSONArray("result");
//				  for(int i = 0; i < newitem.length(); i++){
//		                 JSONObject c = newitem.getJSONObject(i);
//		                 String name = c.getString("mail");
//		                 String description = c.getString("pass");
//		               
//		                 Log.i("...............",name);
//		                 HashMap<String, String> map = new HashMap<String, String>();
//		                 map.put("mail", name);
//		                 map.put("pass", description);
//		                
//		                 oslist.add(map);
//		                    list=(ListView)findViewById(R.id.listView);
//		                    ListAdapter adapter = new SimpleAdapter(vd.this, oslist,
//		                            R.layout.item,
//		                            new String[] { "mail","pass"}, new int[] {
//		                            R.id.htstt,R.id.htname});
//		                    list.setAdapter(adapter);
//		                
//		            
//		                }
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//           
//		 }
//	 
//	
//}
//	public void onAnimationStart(Animation animation) {
//		// TODO Auto-generated method stub
//		
//	}
//	public void onAnimationEnd(Animation animation) {
//		// TODO Auto-generated method stub
//		
//	}
//	public void onAnimationRepeat(Animation animation) {
//		// TODO Auto-generated method stub
//		
//	}
