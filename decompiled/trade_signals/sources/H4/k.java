package H4;

import G4.S;
import I4.h;
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
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f3918b = Logger.getLogger(k.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final I4.h f3919c = I4.h.e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static k f3920d = d(k.class.getClassLoader());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I4.h f3921a;

    public static final class a extends k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final I4.g f3922e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final I4.g f3923f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final I4.g f3924g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final I4.g f3925h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final I4.g f3926i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final I4.g f3927j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final Method f3928k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final Method f3929l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final Method f3930m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final Method f3931n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final Method f3932o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final Method f3933p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final Constructor f3934q;

        /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|48|3|50|4|(3:56|5|(4:60|6|58|7))|33|54|34|52|35|46|47|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00da, code lost:
        
            r2 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00dc, code lost:
        
            r2 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00de, code lost:
        
            r2 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00df, code lost:
        
            r1 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
        
            H4.k.f3918b.log(java.util.logging.Level.FINER, "Failed to find Android 7.0+ APIs", r2);
         */
        static {
            /*
                Method dump skipped, instruction units count: 241
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: H4.k.a.<clinit>():void");
        }

        public a(I4.h hVar) {
            super(hVar);
        }

        @Override // H4.k
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
                            Method method2 = f3928k;
                            if (method2 == null || !((Boolean) method2.invoke(null, sSLSocket)).booleanValue()) {
                                f3922e.e(sSLSocket, Boolean.TRUE);
                            } else {
                                f3929l.invoke(null, sSLSocket, Boolean.TRUE);
                            }
                            Method method3 = f3933p;
                            if (method3 == null || (constructor = f3934q) == null) {
                                f3923f.e(sSLSocket, str);
                            } else {
                                method3.invoke(sSLParameters, Collections.singletonList(constructor.newInstance(str)));
                            }
                        }
                    } catch (InvocationTargetException e8) {
                        throw new RuntimeException(e8);
                    }
                } catch (IllegalAccessException e9) {
                    throw new RuntimeException(e9);
                } catch (InstantiationException e10) {
                    throw new RuntimeException(e10);
                }
            }
            Method method4 = f3932o;
            if (method4 != null) {
                try {
                    method4.invoke(sSLSocket, null);
                    f3930m.invoke(sSLParameters, strArrI);
                    z7 = true;
                } catch (InvocationTargetException e11) {
                    if (!(e11.getTargetException() instanceof UnsupportedOperationException)) {
                        throw e11;
                    }
                    k.f3918b.log(Level.FINER, "setApplicationProtocol unsupported, will try old methods");
                    z7 = false;
                }
            } else {
                z7 = false;
            }
            sSLSocket.setSSLParameters(sSLParameters);
            if (z7 && (method = f3931n) != null && Arrays.equals(strArrI, (String[]) method.invoke(sSLSocket.getSSLParameters(), null))) {
                return;
            }
            Object[] objArr = {I4.h.b(list)};
            if (this.f3921a.i() == h.EnumC0053h.ALPN_AND_NPN) {
                f3925h.f(sSLSocket, objArr);
            }
            if (this.f3921a.i() == h.EnumC0053h.NONE) {
                throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
            }
            f3927j.f(sSLSocket, objArr);
        }

        @Override // H4.k
        public String f(SSLSocket sSLSocket) {
            Method method = f3932o;
            if (method != null) {
                try {
                    return (String) method.invoke(sSLSocket, null);
                } catch (IllegalAccessException e8) {
                    throw new RuntimeException(e8);
                } catch (InvocationTargetException e9) {
                    if (!(e9.getTargetException() instanceof UnsupportedOperationException)) {
                        throw new RuntimeException(e9);
                    }
                    k.f3918b.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                }
            }
            if (this.f3921a.i() == h.EnumC0053h.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) f3924g.f(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, I4.l.f4289b);
                    }
                } catch (Exception e10) {
                    k.f3918b.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e10);
                }
            }
            if (this.f3921a.i() != h.EnumC0053h.NONE) {
                try {
                    byte[] bArr2 = (byte[]) f3926i.f(sSLSocket, new Object[0]);
                    if (bArr2 != null) {
                        return new String(bArr2, I4.l.f4289b);
                    }
                } catch (Exception e11) {
                    k.f3918b.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e11);
                }
            }
            return null;
        }

        @Override // H4.k
        public String h(SSLSocket sSLSocket, String str, List list) {
            String strF = f(sSLSocket);
            return strF == null ? super.h(sSLSocket, str, list) : strF;
        }
    }

    public k(I4.h hVar) {
        this.f3921a = (I4.h) AbstractC2848n.o(hVar, "platform");
    }

    public static k d(ClassLoader classLoader) {
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e8) {
            f3918b.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e8);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e9) {
                f3918b.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e9);
                return new k(f3919c);
            }
        }
        return new a(f3919c);
    }

    public static k e() {
        return f3920d;
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
            arrayList.add(((I4.i) it.next()).toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
        this.f3921a.c(sSLSocket, str, list);
    }

    public String f(SSLSocket sSLSocket) {
        return this.f3921a.h(sSLSocket);
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
            this.f3921a.a(sSLSocket);
        }
    }
}
