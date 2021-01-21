package com.example.fd1.Consumer;

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
import com.example.fd1.Page.MainActivity;
import com.example.fd1.R;

import org.json.JSONException;
import org.json.JSONObject;

public class c_login extends AppCompatActivity {

    private EditText c_lo_id, c_lo_pw;
    private Button c_login, c_lo_re_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_login);

        c_lo_id = findViewById(R.id.c_lo_id);
        c_lo_pw = findViewById(R.id.c_lo_pw);
        c_login = findViewById(R.id.c_login);
        c_lo_re_button = findViewById(R.id.c_lo_re_button);


        //회원가입 버튼 클릭 시 소비자 회원가입 화면으로 전환
        c_lo_re_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c_login.this, c_register.class);
                startActivity(intent);
            }
        });

        c_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //현재 입력되어 있는 값을 get함
                final String c_id = c_lo_id.getText().toString();
                String c_pw = c_lo_pw.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //json오브젝트를 활용하여 회원가입 요청
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            //로그인 성공했을 경우 성공이라고 toast
                            if(success){
                                String c_id = jsonObject.getString("c_id");
                                String c_pw = jsonObject.getString("c_pw");
                                String c_name = jsonObject.getString("c_name");
                                String c_phone = jsonObject.getString("c_phone");
                                Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(c_login.this, MainActivity.class);
                                intent.putExtra("c_id",c_id);
                                intent.putExtra("c_pw",c_pw);
                                intent.putExtra("c_name",c_name);
                                intent.putExtra("c_phone",c_phone);
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
                c_login_request c_login_request = new c_login_request(c_id, c_pw,responseListener);
                RequestQueue queue = Volley.newRequestQueue(c_login.this);
                queue.add(c_login_request);


            }
        });
    }
}