package vn.edu.poly.qunlvtnui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
        Intent intent=getIntent();
        String a=intent.getStringExtra("ok");
        wv.setWebViewClient( new WebViewClient());
        wv.loadUrl(a);
    }

    private void initView() {
        wv = (WebView) findViewById(R.id.wv);
    };
}
