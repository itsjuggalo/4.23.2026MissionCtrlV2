package tb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import rb.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 extends rb.g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Logger f20887j = Logger.getLogger(a0.class.getName());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final rb.g f20888k = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f20889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f20890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rb.r f20891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f20892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g.a f20893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public rb.g f20894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public rb.k1 f20895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f20896h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f20897i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends y {
        public a(rb.r rVar) {
            super(rVar);
        }

        @Override // tb.y
        public void a() {
            a0.this.m();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f20899a;

        public b(StringBuilder sb2) {
            this.f20899a = sb2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.k(rb.k1.f19596i.r(this.f20899a.toString()), true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f20901b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k kVar) {
            super(a0.this.f20891c);
            this.f20901b = kVar;
        }

        @Override // tb.y
        public void a() {
            this.f20901b.g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.a f20903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rb.y0 f20904b;

        public d(g.a aVar, rb.y0 y0Var) {
            this.f20903a = aVar;
            this.f20904b = y0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.f20894f.e(this.f20903a, this.f20904b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.k1 f20906a;

        public e(rb.k1 k1Var) {
            this.f20906a = k1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.f20894f.a(this.f20906a.o(), this.f20906a.m());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f20908a;

        public f(Object obj) {
            this.f20908a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.f20894f.d(this.f20908a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20910a;

        public g(int i10) {
            this.f20910a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.f20894f.c(this.f20910a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.f20894f.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class j extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g.a f20913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final rb.k1 f20914c;

        public j(g.a aVar, rb.k1 k1Var) {
            super(a0.this.f20891c);
            this.f20913b = aVar;
            this.f20914c = k1Var;
        }

        @Override // tb.y
        public void a() {
            this.f20913b.a(this.f20914c, new rb.y0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class k extends g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g.a f20916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f20917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f20918c = new ArrayList();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rb.y0 f20919a;

            public a(rb.y0 y0Var) {
                this.f20919a = y0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f20916a.b(this.f20919a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f20921a;

            public b(Object obj) {
                this.f20921a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f20916a.c(this.f20921a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rb.k1 f20923a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ rb.y0 f20924b;

            public c(rb.k1 k1Var, rb.y0 y0Var) {
                this.f20923a = k1Var;
                this.f20924b = y0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f20916a.a(this.f20923a, this.f20924b);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f20916a.d();
            }
        }

        public k(g.a aVar) {
            this.f20916a = aVar;
        }

        @Override // rb.g.a
        public void a(rb.k1 k1Var, rb.y0 y0Var) {
            f(new c(k1Var, y0Var));
        }

        @Override // rb.g.a
        public void b(rb.y0 y0Var) {
            if (this.f20917b) {
                this.f20916a.b(y0Var);
            } else {
                f(new a(y0Var));
            }
        }

        @Override // rb.g.a
        public void c(Object obj) {
            if (this.f20917b) {
                this.f20916a.c(obj);
            } else {
                f(new b(obj));
            }
        }

        @Override // rb.g.a
        public void d() {
            if (this.f20917b) {
                this.f20916a.d();
            } else {
                f(new d());
            }
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                try {
                    if (this.f20917b) {
                        runnable.run();
                    } else {
                        this.f20918c.add(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void g() {
            List list;
            List arrayList = new ArrayList();
            while (true) {
                synchronized (this) {
                    try {
                        if (this.f20918c.isEmpty()) {
                            this.f20918c = null;
                            this.f20917b = true;
                            return;
                        } else {
                            list = this.f20918c;
                            this.f20918c = arrayList;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                list.clear();
                arrayList = list;
            }
        }
    }

    public a0(Executor executor, ScheduledExecutorService scheduledExecutorService, rb.t tVar) {
        this.f20890b = (Executor) p6.n.o(executor, "callExecutor");
        p6.n.o(scheduledExecutorService, "scheduler");
        this.f20891c = rb.r.e();
        this.f20889a = o(scheduledExecutorService, tVar);
    }

    @Override // rb.g
    public final void a(String str, Throwable th) {
        rb.k1 k1Var = rb.k1.f19593f;
        rb.k1 k1VarR = str != null ? k1Var.r(str) : k1Var.r("Call cancelled without message");
        if (th != null) {
            k1VarR = k1VarR.q(th);
        }
        k(k1VarR, false);
    }

    @Override // rb.g
    public final void b() {
        l(new h());
    }

    @Override // rb.g
    public final void c(int i10) {
        if (this.f20892d) {
            this.f20894f.c(i10);
        } else {
            l(new g(i10));
        }
    }

    @Override // rb.g
    public final void d(Object obj) {
        if (this.f20892d) {
            this.f20894f.d(obj);
        } else {
            l(new f(obj));
        }
    }

    @Override // rb.g
    public final void e(g.a aVar, rb.y0 y0Var) {
        rb.k1 k1Var;
        boolean z10;
        p6.n.u(this.f20893e == null, "already started");
        synchronized (this) {
            try {
                this.f20893e = (g.a) p6.n.o(aVar, "listener");
                k1Var = this.f20895g;
                z10 = this.f20892d;
                if (!z10) {
                    k kVar = new k(aVar);
                    this.f20897i = kVar;
                    aVar = kVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (k1Var != null) {
            this.f20890b.execute(new j(aVar, k1Var));
        } else if (z10) {
            this.f20894f.e(aVar, y0Var);
        } else {
            l(new d(aVar, y0Var));
        }
    }

    public final void k(rb.k1 k1Var, boolean z10) {
        boolean z11;
        g.a aVar;
        synchronized (this) {
            try {
                if (this.f20894f == null) {
                    q(f20888k);
                    aVar = this.f20893e;
                    this.f20895g = k1Var;
                    z11 = false;
                } else {
                    if (z10) {
                        return;
                    }
                    z11 = true;
                    aVar = null;
                }
                if (z11) {
                    l(new e(k1Var));
                } else {
                    if (aVar != null) {
                        this.f20890b.execute(new j(aVar, k1Var));
                    }
                    m();
                }
                j();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.f20892d) {
                    runnable.run();
                } else {
                    this.f20896h.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List r1 = r3.f20896h     // Catch: java.lang.Throwable -> L24
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L26
            r0 = 0
            r3.f20896h = r0     // Catch: java.lang.Throwable -> L24
            r0 = 1
            r3.f20892d = r0     // Catch: java.lang.Throwable -> L24
            tb.a0$k r0 = r3.f20897i     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L23
            java.util.concurrent.Executor r1 = r3.f20890b
            tb.a0$c r2 = new tb.a0$c
            r2.<init>(r0)
            r1.execute(r2)
        L23:
            return
        L24:
            r0 = move-exception
            goto L44
        L26:
            java.util.List r1 = r3.f20896h     // Catch: java.lang.Throwable -> L24
            r3.f20896h = r0     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            java.util.Iterator r0 = r1.iterator()
        L2f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L3f
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L2f
        L3f:
            r1.clear()
            r0 = r1
            goto L5
        L44:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.a0.m():void");
    }

    public final boolean n(rb.t tVar, rb.t tVar2) {
        if (tVar2 == null) {
            return true;
        }
        if (tVar == null) {
            return false;
        }
        return tVar.l(tVar2);
    }

    public final ScheduledFuture o(ScheduledExecutorService scheduledExecutorService, rb.t tVar) {
        rb.t tVarG = this.f20891c.g();
        if (tVar == null && tVarG == null) {
            return null;
        }
        long jQ = tVar != null ? tVar.q(TimeUnit.NANOSECONDS) : Long.MAX_VALUE;
        if (tVarG != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (tVarG.q(timeUnit) < jQ) {
                jQ = tVarG.q(timeUnit);
                Logger logger = f20887j;
                if (logger.isLoggable(Level.FINE)) {
                    Locale locale = Locale.US;
                    StringBuilder sb2 = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(jQ)));
                    if (tVar == null) {
                        sb2.append(" Explicit call timeout was not set.");
                    } else {
                        sb2.append(String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(tVar.q(timeUnit))));
                    }
                    logger.fine(sb2.toString());
                }
            }
        }
        long jAbs = Math.abs(jQ);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        long nanos = jAbs / timeUnit2.toNanos(1L);
        long jAbs2 = Math.abs(jQ) % timeUnit2.toNanos(1L);
        StringBuilder sb3 = new StringBuilder();
        String str = n(tVarG, tVar) ? "Context" : "CallOptions";
        if (jQ < 0) {
            sb3.append("ClientCall started after ");
            sb3.append(str);
            sb3.append(" deadline was exceeded. Deadline has been exceeded for ");
        } else {
            sb3.append("Deadline ");
            sb3.append(str);
            sb3.append(" will be exceeded in ");
        }
        sb3.append(nanos);
        sb3.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        sb3.append("s. ");
        return scheduledExecutorService.schedule(new b(sb3), jQ, TimeUnit.NANOSECONDS);
    }

    public final Runnable p(rb.g gVar) {
        synchronized (this) {
            try {
                if (this.f20894f != null) {
                    return null;
                }
                q((rb.g) p6.n.o(gVar, "call"));
                return new a(this.f20891c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void q(rb.g gVar) {
        rb.g gVar2 = this.f20894f;
        p6.n.x(gVar2 == null, "realCall already set to %s", gVar2);
        ScheduledFuture scheduledFuture = this.f20889a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f20894f = gVar;
    }

    public String toString() {
        return p6.h.b(this).d("realCall", this.f20894f).toString();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class i extends rb.g {
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

    public void j() {
    }
}
