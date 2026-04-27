package io.flutter.plugins.webviewflutter;

import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

/* JADX INFO: loaded from: classes3.dex */
class CertificateProxyApi extends PigeonApiCertificate {
    public CertificateProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCertificate
    public byte[] getEncoded(Certificate certificate) {
        try {
            return certificate.getEncoded();
        } catch (CertificateEncodingException e4) {
            throw new RuntimeException(e4);
        }
    }
}
