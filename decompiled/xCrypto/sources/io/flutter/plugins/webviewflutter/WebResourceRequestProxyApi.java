package io.flutter.plugins.webviewflutter;

import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class WebResourceRequestProxyApi extends PigeonApiWebResourceRequest {
    public WebResourceRequestProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public boolean hasGesture(WebResourceRequest webResourceRequest) {
        return webResourceRequest.hasGesture();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public boolean isForMainFrame(WebResourceRequest webResourceRequest) {
        return webResourceRequest.isForMainFrame();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public boolean isRedirect(WebResourceRequest webResourceRequest) {
        return webResourceRequest.isRedirect();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public String method(WebResourceRequest webResourceRequest) {
        return webResourceRequest.getMethod();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public Map<String, String> requestHeaders(WebResourceRequest webResourceRequest) {
        return webResourceRequest.getRequestHeaders() == null ? Collections.EMPTY_MAP : webResourceRequest.getRequestHeaders();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public String url(WebResourceRequest webResourceRequest) {
        return webResourceRequest.getUrl().toString();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
