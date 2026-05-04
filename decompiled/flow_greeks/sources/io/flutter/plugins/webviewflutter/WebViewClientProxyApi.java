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
import androidx.webkit.WebViewClientCompat;
import cd.r;
import io.flutter.plugins.webviewflutter.WebViewClientProxyApi;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class WebViewClientProxyApi extends PigeonApiWebViewClient {
    public WebViewClientProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewClient
    public WebViewClient pigeon_defaultConstructor() {
        return getPigeonRegistrar().sdkIsAtLeast(24) ? new WebViewClientImpl(this) : new WebViewClientCompatImpl(this);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewClient
    public void setSynchronousReturnValueForShouldOverrideUrlLoading(WebViewClient webViewClient, boolean z10) {
        if (webViewClient instanceof WebViewClientCompatImpl) {
            ((WebViewClientCompatImpl) webViewClient).setReturnValueForShouldOverrideUrlLoading(z10);
        } else {
            if (!getPigeonRegistrar().sdkIsAtLeast(24) || !(webViewClient instanceof WebViewClientImpl)) {
                throw new IllegalStateException("This WebViewClient doesn't support setting the returnValueForShouldOverrideUrlLoading.");
            }
            ((WebViewClientImpl) webViewClient).setReturnValueForShouldOverrideUrlLoading(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class WebViewClientCompatImpl extends WebViewClientCompat {
        private final WebViewClientProxyApi api;
        private boolean returnValueForShouldOverrideUrlLoading = false;

        public WebViewClientCompatImpl(WebViewClientProxyApi webViewClientProxyApi) {
            this.api = webViewClientProxyApi;
        }

        public static /* synthetic */ cd.h0 B(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 C(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 D(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 E(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 F(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 a(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 f(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 g(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 i(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 n(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 o(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 q(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 s(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 v(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 w(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 x(r rVar) {
            return null;
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(final WebView webView, final String str, final boolean z10) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.a8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13189a;
                    webViewClientCompatImpl.api.doUpdateVisitedHistory(webViewClientCompatImpl, webView, str, z10, new pd.k() { // from class: io.flutter.plugins.webviewflutter.p7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.a((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(final WebView webView, final Message message, final Message message2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.y6
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13514a;
                    webViewClientCompatImpl.api.onFormResubmission(webViewClientCompatImpl, webView, message, message2, new pd.k() { // from class: io.flutter.plugins.webviewflutter.v7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.C((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.z7
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13532a;
                    webViewClientCompatImpl.api.onLoadResource(webViewClientCompatImpl, webView, str, new pd.k() { // from class: io.flutter.plugins.webviewflutter.r7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.o((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
        public void onPageCommitVisible(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.u7
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13460a;
                    webViewClientCompatImpl.api.onPageCommitVisible(webViewClientCompatImpl, webView, str, new pd.k() { // from class: io.flutter.plugins.webviewflutter.s7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.n((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.b8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13207a;
                    webViewClientCompatImpl.api.onPageFinished(webViewClientCompatImpl, webView, str, new pd.k() { // from class: io.flutter.plugins.webviewflutter.h7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.F((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(final WebView webView, final String str, Bitmap bitmap) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.a7
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13186a;
                    webViewClientCompatImpl.api.onPageStarted(webViewClientCompatImpl, webView, str, new pd.k() { // from class: io.flutter.plugins.webviewflutter.n7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.i((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(final WebView webView, final ClientCertRequest clientCertRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.f7
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13266a;
                    webViewClientCompatImpl.api.onReceivedClientCertRequest(webViewClientCompatImpl, webView, clientCertRequest, new pd.k() { // from class: io.flutter.plugins.webviewflutter.m7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.f((r) obj);
                        }
                    });
                }
            });
        }

        @Override // androidx.webkit.WebViewClientCompat
        public void onReceivedError(final WebView webView, final WebResourceRequest webResourceRequest, final q2.b bVar) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.g7
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13282a;
                    webViewClientCompatImpl.api.onReceivedRequestErrorCompat(webViewClientCompatImpl, webView, webResourceRequest, bVar, new pd.k() { // from class: io.flutter.plugins.webviewflutter.y7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.E((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(final WebView webView, final HttpAuthHandler httpAuthHandler, final String str, final String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.e7
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13252a;
                    webViewClientCompatImpl.api.onReceivedHttpAuthRequest(webViewClientCompatImpl, webView, httpAuthHandler, str, str2, new pd.k() { // from class: io.flutter.plugins.webviewflutter.w7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.x((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
        public void onReceivedHttpError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceResponse webResourceResponse) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.k7
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13339a;
                    webViewClientCompatImpl.api.onReceivedHttpError(webViewClientCompatImpl, webView, webResourceRequest, webResourceResponse, new pd.k() { // from class: io.flutter.plugins.webviewflutter.l7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.B((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(final WebView webView, final String str, final String str2, final String str3) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.j7
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13321a;
                    webViewClientCompatImpl.api.onReceivedLoginRequest(webViewClientCompatImpl, webView, str, str2, str3, new pd.k() { // from class: io.flutter.plugins.webviewflutter.o7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.v((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.c7
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13223a;
                    webViewClientCompatImpl.api.onReceivedSslError(webViewClientCompatImpl, webView, sslErrorHandler, sslError, new pd.k() { // from class: io.flutter.plugins.webviewflutter.i7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.D((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(final WebView webView, final float f10, final float f11) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.z6
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13528a;
                    webViewClientCompatImpl.api.onScaleChanged(webViewClientCompatImpl, webView, f10, f11, new pd.k() { // from class: io.flutter.plugins.webviewflutter.b7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.s((r) obj);
                        }
                    });
                }
            });
        }

        public void setReturnValueForShouldOverrideUrlLoading(boolean z10) {
            this.returnValueForShouldOverrideUrlLoading = z10;
        }

        @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
        public boolean shouldOverrideUrlLoading(final WebView webView, final WebResourceRequest webResourceRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.x7
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13499a;
                    webViewClientCompatImpl.api.requestLoading(webViewClientCompatImpl, webView, webResourceRequest, new pd.k() { // from class: io.flutter.plugins.webviewflutter.d7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.q((r) obj);
                        }
                    });
                }
            });
            return webResourceRequest.isForMainFrame() && this.returnValueForShouldOverrideUrlLoading;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(final WebView webView, final int i10, final String str, final String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.w6
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13487a;
                    webViewClientCompatImpl.api.onReceivedError(webViewClientCompatImpl, webView, i10, str, str2, new pd.k() { // from class: io.flutter.plugins.webviewflutter.x6
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.g((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.q7
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl webViewClientCompatImpl = this.f13411a;
                    webViewClientCompatImpl.api.urlLoading(webViewClientCompatImpl, webView, str, new pd.k() { // from class: io.flutter.plugins.webviewflutter.t7
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientCompatImpl.w((r) obj);
                        }
                    });
                }
            });
            return this.returnValueForShouldOverrideUrlLoading;
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class WebViewClientImpl extends WebViewClient {
        private final WebViewClientProxyApi api;
        private boolean returnValueForShouldOverrideUrlLoading = false;

        public WebViewClientImpl(WebViewClientProxyApi webViewClientProxyApi) {
            this.api = webViewClientProxyApi;
        }

        public static /* synthetic */ cd.h0 A(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 B(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 C(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 E(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 F(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 b(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 e(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 f(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 h(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 i(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 k(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 t(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 u(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 v(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 y(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 z(r rVar) {
            return null;
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(final WebView webView, final String str, final boolean z10) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.k8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13343a;
                    webViewClientImpl.api.doUpdateVisitedHistory(webViewClientImpl, webView, str, z10, new pd.k() { // from class: io.flutter.plugins.webviewflutter.j8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.v((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(final WebView webView, final Message message, final Message message2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.u8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13463a;
                    webViewClientImpl.api.onFormResubmission(webViewClientImpl, webView, message, message2, new pd.k() { // from class: io.flutter.plugins.webviewflutter.g8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.A((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.x8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13502a;
                    webViewClientImpl.api.onLoadResource(webViewClientImpl, webView, str, new pd.k() { // from class: io.flutter.plugins.webviewflutter.f8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.u((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.i8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13309a;
                    webViewClientImpl.api.onPageCommitVisible(webViewClientImpl, webView, str, new pd.k() { // from class: io.flutter.plugins.webviewflutter.c8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.i((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.d8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13240a;
                    webViewClientImpl.api.onPageFinished(webViewClientImpl, webView, str, new pd.k() { // from class: io.flutter.plugins.webviewflutter.g9
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.B((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(final WebView webView, final String str, Bitmap bitmap) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.n8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13379a;
                    webViewClientImpl.api.onPageStarted(webViewClientImpl, webView, str, new pd.k() { // from class: io.flutter.plugins.webviewflutter.l8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.y((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(final WebView webView, final ClientCertRequest clientCertRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.r8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13428a;
                    webViewClientImpl.api.onReceivedClientCertRequest(webViewClientImpl, webView, clientCertRequest, new pd.k() { // from class: io.flutter.plugins.webviewflutter.z8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.f((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.c9
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13227a;
                    webViewClientImpl.api.onReceivedRequestError(webViewClientImpl, webView, webResourceRequest, webResourceError, new pd.k() { // from class: io.flutter.plugins.webviewflutter.o8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.z((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(final WebView webView, final HttpAuthHandler httpAuthHandler, final String str, final String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.f9
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13269a;
                    webViewClientImpl.api.onReceivedHttpAuthRequest(webViewClientImpl, webView, httpAuthHandler, str, str2, new pd.k() { // from class: io.flutter.plugins.webviewflutter.y8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.e((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceResponse webResourceResponse) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.h9
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13297a;
                    webViewClientImpl.api.onReceivedHttpError(webViewClientImpl, webView, webResourceRequest, webResourceResponse, new pd.k() { // from class: io.flutter.plugins.webviewflutter.d9
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.C((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(final WebView webView, final String str, final String str2, final String str3) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.b9
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13210a;
                    webViewClientImpl.api.onReceivedLoginRequest(webViewClientImpl, webView, str, str2, str3, new pd.k() { // from class: io.flutter.plugins.webviewflutter.t8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.h((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.a9
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13193a;
                    webViewClientImpl.api.onReceivedSslError(webViewClientImpl, webView, sslErrorHandler, sslError, new pd.k() { // from class: io.flutter.plugins.webviewflutter.p8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.E((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(final WebView webView, final float f10, final float f11) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.m8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13362a;
                    webViewClientImpl.api.onScaleChanged(webViewClientImpl, webView, f10, f11, new pd.k() { // from class: io.flutter.plugins.webviewflutter.e9
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.k((r) obj);
                        }
                    });
                }
            });
        }

        public void setReturnValueForShouldOverrideUrlLoading(boolean z10) {
            this.returnValueForShouldOverrideUrlLoading = z10;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(final WebView webView, final WebResourceRequest webResourceRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.h8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13294a;
                    webViewClientImpl.api.requestLoading(webViewClientImpl, webView, webResourceRequest, new pd.k() { // from class: io.flutter.plugins.webviewflutter.w8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.t((r) obj);
                        }
                    });
                }
            });
            return webResourceRequest.isForMainFrame() && this.returnValueForShouldOverrideUrlLoading;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(final WebView webView, final int i10, final String str, final String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.v8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13474a;
                    webViewClientImpl.api.onReceivedError(webViewClientImpl, webView, i10, str, str2, new pd.k() { // from class: io.flutter.plugins.webviewflutter.e8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.F((r) obj);
                        }
                    });
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.q8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl webViewClientImpl = this.f13414a;
                    webViewClientImpl.api.urlLoading(webViewClientImpl, webView, str, new pd.k() { // from class: io.flutter.plugins.webviewflutter.s8
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return WebViewClientProxyApi.WebViewClientImpl.b((r) obj);
                        }
                    });
                }
            });
            return this.returnValueForShouldOverrideUrlLoading;
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        }
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewClient
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
