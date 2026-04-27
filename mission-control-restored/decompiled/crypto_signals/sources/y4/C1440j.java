package y4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedActionException;
import java.security.Provider;
import java.security.Security;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import u5.C1250g;

/* JADX INFO: renamed from: y4.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1440j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f11703b = Logger.getLogger(C1440j.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f11704c = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1440j f11705d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider f11706a;

    static {
        Logger logger;
        Object obj;
        int i;
        Provider provider;
        Provider provider2;
        C1440j c1440j;
        int i6;
        int i7 = 17;
        Provider[] providers = Security.getProviders();
        int length = providers.length;
        int i8 = 0;
        loop0: while (true) {
            logger = f11703b;
            obj = null;
            if (i8 >= length) {
                i = 1;
                logger.log(Level.WARNING, "Unable to find Conscrypt");
                provider = null;
                break;
            }
            Provider provider3 = providers[i8];
            for (String str : f11704c) {
                i = 1;
                if (str.equals(provider3.getClass().getName())) {
                    logger.log(Level.FINE, "Found registered provider {0}", str);
                    provider = provider3;
                    break loop0;
                }
            }
            i8++;
        }
        if (provider != null) {
            f.d dVar = new f.d(obj, "setUseSessionTickets", new Class[]{Boolean.TYPE}, i7);
            f.d dVar2 = new f.d(obj, "setHostname", new Class[]{String.class}, i7);
            f.d dVar3 = new f.d(byte[].class, "getAlpnSelectedProtocol", new Class[0], i7);
            f.d dVar4 = new f.d(obj, "setAlpnProtocols", new Class[]{byte[].class}, i7);
            try {
                Class<?> cls = Class.forName("android.net.TrafficStats");
                cls.getMethod("tagSocket", Socket.class);
                cls.getMethod("untagSocket", Socket.class);
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
            }
            if (provider.getName().equals("GmsCore_OpenSSL") || provider.getName().equals("Conscrypt") || provider.getName().equals("Ssl_Guard")) {
                i6 = i;
                c1440j = new C1436f(dVar, dVar2, dVar3, dVar4, provider, i6);
            } else {
                try {
                    C1440j.class.getClassLoader().loadClass("android.net.Network");
                    i6 = i;
                } catch (ClassNotFoundException e) {
                    logger.log(Level.FINE, "Can't find class", (Throwable) e);
                    try {
                        C1440j.class.getClassLoader().loadClass("android.app.ActivityOptions");
                        i6 = 2;
                    } catch (ClassNotFoundException e2) {
                        logger.log(Level.FINE, "Can't find class", (Throwable) e2);
                        i6 = 3;
                    }
                }
                c1440j = new C1436f(dVar, dVar2, dVar3, dVar4, provider, i6);
            }
        } else {
            try {
                Provider provider4 = SSLContext.getDefault().getProvider();
                try {
                    try {
                        SSLContext sSLContext = SSLContext.getInstance("TLS", provider4);
                        sSLContext.init(null, null, null);
                        ((Method) AccessController.doPrivileged(new C1435e(0))).invoke(sSLContext.createSSLEngine(), new Object[0]);
                        c1440j = new C1437g(provider4, (Method) AccessController.doPrivileged(new C1435e(i)), (Method) AccessController.doPrivileged(new C1435e(2)));
                    } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                        provider2 = provider4;
                        c1440j = new C1440j(provider2);
                        f11705d = c1440j;
                    }
                } catch (IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException unused3) {
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    try {
                        c1440j = new C1438h(cls2.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"), provider4);
                    } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                        provider2 = provider4;
                        c1440j = new C1440j(provider2);
                    }
                }
            } catch (NoSuchAlgorithmException e6) {
                throw new RuntimeException(e6);
            }
        }
        f11705d = c1440j;
    }

    public C1440j(Provider provider) {
        this.f11706a = provider;
    }

    public static byte[] b(List list) {
        C1250g c1250g = new C1250g();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            EnumC1441k enumC1441k = (EnumC1441k) list.get(i);
            if (enumC1441k != EnumC1441k.HTTP_1_0) {
                c1250g.B(enumC1441k.f11711a.length());
                c1250g.E(enumC1441k.f11711a);
            }
        }
        return c1250g.n(c1250g.f10526b);
    }

    public String d(SSLSocket sSLSocket) {
        return null;
    }

    public int e() {
        return 3;
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
    }
}
