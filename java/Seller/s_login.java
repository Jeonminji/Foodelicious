package com.example.fd1.Seller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.fd1.Page.MainActivity2;
import com.example.fd1.R;

import org.json.JSONException;
import org.json.JSONObject;

public class s_login extends AppCompatActivity {

    private EditText s_lo_id, s_lo_pw;
    private Button s_login, s_lo_re_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_login);


        s_lo_id = findViewById(R.id.s_lo_id);
        s_lo_pw = findViewById(R.id.s_lo_pw);
        s_login = findViewById(R.id.s_login);
        s_lo_re_button = findViewById(R.id.s_lo_re_button);

        //판매자 회원가입 화면으로 전환
        s_lo_re_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), s_register.class);
                startActivity(intent);
            }
        });

        s_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //현재 입력되어 있는 값을 get함
                final String s_id = s_lo_id.getText().toString();
                String s_pw = s_lo_pw.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //json오브젝트를 활용하여 회원가입 요청
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            //로그인 성공했을 경우 성공이라고 toast
                            if(success){
                                String s_id = jsonObject.getString("s_id");
                                String s_pw = jsonObject.getString("s_pw");
                                Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(s_login.this, MainActivity2.class);
                                intent.putExtra("c_id",s_id);
                                intent.putExtra("c_pw",s_pw);
                                startActivity(intent);

                            }
                            //실패했을 경우
                            else{
                                Toast.makeText(getApplicationContext(),"로그인 실패",Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                s_login_request s_login_request = new s_login_request(s_id, s_pw,responseListener);
                RequestQueue queue = Volley.newRequestQueue(s_login.this);
                queue.add(s_login_request);


            }
        });
    }
}