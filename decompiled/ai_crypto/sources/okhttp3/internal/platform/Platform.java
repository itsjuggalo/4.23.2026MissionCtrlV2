package okhttp3.internal.platform;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import w6.C2792e;

/* JADX INFO: loaded from: classes2.dex */
public class Platform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Platform f21083a = k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f21084b = Logger.getLogger(OkHttpClient.class.getName());

    public static List b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            Protocol protocol = (Protocol) list.get(i7);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public static byte[] e(List list) {
        C2792e c2792e = new C2792e();
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            Protocol protocol = (Protocol) list.get(i7);
            if (protocol != Protocol.HTTP_1_0) {
                c2792e.v(protocol.toString().length());
                c2792e.I(protocol.toString());
            }
        }
        return c2792e.z0();
    }

    public static Platform i() {
        Platform platformW = Android10Platform.w();
        if (platformW != null) {
            return platformW;
        }
        Platform platformW2 = AndroidPlatform.w();
        if (platformW2 != null) {
            return platformW2;
        }
        throw new NullPointerException("No platform found on Android");
    }

    public static Platform j() {
        ConscryptPlatform conscryptPlatformU;
        if (r() && (conscryptPlatformU = ConscryptPlatform.u()) != null) {
            return conscryptPlatformU;
        }
        Jdk9Platform jdk9PlatformU = Jdk9Platform.u();
        if (jdk9PlatformU != null) {
            return jdk9PlatformU;
        }
        Platform platformU = JdkWithJettyBootPlatform.u();
        return platformU != null ? platformU : new Platform();
    }

    public static Platform k() {
        return p() ? i() : j();
    }

    public static Platform l() {
        return f21083a;
    }

    public static boolean p() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public static boolean r() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public void a(SSLSocket sSLSocket) {
    }

    public CertificateChainCleaner c(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(d(x509TrustManager));
    }

    public TrustRootIndex d(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public void f(SSLSocketFactory sSLSocketFactory) {
    }

    public void g(SSLSocket sSLSocket, String str, List list) {
    }

    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i7) throws IOException {
        socket.connect(inetSocketAddress, i7);
    }

    public String m() {
        return "OkHttp";
    }

    public SSLContext n() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e7) {
            throw new IllegalStateException("No TLS provider", e7);
        }
    }

    public String o(SSLSocket sSLSocket) {
        return null;
    }

    public boolean q(String str) {
        return true;
    }

    public void s(int i7, String str, Throwable th) {
        f21084b.log(i7 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void t(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        s(5, str, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
