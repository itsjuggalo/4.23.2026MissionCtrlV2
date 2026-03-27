package io.flutter.plugins.webviewflutter;

import android.webkit.JavascriptInterface;

/* JADX INFO: loaded from: classes3.dex */
public class JavaScriptChannel {
    private final JavaScriptChannelProxyApi api;
    final String javaScriptChannelName;

    public JavaScriptChannel(String str, JavaScriptChannelProxyApi javaScriptChannelProxyApi) {
        this.javaScriptChannelName = str;
        this.api = javaScriptChannelProxyApi;
    }

    public static /* synthetic */ W2.E b(W2.p pVar) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$1(String str) {
        this.api.postMessage(this, str, new i3.k() { // from class: io.flutter.plugins.webviewflutter.M
            @Override // i3.k
            public final Object invoke(Object obj) {
                return JavaScriptChannel.b((W2.p) obj);
            }
        });
    }

    @JavascriptInterface
    public void postMessage(final String str) {
        this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.N
            @Override // java.lang.Runnable
            public final void run() {
                this.f12878a.lambda$postMessage$1(str);
            }
        });
    }
}
