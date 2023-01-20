package com.example.webviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    //웹뷰를 틀 때 인터넷 주소 미리 설정
    private String url = "https://www.naver.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        //자바 스크립트 허용
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url); //url을 로드해라
        webView.setWebChromeClient(new WebChromeClient());//구글 크롬의 브라우저에 맞춰 추가 세팅
        webView.setWebViewClient(new WebViewClientClass()); //일반적인 웹 뷰 클라이언트

    }


    //안드로이드의 키를 입력했을 때 어떤 동작을 해줄지 설정하는 메소드
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //뒤로 가기 키를 눌렀을 때 && 웹 뷰가 뒤로 갈 수 있게 되면
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack(); //웹 뷰를 뒤로가게 하기
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {

        //현재 페이지의 url을 읽어옴 (새 창, 특수한 기능 넣을 수도 있음)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

//manifests 수정
//<uses-permission android:name="android.permission.INTERNET"/> 추가
