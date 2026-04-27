package O2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f3261b = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f3262c = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f3263d = d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider f3264a;

    public class a implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLEngine.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    public class b implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
        }
    }

    public class c implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    public static class d extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final O2.g f3265e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final O2.g f3266f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Method f3267g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Method f3268h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final O2.g f3269i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final O2.g f3270j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final EnumC0054h f3271k;

        public d(O2.g gVar, O2.g gVar2, Method method, Method method2, O2.g gVar3, O2.g gVar4, Provider provider, EnumC0054h enumC0054h) {
            super(provider);
            this.f3265e = gVar;
            this.f3266f = gVar2;
            this.f3267g = method;
            this.f3268h = method2;
            this.f3269i = gVar3;
            this.f3270j = gVar4;
            this.f3271k = enumC0054h;
        }

        @Override // O2.h
        public void c(SSLSocket sSLSocket, String str, List list) {
            if (str != null) {
                this.f3265e.e(sSLSocket, Boolean.TRUE);
                this.f3266f.e(sSLSocket, str);
            }
            if (this.f3270j.g(sSLSocket)) {
                this.f3270j.f(sSLSocket, h.b(list));
            }
        }

        @Override // O2.h
        public String h(SSLSocket sSLSocket) {
            byte[] bArr;
            if (this.f3269i.g(sSLSocket) && (bArr = (byte[]) this.f3269i.f(sSLSocket, new Object[0])) != null) {
                return new String(bArr, l.f3303b);
            }
            return null;
        }

        @Override // O2.h
        public EnumC0054h i() {
            return this.f3271k;
        }
    }

    public static class e extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Method f3272e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f3273f;

        public /* synthetic */ e(Provider provider, Method method, Method method2, a aVar) {
            this(provider, method, method2);
        }

        @Override // O2.h
        public void c(SSLSocket sSLSocket, String str, List list) {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                this.f3272e.invoke(sSLParameters, arrayList.toArray(new String[arrayList.size()]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException(e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException(e5);
            }
        }

        @Override // O2.h
        public String h(SSLSocket sSLSocket) {
            try {
                return (String) this.f3273f.invoke(sSLSocket, new Object[0]);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException(e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException(e5);
            }
        }

        @Override // O2.h
        public EnumC0054h i() {
            return EnumC0054h.ALPN_AND_NPN;
        }

        public e(Provider provider, Method method, Method method2) {
            super(provider);
            this.f3272e = method;
            this.f3273f = method2;
        }
    }

    public static class f extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Method f3274e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f3275f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Method f3276g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Class f3277h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Class f3278i;

        public f(Method method, Method method2, Method method3, Class cls, Class cls2, Provider provider) {
            super(provider);
            this.f3274e = method;
            this.f3275f = method2;
            this.f3276g = method3;
            this.f3277h = cls;
            this.f3278i = cls2;
        }

        @Override // O2.h
        public void a(SSLSocket sSLSocket) {
            try {
                this.f3276g.invoke(null, sSLSocket);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e4) {
                h.f3261b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", (Throwable) e4);
            }
        }

        @Override // O2.h
        public void c(SSLSocket sSLSocket, String str, List list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                i iVar = (i) list.get(i4);
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                this.f3274e.invoke(null, sSLSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f3277h, this.f3278i}, new g(arrayList)));
            } catch (IllegalAccessException e4) {
                throw new AssertionError(e4);
            } catch (InvocationTargetException e5) {
                throw new AssertionError(e5);
            }
        }

        @Override // O2.h
        public String h(SSLSocket sSLSocket) {
            try {
                g gVar = (g) Proxy.getInvocationHandler(this.f3275f.invoke(null, sSLSocket));
                if (!gVar.f3280b && gVar.f3281c == null) {
                    h.f3261b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (gVar.f3280b) {
                    return null;
                }
                return gVar.f3281c;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                throw new AssertionError();
            }
        }

        @Override // O2.h
        public EnumC0054h i() {
            return EnumC0054h.ALPN_AND_NPN;
        }
    }

    public static class g implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f3279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3280b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3281c;

        public g(List list) {
            this.f3279a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = l.f3302a;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f3280b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f3279a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        if (this.f3279a.contains(list.get(i4))) {
                            String str = (String) list.get(i4);
                            this.f3281c = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f3279a.get(0);
                    this.f3281c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f3281c = (String) objArr[0];
            return null;
        }
    }

    /* JADX INFO: renamed from: O2.h$h, reason: collision with other inner class name */
    public enum EnumC0054h {
        ALPN_AND_NPN,
        NPN,
        NONE
    }

    public h(Provider provider) {
        this.f3264a = provider;
    }

    public static byte[] b(List list) {
        O3.d dVar = new O3.d();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            i iVar = (i) list.get(i4);
            if (iVar != i.HTTP_1_0) {
                dVar.s(iVar.toString().length());
                dVar.y(iVar.toString());
            }
        }
        return dVar.K();
    }

    public static h d() throws NoSuchMethodException {
        Method method;
        Method method2;
        Provider providerF = f();
        a aVar = null;
        if (providerF != null) {
            O2.g gVar = new O2.g(null, "setUseSessionTickets", Boolean.TYPE);
            O2.g gVar2 = new O2.g(null, "setHostname", String.class);
            O2.g gVar3 = new O2.g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            O2.g gVar4 = new O2.g(null, "setAlpnProtocols", byte[].class);
            try {
                Class<?> cls = Class.forName("android.net.TrafficStats");
                method = cls.getMethod("tagSocket", Socket.class);
                try {
                    method2 = cls.getMethod("untagSocket", Socket.class);
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    method2 = null;
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                method = null;
            }
            Method method3 = method;
            EnumC0054h enumC0054h = (providerF.getName().equals("GmsCore_OpenSSL") || providerF.getName().equals("Conscrypt") || providerF.getName().equals("Ssl_Guard") || k()) ? EnumC0054h.ALPN_AND_NPN : j() ? EnumC0054h.NPN : EnumC0054h.NONE;
            return new d(gVar, gVar2, method3, method2, gVar3, gVar4, providerF, enumC0054h);
        }
        try {
            Provider provider = SSLContext.getDefault().getProvider();
            try {
                try {
                    SSLContext sSLContext = SSLContext.getInstance("TLS", provider);
                    sSLContext.init(null, null, null);
                    ((Method) AccessController.doPrivileged(new a())).invoke(sSLContext.createSSLEngine(), new Object[0]);
                    return new e(provider, (Method) AccessController.doPrivileged(new b()), (Method) AccessController.doPrivileged(new c()), aVar);
                } catch (IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException unused3) {
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                    return new f(cls2.getMethod("put", SSLSocket.class, cls3), cls2.getMethod(com.amazon.a.a.o.b.au, SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"), provider);
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                return new h(provider);
            }
        } catch (NoSuchAlgorithmException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static h e() {
        return f3263d;
    }

    public static Provider f() {
        for (Provider provider : Security.getProviders()) {
            for (String str : f3262c) {
                if (str.equals(provider.getClass().getName())) {
                    f3261b.log(Level.FINE, "Found registered provider {0}", str);
                    return provider;
                }
            }
        }
        f3261b.log(Level.WARNING, "Unable to find Conscrypt");
        return null;
    }

    public static boolean j() {
        try {
            h.class.getClassLoader().loadClass("android.app.ActivityOptions");
            return true;
        } catch (ClassNotFoundException e4) {
            f3261b.log(Level.FINE, "Can't find class", (Throwable) e4);
            return false;
        }
    }

    public static boolean k() {
        try {
            h.class.getClassLoader().loadClass("android.net.Network");
            return true;
        } catch (ClassNotFoundException e4) {
            f3261b.log(Level.FINE, "Can't find class", (Throwable) e4);
            return false;
        }
    }

    public Provider g() {
        return this.f3264a;
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public EnumC0054h i() {
        return EnumC0054h.NONE;
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
    }
}
