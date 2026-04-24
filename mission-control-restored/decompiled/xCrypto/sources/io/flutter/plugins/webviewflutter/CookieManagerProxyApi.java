package io.flutter.plugins.webviewflutter;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public class CookieManagerProxyApi extends PigeonApiCookieManager {
    public CookieManagerProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCookieManager
    public CookieManager instance() {
        return CookieManager.getInstance();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCookieManager
    public void removeAllCookies(CookieManager cookieManager, final i3.k kVar) {
        cookieManager.removeAllCookies(new ValueCallback() { // from class: io.flutter.plugins.webviewflutter.J
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                ResultCompat.success((Boolean) obj, kVar);
            }
        });
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCookieManager
    public void setAcceptThirdPartyCookies(CookieManager cookieManager, WebView webView, boolean z4) {
        cookieManager.setAcceptThirdPartyCookies(webView, z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCookieManager
    public void setCookie(CookieManager cookieManager, String str, String str2) {
        cookieManager.setCookie(str, str2);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCookieManager
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
