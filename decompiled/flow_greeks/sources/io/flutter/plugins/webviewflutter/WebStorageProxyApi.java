package io.flutter.plugins.webviewflutter;

import android.webkit.WebStorage;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
