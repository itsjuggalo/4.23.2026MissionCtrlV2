package io.flutter.plugins.webviewflutter;

import android.webkit.HttpAuthHandler;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class HttpAuthHandlerProxyApi extends PigeonApiHttpAuthHandler {
    public HttpAuthHandlerProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiHttpAuthHandler
    public void cancel(HttpAuthHandler httpAuthHandler) {
        httpAuthHandler.cancel();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiHttpAuthHandler
    public void proceed(HttpAuthHandler httpAuthHandler, String str, String str2) {
        httpAuthHandler.proceed(str, str2);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiHttpAuthHandler
    public boolean useHttpAuthUsernamePassword(HttpAuthHandler httpAuthHandler) {
        return httpAuthHandler.useHttpAuthUsernamePassword();
    }
}
