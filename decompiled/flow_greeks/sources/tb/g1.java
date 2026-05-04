package tb;

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
import rb.a;
import rb.b1;
import rb.f;
import rb.f0;
import rb.g;
import rb.g0;
import rb.k;
import rb.o1;
import rb.r0;
import rb.t;
import tb.b2;
import tb.e2;
import tb.f0;
import tb.i;
import tb.j;
import tb.j1;
import tb.k1;
import tb.n;
import tb.q;
import tb.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g1 extends rb.u0 implements rb.j0 {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final Logger f21245m0 = Logger.getLogger(g1.class.getName());

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final Pattern f21246n0 = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final rb.k1 f21247o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final rb.k1 f21248p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final rb.k1 f21249q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final j1 f21250r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final rb.g0 f21251s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final rb.g f21252t0;
    public final List A;
    public final String B;
    public rb.b1 C;
    public boolean D;
    public s E;
    public volatile r0.j F;
    public boolean G;
    public final Set H;
    public Collection I;
    public final Object J;
    public final Set K;
    public final b0 L;
    public final y M;
    public final AtomicBoolean N;
    public boolean O;
    public boolean P;
    public volatile boolean Q;
    public final CountDownLatch R;
    public final n.b S;
    public final tb.n T;
    public final tb.p U;
    public final rb.f V;
    public final rb.e0 W;
    public final u X;
    public v Y;
    public j1 Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.k0 f21253a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final j1 f21254a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21255b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f21256b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21257c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final boolean f21258c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rb.d1 f21259d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final b2.t f21260d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b1.a f21261e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final long f21262e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final tb.i f21263f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final long f21264f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final tb.u f21265g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final boolean f21266g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final tb.u f21267h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final t.c f21268h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final tb.u f21269i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final k1.a f21270i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w f21271j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final w0 f21272j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Executor f21273k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final m f21274k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final p1 f21275l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final a2 f21276l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p1 f21277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p f21278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final p f21279o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final q2 f21280p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f21281q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final rb.o1 f21282r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f21283s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final rb.v f21284t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final rb.o f21285u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p6.s f21286v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f21287w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final tb.x f21288x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j.a f21289y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final rb.d f21290z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends rb.g0 {
        @Override // rb.g0
        public g0.b a(r0.g gVar) {
            throw new IllegalStateException("Resolution is pending");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.this.x0(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class c implements n.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q2 f21292a;

        public c(q2 q2Var) {
            this.f21292a = q2Var;
        }

        @Override // tb.n.b
        public tb.n a() {
            return new tb.n(this.f21292a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f21294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rb.p f21295b;

        public d(Runnable runnable, rb.p pVar) {
            this.f21294a = runnable;
            this.f21295b = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.this.f21288x.c(this.f21294a, g1.this.f21273k, this.f21295b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class e extends r0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.f f21297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f21298b;

        public e(Throwable th) {
            this.f21298b = th;
            this.f21297a = r0.f.e(rb.k1.f19606s.r("Panic! This is a bug!").q(th));
        }

        @Override // rb.r0.j
        public r0.f a(r0.g gVar) {
            return this.f21297a;
        }

        public String toString() {
            return p6.h.a(e.class).d("panicPickResult", this.f21297a).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g1.this.N.get() || g1.this.E == null) {
                return;
            }
            g1.this.x0(false);
            g1.this.y0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.this.z0();
            if (g1.this.F != null) {
                g1.this.F.b();
            }
            if (g1.this.E != null) {
                g1.this.E.f21324a.c();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.this.V.a(f.a.INFO, "Entering SHUTDOWN state");
            g1.this.f21288x.b(rb.p.SHUTDOWN);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g1.this.O) {
                return;
            }
            g1.this.O = true;
            g1.this.D0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class j implements Thread.UncaughtExceptionHandler {
        public j() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            g1.f21245m0.log(Level.SEVERE, "[" + g1.this.f() + "] Uncaught exception in the SynchronizationContext. Panic!", th);
            g1.this.F0(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class k extends n0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f21305b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(rb.b1 b1Var, String str) {
            super(b1Var);
            this.f21305b = str;
        }

        @Override // tb.n0, rb.b1
        public String a() {
            return this.f21305b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class m implements q.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile b2.d0 f21306a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g1.this.z0();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class b extends b2 {
            public final /* synthetic */ rb.z0 E;
            public final /* synthetic */ rb.y0 F;
            public final /* synthetic */ rb.c G;
            public final /* synthetic */ c2 H;
            public final /* synthetic */ t0 I;
            public final /* synthetic */ rb.r J;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(rb.z0 z0Var, rb.y0 y0Var, rb.c cVar, c2 c2Var, t0 t0Var, rb.r rVar) {
                super(z0Var, y0Var, g1.this.f21260d0, g1.this.f21262e0, g1.this.f21264f0, g1.this.A0(cVar), g1.this.f21267h.Q(), c2Var, t0Var, m.this.f21306a);
                this.E = z0Var;
                this.F = y0Var;
                this.G = cVar;
                this.H = c2Var;
                this.I = t0Var;
                this.J = rVar;
            }

            @Override // tb.b2
            public tb.r i0(rb.y0 y0Var, k.a aVar, int i10, boolean z10) {
                rb.c cVarS = this.G.s(aVar);
                rb.k[] kVarArrF = r0.f(cVarS, y0Var, i10, z10);
                tb.t tVarC = m.this.c(new v1(this.E, y0Var, cVarS));
                rb.r rVarB = this.J.b();
                try {
                    return tVarC.g(this.E, y0Var, cVarS, kVarArrF);
                } finally {
                    this.J.f(rVarB);
                }
            }

            @Override // tb.b2
            public void j0() {
                g1.this.M.d(this);
            }

            @Override // tb.b2
            public rb.k1 k0() {
                return g1.this.M.a(this);
            }
        }

        public m() {
        }

        @Override // tb.q.e
        public tb.r a(rb.z0 z0Var, rb.c cVar, rb.y0 y0Var, rb.r rVar) {
            if (g1.this.f21266g0) {
                j1.b bVar = (j1.b) cVar.h(j1.b.f21444g);
                return new b(z0Var, y0Var, cVar, bVar == null ? null : bVar.f21449e, bVar != null ? bVar.f21450f : null, rVar);
            }
            tb.t tVarC = c(new v1(z0Var, y0Var, cVar));
            rb.r rVarB = rVar.b();
            try {
                return tVarC.g(z0Var, y0Var, cVar, r0.f(cVar, y0Var, 0, false));
            } finally {
                rVar.f(rVarB);
            }
        }

        public final tb.t c(r0.g gVar) {
            r0.j jVar = g1.this.F;
            if (g1.this.N.get()) {
                return g1.this.L;
            }
            if (jVar == null) {
                g1.this.f21282r.execute(new a());
                return g1.this.L;
            }
            tb.t tVarK = r0.k(jVar.a(gVar), gVar.a().j());
            return tVarK != null ? tVarK : g1.this.L;
        }

        public /* synthetic */ m(g1 g1Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class n extends rb.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rb.g0 f21309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rb.d f21310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Executor f21311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final rb.z0 f21312d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final rb.r f21313e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public rb.c f21314f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public rb.g f21315g;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends tb.y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g.a f21316b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ rb.k1 f21317c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g.a aVar, rb.k1 k1Var) {
                super(n.this.f21313e);
                this.f21316b = aVar;
                this.f21317c = k1Var;
            }

            @Override // tb.y
            public void a() {
                this.f21316b.a(this.f21317c, new rb.y0());
            }
        }

        public n(rb.g0 g0Var, rb.d dVar, Executor executor, rb.z0 z0Var, rb.c cVar) {
            this.f21309a = g0Var;
            this.f21310b = dVar;
            this.f21312d = z0Var;
            executor = cVar.e() != null ? cVar.e() : executor;
            this.f21311c = executor;
            this.f21314f = cVar.o(executor);
            this.f21313e = rb.r.e();
        }

        @Override // rb.a0, rb.e1, rb.g
        public void a(String str, Throwable th) {
            rb.g gVar = this.f21315g;
            if (gVar != null) {
                gVar.a(str, th);
            }
        }

        @Override // rb.a0, rb.g
        public void e(g.a aVar, rb.y0 y0Var) {
            g0.b bVarA = this.f21309a.a(new v1(this.f21312d, y0Var, this.f21314f));
            rb.k1 k1VarC = bVarA.c();
            if (!k1VarC.p()) {
                h(aVar, r0.o(k1VarC));
                this.f21315g = g1.f21252t0;
                return;
            }
            rb.h hVarB = bVarA.b();
            j1.b bVarF = ((j1) bVarA.a()).f(this.f21312d);
            if (bVarF != null) {
                this.f21314f = this.f21314f.r(j1.b.f21444g, bVarF);
            }
            if (hVarB != null) {
                this.f21315g = hVarB.a(this.f21312d, this.f21314f, this.f21310b);
            } else {
                this.f21315g = this.f21310b.e(this.f21312d, this.f21314f);
            }
            this.f21315g.e(aVar, y0Var);
        }

        @Override // rb.a0, rb.e1
        public rb.g f() {
            return this.f21315g;
        }

        public final void h(g.a aVar, rb.k1 k1Var) {
            this.f21311c.execute(new a(aVar, k1Var));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class o implements k1.a {
        public o() {
        }

        @Override // tb.k1.a
        public void b() {
            p6.n.u(g1.this.N.get(), "Channel must have been shut down");
            g1.this.P = true;
            g1.this.J0(false);
            g1.this.D0();
            g1.this.E0();
        }

        @Override // tb.k1.a
        public void c(rb.k1 k1Var) {
            p6.n.u(g1.this.N.get(), "Channel must have been shut down");
        }

        @Override // tb.k1.a
        public void d(boolean z10) {
            g1 g1Var = g1.this;
            g1Var.f21272j0.e(g1Var.L, z10);
        }

        public /* synthetic */ o(g1 g1Var, a aVar) {
            this();
        }

        @Override // tb.k1.a
        public void a() {
        }

        @Override // tb.k1.a
        public rb.a e(rb.a aVar) {
            return aVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class p implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p1 f21320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f21321b;

        public p(p1 p1Var) {
            this.f21320a = (p1) p6.n.o(p1Var, "executorPool");
        }

        public synchronized Executor a() {
            try {
                if (this.f21321b == null) {
                    this.f21321b = (Executor) p6.n.p((Executor) this.f21320a.a(), "%s.getObject()", this.f21321b);
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f21321b;
        }

        public synchronized void b() {
            Executor executor = this.f21321b;
            if (executor != null) {
                this.f21321b = (Executor) this.f21320a.b(executor);
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a().execute(runnable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class q extends w0 {
        public q() {
        }

        @Override // tb.w0
        public void b() {
            g1.this.z0();
        }

        @Override // tb.w0
        public void c() {
            if (g1.this.N.get()) {
                return;
            }
            g1.this.H0();
        }

        public /* synthetic */ q(g1 g1Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g1.this.E == null) {
                return;
            }
            g1.this.y0();
        }

        public /* synthetic */ r(g1 g1Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class s extends r0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i.b f21324a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g1.this.G0();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r0.j f21327a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ rb.p f21328b;

            public b(r0.j jVar, rb.p pVar) {
                this.f21327a = jVar;
                this.f21328b = pVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                s sVar = s.this;
                if (sVar != g1.this.E) {
                    return;
                }
                g1.this.L0(this.f21327a);
                if (this.f21328b != rb.p.SHUTDOWN) {
                    g1.this.V.b(f.a.INFO, "Entering {0} state with picker: {1}", this.f21328b, this.f21327a);
                    g1.this.f21288x.b(this.f21328b);
                }
            }
        }

        public s() {
        }

        @Override // rb.r0.e
        public rb.f b() {
            return g1.this.V;
        }

        @Override // rb.r0.e
        public ScheduledExecutorService c() {
            return g1.this.f21271j;
        }

        @Override // rb.r0.e
        public rb.o1 d() {
            return g1.this.f21282r;
        }

        @Override // rb.r0.e
        public void e() {
            g1.this.f21282r.f();
            g1.this.f21282r.execute(new a());
        }

        @Override // rb.r0.e
        public void f(rb.p pVar, r0.j jVar) {
            g1.this.f21282r.f();
            p6.n.o(pVar, "newState");
            p6.n.o(jVar, "newPicker");
            g1.this.f21282r.execute(new b(jVar, pVar));
        }

        @Override // rb.r0.e
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public tb.d a(r0.b bVar) {
            g1.this.f21282r.f();
            p6.n.u(!g1.this.P, "Channel is being terminated");
            return g1.this.new x(bVar);
        }

        public /* synthetic */ s(g1 g1Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class t extends b1.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f21330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rb.b1 f21331b;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rb.k1 f21333a;

            public a(rb.k1 k1Var) {
                this.f21333a = k1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                t.this.d(this.f21333a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b1.e f21335a;

            public b(b1.e eVar) {
                this.f21335a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                j1 j1Var;
                if (g1.this.C != t.this.f21331b) {
                    return;
                }
                List listA = this.f21335a.a();
                rb.f fVar = g1.this.V;
                f.a aVar = f.a.DEBUG;
                fVar.b(aVar, "Resolved address: {0}, config={1}", listA, this.f21335a.b());
                v vVar = g1.this.Y;
                v vVar2 = v.SUCCESS;
                if (vVar != vVar2) {
                    g1.this.V.b(f.a.INFO, "Address resolved: {0}", listA);
                    g1.this.Y = vVar2;
                }
                b1.b bVarC = this.f21335a.c();
                e2.b bVar = (e2.b) this.f21335a.b().b(e2.f21212e);
                rb.g0 g0Var = (rb.g0) this.f21335a.b().b(rb.g0.f19566a);
                j1 j1Var2 = (bVarC == null || bVarC.c() == null) ? null : (j1) bVarC.c();
                rb.k1 k1VarD = bVarC != null ? bVarC.d() : null;
                if (g1.this.f21258c0) {
                    if (j1Var2 != null) {
                        if (g0Var != null) {
                            g1.this.X.p(g0Var);
                            if (j1Var2.c() != null) {
                                g1.this.V.a(aVar, "Method configs in service config will be discarded due to presence ofconfig-selector");
                            }
                        } else {
                            g1.this.X.p(j1Var2.c());
                        }
                    } else if (g1.this.f21254a0 != null) {
                        j1Var2 = g1.this.f21254a0;
                        g1.this.X.p(j1Var2.c());
                        g1.this.V.a(f.a.INFO, "Received no service config, using default service config");
                    } else if (k1VarD == null) {
                        j1Var2 = g1.f21250r0;
                        g1.this.X.p(null);
                    } else {
                        if (!g1.this.f21256b0) {
                            g1.this.V.a(f.a.INFO, "Fallback to error due to invalid first service config without default config");
                            t.this.a(bVarC.d());
                            if (bVar != null) {
                                bVar.a(bVarC.d());
                                return;
                            }
                            return;
                        }
                        j1Var2 = g1.this.Z;
                    }
                    if (!j1Var2.equals(g1.this.Z)) {
                        g1.this.V.b(f.a.INFO, "Service config changed{0}", j1Var2 == g1.f21250r0 ? " to empty" : "");
                        g1.this.Z = j1Var2;
                        g1.this.f21274k0.f21306a = j1Var2.g();
                    }
                    try {
                        g1.this.f21256b0 = true;
                    } catch (RuntimeException e10) {
                        g1.f21245m0.log(Level.WARNING, "[" + g1.this.f() + "] Unexpected exception from parsing service config", (Throwable) e10);
                    }
                    j1Var = j1Var2;
                } else {
                    if (j1Var2 != null) {
                        g1.this.V.a(f.a.INFO, "Service config from name resolver discarded by channel settings");
                    }
                    j1Var = g1.this.f21254a0 == null ? g1.f21250r0 : g1.this.f21254a0;
                    if (g0Var != null) {
                        g1.this.V.a(f.a.INFO, "Config selector from name resolver discarded by channel settings");
                    }
                    g1.this.X.p(j1Var.c());
                }
                rb.a aVarB = this.f21335a.b();
                t tVar = t.this;
                if (tVar.f21330a == g1.this.E) {
                    a.b bVarC2 = aVarB.d().c(rb.g0.f19566a);
                    Map mapD = j1Var.d();
                    if (mapD != null) {
                        bVarC2.d(rb.r0.f19691b, mapD).a();
                    }
                    rb.k1 k1VarE = t.this.f21330a.f21324a.e(r0.h.d().b(listA).c(bVarC2.a()).d(j1Var.e()).a());
                    if (bVar != null) {
                        bVar.a(k1VarE);
                    }
                }
            }
        }

        public t(s sVar, rb.b1 b1Var) {
            this.f21330a = (s) p6.n.o(sVar, "helperImpl");
            this.f21331b = (rb.b1) p6.n.o(b1Var, "resolver");
        }

        @Override // rb.b1.d
        public void a(rb.k1 k1Var) {
            p6.n.e(!k1Var.p(), "the error status must not be OK");
            g1.this.f21282r.execute(new a(k1Var));
        }

        @Override // rb.b1.d
        public void b(b1.e eVar) {
            g1.this.f21282r.execute(new b(eVar));
        }

        public final void d(rb.k1 k1Var) {
            g1.f21245m0.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{g1.this.f(), k1Var});
            g1.this.X.m();
            v vVar = g1.this.Y;
            v vVar2 = v.ERROR;
            if (vVar != vVar2) {
                g1.this.V.b(f.a.WARNING, "Failed to resolve name: {0}", k1Var);
                g1.this.Y = vVar2;
            }
            if (this.f21330a != g1.this.E) {
                return;
            }
            this.f21330a.f21324a.b(k1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class u extends rb.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference f21337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final rb.d f21339c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends rb.d {
            public a() {
            }

            @Override // rb.d
            public String a() {
                return u.this.f21338b;
            }

            @Override // rb.d
            public rb.g e(rb.z0 z0Var, rb.c cVar) {
                return new tb.q(z0Var, g1.this.A0(cVar), cVar, g1.this.f21274k0, g1.this.Q ? null : g1.this.f21267h.Q(), g1.this.T, null).E(g1.this.f21283s).D(g1.this.f21284t).C(g1.this.f21285u);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g1.this.I == null) {
                    if (u.this.f21337a.get() == g1.f21251s0) {
                        u.this.f21337a.set(null);
                    }
                    g1.this.M.b(g1.f21248p0);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (u.this.f21337a.get() == g1.f21251s0) {
                    u.this.f21337a.set(null);
                }
                if (g1.this.I != null) {
                    Iterator it = g1.this.I.iterator();
                    while (it.hasNext()) {
                        ((g) it.next()).a("Channel is forcefully shutdown", null);
                    }
                }
                g1.this.M.c(g1.f21247o0);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g1.this.z0();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f21346a;

            public f(g gVar) {
                this.f21346a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (u.this.f21337a.get() != g1.f21251s0) {
                    this.f21346a.r();
                    return;
                }
                if (g1.this.I == null) {
                    g1.this.I = new LinkedHashSet();
                    g1 g1Var = g1.this;
                    g1Var.f21272j0.e(g1Var.J, true);
                }
                g1.this.I.add(this.f21346a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class g extends a0 {

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final rb.r f21348l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final rb.z0 f21349m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final rb.c f21350n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final long f21351o;

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Runnable f21353a;

                public a(Runnable runnable) {
                    this.f21353a = runnable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f21353a.run();
                    g gVar = g.this;
                    g1.this.f21282r.execute(gVar.new b());
                }
            }

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public final class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (g1.this.I != null) {
                        g1.this.I.remove(g.this);
                        if (g1.this.I.isEmpty()) {
                            g1 g1Var = g1.this;
                            g1Var.f21272j0.e(g1Var.J, false);
                            g1.this.I = null;
                            if (g1.this.N.get()) {
                                g1.this.M.b(g1.f21248p0);
                            }
                        }
                    }
                }
            }

            public g(rb.r rVar, rb.z0 z0Var, rb.c cVar) {
                super(g1.this.A0(cVar), g1.this.f21271j, cVar.d());
                this.f21348l = rVar;
                this.f21349m = z0Var;
                this.f21350n = cVar;
                this.f21351o = g1.this.f21268h0.a();
            }

            @Override // tb.a0
            public void j() {
                super.j();
                g1.this.f21282r.execute(new b());
            }

            public void r() {
                rb.r rVarB = this.f21348l.b();
                try {
                    rb.g gVarL = u.this.l(this.f21349m, this.f21350n.r(rb.k.f19580a, Long.valueOf(g1.this.f21268h0.a() - this.f21351o)));
                    this.f21348l.f(rVarB);
                    Runnable runnableP = p(gVarL);
                    if (runnableP == null) {
                        g1.this.f21282r.execute(new b());
                    } else {
                        g1.this.A0(this.f21350n).execute(new a(runnableP));
                    }
                } catch (Throwable th) {
                    this.f21348l.f(rVarB);
                    throw th;
                }
            }
        }

        public /* synthetic */ u(g1 g1Var, String str, a aVar) {
            this(str);
        }

        @Override // rb.d
        public String a() {
            return this.f21338b;
        }

        @Override // rb.d
        public rb.g e(rb.z0 z0Var, rb.c cVar) {
            if (this.f21337a.get() != g1.f21251s0) {
                return l(z0Var, cVar);
            }
            g1.this.f21282r.execute(new d());
            if (this.f21337a.get() != g1.f21251s0) {
                return l(z0Var, cVar);
            }
            if (g1.this.N.get()) {
                return new e();
            }
            g gVar = new g(rb.r.e(), z0Var, cVar);
            g1.this.f21282r.execute(new f(gVar));
            return gVar;
        }

        public final rb.g l(rb.z0 z0Var, rb.c cVar) {
            rb.g0 g0Var = (rb.g0) this.f21337a.get();
            if (g0Var == null) {
                return this.f21339c.e(z0Var, cVar);
            }
            if (!(g0Var instanceof j1.c)) {
                return new n(g0Var, this.f21339c, g1.this.f21273k, z0Var, cVar);
            }
            j1.b bVarF = ((j1.c) g0Var).f21451b.f(z0Var);
            if (bVarF != null) {
                cVar = cVar.r(j1.b.f21444g, bVarF);
            }
            return this.f21339c.e(z0Var, cVar);
        }

        public void m() {
            if (this.f21337a.get() == g1.f21251s0) {
                p(null);
            }
        }

        public void n() {
            g1.this.f21282r.execute(new b());
        }

        public void o() {
            g1.this.f21282r.execute(new c());
        }

        public void p(rb.g0 g0Var) {
            rb.g0 g0Var2 = (rb.g0) this.f21337a.get();
            this.f21337a.set(g0Var);
            if (g0Var2 != g1.f21251s0 || g1.this.I == null) {
                return;
            }
            Iterator it = g1.this.I.iterator();
            while (it.hasNext()) {
                ((g) it.next()).r();
            }
        }

        public u(String str) {
            this.f21337a = new AtomicReference(g1.f21251s0);
            this.f21339c = new a();
            this.f21338b = (String) p6.n.o(str, "authority");
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class e extends rb.g {
            public e() {
            }

            @Override // rb.g
            public void e(g.a aVar, rb.y0 y0Var) {
                aVar.a(g1.f21248p0, new rb.y0());
            }

            @Override // rb.g
            public void b() {
            }

            @Override // rb.g
            public void c(int i10) {
            }

            @Override // rb.g
            public void d(Object obj) {
            }

            @Override // rb.g
            public void a(String str, Throwable th) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum v {
        NO_RESOLUTION,
        SUCCESS,
        ERROR
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class w implements ScheduledExecutorService, AutoCloseable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f21360a;

        public /* synthetic */ w(ScheduledExecutorService scheduledExecutorService, a aVar) {
            this(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j10, TimeUnit timeUnit) {
            return this.f21360a.awaitTermination(j10, timeUnit);
        }

        @Override // java.lang.AutoCloseable
        public /* synthetic */ void close() {
            l3.a.a(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f21360a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public List invokeAll(Collection collection) {
            return this.f21360a.invokeAll(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public Object invokeAny(Collection collection) {
            return this.f21360a.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.f21360a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.f21360a.isTerminated();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture schedule(Callable callable, long j10, TimeUnit timeUnit) {
            return this.f21360a.schedule(callable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.f21360a.scheduleAtFixedRate(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.f21360a.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
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
            return this.f21360a.submit(callable);
        }

        public w(ScheduledExecutorService scheduledExecutorService) {
            this.f21360a = (ScheduledExecutorService) p6.n.o(scheduledExecutorService, "delegate");
        }

        @Override // java.util.concurrent.ExecutorService
        public List invokeAll(Collection collection, long j10, TimeUnit timeUnit) {
            return this.f21360a.invokeAll(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public Object invokeAny(Collection collection, long j10, TimeUnit timeUnit) {
            return this.f21360a.invokeAny(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f21360a.schedule(runnable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Runnable runnable) {
            return this.f21360a.submit(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Runnable runnable, Object obj) {
            return this.f21360a.submit(runnable, obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class x extends tb.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.b f21361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rb.k0 f21362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final tb.o f21363c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final tb.p f21364d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f21365e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public y0 f21366f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f21367g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f21368h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public o1.d f21369i;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class a extends y0.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r0.k f21371a;

            public a(r0.k kVar) {
                this.f21371a = kVar;
            }

            @Override // tb.y0.j
            public void a(y0 y0Var) {
                g1.this.f21272j0.e(y0Var, true);
            }

            @Override // tb.y0.j
            public void b(y0 y0Var) {
                g1.this.f21272j0.e(y0Var, false);
            }

            @Override // tb.y0.j
            public void c(y0 y0Var, rb.q qVar) {
                p6.n.u(this.f21371a != null, "listener is null");
                this.f21371a.a(qVar);
            }

            @Override // tb.y0.j
            public void d(y0 y0Var) {
                g1.this.H.remove(y0Var);
                g1.this.W.k(y0Var);
                g1.this.E0();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                x.this.f21366f.c(g1.f21249q0);
            }
        }

        public x(r0.b bVar) {
            p6.n.o(bVar, "args");
            this.f21365e = bVar.a();
            if (g1.this.f21257c != null) {
                bVar = bVar.e().e(j(bVar.a())).c();
            }
            this.f21361a = bVar;
            rb.k0 k0VarB = rb.k0.b("Subchannel", g1.this.a());
            this.f21362b = k0VarB;
            tb.p pVar = new tb.p(k0VarB, g1.this.f21281q, g1.this.f21280p.a(), "Subchannel for " + bVar.a());
            this.f21364d = pVar;
            this.f21363c = new tb.o(pVar, g1.this.f21280p);
        }

        @Override // rb.r0.i
        public List b() {
            g1.this.f21282r.f();
            p6.n.u(this.f21367g, "not started");
            return this.f21365e;
        }

        @Override // rb.r0.i
        public rb.a c() {
            return this.f21361a.b();
        }

        @Override // rb.r0.i
        public rb.f d() {
            return this.f21363c;
        }

        @Override // rb.r0.i
        public Object e() {
            p6.n.u(this.f21367g, "Subchannel is not started");
            return this.f21366f;
        }

        @Override // rb.r0.i
        public void f() {
            g1.this.f21282r.f();
            p6.n.u(this.f21367g, "not started");
            this.f21366f.a();
        }

        @Override // rb.r0.i
        public void g() {
            o1.d dVar;
            g1.this.f21282r.f();
            if (this.f21366f == null) {
                this.f21368h = true;
                return;
            }
            if (!this.f21368h) {
                this.f21368h = true;
            } else {
                if (!g1.this.P || (dVar = this.f21369i) == null) {
                    return;
                }
                dVar.a();
                this.f21369i = null;
            }
            if (g1.this.P) {
                this.f21366f.c(g1.f21248p0);
            } else {
                this.f21369i = g1.this.f21282r.d(new d1(new b()), 5L, TimeUnit.SECONDS, g1.this.f21267h.Q());
            }
        }

        @Override // rb.r0.i
        public void h(r0.k kVar) {
            g1.this.f21282r.f();
            p6.n.u(!this.f21367g, "already started");
            p6.n.u(!this.f21368h, "already shutdown");
            p6.n.u(!g1.this.P, "Channel is being terminated");
            this.f21367g = true;
            y0 y0Var = new y0(this.f21361a.a(), g1.this.a(), g1.this.B, g1.this.f21289y, g1.this.f21267h, g1.this.f21267h.Q(), g1.this.f21286v, g1.this.f21282r, new a(kVar), g1.this.W, g1.this.S.a(), this.f21364d, this.f21362b, this.f21363c, g1.this.A);
            g1.this.U.e(new f0.a().b("Child Subchannel started").c(f0.b.CT_INFO).e(g1.this.f21280p.a()).d(y0Var).a());
            this.f21366f = y0Var;
            g1.this.W.e(y0Var);
            g1.this.H.add(y0Var);
        }

        @Override // rb.r0.i
        public void i(List list) {
            g1.this.f21282r.f();
            this.f21365e = list;
            if (g1.this.f21257c != null) {
                list = j(list);
            }
            this.f21366f.U(list);
        }

        public final List j(List list) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                rb.x xVar = (rb.x) it.next();
                arrayList.add(new rb.x(xVar.a(), xVar.b().d().c(rb.x.f19736d).a()));
            }
            return Collections.unmodifiableList(arrayList);
        }

        public String toString() {
            return this.f21362b.toString();
        }
    }

    static {
        rb.k1 k1Var = rb.k1.f19607t;
        f21247o0 = k1Var.r("Channel shutdownNow invoked");
        f21248p0 = k1Var.r("Channel shutdown invoked");
        f21249q0 = k1Var.r("Subchannel shutdown invoked");
        f21250r0 = j1.a();
        f21251s0 = new a();
        f21252t0 = new l();
    }

    public g1(h1 h1Var, tb.u uVar, j.a aVar, p1 p1Var, p6.s sVar, List list, q2 q2Var) {
        a aVar2;
        rb.o1 o1Var = new rb.o1(new j());
        this.f21282r = o1Var;
        this.f21288x = new tb.x();
        this.H = new HashSet(16, 0.75f);
        this.J = new Object();
        this.K = new HashSet(1, 0.75f);
        a aVar3 = null;
        this.M = new y(this, aVar3);
        this.N = new AtomicBoolean(false);
        this.R = new CountDownLatch(1);
        this.Y = v.NO_RESOLUTION;
        this.Z = f21250r0;
        this.f21256b0 = false;
        this.f21260d0 = new b2.t();
        this.f21268h0 = rb.t.k();
        o oVar = new o(this, aVar3);
        this.f21270i0 = oVar;
        this.f21272j0 = new q(this, aVar3);
        this.f21274k0 = new m(this, aVar3);
        String str = (String) p6.n.o(h1Var.f21390f, "target");
        this.f21255b = str;
        rb.k0 k0VarB = rb.k0.b("Channel", str);
        this.f21253a = k0VarB;
        this.f21280p = (q2) p6.n.o(q2Var, "timeProvider");
        p1 p1Var2 = (p1) p6.n.o(h1Var.f21385a, "executorPool");
        this.f21275l = p1Var2;
        Executor executor = (Executor) p6.n.o((Executor) p1Var2.a(), "executor");
        this.f21273k = executor;
        this.f21265g = uVar;
        p pVar = new p((p1) p6.n.o(h1Var.f21386b, "offloadExecutorPool"));
        this.f21279o = pVar;
        tb.m mVar = new tb.m(uVar, h1Var.f21391g, pVar);
        this.f21267h = mVar;
        this.f21269i = new tb.m(uVar, null, pVar);
        w wVar = new w(mVar.Q(), aVar3);
        this.f21271j = wVar;
        this.f21281q = h1Var.f21406v;
        tb.p pVar2 = new tb.p(k0VarB, h1Var.f21406v, q2Var.a(), "Channel for '" + str + "'");
        this.U = pVar2;
        tb.o oVar2 = new tb.o(pVar2, q2Var);
        this.V = oVar2;
        rb.g1 g1Var = h1Var.f21409y;
        g1Var = g1Var == null ? r0.f21640q : g1Var;
        boolean z10 = h1Var.f21404t;
        this.f21266g0 = z10;
        tb.i iVar = new tb.i(h1Var.f21395k);
        this.f21263f = iVar;
        rb.d1 d1Var = h1Var.f21388d;
        this.f21259d = d1Var;
        g2 g2Var = new g2(z10, h1Var.f21400p, h1Var.f21401q, iVar);
        String str2 = h1Var.f21394j;
        this.f21257c = str2;
        b1.a aVarA = b1.a.g().c(h1Var.e()).f(g1Var).i(o1Var).g(wVar).h(g2Var).b(oVar2).d(pVar).e(str2).a();
        this.f21261e = aVarA;
        this.C = B0(str, str2, d1Var, aVarA, mVar.Y());
        this.f21277m = (p1) p6.n.o(p1Var, "balancerRpcExecutorPool");
        this.f21278n = new p(p1Var);
        b0 b0Var = new b0(executor, o1Var);
        this.L = b0Var;
        b0Var.d(oVar);
        this.f21289y = aVar;
        Map map = h1Var.f21407w;
        if (map != null) {
            b1.b bVarA = g2Var.a(map);
            p6.n.x(bVarA.d() == null, "Default config is invalid: %s", bVarA.d());
            j1 j1Var = (j1) bVarA.c();
            this.f21254a0 = j1Var;
            this.Z = j1Var;
            aVar2 = null;
        } else {
            aVar2 = null;
            this.f21254a0 = null;
        }
        boolean z11 = h1Var.f21408x;
        this.f21258c0 = z11;
        u uVar2 = new u(this, this.C.a(), aVar2);
        this.X = uVar2;
        this.f21290z = rb.j.a(uVar2, list);
        this.A = new ArrayList(h1Var.f21389e);
        this.f21286v = (p6.s) p6.n.o(sVar, "stopwatchSupplier");
        long j10 = h1Var.f21399o;
        if (j10 == -1) {
            this.f21287w = j10;
        } else {
            p6.n.i(j10 >= h1.J, "invalid idleTimeoutMillis %s", j10);
            this.f21287w = h1Var.f21399o;
        }
        this.f21276l0 = new a2(new r(this, null), o1Var, mVar.Q(), (p6.q) sVar.get());
        this.f21283s = h1Var.f21396l;
        this.f21284t = (rb.v) p6.n.o(h1Var.f21397m, "decompressorRegistry");
        this.f21285u = (rb.o) p6.n.o(h1Var.f21398n, "compressorRegistry");
        this.B = h1Var.f21393i;
        this.f21264f0 = h1Var.f21402r;
        this.f21262e0 = h1Var.f21403s;
        c cVar = new c(q2Var);
        this.S = cVar;
        this.T = cVar.a();
        rb.e0 e0Var = (rb.e0) p6.n.n(h1Var.f21405u);
        this.W = e0Var;
        e0Var.d(this);
        if (z11) {
            return;
        }
        if (this.f21254a0 != null) {
            oVar2.a(f.a.INFO, "Service config look-up disabled, using default service config");
        }
        this.f21256b0 = true;
    }

    public static rb.b1 B0(String str, String str2, rb.d1 d1Var, b1.a aVar, Collection collection) {
        e2 e2Var = new e2(C0(str, d1Var, aVar, collection), new tb.l(new f0.a(), aVar.d(), aVar.f()), aVar.f());
        return str2 == null ? e2Var : new k(e2Var, str2);
    }

    public static rb.b1 C0(String str, rb.d1 d1Var, b1.a aVar, Collection collection) {
        URI uri;
        StringBuilder sb2 = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e10) {
            sb2.append(e10.getMessage());
            uri = null;
        }
        rb.c1 c1VarE = uri != null ? d1Var.e(uri.getScheme()) : null;
        String str2 = "";
        if (c1VarE == null && !f21246n0.matcher(str).matches()) {
            try {
                uri = new URI(d1Var.c(), "", "/" + str, null);
                c1VarE = d1Var.e(uri.getScheme());
            } catch (URISyntaxException e11) {
                throw new IllegalArgumentException(e11);
            }
        }
        if (c1VarE == null) {
            if (sb2.length() > 0) {
                str2 = " (" + ((Object) sb2) + ")";
            }
            throw new IllegalArgumentException(String.format("Could not find a NameResolverProvider for %s%s", str, str2));
        }
        if (collection != null && !collection.containsAll(c1VarE.c())) {
            throw new IllegalArgumentException(String.format("Address types of NameResolver '%s' for '%s' not supported by transport", uri.getScheme(), str));
        }
        rb.b1 b1VarB = c1VarE.b(uri, aVar);
        if (b1VarB != null) {
            return b1VarB;
        }
        if (sb2.length() > 0) {
            str2 = " (" + ((Object) sb2) + ")";
        }
        throw new IllegalArgumentException(String.format("cannot create a NameResolver for %s%s", str, str2));
    }

    public final Executor A0(rb.c cVar) {
        Executor executorE = cVar.e();
        return executorE == null ? this.f21273k : executorE;
    }

    public final void D0() {
        if (this.O) {
            Iterator it = this.H.iterator();
            while (it.hasNext()) {
                ((y0) it.next()).h(f21247o0);
            }
            Iterator it2 = this.K.iterator();
            if (it2.hasNext()) {
                android.support.v4.media.session.b.a(it2.next());
                throw null;
            }
        }
    }

    public final void E0() {
        if (!this.Q && this.N.get() && this.H.isEmpty() && this.K.isEmpty()) {
            this.V.a(f.a.INFO, "Terminated");
            this.W.j(this);
            this.f21275l.b(this.f21273k);
            this.f21278n.b();
            this.f21279o.b();
            this.f21267h.close();
            this.Q = true;
            this.R.countDown();
        }
    }

    public void F0(Throwable th) {
        if (this.G) {
            return;
        }
        this.G = true;
        x0(true);
        J0(false);
        L0(new e(th));
        this.X.p(null);
        this.V.a(f.a.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        this.f21288x.b(rb.p.TRANSIENT_FAILURE);
    }

    public final void G0() {
        this.f21282r.f();
        if (this.D) {
            this.C.b();
        }
    }

    public final void H0() {
        long j10 = this.f21287w;
        if (j10 == -1) {
            return;
        }
        this.f21276l0.k(j10, TimeUnit.MILLISECONDS);
    }

    @Override // rb.u0
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public g1 m() {
        this.V.a(f.a.DEBUG, "shutdown() called");
        if (!this.N.compareAndSet(false, true)) {
            return this;
        }
        this.f21282r.execute(new h());
        this.X.n();
        this.f21282r.execute(new b());
        return this;
    }

    public final void J0(boolean z10) {
        this.f21282r.f();
        if (z10) {
            p6.n.u(this.D, "nameResolver is not started");
            p6.n.u(this.E != null, "lbHelper is null");
        }
        rb.b1 b1Var = this.C;
        if (b1Var != null) {
            b1Var.c();
            this.D = false;
            if (z10) {
                this.C = B0(this.f21255b, this.f21257c, this.f21259d, this.f21261e, this.f21267h.Y());
            } else {
                this.C = null;
            }
        }
        s sVar = this.E;
        if (sVar != null) {
            sVar.f21324a.d();
            this.E = null;
        }
        this.F = null;
    }

    @Override // rb.u0
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public g1 n() {
        this.V.a(f.a.DEBUG, "shutdownNow() called");
        m();
        this.X.o();
        this.f21282r.execute(new i());
        return this;
    }

    public final void L0(r0.j jVar) {
        this.F = jVar;
        this.L.r(jVar);
    }

    @Override // rb.d
    public String a() {
        return this.f21290z.a();
    }

    @Override // rb.d
    public rb.g e(rb.z0 z0Var, rb.c cVar) {
        return this.f21290z.e(z0Var, cVar);
    }

    @Override // rb.p0
    public rb.k0 f() {
        return this.f21253a;
    }

    @Override // rb.u0
    public boolean i(long j10, TimeUnit timeUnit) {
        return this.R.await(j10, timeUnit);
    }

    @Override // rb.u0
    public void j() {
        this.f21282r.execute(new f());
    }

    @Override // rb.u0
    public rb.p k(boolean z10) {
        rb.p pVarA = this.f21288x.a();
        if (z10 && pVarA == rb.p.IDLE) {
            this.f21282r.execute(new g());
        }
        return pVarA;
    }

    @Override // rb.u0
    public void l(rb.p pVar, Runnable runnable) {
        this.f21282r.execute(new d(runnable, pVar));
    }

    public String toString() {
        return p6.h.b(this).c("logId", this.f21253a.d()).d("target", this.f21255b).toString();
    }

    public final void x0(boolean z10) {
        this.f21276l0.i(z10);
    }

    public final void y0() {
        J0(true);
        this.L.r(null);
        this.V.a(f.a.INFO, "Entering IDLE state");
        this.f21288x.b(rb.p.IDLE);
        if (this.f21272j0.a(this.J, this.L)) {
            z0();
        }
    }

    public void z0() {
        this.f21282r.f();
        if (this.N.get() || this.G) {
            return;
        }
        if (this.f21272j0.d()) {
            x0(false);
        } else {
            H0();
        }
        if (this.E != null) {
            return;
        }
        this.V.a(f.a.INFO, "Exiting idle mode");
        s sVar = new s(this, null);
        sVar.f21324a = this.f21263f.e(sVar);
        this.E = sVar;
        this.C.d(new t(sVar, this.C));
        this.D = true;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f21374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Collection f21375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public rb.k1 f21376c;

        public y() {
            this.f21374a = new Object();
            this.f21375b = new HashSet();
        }

        public rb.k1 a(b2 b2Var) {
            synchronized (this.f21374a) {
                try {
                    rb.k1 k1Var = this.f21376c;
                    if (k1Var != null) {
                        return k1Var;
                    }
                    this.f21375b.add(b2Var);
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b(rb.k1 k1Var) {
            synchronized (this.f21374a) {
                try {
                    if (this.f21376c != null) {
                        return;
                    }
                    this.f21376c = k1Var;
                    boolean zIsEmpty = this.f21375b.isEmpty();
                    if (zIsEmpty) {
                        g1.this.L.c(k1Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c(rb.k1 k1Var) {
            ArrayList arrayList;
            b(k1Var);
            synchronized (this.f21374a) {
                arrayList = new ArrayList(this.f21375b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((tb.r) it.next()).e(k1Var);
            }
            g1.this.L.h(k1Var);
        }

        public void d(b2 b2Var) {
            rb.k1 k1Var;
            synchronized (this.f21374a) {
                try {
                    this.f21375b.remove(b2Var);
                    if (this.f21375b.isEmpty()) {
                        k1Var = this.f21376c;
                        this.f21375b = new HashSet();
                    } else {
                        k1Var = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (k1Var != null) {
                g1.this.L.c(k1Var);
            }
        }

        public /* synthetic */ y(g1 g1Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class l extends rb.g {
        @Override // rb.g
        public void b() {
        }

        @Override // rb.g
        public void c(int i10) {
        }

        @Override // rb.g
        public void d(Object obj) {
        }

        @Override // rb.g
        public void a(String str, Throwable th) {
        }

        @Override // rb.g
        public void e(g.a aVar, rb.y0 y0Var) {
        }
    }
}
