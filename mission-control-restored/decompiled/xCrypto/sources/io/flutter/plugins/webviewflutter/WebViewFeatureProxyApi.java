package io.flutter.plugins.webviewflutter;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewFeatureProxyApi extends PigeonApiWebViewFeature {
    public WebViewFeatureProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewFeature
    public boolean isFeatureSupported(String str) {
        return u0.d.a(str);
    }
}
