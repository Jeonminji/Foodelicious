package com.example.fd1.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fd1.Consumer.c_login;
import com.example.fd1.R;
import com.example.fd1.Seller.s_login;

public class c_or_s extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_or_s);

       //소비자 로그인 화면으로 전환
        Button consumer_button = (Button) findViewById(R.id.consumer);
        consumer_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), c_login.class);
                startActivity(intent);
            }
        });

        //판매자 로그인 화면으로 전환
        Button seller_button = (Button) findViewById(R.id.seller);
        seller_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), s_login.class);
                startActivity(intent);
            }
        });
    }
}
