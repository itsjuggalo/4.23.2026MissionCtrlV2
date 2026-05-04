package io.flutter.plugins.webviewflutter;

import android.webkit.ClientCertRequest;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
class ClientCertRequestProxyApi extends PigeonApiClientCertRequest {
    public ClientCertRequestProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiClientCertRequest
    public void cancel(ClientCertRequest clientCertRequest) {
        clientCertRequest.cancel();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiClientCertRequest
    public void ignore(ClientCertRequest clientCertRequest) {
        clientCertRequest.ignore();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiClientCertRequest
    public void proceed(ClientCertRequest clientCertRequest, PrivateKey privateKey, List<? extends X509Certificate> list) {
        clientCertRequest.proceed(privateKey, (X509Certificate[]) list.toArray(new X509Certificate[0]));
    }
}
