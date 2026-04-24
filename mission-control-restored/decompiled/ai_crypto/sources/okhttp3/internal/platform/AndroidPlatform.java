package okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* JADX INFO: loaded from: classes2.dex */
class AndroidPlatform extends Platform {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f21057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OptionalMethod f21058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OptionalMethod f21059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OptionalMethod f21060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OptionalMethod f21061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CloseGuard f21062h = CloseGuard.a();

    public static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f21063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f21064b;

        public AndroidCertificateChainCleaner(Object obj, Method method) {
            this.f21063a = obj;
            this.f21064b = method;
        }

        @Override // okhttp3.internal.tls.CertificateChainCleaner
        public List a(List list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f21064b.invoke(this.f21063a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e7) {
                throw new AssertionError(e7);
            } catch (InvocationTargetException e8) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e8.getMessage());
                sSLPeerUnverifiedException.initCause(e8);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof AndroidCertificateChainCleaner;
        }

        public int hashCode() {
            return 0;
        }
    }

    public static final class AndroidTrustRootIndex implements TrustRootIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X509TrustManager f21065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f21066b;

        public AndroidTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            this.f21066b = method;
            this.f21065a = x509TrustManager;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f21066b.invoke(this.f21065a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e7) {
                throw Util.b("unable to get issues and signature", e7);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AndroidTrustRootIndex)) {
                return false;
            }
            AndroidTrustRootIndex androidTrustRootIndex = (AndroidTrustRootIndex) obj;
            return this.f21065a.equals(androidTrustRootIndex.f21065a) && this.f21066b.equals(androidTrustRootIndex.f21066b);
        }

        public int hashCode() {
            return this.f21065a.hashCode() + (this.f21066b.hashCode() * 31);
        }
    }

    public static final class CloseGuard {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f21067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f21068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f21069c;

        public CloseGuard(Method method, Method method2, Method method3) {
            this.f21067a = method;
            this.f21068b = method2;
            this.f21069c = method3;
        }

        public static CloseGuard a() throws NoSuchMethodException {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod(com.amazon.a.a.o.b.au, null);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", null);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new CloseGuard(method3, method2, method);
        }

        public boolean b(Object obj) {
            if (obj != null) {
                try {
                    this.f21069c.invoke(obj, null);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public AndroidPlatform(Class cls, OptionalMethod optionalMethod, OptionalMethod optionalMethod2, OptionalMethod optionalMethod3, OptionalMethod optionalMethod4) {
        this.f21057c = cls;
        this.f21058d = optionalMethod;
        this.f21059e = optionalMethod2;
        this.f21060f = optionalMethod3;
        this.f21061g = optionalMethod4;
    }

    public static Platform w() {
        Class<?> cls;
        OptionalMethod optionalMethod;
        OptionalMethod optionalMethod2;
        if (!Platform.p()) {
            return null;
        }
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            OptionalMethod optionalMethod3 = new OptionalMethod(null, "setUseSessionTickets", Boolean.TYPE);
            OptionalMethod optionalMethod4 = new OptionalMethod(null, "setHostname", String.class);
            if (y()) {
                optionalMethod = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                optionalMethod2 = new OptionalMethod(null, "setAlpnProtocols", byte[].class);
            } else {
                optionalMethod = null;
                optionalMethod2 = null;
            }
            return new AndroidPlatform(cls2, optionalMethod3, optionalMethod4, optionalMethod, optionalMethod2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    public static int x() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    public static boolean y() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public CertificateChainCleaner c(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new AndroidCertificateChainCleaner(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public TrustRootIndex d(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new AndroidTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void g(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.f21058d.e(sSLSocket, Boolean.TRUE);
            this.f21059e.e(sSLSocket, str);
        }
        OptionalMethod optionalMethod = this.f21061g;
        if (optionalMethod == null || !optionalMethod.g(sSLSocket)) {
            return;
        }
        this.f21061g.f(sSLSocket, Platform.e(list));
    }

    @Override // okhttp3.internal.platform.Platform
    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i7) throws IOException {
        try {
            socket.connect(inetSocketAddress, i7);
        } catch (AssertionError e7) {
            if (!Util.z(e7)) {
                throw e7;
            }
            throw new IOException(e7);
        } catch (ClassCastException e8) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e8;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e8);
            throw iOException;
        } catch (SecurityException e9) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e9);
            throw iOException2;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext n() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e7) {
            throw new IllegalStateException("No TLS provider", e7);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String o(SSLSocket sSLSocket) {
        byte[] bArr;
        OptionalMethod optionalMethod = this.f21060f;
        if (optionalMethod == null || !optionalMethod.g(sSLSocket) || (bArr = (byte[]) this.f21060f.f(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, Util.f20679j);
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean q(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return v(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.q(str);
        } catch (IllegalAccessException e7) {
            e = e7;
            throw Util.b("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e8) {
            e = e8;
            throw Util.b("unable to determine cleartext support", e);
        } catch (InvocationTargetException e9) {
            e = e9;
            throw Util.b("unable to determine cleartext support", e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void s(int i7, String str, Throwable th) {
        int iMin;
        int i8 = i7 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i9 = 0;
        while (i9 < length) {
            int iIndexOf = str.indexOf(10, i9);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i9 + 4000);
                Log.println(i8, "OkHttp", str.substring(i9, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i9 = iMin;
                }
            }
            i9 = iMin + 1;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void t(String str, Object obj) {
        if (this.f21062h.b(obj)) {
            return;
        }
        s(5, str, null);
    }

    public final boolean u(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.q(str);
        }
    }

    public final boolean v(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return u(str, cls, obj);
        }
    }
}
