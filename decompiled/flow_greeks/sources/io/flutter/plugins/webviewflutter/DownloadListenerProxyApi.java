package io.flutter.plugins.webviewflutter;

import android.webkit.DownloadListener;
import cd.r;
import io.flutter.plugins.webviewflutter.DownloadListenerProxyApi;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class DownloadListenerProxyApi extends PigeonApiDownloadListener {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class DownloadListenerImpl implements DownloadListener {
        private final DownloadListenerProxyApi api;

        public DownloadListenerImpl(DownloadListenerProxyApi downloadListenerProxyApi) {
            this.api = downloadListenerProxyApi;
        }

        public static /* synthetic */ cd.h0 a(r rVar) {
            return null;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(final String str, final String str2, final String str3, final String str4, final long j10) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.n0
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadListenerProxyApi.DownloadListenerImpl downloadListenerImpl = this.f13366a;
                    downloadListenerImpl.api.onDownloadStart(downloadListenerImpl, str, str2, str3, str4, j10, new pd.k() { // from class: io.flutter.plugins.webviewflutter.m0
                        @Override // pd.k
                        public final Object invoke(Object obj) {
                            return DownloadListenerProxyApi.DownloadListenerImpl.a((r) obj);
                        }
                    });
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
