package M2;

import K2.AbstractC0354b;
import K2.AbstractC0357e;
import K2.C0367o;
import K2.C0373v;
import M2.F;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: M2.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0425i0 extends K2.W {

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final Logger f2391H = Logger.getLogger(C0425i0.class.getName());

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final long f2392I = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final long f2393J = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final InterfaceC0441q0 f2394K = M0.c(S.f1975u);

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final C0373v f2395L = C0373v.c();

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final C0367o f2396M = C0367o.a();

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final Method f2397N;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f2398A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f2399B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f2400C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f2401D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f2402E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final c f2403F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final b f2404G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0441q0 f2405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0441q0 f2406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public K2.e0 f2408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f2409e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AbstractC0354b f2411g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SocketAddress f2412h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2413i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f2414j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f2415k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2416l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C0373v f2417m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public C0367o f2418n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f2419o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2420p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2421q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f2422r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f2423s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2424t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public K2.E f2425u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2426v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map f2427w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2428x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public K2.h0 f2429y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2430z;

    /* JADX INFO: renamed from: M2.i0$b */
    public interface b {
        int a();
    }

    /* JADX INFO: renamed from: M2.i0$c */
    public interface c {
        InterfaceC0447u a();
    }

    /* JADX INFO: renamed from: M2.i0$d */
    public static final class d implements b {
        public d() {
        }

        @Override // M2.C0425i0.b
        public int a() {
            return 443;
        }
    }

    static {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
            Class cls2 = Boolean.TYPE;
            declaredMethod = cls.getDeclaredMethod("getClientInterceptor", cls2, cls2, cls2, cls2);
        } catch (ClassNotFoundException e4) {
            f2391H.log(Level.FINE, "Unable to apply census stats", (Throwable) e4);
            declaredMethod = null;
        } catch (NoSuchMethodException e5) {
            f2391H.log(Level.FINE, "Unable to apply census stats", (Throwable) e5);
            declaredMethod = null;
        }
        f2397N = declaredMethod;
    }

    public C0425i0(String str, c cVar, b bVar) {
        this(str, null, null, cVar, bVar);
    }

    @Override // K2.W
    public K2.V a() {
        return new C0427j0(new C0423h0(this, this.f2403F.a(), new F.a(), M0.c(S.f1975u), S.f1977w, f(), R0.f1954a));
    }

    public int e() {
        return this.f2404G.a();
    }

    public List f() {
        boolean z4;
        Method method;
        ArrayList arrayList = new ArrayList(this.f2407c);
        List listA = K2.I.a();
        if (listA != null) {
            arrayList.addAll(listA);
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4 && this.f2430z && (method = f2397N) != null) {
            try {
                android.support.v4.media.session.b.a(method.invoke(null, Boolean.valueOf(this.f2398A), Boolean.valueOf(this.f2399B), Boolean.valueOf(this.f2400C), Boolean.valueOf(this.f2401D)));
            } catch (IllegalAccessException e4) {
                f2391H.log(Level.FINE, "Unable to apply census stats", (Throwable) e4);
            } catch (InvocationTargetException e5) {
                f2391H.log(Level.FINE, "Unable to apply census stats", (Throwable) e5);
            }
        }
        if (!z4 && this.f2402E) {
            try {
                android.support.v4.media.session.b.a(Class.forName("io.grpc.census.InternalCensusTracingAccessor").getDeclaredMethod("getClientInterceptor", new Class[0]).invoke(null, new Object[0]));
            } catch (ClassNotFoundException e6) {
                f2391H.log(Level.FINE, "Unable to apply census stats", (Throwable) e6);
            } catch (IllegalAccessException e7) {
                f2391H.log(Level.FINE, "Unable to apply census stats", (Throwable) e7);
            } catch (NoSuchMethodException e8) {
                f2391H.log(Level.FINE, "Unable to apply census stats", (Throwable) e8);
            } catch (InvocationTargetException e9) {
                f2391H.log(Level.FINE, "Unable to apply census stats", (Throwable) e9);
            }
        }
        return arrayList;
    }

    public C0425i0(String str, AbstractC0357e abstractC0357e, AbstractC0354b abstractC0354b, c cVar, b bVar) {
        InterfaceC0441q0 interfaceC0441q0 = f2394K;
        this.f2405a = interfaceC0441q0;
        this.f2406b = interfaceC0441q0;
        this.f2407c = new ArrayList();
        this.f2408d = K2.e0.b();
        this.f2409e = new ArrayList();
        this.f2415k = "pick_first";
        this.f2417m = f2395L;
        this.f2418n = f2396M;
        this.f2419o = f2392I;
        this.f2420p = 5;
        this.f2421q = 5;
        this.f2422r = 16777216L;
        this.f2423s = 1048576L;
        this.f2424t = true;
        this.f2425u = K2.E.g();
        this.f2428x = true;
        this.f2430z = true;
        this.f2398A = true;
        this.f2399B = true;
        this.f2400C = false;
        this.f2401D = true;
        this.f2402E = true;
        this.f2410f = (String) Z1.m.o(str, "target");
        this.f2411g = abstractC0354b;
        this.f2403F = (c) Z1.m.o(cVar, "clientTransportFactoryBuilder");
        this.f2412h = null;
        if (bVar != null) {
            this.f2404G = bVar;
        } else {
            this.f2404G = new d();
        }
    }
}
