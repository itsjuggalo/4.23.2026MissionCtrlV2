package io.flutter.plugins.webviewflutter;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.flutter.plugins.webviewflutter.WebViewClientProxyApi;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewClientProxyApi extends PigeonApiWebViewClient {

    public static class WebViewClientImpl extends WebViewClient {
        private final WebViewClientProxyApi api;
        private boolean returnValueForShouldOverrideUrlLoading = false;

        public WebViewClientImpl(WebViewClientProxyApi webViewClientProxyApi) {
            this.api = webViewClientProxyApi;
        }

        public static /* synthetic */ W2.E A(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E B(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E a(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E c(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E d(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E g(W2.p pVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$doUpdateVisitedHistory$11(WebView webView, String str, boolean z4) {
            this.api.doUpdateVisitedHistory(this, webView, str, z4, new i3.k() { // from class: io.flutter.plugins.webviewflutter.m3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.x((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFormResubmission$15(WebView webView, Message message, Message message2) {
            this.api.onFormResubmission(this, webView, message, message2, new i3.k() { // from class: io.flutter.plugins.webviewflutter.Z2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.q((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoadResource$17(WebView webView, String str) {
            this.api.onLoadResource(this, webView, str, new i3.k() { // from class: io.flutter.plugins.webviewflutter.i3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.o((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageCommitVisible$19(WebView webView, String str) {
            this.api.onPageCommitVisible(this, webView, str, new i3.k() { // from class: io.flutter.plugins.webviewflutter.q3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.g((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageFinished$3(WebView webView, String str) {
            this.api.onPageFinished(this, webView, str, new i3.k() { // from class: io.flutter.plugins.webviewflutter.z3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.A((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageStarted$1(WebView webView, String str) {
            this.api.onPageStarted(this, webView, str, new i3.k() { // from class: io.flutter.plugins.webviewflutter.h3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.r((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedClientCertRequest$21(WebView webView, ClientCertRequest clientCertRequest) {
            this.api.onReceivedClientCertRequest(this, webView, clientCertRequest, new i3.k() { // from class: io.flutter.plugins.webviewflutter.w3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.w((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedError$7(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            this.api.onReceivedRequestError(this, webView, webResourceRequest, webResourceError, new i3.k() { // from class: io.flutter.plugins.webviewflutter.l3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.t((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedHttpAuthRequest$13(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            this.api.onReceivedHttpAuthRequest(this, webView, httpAuthHandler, str, str2, new i3.k() { // from class: io.flutter.plugins.webviewflutter.b3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.c((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedHttpError$5(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            this.api.onReceivedHttpError(this, webView, webResourceRequest, webResourceResponse, new i3.k() { // from class: io.flutter.plugins.webviewflutter.v3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.B((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedLoginRequest$23(WebView webView, String str, String str2, String str3) {
            this.api.onReceivedLoginRequest(this, webView, str, str2, str3, new i3.k() { // from class: io.flutter.plugins.webviewflutter.f3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.y((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedSslError$25(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.api.onReceivedSslError(this, webView, sslErrorHandler, sslError, new i3.k() { // from class: io.flutter.plugins.webviewflutter.x3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.p((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onScaleChanged$27(WebView webView, float f4, float f5) {
            this.api.onScaleChanged(this, webView, f4, f5, new i3.k() { // from class: io.flutter.plugins.webviewflutter.r3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.d((W2.p) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$shouldOverrideUrlLoading$9(WebView webView, WebResourceRequest webResourceRequest) {
            this.api.requestLoading(this, webView, webResourceRequest, new i3.k() { // from class: io.flutter.plugins.webviewflutter.c3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.a((W2.p) obj);
                }
            });
        }

        public static /* synthetic */ W2.E o(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E p(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E q(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E r(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E t(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E w(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E x(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E y(W2.p pVar) {
            return null;
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(final WebView webView, final String str, final boolean z4) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.g3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12984a.lambda$doUpdateVisitedHistory$11(webView, str, z4);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(final WebView webView, final Message message, final Message message2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.o3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13027a.lambda$onFormResubmission$15(webView, message, message2);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.p3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13037a.lambda$onLoadResource$17(webView, str);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.e3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12972a.lambda$onPageCommitVisible$19(webView, str);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.a3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12945a.lambda$onPageFinished$3(webView, str);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(final WebView webView, final String str, Bitmap bitmap) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.k3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13007a.lambda$onPageStarted$1(webView, str);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(final WebView webView, final ClientCertRequest clientCertRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.n3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13020a.lambda$onReceivedClientCertRequest$21(webView, clientCertRequest);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.u3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13073a.lambda$onReceivedError$7(webView, webResourceRequest, webResourceError);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(final WebView webView, final HttpAuthHandler httpAuthHandler, final String str, final String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.y3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13095a.lambda$onReceivedHttpAuthRequest$13(webView, httpAuthHandler, str, str2);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceResponse webResourceResponse) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.A3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12812a.lambda$onReceivedHttpError$5(webView, webResourceRequest, webResourceResponse);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(final WebView webView, final String str, final String str2, final String str3) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.t3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13064a.lambda$onReceivedLoginRequest$23(webView, str, str2, str3);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.s3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13055a.lambda$onReceivedSslError$25(webView, sslErrorHandler, sslError);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(final WebView webView, final float f4, final float f5) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.j3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13000a.lambda$onScaleChanged$27(webView, f4, f5);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        }

        public void setReturnValueForShouldOverrideUrlLoading(boolean z4) {
            this.returnValueForShouldOverrideUrlLoading = z4;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(final WebView webView, final WebResourceRequest webResourceRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.d3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12963a.lambda$shouldOverrideUrlLoading$9(webView, webResourceRequest);
                }
            });
            return webResourceRequest.isForMainFrame() && this.returnValueForShouldOverrideUrlLoading;
        }
    }

    public WebViewClientProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewClient
    public WebViewClient pigeon_defaultConstructor() {
        return new WebViewClientImpl(this);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewClient
    public void setSynchronousReturnValueForShouldOverrideUrlLoading(WebViewClient webViewClient, boolean z4) {
        if (!(webViewClient instanceof WebViewClientImpl)) {
            throw new IllegalStateException("This WebViewClient doesn't support setting the returnValueForShouldOverrideUrlLoading.");
        }
        ((WebViewClientImpl) webViewClient).setReturnValueForShouldOverrideUrlLoading(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewClient
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
