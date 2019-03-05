package com.senon.mvpretrofitrx.mvp.activity.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.base.BaseActivity;
import com.senon.mvpretrofitrx.mvp.base.BasePresenter;
import com.senon.mvpretrofitrx.mvp.base.BaseView;
import com.senon.mvpretrofitrx.mvp.utils.SharesUtils;
import com.senon.mvpretrofitrx.mvp.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends BaseActivity {
    @BindView(R.id.iv_baseleft)
    ImageView ivBaseleft;
    @BindView(R.id.tv_basetitle)
    TextView tvBasetitle;
    @BindView(R.id.tv_baseright)
    TextView tvBaseright;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.menu_labels_right)
    FloatingActionMenu fab_menu;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.fab1)
    FloatingActionButton fab1;
    @BindView(R.id.fab2)
    FloatingActionButton fab2;


    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    String uri, title;

    @Override
    public void init() {
        title = getIntent().getStringExtra("title");
        uri = getIntent().getStringExtra("uri");
//        setTitle("title", "");
        setWebView(webview, uri);
        fab_menu.setClosedOnTouchOutside(true);        //点空白处关闭菜单
        fab_menu.close(true);        //关闭菜单
           fab.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   ClipboardManager cmd = (ClipboardManager)
                            getSystemService(Context.CLIPBOARD_SERVICE);
                        cmd.setPrimaryClip(ClipData.
                                newPlainText("复制链接",
                                        webview.getUrl()));
                        ToastUtil.showShortToast("已复制完成");
               }
           });
           fab1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse(webview.getUrl()));
                        startActivity(intent);
               }
           });
           fab2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   SharesUtils.share(WebActivity.this,webview.getUrl());
               }
           });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public void setWebView(WebView webView, String url) {


        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);// 支持JS
        settings.setBuiltInZoomControls(false);// 显示放大缩小按钮
        settings.setUseWideViewPort(true);// 支持双击放大缩小
        settings.setSupportZoom(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setLoadsImagesAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);
                System.out.println("网页开始加载");
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                System.out.println("网页加载结束");
                progressBar.setVisibility(View.GONE);
            }

            /**
             * 所有跳转的链接都在此方法中回调
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                System.out.println("onProgressChanged");
                progressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                setTitle("详情", "");
                super.onReceivedTitle(view, title);
            }
        });

        webView.loadUrl(url);
    }
}
