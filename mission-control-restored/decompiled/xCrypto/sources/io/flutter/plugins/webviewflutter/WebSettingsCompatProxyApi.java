package io.flutter.plugins.webviewflutter;

import android.webkit.WebSettings;

/* JADX INFO: loaded from: classes3.dex */
public class WebSettingsCompatProxyApi extends PigeonApiWebSettingsCompat {
    public WebSettingsCompatProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettingsCompat
    public void setPaymentRequestEnabled(WebSettings webSettings, boolean z4) {
        u0.b.b(webSettings, z4);
    }
}
