package v5;

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
import w6.C2792e;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f24892b = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f24893c = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f24894d = d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider f24895a;

    public class a implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLEngine.class.getMethod("getApplicationProtocol", null);
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
            return SSLSocket.class.getMethod("getApplicationProtocol", null);
        }
    }

    public static class d extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final v5.g f24896e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final v5.g f24897f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Method f24898g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Method f24899h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final v5.g f24900i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final v5.g f24901j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final EnumC0389h f24902k;

        public d(v5.g gVar, v5.g gVar2, Method method, Method method2, v5.g gVar3, v5.g gVar4, Provider provider, EnumC0389h enumC0389h) {
            super(provider);
            this.f24896e = gVar;
            this.f24897f = gVar2;
            this.f24898g = method;
            this.f24899h = method2;
            this.f24900i = gVar3;
            this.f24901j = gVar4;
            this.f24902k = enumC0389h;
        }

        @Override // v5.h
        public void c(SSLSocket sSLSocket, String str, List list) {
            if (str != null) {
                this.f24896e.e(sSLSocket, Boolean.TRUE);
                this.f24897f.e(sSLSocket, str);
            }
            if (this.f24901j.g(sSLSocket)) {
                this.f24901j.f(sSLSocket, h.b(list));
            }
        }

        @Override // v5.h
        public String h(SSLSocket sSLSocket) {
            byte[] bArr;
            if (this.f24900i.g(sSLSocket) && (bArr = (byte[]) this.f24900i.f(sSLSocket, new Object[0])) != null) {
                return new String(bArr, l.f24934b);
            }
            return null;
        }

        @Override // v5.h
        public EnumC0389h i() {
            return this.f24902k;
        }
    }

    public static class e extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Method f24903e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f24904f;

        public /* synthetic */ e(Provider provider, Method method, Method method2, a aVar) {
            this(provider, method, method2);
        }

        @Override // v5.h
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
                this.f24903e.invoke(sSLParameters, arrayList.toArray(new String[arrayList.size()]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalAccessException e7) {
                throw new RuntimeException(e7);
            } catch (InvocationTargetException e8) {
                throw new RuntimeException(e8);
            }
        }

        @Override // v5.h
        public String h(SSLSocket sSLSocket) {
            try {
                return (String) this.f24904f.invoke(sSLSocket, null);
            } catch (IllegalAccessException e7) {
                throw new RuntimeException(e7);
            } catch (InvocationTargetException e8) {
                throw new RuntimeException(e8);
            }
        }

        @Override // v5.h
        public EnumC0389h i() {
            return EnumC0389h.ALPN_AND_NPN;
        }

        public e(Provider provider, Method method, Method method2) {
            super(provider);
            this.f24903e = method;
            this.f24904f = method2;
        }
    }

    public static class f extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Method f24905e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f24906f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Method f24907g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Class f24908h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Class f24909i;

        public f(Method method, Method method2, Method method3, Class cls, Class cls2, Provider provider) {
            super(provider);
            this.f24905e = method;
            this.f24906f = method2;
            this.f24907g = method3;
            this.f24908h = cls;
            this.f24909i = cls2;
        }

        @Override // v5.h
        public void a(SSLSocket sSLSocket) {
            try {
                this.f24907g.invoke(null, sSLSocket);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e7) {
                h.f24892b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", (Throwable) e7);
            }
        }

        @Override // v5.h
        public void c(SSLSocket sSLSocket, String str, List list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                i iVar = (i) list.get(i7);
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                this.f24905e.invoke(null, sSLSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f24908h, this.f24909i}, new g(arrayList)));
            } catch (IllegalAccessException e7) {
                throw new AssertionError(e7);
            } catch (InvocationTargetException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // v5.h
        public String h(SSLSocket sSLSocket) {
            try {
                g gVar = (g) Proxy.getInvocationHandler(this.f24906f.invoke(null, sSLSocket));
                if (!gVar.f24911b && gVar.f24912c == null) {
                    h.f24892b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (gVar.f24911b) {
                    return null;
                }
                return gVar.f24912c;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                throw new AssertionError();
            }
        }

        @Override // v5.h
        public EnumC0389h i() {
            return EnumC0389h.ALPN_AND_NPN;
        }
    }

    public static class g implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f24910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f24911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f24912c;

        public g(List list) {
            this.f24910a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = l.f24933a;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f24911b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f24910a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        if (this.f24910a.contains(list.get(i7))) {
                            String str = (String) list.get(i7);
                            this.f24912c = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f24910a.get(0);
                    this.f24912c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f24912c = (String) objArr[0];
            return null;
        }
    }

    /* JADX INFO: renamed from: v5.h$h, reason: collision with other inner class name */
    public enum EnumC0389h {
        ALPN_AND_NPN,
        NPN,
        NONE
    }

    public h(Provider provider) {
        this.f24895a = provider;
    }

    public static byte[] b(List list) {
        C2792e c2792e = new C2792e();
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            i iVar = (i) list.get(i7);
            if (iVar != i.HTTP_1_0) {
                c2792e.v(iVar.toString().length());
                c2792e.I(iVar.toString());
            }
        }
        return c2792e.z0();
    }

    public static h d() throws NoSuchMethodException {
        Method method;
        Method method2;
        Method method3;
        Provider providerF = f();
        a aVar = null;
        if (providerF != null) {
            v5.g gVar = new v5.g(null, "setUseSessionTickets", Boolean.TYPE);
            v5.g gVar2 = new v5.g(null, "setHostname", String.class);
            v5.g gVar3 = new v5.g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            v5.g gVar4 = new v5.g(null, "setAlpnProtocols", byte[].class);
            try {
                Class<?> cls = Class.forName("android.net.TrafficStats");
                method = cls.getMethod("tagSocket", Socket.class);
                try {
                    method3 = cls.getMethod("untagSocket", Socket.class);
                    method2 = method;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    method2 = method;
                    method3 = null;
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                method = null;
            }
            EnumC0389h enumC0389h = (providerF.getName().equals("GmsCore_OpenSSL") || providerF.getName().equals("Conscrypt") || providerF.getName().equals("Ssl_Guard") || k()) ? EnumC0389h.ALPN_AND_NPN : j() ? EnumC0389h.NPN : EnumC0389h.NONE;
            return new d(gVar, gVar2, method2, method3, gVar3, gVar4, providerF, enumC0389h);
        }
        try {
            Provider provider = SSLContext.getDefault().getProvider();
            try {
                try {
                    SSLContext sSLContext = SSLContext.getInstance("TLS", provider);
                    sSLContext.init(null, null, null);
                    ((Method) AccessController.doPrivileged(new a())).invoke(sSLContext.createSSLEngine(), null);
                    return new e(provider, (Method) AccessController.doPrivileged(new b()), (Method) AccessController.doPrivileged(new c()), aVar);
                } catch (IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException unused3) {
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                    return new f(cls2.getMethod("put", SSLSocket.class, cls3), cls2.getMethod(com.amazon.a.a.o.b.au, SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"), provider);
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                return new h(provider);
            }
        } catch (NoSuchAlgorithmException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static h e() {
        return f24894d;
    }

    public static Provider f() {
        for (Provider provider : Security.getProviders()) {
            for (String str : f24893c) {
                if (str.equals(provider.getClass().getName())) {
                    f24892b.log(Level.FINE, "Found registered provider {0}", str);
                    return provider;
                }
            }
        }
        f24892b.log(Level.WARNING, "Unable to find Conscrypt");
        return null;
    }

    public static boolean j() {
        try {
            h.class.getClassLoader().loadClass("android.app.ActivityOptions");
            return true;
        } catch (ClassNotFoundException e7) {
            f24892b.log(Level.FINE, "Can't find class", (Throwable) e7);
            return false;
        }
    }

    public static boolean k() {
        try {
            h.class.getClassLoader().loadClass("android.net.Network");
            return true;
        } catch (ClassNotFoundException e7) {
            f24892b.log(Level.FINE, "Can't find class", (Throwable) e7);
            return false;
        }
    }

    public Provider g() {
        return this.f24895a;
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public EnumC0389h i() {
        return EnumC0389h.NONE;
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
    }
}
