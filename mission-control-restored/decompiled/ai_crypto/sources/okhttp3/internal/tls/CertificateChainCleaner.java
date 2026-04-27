package okhttp3.internal.tls;

import java.util.List;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CertificateChainCleaner {
    public static CertificateChainCleaner b(X509TrustManager x509TrustManager) {
        return Platform.l().c(x509TrustManager);
    }

    public abstract List a(List list, String str);
}
