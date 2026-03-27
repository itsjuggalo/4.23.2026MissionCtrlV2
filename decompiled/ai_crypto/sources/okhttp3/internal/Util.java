package okhttp3.internal;

import com.revenuecat.purchases.common.Constants;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import w6.C2792e;
import w6.C2795h;
import w6.InterfaceC2794g;
import w6.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f20670a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ResponseBody f20672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RequestBody f20673d;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Method f20687r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Pattern f20688s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f20671b = new String[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2795h f20674e = C2795h.h("efbbbf");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C2795h f20675f = C2795h.h("feff");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C2795h f20676g = C2795h.h("fffe");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C2795h f20677h = C2795h.h("0000ffff");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C2795h f20678i = C2795h.h("ffff0000");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Charset f20679j = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Charset f20680k = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Charset f20681l = Charset.forName("UTF-16BE");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Charset f20682m = Charset.forName("UTF-16LE");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Charset f20683n = Charset.forName("UTF-32BE");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Charset f20684o = Charset.forName("UTF-32LE");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final TimeZone f20685p = DesugarTimeZone.getTimeZone("GMT");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Comparator f20686q = new Comparator<String>() { // from class: okhttp3.internal.Util.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };

    static {
        byte[] bArr = new byte[0];
        f20670a = bArr;
        Method declaredMethod = null;
        f20672c = ResponseBody.A(null, bArr);
        f20673d = RequestBody.c(null, bArr);
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f20687r = declaredMethod;
        f20688s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    private Util() {
    }

    public static boolean A(Comparator comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static X509TrustManager B() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e7) {
            throw b("No System TLS", e7);
        }
    }

    public static boolean C(Z z7, int i7, TimeUnit timeUnit) {
        long jNanoTime = System.nanoTime();
        long jC = z7.f().e() ? z7.f().c() - jNanoTime : Long.MAX_VALUE;
        z7.f().d(Math.min(jC, timeUnit.toNanos(i7)) + jNanoTime);
        try {
            C2792e c2792e = new C2792e();
            while (z7.z(c2792e, 8192L) != -1) {
                c2792e.i();
            }
            if (jC == Long.MAX_VALUE) {
                z7.f().a();
                return true;
            }
            z7.f().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                z7.f().a();
                return false;
            }
            z7.f().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                z7.f().a();
            } else {
                z7.f().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static int D(String str, int i7, int i8) {
        while (i7 < i8) {
            char cCharAt = str.charAt(i7);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    public static int E(String str, int i7, int i8) {
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            char cCharAt = str.charAt(i9);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i9 + 1;
            }
        }
        return i7;
    }

    public static ThreadFactory F(final String str, final boolean z7) {
        return new ThreadFactory() { // from class: okhttp3.internal.Util.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z7);
                return thread;
            }
        };
    }

    public static Headers G(List list) {
        Headers.Builder builder = new Headers.Builder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Header header = (Header) it.next();
            Internal.f20668a.b(builder, header.f20898a.N(), header.f20899b.N());
        }
        return builder.d();
    }

    public static String H(String str, int i7, int i8) {
        int iD = D(str, i7, i8);
        return str.substring(iD, E(str, iD, i8));
    }

    public static boolean I(String str) {
        return f20688s.matcher(str).matches();
    }

    public static void a(Throwable th, Throwable th2) {
        Method method = f20687r;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static AssertionError b(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static Charset c(InterfaceC2794g interfaceC2794g, Charset charset) {
        if (interfaceC2794g.R(0L, f20674e)) {
            interfaceC2794g.skip(r0.H());
            return f20679j;
        }
        if (interfaceC2794g.R(0L, f20675f)) {
            interfaceC2794g.skip(r0.H());
            return f20681l;
        }
        if (interfaceC2794g.R(0L, f20676g)) {
            interfaceC2794g.skip(r0.H());
            return f20682m;
        }
        if (interfaceC2794g.R(0L, f20677h)) {
            interfaceC2794g.skip(r0.H());
            return f20683n;
        }
        if (!interfaceC2794g.R(0L, f20678i)) {
            return charset;
        }
        interfaceC2794g.skip(r0.H());
        return f20684o;
    }

    public static String d(String str) {
        if (!str.contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (i(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressL = (str.startsWith("[") && str.endsWith("]")) ? l(str, 1, str.length() - 1) : l(str, 0, str.length());
        if (inetAddressL == null) {
            return null;
        }
        byte[] address = inetAddressL.getAddress();
        if (address.length == 16) {
            return x(address);
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + "'");
    }

    public static void e(long j7, long j8, long j9) {
        if ((j8 | j9) < 0 || j8 > j7 || j7 - j8 < j9) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Exception unused) {
            }
        }
    }

    public static void g(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e7) {
                if (!z(e7)) {
                    throw e7;
                }
            } catch (RuntimeException e8) {
                if (!"bio == null".equals(e8.getMessage())) {
                    throw e8;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static String[] h(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    public static boolean i(String str) {
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int j(char c7) {
        if (c7 >= '0' && c7 <= '9') {
            return c7 - '0';
        }
        if (c7 >= 'a' && c7 <= 'f') {
            return c7 - 'W';
        }
        if (c7 < 'A' || c7 > 'F') {
            return -1;
        }
        return c7 - '7';
    }

    public static boolean k(String str, int i7, int i8, byte[] bArr, int i9) {
        int i10 = i9;
        while (i7 < i8) {
            if (i10 == bArr.length) {
                return false;
            }
            if (i10 != i9) {
                if (str.charAt(i7) != '.') {
                    return false;
                }
                i7++;
            }
            int i11 = i7;
            int i12 = 0;
            while (i11 < i8) {
                char cCharAt = str.charAt(i11);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i12 == 0 && i7 != i11) || (i12 = ((i12 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i11++;
            }
            if (i11 - i7 == 0) {
                return false;
            }
            bArr[i10] = (byte) i12;
            i10++;
            i7 = i11;
        }
        return i10 == i9 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
    
        if (r4 == 16) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (r5 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007e, code lost:
    
        r12 = r4 - r5;
        java.lang.System.arraycopy(r1, r5, r1, 16 - r12, r12);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008e, code lost:
    
        return java.net.InetAddress.getByAddress(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0094, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.net.InetAddress l(java.lang.String r12, int r13, int r14) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = r2
            r5 = r3
            r6 = r5
        L9:
            r7 = 0
            if (r13 >= r14) goto L79
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r13 + 2
            r9 = 2
            if (r8 > r14) goto L27
            java.lang.String r10 = "::"
            boolean r10 = r12.regionMatches(r13, r10, r2, r9)
            if (r10 == 0) goto L27
            if (r5 == r3) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r14) goto L25
            goto L79
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L34
            java.lang.String r8 = ":"
            r10 = 1
            boolean r8 = r12.regionMatches(r13, r8, r2, r10)
            if (r8 == 0) goto L36
            int r13 = r13 + 1
        L34:
            r6 = r13
            goto L4b
        L36:
            java.lang.String r8 = "."
            boolean r13 = r12.regionMatches(r13, r8, r2, r10)
            if (r13 == 0) goto L4a
            int r13 = r4 + (-2)
            boolean r12 = k(r12, r6, r14, r1, r13)
            if (r12 != 0) goto L47
            return r7
        L47:
            int r4 = r4 + 2
            goto L79
        L4a:
            return r7
        L4b:
            r8 = r2
            r13 = r6
        L4d:
            if (r13 >= r14) goto L60
            char r10 = r12.charAt(r13)
            int r10 = j(r10)
            if (r10 != r3) goto L5a
            goto L60
        L5a:
            int r8 = r8 << 4
            int r8 = r8 + r10
            int r13 = r13 + 1
            goto L4d
        L60:
            int r10 = r13 - r6
            if (r10 == 0) goto L78
            r11 = 4
            if (r10 <= r11) goto L68
            goto L78
        L68:
            int r7 = r4 + 1
            int r10 = r8 >>> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r1[r4] = r10
            int r4 = r4 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L78:
            return r7
        L79:
            if (r4 == r0) goto L8a
            if (r5 != r3) goto L7e
            return r7
        L7e:
            int r12 = r4 - r5
            int r13 = 16 - r12
            java.lang.System.arraycopy(r1, r5, r1, r13, r12)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L8a:
            java.net.InetAddress r12 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8f
            return r12
        L8f:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.l(java.lang.String, int, int):java.net.InetAddress");
    }

    public static int m(String str, int i7, int i8, char c7) {
        while (i7 < i8) {
            if (str.charAt(i7) == c7) {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    public static int n(String str, int i7, int i8, String str2) {
        while (i7 < i8) {
            if (str2.indexOf(str.charAt(i7)) != -1) {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    public static boolean o(Z z7, int i7, TimeUnit timeUnit) {
        try {
            return C(z7, i7, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean p(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static String q(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String r(HttpUrl httpUrl, boolean z7) {
        String strL;
        if (httpUrl.l().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
            strL = "[" + httpUrl.l() + "]";
        } else {
            strL = httpUrl.l();
        }
        if (!z7 && httpUrl.w() == HttpUrl.d(httpUrl.B())) {
            return strL;
        }
        return strL + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + httpUrl.w();
    }

    public static List s(List list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static List t(Object... objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static Map u(Map map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static int v(Comparator comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (comparator.compare(strArr[i7], str) == 0) {
                return i7;
            }
        }
        return -1;
    }

    public static int w(String str) {
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i7;
            }
        }
        return -1;
    }

    public static String x(byte[] bArr) {
        int i7 = -1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < bArr.length) {
            int i11 = i9;
            while (i11 < 16 && bArr[i11] == 0 && bArr[i11 + 1] == 0) {
                i11 += 2;
            }
            int i12 = i11 - i9;
            if (i12 > i10 && i12 >= 4) {
                i7 = i9;
                i10 = i12;
            }
            i9 = i11 + 2;
        }
        C2792e c2792e = new C2792e();
        while (i8 < bArr.length) {
            if (i8 == i7) {
                c2792e.v(58);
                i8 += i10;
                if (i8 == 16) {
                    c2792e.v(58);
                }
            } else {
                if (i8 > 0) {
                    c2792e.v(58);
                }
                c2792e.P(((bArr[i8] & 255) << 8) | (bArr[i8 + 1] & 255));
                i8 += 2;
            }
        }
        return c2792e.C0();
    }

    public static String[] y(Comparator comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i7]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i7++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean z(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
