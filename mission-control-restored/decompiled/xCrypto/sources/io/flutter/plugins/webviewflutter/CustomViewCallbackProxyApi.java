package io.flutter.plugins.webviewflutter;

import android.webkit.WebChromeClient;

/* JADX INFO: loaded from: classes3.dex */
public class CustomViewCallbackProxyApi extends PigeonApiCustomViewCallback {
    public CustomViewCallbackProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCustomViewCallback
    public void onCustomViewHidden(WebChromeClient.CustomViewCallback customViewCallback) {
        customViewCallback.onCustomViewHidden();
    }
}
