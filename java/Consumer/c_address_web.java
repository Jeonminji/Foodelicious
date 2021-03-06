
package com.example.fd1.Consumer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.fd1.Page.MainActivity;
import com.example.fd1.R;


public class c_address_web extends AppCompatActivity {

    private WebView webView;
    private TextView txt_address;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_address_web);

        txt_address = findViewById(R.id.txt_address);

        // WebView 초기화
        init_webView();

        // 핸들러를 통한 JavaScript 이벤트 반응
        handler = new Handler();
    }
    public void init_webView() {
        // WebView 설정
        webView = (WebView) findViewById(R.id.daum_webview);

        // JavaScript 허용
        webView.getSettings().setJavaScriptEnabled(true);

        // JavaScript의 window.open 허용
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);


        // JavaScript이벤트에 대응할 함수를 정의 한 클래스를 붙여줌
        webView.addJavascriptInterface(new AndroidBridge(), "FD1");

        // web client 를 chrome 으로 설정
        webView.setWebChromeClient(new WebChromeClient());

        // webview url load. php 파일 주소
        webView.loadUrl("http://foodelicious.dothome.co.kr/c_location.php");

    }


    private class AndroidBridge {
        @JavascriptInterface
        public void setAddress(final String arg1, final String arg2, final String arg3) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    final String arg4 = arg2 + " " + arg3;


                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("address1",arg4);
                    startActivity(intent);
                    // WebView를 초기화 하지않으면 재사용할 수 없음
                    init_webView();


                }
            });
        }
    }
}
