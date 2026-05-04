package vb;

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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f23313b = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f23314c = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f23315d = d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider f23316a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLEngine.class.getMethod("getApplicationProtocol", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLSocket.class.getMethod("getApplicationProtocol", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final vb.g f23317e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final vb.g f23318f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Method f23319g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Method f23320h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final vb.g f23321i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final vb.g f23322j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final EnumC0404h f23323k;

        public d(vb.g gVar, vb.g gVar2, Method method, Method method2, vb.g gVar3, vb.g gVar4, Provider provider, EnumC0404h enumC0404h) {
            super(provider);
            this.f23317e = gVar;
            this.f23318f = gVar2;
            this.f23319g = method;
            this.f23320h = method2;
            this.f23321i = gVar3;
            this.f23322j = gVar4;
            this.f23323k = enumC0404h;
        }

        @Override // vb.h
        public void c(SSLSocket sSLSocket, String str, List list) {
            if (str != null) {
                this.f23317e.e(sSLSocket, Boolean.TRUE);
                this.f23318f.e(sSLSocket, str);
            }
            if (this.f23322j.g(sSLSocket)) {
                this.f23322j.f(sSLSocket, h.b(list));
            }
        }

        @Override // vb.h
        public String h(SSLSocket sSLSocket) {
            byte[] bArr;
            if (this.f23321i.g(sSLSocket) && (bArr = (byte[]) this.f23321i.f(sSLSocket, new Object[0])) != null) {
                return new String(bArr, l.f23355b);
            }
            return null;
        }

        @Override // vb.h
        public EnumC0404h i() {
            return this.f23323k;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Method f23324e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f23325f;

        public /* synthetic */ e(Provider provider, Method method, Method method2, a aVar) {
            this(provider, method, method2);
        }

        @Override // vb.h
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
                this.f23324e.invoke(sSLParameters, arrayList.toArray(new String[arrayList.size()]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Override // vb.h
        public String h(SSLSocket sSLSocket) {
            try {
                return (String) this.f23325f.invoke(sSLSocket, null);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Override // vb.h
        public EnumC0404h i() {
            return EnumC0404h.ALPN_AND_NPN;
        }

        public e(Provider provider, Method method, Method method2) {
            super(provider);
            this.f23324e = method;
            this.f23325f = method2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class f extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Method f23326e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f23327f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Method f23328g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Class f23329h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Class f23330i;

        public f(Method method, Method method2, Method method3, Class cls, Class cls2, Provider provider) {
            super(provider);
            this.f23326e = method;
            this.f23327f = method2;
            this.f23328g = method3;
            this.f23329h = cls;
            this.f23330i = cls2;
        }

        @Override // vb.h
        public void a(SSLSocket sSLSocket) {
            try {
                this.f23328g.invoke(null, sSLSocket);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e10) {
                h.f23313b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", (Throwable) e10);
            }
        }

        @Override // vb.h
        public void c(SSLSocket sSLSocket, String str, List list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                i iVar = (i) list.get(i10);
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                this.f23326e.invoke(null, sSLSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f23329h, this.f23330i}, new g(arrayList)));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }

        @Override // vb.h
        public String h(SSLSocket sSLSocket) {
            try {
                g gVar = (g) Proxy.getInvocationHandler(this.f23327f.invoke(null, sSLSocket));
                if (!gVar.f23332b && gVar.f23333c == null) {
                    h.f23313b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (gVar.f23332b) {
                    return null;
                }
                return gVar.f23333c;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                throw new AssertionError();
            }
        }

        @Override // vb.h
        public EnumC0404h i() {
            return EnumC0404h.ALPN_AND_NPN;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class g implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f23331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f23332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f23333c;

        public g(List list) {
            this.f23331a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = l.f23354a;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f23332b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f23331a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f23331a.contains(list.get(i10))) {
                            String str = (String) list.get(i10);
                            this.f23333c = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f23331a.get(0);
                    this.f23333c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f23333c = (String) objArr[0];
            return null;
        }
    }

    /* JADX INFO: renamed from: vb.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum EnumC0404h {
        ALPN_AND_NPN,
        NPN,
        NONE
    }

    public h(Provider provider) {
        this.f23316a = provider;
    }

    public static byte[] b(List list) {
        hh.d dVar = new hh.d();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = (i) list.get(i10);
            if (iVar != i.HTTP_1_0) {
                dVar.writeByte(iVar.toString().length());
                dVar.x(iVar.toString());
            }
        }
        return dVar.O();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [vb.h$a] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.reflect.Method] */
    public static h d() {
        Method method;
        Provider providerF = f();
        ?? method2 = 0;
        method2 = 0;
        if (providerF != null) {
            vb.g gVar = new vb.g(null, "setUseSessionTickets", Boolean.TYPE);
            vb.g gVar2 = new vb.g(null, "setHostname", String.class);
            vb.g gVar3 = new vb.g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            vb.g gVar4 = new vb.g(null, "setAlpnProtocols", byte[].class);
            try {
                Class<?> cls = Class.forName("android.net.TrafficStats");
                method = cls.getMethod("tagSocket", Socket.class);
                try {
                    method2 = cls.getMethod("untagSocket", Socket.class);
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                method = null;
            }
            Method method3 = method;
            ?? r72 = method2;
            EnumC0404h enumC0404h = (providerF.getName().equals("GmsCore_OpenSSL") || providerF.getName().equals("Conscrypt") || providerF.getName().equals("Ssl_Guard") || k()) ? EnumC0404h.ALPN_AND_NPN : j() ? EnumC0404h.NPN : EnumC0404h.NONE;
            return new d(gVar, gVar2, method3, r72, gVar3, gVar4, providerF, enumC0404h);
        }
        try {
            Provider provider = SSLContext.getDefault().getProvider();
            try {
                try {
                    SSLContext sSLContext = SSLContext.getInstance("TLS", provider);
                    sSLContext.init(null, null, null);
                    ((Method) AccessController.doPrivileged(new a())).invoke(sSLContext.createSSLEngine(), null);
                    return new e(provider, (Method) AccessController.doPrivileged(new b()), (Method) AccessController.doPrivileged(new c()), method2);
                } catch (IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException unused3) {
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                    return new f(cls2.getMethod("put", SSLSocket.class, cls3), cls2.getMethod(com.amazon.a.a.o.b.au, SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"), provider);
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                return new h(provider);
            }
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static h e() {
        return f23315d;
    }

    public static Provider f() {
        for (Provider provider : Security.getProviders()) {
            for (String str : f23314c) {
                if (str.equals(provider.getClass().getName())) {
                    f23313b.log(Level.FINE, "Found registered provider {0}", str);
                    return provider;
                }
            }
        }
        f23313b.log(Level.WARNING, "Unable to find Conscrypt");
        return null;
    }

    public static boolean j() {
        try {
            h.class.getClassLoader().loadClass("android.app.ActivityOptions");
            return true;
        } catch (ClassNotFoundException e10) {
            f23313b.log(Level.FINE, "Can't find class", (Throwable) e10);
            return false;
        }
    }

    public static boolean k() {
        try {
            h.class.getClassLoader().loadClass("android.net.Network");
            return true;
        } catch (ClassNotFoundException e10) {
            f23313b.log(Level.FINE, "Can't find class", (Throwable) e10);
            return false;
        }
    }

    public Provider g() {
        return this.f23316a;
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public EnumC0404h i() {
        return EnumC0404h.NONE;
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
    }
}
