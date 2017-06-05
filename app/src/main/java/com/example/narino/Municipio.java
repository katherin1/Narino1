package com.example.narino;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Municipio extends AppCompatActivity {


    String  mun, webUrl;
    TextView nombreMun;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //nombreMun = (TextView) findViewById(R.id.nomMun);
        web=(WebView)findViewById(R.id.web1);


        Bundle bundle = getIntent().getExtras();
        mun =  bundle.getString("mun");
        webUrl = bundle.getString("web");
        //web.loadUrl("http://" +webUrl);
        web.loadUrl("http://" +webUrl);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setBuiltInZoomControls(true);
        //web.getSettings().setTextSize(WebSettings.TextSize.SMALLEST);
        web.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
       // nombreMun.setText(mun);


        web.setWebViewClient(new WebViewClient(){
            public boolean shouldOverriceUrlLoading(WebView view, String url)
            {
                return false;
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item){

        finish();
        return true;

    }
}
