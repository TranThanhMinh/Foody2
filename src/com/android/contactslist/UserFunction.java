package com.android.contactslist;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;




public class UserFunction {
	
	private jSon jsonParse;
	
	private static String registerURL = "http://minh1.comyr.com/new/ketnoi.php";//private static String registerURL = "http://10.0.2.2/android_login_api/";

	
	//Hàm xây dựng khởi tạo đối tượng
	public UserFunction(){
		jsonParse = new jSon();
	}
	
	public JSONObject registerUser(String email, String password){
		//Xây dựng các giá trị
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email",email));
		params.add(new BasicNameValuePair("password",password));
			
		JSONObject json = jsonParse.getJSONFromUrl(registerURL,"POST",params);
		//Trả về đối tượng là 1 JSONObject
		return json;
	}
	
}