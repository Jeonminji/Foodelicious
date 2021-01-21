package com.example.fd1.Consumer;

import androidx.appcompat.app.AlertDialog;
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
import com.example.fd1.R;

import org.json.JSONException;
import org.json.JSONObject;

public class c_register extends AppCompatActivity {

    private EditText c_re_id, c_re_pw, c_re_name, c_re_phone;
    private Button c_re_button, c_check_button;
    private AlertDialog dialog;
    private boolean validate=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //액티비티 시작 시 처음으로 실행되는 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_register);

        //id값 찾아주기
        c_re_id = findViewById(R.id.c_re_id);
        c_re_pw = findViewById(R.id.c_re_pw);
        c_re_name = findViewById(R.id.c_re_name);
        c_re_phone = findViewById(R.id.c_re_phone);

        c_check_button = findViewById(R.id.c_check_button);


        //id중복체크
        c_check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c_id = c_re_id.getText().toString();
                if(validate){
                    return; //id중복체크 완료
                }
                if(c_id.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(c_register.this);
                    dialog=builder.setMessage("아이디는 빈 칸 일수 없습니다.")
                            .setPositiveButton("확인",null)
                            .create();
                    dialog.show();
                    return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder=new AlertDialog.Builder( c_register.this );
                                dialog=builder.setMessage("you can use ID")
                                        .setPositiveButton("OK",null)
                                        .create();
                                dialog.show();
                                c_re_id.setEnabled(false); //사용할 수 있는 아이디일 경우 아이디를 고정시킴
                                validate=true;
                                c_check_button.setText("OK");

                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(c_register.this);

                                dialog=builder.setMessage("already used ID")
                                        .setNegativeButton("OK",null)
                                        .create();
                                dialog.show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };

                c_double_check check = new c_double_check(c_id, responseListener);
                RequestQueue queue = Volley.newRequestQueue(c_register.this);
                queue.add(check);
            }
        });


        //회원가입 클릭 시 수행하는 것
        c_re_button = findViewById(R.id.c_re_button);
        c_re_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //현재 입력되어 있는 값을 get함
                String c_id = c_re_id.getText().toString();
                String c_pw = c_re_pw.getText().toString();
                String c_name = c_re_name.getText().toString();
                String c_phone = c_re_phone.getText().toString();

                if(!validate){
                    AlertDialog.Builder builder = new AlertDialog.Builder(c_register.this);
                    dialog = builder.setMessage("First check ID")
                            .setNegativeButton("OK",null)
                            .create();
                    dialog.show();
                    return;
                }


                if(c_id.equals("")||c_pw.equals("")||c_name.equals("")||c_phone.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(c_register.this);
                    dialog=builder.setMessage("Empty text exist.")
                            .setPositiveButton("OK",null)
                            .create();
                    dialog.show();
                    return;
                }


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //json오브젝트를 활용하여 회원가입 요청
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            //회원가입 성공했을 경우 성공이라고 toast
                            if(success){
                                Toast.makeText(getApplicationContext(),"회원 가입 성공",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(c_register.this, c_login.class);

                                startActivity(intent);

                            }
                            //실패했을 경우
                            else{
                                Toast.makeText(getApplicationContext(),"회원 가입 실패",Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                //서버로 volley를 이용해 요청함
                c_register_request c__register_request = new c_register_request(c_id,c_pw,c_name,c_phone,responseListener);
                RequestQueue queue = Volley.newRequestQueue(c_register.this);
                queue.add(c__register_request);
            }
        });
    }
}