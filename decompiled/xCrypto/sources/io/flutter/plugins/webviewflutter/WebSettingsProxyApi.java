package io.flutter.plugins.webviewflutter;

import android.webkit.WebSettings;

/* JADX INFO: loaded from: classes3.dex */
public class WebSettingsProxyApi extends PigeonApiWebSettings {

    /* JADX INFO: renamed from: io.flutter.plugins.webviewflutter.WebSettingsProxyApi$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$webviewflutter$MixedContentMode;

        static {
            int[] iArr = new int[MixedContentMode.values().length];
            $SwitchMap$io$flutter$plugins$webviewflutter$MixedContentMode = iArr;
            try {
                iArr[MixedContentMode.ALWAYS_ALLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$MixedContentMode[MixedContentMode.COMPATIBILITY_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$MixedContentMode[MixedContentMode.NEVER_ALLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WebSettingsProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public String getUserAgentString(WebSettings webSettings) {
        return webSettings.getUserAgentString();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setAllowContentAccess(WebSettings webSettings, boolean z4) {
        webSettings.setAllowContentAccess(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setAllowFileAccess(WebSettings webSettings, boolean z4) {
        webSettings.setAllowFileAccess(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setBuiltInZoomControls(WebSettings webSettings, boolean z4) {
        webSettings.setBuiltInZoomControls(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setDisplayZoomControls(WebSettings webSettings, boolean z4) {
        webSettings.setDisplayZoomControls(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setDomStorageEnabled(WebSettings webSettings, boolean z4) {
        webSettings.setDomStorageEnabled(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setGeolocationEnabled(WebSettings webSettings, boolean z4) {
        webSettings.setGeolocationEnabled(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setJavaScriptCanOpenWindowsAutomatically(WebSettings webSettings, boolean z4) {
        webSettings.setJavaScriptCanOpenWindowsAutomatically(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setJavaScriptEnabled(WebSettings webSettings, boolean z4) {
        webSettings.setJavaScriptEnabled(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setLoadWithOverviewMode(WebSettings webSettings, boolean z4) {
        webSettings.setLoadWithOverviewMode(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setMediaPlaybackRequiresUserGesture(WebSettings webSettings, boolean z4) {
        webSettings.setMediaPlaybackRequiresUserGesture(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setMixedContentMode(WebSettings webSettings, MixedContentMode mixedContentMode) {
        int i4 = AnonymousClass1.$SwitchMap$io$flutter$plugins$webviewflutter$MixedContentMode[mixedContentMode.ordinal()];
        if (i4 == 1) {
            webSettings.setMixedContentMode(0);
        } else if (i4 == 2) {
            webSettings.setMixedContentMode(2);
        } else {
            if (i4 != 3) {
                return;
            }
            webSettings.setMixedContentMode(1);
        }
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setSupportMultipleWindows(WebSettings webSettings, boolean z4) {
        webSettings.setSupportMultipleWindows(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setSupportZoom(WebSettings webSettings, boolean z4) {
        webSettings.setSupportZoom(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setTextZoom(WebSettings webSettings, long j4) {
        webSettings.setTextZoom((int) j4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setUseWideViewPort(WebSettings webSettings, boolean z4) {
        webSettings.setUseWideViewPort(z4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setUserAgentString(WebSettings webSettings, String str) {
        webSettings.setUserAgentString(str);
    }
}
