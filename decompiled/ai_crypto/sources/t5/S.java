package t5;

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
import r5.AbstractC2595k;
import r5.C2587c;
import r5.M;
import r5.S;
import r5.Z;
import r5.l0;
import t5.InterfaceC2698s;
import t5.L0;
import t5.Q0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f23506a = Logger.getLogger(S.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f23507b = Collections.unmodifiableSet(EnumSet.of(l0.b.OK, l0.b.INVALID_ARGUMENT, l0.b.NOT_FOUND, l0.b.ALREADY_EXISTS, l0.b.FAILED_PRECONDITION, l0.b.ABORTED, l0.b.OUT_OF_RANGE, l0.b.DATA_LOSS));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f23508c = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Z.g f23509d = Z.g.e("grpc-timeout", new i());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Z.g f23510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Z.g f23511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Z.g f23512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Z.g f23513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Z.g f23514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Z.g f23515j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Z.g f23516k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Z.g f23517l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final H2.o f23518m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f23519n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f23520o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f23521p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final r5.h0 f23522q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final r5.h0 f23523r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final C2587c.C0351c f23524s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final AbstractC2595k f23525t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final L0.d f23526u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final L0.d f23527v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final H2.r f23528w;

    public class a implements r5.h0 {
        @Override // r5.h0
        public r5.g0 a(SocketAddress socketAddress) {
            return null;
        }
    }

    public class b extends AbstractC2595k {
    }

    public class c implements L0.d {
        @Override // t5.L0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // t5.L0.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Executor a() {
            return Executors.newCachedThreadPool(S.j("grpc-default-executor-%d", true));
        }

        public String toString() {
            return "grpc-default-executor";
        }
    }

    public class d implements L0.d {
        @Override // t5.L0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }

        @Override // t5.L0.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ScheduledExecutorService a() {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, S.j("grpc-timer-%d", true));
            try {
                scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Exception e8) {
                throw new RuntimeException(e8);
            }
            return Executors.unconfigurableScheduledExecutorService(scheduledExecutorServiceNewScheduledThreadPool);
        }
    }

    public class e implements H2.r {
        @Override // H2.r
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public H2.p get() {
            return H2.p.c();
        }
    }

    public class f implements InterfaceC2700t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC2595k.a f23529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2700t f23530b;

        public f(AbstractC2595k.a aVar, InterfaceC2700t interfaceC2700t) {
            this.f23529a = aVar;
            this.f23530b = interfaceC2700t;
        }

        @Override // t5.InterfaceC2700t
        public r f(r5.a0 a0Var, r5.Z z7, C2587c c2587c, AbstractC2595k[] abstractC2595kArr) {
            AbstractC2595k abstractC2595kA = this.f23529a.a(AbstractC2595k.b.a().b(c2587c).a(), z7);
            H2.m.u(abstractC2595kArr[abstractC2595kArr.length - 1] == S.f23525t, "lb tracer already assigned");
            abstractC2595kArr[abstractC2595kArr.length - 1] = abstractC2595kA;
            return this.f23530b.f(a0Var, z7, c2587c, abstractC2595kArr);
        }

        @Override // r5.P
        public r5.K h() {
            return this.f23530b.h();
        }
    }

    public static final class g implements M.a {
        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        @Override // r5.Z.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(byte[] bArr) {
            return bArr;
        }

        @Override // r5.Z.j
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
        public static final h f23531c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final h f23532d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final h f23533e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h f23534f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final h f23535g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final h f23536h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final h f23537i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final h f23538j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final h f23539k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final h f23540l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final h f23541m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final h f23542n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final h f23543o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final h f23544p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final h[] f23545q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final /* synthetic */ h[] f23546r;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f23547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r5.l0 f23548b;

        static {
            r5.l0 l0Var = r5.l0.f22720t;
            h hVar = new h("NO_ERROR", 0, 0, l0Var);
            f23531c = hVar;
            r5.l0 l0Var2 = r5.l0.f22719s;
            h hVar2 = new h("PROTOCOL_ERROR", 1, 1, l0Var2);
            f23532d = hVar2;
            h hVar3 = new h("INTERNAL_ERROR", 2, 2, l0Var2);
            f23533e = hVar3;
            h hVar4 = new h("FLOW_CONTROL_ERROR", 3, 3, l0Var2);
            f23534f = hVar4;
            h hVar5 = new h("SETTINGS_TIMEOUT", 4, 4, l0Var2);
            f23535g = hVar5;
            h hVar6 = new h("STREAM_CLOSED", 5, 5, l0Var2);
            f23536h = hVar6;
            h hVar7 = new h("FRAME_SIZE_ERROR", 6, 6, l0Var2);
            f23537i = hVar7;
            h hVar8 = new h("REFUSED_STREAM", 7, 7, l0Var);
            f23538j = hVar8;
            h hVar9 = new h("CANCEL", 8, 8, r5.l0.f22706f);
            f23539k = hVar9;
            h hVar10 = new h("COMPRESSION_ERROR", 9, 9, l0Var2);
            f23540l = hVar10;
            h hVar11 = new h("CONNECT_ERROR", 10, 10, l0Var2);
            f23541m = hVar11;
            h hVar12 = new h("ENHANCE_YOUR_CALM", 11, 11, r5.l0.f22714n.q("Bandwidth exhausted"));
            f23542n = hVar12;
            h hVar13 = new h("INADEQUATE_SECURITY", 12, 12, r5.l0.f22712l.q("Permission denied as protocol is not secure enough to call"));
            f23543o = hVar13;
            h hVar14 = new h("HTTP_1_1_REQUIRED", 13, 13, r5.l0.f22707g);
            f23544p = hVar14;
            f23546r = new h[]{hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, hVar10, hVar11, hVar12, hVar13, hVar14};
            f23545q = a();
        }

        public h(String str, int i7, int i8, r5.l0 l0Var) {
            this.f23547a = i8;
            String str2 = "HTTP/2 error code: " + name();
            if (l0Var.n() != null) {
                str2 = str2 + " (" + l0Var.n() + ")";
            }
            this.f23548b = l0Var.q(str2);
        }

        public static h[] a() {
            h[] hVarArrValues = values();
            h[] hVarArr = new h[((int) hVarArrValues[hVarArrValues.length - 1].b()) + 1];
            for (h hVar : hVarArrValues) {
                hVarArr[(int) hVar.b()] = hVar;
            }
            return hVarArr;
        }

        public static h c(long j7) {
            h[] hVarArr = f23545q;
            if (j7 >= hVarArr.length || j7 < 0) {
                return null;
            }
            return hVarArr[(int) j7];
        }

        public static r5.l0 i(long j7) {
            h hVarC = c(j7);
            if (hVarC != null) {
                return hVarC.h();
            }
            return r5.l0.h(f23533e.h().m().c()).q("Unrecognized HTTP/2 error code: " + j7);
        }

        public static h valueOf(String str) {
            return (h) Enum.valueOf(h.class, str);
        }

        public static h[] values() {
            return (h[]) f23546r.clone();
        }

        public long b() {
            return this.f23547a;
        }

        public r5.l0 h() {
            return this.f23548b;
        }
    }

    public static class i implements Z.d {
        @Override // r5.Z.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Long b(String str) {
            H2.m.e(str.length() > 0, "empty timeout");
            H2.m.e(str.length() <= 9, "bad timeout format");
            long j7 = Long.parseLong(str.substring(0, str.length() - 1));
            char cCharAt = str.charAt(str.length() - 1);
            if (cCharAt == 'H') {
                return Long.valueOf(TimeUnit.HOURS.toNanos(j7));
            }
            if (cCharAt == 'M') {
                return Long.valueOf(TimeUnit.MINUTES.toNanos(j7));
            }
            if (cCharAt == 'S') {
                return Long.valueOf(TimeUnit.SECONDS.toNanos(j7));
            }
            if (cCharAt == 'u') {
                return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(j7));
            }
            if (cCharAt == 'm') {
                return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(j7));
            }
            if (cCharAt == 'n') {
                return Long.valueOf(j7);
            }
            throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(cCharAt)));
        }

        @Override // r5.Z.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(Long l7) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l7.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            }
            if (l7.longValue() < 100000000) {
                return l7 + "n";
            }
            if (l7.longValue() < 100000000000L) {
                return timeUnit.toMicros(l7.longValue()) + "u";
            }
            if (l7.longValue() < 100000000000000L) {
                return timeUnit.toMillis(l7.longValue()) + "m";
            }
            if (l7.longValue() < 100000000000000000L) {
                return timeUnit.toSeconds(l7.longValue()) + "S";
            }
            if (l7.longValue() < 6000000000000000000L) {
                return timeUnit.toMinutes(l7.longValue()) + "M";
            }
            return timeUnit.toHours(l7.longValue()) + "H";
        }
    }

    static {
        Z.d dVar = r5.Z.f22587e;
        f23510e = Z.g.e("grpc-encoding", dVar);
        a aVar = null;
        f23511f = r5.M.b("grpc-accept-encoding", new g(aVar));
        f23512g = Z.g.e("content-encoding", dVar);
        f23513h = r5.M.b("accept-encoding", new g(aVar));
        f23514i = Z.g.e("content-length", dVar);
        f23515j = Z.g.e("content-type", dVar);
        f23516k = Z.g.e("te", dVar);
        f23517l = Z.g.e("user-agent", dVar);
        f23518m = H2.o.a(',').c();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f23519n = timeUnit.toNanos(20L);
        f23520o = TimeUnit.HOURS.toNanos(2L);
        f23521p = timeUnit.toNanos(20L);
        f23522q = new x0();
        f23523r = new a();
        f23524s = C2587c.C0351c.b("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        f23525t = new b();
        f23526u = new c();
        f23527v = new d();
        f23528w = new e();
    }

    public static URI b(String str) {
        H2.m.o(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e7) {
            throw new IllegalArgumentException("Invalid authority: " + str, e7);
        }
    }

    public static String c(String str) {
        H2.m.j(b(str).getAuthority().indexOf(64) == -1, "Userinfo must not be present on authority: '%s'", str);
        return str;
    }

    public static void d(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e7) {
            f23506a.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e7);
        }
    }

    public static void e(Q0.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                d(next);
            }
        }
    }

    public static AbstractC2595k[] f(C2587c c2587c, r5.Z z7, int i7, boolean z8) {
        List listI = c2587c.i();
        int size = listI.size();
        AbstractC2595k[] abstractC2595kArr = new AbstractC2595k[size + 1];
        AbstractC2595k.b bVarA = AbstractC2595k.b.a().b(c2587c).d(i7).c(z8).a();
        for (int i8 = 0; i8 < listI.size(); i8++) {
            abstractC2595kArr[i8] = ((AbstractC2595k.a) listI.get(i8)).a(bVarA, z7);
        }
        abstractC2595kArr[size] = f23525t;
        return abstractC2595kArr;
    }

    public static boolean g(String str, boolean z7) {
        String property = System.getenv(str);
        if (property == null) {
            property = System.getProperty(str);
        }
        return z7 ? H2.q.a(property) || Boolean.parseBoolean(property) : !H2.q.a(property) && Boolean.parseBoolean(property);
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
            return (String) InetSocketAddress.class.getMethod("getHostString", null).invoke(inetSocketAddress, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static ThreadFactory j(String str, boolean z7) {
        return new M2.g().e(z7).f(str).b();
    }

    public static InterfaceC2700t k(S.f fVar, boolean z7) {
        S.i iVarC = fVar.c();
        InterfaceC2700t interfaceC2700tA = iVarC != null ? ((T0) iVarC.e()).a() : null;
        if (interfaceC2700tA != null) {
            AbstractC2595k.a aVarB = fVar.b();
            return aVarB == null ? interfaceC2700tA : new f(aVarB, interfaceC2700tA);
        }
        if (!fVar.a().o()) {
            if (fVar.d()) {
                return new H(o(fVar.a()), InterfaceC2698s.a.DROPPED);
            }
            if (!z7) {
                return new H(o(fVar.a()), InterfaceC2698s.a.PROCESSED);
            }
        }
        return null;
    }

    public static l0.b l(int i7) {
        if (i7 >= 100 && i7 < 200) {
            return l0.b.INTERNAL;
        }
        if (i7 != 400) {
            if (i7 == 401) {
                return l0.b.UNAUTHENTICATED;
            }
            if (i7 == 403) {
                return l0.b.PERMISSION_DENIED;
            }
            if (i7 == 404) {
                return l0.b.UNIMPLEMENTED;
            }
            if (i7 != 429) {
                if (i7 != 431) {
                    switch (i7) {
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

    public static r5.l0 m(int i7) {
        return l(i7).b().q("HTTP status code " + i7);
    }

    public static boolean n(String str) {
        if (str == null || 16 > str.length()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (!lowerCase.startsWith("application/grpc")) {
            return false;
        }
        if (lowerCase.length() == 16) {
            return true;
        }
        char cCharAt = lowerCase.charAt(16);
        return cCharAt == '+' || cCharAt == ';';
    }

    public static r5.l0 o(r5.l0 l0Var) {
        H2.m.d(l0Var != null);
        if (!f23507b.contains(l0Var.m())) {
            return l0Var;
        }
        return r5.l0.f22719s.q("Inappropriate status code from control plane: " + l0Var.m() + " " + l0Var.n()).p(l0Var.l());
    }

    public static boolean p(C2587c c2587c) {
        return !Boolean.TRUE.equals(c2587c.h(f23524s));
    }
}
