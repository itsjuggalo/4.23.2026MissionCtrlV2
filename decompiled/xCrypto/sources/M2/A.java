package M2;

import K2.AbstractC0359g;
import K2.C0353a;
import K2.C0371t;
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

/* JADX INFO: loaded from: classes3.dex */
public abstract class A extends AbstractC0359g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Logger f1607j = Logger.getLogger(A.class.getName());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AbstractC0359g f1608k = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f1609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f1610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final K2.r f1611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f1612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AbstractC0359g.a f1613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AbstractC0359g f1614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public K2.l0 f1615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f1616h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f1617i;

    public class a extends AbstractRunnableC0454y {
        public a(K2.r rVar) {
            super(rVar);
        }

        @Override // M2.AbstractRunnableC0454y
        public void a() {
            A.this.h();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f1619a;

        public b(StringBuilder sb) {
            this.f1619a = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.f(K2.l0.f1219i.q(this.f1619a.toString()), true);
        }
    }

    public class c extends AbstractRunnableC0454y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f1621b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l lVar) {
            super(A.this.f1611c);
            this.f1621b = lVar;
        }

        @Override // M2.AbstractRunnableC0454y
        public void a() {
            this.f1621b.c();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0359g.a f1623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ K2.Z f1624b;

        public d(AbstractC0359g.a aVar, K2.Z z4) {
            this.f1623a = aVar;
            this.f1624b = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.f1614f.start(this.f1623a, this.f1624b);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ K2.l0 f1626a;

        public e(K2.l0 l0Var) {
            this.f1626a = l0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.f1614f.cancel(this.f1626a.n(), this.f1626a.l());
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f1628a;

        public f(Object obj) {
            this.f1628a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.f1614f.sendMessage(this.f1628a);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1630a;

        public g(boolean z4) {
            this.f1630a = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.f1614f.setMessageCompression(this.f1630a);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1632a;

        public h(int i4) {
            this.f1632a = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.f1614f.request(this.f1632a);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            A.this.f1614f.halfClose();
        }
    }

    public final class k extends AbstractRunnableC0454y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC0359g.a f1635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final K2.l0 f1636c;

        public k(AbstractC0359g.a aVar, K2.l0 l0Var) {
            super(A.this.f1611c);
            this.f1635b = aVar;
            this.f1636c = l0Var;
        }

        @Override // M2.AbstractRunnableC0454y
        public void a() {
            this.f1635b.onClose(this.f1636c, new K2.Z());
        }
    }

    public static final class l extends AbstractC0359g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0359g.a f1638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f1639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f1640c = new ArrayList();

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ K2.Z f1641a;

            public a(K2.Z z4) {
                this.f1641a = z4;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.f1638a.onHeaders(this.f1641a);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f1643a;

            public b(Object obj) {
                this.f1643a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.f1638a.onMessage(this.f1643a);
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ K2.l0 f1645a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ K2.Z f1646b;

            public c(K2.l0 l0Var, K2.Z z4) {
                this.f1645a = l0Var;
                this.f1646b = z4;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.f1638a.onClose(this.f1645a, this.f1646b);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.f1638a.onReady();
            }
        }

        public l(AbstractC0359g.a aVar) {
            this.f1638a = aVar;
        }

        public final void b(Runnable runnable) {
            synchronized (this) {
                try {
                    if (this.f1639b) {
                        runnable.run();
                    } else {
                        this.f1640c.add(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c() {
            List list;
            List arrayList = new ArrayList();
            while (true) {
                synchronized (this) {
                    try {
                        if (this.f1640c.isEmpty()) {
                            this.f1640c = null;
                            this.f1639b = true;
                            return;
                        } else {
                            list = this.f1640c;
                            this.f1640c = arrayList;
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

        @Override // K2.AbstractC0359g.a
        public void onClose(K2.l0 l0Var, K2.Z z4) {
            b(new c(l0Var, z4));
        }

        @Override // K2.AbstractC0359g.a
        public void onHeaders(K2.Z z4) {
            if (this.f1639b) {
                this.f1638a.onHeaders(z4);
            } else {
                b(new a(z4));
            }
        }

        @Override // K2.AbstractC0359g.a
        public void onMessage(Object obj) {
            if (this.f1639b) {
                this.f1638a.onMessage(obj);
            } else {
                b(new b(obj));
            }
        }

        @Override // K2.AbstractC0359g.a
        public void onReady() {
            if (this.f1639b) {
                this.f1638a.onReady();
            } else {
                b(new d());
            }
        }
    }

    public A(Executor executor, ScheduledExecutorService scheduledExecutorService, C0371t c0371t) {
        this.f1610b = (Executor) Z1.m.o(executor, "callExecutor");
        Z1.m.o(scheduledExecutorService, "scheduler");
        this.f1611c = K2.r.e();
        this.f1609a = j(scheduledExecutorService, c0371t);
    }

    @Override // K2.AbstractC0359g
    public final void cancel(String str, Throwable th) {
        K2.l0 l0Var = K2.l0.f1216f;
        K2.l0 l0VarQ = str != null ? l0Var.q(str) : l0Var.q("Call cancelled without message");
        if (th != null) {
            l0VarQ = l0VarQ.p(th);
        }
        f(l0VarQ, false);
    }

    public final void f(K2.l0 l0Var, boolean z4) {
        boolean z5;
        AbstractC0359g.a aVar;
        synchronized (this) {
            try {
                if (this.f1614f == null) {
                    l(f1608k);
                    aVar = this.f1613e;
                    this.f1615g = l0Var;
                    z5 = false;
                } else {
                    if (z4) {
                        return;
                    }
                    z5 = true;
                    aVar = null;
                }
                if (z5) {
                    g(new e(l0Var));
                } else {
                    if (aVar != null) {
                        this.f1610b.execute(new k(aVar, l0Var));
                    }
                    h();
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.f1612d) {
                    runnable.run();
                } else {
                    this.f1616h.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // K2.AbstractC0359g
    public final C0353a getAttributes() {
        AbstractC0359g abstractC0359g;
        synchronized (this) {
            abstractC0359g = this.f1614f;
        }
        return abstractC0359g != null ? abstractC0359g.getAttributes() : C0353a.f1111c;
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
    public final void h() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List r1 = r3.f1616h     // Catch: java.lang.Throwable -> L24
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L26
            r0 = 0
            r3.f1616h = r0     // Catch: java.lang.Throwable -> L24
            r0 = 1
            r3.f1612d = r0     // Catch: java.lang.Throwable -> L24
            M2.A$l r0 = r3.f1617i     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L23
            java.util.concurrent.Executor r1 = r3.f1610b
            M2.A$c r2 = new M2.A$c
            r2.<init>(r0)
            r1.execute(r2)
        L23:
            return
        L24:
            r0 = move-exception
            goto L44
        L26:
            java.util.List r1 = r3.f1616h     // Catch: java.lang.Throwable -> L24
            r3.f1616h = r0     // Catch: java.lang.Throwable -> L24
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
        throw new UnsupportedOperationException("Method not decompiled: M2.A.h():void");
    }

    @Override // K2.AbstractC0359g
    public final void halfClose() {
        g(new i());
    }

    public final boolean i(C0371t c0371t, C0371t c0371t2) {
        if (c0371t2 == null) {
            return true;
        }
        if (c0371t == null) {
            return false;
        }
        return c0371t.l(c0371t2);
    }

    @Override // K2.AbstractC0359g
    public final boolean isReady() {
        if (this.f1612d) {
            return this.f1614f.isReady();
        }
        return false;
    }

    public final ScheduledFuture j(ScheduledExecutorService scheduledExecutorService, C0371t c0371t) {
        C0371t c0371tG = this.f1611c.g();
        if (c0371t == null && c0371tG == null) {
            return null;
        }
        long jO = c0371t != null ? c0371t.o(TimeUnit.NANOSECONDS) : Long.MAX_VALUE;
        if (c0371tG != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (c0371tG.o(timeUnit) < jO) {
                jO = c0371tG.o(timeUnit);
                Logger logger = f1607j;
                if (logger.isLoggable(Level.FINE)) {
                    Locale locale = Locale.US;
                    StringBuilder sb = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(jO)));
                    if (c0371t == null) {
                        sb.append(" Explicit call timeout was not set.");
                    } else {
                        sb.append(String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(c0371t.o(timeUnit))));
                    }
                    logger.fine(sb.toString());
                }
            }
        }
        long jAbs = Math.abs(jO);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        long nanos = jAbs / timeUnit2.toNanos(1L);
        long jAbs2 = Math.abs(jO) % timeUnit2.toNanos(1L);
        StringBuilder sb2 = new StringBuilder();
        String str = i(c0371tG, c0371t) ? "Context" : "CallOptions";
        if (jO < 0) {
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
        return scheduledExecutorService.schedule(new b(sb2), jO, TimeUnit.NANOSECONDS);
    }

    public final Runnable k(AbstractC0359g abstractC0359g) {
        synchronized (this) {
            try {
                if (this.f1614f != null) {
                    return null;
                }
                l((AbstractC0359g) Z1.m.o(abstractC0359g, "call"));
                return new a(this.f1611c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(AbstractC0359g abstractC0359g) {
        AbstractC0359g abstractC0359g2 = this.f1614f;
        Z1.m.w(abstractC0359g2 == null, "realCall already set to %s", abstractC0359g2);
        ScheduledFuture scheduledFuture = this.f1609a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f1614f = abstractC0359g;
    }

    @Override // K2.AbstractC0359g
    public final void request(int i4) {
        if (this.f1612d) {
            this.f1614f.request(i4);
        } else {
            g(new h(i4));
        }
    }

    @Override // K2.AbstractC0359g
    public final void sendMessage(Object obj) {
        if (this.f1612d) {
            this.f1614f.sendMessage(obj);
        } else {
            g(new f(obj));
        }
    }

    @Override // K2.AbstractC0359g
    public final void setMessageCompression(boolean z4) {
        if (this.f1612d) {
            this.f1614f.setMessageCompression(z4);
        } else {
            g(new g(z4));
        }
    }

    @Override // K2.AbstractC0359g
    public final void start(AbstractC0359g.a aVar, K2.Z z4) {
        K2.l0 l0Var;
        boolean z5;
        Z1.m.u(this.f1613e == null, "already started");
        synchronized (this) {
            try {
                this.f1613e = (AbstractC0359g.a) Z1.m.o(aVar, "listener");
                l0Var = this.f1615g;
                z5 = this.f1612d;
                if (!z5) {
                    l lVar = new l(aVar);
                    this.f1617i = lVar;
                    aVar = lVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (l0Var != null) {
            this.f1610b.execute(new k(aVar, l0Var));
        } else if (z5) {
            this.f1614f.start(aVar, z4);
        } else {
            g(new d(aVar, z4));
        }
    }

    public String toString() {
        return Z1.g.b(this).d("realCall", this.f1614f).toString();
    }

    public class j extends AbstractC0359g {
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

    public void e() {
    }
}
