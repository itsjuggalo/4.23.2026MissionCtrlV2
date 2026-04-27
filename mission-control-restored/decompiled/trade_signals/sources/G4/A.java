package G4;

import F4.AbstractC0493g;
import F4.C0505t;
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
import v2.AbstractC2842h;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A extends AbstractC0493g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Logger f2201j = Logger.getLogger(A.class.getName());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AbstractC0493g f2202k = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f2203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f2204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final F4.r f2205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f2206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AbstractC0493g.a f2207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AbstractC0493g f2208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public F4.j0 f2209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f2210h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f2211i;

    public class a extends AbstractRunnableC0562y {
        public a(F4.r rVar) {
            super(rVar);
        }

        @Override // G4.AbstractRunnableC0562y
        public void a() {
            A.this.m();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f2213a;

        public b(StringBuilder sb) {
            this.f2213a = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.k(F4.j0.f1801i.r(this.f2213a.toString()), true);
        }
    }

    public class c extends AbstractRunnableC0562y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f2215b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k kVar) {
            super(A.this.f2205c);
            this.f2215b = kVar;
        }

        @Override // G4.AbstractRunnableC0562y
        public void a() {
            this.f2215b.g();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0493g.a f2217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ F4.X f2218b;

        public d(AbstractC0493g.a aVar, F4.X x8) {
            this.f2217a = aVar;
            this.f2218b = x8;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.f2208f.e(this.f2217a, this.f2218b);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ F4.j0 f2220a;

        public e(F4.j0 j0Var) {
            this.f2220a = j0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.f2208f.a(this.f2220a.o(), this.f2220a.m());
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f2222a;

        public f(Object obj) {
            this.f2222a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.f2208f.d(this.f2222a);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2224a;

        public g(int i8) {
            this.f2224a = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.f2208f.c(this.f2224a);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.f2208f.b();
        }
    }

    public final class j extends AbstractRunnableC0562y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC0493g.a f2227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final F4.j0 f2228c;

        public j(AbstractC0493g.a aVar, F4.j0 j0Var) {
            super(A.this.f2205c);
            this.f2227b = aVar;
            this.f2228c = j0Var;
        }

        @Override // G4.AbstractRunnableC0562y
        public void a() {
            this.f2227b.a(this.f2228c, new F4.X());
        }
    }

    public static final class k extends AbstractC0493g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0493g.a f2230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f2231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f2232c = new ArrayList();

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ F4.X f2233a;

            public a(F4.X x8) {
                this.f2233a = x8;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f2230a.b(this.f2233a);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f2235a;

            public b(Object obj) {
                this.f2235a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f2230a.c(this.f2235a);
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ F4.j0 f2237a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ F4.X f2238b;

            public c(F4.j0 j0Var, F4.X x8) {
                this.f2237a = j0Var;
                this.f2238b = x8;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f2230a.a(this.f2237a, this.f2238b);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f2230a.d();
            }
        }

        public k(AbstractC0493g.a aVar) {
            this.f2230a = aVar;
        }

        @Override // F4.AbstractC0493g.a
        public void a(F4.j0 j0Var, F4.X x8) {
            f(new c(j0Var, x8));
        }

        @Override // F4.AbstractC0493g.a
        public void b(F4.X x8) {
            if (this.f2231b) {
                this.f2230a.b(x8);
            } else {
                f(new a(x8));
            }
        }

        @Override // F4.AbstractC0493g.a
        public void c(Object obj) {
            if (this.f2231b) {
                this.f2230a.c(obj);
            } else {
                f(new b(obj));
            }
        }

        @Override // F4.AbstractC0493g.a
        public void d() {
            if (this.f2231b) {
                this.f2230a.d();
            } else {
                f(new d());
            }
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                try {
                    if (this.f2231b) {
                        runnable.run();
                    } else {
                        this.f2232c.add(runnable);
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
                        if (this.f2232c.isEmpty()) {
                            this.f2232c = null;
                            this.f2231b = true;
                            return;
                        } else {
                            list = this.f2232c;
                            this.f2232c = arrayList;
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

    public A(Executor executor, ScheduledExecutorService scheduledExecutorService, C0505t c0505t) {
        this.f2204b = (Executor) AbstractC2848n.o(executor, "callExecutor");
        AbstractC2848n.o(scheduledExecutorService, "scheduler");
        this.f2205c = F4.r.e();
        this.f2203a = o(scheduledExecutorService, c0505t);
    }

    @Override // F4.AbstractC0493g
    public final void a(String str, Throwable th) {
        F4.j0 j0Var = F4.j0.f1798f;
        if (str == null) {
            str = "Call cancelled without message";
        }
        F4.j0 j0VarR = j0Var.r(str);
        if (th != null) {
            j0VarR = j0VarR.q(th);
        }
        k(j0VarR, false);
    }

    @Override // F4.AbstractC0493g
    public final void b() {
        l(new h());
    }

    @Override // F4.AbstractC0493g
    public final void c(int i8) {
        if (this.f2206d) {
            this.f2208f.c(i8);
        } else {
            l(new g(i8));
        }
    }

    @Override // F4.AbstractC0493g
    public final void d(Object obj) {
        if (this.f2206d) {
            this.f2208f.d(obj);
        } else {
            l(new f(obj));
        }
    }

    @Override // F4.AbstractC0493g
    public final void e(AbstractC0493g.a aVar, F4.X x8) {
        F4.j0 j0Var;
        boolean z7;
        AbstractC2848n.u(this.f2207e == null, "already started");
        synchronized (this) {
            try {
                this.f2207e = (AbstractC0493g.a) AbstractC2848n.o(aVar, "listener");
                j0Var = this.f2209g;
                z7 = this.f2206d;
                if (!z7) {
                    k kVar = new k(aVar);
                    this.f2211i = kVar;
                    aVar = kVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (j0Var != null) {
            this.f2204b.execute(new j(aVar, j0Var));
        } else if (z7) {
            this.f2208f.e(aVar, x8);
        } else {
            l(new d(aVar, x8));
        }
    }

    public final void k(F4.j0 j0Var, boolean z7) {
        boolean z8;
        AbstractC0493g.a aVar;
        synchronized (this) {
            try {
                if (this.f2208f == null) {
                    q(f2202k);
                    aVar = this.f2207e;
                    this.f2209g = j0Var;
                    z8 = false;
                } else {
                    if (z7) {
                        return;
                    }
                    z8 = true;
                    aVar = null;
                }
                if (z8) {
                    l(new e(j0Var));
                } else {
                    if (aVar != null) {
                        this.f2204b.execute(new j(aVar, j0Var));
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
                if (this.f2206d) {
                    runnable.run();
                } else {
                    this.f2210h.add(runnable);
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
            java.util.List r1 = r3.f2210h     // Catch: java.lang.Throwable -> L24
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L26
            r0 = 0
            r3.f2210h = r0     // Catch: java.lang.Throwable -> L24
            r0 = 1
            r3.f2206d = r0     // Catch: java.lang.Throwable -> L24
            G4.A$k r0 = r3.f2211i     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L23
            java.util.concurrent.Executor r1 = r3.f2204b
            G4.A$c r2 = new G4.A$c
            r2.<init>(r0)
            r1.execute(r2)
        L23:
            return
        L24:
            r0 = move-exception
            goto L44
        L26:
            java.util.List r1 = r3.f2210h     // Catch: java.lang.Throwable -> L24
            r3.f2210h = r0     // Catch: java.lang.Throwable -> L24
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
        throw new UnsupportedOperationException("Method not decompiled: G4.A.m():void");
    }

    public final boolean n(C0505t c0505t, C0505t c0505t2) {
        if (c0505t2 == null) {
            return true;
        }
        if (c0505t == null) {
            return false;
        }
        return c0505t.m(c0505t2);
    }

    public final ScheduledFuture o(ScheduledExecutorService scheduledExecutorService, C0505t c0505t) {
        String str;
        C0505t c0505tG = this.f2205c.g();
        if (c0505t == null && c0505tG == null) {
            return null;
        }
        long jR = c0505t != null ? c0505t.r(TimeUnit.NANOSECONDS) : Long.MAX_VALUE;
        if (c0505tG != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (c0505tG.r(timeUnit) < jR) {
                jR = c0505tG.r(timeUnit);
                Logger logger = f2201j;
                if (logger.isLoggable(Level.FINE)) {
                    Locale locale = Locale.US;
                    StringBuilder sb = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(jR)));
                    sb.append(c0505t == null ? " Explicit call timeout was not set." : String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(c0505t.r(timeUnit))));
                    logger.fine(sb.toString());
                }
            }
        }
        long jAbs = Math.abs(jR);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        long nanos = jAbs / timeUnit2.toNanos(1L);
        long jAbs2 = Math.abs(jR) % timeUnit2.toNanos(1L);
        StringBuilder sb2 = new StringBuilder();
        String str2 = n(c0505tG, c0505t) ? "Context" : "CallOptions";
        if (jR < 0) {
            sb2.append("ClientCall started after ");
            sb2.append(str2);
            str = " deadline was exceeded. Deadline has been exceeded for ";
        } else {
            sb2.append("Deadline ");
            sb2.append(str2);
            str = " will be exceeded in ";
        }
        sb2.append(str);
        sb2.append(nanos);
        sb2.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        sb2.append("s. ");
        return scheduledExecutorService.schedule(new b(sb2), jR, TimeUnit.NANOSECONDS);
    }

    public final Runnable p(AbstractC0493g abstractC0493g) {
        synchronized (this) {
            try {
                if (this.f2208f != null) {
                    return null;
                }
                q((AbstractC0493g) AbstractC2848n.o(abstractC0493g, "call"));
                return new a(this.f2205c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void q(AbstractC0493g abstractC0493g) {
        AbstractC0493g abstractC0493g2 = this.f2208f;
        AbstractC2848n.x(abstractC0493g2 == null, "realCall already set to %s", abstractC0493g2);
        ScheduledFuture scheduledFuture = this.f2203a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f2208f = abstractC0493g;
    }

    public String toString() {
        return AbstractC2842h.b(this).d("realCall", this.f2208f).toString();
    }

    public class i extends AbstractC0493g {
        @Override // F4.AbstractC0493g
        public void b() {
        }

        @Override // F4.AbstractC0493g
        public void c(int i8) {
        }

        @Override // F4.AbstractC0493g
        public void d(Object obj) {
        }

        @Override // F4.AbstractC0493g
        public void a(String str, Throwable th) {
        }

        @Override // F4.AbstractC0493g
        public void e(AbstractC0493g.a aVar, F4.X x8) {
        }
    }

    public void j() {
    }
}
