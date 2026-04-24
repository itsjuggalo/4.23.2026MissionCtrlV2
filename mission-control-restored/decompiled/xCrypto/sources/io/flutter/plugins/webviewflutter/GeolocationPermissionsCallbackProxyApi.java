package io.flutter.plugins.webviewflutter;

import android.webkit.GeolocationPermissions;

/* JADX INFO: loaded from: classes3.dex */
public class GeolocationPermissionsCallbackProxyApi extends PigeonApiGeolocationPermissionsCallback {
    public GeolocationPermissionsCallbackProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiGeolocationPermissionsCallback
    public void invoke(GeolocationPermissions.Callback callback, String str, boolean z4, boolean z5) {
        callback.invoke(str, z4, z5);
    }
}
