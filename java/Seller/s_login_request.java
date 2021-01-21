package com.example.fd1.Seller;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class s_login_request extends StringRequest {
    //서버 URL설정(php파일 연동)
    final static private String URL ="http://foodelicious.dothome.co.kr/s_login.php";
    private Map<String,String> map;


    public s_login_request(String s_id, String s_pw, Response.Listener<String> listener) {
        super(Request.Method.POST,URL,listener,null);

        map = new HashMap<>();
        map.put("s_id",s_id);
        map.put("s_pw",s_pw);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
