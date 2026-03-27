package io.flutter.plugins.webviewflutter;

import android.webkit.WebView;
import io.flutter.embedding.engine.FlutterEngine;

/* JADX INFO: loaded from: classes.dex */
public interface WebViewFlutterAndroidExternalApi {
    static WebView getWebView(FlutterEngine flutterEngine, long j8) {
        WebViewFlutterPlugin webViewFlutterPlugin = (WebViewFlutterPlugin) flutterEngine.getPlugins().get(WebViewFlutterPlugin.class);
        if (webViewFlutterPlugin == null || webViewFlutterPlugin.getInstanceManager() == null) {
            return null;
        }
        Object androidWebkitLibraryPigeonInstanceManager = webViewFlutterPlugin.getInstanceManager().getInstance(j8);
        if (androidWebkitLibraryPigeonInstanceManager instanceof WebView) {
            return (WebView) androidWebkitLibraryPigeonInstanceManager;
        }
        return null;
    }
}
