package com.android.contactslist;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;




public class UserFunction {
	
	private JSONParse jSon ;
	
	
	private static String search="http://minh1.comyr.com/new/search.php";
	private static String regis="http://minh1.comyr.com/new/insert.php";
	//Hàm xây dựng khởi tạo đối tượng
	public UserFunction(){
		jSon=new JSONParse();
	}
	
	public JSONObject loadtt(String diachi){
		//Xây dựng các giá trị
		List<NameValuePair> name=new ArrayList<NameValuePair>();
		name.add(new BasicNameValuePair("DiaChi", diachi));
		
		JSONObject json=jSon.getJSONFromUrl("http://minh1.comyr.com/new/information.php",name);
		return json;
	}
	public JSONObject search(String txtsaerch){
		//Xây dựng các giá trị
		List<NameValuePair> name=new ArrayList<NameValuePair>();
		name.add(new BasicNameValuePair("search",txtsaerch));			
		JSONObject json = jSon.getJSONFromUrl(search,name);
		//Trả về đối tượng là 1 JSONObject
		return json;
	}
	public JSONObject register(String tk,String mk,String lmk,String tenht){
		//Xây dựng các giá trị
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("TK",tk));	
		params.add(new BasicNameValuePair("MK",mk));
		params.add(new BasicNameValuePair("LMK",lmk));
		params.add(new BasicNameValuePair("TenHT",tenht));
		JSONObject json = jSon.getJSONFromUrl(regis,params);
		//Trả về đối tượng là 1 JSONObject
		return json;
	}
}