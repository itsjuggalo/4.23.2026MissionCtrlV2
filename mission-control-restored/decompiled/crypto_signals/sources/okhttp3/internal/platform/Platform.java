package okhttp3.internal.platform;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* JADX INFO: loaded from: classes.dex */
public class Platform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Platform f8950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f8951b;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    static {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.Platform.<clinit>():void");
    }

    public CertificateChainCleaner a(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(b(x509TrustManager));
    }

    public TrustRootIndex b(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public void c(SSLSocketFactory sSLSocketFactory) {
    }

    public SSLContext d() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public void e(int i, String str, Throwable th) {
        f8951b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void f(String str) {
        e(5, str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);", null);
    }

    public final String toString() {
        return getClass().getSimpleName();
    }
}
