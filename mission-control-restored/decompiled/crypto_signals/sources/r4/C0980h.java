package r4;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: renamed from: r4.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0980h extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0981i f9478a;

    public C0980h(C0981i c0981i) {
        this.f9478a = c0981i;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        this.f9478a.f9479a.f7237c.loadUrl(webResourceRequest.getUrl().toString());
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.f9478a.f9479a.f7237c.loadUrl(str);
        return true;
    }
}
