package io.flutter.plugins.webviewflutter;

import android.webkit.WebView;
import io.flutter.embedding.engine.FlutterEngine;

/* JADX INFO: loaded from: classes3.dex */
public interface WebViewFlutterAndroidExternalApi {
    static WebView getWebView(FlutterEngine flutterEngine, long j4) {
        WebViewFlutterPlugin webViewFlutterPlugin = (WebViewFlutterPlugin) flutterEngine.getPlugins().get(WebViewFlutterPlugin.class);
        if (webViewFlutterPlugin == null || webViewFlutterPlugin.getInstanceManager() == null) {
            return null;
        }
        Object androidWebkitLibraryPigeonInstanceManager = webViewFlutterPlugin.getInstanceManager().getInstance(j4);
        if (androidWebkitLibraryPigeonInstanceManager instanceof WebView) {
            return (WebView) androidWebkitLibraryPigeonInstanceManager;
        }
        return null;
    }
}
