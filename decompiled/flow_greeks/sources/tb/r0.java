package tb;

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
import rb.c;
import rb.k;
import rb.k1;
import rb.m0;
import rb.r0;
import rb.y0;
import tb.k2;
import tb.p2;
import tb.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f21624a = Logger.getLogger(r0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f21625b = Collections.unmodifiableSet(EnumSet.of(k1.b.OK, k1.b.INVALID_ARGUMENT, k1.b.NOT_FOUND, k1.b.ALREADY_EXISTS, k1.b.FAILED_PRECONDITION, k1.b.ABORTED, k1.b.OUT_OF_RANGE, k1.b.DATA_LOSS));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f21626c = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y0.g f21627d = y0.g.e("grpc-timeout", new i());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y0.g f21628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y0.g f21629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final y0.g f21630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y0.g f21631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final y0.g f21632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final y0.g f21633j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final y0.g f21634k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final y0.g f21635l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final p6.p f21636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f21637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f21638o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f21639p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final rb.g1 f21640q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final rb.g1 f21641r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final c.C0344c f21642s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final rb.k f21643t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final k2.d f21644u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final k2.d f21645v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final p6.s f21646w;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements rb.g1 {
        @Override // rb.g1
        public rb.f1 a(SocketAddress socketAddress) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends rb.k {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements k2.d {
        @Override // tb.k2.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // tb.k2.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Executor a() {
            return Executors.newCachedThreadPool(r0.j("grpc-default-executor-%d", true));
        }

        public String toString() {
            return "grpc-default-executor";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements k2.d {
        @Override // tb.k2.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }

        @Override // tb.k2.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ScheduledExecutorService a() {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, r0.j("grpc-timer-%d", true));
            try {
                scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
            return Executors.unconfigurableScheduledExecutorService(scheduledExecutorServiceNewScheduledThreadPool);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements p6.s {
        @Override // p6.s
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p6.q get() {
            return p6.q.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k.a f21647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f21648b;

        public f(k.a aVar, t tVar) {
            this.f21647a = aVar;
            this.f21648b = tVar;
        }

        @Override // rb.p0
        public rb.k0 f() {
            return this.f21648b.f();
        }

        @Override // tb.t
        public r g(rb.z0 z0Var, rb.y0 y0Var, rb.c cVar, rb.k[] kVarArr) {
            rb.k kVarA = this.f21647a.a(k.b.a().b(cVar).a(), y0Var);
            p6.n.u(kVarArr[kVarArr.length - 1] == r0.f21643t, "lb tracer already assigned");
            kVarArr[kVarArr.length - 1] = kVarA;
            return this.f21648b.g(z0Var, y0Var, cVar, kVarArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g implements m0.a {
        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        @Override // rb.y0.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(byte[] bArr) {
            return bArr;
        }

        @Override // rb.y0.j
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
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f21649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final h f21650d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final h f21651e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h f21652f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final h f21653g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final h f21654h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final h f21655i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final h f21656j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final h f21657k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final h f21658l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final h f21659m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final h f21660n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final h f21661o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final h f21662p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final h[] f21663q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final /* synthetic */ h[] f21664r;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rb.k1 f21666b;

        static {
            rb.k1 k1Var = rb.k1.f19607t;
            h hVar = new h("NO_ERROR", 0, 0, k1Var);
            f21649c = hVar;
            rb.k1 k1Var2 = rb.k1.f19606s;
            h hVar2 = new h("PROTOCOL_ERROR", 1, 1, k1Var2);
            f21650d = hVar2;
            h hVar3 = new h("INTERNAL_ERROR", 2, 2, k1Var2);
            f21651e = hVar3;
            h hVar4 = new h("FLOW_CONTROL_ERROR", 3, 3, k1Var2);
            f21652f = hVar4;
            h hVar5 = new h("SETTINGS_TIMEOUT", 4, 4, k1Var2);
            f21653g = hVar5;
            h hVar6 = new h("STREAM_CLOSED", 5, 5, k1Var2);
            f21654h = hVar6;
            h hVar7 = new h("FRAME_SIZE_ERROR", 6, 6, k1Var2);
            f21655i = hVar7;
            h hVar8 = new h("REFUSED_STREAM", 7, 7, k1Var);
            f21656j = hVar8;
            h hVar9 = new h("CANCEL", 8, 8, rb.k1.f19593f);
            f21657k = hVar9;
            h hVar10 = new h("COMPRESSION_ERROR", 9, 9, k1Var2);
            f21658l = hVar10;
            h hVar11 = new h("CONNECT_ERROR", 10, 10, k1Var2);
            f21659m = hVar11;
            h hVar12 = new h("ENHANCE_YOUR_CALM", 11, 11, rb.k1.f19601n.r("Bandwidth exhausted"));
            f21660n = hVar12;
            h hVar13 = new h("INADEQUATE_SECURITY", 12, 12, rb.k1.f19599l.r("Permission denied as protocol is not secure enough to call"));
            f21661o = hVar13;
            h hVar14 = new h("HTTP_1_1_REQUIRED", 13, 13, rb.k1.f19594g);
            f21662p = hVar14;
            f21664r = new h[]{hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, hVar10, hVar11, hVar12, hVar13, hVar14};
            f21663q = a();
        }

        public h(String str, int i10, int i11, rb.k1 k1Var) {
            this.f21665a = i11;
            String str2 = "HTTP/2 error code: " + name();
            if (k1Var.o() != null) {
                str2 = str2 + " (" + k1Var.o() + ")";
            }
            this.f21666b = k1Var.r(str2);
        }

        public static h[] a() {
            h[] hVarArrValues = values();
            h[] hVarArr = new h[((int) hVarArrValues[hVarArrValues.length - 1].b()) + 1];
            for (h hVar : hVarArrValues) {
                hVarArr[(int) hVar.b()] = hVar;
            }
            return hVarArr;
        }

        public static h c(long j10) {
            h[] hVarArr = f21663q;
            if (j10 >= hVarArr.length || j10 < 0) {
                return null;
            }
            return hVarArr[(int) j10];
        }

        public static rb.k1 i(long j10) {
            h hVarC = c(j10);
            if (hVarC != null) {
                return hVarC.h();
            }
            return rb.k1.i(f21651e.h().n().c()).r("Unrecognized HTTP/2 error code: " + j10);
        }

        public static h valueOf(String str) {
            return (h) Enum.valueOf(h.class, str);
        }

        public static h[] values() {
            return (h[]) f21664r.clone();
        }

        public long b() {
            return this.f21665a;
        }

        public rb.k1 h() {
            return this.f21666b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class i implements y0.d {
        @Override // rb.y0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Long b(String str) {
            p6.n.e(str.length() > 0, "empty timeout");
            p6.n.e(str.length() <= 9, "bad timeout format");
            long j10 = Long.parseLong(str.substring(0, str.length() - 1));
            char cCharAt = str.charAt(str.length() - 1);
            if (cCharAt == 'H') {
                return Long.valueOf(TimeUnit.HOURS.toNanos(j10));
            }
            if (cCharAt == 'M') {
                return Long.valueOf(TimeUnit.MINUTES.toNanos(j10));
            }
            if (cCharAt == 'S') {
                return Long.valueOf(TimeUnit.SECONDS.toNanos(j10));
            }
            if (cCharAt == 'u') {
                return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(j10));
            }
            if (cCharAt == 'm') {
                return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(j10));
            }
            if (cCharAt == 'n') {
                return Long.valueOf(j10);
            }
            throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(cCharAt)));
        }

        @Override // rb.y0.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(Long l10) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l10.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            }
            if (l10.longValue() < 100000000) {
                return l10 + "n";
            }
            if (l10.longValue() < 100000000000L) {
                return timeUnit.toMicros(l10.longValue()) + "u";
            }
            if (l10.longValue() < 100000000000000L) {
                return timeUnit.toMillis(l10.longValue()) + "m";
            }
            if (l10.longValue() < 100000000000000000L) {
                return timeUnit.toSeconds(l10.longValue()) + "S";
            }
            if (l10.longValue() < 6000000000000000000L) {
                return timeUnit.toMinutes(l10.longValue()) + "M";
            }
            return timeUnit.toHours(l10.longValue()) + "H";
        }
    }

    static {
        y0.d dVar = rb.y0.f19747e;
        f21628e = y0.g.e("grpc-encoding", dVar);
        a aVar = null;
        f21629f = rb.m0.b("grpc-accept-encoding", new g(aVar));
        f21630g = y0.g.e("content-encoding", dVar);
        f21631h = rb.m0.b("accept-encoding", new g(aVar));
        f21632i = y0.g.e("content-length", dVar);
        f21633j = y0.g.e("content-type", dVar);
        f21634k = y0.g.e("te", dVar);
        f21635l = y0.g.e("user-agent", dVar);
        f21636m = p6.p.a(',').c();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f21637n = timeUnit.toNanos(20L);
        f21638o = TimeUnit.HOURS.toNanos(2L);
        f21639p = timeUnit.toNanos(20L);
        f21640q = new w1();
        f21641r = new a();
        f21642s = c.C0344c.b("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        f21643t = new b();
        f21644u = new c();
        f21645v = new d();
        f21646w = new e();
    }

    public static URI b(String str) {
        String str2;
        p6.n.o(str, "authority");
        try {
            str2 = str;
            try {
                return new URI(null, str2, null, null, null);
            } catch (URISyntaxException e10) {
                e = e10;
                throw new IllegalArgumentException("Invalid authority: " + str2, e);
            }
        } catch (URISyntaxException e11) {
            e = e11;
            str2 = str;
        }
    }

    public static String c(String str) {
        p6.n.j(b(str).getAuthority().indexOf(64) == -1, "Userinfo must not be present on authority: '%s'", str);
        return str;
    }

    public static void d(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e10) {
            f21624a.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e10);
        }
    }

    public static void e(p2.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                d(next);
            }
        }
    }

    public static rb.k[] f(rb.c cVar, rb.y0 y0Var, int i10, boolean z10) {
        List listI = cVar.i();
        int size = listI.size();
        rb.k[] kVarArr = new rb.k[size + 1];
        k.b bVarA = k.b.a().b(cVar).d(i10).c(z10).a();
        for (int i11 = 0; i11 < listI.size(); i11++) {
            kVarArr[i11] = ((k.a) listI.get(i11)).a(bVarA, y0Var);
        }
        kVarArr[size] = f21643t;
        return kVarArr;
    }

    public static boolean g(String str, boolean z10) {
        String property = System.getenv(str);
        if (property == null) {
            property = System.getProperty(str);
        }
        return z10 ? p6.r.b(property) || Boolean.parseBoolean(property) : !p6.r.b(property) && Boolean.parseBoolean(property);
    }

    public static String h(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (str2 != null) {
            sb2.append(str2);
            sb2.append(' ');
        }
        sb2.append("grpc-java-");
        sb2.append(str);
        sb2.append('/');
        sb2.append("1.62.2");
        return sb2.toString();
    }

    public static String i(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", null).invoke(inetSocketAddress, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static ThreadFactory j(String str, boolean z10) {
        return new u6.j().e(z10).f(str).b();
    }

    public static t k(r0.f fVar, boolean z10) {
        r0.i iVarC = fVar.c();
        t tVarA = iVarC != null ? ((s2) iVarC.e()).a() : null;
        if (tVarA != null) {
            k.a aVarB = fVar.b();
            return aVarB == null ? tVarA : new f(aVarB, tVarA);
        }
        if (!fVar.a().p()) {
            if (fVar.d()) {
                return new h0(o(fVar.a()), s.a.DROPPED);
            }
            if (!z10) {
                return new h0(o(fVar.a()), s.a.PROCESSED);
            }
        }
        return null;
    }

    public static k1.b l(int i10) {
        if (i10 >= 100 && i10 < 200) {
            return k1.b.INTERNAL;
        }
        if (i10 != 400) {
            if (i10 == 401) {
                return k1.b.UNAUTHENTICATED;
            }
            if (i10 == 403) {
                return k1.b.PERMISSION_DENIED;
            }
            if (i10 == 404) {
                return k1.b.UNIMPLEMENTED;
            }
            if (i10 != 429) {
                if (i10 != 431) {
                    switch (i10) {
                        case 502:
                        case 503:
                        case 504:
                            break;
                        default:
                            return k1.b.UNKNOWN;
                    }
                }
            }
            return k1.b.UNAVAILABLE;
        }
        return k1.b.INTERNAL;
    }

    public static rb.k1 m(int i10) {
        return l(i10).b().r("HTTP status code " + i10);
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

    public static rb.k1 o(rb.k1 k1Var) {
        p6.n.d(k1Var != null);
        if (!f21625b.contains(k1Var.n())) {
            return k1Var;
        }
        return rb.k1.f19606s.r("Inappropriate status code from control plane: " + k1Var.n() + " " + k1Var.o()).q(k1Var.m());
    }

    public static boolean p(rb.c cVar) {
        return !Boolean.TRUE.equals(cVar.h(f21642s));
    }
}
