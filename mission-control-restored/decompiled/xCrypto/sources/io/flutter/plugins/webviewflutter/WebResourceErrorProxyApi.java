package io.flutter.plugins.webviewflutter;

import android.webkit.WebResourceError;

/* JADX INFO: loaded from: classes3.dex */
public class WebResourceErrorProxyApi extends PigeonApiWebResourceError {
    public WebResourceErrorProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceError
    public String description(WebResourceError webResourceError) {
        return webResourceError.getDescription().toString();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceError
    public long errorCode(WebResourceError webResourceError) {
        return webResourceError.getErrorCode();
    }
}
