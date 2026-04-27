package u5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import t5.S;
import v5.h;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f24653b = Logger.getLogger(k.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v5.h f24654c = v5.h.e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static k f24655d = d(k.class.getClassLoader());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v5.h f24656a;

    public static final class a extends k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final v5.g f24657e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final v5.g f24658f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final v5.g f24659g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final v5.g f24660h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final v5.g f24661i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final v5.g f24662j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final Method f24663k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final Method f24664l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final Method f24665m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final Method f24666n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final Method f24667o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final Method f24668p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final Constructor f24669q;

        static {
            Method method;
            Method method2;
            Method method3;
            Method method4;
            Method method5;
            Method method6;
            Class cls = Boolean.TYPE;
            Constructor<?> constructor = null;
            f24657e = new v5.g(null, "setUseSessionTickets", cls);
            f24658f = new v5.g(null, "setHostname", String.class);
            f24659g = new v5.g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            f24660h = new v5.g(null, "setAlpnProtocols", byte[].class);
            f24661i = new v5.g(byte[].class, "getNpnSelectedProtocol", new Class[0]);
            f24662j = new v5.g(null, "setNpnProtocols", byte[].class);
            try {
                method = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
            } catch (ClassNotFoundException e7) {
                e = e7;
                method = null;
                method2 = null;
            } catch (NoSuchMethodException e8) {
                e = e8;
                method = null;
                method2 = null;
            }
            try {
                method2 = SSLParameters.class.getMethod("getApplicationProtocols", null);
            } catch (ClassNotFoundException e9) {
                e = e9;
                method2 = null;
                method3 = method2;
                method4 = method3;
                k.f24653b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                f24665m = method;
                f24666n = method2;
                f24667o = method3;
                f24663k = method4;
                f24664l = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                try {
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                } catch (ClassNotFoundException e10) {
                    e = e10;
                    k.f24653b.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
                } catch (NoSuchMethodException e11) {
                    e = e11;
                    k.f24653b.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
                }
                f24668p = method6;
                f24669q = constructor;
            } catch (NoSuchMethodException e12) {
                e = e12;
                method2 = null;
                method3 = method2;
                method4 = method3;
                k.f24653b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                f24665m = method;
                f24666n = method2;
                f24667o = method3;
                f24663k = method4;
                f24664l = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                f24668p = method6;
                f24669q = constructor;
            }
            try {
                method3 = SSLSocket.class.getMethod("getApplicationProtocol", null);
                try {
                    Class<?> cls2 = Class.forName("android.net.ssl.SSLSockets");
                    method4 = cls2.getMethod("isSupportedSocket", SSLSocket.class);
                    try {
                        method5 = cls2.getMethod("setUseSessionTickets", SSLSocket.class, cls);
                    } catch (ClassNotFoundException e13) {
                        e = e13;
                        k.f24653b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                        method5 = null;
                    } catch (NoSuchMethodException e14) {
                        e = e14;
                        k.f24653b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                        method5 = null;
                    }
                } catch (ClassNotFoundException e15) {
                    e = e15;
                    method4 = null;
                } catch (NoSuchMethodException e16) {
                    e = e16;
                    method4 = null;
                }
            } catch (ClassNotFoundException e17) {
                e = e17;
                method3 = null;
                method4 = method3;
                k.f24653b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                f24665m = method;
                f24666n = method2;
                f24667o = method3;
                f24663k = method4;
                f24664l = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                f24668p = method6;
                f24669q = constructor;
            } catch (NoSuchMethodException e18) {
                e = e18;
                method3 = null;
                method4 = method3;
                k.f24653b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                f24665m = method;
                f24666n = method2;
                f24667o = method3;
                f24663k = method4;
                f24664l = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                f24668p = method6;
                f24669q = constructor;
            }
            f24665m = method;
            f24666n = method2;
            f24667o = method3;
            f24663k = method4;
            f24664l = method5;
            try {
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
            } catch (ClassNotFoundException e19) {
                e = e19;
                method6 = null;
            } catch (NoSuchMethodException e20) {
                e = e20;
                method6 = null;
            }
            f24668p = method6;
            f24669q = constructor;
        }

        public a(v5.h hVar) {
            super(hVar);
        }

        @Override // u5.k
        public void c(SSLSocket sSLSocket, String str, List list) {
            Constructor constructor;
            boolean z7;
            Method method;
            String[] strArrI = k.i(list);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            if (str != null) {
                try {
                    try {
                        if (k.g(str)) {
                            Method method2 = f24663k;
                            if (method2 == null || !((Boolean) method2.invoke(null, sSLSocket)).booleanValue()) {
                                f24657e.e(sSLSocket, Boolean.TRUE);
                            } else {
                                f24664l.invoke(null, sSLSocket, Boolean.TRUE);
                            }
                            Method method3 = f24668p;
                            if (method3 == null || (constructor = f24669q) == null) {
                                f24658f.e(sSLSocket, str);
                            } else {
                                method3.invoke(sSLParameters, Collections.singletonList(constructor.newInstance(str)));
                            }
                        }
                    } catch (InvocationTargetException e7) {
                        throw new RuntimeException(e7);
                    }
                } catch (IllegalAccessException e8) {
                    throw new RuntimeException(e8);
                } catch (InstantiationException e9) {
                    throw new RuntimeException(e9);
                }
            }
            Method method4 = f24667o;
            if (method4 != null) {
                try {
                    method4.invoke(sSLSocket, null);
                    f24665m.invoke(sSLParameters, strArrI);
                    z7 = true;
                } catch (InvocationTargetException e10) {
                    if (!(e10.getTargetException() instanceof UnsupportedOperationException)) {
                        throw e10;
                    }
                    k.f24653b.log(Level.FINER, "setApplicationProtocol unsupported, will try old methods");
                    z7 = false;
                }
            } else {
                z7 = false;
            }
            sSLSocket.setSSLParameters(sSLParameters);
            if (z7 && (method = f24666n) != null && Arrays.equals(strArrI, (String[]) method.invoke(sSLSocket.getSSLParameters(), null))) {
                return;
            }
            Object[] objArr = {v5.h.b(list)};
            if (this.f24656a.i() == h.EnumC0389h.ALPN_AND_NPN) {
                f24660h.f(sSLSocket, objArr);
            }
            if (this.f24656a.i() == h.EnumC0389h.NONE) {
                throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
            }
            f24662j.f(sSLSocket, objArr);
        }

        @Override // u5.k
        public String f(SSLSocket sSLSocket) {
            Method method = f24667o;
            if (method != null) {
                try {
                    return (String) method.invoke(sSLSocket, null);
                } catch (IllegalAccessException e7) {
                    throw new RuntimeException(e7);
                } catch (InvocationTargetException e8) {
                    if (!(e8.getTargetException() instanceof UnsupportedOperationException)) {
                        throw new RuntimeException(e8);
                    }
                    k.f24653b.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                }
            }
            if (this.f24656a.i() == h.EnumC0389h.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) f24659g.f(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, v5.l.f24934b);
                    }
                } catch (Exception e9) {
                    k.f24653b.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e9);
                }
            }
            if (this.f24656a.i() != h.EnumC0389h.NONE) {
                try {
                    byte[] bArr2 = (byte[]) f24661i.f(sSLSocket, new Object[0]);
                    if (bArr2 != null) {
                        return new String(bArr2, v5.l.f24934b);
                    }
                } catch (Exception e10) {
                    k.f24653b.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e10);
                }
            }
            return null;
        }

        @Override // u5.k
        public String h(SSLSocket sSLSocket, String str, List list) {
            String strF = f(sSLSocket);
            return strF == null ? super.h(sSLSocket, str, list) : strF;
        }
    }

    public k(v5.h hVar) {
        this.f24656a = (v5.h) H2.m.o(hVar, "platform");
    }

    public static k d(ClassLoader classLoader) {
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e7) {
            f24653b.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e7);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e8) {
                f24653b.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e8);
                return new k(f24654c);
            }
        }
        return new a(f24654c);
    }

    public static k e() {
        return f24655d;
    }

    public static boolean g(String str) {
        if (str.contains("_")) {
            return false;
        }
        try {
            S.c(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static String[] i(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((v5.i) it.next()).toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
        this.f24656a.c(sSLSocket, str, list);
    }

    public String f(SSLSocket sSLSocket) {
        return this.f24656a.h(sSLSocket);
    }

    public String h(SSLSocket sSLSocket, String str, List list) {
        if (list != null) {
            c(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String strF = f(sSLSocket);
            if (strF != null) {
                return strF;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + list);
        } finally {
            this.f24656a.a(sSLSocket);
        }
    }
}
