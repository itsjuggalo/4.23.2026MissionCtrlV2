package io.flutter.plugins.webviewflutter;

import android.hardware.display.DisplayManager;
import android.view.View;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.firebase.messaging.Constants;
import io.flutter.embedding.android.FlutterView;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugins.webviewflutter.WebChromeClientProxyApi;
import io.flutter.plugins.webviewflutter.WebViewProxyApi;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewProxyApi extends PigeonApiWebView {

    public static class WebViewPlatformView extends WebView implements PlatformView {
        private final WebViewProxyApi api;
        private WebChromeClientProxyApi.SecureWebChromeClient currentWebChromeClient;
        private WebViewClient currentWebViewClient;

        public WebViewPlatformView(WebViewProxyApi webViewProxyApi) {
            super(webViewProxyApi.getPigeonRegistrar().getContext());
            this.api = webViewProxyApi;
            this.currentWebViewClient = new WebViewClient();
            this.currentWebChromeClient = new WebChromeClientProxyApi.SecureWebChromeClient();
            setWebViewClient(this.currentWebViewClient);
            setWebChromeClient(this.currentWebChromeClient);
        }

        public static /* synthetic */ W2.E a(W2.p pVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onScrollChanged$1(int i4, int i5, int i6, int i7) {
            this.api.onScrollChanged(this, i4, i5, i6, i7, new i3.k() { // from class: io.flutter.plugins.webviewflutter.D3
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return WebViewProxyApi.WebViewPlatformView.a((W2.p) obj);
                }
            });
        }

        private FlutterView tryFindFlutterView() {
            ViewParent parent = this;
            while (parent.getParent() != null) {
                parent = parent.getParent();
                if (parent instanceof FlutterView) {
                    return (FlutterView) parent;
                }
            }
            return null;
        }

        @Override // io.flutter.plugin.platform.PlatformView
        public void dispose() {
        }

        @Override // io.flutter.plugin.platform.PlatformView
        public View getView() {
            return this;
        }

        @Override // android.webkit.WebView
        public WebChromeClient getWebChromeClient() {
            return this.currentWebChromeClient;
        }

        @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            FlutterView flutterViewTryFindFlutterView;
            super.onAttachedToWindow();
            if (!this.api.getPigeonRegistrar().sdkIsAtLeast(26) || (flutterViewTryFindFlutterView = tryFindFlutterView()) == null) {
                return;
            }
            flutterViewTryFindFlutterView.setImportantForAutofill(1);
        }

        @Override // android.webkit.WebView, android.view.View
        public void onScrollChanged(final int i4, final int i5, final int i6, final int i7) {
            super.onScrollChanged(i4, i5, i6, i7);
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.C3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12825a.lambda$onScrollChanged$1(i4, i5, i6, i7);
                }
            });
        }

        @Override // android.webkit.WebView
        public void setWebChromeClient(WebChromeClient webChromeClient) {
            super.setWebChromeClient(webChromeClient);
            if (!(webChromeClient instanceof WebChromeClientProxyApi.SecureWebChromeClient)) {
                throw new AssertionError("Client must be a SecureWebChromeClient.");
            }
            WebChromeClientProxyApi.SecureWebChromeClient secureWebChromeClient = (WebChromeClientProxyApi.SecureWebChromeClient) webChromeClient;
            this.currentWebChromeClient = secureWebChromeClient;
            secureWebChromeClient.setWebViewClient(this.currentWebViewClient);
        }

        @Override // android.webkit.WebView
        public void setWebViewClient(WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            this.currentWebViewClient = webViewClient;
            this.currentWebChromeClient.setWebViewClient(webViewClient);
        }
    }

    public WebViewProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void addJavaScriptChannel(WebView webView, JavaScriptChannel javaScriptChannel) {
        webView.addJavascriptInterface(javaScriptChannel, javaScriptChannel.javaScriptChannelName);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public boolean canGoBack(WebView webView) {
        return webView.canGoBack();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public boolean canGoForward(WebView webView) {
        return webView.canGoForward();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void clearCache(WebView webView, boolean z4) {
        webView.clearCache(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void destroy(WebView webView) {
        webView.destroy();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void evaluateJavascript(WebView webView, String str, final i3.k kVar) {
        webView.evaluateJavascript(str, new ValueCallback() { // from class: io.flutter.plugins.webviewflutter.B3
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                ResultCompat.success((String) obj, kVar);
            }
        });
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public String getTitle(WebView webView) {
        return webView.getTitle();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public String getUrl(WebView webView) {
        return webView.getUrl();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void goBack(WebView webView) {
        webView.goBack();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void goForward(WebView webView) {
        webView.goForward();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void loadData(WebView webView, String str, String str2, String str3) {
        webView.loadData(str, str2, str3);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void loadDataWithBaseUrl(WebView webView, String str, String str2, String str3, String str4, String str5) {
        webView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void loadUrl(WebView webView, String str, Map<String, String> map) {
        webView.loadUrl(str, map);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public WebView pigeon_defaultConstructor() {
        DisplayListenerProxy displayListenerProxy = new DisplayListenerProxy();
        DisplayManager displayManager = (DisplayManager) getPigeonRegistrar().getContext().getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        displayListenerProxy.onPreWebViewInitialization(displayManager);
        WebViewPlatformView webViewPlatformView = new WebViewPlatformView(this);
        displayListenerProxy.onPostWebViewInitialization(displayManager);
        return webViewPlatformView;
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void postUrl(WebView webView, String str, byte[] bArr) {
        webView.postUrl(str, bArr);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void reload(WebView webView) {
        webView.reload();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void removeJavaScriptChannel(WebView webView, String str) {
        webView.removeJavascriptInterface(str);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void setBackgroundColor(WebView webView, long j4) {
        webView.setBackgroundColor((int) j4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void setDownloadListener(WebView webView, DownloadListener downloadListener) {
        webView.setDownloadListener(downloadListener);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void setWebChromeClient(WebView webView, WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl) {
        webView.setWebChromeClient(webChromeClientImpl);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void setWebContentsDebuggingEnabled(boolean z4) {
        WebView.setWebContentsDebuggingEnabled(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public void setWebViewClient(WebView webView, WebViewClient webViewClient) {
        webView.setWebViewClient(webViewClient);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public WebSettings settings(WebView webView) {
        return webView.getSettings();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebView
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
