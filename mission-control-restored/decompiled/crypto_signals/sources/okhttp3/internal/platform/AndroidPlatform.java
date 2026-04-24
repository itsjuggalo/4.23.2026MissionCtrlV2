package okhttp3.internal.platform;

import android.util.Log;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* JADX INFO: loaded from: classes.dex */
class AndroidPlatform extends Platform {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CloseGuard f8946c;

    public static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f8947a;

        public AndroidCertificateChainCleaner(Object obj, Method method) {
            this.f8947a = obj;
        }

        public final boolean equals(Object obj) {
            return obj instanceof AndroidCertificateChainCleaner;
        }

        public final int hashCode() {
            return 0;
        }
    }

    public static final class AndroidTrustRootIndex implements TrustRootIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X509TrustManager f8948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f8949b;

        public AndroidTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            this.f8949b = method;
            this.f8948a = x509TrustManager;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AndroidTrustRootIndex)) {
                return false;
            }
            AndroidTrustRootIndex androidTrustRootIndex = (AndroidTrustRootIndex) obj;
            return this.f8948a.equals(androidTrustRootIndex.f8948a) && this.f8949b.equals(androidTrustRootIndex.f8949b);
        }

        public final int hashCode() {
            return (this.f8949b.hashCode() * 31) + this.f8948a.hashCode();
        }
    }

    public static final class CloseGuard {
    }

    public AndroidPlatform(OptionalMethod optionalMethod, OptionalMethod optionalMethod2, OptionalMethod optionalMethod3, OptionalMethod optionalMethod4) {
        try {
            Class<?> cls = Class.forName("dalvik.system.CloseGuard");
            cls.getMethod("get", new Class[0]);
            cls.getMethod("open", String.class);
            cls.getMethod("warnIfOpen", new Class[0]);
        } catch (Exception unused) {
        }
        this.f8946c = new CloseGuard();
    }

    @Override // okhttp3.internal.platform.Platform
    public final CertificateChainCleaner a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new AndroidCertificateChainCleaner(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final TrustRootIndex b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new AndroidTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final SSLContext d() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final void e(int i, String str, Throwable th) {
        int iMin;
        int i6 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i7 = 0;
        while (i7 < length) {
            int iIndexOf = str.indexOf(10, i7);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i7 + 4000);
                Log.println(i6, "OkHttp", str.substring(i7, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i7 = iMin;
                }
            }
            i7 = iMin + 1;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final void f(String str) {
        this.f8946c.getClass();
        e(5, str, null);
    }
}
