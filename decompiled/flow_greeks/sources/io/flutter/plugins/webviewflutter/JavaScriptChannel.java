package io.flutter.plugins.webviewflutter;

import android.webkit.JavascriptInterface;
import cd.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class JavaScriptChannel {
    private final JavaScriptChannelProxyApi api;
    final String javaScriptChannelName;

    public JavaScriptChannel(String str, JavaScriptChannelProxyApi javaScriptChannelProxyApi) {
        this.javaScriptChannelName = str;
        this.api = javaScriptChannelProxyApi;
    }

    public static /* synthetic */ cd.h0 b(r rVar) {
        return null;
    }

    @JavascriptInterface
    public void postMessage(final String str) {
        this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.p0
            @Override // java.lang.Runnable
            public final void run() {
                JavaScriptChannel javaScriptChannel = this.f13391a;
                javaScriptChannel.api.postMessage(javaScriptChannel, str, new pd.k() { // from class: io.flutter.plugins.webviewflutter.o0
                    @Override // pd.k
                    public final Object invoke(Object obj) {
                        return JavaScriptChannel.b((r) obj);
                    }
                });
            }
        });
    }
}
