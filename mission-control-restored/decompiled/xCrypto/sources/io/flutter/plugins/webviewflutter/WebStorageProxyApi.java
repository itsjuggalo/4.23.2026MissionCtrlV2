package io.flutter.plugins.webviewflutter;

import android.webkit.WebStorage;

/* JADX INFO: loaded from: classes3.dex */
public class WebStorageProxyApi extends PigeonApiWebStorage {
    public WebStorageProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebStorage
    public void deleteAllData(WebStorage webStorage) {
        webStorage.deleteAllData();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebStorage
    public WebStorage instance() {
        return WebStorage.getInstance();
    }
}
