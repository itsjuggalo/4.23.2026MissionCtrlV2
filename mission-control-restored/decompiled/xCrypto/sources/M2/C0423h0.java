package M2;

import K2.AbstractC0356d;
import K2.AbstractC0358f;
import K2.AbstractC0359g;
import K2.AbstractC0362j;
import K2.AbstractC0363k;
import K2.C0353a;
import K2.C0355c;
import K2.C0367o;
import K2.C0369q;
import K2.C0371t;
import K2.C0373v;
import K2.C0375x;
import K2.EnumC0368p;
import K2.F;
import K2.G;
import K2.S;
import K2.c0;
import K2.p0;
import M2.C0;
import M2.C0424i;
import M2.C0429k0;
import M2.C0434n;
import M2.C0440q;
import M2.F;
import M2.F0;
import M2.InterfaceC0426j;
import M2.InterfaceC0431l0;
import M2.Z;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.Thread;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: M2.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0423h0 extends K2.V implements K2.J {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final Logger f2218m0 = Logger.getLogger(C0423h0.class.getName());

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final Pattern f2219n0 = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final K2.l0 f2220o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final K2.l0 f2221p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final K2.l0 f2222q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final C0429k0 f2223r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final K2.G f2224s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final AbstractC0359g f2225t0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final List f2226A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final String f2227B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public K2.c0 f2228C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f2229D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public s f2230E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public volatile S.j f2231F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f2232G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final Set f2233H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public Collection f2234I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Object f2235J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final Set f2236K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public final B f2237L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public final y f2238M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public final AtomicBoolean f2239N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public boolean f2240O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f2241P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public volatile boolean f2242Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public final CountDownLatch f2243R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public final C0434n.b f2244S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final C0434n f2245T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final C0438p f2246U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public final AbstractC0358f f2247V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public final K2.E f2248W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public final u f2249X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public v f2250Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public C0429k0 f2251Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.K f2252a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final C0429k0 f2253a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2254b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f2255b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2256c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final boolean f2257c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final K2.e0 f2258d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final C0.u f2259d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0.a f2260e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final long f2261e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0424i f2262f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final long f2263f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC0447u f2264g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final boolean f2265g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InterfaceC0447u f2266h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final C0371t.c f2267h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InterfaceC0447u f2268i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final InterfaceC0431l0.a f2269i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w f2270j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final X f2271j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Executor f2272k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final m f2273k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final InterfaceC0441q0 f2274l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final B0 f2275l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final InterfaceC0441q0 f2276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p f2277n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final p f2278o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final R0 f2279p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f2280q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final K2.p0 f2281r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2282s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final C0373v f2283t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final C0367o f2284u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Z1.r f2285v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f2286w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final C0453x f2287x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final InterfaceC0426j.a f2288y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AbstractC0356d f2289z;

    /* JADX INFO: renamed from: M2.h0$a */
    public class a extends K2.G {
        @Override // K2.G
        public G.b a(S.g gVar) {
            throw new IllegalStateException("Resolution is pending");
        }
    }

    /* JADX INFO: renamed from: M2.h0$b */
    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0423h0.this.y0(true);
        }
    }

    /* JADX INFO: renamed from: M2.h0$c */
    public final class c implements C0434n.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ R0 f2291a;

        public c(R0 r02) {
            this.f2291a = r02;
        }

        @Override // M2.C0434n.b
        public C0434n a() {
            return new C0434n(this.f2291a);
        }
    }

    /* JADX INFO: renamed from: M2.h0$d */
    public final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f2293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EnumC0368p f2294b;

        public d(Runnable runnable, EnumC0368p enumC0368p) {
            this.f2293a = runnable;
            this.f2294b = enumC0368p;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0423h0.this.f2287x.c(this.f2293a, C0423h0.this.f2272k, this.f2294b);
        }
    }

    /* JADX INFO: renamed from: M2.h0$e */
    public final class e extends S.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.f f2296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f2297b;

        public e(Throwable th) {
            this.f2297b = th;
            this.f2296a = S.f.e(K2.l0.f1229s.q("Panic! This is a bug!").p(th));
        }

        @Override // K2.S.j
        public S.f a(S.g gVar) {
            return this.f2296a;
        }

        public String toString() {
            return Z1.g.a(e.class).d("panicPickResult", this.f2296a).toString();
        }
    }

    /* JADX INFO: renamed from: M2.h0$f */
    public final class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0423h0.this.f2239N.get() || C0423h0.this.f2230E == null) {
                return;
            }
            C0423h0.this.y0(false);
            C0423h0.this.z0();
        }
    }

    /* JADX INFO: renamed from: M2.h0$g */
    public final class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0423h0.this.A0();
            if (C0423h0.this.f2231F != null) {
                C0423h0.this.f2231F.b();
            }
            if (C0423h0.this.f2230E != null) {
                C0423h0.this.f2230E.f2330a.c();
            }
        }
    }

    /* JADX INFO: renamed from: M2.h0$h */
    public final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0423h0.this.f2247V.a(AbstractC0358f.a.INFO, "Entering SHUTDOWN state");
            C0423h0.this.f2287x.b(EnumC0368p.SHUTDOWN);
        }
    }

    /* JADX INFO: renamed from: M2.h0$i */
    public final class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0423h0.this.f2240O) {
                return;
            }
            C0423h0.this.f2240O = true;
            C0423h0.this.E0();
        }
    }

    /* JADX INFO: renamed from: M2.h0$j */
    public class j implements Thread.UncaughtExceptionHandler {
        public j() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            C0423h0.f2218m0.log(Level.SEVERE, "[" + C0423h0.this.h() + "] Uncaught exception in the SynchronizationContext. Panic!", th);
            C0423h0.this.G0(th);
        }
    }

    /* JADX INFO: renamed from: M2.h0$k */
    public class k extends N {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f2304b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(K2.c0 c0Var, String str) {
            super(c0Var);
            this.f2304b = str;
        }

        @Override // M2.N, K2.c0
        public String a() {
            return this.f2304b;
        }
    }

    /* JADX INFO: renamed from: M2.h0$m */
    public final class m implements C0440q.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile C0.E f2305a;

        /* JADX INFO: renamed from: M2.h0$m$a */
        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0423h0.this.A0();
            }
        }

        /* JADX INFO: renamed from: M2.h0$m$b */
        public final class b extends C0 {

            /* JADX INFO: renamed from: E, reason: collision with root package name */
            public final /* synthetic */ K2.a0 f2308E;

            /* JADX INFO: renamed from: F, reason: collision with root package name */
            public final /* synthetic */ K2.Z f2309F;

            /* JADX INFO: renamed from: G, reason: collision with root package name */
            public final /* synthetic */ C0355c f2310G;

            /* JADX INFO: renamed from: H, reason: collision with root package name */
            public final /* synthetic */ D0 f2311H;

            /* JADX INFO: renamed from: I, reason: collision with root package name */
            public final /* synthetic */ U f2312I;

            /* JADX INFO: renamed from: J, reason: collision with root package name */
            public final /* synthetic */ K2.r f2313J;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(K2.a0 a0Var, K2.Z z4, C0355c c0355c, D0 d02, U u4, K2.r rVar) {
                super(a0Var, z4, C0423h0.this.f2259d0, C0423h0.this.f2261e0, C0423h0.this.f2263f0, C0423h0.this.B0(c0355c), C0423h0.this.f2266h.R(), d02, u4, m.this.f2305a);
                this.f2308E = a0Var;
                this.f2309F = z4;
                this.f2310G = c0355c;
                this.f2311H = d02;
                this.f2312I = u4;
                this.f2313J = rVar;
            }

            @Override // M2.C0
            public M2.r k0(K2.Z z4, AbstractC0363k.a aVar, int i4, boolean z5) {
                C0355c c0355cR = this.f2310G.r(aVar);
                AbstractC0363k[] abstractC0363kArrF = S.f(c0355cR, z4, i4, z5);
                InterfaceC0445t interfaceC0445tC = m.this.c(new C0452w0(this.f2308E, z4, c0355cR));
                K2.r rVarB = this.f2313J.b();
                try {
                    return interfaceC0445tC.c(this.f2308E, z4, c0355cR, abstractC0363kArrF);
                } finally {
                    this.f2313J.f(rVarB);
                }
            }

            @Override // M2.C0
            public void l0() {
                C0423h0.this.f2238M.d(this);
            }

            @Override // M2.C0
            public K2.l0 m0() {
                return C0423h0.this.f2238M.a(this);
            }
        }

        public m() {
        }

        @Override // M2.C0440q.e
        public M2.r a(K2.a0 a0Var, C0355c c0355c, K2.Z z4, K2.r rVar) {
            if (C0423h0.this.f2265g0) {
                C0429k0.b bVar = (C0429k0.b) c0355c.h(C0429k0.b.f2449g);
                return new b(a0Var, z4, c0355c, bVar == null ? null : bVar.f2454e, bVar != null ? bVar.f2455f : null, rVar);
            }
            InterfaceC0445t interfaceC0445tC = c(new C0452w0(a0Var, z4, c0355c));
            K2.r rVarB = rVar.b();
            try {
                return interfaceC0445tC.c(a0Var, z4, c0355c, S.f(c0355c, z4, 0, false));
            } finally {
                rVar.f(rVarB);
            }
        }

        public final InterfaceC0445t c(S.g gVar) {
            S.j jVar = C0423h0.this.f2231F;
            if (C0423h0.this.f2239N.get()) {
                return C0423h0.this.f2237L;
            }
            if (jVar == null) {
                C0423h0.this.f2281r.execute(new a());
                return C0423h0.this.f2237L;
            }
            InterfaceC0445t interfaceC0445tK = S.k(jVar.a(gVar), gVar.a().j());
            return interfaceC0445tK != null ? interfaceC0445tK : C0423h0.this.f2237L;
        }

        public /* synthetic */ m(C0423h0 c0423h0, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: M2.h0$n */
    public static final class n extends K2.A {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K2.G f2315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC0356d f2316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Executor f2317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final K2.a0 f2318d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final K2.r f2319e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public C0355c f2320f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public AbstractC0359g f2321g;

        /* JADX INFO: renamed from: M2.h0$n$a */
        public class a extends AbstractRunnableC0454y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractC0359g.a f2322b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ K2.l0 f2323c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AbstractC0359g.a aVar, K2.l0 l0Var) {
                super(n.this.f2319e);
                this.f2322b = aVar;
                this.f2323c = l0Var;
            }

            @Override // M2.AbstractRunnableC0454y
            public void a() {
                this.f2322b.onClose(this.f2323c, new K2.Z());
            }
        }

        public n(K2.G g4, AbstractC0356d abstractC0356d, Executor executor, K2.a0 a0Var, C0355c c0355c) {
            this.f2315a = g4;
            this.f2316b = abstractC0356d;
            this.f2318d = a0Var;
            executor = c0355c.e() != null ? c0355c.e() : executor;
            this.f2317c = executor;
            this.f2320f = c0355c.n(executor);
            this.f2319e = K2.r.e();
        }

        public final void b(AbstractC0359g.a aVar, K2.l0 l0Var) {
            this.f2317c.execute(new a(aVar, l0Var));
        }

        @Override // K2.A, K2.f0, K2.AbstractC0359g
        public void cancel(String str, Throwable th) {
            AbstractC0359g abstractC0359g = this.f2321g;
            if (abstractC0359g != null) {
                abstractC0359g.cancel(str, th);
            }
        }

        @Override // K2.A, K2.f0
        public AbstractC0359g delegate() {
            return this.f2321g;
        }

        @Override // K2.A, K2.AbstractC0359g
        public void start(AbstractC0359g.a aVar, K2.Z z4) {
            G.b bVarA = this.f2315a.a(new C0452w0(this.f2318d, z4, this.f2320f));
            K2.l0 l0VarC = bVarA.c();
            if (!l0VarC.o()) {
                b(aVar, S.o(l0VarC));
                this.f2321g = C0423h0.f2225t0;
                return;
            }
            bVarA.b();
            C0429k0.b bVarF = ((C0429k0) bVarA.a()).f(this.f2318d);
            if (bVarF != null) {
                this.f2320f = this.f2320f.q(C0429k0.b.f2449g, bVarF);
            }
            AbstractC0359g abstractC0359gG = this.f2316b.g(this.f2318d, this.f2320f);
            this.f2321g = abstractC0359gG;
            abstractC0359gG.start(aVar, z4);
        }
    }

    /* JADX INFO: renamed from: M2.h0$o */
    public final class o implements InterfaceC0431l0.a {
        public o() {
        }

        @Override // M2.InterfaceC0431l0.a
        public void b() {
            Z1.m.u(C0423h0.this.f2239N.get(), "Channel must have been shut down");
            C0423h0.this.f2241P = true;
            C0423h0.this.K0(false);
            C0423h0.this.E0();
            C0423h0.this.F0();
        }

        @Override // M2.InterfaceC0431l0.a
        public void c(boolean z4) {
            C0423h0 c0423h0 = C0423h0.this;
            c0423h0.f2271j0.e(c0423h0.f2237L, z4);
        }

        @Override // M2.InterfaceC0431l0.a
        public void d(K2.l0 l0Var) {
            Z1.m.u(C0423h0.this.f2239N.get(), "Channel must have been shut down");
        }

        public /* synthetic */ o(C0423h0 c0423h0, a aVar) {
            this();
        }

        @Override // M2.InterfaceC0431l0.a
        public void a() {
        }

        @Override // M2.InterfaceC0431l0.a
        public C0353a e(C0353a c0353a) {
            return c0353a;
        }
    }

    /* JADX INFO: renamed from: M2.h0$p */
    public static final class p implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0441q0 f2326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f2327b;

        public p(InterfaceC0441q0 interfaceC0441q0) {
            this.f2326a = (InterfaceC0441q0) Z1.m.o(interfaceC0441q0, "executorPool");
        }

        public synchronized Executor a() {
            try {
                if (this.f2327b == null) {
                    this.f2327b = (Executor) Z1.m.p((Executor) this.f2326a.a(), "%s.getObject()", this.f2327b);
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f2327b;
        }

        public synchronized void b() {
            Executor executor = this.f2327b;
            if (executor != null) {
                this.f2327b = (Executor) this.f2326a.b(executor);
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a().execute(runnable);
        }
    }

    /* JADX INFO: renamed from: M2.h0$q */
    public final class q extends X {
        public q() {
        }

        @Override // M2.X
        public void b() {
            C0423h0.this.A0();
        }

        @Override // M2.X
        public void c() {
            if (C0423h0.this.f2239N.get()) {
                return;
            }
            C0423h0.this.I0();
        }

        public /* synthetic */ q(C0423h0 c0423h0, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: M2.h0$r */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0423h0.this.f2230E == null) {
                return;
            }
            C0423h0.this.z0();
        }

        public /* synthetic */ r(C0423h0 c0423h0, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: M2.h0$s */
    public final class s extends S.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0424i.b f2330a;

        /* JADX INFO: renamed from: M2.h0$s$a */
        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0423h0.this.H0();
            }
        }

        /* JADX INFO: renamed from: M2.h0$s$b */
        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ S.j f2333a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ EnumC0368p f2334b;

            public b(S.j jVar, EnumC0368p enumC0368p) {
                this.f2333a = jVar;
                this.f2334b = enumC0368p;
            }

            @Override // java.lang.Runnable
            public void run() {
                s sVar = s.this;
                if (sVar != C0423h0.this.f2230E) {
                    return;
                }
                C0423h0.this.M0(this.f2333a);
                if (this.f2334b != EnumC0368p.SHUTDOWN) {
                    C0423h0.this.f2247V.b(AbstractC0358f.a.INFO, "Entering {0} state with picker: {1}", this.f2334b, this.f2333a);
                    C0423h0.this.f2287x.b(this.f2334b);
                }
            }
        }

        public s() {
        }

        @Override // K2.S.e
        public AbstractC0358f b() {
            return C0423h0.this.f2247V;
        }

        @Override // K2.S.e
        public ScheduledExecutorService c() {
            return C0423h0.this.f2270j;
        }

        @Override // K2.S.e
        public K2.p0 d() {
            return C0423h0.this.f2281r;
        }

        @Override // K2.S.e
        public void e() {
            C0423h0.this.f2281r.e();
            C0423h0.this.f2281r.execute(new a());
        }

        @Override // K2.S.e
        public void f(EnumC0368p enumC0368p, S.j jVar) {
            C0423h0.this.f2281r.e();
            Z1.m.o(enumC0368p, "newState");
            Z1.m.o(jVar, "newPicker");
            C0423h0.this.f2281r.execute(new b(jVar, enumC0368p));
        }

        @Override // K2.S.e
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public AbstractC0414d a(S.b bVar) {
            C0423h0.this.f2281r.e();
            Z1.m.u(!C0423h0.this.f2241P, "Channel is being terminated");
            return C0423h0.this.new x(bVar);
        }

        public /* synthetic */ s(C0423h0 c0423h0, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: M2.h0$t */
    public final class t extends c0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f2336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final K2.c0 f2337b;

        /* JADX INFO: renamed from: M2.h0$t$a */
        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ K2.l0 f2339a;

            public a(K2.l0 l0Var) {
                this.f2339a = l0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                t.this.d(this.f2339a);
            }
        }

        /* JADX INFO: renamed from: M2.h0$t$b */
        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c0.e f2341a;

            public b(c0.e eVar) {
                this.f2341a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0429k0 c0429k0;
                if (C0423h0.this.f2228C != t.this.f2337b) {
                    return;
                }
                List listA = this.f2341a.a();
                AbstractC0358f abstractC0358f = C0423h0.this.f2247V;
                AbstractC0358f.a aVar = AbstractC0358f.a.DEBUG;
                abstractC0358f.b(aVar, "Resolved address: {0}, config={1}", listA, this.f2341a.b());
                v vVar = C0423h0.this.f2250Y;
                v vVar2 = v.SUCCESS;
                if (vVar != vVar2) {
                    C0423h0.this.f2247V.b(AbstractC0358f.a.INFO, "Address resolved: {0}", listA);
                    C0423h0.this.f2250Y = vVar2;
                }
                c0.b bVarC = this.f2341a.c();
                F0.b bVar = (F0.b) this.f2341a.b().b(F0.f1900e);
                K2.G g4 = (K2.G) this.f2341a.b().b(K2.G.f1046a);
                C0429k0 c0429k02 = (bVarC == null || bVarC.c() == null) ? null : (C0429k0) bVarC.c();
                K2.l0 l0VarD = bVarC != null ? bVarC.d() : null;
                if (C0423h0.this.f2257c0) {
                    if (c0429k02 != null) {
                        if (g4 != null) {
                            C0423h0.this.f2249X.q(g4);
                            if (c0429k02.c() != null) {
                                C0423h0.this.f2247V.a(aVar, "Method configs in service config will be discarded due to presence ofconfig-selector");
                            }
                        } else {
                            C0423h0.this.f2249X.q(c0429k02.c());
                        }
                    } else if (C0423h0.this.f2253a0 != null) {
                        c0429k02 = C0423h0.this.f2253a0;
                        C0423h0.this.f2249X.q(c0429k02.c());
                        C0423h0.this.f2247V.a(AbstractC0358f.a.INFO, "Received no service config, using default service config");
                    } else if (l0VarD == null) {
                        c0429k02 = C0423h0.f2223r0;
                        C0423h0.this.f2249X.q(null);
                    } else {
                        if (!C0423h0.this.f2255b0) {
                            C0423h0.this.f2247V.a(AbstractC0358f.a.INFO, "Fallback to error due to invalid first service config without default config");
                            t.this.a(bVarC.d());
                            if (bVar != null) {
                                bVar.a(bVarC.d());
                                return;
                            }
                            return;
                        }
                        c0429k02 = C0423h0.this.f2251Z;
                    }
                    if (!c0429k02.equals(C0423h0.this.f2251Z)) {
                        C0423h0.this.f2247V.b(AbstractC0358f.a.INFO, "Service config changed{0}", c0429k02 == C0423h0.f2223r0 ? " to empty" : "");
                        C0423h0.this.f2251Z = c0429k02;
                        C0423h0.this.f2273k0.f2305a = c0429k02.g();
                    }
                    try {
                        C0423h0.this.f2255b0 = true;
                    } catch (RuntimeException e4) {
                        C0423h0.f2218m0.log(Level.WARNING, "[" + C0423h0.this.h() + "] Unexpected exception from parsing service config", (Throwable) e4);
                    }
                    c0429k0 = c0429k02;
                } else {
                    if (c0429k02 != null) {
                        C0423h0.this.f2247V.a(AbstractC0358f.a.INFO, "Service config from name resolver discarded by channel settings");
                    }
                    c0429k0 = C0423h0.this.f2253a0 == null ? C0423h0.f2223r0 : C0423h0.this.f2253a0;
                    if (g4 != null) {
                        C0423h0.this.f2247V.a(AbstractC0358f.a.INFO, "Config selector from name resolver discarded by channel settings");
                    }
                    C0423h0.this.f2249X.q(c0429k0.c());
                }
                C0353a c0353aB = this.f2341a.b();
                t tVar = t.this;
                if (tVar.f2336a == C0423h0.this.f2230E) {
                    C0353a.b bVarC2 = c0353aB.d().c(K2.G.f1046a);
                    Map mapD = c0429k0.d();
                    if (mapD != null) {
                        bVarC2.d(K2.S.f1058b, mapD).a();
                    }
                    K2.l0 l0VarE = t.this.f2336a.f2330a.e(S.h.d().b(listA).c(bVarC2.a()).d(c0429k0.e()).a());
                    if (bVar != null) {
                        bVar.a(l0VarE);
                    }
                }
            }
        }

        public t(s sVar, K2.c0 c0Var) {
            this.f2336a = (s) Z1.m.o(sVar, "helperImpl");
            this.f2337b = (K2.c0) Z1.m.o(c0Var, "resolver");
        }

        @Override // K2.c0.d
        public void a(K2.l0 l0Var) {
            Z1.m.e(!l0Var.o(), "the error status must not be OK");
            C0423h0.this.f2281r.execute(new a(l0Var));
        }

        @Override // K2.c0.d
        public void b(c0.e eVar) {
            C0423h0.this.f2281r.execute(new b(eVar));
        }

        public final void d(K2.l0 l0Var) {
            C0423h0.f2218m0.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{C0423h0.this.h(), l0Var});
            C0423h0.this.f2249X.n();
            v vVar = C0423h0.this.f2250Y;
            v vVar2 = v.ERROR;
            if (vVar != vVar2) {
                C0423h0.this.f2247V.b(AbstractC0358f.a.WARNING, "Failed to resolve name: {0}", l0Var);
                C0423h0.this.f2250Y = vVar2;
            }
            if (this.f2336a != C0423h0.this.f2230E) {
                return;
            }
            this.f2336a.f2330a.b(l0Var);
        }
    }

    /* JADX INFO: renamed from: M2.h0$u */
    public class u extends AbstractC0356d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference f2343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractC0356d f2345c;

        /* JADX INFO: renamed from: M2.h0$u$a */
        public class a extends AbstractC0356d {
            public a() {
            }

            @Override // K2.AbstractC0356d
            public String a() {
                return u.this.f2344b;
            }

            @Override // K2.AbstractC0356d
            public AbstractC0359g g(K2.a0 a0Var, C0355c c0355c) {
                return new C0440q(a0Var, C0423h0.this.B0(c0355c), c0355c, C0423h0.this.f2273k0, C0423h0.this.f2242Q ? null : C0423h0.this.f2266h.R(), C0423h0.this.f2245T, null).z(C0423h0.this.f2282s).y(C0423h0.this.f2283t).x(C0423h0.this.f2284u);
            }
        }

        /* JADX INFO: renamed from: M2.h0$u$b */
        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0423h0.this.f2234I == null) {
                    if (u.this.f2343a.get() == C0423h0.f2224s0) {
                        u.this.f2343a.set(null);
                    }
                    C0423h0.this.f2238M.b(C0423h0.f2221p0);
                }
            }
        }

        /* JADX INFO: renamed from: M2.h0$u$c */
        public final class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (u.this.f2343a.get() == C0423h0.f2224s0) {
                    u.this.f2343a.set(null);
                }
                if (C0423h0.this.f2234I != null) {
                    Iterator it = C0423h0.this.f2234I.iterator();
                    while (it.hasNext()) {
                        ((g) it.next()).cancel("Channel is forcefully shutdown", null);
                    }
                }
                C0423h0.this.f2238M.c(C0423h0.f2220o0);
            }
        }

        /* JADX INFO: renamed from: M2.h0$u$d */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0423h0.this.A0();
            }
        }

        /* JADX INFO: renamed from: M2.h0$u$f */
        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f2352a;

            public f(g gVar) {
                this.f2352a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (u.this.f2343a.get() != C0423h0.f2224s0) {
                    this.f2352a.m();
                    return;
                }
                if (C0423h0.this.f2234I == null) {
                    C0423h0.this.f2234I = new LinkedHashSet();
                    C0423h0 c0423h0 = C0423h0.this;
                    c0423h0.f2271j0.e(c0423h0.f2235J, true);
                }
                C0423h0.this.f2234I.add(this.f2352a);
            }
        }

        /* JADX INFO: renamed from: M2.h0$u$g */
        public final class g extends A {

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final K2.r f2354l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final K2.a0 f2355m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final C0355c f2356n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final long f2357o;

            /* JADX INFO: renamed from: M2.h0$u$g$a */
            public class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Runnable f2359a;

                public a(Runnable runnable) {
                    this.f2359a = runnable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f2359a.run();
                    g gVar = g.this;
                    C0423h0.this.f2281r.execute(gVar.new b());
                }
            }

            /* JADX INFO: renamed from: M2.h0$u$g$b */
            public final class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C0423h0.this.f2234I != null) {
                        C0423h0.this.f2234I.remove(g.this);
                        if (C0423h0.this.f2234I.isEmpty()) {
                            C0423h0 c0423h0 = C0423h0.this;
                            c0423h0.f2271j0.e(c0423h0.f2235J, false);
                            C0423h0.this.f2234I = null;
                            if (C0423h0.this.f2239N.get()) {
                                C0423h0.this.f2238M.b(C0423h0.f2221p0);
                            }
                        }
                    }
                }
            }

            public g(K2.r rVar, K2.a0 a0Var, C0355c c0355c) {
                super(C0423h0.this.B0(c0355c), C0423h0.this.f2270j, c0355c.d());
                this.f2354l = rVar;
                this.f2355m = a0Var;
                this.f2356n = c0355c;
                this.f2357o = C0423h0.this.f2267h0.a();
            }

            @Override // M2.A
            public void e() {
                super.e();
                C0423h0.this.f2281r.execute(new b());
            }

            public void m() {
                K2.r rVarB = this.f2354l.b();
                try {
                    AbstractC0359g abstractC0359gM = u.this.m(this.f2355m, this.f2356n.q(AbstractC0363k.f1205a, Long.valueOf(C0423h0.this.f2267h0.a() - this.f2357o)));
                    this.f2354l.f(rVarB);
                    Runnable runnableK = k(abstractC0359gM);
                    if (runnableK == null) {
                        C0423h0.this.f2281r.execute(new b());
                    } else {
                        C0423h0.this.B0(this.f2356n).execute(new a(runnableK));
                    }
                } catch (Throwable th) {
                    this.f2354l.f(rVarB);
                    throw th;
                }
            }
        }

        public /* synthetic */ u(C0423h0 c0423h0, String str, a aVar) {
            this(str);
        }

        @Override // K2.AbstractC0356d
        public String a() {
            return this.f2344b;
        }

        @Override // K2.AbstractC0356d
        public AbstractC0359g g(K2.a0 a0Var, C0355c c0355c) {
            if (this.f2343a.get() != C0423h0.f2224s0) {
                return m(a0Var, c0355c);
            }
            C0423h0.this.f2281r.execute(new d());
            if (this.f2343a.get() != C0423h0.f2224s0) {
                return m(a0Var, c0355c);
            }
            if (C0423h0.this.f2239N.get()) {
                return new e();
            }
            g gVar = new g(K2.r.e(), a0Var, c0355c);
            C0423h0.this.f2281r.execute(new f(gVar));
            return gVar;
        }

        public final AbstractC0359g m(K2.a0 a0Var, C0355c c0355c) {
            K2.G g4 = (K2.G) this.f2343a.get();
            if (g4 == null) {
                return this.f2345c.g(a0Var, c0355c);
            }
            if (!(g4 instanceof C0429k0.c)) {
                return new n(g4, this.f2345c, C0423h0.this.f2272k, a0Var, c0355c);
            }
            C0429k0.b bVarF = ((C0429k0.c) g4).f2456b.f(a0Var);
            if (bVarF != null) {
                c0355c = c0355c.q(C0429k0.b.f2449g, bVarF);
            }
            return this.f2345c.g(a0Var, c0355c);
        }

        public void n() {
            if (this.f2343a.get() == C0423h0.f2224s0) {
                q(null);
            }
        }

        public void o() {
            C0423h0.this.f2281r.execute(new b());
        }

        public void p() {
            C0423h0.this.f2281r.execute(new c());
        }

        public void q(K2.G g4) {
            K2.G g5 = (K2.G) this.f2343a.get();
            this.f2343a.set(g4);
            if (g5 != C0423h0.f2224s0 || C0423h0.this.f2234I == null) {
                return;
            }
            Iterator it = C0423h0.this.f2234I.iterator();
            while (it.hasNext()) {
                ((g) it.next()).m();
            }
        }

        public u(String str) {
            this.f2343a = new AtomicReference(C0423h0.f2224s0);
            this.f2345c = new a();
            this.f2344b = (String) Z1.m.o(str, "authority");
        }

        /* JADX INFO: renamed from: M2.h0$u$e */
        public class e extends AbstractC0359g {
            public e() {
            }

            @Override // K2.AbstractC0359g
            public void start(AbstractC0359g.a aVar, K2.Z z4) {
                aVar.onClose(C0423h0.f2221p0, new K2.Z());
            }

            @Override // K2.AbstractC0359g
            public void halfClose() {
            }

            @Override // K2.AbstractC0359g
            public void request(int i4) {
            }

            @Override // K2.AbstractC0359g
            public void sendMessage(Object obj) {
            }

            @Override // K2.AbstractC0359g
            public void cancel(String str, Throwable th) {
            }
        }
    }

    /* JADX INFO: renamed from: M2.h0$v */
    public enum v {
        NO_RESOLUTION,
        SUCCESS,
        ERROR
    }

    /* JADX INFO: renamed from: M2.h0$w */
    public static final class w implements ScheduledExecutorService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f2366a;

        public /* synthetic */ w(ScheduledExecutorService scheduledExecutorService, a aVar) {
            this(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j4, TimeUnit timeUnit) {
            return this.f2366a.awaitTermination(j4, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f2366a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public List invokeAll(Collection collection) {
            return this.f2366a.invokeAll(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public Object invokeAny(Collection collection) {
            return this.f2366a.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.f2366a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.f2366a.isTerminated();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture schedule(Callable callable, long j4, TimeUnit timeUnit) {
            return this.f2366a.schedule(callable, j4, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
            return this.f2366a.scheduleAtFixedRate(runnable, j4, j5, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
            return this.f2366a.scheduleWithFixedDelay(runnable, j4, j5, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public List shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Callable callable) {
            return this.f2366a.submit(callable);
        }

        public w(ScheduledExecutorService scheduledExecutorService) {
            this.f2366a = (ScheduledExecutorService) Z1.m.o(scheduledExecutorService, "delegate");
        }

        @Override // java.util.concurrent.ExecutorService
        public List invokeAll(Collection collection, long j4, TimeUnit timeUnit) {
            return this.f2366a.invokeAll(collection, j4, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public Object invokeAny(Collection collection, long j4, TimeUnit timeUnit) {
            return this.f2366a.invokeAny(collection, j4, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture schedule(Runnable runnable, long j4, TimeUnit timeUnit) {
            return this.f2366a.schedule(runnable, j4, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Runnable runnable) {
            return this.f2366a.submit(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Runnable runnable, Object obj) {
            return this.f2366a.submit(runnable, obj);
        }
    }

    /* JADX INFO: renamed from: M2.h0$x */
    public final class x extends AbstractC0414d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.b f2367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final K2.K f2368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C0436o f2369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C0438p f2370d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f2371e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Z f2372f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f2373g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f2374h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public p0.d f2375i;

        /* JADX INFO: renamed from: M2.h0$x$a */
        public final class a extends Z.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ S.k f2377a;

            public a(S.k kVar) {
                this.f2377a = kVar;
            }

            @Override // M2.Z.j
            public void a(Z z4) {
                C0423h0.this.f2271j0.e(z4, true);
            }

            @Override // M2.Z.j
            public void b(Z z4) {
                C0423h0.this.f2271j0.e(z4, false);
            }

            @Override // M2.Z.j
            public void c(Z z4, C0369q c0369q) {
                Z1.m.u(this.f2377a != null, "listener is null");
                this.f2377a.a(c0369q);
            }

            @Override // M2.Z.j
            public void d(Z z4) {
                C0423h0.this.f2233H.remove(z4);
                C0423h0.this.f2248W.k(z4);
                C0423h0.this.F0();
            }
        }

        /* JADX INFO: renamed from: M2.h0$x$b */
        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                x.this.f2372f.e(C0423h0.f2222q0);
            }
        }

        public x(S.b bVar) {
            Z1.m.o(bVar, "args");
            this.f2371e = bVar.a();
            if (C0423h0.this.f2256c != null) {
                bVar = bVar.e().e(j(bVar.a())).c();
            }
            this.f2367a = bVar;
            K2.K kB = K2.K.b("Subchannel", C0423h0.this.a());
            this.f2368b = kB;
            C0438p c0438p = new C0438p(kB, C0423h0.this.f2280q, C0423h0.this.f2279p.a(), "Subchannel for " + bVar.a());
            this.f2370d = c0438p;
            this.f2369c = new C0436o(c0438p, C0423h0.this.f2279p);
        }

        @Override // K2.S.i
        public List b() {
            C0423h0.this.f2281r.e();
            Z1.m.u(this.f2373g, "not started");
            return this.f2371e;
        }

        @Override // K2.S.i
        public C0353a c() {
            return this.f2367a.b();
        }

        @Override // K2.S.i
        public AbstractC0358f d() {
            return this.f2369c;
        }

        @Override // K2.S.i
        public Object e() {
            Z1.m.u(this.f2373g, "Subchannel is not started");
            return this.f2372f;
        }

        @Override // K2.S.i
        public void f() {
            C0423h0.this.f2281r.e();
            Z1.m.u(this.f2373g, "not started");
            this.f2372f.a();
        }

        @Override // K2.S.i
        public void g() {
            p0.d dVar;
            C0423h0.this.f2281r.e();
            if (this.f2372f == null) {
                this.f2374h = true;
                return;
            }
            if (!this.f2374h) {
                this.f2374h = true;
            } else {
                if (!C0423h0.this.f2241P || (dVar = this.f2375i) == null) {
                    return;
                }
                dVar.a();
                this.f2375i = null;
            }
            if (C0423h0.this.f2241P) {
                this.f2372f.e(C0423h0.f2221p0);
            } else {
                this.f2375i = C0423h0.this.f2281r.c(new RunnableC0417e0(new b()), 5L, TimeUnit.SECONDS, C0423h0.this.f2266h.R());
            }
        }

        @Override // K2.S.i
        public void h(S.k kVar) {
            C0423h0.this.f2281r.e();
            Z1.m.u(!this.f2373g, "already started");
            Z1.m.u(!this.f2374h, "already shutdown");
            Z1.m.u(!C0423h0.this.f2241P, "Channel is being terminated");
            this.f2373g = true;
            Z z4 = new Z(this.f2367a.a(), C0423h0.this.a(), C0423h0.this.f2227B, C0423h0.this.f2288y, C0423h0.this.f2266h, C0423h0.this.f2266h.R(), C0423h0.this.f2285v, C0423h0.this.f2281r, new a(kVar), C0423h0.this.f2248W, C0423h0.this.f2244S.a(), this.f2370d, this.f2368b, this.f2369c, C0423h0.this.f2226A);
            C0423h0.this.f2246U.e(new F.a().b("Child Subchannel started").c(F.b.CT_INFO).e(C0423h0.this.f2279p.a()).d(z4).a());
            this.f2372f = z4;
            C0423h0.this.f2248W.e(z4);
            C0423h0.this.f2233H.add(z4);
        }

        @Override // K2.S.i
        public void i(List list) {
            C0423h0.this.f2281r.e();
            this.f2371e = list;
            if (C0423h0.this.f2256c != null) {
                list = j(list);
            }
            this.f2372f.V(list);
        }

        public final List j(List list) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C0375x c0375x = (C0375x) it.next();
                arrayList.add(new C0375x(c0375x.a(), c0375x.b().d().c(C0375x.f1322d).a()));
            }
            return Collections.unmodifiableList(arrayList);
        }

        public String toString() {
            return this.f2368b.toString();
        }
    }

    static {
        K2.l0 l0Var = K2.l0.f1230t;
        f2220o0 = l0Var.q("Channel shutdownNow invoked");
        f2221p0 = l0Var.q("Channel shutdown invoked");
        f2222q0 = l0Var.q("Subchannel shutdown invoked");
        f2223r0 = C0429k0.a();
        f2224s0 = new a();
        f2225t0 = new l();
    }

    public C0423h0(C0425i0 c0425i0, InterfaceC0447u interfaceC0447u, InterfaceC0426j.a aVar, InterfaceC0441q0 interfaceC0441q0, Z1.r rVar, List list, R0 r02) {
        a aVar2;
        K2.p0 p0Var = new K2.p0(new j());
        this.f2281r = p0Var;
        this.f2287x = new C0453x();
        this.f2233H = new HashSet(16, 0.75f);
        this.f2235J = new Object();
        this.f2236K = new HashSet(1, 0.75f);
        a aVar3 = null;
        this.f2238M = new y(this, aVar3);
        this.f2239N = new AtomicBoolean(false);
        this.f2243R = new CountDownLatch(1);
        this.f2250Y = v.NO_RESOLUTION;
        this.f2251Z = f2223r0;
        this.f2255b0 = false;
        this.f2259d0 = new C0.u();
        this.f2267h0 = C0371t.k();
        o oVar = new o(this, aVar3);
        this.f2269i0 = oVar;
        this.f2271j0 = new q(this, aVar3);
        this.f2273k0 = new m(this, aVar3);
        String str = (String) Z1.m.o(c0425i0.f2410f, "target");
        this.f2254b = str;
        K2.K kB = K2.K.b("Channel", str);
        this.f2252a = kB;
        this.f2279p = (R0) Z1.m.o(r02, "timeProvider");
        InterfaceC0441q0 interfaceC0441q02 = (InterfaceC0441q0) Z1.m.o(c0425i0.f2405a, "executorPool");
        this.f2274l = interfaceC0441q02;
        Executor executor = (Executor) Z1.m.o((Executor) interfaceC0441q02.a(), "executor");
        this.f2272k = executor;
        this.f2264g = interfaceC0447u;
        p pVar = new p((InterfaceC0441q0) Z1.m.o(c0425i0.f2406b, "offloadExecutorPool"));
        this.f2278o = pVar;
        C0432m c0432m = new C0432m(interfaceC0447u, c0425i0.f2411g, pVar);
        this.f2266h = c0432m;
        this.f2268i = new C0432m(interfaceC0447u, null, pVar);
        w wVar = new w(c0432m.R(), aVar3);
        this.f2270j = wVar;
        this.f2280q = c0425i0.f2426v;
        C0438p c0438p = new C0438p(kB, c0425i0.f2426v, r02.a(), "Channel for '" + str + "'");
        this.f2246U = c0438p;
        C0436o c0436o = new C0436o(c0438p, r02);
        this.f2247V = c0436o;
        K2.h0 h0Var = c0425i0.f2429y;
        h0Var = h0Var == null ? S.f1971q : h0Var;
        boolean z4 = c0425i0.f2424t;
        this.f2265g0 = z4;
        C0424i c0424i = new C0424i(c0425i0.f2415k);
        this.f2262f = c0424i;
        K2.e0 e0Var = c0425i0.f2408d;
        this.f2258d = e0Var;
        H0 h02 = new H0(z4, c0425i0.f2420p, c0425i0.f2421q, c0424i);
        String str2 = c0425i0.f2414j;
        this.f2256c = str2;
        c0.a aVarA = c0.a.g().c(c0425i0.e()).f(h0Var).i(p0Var).g(wVar).h(h02).b(c0436o).d(pVar).e(str2).a();
        this.f2260e = aVarA;
        this.f2228C = D0(str, str2, e0Var, aVarA, c0432m.b0());
        this.f2276m = (InterfaceC0441q0) Z1.m.o(interfaceC0441q0, "balancerRpcExecutorPool");
        this.f2277n = new p(interfaceC0441q0);
        B b4 = new B(executor, p0Var);
        this.f2237L = b4;
        b4.i(oVar);
        this.f2288y = aVar;
        Map map = c0425i0.f2427w;
        if (map != null) {
            c0.b bVarA = h02.a(map);
            Z1.m.w(bVarA.d() == null, "Default config is invalid: %s", bVarA.d());
            C0429k0 c0429k0 = (C0429k0) bVarA.c();
            this.f2253a0 = c0429k0;
            this.f2251Z = c0429k0;
            aVar2 = null;
        } else {
            aVar2 = null;
            this.f2253a0 = null;
        }
        boolean z5 = c0425i0.f2428x;
        this.f2257c0 = z5;
        u uVar = new u(this, this.f2228C.a(), aVar2);
        this.f2249X = uVar;
        this.f2289z = AbstractC0362j.a(uVar, list);
        this.f2226A = new ArrayList(c0425i0.f2409e);
        this.f2285v = (Z1.r) Z1.m.o(rVar, "stopwatchSupplier");
        long j4 = c0425i0.f2419o;
        if (j4 == -1) {
            this.f2286w = j4;
        } else {
            Z1.m.i(j4 >= C0425i0.f2393J, "invalid idleTimeoutMillis %s", j4);
            this.f2286w = c0425i0.f2419o;
        }
        this.f2275l0 = new B0(new r(this, null), p0Var, c0432m.R(), (Z1.p) rVar.get());
        this.f2282s = c0425i0.f2416l;
        this.f2283t = (C0373v) Z1.m.o(c0425i0.f2417m, "decompressorRegistry");
        this.f2284u = (C0367o) Z1.m.o(c0425i0.f2418n, "compressorRegistry");
        this.f2227B = c0425i0.f2413i;
        this.f2263f0 = c0425i0.f2422r;
        this.f2261e0 = c0425i0.f2423s;
        c cVar = new c(r02);
        this.f2244S = cVar;
        this.f2245T = cVar.a();
        K2.E e4 = (K2.E) Z1.m.n(c0425i0.f2425u);
        this.f2248W = e4;
        e4.d(this);
        if (z5) {
            return;
        }
        if (this.f2253a0 != null) {
            c0436o.a(AbstractC0358f.a.INFO, "Service config look-up disabled, using default service config");
        }
        this.f2255b0 = true;
    }

    public static K2.c0 C0(String str, K2.e0 e0Var, c0.a aVar, Collection collection) {
        URI uri;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e4) {
            sb.append(e4.getMessage());
            uri = null;
        }
        K2.d0 d0VarE = uri != null ? e0Var.e(uri.getScheme()) : null;
        String str2 = "";
        if (d0VarE == null && !f2219n0.matcher(str).matches()) {
            try {
                uri = new URI(e0Var.c(), "", RemoteSettings.FORWARD_SLASH_STRING + str, null);
                d0VarE = e0Var.e(uri.getScheme());
            } catch (URISyntaxException e5) {
                throw new IllegalArgumentException(e5);
            }
        }
        if (d0VarE == null) {
            if (sb.length() > 0) {
                str2 = " (" + ((Object) sb) + ")";
            }
            throw new IllegalArgumentException(String.format("Could not find a NameResolverProvider for %s%s", str, str2));
        }
        if (collection != null && !collection.containsAll(d0VarE.c())) {
            throw new IllegalArgumentException(String.format("Address types of NameResolver '%s' for '%s' not supported by transport", uri.getScheme(), str));
        }
        K2.c0 c0VarB = d0VarE.b(uri, aVar);
        if (c0VarB != null) {
            return c0VarB;
        }
        if (sb.length() > 0) {
            str2 = " (" + ((Object) sb) + ")";
        }
        throw new IllegalArgumentException(String.format("cannot create a NameResolver for %s%s", str, str2));
    }

    public static K2.c0 D0(String str, String str2, K2.e0 e0Var, c0.a aVar, Collection collection) {
        F0 f02 = new F0(C0(str, e0Var, aVar, collection), new C0430l(new F.a(), aVar.d(), aVar.f()), aVar.f());
        return str2 == null ? f02 : new k(f02, str2);
    }

    public void A0() {
        this.f2281r.e();
        if (this.f2239N.get() || this.f2232G) {
            return;
        }
        if (this.f2271j0.d()) {
            y0(false);
        } else {
            I0();
        }
        if (this.f2230E != null) {
            return;
        }
        this.f2247V.a(AbstractC0358f.a.INFO, "Exiting idle mode");
        s sVar = new s(this, null);
        sVar.f2330a = this.f2262f.e(sVar);
        this.f2230E = sVar;
        this.f2228C.d(new t(sVar, this.f2228C));
        this.f2229D = true;
    }

    public final Executor B0(C0355c c0355c) {
        Executor executorE = c0355c.e();
        return executorE == null ? this.f2272k : executorE;
    }

    public final void E0() {
        if (this.f2240O) {
            Iterator it = this.f2233H.iterator();
            while (it.hasNext()) {
                ((Z) it.next()).b(f2220o0);
            }
            Iterator it2 = this.f2236K.iterator();
            if (it2.hasNext()) {
                android.support.v4.media.session.b.a(it2.next());
                throw null;
            }
        }
    }

    public final void F0() {
        if (!this.f2242Q && this.f2239N.get() && this.f2233H.isEmpty() && this.f2236K.isEmpty()) {
            this.f2247V.a(AbstractC0358f.a.INFO, "Terminated");
            this.f2248W.j(this);
            this.f2274l.b(this.f2272k);
            this.f2277n.b();
            this.f2278o.b();
            this.f2266h.close();
            this.f2242Q = true;
            this.f2243R.countDown();
        }
    }

    public void G0(Throwable th) {
        if (this.f2232G) {
            return;
        }
        this.f2232G = true;
        y0(true);
        K0(false);
        M0(new e(th));
        this.f2249X.q(null);
        this.f2247V.a(AbstractC0358f.a.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        this.f2287x.b(EnumC0368p.TRANSIENT_FAILURE);
    }

    public final void H0() {
        this.f2281r.e();
        if (this.f2229D) {
            this.f2228C.b();
        }
    }

    public final void I0() {
        long j4 = this.f2286w;
        if (j4 == -1) {
            return;
        }
        this.f2275l0.k(j4, TimeUnit.MILLISECONDS);
    }

    @Override // K2.V
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public C0423h0 n() {
        this.f2247V.a(AbstractC0358f.a.DEBUG, "shutdown() called");
        if (!this.f2239N.compareAndSet(false, true)) {
            return this;
        }
        this.f2281r.execute(new h());
        this.f2249X.o();
        this.f2281r.execute(new b());
        return this;
    }

    public final void K0(boolean z4) {
        this.f2281r.e();
        if (z4) {
            Z1.m.u(this.f2229D, "nameResolver is not started");
            Z1.m.u(this.f2230E != null, "lbHelper is null");
        }
        K2.c0 c0Var = this.f2228C;
        if (c0Var != null) {
            c0Var.c();
            this.f2229D = false;
            if (z4) {
                this.f2228C = D0(this.f2254b, this.f2256c, this.f2258d, this.f2260e, this.f2266h.b0());
            } else {
                this.f2228C = null;
            }
        }
        s sVar = this.f2230E;
        if (sVar != null) {
            sVar.f2330a.d();
            this.f2230E = null;
        }
        this.f2231F = null;
    }

    @Override // K2.V
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public C0423h0 o() {
        this.f2247V.a(AbstractC0358f.a.DEBUG, "shutdownNow() called");
        n();
        this.f2249X.p();
        this.f2281r.execute(new i());
        return this;
    }

    public final void M0(S.j jVar) {
        this.f2231F = jVar;
        this.f2237L.s(jVar);
    }

    @Override // K2.AbstractC0356d
    public String a() {
        return this.f2289z.a();
    }

    @Override // K2.AbstractC0356d
    public AbstractC0359g g(K2.a0 a0Var, C0355c c0355c) {
        return this.f2289z.g(a0Var, c0355c);
    }

    @Override // K2.P
    public K2.K h() {
        return this.f2252a;
    }

    @Override // K2.V
    public boolean j(long j4, TimeUnit timeUnit) {
        return this.f2243R.await(j4, timeUnit);
    }

    @Override // K2.V
    public void k() {
        this.f2281r.execute(new f());
    }

    @Override // K2.V
    public EnumC0368p l(boolean z4) {
        EnumC0368p enumC0368pA = this.f2287x.a();
        if (z4 && enumC0368pA == EnumC0368p.IDLE) {
            this.f2281r.execute(new g());
        }
        return enumC0368pA;
    }

    @Override // K2.V
    public void m(EnumC0368p enumC0368p, Runnable runnable) {
        this.f2281r.execute(new d(runnable, enumC0368p));
    }

    public String toString() {
        return Z1.g.b(this).c("logId", this.f2252a.d()).d("target", this.f2254b).toString();
    }

    public final void y0(boolean z4) {
        this.f2275l0.i(z4);
    }

    public final void z0() {
        K0(true);
        this.f2237L.s(null);
        this.f2247V.a(AbstractC0358f.a.INFO, "Entering IDLE state");
        this.f2287x.b(EnumC0368p.IDLE);
        if (this.f2271j0.a(this.f2235J, this.f2237L)) {
            A0();
        }
    }

    /* JADX INFO: renamed from: M2.h0$y */
    public final class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f2380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Collection f2381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public K2.l0 f2382c;

        public y() {
            this.f2380a = new Object();
            this.f2381b = new HashSet();
        }

        public K2.l0 a(C0 c02) {
            synchronized (this.f2380a) {
                try {
                    K2.l0 l0Var = this.f2382c;
                    if (l0Var != null) {
                        return l0Var;
                    }
                    this.f2381b.add(c02);
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b(K2.l0 l0Var) {
            synchronized (this.f2380a) {
                try {
                    if (this.f2382c != null) {
                        return;
                    }
                    this.f2382c = l0Var;
                    boolean zIsEmpty = this.f2381b.isEmpty();
                    if (zIsEmpty) {
                        C0423h0.this.f2237L.e(l0Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c(K2.l0 l0Var) {
            ArrayList arrayList;
            b(l0Var);
            synchronized (this.f2380a) {
                arrayList = new ArrayList(this.f2381b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((M2.r) it.next()).c(l0Var);
            }
            C0423h0.this.f2237L.b(l0Var);
        }

        public void d(C0 c02) {
            K2.l0 l0Var;
            synchronized (this.f2380a) {
                try {
                    this.f2381b.remove(c02);
                    if (this.f2381b.isEmpty()) {
                        l0Var = this.f2382c;
                        this.f2381b = new HashSet();
                    } else {
                        l0Var = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (l0Var != null) {
                C0423h0.this.f2237L.e(l0Var);
            }
        }

        public /* synthetic */ y(C0423h0 c0423h0, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: M2.h0$l */
    public class l extends AbstractC0359g {
        @Override // K2.AbstractC0359g
        public boolean isReady() {
            return false;
        }

        @Override // K2.AbstractC0359g
        public void halfClose() {
        }

        @Override // K2.AbstractC0359g
        public void request(int i4) {
        }

        @Override // K2.AbstractC0359g
        public void sendMessage(Object obj) {
        }

        @Override // K2.AbstractC0359g
        public void cancel(String str, Throwable th) {
        }

        @Override // K2.AbstractC0359g
        public void start(AbstractC0359g.a aVar, K2.Z z4) {
        }
    }
}
