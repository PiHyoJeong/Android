package org.techtown.web;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new ViewClient());

//        webView.setWebViewClient(new WebViewClient(){ //class를 정의해도 되고,
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                view.loadUrl(request.getUrl().toString());
//                return true;
//            }
//        });



        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(editText.getText().toString()); //주소가 있으면 그 주소로 웹 실행하기.
            }
        });


        }

    private class ViewClient extends WebViewClient{ //webViewClient를 상속한 별도의 class 정의
        public boolean shouldOverrideUrlLoading(final WebView view,final String url){
            view.loadUrl(url);

            return true;
        }
    }

}