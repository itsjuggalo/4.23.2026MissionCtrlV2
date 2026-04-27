package N2;

import M2.S;
import O2.h;
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

/* JADX INFO: loaded from: classes3.dex */
public class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f3061b = Logger.getLogger(k.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final O2.h f3062c = O2.h.e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static k f3063d = d(k.class.getClassLoader());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O2.h f3064a;

    public static final class a extends k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final O2.g f3065e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final O2.g f3066f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final O2.g f3067g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final O2.g f3068h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final O2.g f3069i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final O2.g f3070j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final Method f3071k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final Method f3072l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final Method f3073m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final Method f3074n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final Method f3075o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final Method f3076p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final Constructor f3077q;

        static {
            Method method;
            Method method2;
            Method method3;
            Method method4;
            Method method5;
            Method method6;
            Class<?> cls;
            Class cls2 = Boolean.TYPE;
            Constructor<?> constructor = null;
            f3065e = new O2.g(null, "setUseSessionTickets", cls2);
            f3066f = new O2.g(null, "setHostname", String.class);
            f3067g = new O2.g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            f3068h = new O2.g(null, "setAlpnProtocols", byte[].class);
            f3069i = new O2.g(byte[].class, "getNpnSelectedProtocol", new Class[0]);
            f3070j = new O2.g(null, "setNpnProtocols", byte[].class);
            try {
                method = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
                try {
                    method3 = SSLParameters.class.getMethod("getApplicationProtocols", new Class[0]);
                    try {
                        method2 = SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
                        try {
                            cls = Class.forName("android.net.ssl.SSLSockets");
                            method4 = cls.getMethod("isSupportedSocket", SSLSocket.class);
                        } catch (ClassNotFoundException e4) {
                            e = e4;
                            method4 = null;
                        } catch (NoSuchMethodException e5) {
                            e = e5;
                            method4 = null;
                        }
                    } catch (ClassNotFoundException e6) {
                        e = e6;
                        method2 = null;
                        method4 = null;
                    } catch (NoSuchMethodException e7) {
                        e = e7;
                        method2 = null;
                        method4 = null;
                    }
                } catch (ClassNotFoundException e8) {
                    e = e8;
                    method2 = null;
                    method3 = method2;
                    method4 = method3;
                    k.f3061b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                    method5 = null;
                    f3073m = method;
                    f3074n = method3;
                    f3075o = method2;
                    f3071k = method4;
                    f3072l = method5;
                    method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                    f3076p = method6;
                    f3077q = constructor;
                } catch (NoSuchMethodException e9) {
                    e = e9;
                    method2 = null;
                    method3 = method2;
                    method4 = method3;
                    k.f3061b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                    method5 = null;
                    f3073m = method;
                    f3074n = method3;
                    f3075o = method2;
                    f3071k = method4;
                    f3072l = method5;
                    method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                    f3076p = method6;
                    f3077q = constructor;
                }
            } catch (ClassNotFoundException e10) {
                e = e10;
                method = null;
                method2 = null;
            } catch (NoSuchMethodException e11) {
                e = e11;
                method = null;
                method2 = null;
            }
            try {
                method5 = cls.getMethod("setUseSessionTickets", SSLSocket.class, cls2);
            } catch (ClassNotFoundException e12) {
                e = e12;
                k.f3061b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
            } catch (NoSuchMethodException e13) {
                e = e13;
                k.f3061b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
            }
            f3073m = method;
            f3074n = method3;
            f3075o = method2;
            f3071k = method4;
            f3072l = method5;
            try {
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
            } catch (ClassNotFoundException e14) {
                e = e14;
                method6 = null;
            } catch (NoSuchMethodException e15) {
                e = e15;
                method6 = null;
            }
            try {
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
            } catch (ClassNotFoundException e16) {
                e = e16;
                k.f3061b.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
            } catch (NoSuchMethodException e17) {
                e = e17;
                k.f3061b.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
            }
            f3076p = method6;
            f3077q = constructor;
        }

        public a(O2.h hVar) {
            super(hVar);
        }

        @Override // N2.k
        public void c(SSLSocket sSLSocket, String str, List list) {
            Constructor constructor;
            boolean z4;
            Method method;
            String[] strArrI = k.i(list);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            if (str != null) {
                try {
                    try {
                        if (k.g(str)) {
                            Method method2 = f3071k;
                            if (method2 == null || !((Boolean) method2.invoke(null, sSLSocket)).booleanValue()) {
                                f3065e.e(sSLSocket, Boolean.TRUE);
                            } else {
                                f3072l.invoke(null, sSLSocket, Boolean.TRUE);
                            }
                            Method method3 = f3076p;
                            if (method3 == null || (constructor = f3077q) == null) {
                                f3066f.e(sSLSocket, str);
                            } else {
                                method3.invoke(sSLParameters, Collections.singletonList(constructor.newInstance(str)));
                            }
                        }
                    } catch (InvocationTargetException e4) {
                        throw new RuntimeException(e4);
                    }
                } catch (IllegalAccessException e5) {
                    throw new RuntimeException(e5);
                } catch (InstantiationException e6) {
                    throw new RuntimeException(e6);
                }
            }
            Method method4 = f3075o;
            if (method4 != null) {
                try {
                    method4.invoke(sSLSocket, new Object[0]);
                    f3073m.invoke(sSLParameters, strArrI);
                    z4 = true;
                } catch (InvocationTargetException e7) {
                    if (!(e7.getTargetException() instanceof UnsupportedOperationException)) {
                        throw e7;
                    }
                    k.f3061b.log(Level.FINER, "setApplicationProtocol unsupported, will try old methods");
                    z4 = false;
                }
            } else {
                z4 = false;
            }
            sSLSocket.setSSLParameters(sSLParameters);
            if (z4 && (method = f3074n) != null && Arrays.equals(strArrI, (String[]) method.invoke(sSLSocket.getSSLParameters(), new Object[0]))) {
                return;
            }
            Object[] objArr = {O2.h.b(list)};
            if (this.f3064a.i() == h.EnumC0054h.ALPN_AND_NPN) {
                f3068h.f(sSLSocket, objArr);
            }
            if (this.f3064a.i() == h.EnumC0054h.NONE) {
                throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
            }
            f3070j.f(sSLSocket, objArr);
        }

        @Override // N2.k
        public String f(SSLSocket sSLSocket) {
            Method method = f3075o;
            if (method != null) {
                try {
                    return (String) method.invoke(sSLSocket, new Object[0]);
                } catch (IllegalAccessException e4) {
                    throw new RuntimeException(e4);
                } catch (InvocationTargetException e5) {
                    if (!(e5.getTargetException() instanceof UnsupportedOperationException)) {
                        throw new RuntimeException(e5);
                    }
                    k.f3061b.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                }
            }
            if (this.f3064a.i() == h.EnumC0054h.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) f3067g.f(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, O2.l.f3303b);
                    }
                } catch (Exception e6) {
                    k.f3061b.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e6);
                }
            }
            if (this.f3064a.i() == h.EnumC0054h.NONE) {
                return null;
            }
            try {
                byte[] bArr2 = (byte[]) f3069i.f(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, O2.l.f3303b);
                }
                return null;
            } catch (Exception e7) {
                k.f3061b.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e7);
                return null;
            }
        }

        @Override // N2.k
        public String h(SSLSocket sSLSocket, String str, List list) {
            String strF = f(sSLSocket);
            return strF == null ? super.h(sSLSocket, str, list) : strF;
        }
    }

    public k(O2.h hVar) {
        this.f3064a = (O2.h) Z1.m.o(hVar, "platform");
    }

    public static k d(ClassLoader classLoader) {
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e4) {
            f3061b.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e4);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e5) {
                f3061b.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e5);
                return new k(f3062c);
            }
        }
        return new a(f3062c);
    }

    public static k e() {
        return f3063d;
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
            arrayList.add(((O2.i) it.next()).toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
        this.f3064a.c(sSLSocket, str, list);
    }

    public String f(SSLSocket sSLSocket) {
        return this.f3064a.h(sSLSocket);
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
            this.f3064a.a(sSLSocket);
        }
    }
}
