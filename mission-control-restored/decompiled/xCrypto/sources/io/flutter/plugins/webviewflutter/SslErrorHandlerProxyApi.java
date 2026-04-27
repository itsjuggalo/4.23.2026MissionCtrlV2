package io.flutter.plugins.webviewflutter;

import android.webkit.SslErrorHandler;

/* JADX INFO: loaded from: classes3.dex */
class SslErrorHandlerProxyApi extends PigeonApiSslErrorHandler {
    public SslErrorHandlerProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslErrorHandler
    public void cancel(SslErrorHandler sslErrorHandler) {
        sslErrorHandler.cancel();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslErrorHandler
    public void proceed(SslErrorHandler sslErrorHandler) {
        sslErrorHandler.proceed();
    }
}
