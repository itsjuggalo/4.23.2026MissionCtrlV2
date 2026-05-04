package ub;

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
import tb.r0;
import vb.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f22872b = Logger.getLogger(k.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final vb.h f22873c = vb.h.e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static k f22874d = d(k.class.getClassLoader());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.h f22875a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final vb.g f22876e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final vb.g f22877f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final vb.g f22878g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final vb.g f22879h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final vb.g f22880i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final vb.g f22881j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final Method f22882k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final Method f22883l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final Method f22884m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final Method f22885n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final Method f22886o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final Method f22887p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final Constructor f22888q;

        static {
            Method method;
            Method method2;
            Method method3;
            Method method4;
            Method method5;
            Method method6;
            Class cls = Boolean.TYPE;
            Constructor<?> constructor = null;
            f22876e = new vb.g(null, "setUseSessionTickets", cls);
            f22877f = new vb.g(null, "setHostname", String.class);
            f22878g = new vb.g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            f22879h = new vb.g(null, "setAlpnProtocols", byte[].class);
            f22880i = new vb.g(byte[].class, "getNpnSelectedProtocol", new Class[0]);
            f22881j = new vb.g(null, "setNpnProtocols", byte[].class);
            try {
                method = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
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
                method2 = SSLParameters.class.getMethod("getApplicationProtocols", null);
            } catch (ClassNotFoundException e12) {
                e = e12;
                method2 = null;
                method3 = method2;
                method4 = method3;
                k.f22872b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                f22884m = method;
                f22885n = method2;
                f22886o = method3;
                f22882k = method4;
                f22883l = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                try {
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                } catch (ClassNotFoundException e13) {
                    e = e13;
                    k.f22872b.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
                } catch (NoSuchMethodException e14) {
                    e = e14;
                    k.f22872b.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
                }
                f22887p = method6;
                f22888q = constructor;
            } catch (NoSuchMethodException e15) {
                e = e15;
                method2 = null;
                method3 = method2;
                method4 = method3;
                k.f22872b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                f22884m = method;
                f22885n = method2;
                f22886o = method3;
                f22882k = method4;
                f22883l = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                f22887p = method6;
                f22888q = constructor;
            }
            try {
                method3 = SSLSocket.class.getMethod("getApplicationProtocol", null);
                try {
                    Class<?> cls2 = Class.forName("android.net.ssl.SSLSockets");
                    method4 = cls2.getMethod("isSupportedSocket", SSLSocket.class);
                    try {
                        method5 = cls2.getMethod("setUseSessionTickets", SSLSocket.class, cls);
                    } catch (ClassNotFoundException e16) {
                        e = e16;
                        k.f22872b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                        method5 = null;
                    } catch (NoSuchMethodException e17) {
                        e = e17;
                        k.f22872b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                        method5 = null;
                    }
                } catch (ClassNotFoundException e18) {
                    e = e18;
                    method4 = null;
                } catch (NoSuchMethodException e19) {
                    e = e19;
                    method4 = null;
                }
            } catch (ClassNotFoundException e20) {
                e = e20;
                method3 = null;
                method4 = method3;
                k.f22872b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                f22884m = method;
                f22885n = method2;
                f22886o = method3;
                f22882k = method4;
                f22883l = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                f22887p = method6;
                f22888q = constructor;
            } catch (NoSuchMethodException e21) {
                e = e21;
                method3 = null;
                method4 = method3;
                k.f22872b.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                f22884m = method;
                f22885n = method2;
                f22886o = method3;
                f22882k = method4;
                f22883l = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                f22887p = method6;
                f22888q = constructor;
            }
            f22884m = method;
            f22885n = method2;
            f22886o = method3;
            f22882k = method4;
            f22883l = method5;
            try {
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
            } catch (ClassNotFoundException e22) {
                e = e22;
                method6 = null;
            } catch (NoSuchMethodException e23) {
                e = e23;
                method6 = null;
            }
            f22887p = method6;
            f22888q = constructor;
        }

        public a(vb.h hVar) {
            super(hVar);
        }

        @Override // ub.k
        public void c(SSLSocket sSLSocket, String str, List list) {
            Constructor constructor;
            boolean z10;
            Method method;
            String[] strArrI = k.i(list);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            if (str != null) {
                try {
                    try {
                        if (k.g(str)) {
                            Method method2 = f22882k;
                            if (method2 == null || !((Boolean) method2.invoke(null, sSLSocket)).booleanValue()) {
                                f22876e.e(sSLSocket, Boolean.TRUE);
                            } else {
                                f22883l.invoke(null, sSLSocket, Boolean.TRUE);
                            }
                            Method method3 = f22887p;
                            if (method3 == null || (constructor = f22888q) == null) {
                                f22877f.e(sSLSocket, str);
                            } else {
                                method3.invoke(sSLParameters, Collections.singletonList(constructor.newInstance(str)));
                            }
                        }
                    } catch (InvocationTargetException e10) {
                        throw new RuntimeException(e10);
                    }
                } catch (IllegalAccessException e11) {
                    throw new RuntimeException(e11);
                } catch (InstantiationException e12) {
                    throw new RuntimeException(e12);
                }
            }
            Method method4 = f22886o;
            if (method4 != null) {
                try {
                    method4.invoke(sSLSocket, null);
                    f22884m.invoke(sSLParameters, strArrI);
                    z10 = true;
                } catch (InvocationTargetException e13) {
                    if (!(e13.getTargetException() instanceof UnsupportedOperationException)) {
                        throw e13;
                    }
                    k.f22872b.log(Level.FINER, "setApplicationProtocol unsupported, will try old methods");
                    z10 = false;
                }
            } else {
                z10 = false;
            }
            sSLSocket.setSSLParameters(sSLParameters);
            if (z10 && (method = f22885n) != null && Arrays.equals(strArrI, (String[]) method.invoke(sSLSocket.getSSLParameters(), null))) {
                return;
            }
            Object[] objArr = {vb.h.b(list)};
            if (this.f22875a.i() == h.EnumC0404h.ALPN_AND_NPN) {
                f22879h.f(sSLSocket, objArr);
            }
            if (this.f22875a.i() == h.EnumC0404h.NONE) {
                throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
            }
            f22881j.f(sSLSocket, objArr);
        }

        @Override // ub.k
        public String f(SSLSocket sSLSocket) {
            Method method = f22886o;
            if (method != null) {
                try {
                    return (String) method.invoke(sSLSocket, null);
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException(e10);
                } catch (InvocationTargetException e11) {
                    if (!(e11.getTargetException() instanceof UnsupportedOperationException)) {
                        throw new RuntimeException(e11);
                    }
                    k.f22872b.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                }
            }
            if (this.f22875a.i() == h.EnumC0404h.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) f22878g.f(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, vb.l.f23355b);
                    }
                } catch (Exception e12) {
                    k.f22872b.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e12);
                }
            }
            if (this.f22875a.i() != h.EnumC0404h.NONE) {
                try {
                    byte[] bArr2 = (byte[]) f22880i.f(sSLSocket, new Object[0]);
                    if (bArr2 != null) {
                        return new String(bArr2, vb.l.f23355b);
                    }
                } catch (Exception e13) {
                    k.f22872b.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e13);
                }
            }
            return null;
        }

        @Override // ub.k
        public String h(SSLSocket sSLSocket, String str, List list) {
            String strF = f(sSLSocket);
            return strF == null ? super.h(sSLSocket, str, list) : strF;
        }
    }

    public k(vb.h hVar) {
        this.f22875a = (vb.h) p6.n.o(hVar, "platform");
    }

    public static k d(ClassLoader classLoader) {
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e10) {
            f22872b.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e10);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e11) {
                f22872b.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e11);
                return new k(f22873c);
            }
        }
        return new a(f22873c);
    }

    public static k e() {
        return f22874d;
    }

    public static boolean g(String str) {
        if (str.contains("_")) {
            return false;
        }
        try {
            r0.c(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static String[] i(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((vb.i) it.next()).toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
        this.f22875a.c(sSLSocket, str, list);
    }

    public String f(SSLSocket sSLSocket) {
        return this.f22875a.h(sSLSocket);
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
            this.f22875a.a(sSLSocket);
        }
    }
}
