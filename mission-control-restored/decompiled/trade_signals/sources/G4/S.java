package G4;

import F4.AbstractC0497k;
import F4.C0489c;
import F4.K;
import F4.P;
import F4.X;
import F4.j0;
import G4.InterfaceC0551s;
import G4.L0;
import G4.Q0;
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
import v2.AbstractC2848n;
import v2.AbstractC2852r;
import v2.C2850p;
import v2.C2851q;
import v2.InterfaceC2853s;

/* JADX INFO: loaded from: classes2.dex */
public abstract class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f2543a = Logger.getLogger(S.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f2544b = Collections.unmodifiableSet(EnumSet.of(j0.b.OK, j0.b.INVALID_ARGUMENT, j0.b.NOT_FOUND, j0.b.ALREADY_EXISTS, j0.b.FAILED_PRECONDITION, j0.b.ABORTED, j0.b.OUT_OF_RANGE, j0.b.DATA_LOSS));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f2545c = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final X.g f2546d = X.g.e("grpc-timeout", new i());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final X.g f2547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final X.g f2548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final X.g f2549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final X.g f2550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final X.g f2551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final X.g f2552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final X.g f2553k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final X.g f2554l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C2850p f2555m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f2556n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f2557o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f2558p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final F4.f0 f2559q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final F4.f0 f2560r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final C0489c.C0029c f2561s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final AbstractC0497k f2562t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final L0.d f2563u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final L0.d f2564v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final InterfaceC2853s f2565w;

    public class a implements F4.f0 {
        @Override // F4.f0
        public F4.e0 a(SocketAddress socketAddress) {
            return null;
        }
    }

    public class b extends AbstractC0497k {
    }

    public class c implements L0.d {
        @Override // G4.L0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // G4.L0.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Executor a() {
            return Executors.newCachedThreadPool(S.j("grpc-default-executor-%d", true));
        }

        public String toString() {
            return "grpc-default-executor";
        }
    }

    public class d implements L0.d {
        @Override // G4.L0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }

        @Override // G4.L0.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ScheduledExecutorService a() {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, S.j("grpc-timer-%d", true));
            try {
                scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
            } catch (RuntimeException e8) {
                throw e8;
            } catch (Exception e9) {
                throw new RuntimeException(e9);
            }
            return Executors.unconfigurableScheduledExecutorService(scheduledExecutorServiceNewScheduledThreadPool);
        }
    }

    public class e implements InterfaceC2853s {
        @Override // v2.InterfaceC2853s
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C2851q get() {
            return C2851q.c();
        }
    }

    public class f implements InterfaceC0553t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0497k.a f2566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0553t f2567b;

        public f(AbstractC0497k.a aVar, InterfaceC0553t interfaceC0553t) {
            this.f2566a = aVar;
            this.f2567b = interfaceC0553t;
        }

        @Override // G4.InterfaceC0553t
        public r e(F4.Y y7, F4.X x8, C0489c c0489c, AbstractC0497k[] abstractC0497kArr) {
            AbstractC0497k abstractC0497kA = this.f2566a.a(AbstractC0497k.b.a().b(c0489c).a(), x8);
            AbstractC2848n.u(abstractC0497kArr[abstractC0497kArr.length - 1] == S.f2562t, "lb tracer already assigned");
            abstractC0497kArr[abstractC0497kArr.length - 1] = abstractC0497kA;
            return this.f2567b.e(y7, x8, c0489c, abstractC0497kArr);
        }

        @Override // F4.N
        public F4.J h() {
            return this.f2567b.h();
        }
    }

    public static final class g implements K.a {
        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        @Override // F4.X.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(byte[] bArr) {
            return bArr;
        }

        @Override // F4.X.j
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
        public static final h f2568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final h f2569d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final h f2570e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h f2571f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final h f2572g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final h f2573h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final h f2574i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final h f2575j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final h f2576k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final h f2577l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final h f2578m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final h f2579n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final h f2580o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final h f2581p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final h[] f2582q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final /* synthetic */ h[] f2583r;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final F4.j0 f2585b;

        static {
            F4.j0 j0Var = F4.j0.f1812t;
            h hVar = new h("NO_ERROR", 0, 0, j0Var);
            f2568c = hVar;
            F4.j0 j0Var2 = F4.j0.f1811s;
            h hVar2 = new h("PROTOCOL_ERROR", 1, 1, j0Var2);
            f2569d = hVar2;
            h hVar3 = new h("INTERNAL_ERROR", 2, 2, j0Var2);
            f2570e = hVar3;
            h hVar4 = new h("FLOW_CONTROL_ERROR", 3, 3, j0Var2);
            f2571f = hVar4;
            h hVar5 = new h("SETTINGS_TIMEOUT", 4, 4, j0Var2);
            f2572g = hVar5;
            h hVar6 = new h("STREAM_CLOSED", 5, 5, j0Var2);
            f2573h = hVar6;
            h hVar7 = new h("FRAME_SIZE_ERROR", 6, 6, j0Var2);
            f2574i = hVar7;
            h hVar8 = new h("REFUSED_STREAM", 7, 7, j0Var);
            f2575j = hVar8;
            h hVar9 = new h("CANCEL", 8, 8, F4.j0.f1798f);
            f2576k = hVar9;
            h hVar10 = new h("COMPRESSION_ERROR", 9, 9, j0Var2);
            f2577l = hVar10;
            h hVar11 = new h("CONNECT_ERROR", 10, 10, j0Var2);
            f2578m = hVar11;
            h hVar12 = new h("ENHANCE_YOUR_CALM", 11, 11, F4.j0.f1806n.r("Bandwidth exhausted"));
            f2579n = hVar12;
            h hVar13 = new h("INADEQUATE_SECURITY", 12, 12, F4.j0.f1804l.r("Permission denied as protocol is not secure enough to call"));
            f2580o = hVar13;
            h hVar14 = new h("HTTP_1_1_REQUIRED", 13, 13, F4.j0.f1799g);
            f2581p = hVar14;
            f2583r = new h[]{hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, hVar10, hVar11, hVar12, hVar13, hVar14};
            f2582q = a();
        }

        public h(String str, int i8, int i9, F4.j0 j0Var) {
            this.f2584a = i9;
            String str2 = "HTTP/2 error code: " + name();
            if (j0Var.o() != null) {
                str2 = str2 + " (" + j0Var.o() + ")";
            }
            this.f2585b = j0Var.r(str2);
        }

        public static h[] a() {
            h[] hVarArrValues = values();
            h[] hVarArr = new h[((int) hVarArrValues[hVarArrValues.length - 1].b()) + 1];
            for (h hVar : hVarArrValues) {
                hVarArr[(int) hVar.b()] = hVar;
            }
            return hVarArr;
        }

        public static h g(long j8) {
            h[] hVarArr = f2582q;
            if (j8 >= hVarArr.length || j8 < 0) {
                return null;
            }
            return hVarArr[(int) j8];
        }

        public static F4.j0 k(long j8) {
            h hVarG = g(j8);
            if (hVarG != null) {
                return hVarG.i();
            }
            return F4.j0.i(f2570e.i().n().g()).r("Unrecognized HTTP/2 error code: " + j8);
        }

        public static h valueOf(String str) {
            return (h) Enum.valueOf(h.class, str);
        }

        public static h[] values() {
            return (h[]) f2583r.clone();
        }

        public long b() {
            return this.f2584a;
        }

        public F4.j0 i() {
            return this.f2585b;
        }
    }

    public static class i implements X.d {
        @Override // F4.X.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Long b(String str) {
            TimeUnit timeUnit;
            AbstractC2848n.e(str.length() > 0, "empty timeout");
            AbstractC2848n.e(str.length() <= 9, "bad timeout format");
            long j8 = Long.parseLong(str.substring(0, str.length() - 1));
            char cCharAt = str.charAt(str.length() - 1);
            if (cCharAt == 'H') {
                timeUnit = TimeUnit.HOURS;
            } else if (cCharAt == 'M') {
                timeUnit = TimeUnit.MINUTES;
            } else if (cCharAt == 'S') {
                timeUnit = TimeUnit.SECONDS;
            } else if (cCharAt == 'u') {
                timeUnit = TimeUnit.MICROSECONDS;
            } else {
                if (cCharAt != 'm') {
                    if (cCharAt == 'n') {
                        return Long.valueOf(j8);
                    }
                    throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(cCharAt)));
                }
                timeUnit = TimeUnit.MILLISECONDS;
            }
            return Long.valueOf(timeUnit.toNanos(j8));
        }

        @Override // F4.X.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(Long l8) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l8.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            }
            if (l8.longValue() < 100000000) {
                return l8 + "n";
            }
            if (l8.longValue() < 100000000000L) {
                return timeUnit.toMicros(l8.longValue()) + "u";
            }
            if (l8.longValue() < 100000000000000L) {
                return timeUnit.toMillis(l8.longValue()) + "m";
            }
            if (l8.longValue() < 100000000000000000L) {
                return timeUnit.toSeconds(l8.longValue()) + "S";
            }
            if (l8.longValue() < 6000000000000000000L) {
                return timeUnit.toMinutes(l8.longValue()) + "M";
            }
            return timeUnit.toHours(l8.longValue()) + "H";
        }
    }

    static {
        X.d dVar = F4.X.f1686e;
        f2547e = X.g.e("grpc-encoding", dVar);
        a aVar = null;
        f2548f = F4.K.b("grpc-accept-encoding", new g(aVar));
        f2549g = X.g.e("content-encoding", dVar);
        f2550h = F4.K.b("accept-encoding", new g(aVar));
        f2551i = X.g.e("content-length", dVar);
        f2552j = X.g.e("content-type", dVar);
        f2553k = X.g.e("te", dVar);
        f2554l = X.g.e("user-agent", dVar);
        f2555m = C2850p.a(',').c();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f2556n = timeUnit.toNanos(20L);
        f2557o = TimeUnit.HOURS.toNanos(2L);
        f2558p = timeUnit.toNanos(20L);
        f2559q = new x0();
        f2560r = new a();
        f2561s = C0489c.C0029c.b("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        f2562t = new b();
        f2563u = new c();
        f2564v = new d();
        f2565w = new e();
    }

    public static URI b(String str) {
        AbstractC2848n.o(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e8) {
            throw new IllegalArgumentException("Invalid authority: " + str, e8);
        }
    }

    public static String c(String str) {
        AbstractC2848n.j(b(str).getAuthority().indexOf(64) == -1, "Userinfo must not be present on authority: '%s'", str);
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
        } catch (IOException e8) {
            f2543a.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e8);
        }
    }

    public static AbstractC0497k[] f(C0489c c0489c, F4.X x8, int i8, boolean z7) {
        List listI = c0489c.i();
        int size = listI.size();
        AbstractC0497k[] abstractC0497kArr = new AbstractC0497k[size + 1];
        AbstractC0497k.b bVarA = AbstractC0497k.b.a().b(c0489c).d(i8).c(z7).a();
        for (int i9 = 0; i9 < listI.size(); i9++) {
            abstractC0497kArr[i9] = ((AbstractC0497k.a) listI.get(i9)).a(bVarA, x8);
        }
        abstractC0497kArr[size] = f2562t;
        return abstractC0497kArr;
    }

    public static boolean g(String str, boolean z7) {
        String property = System.getenv(str);
        if (property == null) {
            property = System.getProperty(str);
        }
        return z7 ? AbstractC2852r.b(property) || Boolean.parseBoolean(property) : !AbstractC2852r.b(property) && Boolean.parseBoolean(property);
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
        return new A2.j().e(z7).f(str).b();
    }

    public static InterfaceC0553t k(P.f fVar, boolean z7) {
        P.i iVarC = fVar.c();
        InterfaceC0553t interfaceC0553tA = iVarC != null ? ((T0) iVarC.e()).a() : null;
        if (interfaceC0553tA != null) {
            AbstractC0497k.a aVarB = fVar.b();
            return aVarB == null ? interfaceC0553tA : new f(aVarB, interfaceC0553tA);
        }
        if (!fVar.a().p()) {
            if (fVar.d()) {
                return new H(o(fVar.a()), InterfaceC0551s.a.DROPPED);
            }
            if (!z7) {
                return new H(o(fVar.a()), InterfaceC0551s.a.PROCESSED);
            }
        }
        return null;
    }

    public static j0.b l(int i8) {
        if (i8 >= 100 && i8 < 200) {
            return j0.b.INTERNAL;
        }
        if (i8 != 400) {
            if (i8 == 401) {
                return j0.b.UNAUTHENTICATED;
            }
            if (i8 == 403) {
                return j0.b.PERMISSION_DENIED;
            }
            if (i8 == 404) {
                return j0.b.UNIMPLEMENTED;
            }
            if (i8 != 429) {
                if (i8 != 431) {
                    switch (i8) {
                        case 502:
                        case 503:
                        case 504:
                            break;
                        default:
                            return j0.b.UNKNOWN;
                    }
                }
            }
            return j0.b.UNAVAILABLE;
        }
        return j0.b.INTERNAL;
    }

    public static F4.j0 m(int i8) {
        return l(i8).b().r("HTTP status code " + i8);
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

    public static F4.j0 o(F4.j0 j0Var) {
        AbstractC2848n.d(j0Var != null);
        if (!f2544b.contains(j0Var.n())) {
            return j0Var;
        }
        return F4.j0.f1811s.r("Inappropriate status code from control plane: " + j0Var.n() + " " + j0Var.o()).q(j0Var.m());
    }

    public static boolean p(C0489c c0489c) {
        return !Boolean.TRUE.equals(c0489c.h(f2561s));
    }
}
