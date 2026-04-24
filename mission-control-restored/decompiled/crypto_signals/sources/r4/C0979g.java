package r4;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: renamed from: r4.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0979g extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        webView.loadUrl(webResourceRequest.getUrl().toString());
        return false;
    }
}
