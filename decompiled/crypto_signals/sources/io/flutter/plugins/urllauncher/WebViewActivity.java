package io.flutter.plugins.urllauncher;

import N1.d2;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r4.C0979g;
import r4.C0981i;
import u.AbstractC1193h;

/* JADX INFO: loaded from: classes.dex */
public class WebViewActivity extends Activity {
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebView f7237c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d2 f7235a = new d2(this);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0979g f7236b = new C0979g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IntentFilter f7238d = new IntentFilter("close action");

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        Map<String, String> map;
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        this.f7237c = webView;
        setContentView(webView);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("url");
        boolean booleanExtra = intent.getBooleanExtra("enableJavaScript", false);
        boolean booleanExtra2 = intent.getBooleanExtra("enableDomStorage", false);
        Bundle bundleExtra = intent.getBundleExtra("com.android.browser.headers");
        if (bundleExtra == null) {
            map = Collections.EMPTY_MAP;
        } else {
            HashMap map2 = new HashMap();
            for (String str : bundleExtra.keySet()) {
                map2.put(str, bundleExtra.getString(str));
            }
            map = map2;
        }
        this.f7237c.loadUrl(stringExtra, map);
        this.f7237c.getSettings().setJavaScriptEnabled(booleanExtra);
        this.f7237c.getSettings().setDomStorageEnabled(booleanExtra2);
        this.f7237c.setWebViewClient(this.f7236b);
        this.f7237c.getSettings().setSupportMultipleWindows(true);
        this.f7237c.setWebChromeClient(new C0981i(this));
        AbstractC1193h.registerReceiver(this, this.f7235a, this.f7238d, 2);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f7235a);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f7237c.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.f7237c.goBack();
        return true;
    }
}
