package com.example.fd1.Seller;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class s_register_request extends StringRequest {

    //서버 URL설정(php파일 연동)
    final static private String URL ="http://foodelicious.dothome.co.kr/s_register.php";
    private Map<String,String> map;


    public s_register_request(String s_id, String s_pw, String s_name, String s_phone,
                              Response.Listener<String> listener) {
        super(Method.POST,URL,listener,null);

        map = new HashMap<>();
        map.put("s_id",s_id);
        map.put("s_pw",s_pw);
        map.put("s_name",s_name);
        map.put("s_phone",s_phone);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}