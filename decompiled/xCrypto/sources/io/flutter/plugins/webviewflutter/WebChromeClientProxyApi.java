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
import io.flutter.plugins.webviewflutter.WebChromeClientProxyApi;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class WebChromeClientProxyApi extends PigeonApiWebChromeClient {

    public static class SecureWebChromeClient extends WebChromeClient {
        WebViewClient webViewClient;

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z4, boolean z5, Message message) {
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

        public static /* synthetic */ W2.E a(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E b(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E d(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E e(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E f(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E g(W2.p pVar) {
            return null;
        }

        public static /* synthetic */ W2.E h(W2.p pVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ W2.E lambda$onJsAlert$8(JsResult jsResult, ResultCompat resultCompat) {
            if (!resultCompat.isFailure()) {
                jsResult.confirm();
                return null;
            }
            ProxyApiRegistrar pigeonRegistrar = this.api.getPigeonRegistrar();
            Throwable thExceptionOrNull = resultCompat.exceptionOrNull();
            Objects.requireNonNull(thExceptionOrNull);
            pigeonRegistrar.logError(TAG, thExceptionOrNull);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ W2.E lambda$onJsConfirm$9(JsResult jsResult, ResultCompat resultCompat) {
            if (!resultCompat.isFailure()) {
                if (Boolean.TRUE.equals(resultCompat.getOrNull())) {
                    jsResult.confirm();
                } else {
                    jsResult.cancel();
                }
                return null;
            }
            ProxyApiRegistrar pigeonRegistrar = this.api.getPigeonRegistrar();
            Throwable thExceptionOrNull = resultCompat.exceptionOrNull();
            Objects.requireNonNull(thExceptionOrNull);
            pigeonRegistrar.logError(TAG, thExceptionOrNull);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ W2.E lambda$onJsPrompt$10(JsPromptResult jsPromptResult, ResultCompat resultCompat) {
            if (resultCompat.isFailure()) {
                ProxyApiRegistrar pigeonRegistrar = this.api.getPigeonRegistrar();
                Throwable thExceptionOrNull = resultCompat.exceptionOrNull();
                Objects.requireNonNull(thExceptionOrNull);
                pigeonRegistrar.logError(TAG, thExceptionOrNull);
                return null;
            }
            String str = (String) resultCompat.getOrNull();
            if (str != null) {
                jsPromptResult.confirm(str);
            } else {
                jsPromptResult.cancel();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ W2.E lambda$onShowFileChooser$5(boolean z4, ValueCallback valueCallback, ResultCompat resultCompat) {
            if (resultCompat.isFailure()) {
                ProxyApiRegistrar pigeonRegistrar = this.api.getPigeonRegistrar();
                Throwable thExceptionOrNull = resultCompat.exceptionOrNull();
                Objects.requireNonNull(thExceptionOrNull);
                pigeonRegistrar.logError(TAG, thExceptionOrNull);
                return null;
            }
            List list = (List) resultCompat.getOrNull();
            Objects.requireNonNull(list);
            List list2 = list;
            if (z4) {
                Uri[] uriArr = new Uri[list2.size()];
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    uriArr[i4] = Uri.parse((String) list2.get(i4));
                }
                valueCallback.onReceiveValue(uriArr);
            }
            return null;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            this.api.onConsoleMessage(this, consoleMessage, new i3.k() { // from class: io.flutter.plugins.webviewflutter.R2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.b((W2.p) obj);
                }
            });
            return this.returnValueForOnConsoleMessage;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            this.api.onGeolocationPermissionsHidePrompt(this, new i3.k() { // from class: io.flutter.plugins.webviewflutter.P2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.g((W2.p) obj);
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            this.api.onGeolocationPermissionsShowPrompt(this, str, callback, new i3.k() { // from class: io.flutter.plugins.webviewflutter.T2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.h((W2.p) obj);
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            this.api.onHideCustomView(this, new i3.k() { // from class: io.flutter.plugins.webviewflutter.Y2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.f((W2.p) obj);
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            if (!this.returnValueForOnJsAlert) {
                return false;
            }
            this.api.onJsAlert(this, webView, str, str2, ResultCompat.asCompatCallback(new i3.k() { // from class: io.flutter.plugins.webviewflutter.U2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return this.f12913a.lambda$onJsAlert$8(jsResult, (ResultCompat) obj);
                }
            }));
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
            if (!this.returnValueForOnJsConfirm) {
                return false;
            }
            this.api.onJsConfirm(this, webView, str, str2, ResultCompat.asCompatCallback(new i3.k() { // from class: io.flutter.plugins.webviewflutter.O2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return this.f12887a.lambda$onJsConfirm$9(jsResult, (ResultCompat) obj);
                }
            }));
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
            if (!this.returnValueForOnJsPrompt) {
                return false;
            }
            this.api.onJsPrompt(this, webView, str, str2, str3, ResultCompat.asCompatCallback(new i3.k() { // from class: io.flutter.plugins.webviewflutter.Q2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return this.f12899a.lambda$onJsPrompt$10(jsPromptResult, (ResultCompat) obj);
                }
            }));
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            this.api.onPermissionRequest(this, permissionRequest, new i3.k() { // from class: io.flutter.plugins.webviewflutter.W2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.e((W2.p) obj);
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i4) {
            this.api.onProgressChanged(this, webView, i4, new i3.k() { // from class: io.flutter.plugins.webviewflutter.V2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.a((W2.p) obj);
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            this.api.onShowCustomView(this, view, customViewCallback, new i3.k() { // from class: io.flutter.plugins.webviewflutter.S2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebChromeClientProxyApi.WebChromeClientImpl.d((W2.p) obj);
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            final boolean z4 = this.returnValueForOnShowFileChooser;
            this.api.onShowFileChooser(this, webView, fileChooserParams, ResultCompat.asCompatCallback(new i3.k() { // from class: io.flutter.plugins.webviewflutter.X2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return this.f12928a.lambda$onShowFileChooser$5(z4, valueCallback, (ResultCompat) obj);
                }
            }));
            return z4;
        }

        public void setReturnValueForOnConsoleMessage(boolean z4) {
            this.returnValueForOnConsoleMessage = z4;
        }

        public void setReturnValueForOnJsAlert(boolean z4) {
            this.returnValueForOnJsAlert = z4;
        }

        public void setReturnValueForOnJsConfirm(boolean z4) {
            this.returnValueForOnJsConfirm = z4;
        }

        public void setReturnValueForOnJsPrompt(boolean z4) {
            this.returnValueForOnJsPrompt = z4;
        }

        public void setReturnValueForOnShowFileChooser(boolean z4) {
            this.returnValueForOnShowFileChooser = z4;
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
    public void setSynchronousReturnValueForOnConsoleMessage(WebChromeClientImpl webChromeClientImpl, boolean z4) {
        webChromeClientImpl.setReturnValueForOnConsoleMessage(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient
    public void setSynchronousReturnValueForOnJsAlert(WebChromeClientImpl webChromeClientImpl, boolean z4) {
        webChromeClientImpl.setReturnValueForOnJsAlert(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient
    public void setSynchronousReturnValueForOnJsConfirm(WebChromeClientImpl webChromeClientImpl, boolean z4) {
        webChromeClientImpl.setReturnValueForOnJsConfirm(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient
    public void setSynchronousReturnValueForOnJsPrompt(WebChromeClientImpl webChromeClientImpl, boolean z4) {
        webChromeClientImpl.setReturnValueForOnJsPrompt(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient
    public void setSynchronousReturnValueForOnShowFileChooser(WebChromeClientImpl webChromeClientImpl, boolean z4) {
        webChromeClientImpl.setReturnValueForOnShowFileChooser(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
