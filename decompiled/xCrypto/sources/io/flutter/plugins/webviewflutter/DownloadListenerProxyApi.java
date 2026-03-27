package io.flutter.plugins.webviewflutter;

import android.webkit.DownloadListener;
import io.flutter.plugins.webviewflutter.DownloadListenerProxyApi;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadListenerProxyApi extends PigeonApiDownloadListener {

    public static class DownloadListenerImpl implements DownloadListener {
        private final DownloadListenerProxyApi api;

        public DownloadListenerImpl(DownloadListenerProxyApi downloadListenerProxyApi) {
            this.api = downloadListenerProxyApi;
        }

        public static /* synthetic */ W2.E a(W2.p pVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDownloadStart$1(String str, String str2, String str3, String str4, long j4) {
            this.api.onDownloadStart(this, str, str2, str3, str4, j4, new i3.k() { // from class: io.flutter.plugins.webviewflutter.K
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return DownloadListenerProxyApi.DownloadListenerImpl.a((W2.p) obj);
                }
            });
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(final String str, final String str2, final String str3, final String str4, final long j4) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.L
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12864a.lambda$onDownloadStart$1(str, str2, str3, str4, j4);
                }
            });
        }
    }

    public DownloadListenerProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiDownloadListener
    public DownloadListener pigeon_defaultConstructor() {
        return new DownloadListenerImpl(this);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiDownloadListener
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
