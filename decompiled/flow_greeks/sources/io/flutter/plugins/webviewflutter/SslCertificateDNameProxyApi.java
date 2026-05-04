package io.flutter.plugins.webviewflutter;

import android.net.http.SslCertificate;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
class SslCertificateDNameProxyApi extends PigeonApiSslCertificateDName {
    public SslCertificateDNameProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificateDName
    public String getCName(SslCertificate.DName dName) {
        return dName.getCName();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificateDName
    public String getDName(SslCertificate.DName dName) {
        return dName.getDName();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificateDName
    public String getOName(SslCertificate.DName dName) {
        return dName.getOName();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificateDName
    public String getUName(SslCertificate.DName dName) {
        return dName.getUName();
    }
}
