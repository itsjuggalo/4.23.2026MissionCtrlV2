package io.flutter.plugins.webviewflutter;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewPointProxyApi extends PigeonApiWebViewPoint {
    public WebViewPointProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewPoint
    public long x(WebViewPoint webViewPoint) {
        return webViewPoint.getX();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewPoint
    public long y(WebViewPoint webViewPoint) {
        return webViewPoint.getY();
    }
}
