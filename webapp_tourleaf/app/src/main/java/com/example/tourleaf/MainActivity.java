package com.example.tourleaf;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView web_View;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web_View = findViewById(R.id.webview_Id);
        mProgressBar = findViewById(R.id.progressBar);
        mProgressBar.setMax(100);
        web_View.loadUrl("https://www.tourleaf.com/");
        WebSettings websettings = web_View.getSettings();
        websettings.setJavaScriptEnabled(true);
        web_View.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mProgressBar.setVisibility(View.VISIBLE);
                setTitle("Loading...");
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mProgressBar.setVisibility(View.GONE);
                setTitle(view.getTitle());
                super.onPageFinished(view, url);
            }
        });

    }
        @Override
        public void onBackPressed()
    {
            if (web_View.canGoBack()) {
                web_View.goBack(); }
            else {
                super.onBackPressed();
            }

        }

    }


