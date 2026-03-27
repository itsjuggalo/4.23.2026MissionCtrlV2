package I4;

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
import u7.C2811d;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f4247b = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f4248c = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f4249d = d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider f4250a;

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
        public final I4.g f4251e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final I4.g f4252f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Method f4253g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Method f4254h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final I4.g f4255i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final I4.g f4256j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final EnumC0053h f4257k;

        public d(I4.g gVar, I4.g gVar2, Method method, Method method2, I4.g gVar3, I4.g gVar4, Provider provider, EnumC0053h enumC0053h) {
            super(provider);
            this.f4251e = gVar;
            this.f4252f = gVar2;
            this.f4253g = method;
            this.f4254h = method2;
            this.f4255i = gVar3;
            this.f4256j = gVar4;
            this.f4257k = enumC0053h;
        }

        @Override // I4.h
        public void c(SSLSocket sSLSocket, String str, List list) {
            if (str != null) {
                this.f4251e.e(sSLSocket, Boolean.TRUE);
                this.f4252f.e(sSLSocket, str);
            }
            if (this.f4256j.g(sSLSocket)) {
                this.f4256j.f(sSLSocket, h.b(list));
            }
        }

        @Override // I4.h
        public String h(SSLSocket sSLSocket) {
            byte[] bArr;
            if (this.f4255i.g(sSLSocket) && (bArr = (byte[]) this.f4255i.f(sSLSocket, new Object[0])) != null) {
                return new String(bArr, l.f4289b);
            }
            return null;
        }

        @Override // I4.h
        public EnumC0053h i() {
            return this.f4257k;
        }
    }

    public static class e extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Method f4258e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f4259f;

        public e(Provider provider, Method method, Method method2) {
            super(provider);
            this.f4258e = method;
            this.f4259f = method2;
        }

        @Override // I4.h
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
                this.f4258e.invoke(sSLParameters, arrayList.toArray(new String[arrayList.size()]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalAccessException e8) {
                throw new RuntimeException(e8);
            } catch (InvocationTargetException e9) {
                throw new RuntimeException(e9);
            }
        }

        @Override // I4.h
        public String h(SSLSocket sSLSocket) {
            try {
                return (String) this.f4259f.invoke(sSLSocket, null);
            } catch (IllegalAccessException e8) {
                throw new RuntimeException(e8);
            } catch (InvocationTargetException e9) {
                throw new RuntimeException(e9);
            }
        }

        @Override // I4.h
        public EnumC0053h i() {
            return EnumC0053h.ALPN_AND_NPN;
        }

        public /* synthetic */ e(Provider provider, Method method, Method method2, a aVar) {
            this(provider, method, method2);
        }
    }

    public static class f extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Method f4260e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f4261f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Method f4262g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Class f4263h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Class f4264i;

        public f(Method method, Method method2, Method method3, Class cls, Class cls2, Provider provider) {
            super(provider);
            this.f4260e = method;
            this.f4261f = method2;
            this.f4262g = method3;
            this.f4263h = cls;
            this.f4264i = cls2;
        }

        @Override // I4.h
        public void a(SSLSocket sSLSocket) {
            try {
                this.f4262g.invoke(null, sSLSocket);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e8) {
                h.f4247b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", (Throwable) e8);
            }
        }

        @Override // I4.h
        public void c(SSLSocket sSLSocket, String str, List list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                i iVar = (i) list.get(i8);
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                this.f4260e.invoke(null, sSLSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f4263h, this.f4264i}, new g(arrayList)));
            } catch (IllegalAccessException e8) {
                throw new AssertionError(e8);
            } catch (InvocationTargetException e9) {
                throw new AssertionError(e9);
            }
        }

        @Override // I4.h
        public String h(SSLSocket sSLSocket) {
            try {
                g gVar = (g) Proxy.getInvocationHandler(this.f4261f.invoke(null, sSLSocket));
                if (!gVar.f4266b && gVar.f4267c == null) {
                    h.f4247b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (gVar.f4266b) {
                    return null;
                }
                return gVar.f4267c;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                throw new AssertionError();
            }
        }

        @Override // I4.h
        public EnumC0053h i() {
            return EnumC0053h.ALPN_AND_NPN;
        }
    }

    public static class g implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f4265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f4267c;

        public g(List list) {
            this.f4265a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = l.f4288a;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f4266b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f4265a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj3 = objArr[0];
                if (obj3 instanceof List) {
                    List list = (List) obj3;
                    int size = list.size();
                    int i8 = 0;
                    while (true) {
                        if (i8 >= size) {
                            obj2 = this.f4265a.get(0);
                            break;
                        }
                        if (this.f4265a.contains(list.get(i8))) {
                            obj2 = list.get(i8);
                            break;
                        }
                        i8++;
                    }
                    String str = (String) obj2;
                    this.f4267c = str;
                    return str;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f4267c = (String) objArr[0];
            return null;
        }
    }

    /* JADX INFO: renamed from: I4.h$h, reason: collision with other inner class name */
    public enum EnumC0053h {
        ALPN_AND_NPN,
        NPN,
        NONE
    }

    public h(Provider provider) {
        this.f4250a = provider;
    }

    public static byte[] b(List list) {
        C2811d c2811d = new C2811d();
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            i iVar = (i) list.get(i8);
            if (iVar != i.HTTP_1_0) {
                c2811d.x(iVar.toString().length());
                c2811d.G(iVar.toString());
            }
        }
        return c2811d.S();
    }

    public static h d() throws NoSuchMethodException {
        Method method;
        Method method2;
        Method method3;
        Provider providerF = f();
        a aVar = null;
        if (providerF != null) {
            I4.g gVar = new I4.g(null, "setUseSessionTickets", Boolean.TYPE);
            I4.g gVar2 = new I4.g(null, "setHostname", String.class);
            I4.g gVar3 = new I4.g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            I4.g gVar4 = new I4.g(null, "setAlpnProtocols", byte[].class);
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
            return new d(gVar, gVar2, method2, method3, gVar3, gVar4, providerF, (providerF.getName().equals("GmsCore_OpenSSL") || providerF.getName().equals("Conscrypt") || providerF.getName().equals("Ssl_Guard") || k()) ? EnumC0053h.ALPN_AND_NPN : j() ? EnumC0053h.NPN : EnumC0053h.NONE);
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
        } catch (NoSuchAlgorithmException e8) {
            throw new RuntimeException(e8);
        }
    }

    public static h e() {
        return f4249d;
    }

    public static Provider f() {
        for (Provider provider : Security.getProviders()) {
            for (String str : f4248c) {
                if (str.equals(provider.getClass().getName())) {
                    f4247b.log(Level.FINE, "Found registered provider {0}", str);
                    return provider;
                }
            }
        }
        f4247b.log(Level.WARNING, "Unable to find Conscrypt");
        return null;
    }

    public static boolean j() {
        try {
            h.class.getClassLoader().loadClass("android.app.ActivityOptions");
            return true;
        } catch (ClassNotFoundException e8) {
            f4247b.log(Level.FINE, "Can't find class", (Throwable) e8);
            return false;
        }
    }

    public static boolean k() {
        try {
            h.class.getClassLoader().loadClass("android.net.Network");
            return true;
        } catch (ClassNotFoundException e8) {
            f4247b.log(Level.FINE, "Can't find class", (Throwable) e8);
            return false;
        }
    }

    public Provider g() {
        return this.f4250a;
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public EnumC0053h i() {
        return EnumC0053h.NONE;
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
    }
}
