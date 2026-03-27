package M2;

import K2.AbstractC0363k;
import K2.C0355c;
import K2.M;
import K2.S;
import K2.Z;
import K2.l0;
import M2.InterfaceC0443s;
import M2.L0;
import M2.Q0;
import e2.C1235g;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f1955a = Logger.getLogger(S.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f1956b = Collections.unmodifiableSet(EnumSet.of(l0.b.OK, l0.b.INVALID_ARGUMENT, l0.b.NOT_FOUND, l0.b.ALREADY_EXISTS, l0.b.FAILED_PRECONDITION, l0.b.ABORTED, l0.b.OUT_OF_RANGE, l0.b.DATA_LOSS));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f1957c = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Z.g f1958d = Z.g.e("grpc-timeout", new i());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Z.g f1959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Z.g f1960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Z.g f1961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Z.g f1962h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Z.g f1963i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Z.g f1964j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Z.g f1965k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Z.g f1966l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Z1.o f1967m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f1968n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f1969o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f1970p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final K2.h0 f1971q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final K2.h0 f1972r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final C0355c.C0031c f1973s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final AbstractC0363k f1974t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final L0.d f1975u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final L0.d f1976v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Z1.r f1977w;

    public class a implements K2.h0 {
        @Override // K2.h0
        public K2.g0 a(SocketAddress socketAddress) {
            return null;
        }
    }

    public class b extends AbstractC0363k {
    }

    public class c implements L0.d {
        @Override // M2.L0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // M2.L0.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Executor a() {
            return Executors.newCachedThreadPool(S.j("grpc-default-executor-%d", true));
        }

        public String toString() {
            return "grpc-default-executor";
        }
    }

    public class d implements L0.d {
        @Override // M2.L0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }

        @Override // M2.L0.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ScheduledExecutorService a() {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, S.j("grpc-timer-%d", true));
            try {
                scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception e5) {
                throw new RuntimeException(e5);
            }
            return Executors.unconfigurableScheduledExecutorService(scheduledExecutorServiceNewScheduledThreadPool);
        }
    }

    public class e implements Z1.r {
        @Override // Z1.r
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Z1.p get() {
            return Z1.p.c();
        }
    }

    public class f implements InterfaceC0445t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0363k.a f1978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0445t f1979b;

        public f(AbstractC0363k.a aVar, InterfaceC0445t interfaceC0445t) {
            this.f1978a = aVar;
            this.f1979b = interfaceC0445t;
        }

        @Override // M2.InterfaceC0445t
        public r c(K2.a0 a0Var, K2.Z z4, C0355c c0355c, AbstractC0363k[] abstractC0363kArr) {
            AbstractC0363k abstractC0363kA = this.f1978a.a(AbstractC0363k.b.a().b(c0355c).a(), z4);
            Z1.m.u(abstractC0363kArr[abstractC0363kArr.length - 1] == S.f1974t, "lb tracer already assigned");
            abstractC0363kArr[abstractC0363kArr.length - 1] = abstractC0363kA;
            return this.f1979b.c(a0Var, z4, c0355c, abstractC0363kArr);
        }

        @Override // K2.P
        public K2.K h() {
            return this.f1979b.h();
        }
    }

    public static final class g implements M.a {
        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        @Override // K2.Z.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(byte[] bArr) {
            return bArr;
        }

        @Override // K2.Z.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(byte[] bArr) {
            return bArr;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f1980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final h f1981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final h f1982e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h f1983f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final h f1984g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final h f1985h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final h f1986i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final h f1987j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final h f1988k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final h f1989l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final h f1990m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final h f1991n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final h f1992o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final h f1993p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final h[] f1994q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final /* synthetic */ h[] f1995r;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final K2.l0 f1997b;

        static {
            K2.l0 l0Var = K2.l0.f1230t;
            h hVar = new h("NO_ERROR", 0, 0, l0Var);
            f1980c = hVar;
            K2.l0 l0Var2 = K2.l0.f1229s;
            h hVar2 = new h("PROTOCOL_ERROR", 1, 1, l0Var2);
            f1981d = hVar2;
            h hVar3 = new h("INTERNAL_ERROR", 2, 2, l0Var2);
            f1982e = hVar3;
            h hVar4 = new h("FLOW_CONTROL_ERROR", 3, 3, l0Var2);
            f1983f = hVar4;
            h hVar5 = new h("SETTINGS_TIMEOUT", 4, 4, l0Var2);
            f1984g = hVar5;
            h hVar6 = new h("STREAM_CLOSED", 5, 5, l0Var2);
            f1985h = hVar6;
            h hVar7 = new h("FRAME_SIZE_ERROR", 6, 6, l0Var2);
            f1986i = hVar7;
            h hVar8 = new h("REFUSED_STREAM", 7, 7, l0Var);
            f1987j = hVar8;
            h hVar9 = new h("CANCEL", 8, 8, K2.l0.f1216f);
            f1988k = hVar9;
            h hVar10 = new h("COMPRESSION_ERROR", 9, 9, l0Var2);
            f1989l = hVar10;
            h hVar11 = new h("CONNECT_ERROR", 10, 10, l0Var2);
            f1990m = hVar11;
            h hVar12 = new h("ENHANCE_YOUR_CALM", 11, 11, K2.l0.f1224n.q("Bandwidth exhausted"));
            f1991n = hVar12;
            h hVar13 = new h("INADEQUATE_SECURITY", 12, 12, K2.l0.f1222l.q("Permission denied as protocol is not secure enough to call"));
            f1992o = hVar13;
            h hVar14 = new h("HTTP_1_1_REQUIRED", 13, 13, K2.l0.f1217g);
            f1993p = hVar14;
            f1995r = new h[]{hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, hVar10, hVar11, hVar12, hVar13, hVar14};
            f1994q = a();
        }

        public h(String str, int i4, int i5, K2.l0 l0Var) {
            this.f1996a = i5;
            String str2 = "HTTP/2 error code: " + name();
            if (l0Var.n() != null) {
                str2 = str2 + " (" + l0Var.n() + ")";
            }
            this.f1997b = l0Var.q(str2);
        }

        public static h[] a() {
            h[] hVarArrValues = values();
            h[] hVarArr = new h[((int) hVarArrValues[hVarArrValues.length - 1].c()) + 1];
            for (h hVar : hVarArrValues) {
                hVarArr[(int) hVar.c()] = hVar;
            }
            return hVarArr;
        }

        public static h g(long j4) {
            h[] hVarArr = f1994q;
            if (j4 >= hVarArr.length || j4 < 0) {
                return null;
            }
            return hVarArr[(int) j4];
        }

        public static K2.l0 i(long j4) {
            h hVarG = g(j4);
            if (hVarG != null) {
                return hVarG.h();
            }
            return K2.l0.h(f1982e.h().m().g()).q("Unrecognized HTTP/2 error code: " + j4);
        }

        public static h valueOf(String str) {
            return (h) Enum.valueOf(h.class, str);
        }

        public static h[] values() {
            return (h[]) f1995r.clone();
        }

        public long c() {
            return this.f1996a;
        }

        public K2.l0 h() {
            return this.f1997b;
        }
    }

    public static class i implements Z.d {
        @Override // K2.Z.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Long b(String str) {
            Z1.m.e(str.length() > 0, "empty timeout");
            Z1.m.e(str.length() <= 9, "bad timeout format");
            long j4 = Long.parseLong(str.substring(0, str.length() - 1));
            char cCharAt = str.charAt(str.length() - 1);
            if (cCharAt == 'H') {
                return Long.valueOf(TimeUnit.HOURS.toNanos(j4));
            }
            if (cCharAt == 'M') {
                return Long.valueOf(TimeUnit.MINUTES.toNanos(j4));
            }
            if (cCharAt == 'S') {
                return Long.valueOf(TimeUnit.SECONDS.toNanos(j4));
            }
            if (cCharAt == 'u') {
                return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(j4));
            }
            if (cCharAt == 'm') {
                return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(j4));
            }
            if (cCharAt == 'n') {
                return Long.valueOf(j4);
            }
            throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(cCharAt)));
        }

        @Override // K2.Z.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(Long l4) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l4.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            }
            if (l4.longValue() < 100000000) {
                return l4 + "n";
            }
            if (l4.longValue() < 100000000000L) {
                return timeUnit.toMicros(l4.longValue()) + "u";
            }
            if (l4.longValue() < 100000000000000L) {
                return timeUnit.toMillis(l4.longValue()) + "m";
            }
            if (l4.longValue() < 100000000000000000L) {
                return timeUnit.toSeconds(l4.longValue()) + "S";
            }
            if (l4.longValue() < 6000000000000000000L) {
                return timeUnit.toMinutes(l4.longValue()) + "M";
            }
            return timeUnit.toHours(l4.longValue()) + "H";
        }
    }

    static {
        Z.d dVar = K2.Z.f1097e;
        f1959e = Z.g.e("grpc-encoding", dVar);
        a aVar = null;
        f1960f = K2.M.b("grpc-accept-encoding", new g(aVar));
        f1961g = Z.g.e("content-encoding", dVar);
        f1962h = K2.M.b("accept-encoding", new g(aVar));
        f1963i = Z.g.e("content-length", dVar);
        f1964j = Z.g.e("content-type", dVar);
        f1965k = Z.g.e("te", dVar);
        f1966l = Z.g.e("user-agent", dVar);
        f1967m = Z1.o.a(',').c();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f1968n = timeUnit.toNanos(20L);
        f1969o = TimeUnit.HOURS.toNanos(2L);
        f1970p = timeUnit.toNanos(20L);
        f1971q = new x0();
        f1972r = new a();
        f1973s = C0355c.C0031c.b("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        f1974t = new b();
        f1975u = new c();
        f1976v = new d();
        f1977w = new e();
    }

    public static URI b(String str) {
        String str2;
        Z1.m.o(str, "authority");
        try {
            str2 = str;
            try {
                return new URI(null, str2, null, null, null);
            } catch (URISyntaxException e4) {
                e = e4;
                throw new IllegalArgumentException("Invalid authority: " + str2, e);
            }
        } catch (URISyntaxException e5) {
            e = e5;
            str2 = str;
        }
    }

    public static String c(String str) {
        Z1.m.j(b(str).getAuthority().indexOf(64) == -1, "Userinfo must not be present on authority: '%s'", str);
        return str;
    }

    public static void d(Q0.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                e(next);
            }
        }
    }

    public static void e(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e4) {
            f1955a.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e4);
        }
    }

    public static AbstractC0363k[] f(C0355c c0355c, K2.Z z4, int i4, boolean z5) {
        List listI = c0355c.i();
        int size = listI.size();
        AbstractC0363k[] abstractC0363kArr = new AbstractC0363k[size + 1];
        AbstractC0363k.b bVarA = AbstractC0363k.b.a().b(c0355c).d(i4).c(z5).a();
        for (int i5 = 0; i5 < listI.size(); i5++) {
            abstractC0363kArr[i5] = ((AbstractC0363k.a) listI.get(i5)).a(bVarA, z4);
        }
        abstractC0363kArr[size] = f1974t;
        return abstractC0363kArr;
    }

    public static boolean g(String str, boolean z4) {
        String property = System.getenv(str);
        if (property == null) {
            property = System.getProperty(str);
        }
        return z4 ? Z1.q.a(property) || Boolean.parseBoolean(property) : !Z1.q.a(property) && Boolean.parseBoolean(property);
    }

    public static String h(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            sb.append(str2);
            sb.append(' ');
        }
        sb.append("grpc-java-");
        sb.append(str);
        sb.append('/');
        sb.append("1.62.2");
        return sb.toString();
    }

    public static String i(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", new Class[0]).invoke(inetSocketAddress, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static ThreadFactory j(String str, boolean z4) {
        return new C1235g().e(z4).f(str).b();
    }

    public static InterfaceC0445t k(S.f fVar, boolean z4) {
        S.i iVarC = fVar.c();
        InterfaceC0445t interfaceC0445tA = iVarC != null ? ((T0) iVarC.e()).a() : null;
        if (interfaceC0445tA != null) {
            AbstractC0363k.a aVarB = fVar.b();
            return aVarB == null ? interfaceC0445tA : new f(aVarB, interfaceC0445tA);
        }
        if (!fVar.a().o()) {
            if (fVar.d()) {
                return new H(o(fVar.a()), InterfaceC0443s.a.DROPPED);
            }
            if (!z4) {
                return new H(o(fVar.a()), InterfaceC0443s.a.PROCESSED);
            }
        }
        return null;
    }

    public static l0.b l(int i4) {
        if (i4 >= 100 && i4 < 200) {
            return l0.b.INTERNAL;
        }
        if (i4 != 400) {
            if (i4 == 401) {
                return l0.b.UNAUTHENTICATED;
            }
            if (i4 == 403) {
                return l0.b.PERMISSION_DENIED;
            }
            if (i4 == 404) {
                return l0.b.UNIMPLEMENTED;
            }
            if (i4 != 429) {
                if (i4 != 431) {
                    switch (i4) {
                        case 502:
                        case 503:
                        case 504:
                            break;
                        default:
                            return l0.b.UNKNOWN;
                    }
                }
            }
            return l0.b.UNAVAILABLE;
        }
        return l0.b.INTERNAL;
    }

    public static K2.l0 m(int i4) {
        return l(i4).c().q("HTTP status code " + i4);
    }

    public static boolean n(String str) {
        char cCharAt;
        if (str == null || 16 > str.length()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (lowerCase.startsWith("application/grpc")) {
            return lowerCase.length() == 16 || (cCharAt = lowerCase.charAt(16)) == '+' || cCharAt == ';';
        }
        return false;
    }

    public static K2.l0 o(K2.l0 l0Var) {
        Z1.m.d(l0Var != null);
        if (!f1956b.contains(l0Var.m())) {
            return l0Var;
        }
        return K2.l0.f1229s.q("Inappropriate status code from control plane: " + l0Var.m() + " " + l0Var.n()).p(l0Var.l());
    }

    public static boolean p(C0355c c0355c) {
        return !Boolean.TRUE.equals(c0355c.h(f1973s));
    }
}
