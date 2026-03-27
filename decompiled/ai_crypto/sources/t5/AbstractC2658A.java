package t5;

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
import r5.AbstractC2591g;
import r5.C2603t;

/* JADX INFO: renamed from: t5.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2658A extends AbstractC2591g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Logger f23164j = Logger.getLogger(AbstractC2658A.class.getName());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AbstractC2591g f23165k = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f23166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f23167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r5.r f23168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f23169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AbstractC2591g.a f23170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AbstractC2591g f23171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r5.l0 f23172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f23173h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f23174i;

    /* JADX INFO: renamed from: t5.A$a */
    public class a extends AbstractRunnableC2709y {
        public a(r5.r rVar) {
            super(rVar);
        }

        @Override // t5.AbstractRunnableC2709y
        public void a() {
            AbstractC2658A.this.m();
        }
    }

    /* JADX INFO: renamed from: t5.A$b */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f23176a;

        public b(StringBuilder sb) {
            this.f23176a = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2658A.this.k(r5.l0.f22709i.q(this.f23176a.toString()), true);
        }
    }

    /* JADX INFO: renamed from: t5.A$c */
    public class c extends AbstractRunnableC2709y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f23178b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k kVar) {
            super(AbstractC2658A.this.f23168c);
            this.f23178b = kVar;
        }

        @Override // t5.AbstractRunnableC2709y
        public void a() {
            this.f23178b.g();
        }
    }

    /* JADX INFO: renamed from: t5.A$d */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC2591g.a f23180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r5.Z f23181b;

        public d(AbstractC2591g.a aVar, r5.Z z7) {
            this.f23180a = aVar;
            this.f23181b = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2658A.this.f23171f.e(this.f23180a, this.f23181b);
        }
    }

    /* JADX INFO: renamed from: t5.A$e */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r5.l0 f23183a;

        public e(r5.l0 l0Var) {
            this.f23183a = l0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2658A.this.f23171f.a(this.f23183a.n(), this.f23183a.l());
        }
    }

    /* JADX INFO: renamed from: t5.A$f */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f23185a;

        public f(Object obj) {
            this.f23185a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2658A.this.f23171f.d(this.f23185a);
        }
    }

    /* JADX INFO: renamed from: t5.A$g */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23187a;

        public g(int i7) {
            this.f23187a = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2658A.this.f23171f.c(this.f23187a);
        }
    }

    /* JADX INFO: renamed from: t5.A$h */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2658A.this.f23171f.b();
        }
    }

    /* JADX INFO: renamed from: t5.A$j */
    public final class j extends AbstractRunnableC2709y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2591g.a f23190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r5.l0 f23191c;

        public j(AbstractC2591g.a aVar, r5.l0 l0Var) {
            super(AbstractC2658A.this.f23168c);
            this.f23190b = aVar;
            this.f23191c = l0Var;
        }

        @Override // t5.AbstractRunnableC2709y
        public void a() {
            this.f23190b.a(this.f23191c, new r5.Z());
        }
    }

    /* JADX INFO: renamed from: t5.A$k */
    public static final class k extends AbstractC2591g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC2591g.a f23193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f23194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f23195c = new ArrayList();

        /* JADX INFO: renamed from: t5.A$k$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r5.Z f23196a;

            public a(r5.Z z7) {
                this.f23196a = z7;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f23193a.b(this.f23196a);
            }
        }

        /* JADX INFO: renamed from: t5.A$k$b */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f23198a;

            public b(Object obj) {
                this.f23198a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f23193a.c(this.f23198a);
            }
        }

        /* JADX INFO: renamed from: t5.A$k$c */
        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r5.l0 f23200a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r5.Z f23201b;

            public c(r5.l0 l0Var, r5.Z z7) {
                this.f23200a = l0Var;
                this.f23201b = z7;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f23193a.a(this.f23200a, this.f23201b);
            }
        }

        /* JADX INFO: renamed from: t5.A$k$d */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f23193a.d();
            }
        }

        public k(AbstractC2591g.a aVar) {
            this.f23193a = aVar;
        }

        @Override // r5.AbstractC2591g.a
        public void a(r5.l0 l0Var, r5.Z z7) {
            f(new c(l0Var, z7));
        }

        @Override // r5.AbstractC2591g.a
        public void b(r5.Z z7) {
            if (this.f23194b) {
                this.f23193a.b(z7);
            } else {
                f(new a(z7));
            }
        }

        @Override // r5.AbstractC2591g.a
        public void c(Object obj) {
            if (this.f23194b) {
                this.f23193a.c(obj);
            } else {
                f(new b(obj));
            }
        }

        @Override // r5.AbstractC2591g.a
        public void d() {
            if (this.f23194b) {
                this.f23193a.d();
            } else {
                f(new d());
            }
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                try {
                    if (this.f23194b) {
                        runnable.run();
                    } else {
                        this.f23195c.add(runnable);
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
                        if (this.f23195c.isEmpty()) {
                            this.f23195c = null;
                            this.f23194b = true;
                            return;
                        } else {
                            list = this.f23195c;
                            this.f23195c = arrayList;
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

    public AbstractC2658A(Executor executor, ScheduledExecutorService scheduledExecutorService, C2603t c2603t) {
        this.f23167b = (Executor) H2.m.o(executor, "callExecutor");
        H2.m.o(scheduledExecutorService, "scheduler");
        this.f23168c = r5.r.e();
        this.f23166a = o(scheduledExecutorService, c2603t);
    }

    @Override // r5.AbstractC2591g
    public final void a(String str, Throwable th) {
        r5.l0 l0Var = r5.l0.f22706f;
        r5.l0 l0VarQ = str != null ? l0Var.q(str) : l0Var.q("Call cancelled without message");
        if (th != null) {
            l0VarQ = l0VarQ.p(th);
        }
        k(l0VarQ, false);
    }

    @Override // r5.AbstractC2591g
    public final void b() {
        l(new h());
    }

    @Override // r5.AbstractC2591g
    public final void c(int i7) {
        if (this.f23169d) {
            this.f23171f.c(i7);
        } else {
            l(new g(i7));
        }
    }

    @Override // r5.AbstractC2591g
    public final void d(Object obj) {
        if (this.f23169d) {
            this.f23171f.d(obj);
        } else {
            l(new f(obj));
        }
    }

    @Override // r5.AbstractC2591g
    public final void e(AbstractC2591g.a aVar, r5.Z z7) {
        r5.l0 l0Var;
        boolean z8;
        H2.m.u(this.f23170e == null, "already started");
        synchronized (this) {
            try {
                this.f23170e = (AbstractC2591g.a) H2.m.o(aVar, "listener");
                l0Var = this.f23172g;
                z8 = this.f23169d;
                if (!z8) {
                    k kVar = new k(aVar);
                    this.f23174i = kVar;
                    aVar = kVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (l0Var != null) {
            this.f23167b.execute(new j(aVar, l0Var));
        } else if (z8) {
            this.f23171f.e(aVar, z7);
        } else {
            l(new d(aVar, z7));
        }
    }

    public final void k(r5.l0 l0Var, boolean z7) {
        boolean z8;
        AbstractC2591g.a aVar;
        synchronized (this) {
            try {
                if (this.f23171f == null) {
                    q(f23165k);
                    aVar = this.f23170e;
                    this.f23172g = l0Var;
                    z8 = false;
                } else {
                    if (z7) {
                        return;
                    }
                    z8 = true;
                    aVar = null;
                }
                if (z8) {
                    l(new e(l0Var));
                } else {
                    if (aVar != null) {
                        this.f23167b.execute(new j(aVar, l0Var));
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
                if (this.f23169d) {
                    runnable.run();
                } else {
                    this.f23173h.add(runnable);
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
            java.util.List r1 = r3.f23173h     // Catch: java.lang.Throwable -> L24
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L26
            r0 = 0
            r3.f23173h = r0     // Catch: java.lang.Throwable -> L24
            r0 = 1
            r3.f23169d = r0     // Catch: java.lang.Throwable -> L24
            t5.A$k r0 = r3.f23174i     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L23
            java.util.concurrent.Executor r1 = r3.f23167b
            t5.A$c r2 = new t5.A$c
            r2.<init>(r0)
            r1.execute(r2)
        L23:
            return
        L24:
            r0 = move-exception
            goto L44
        L26:
            java.util.List r1 = r3.f23173h     // Catch: java.lang.Throwable -> L24
            r3.f23173h = r0     // Catch: java.lang.Throwable -> L24
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
        throw new UnsupportedOperationException("Method not decompiled: t5.AbstractC2658A.m():void");
    }

    public final boolean n(C2603t c2603t, C2603t c2603t2) {
        if (c2603t2 == null) {
            return true;
        }
        if (c2603t == null) {
            return false;
        }
        return c2603t.k(c2603t2);
    }

    public final ScheduledFuture o(ScheduledExecutorService scheduledExecutorService, C2603t c2603t) {
        C2603t c2603tG = this.f23168c.g();
        if (c2603t == null && c2603tG == null) {
            return null;
        }
        long jN = c2603t != null ? c2603t.n(TimeUnit.NANOSECONDS) : Long.MAX_VALUE;
        if (c2603tG != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (c2603tG.n(timeUnit) < jN) {
                jN = c2603tG.n(timeUnit);
                Logger logger = f23164j;
                if (logger.isLoggable(Level.FINE)) {
                    Locale locale = Locale.US;
                    StringBuilder sb = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(jN)));
                    if (c2603t == null) {
                        sb.append(" Explicit call timeout was not set.");
                    } else {
                        sb.append(String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(c2603t.n(timeUnit))));
                    }
                    logger.fine(sb.toString());
                }
            }
        }
        long jAbs = Math.abs(jN);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        long nanos = jAbs / timeUnit2.toNanos(1L);
        long jAbs2 = Math.abs(jN) % timeUnit2.toNanos(1L);
        StringBuilder sb2 = new StringBuilder();
        String str = n(c2603tG, c2603t) ? "Context" : "CallOptions";
        if (jN < 0) {
            sb2.append("ClientCall started after ");
            sb2.append(str);
            sb2.append(" deadline was exceeded. Deadline has been exceeded for ");
        } else {
            sb2.append("Deadline ");
            sb2.append(str);
            sb2.append(" will be exceeded in ");
        }
        sb2.append(nanos);
        sb2.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        sb2.append("s. ");
        return scheduledExecutorService.schedule(new b(sb2), jN, TimeUnit.NANOSECONDS);
    }

    public final Runnable p(AbstractC2591g abstractC2591g) {
        synchronized (this) {
            try {
                if (this.f23171f != null) {
                    return null;
                }
                q((AbstractC2591g) H2.m.o(abstractC2591g, "call"));
                return new a(this.f23168c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void q(AbstractC2591g abstractC2591g) {
        AbstractC2591g abstractC2591g2 = this.f23171f;
        H2.m.w(abstractC2591g2 == null, "realCall already set to %s", abstractC2591g2);
        ScheduledFuture scheduledFuture = this.f23166a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f23171f = abstractC2591g;
    }

    public String toString() {
        return H2.g.b(this).d("realCall", this.f23171f).toString();
    }

    /* JADX INFO: renamed from: t5.A$i */
    public class i extends AbstractC2591g {
        @Override // r5.AbstractC2591g
        public void b() {
        }

        @Override // r5.AbstractC2591g
        public void c(int i7) {
        }

        @Override // r5.AbstractC2591g
        public void d(Object obj) {
        }

        @Override // r5.AbstractC2591g
        public void a(String str, Throwable th) {
        }

        @Override // r5.AbstractC2591g
        public void e(AbstractC2591g.a aVar, r5.Z z7) {
        }
    }

    public void j() {
    }
}
