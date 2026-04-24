package s4;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes.dex */
public class O extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebViewClient f9665a;

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z6, boolean z7, Message message) {
        WebView webView2 = new WebView(webView.getContext());
        if (this.f9665a == null) {
            return false;
        }
        webView2.setWebViewClient(new N(this, webView));
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }
}
