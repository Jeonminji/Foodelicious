package com.example.fd1.Consumer;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class c_register_request extends StringRequest {

    //서버 URL설정(php파일 연동)
    final static private String URL ="http://foodelicious.dothome.co.kr/c_register.php";
    private Map<String,String> map;


    public c_register_request(String c_id, String c_pw, String c_name, String c_phone,
                              Response.Listener<String> listener) {
        super(Method.POST,URL,listener,null);

        map = new HashMap<>();
        map.put("c_id",c_id);
        map.put("c_pw",c_pw);
        map.put("c_name",c_name);
        map.put("c_phone",c_phone);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
