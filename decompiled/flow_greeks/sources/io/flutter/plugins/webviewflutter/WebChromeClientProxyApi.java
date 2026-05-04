package io.flutter.plugins.webviewflutter;

import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cd.r;
import io.flutter.plugins.webviewflutter.WebChromeClientProxyApi;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class WebChromeClientProxyApi extends PigeonApiWebChromeClient {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class SecureWebChromeClient extends WebChromeClient {
        WebViewClient webViewClient;

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
            return onCreateWindow(webView, message, new WebView(webView.getContext()));
        }

        public void setWebViewClient(WebViewClient webViewClient) {
            this.webViewClient = webViewClient;
        }

        public boolean onCreateWindow(final WebView webView, Message message, WebView webView2) {
            if (this.webViewClient == null) {
                return false;
            }
            WebViewClient webViewClient = new WebViewClient() { // from class: io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.SecureWebChromeClient.1
                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView3, WebResourceRequest webResourceRequest) {
                    if (SecureWebChromeClient.this.webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest)) {
                        return true;
                    }
                    webView.loadUrl(webResourceRequest.getUrl().toString());
                    return true;
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView3, String str) {
                    if (SecureWebChromeClient.this.webViewClient.shouldOverrideUrlLoading(webView, str)) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                }
            };
            if (webView2 == null) {
                webView2 = new WebView(webView.getContext());
            }
            webView2.setWebViewClient(webViewClient);
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class WebChromeClientImpl extends SecureWebChromeClient {
        private static final String TAG = "WebChromeClientImpl";
        private final WebChromeClientProxyApi api;
        private boolean returnValueForOnShowFileChooser = false;
        private boolean returnValueForOnConsoleMessage = false;
        private boolean returnValueForOnJsAlert = false;
        private boolean returnValueForOnJsConfirm = false;
        private boolean returnValueForOnJsPrompt = false;

        public WebChromeClientImpl(WebChromeClientProxyApi webChromeClientProxyApi) {
            this.api = webChromeClientProxyApi;
        }

        public static /* synthetic */ cd.h0 a(WebChromeClientImpl webChromeClientImpl, JsPromptResult jsPromptResult, ResultCompat resultCompat) {
            webChromeClientImpl.getClass();
            if (resultCompat.getIsFailure()) {
                ProxyApiRegistrar pigeonRegistrar = webChromeClientImpl.api.getPigeonRegistrar();
                Throwable exception = resultCompat.getException();
                Objects.requireNonNull(exception);
                pigeonRegistrar.logError(TAG, exception);
                return null;
            }
            String str = (String) resultCompat.getOrNull();
            if (str != null) {
                jsPromptResult.confirm(str);
                return null;
            }
            jsPromptResult.cancel();
            return null;
        }

        public static /* synthetic */ cd.h0 b(WebChromeClientImpl webChromeClientImpl, JsResult jsResult, ResultCompat resultCompat) {
            webChromeClientImpl.getClass();
            if (!resultCompat.getIsFailure()) {
                jsResult.confirm();
                return null;
            }
            ProxyApiRegistrar pigeonRegistrar = webChromeClientImpl.api.getPigeonRegistrar();
            Throwable exception = resultCompat.getException();
            Objects.requireNonNull(exception);
            pigeonRegistrar.logError(TAG, exception);
            return null;
        }

        public static /* synthetic */ cd.h0 c(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 d(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 e(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 f(WebChromeClientImpl webChromeClientImpl, JsResult jsResult, ResultCompat resultCompat) {
            webChromeClientImpl.getClass();
            if (resultCompat.getIsFailure()) {
                ProxyApiRegistrar pigeonRegistrar = webChromeClientImpl.api.getPigeonRegistrar();
                Throwable exception = resultCompat.getException();
                Objects.requireNonNull(exception);
                pigeonRegistrar.logError(TAG, exception);
                return null;
            }
            if (Boolean.TRUE.equals(resultCompat.getOrNull())) {
                jsResult.confirm();
                return null;
            }
            jsResult.cancel();
            return null;
        }

        public static /* synthetic */ cd.h0 g(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 h(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 i(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 j(r rVar) {
            return null;
        }

        public static /* synthetic */ cd.h0 k(WebChromeClientImpl webChromeClientImpl, boolean z10, ValueCallback valueCallback, ResultCompat resultCompat) {
            webChromeClientImpl.getClass();
            if (resultCompat.getIsFailure()) {
                ProxyApiRegistrar pigeonRegistrar = webChromeClientImpl.api.getPigeonRegistrar();
                Throwable exception = resultCompat.getException();
                Objects.requireNonNull(exception);
                pigeonRegistrar.logError(TAG, exception);
                return null;
            }
            List list = (List) resultCompat.getOrNull();
            Objects.requireNonNull(list);
            if (z10) {
                Uri[] uriArr = new Uri[list.size()];
                for (int i10 = 0; i10 < list.size(); i10++) {
                    uriArr[i10] = Uri.parse((String) list.get(i10));
                }
                valueCallback.onReceiveValue(uriArr);
            }
            return null;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            this.api.onConsoleMessage(this, consoleMessage, new pd.k() { // from class: io.flutter.plugins.webviewflutter.o6
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.d((r) obj);
                }
            });
            return this.returnValueForOnConsoleMessage;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            this.api.onGeolocationPermissionsHidePrompt(this, new pd.k() { // from class: io.flutter.plugins.webviewflutter.m6
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.i((r) obj);
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            this.api.onGeolocationPermissionsShowPrompt(this, str, callback, new pd.k() { // from class: io.flutter.plugins.webviewflutter.q6
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.j((r) obj);
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            this.api.onHideCustomView(this, new pd.k() { // from class: io.flutter.plugins.webviewflutter.v6
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.h((r) obj);
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            if (!this.returnValueForOnJsAlert) {
                return false;
            }
            this.api.onJsAlert(this, webView, str, str2, ResultCompat.asCompatCallback(new pd.k() { // from class: io.flutter.plugins.webviewflutter.r6
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.b(this.f13426a, jsResult, (ResultCompat) obj);
                }
            }));
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
            if (!this.returnValueForOnJsConfirm) {
                return false;
            }
            this.api.onJsConfirm(this, webView, str, str2, ResultCompat.asCompatCallback(new pd.k() { // from class: io.flutter.plugins.webviewflutter.l6
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.f(this.f13355a, jsResult, (ResultCompat) obj);
                }
            }));
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
            if (!this.returnValueForOnJsPrompt) {
                return false;
            }
            this.api.onJsPrompt(this, webView, str, str2, str3, ResultCompat.asCompatCallback(new pd.k() { // from class: io.flutter.plugins.webviewflutter.n6
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.a(this.f13377a, jsPromptResult, (ResultCompat) obj);
                }
            }));
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            this.api.onPermissionRequest(this, permissionRequest, new pd.k() { // from class: io.flutter.plugins.webviewflutter.t6
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.g((r) obj);
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            this.api.onProgressChanged(this, webView, i10, new pd.k() { // from class: io.flutter.plugins.webviewflutter.s6
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.c((r) obj);
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            this.api.onShowCustomView(this, view, customViewCallback, new pd.k() { // from class: io.flutter.plugins.webviewflutter.p6
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.e((r) obj);
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            final boolean z10 = this.returnValueForOnShowFileChooser;
            this.api.onShowFileChooser(this, webView, fileChooserParams, ResultCompat.asCompatCallback(new pd.k() { // from class: io.flutter.plugins.webviewflutter.u6
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.k(this.f13457a, z10, valueCallback, (ResultCompat) obj);
                }
            }));
            return z10;
        }

        public void setReturnValueForOnConsoleMessage(boolean z10) {
            this.returnValueForOnConsoleMessage = z10;
        }

        public void setReturnValueForOnJsAlert(boolean z10) {
            this.returnValueForOnJsAlert = z10;
        }

        public void setReturnValueForOnJsConfirm(boolean z10) {
            this.returnValueForOnJsConfirm = z10;
        }

        public void setReturnValueForOnJsPrompt(boolean z10) {
            this.returnValueForOnJsPrompt = z10;
        }

        public void setReturnValueForOnShowFileChooser(boolean z10) {
            this.returnValueForOnShowFileChooser = z10;
        }
    }

    public WebChromeClientProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient
    public WebChromeClientImpl pigeon_defaultConstructor() {
        return new WebChromeClientImpl(this);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient
    public void setSynchronousReturnValueForOnConsoleMessage(WebChromeClientImpl webChromeClientImpl, boolean z10) {
        webChromeClientImpl.setReturnValueForOnConsoleMessage(z10);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient
    public void setSynchronousReturnValueForOnJsAlert(WebChromeClientImpl webChromeClientImpl, boolean z10) {
        webChromeClientImpl.setReturnValueForOnJsAlert(z10);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient
    public void setSynchronousReturnValueForOnJsConfirm(WebChromeClientImpl webChromeClientImpl, boolean z10) {
        webChromeClientImpl.setReturnValueForOnJsConfirm(z10);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient
    public void setSynchronousReturnValueForOnJsPrompt(WebChromeClientImpl webChromeClientImpl, boolean z10) {
        webChromeClientImpl.setReturnValueForOnJsPrompt(z10);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient
    public void setSynchronousReturnValueForOnShowFileChooser(WebChromeClientImpl webChromeClientImpl, boolean z10) {
        webChromeClientImpl.setReturnValueForOnShowFileChooser(z10);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
