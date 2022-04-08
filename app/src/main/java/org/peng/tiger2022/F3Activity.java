package org.peng.tiger2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class F3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3);

        WebView displayWebview = findViewById(R.id.wv);

        displayWebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //设置js可以直接打开窗口，如window.open()，默认为false
        displayWebview.getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        displayWebview.getSettings().setSupportZoom(true);//是否可以缩放，默认true
        displayWebview.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        displayWebview.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        displayWebview.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        displayWebview.getSettings().setAppCacheEnabled(true);//是否使用缓存
        displayWebview.getSettings().setDomStorageEnabled(true);//DOM Storage
// displayWebview.getSettings().setUserAgentString("User-Agent:Android");
//设置用户代理，一般不用


        String url = "http://www.qq.com";
        displayWebview.loadUrl(url);
    }
}