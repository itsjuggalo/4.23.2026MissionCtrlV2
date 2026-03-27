package r4;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import io.flutter.plugins.urllauncher.WebViewActivity;

/* JADX INFO: renamed from: r4.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0981i extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewActivity f9479a;

    public C0981i(WebViewActivity webViewActivity) {
        this.f9479a = webViewActivity;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z6, boolean z7, Message message) {
        C0980h c0980h = new C0980h(this);
        WebView webView2 = new WebView(this.f9479a.f7237c.getContext());
        webView2.setWebViewClient(c0980h);
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }
}
