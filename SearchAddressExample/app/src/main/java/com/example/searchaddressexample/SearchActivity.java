package com.example.searchaddressexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); //자바스크립트 구문 허용
        webView.addJavascriptInterface(new BridgeInterface(), "Android");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) { //페이지 로딩이 모두 끝났을 때 (Callback의 형태)
                // Android -> Javascript 함수 호출!
                webView.loadUrl("javascript:sample2_execDaumPostcode();");
            }
        });

        //최초 웹뷰 로드 (위의 함수보다 더 먼저 호출)
        webView.loadUrl("https://searchaddress-61857.web.app");

    }

    //웹 뷰 페이지에서 안드로이드의 연동되어있는 웹뷰쪽으로 쏴서 데이터를 통해서 processDATA를 정상적으로 받아온다. (상호간의 연결 통로)
    private class BridgeInterface {
        @JavascriptInterface
        public void processDATA(String data){

            // 다음(카카오) 주소 검색 API의 결과 값이 브릿지 통로를 통해 전해 받는다. (from JAVAScript)
            Intent intent = new Intent();
            intent.putExtra("data", data);
            setResult(RESULT_OK, intent);
            finish();

        }
    }
}