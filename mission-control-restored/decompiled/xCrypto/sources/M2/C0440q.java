package M2;

import K2.AbstractC0359g;
import K2.AbstractC0363k;
import K2.AbstractC0370s;
import K2.C0353a;
import K2.C0355c;
import K2.C0367o;
import K2.C0371t;
import K2.C0373v;
import K2.InterfaceC0364l;
import K2.InterfaceC0366n;
import K2.Z;
import K2.a0;
import K2.l0;
import K2.r;
import M2.C0429k0;
import M2.InterfaceC0443s;
import M2.Q0;
import e2.AbstractC1234f;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: M2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0440q extends AbstractC0359g {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Logger f2554t = Logger.getLogger(C0440q.class.getName());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final byte[] f2555u = "gzip".getBytes(Charset.forName("US-ASCII"));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final double f2556v = TimeUnit.SECONDS.toNanos(1) * 1.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.a0 f2557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final U2.d f2558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f2559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0434n f2561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final K2.r f2562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile ScheduledFuture f2563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public C0355c f2565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f2566j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f2567k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2568l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2569m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f2570n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ScheduledExecutorService f2572p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2573q;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f f2571o = new f();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public C0373v f2574r = C0373v.c();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public C0367o f2575s = C0367o.a();

    /* JADX INFO: renamed from: M2.q$b */
    public class b extends AbstractRunnableC0454y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC0359g.a f2576b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbstractC0359g.a aVar) {
            super(C0440q.this.f2562f);
            this.f2576b = aVar;
        }

        @Override // M2.AbstractRunnableC0454y
        public void a() {
            C0440q c0440q = C0440q.this;
            c0440q.o(this.f2576b, AbstractC0370s.a(c0440q.f2562f), new K2.Z());
        }
    }

    /* JADX INFO: renamed from: M2.q$c */
    public class c extends AbstractRunnableC0454y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC0359g.a f2578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f2579c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbstractC0359g.a aVar, String str) {
            super(C0440q.this.f2562f);
            this.f2578b = aVar;
            this.f2579c = str;
        }

        @Override // M2.AbstractRunnableC0454y
        public void a() {
            C0440q.this.o(this.f2578b, K2.l0.f1229s.q(String.format("Unable to find compressor by name %s", this.f2579c)), new K2.Z());
        }
    }

    /* JADX INFO: renamed from: M2.q$d */
    public class d implements InterfaceC0443s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0359g.a f2581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public K2.l0 f2582b;

        /* JADX INFO: renamed from: M2.q$d$a */
        public final class a extends AbstractRunnableC0454y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ U2.b f2584b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ K2.Z f2585c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(U2.b bVar, K2.Z z4) {
                super(C0440q.this.f2562f);
                this.f2584b = bVar;
                this.f2585c = z4;
            }

            @Override // M2.AbstractRunnableC0454y
            public void a() {
                U2.e eVarH = U2.c.h("ClientCall$Listener.headersRead");
                try {
                    U2.c.a(C0440q.this.f2558b);
                    U2.c.e(this.f2584b);
                    b();
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } catch (Throwable th) {
                    if (eVarH != null) {
                        try {
                            eVarH.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }

            public final void b() {
                if (d.this.f2582b != null) {
                    return;
                }
                try {
                    d.this.f2581a.onHeaders(this.f2585c);
                } catch (Throwable th) {
                    d.this.i(K2.l0.f1216f.p(th).q("Failed to read headers"));
                }
            }
        }

        /* JADX INFO: renamed from: M2.q$d$b */
        public final class b extends AbstractRunnableC0454y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ U2.b f2587b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Q0.a f2588c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(U2.b bVar, Q0.a aVar) {
                super(C0440q.this.f2562f);
                this.f2587b = bVar;
                this.f2588c = aVar;
            }

            private void b() {
                if (d.this.f2582b != null) {
                    S.d(this.f2588c);
                    return;
                }
                while (true) {
                    try {
                        InputStream next = this.f2588c.next();
                        if (next == null) {
                            return;
                        }
                        try {
                            d.this.f2581a.onMessage(C0440q.this.f2557a.i(next));
                            next.close();
                        } catch (Throwable th) {
                            S.e(next);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        S.d(this.f2588c);
                        d.this.i(K2.l0.f1216f.p(th2).q("Failed to read message."));
                        return;
                    }
                }
            }

            @Override // M2.AbstractRunnableC0454y
            public void a() {
                U2.e eVarH = U2.c.h("ClientCall$Listener.messagesAvailable");
                try {
                    U2.c.a(C0440q.this.f2558b);
                    U2.c.e(this.f2587b);
                    b();
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } catch (Throwable th) {
                    if (eVarH != null) {
                        try {
                            eVarH.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: M2.q$d$c */
        public final class c extends AbstractRunnableC0454y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ U2.b f2590b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ K2.l0 f2591c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ K2.Z f2592d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(U2.b bVar, K2.l0 l0Var, K2.Z z4) {
                super(C0440q.this.f2562f);
                this.f2590b = bVar;
                this.f2591c = l0Var;
                this.f2592d = z4;
            }

            private void b() {
                K2.l0 l0Var = this.f2591c;
                K2.Z z4 = this.f2592d;
                if (d.this.f2582b != null) {
                    l0Var = d.this.f2582b;
                    z4 = new K2.Z();
                }
                C0440q.this.f2567k = true;
                try {
                    d dVar = d.this;
                    C0440q.this.o(dVar.f2581a, l0Var, z4);
                } finally {
                    C0440q.this.v();
                    C0440q.this.f2561e.a(l0Var.o());
                }
            }

            @Override // M2.AbstractRunnableC0454y
            public void a() {
                U2.e eVarH = U2.c.h("ClientCall$Listener.onClose");
                try {
                    U2.c.a(C0440q.this.f2558b);
                    U2.c.e(this.f2590b);
                    b();
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } catch (Throwable th) {
                    if (eVarH != null) {
                        try {
                            eVarH.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: M2.q$d$d, reason: collision with other inner class name */
        public final class C0046d extends AbstractRunnableC0454y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ U2.b f2594b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0046d(U2.b bVar) {
                super(C0440q.this.f2562f);
                this.f2594b = bVar;
            }

            private void b() {
                if (d.this.f2582b != null) {
                    return;
                }
                try {
                    d.this.f2581a.onReady();
                } catch (Throwable th) {
                    d.this.i(K2.l0.f1216f.p(th).q("Failed to call onReady."));
                }
            }

            @Override // M2.AbstractRunnableC0454y
            public void a() {
                U2.e eVarH = U2.c.h("ClientCall$Listener.onReady");
                try {
                    U2.c.a(C0440q.this.f2558b);
                    U2.c.e(this.f2594b);
                    b();
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } catch (Throwable th) {
                    if (eVarH != null) {
                        try {
                            eVarH.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }

        public d(AbstractC0359g.a aVar) {
            this.f2581a = (AbstractC0359g.a) Z1.m.o(aVar, "observer");
        }

        @Override // M2.Q0
        public void a(Q0.a aVar) {
            U2.e eVarH = U2.c.h("ClientStreamListener.messagesAvailable");
            try {
                U2.c.a(C0440q.this.f2558b);
                C0440q.this.f2559c.execute(new b(U2.c.f(), aVar));
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // M2.InterfaceC0443s
        public void b(K2.l0 l0Var, InterfaceC0443s.a aVar, K2.Z z4) {
            U2.e eVarH = U2.c.h("ClientStreamListener.closed");
            try {
                U2.c.a(C0440q.this.f2558b);
                h(l0Var, aVar, z4);
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // M2.Q0
        public void c() {
            if (C0440q.this.f2557a.e().a()) {
                return;
            }
            U2.e eVarH = U2.c.h("ClientStreamListener.onReady");
            try {
                U2.c.a(C0440q.this.f2558b);
                C0440q.this.f2559c.execute(new C0046d(U2.c.f()));
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // M2.InterfaceC0443s
        public void d(K2.Z z4) {
            U2.e eVarH = U2.c.h("ClientStreamListener.headersRead");
            try {
                U2.c.a(C0440q.this.f2558b);
                C0440q.this.f2559c.execute(new a(U2.c.f(), z4));
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public final void h(K2.l0 l0Var, InterfaceC0443s.a aVar, K2.Z z4) {
            C0371t c0371tP = C0440q.this.p();
            if (l0Var.m() == l0.b.CANCELLED && c0371tP != null && c0371tP.m()) {
                Y y4 = new Y();
                C0440q.this.f2566j.n(y4);
                l0Var = K2.l0.f1219i.e("ClientCall was cancelled at or after deadline. " + y4);
                z4 = new K2.Z();
            }
            C0440q.this.f2559c.execute(new c(U2.c.f(), l0Var, z4));
        }

        public final void i(K2.l0 l0Var) {
            this.f2582b = l0Var;
            C0440q.this.f2566j.c(l0Var);
        }
    }

    /* JADX INFO: renamed from: M2.q$e */
    public interface e {
        r a(K2.a0 a0Var, C0355c c0355c, K2.Z z4, K2.r rVar);
    }

    /* JADX INFO: renamed from: M2.q$f */
    public final class f implements r.a {
        public f() {
        }
    }

    /* JADX INFO: renamed from: M2.q$g */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f2597a;

        public g(long j4) {
            this.f2597a = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Y y4 = new Y();
            C0440q.this.f2566j.n(y4);
            long jAbs = Math.abs(this.f2597a);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long nanos = jAbs / timeUnit.toNanos(1L);
            long jAbs2 = Math.abs(this.f2597a) % timeUnit.toNanos(1L);
            StringBuilder sb = new StringBuilder();
            sb.append("deadline exceeded after ");
            if (this.f2597a < 0) {
                sb.append('-');
            }
            sb.append(nanos);
            Locale locale = Locale.US;
            sb.append(String.format(locale, ".%09d", Long.valueOf(jAbs2)));
            sb.append("s. ");
            sb.append(String.format(locale, "Name resolution delay %.9f seconds. ", Double.valueOf(((Long) C0440q.this.f2565i.h(AbstractC0363k.f1205a)) == null ? 0.0d : r2.longValue() / C0440q.f2556v)));
            sb.append(y4);
            C0440q.this.f2566j.c(K2.l0.f1219i.e(sb.toString()));
        }
    }

    public C0440q(K2.a0 a0Var, Executor executor, C0355c c0355c, e eVar, ScheduledExecutorService scheduledExecutorService, C0434n c0434n, K2.G g4) {
        this.f2557a = a0Var;
        U2.d dVarC = U2.c.c(a0Var.c(), System.identityHashCode(this));
        this.f2558b = dVarC;
        if (executor == AbstractC1234f.a()) {
            this.f2559c = new I0();
            this.f2560d = true;
        } else {
            this.f2559c = new J0(executor);
            this.f2560d = false;
        }
        this.f2561e = c0434n;
        this.f2562f = K2.r.e();
        this.f2564h = a0Var.e() == a0.d.UNARY || a0Var.e() == a0.d.SERVER_STREAMING;
        this.f2565i = c0355c;
        this.f2570n = eVar;
        this.f2572p = scheduledExecutorService;
        U2.c.d("ClientCall.<init>", dVarC);
    }

    public static boolean r(C0371t c0371t, C0371t c0371t2) {
        if (c0371t == null) {
            return false;
        }
        if (c0371t2 == null) {
            return true;
        }
        return c0371t.l(c0371t2);
    }

    public static void s(C0371t c0371t, C0371t c0371t2, C0371t c0371t3) {
        Logger logger = f2554t;
        if (logger.isLoggable(Level.FINE) && c0371t != null && c0371t.equals(c0371t2)) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long jMax = Math.max(0L, c0371t.o(timeUnit));
            Locale locale = Locale.US;
            StringBuilder sb = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(jMax)));
            if (c0371t3 == null) {
                sb.append(" Explicit call timeout was not set.");
            } else {
                sb.append(String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(c0371t3.o(timeUnit))));
            }
            logger.fine(sb.toString());
        }
    }

    public static C0371t t(C0371t c0371t, C0371t c0371t2) {
        return c0371t == null ? c0371t2 : c0371t2 == null ? c0371t : c0371t.n(c0371t2);
    }

    public static void u(K2.Z z4, C0373v c0373v, InterfaceC0366n interfaceC0366n, boolean z5) {
        z4.e(S.f1963i);
        Z.g gVar = S.f1959e;
        z4.e(gVar);
        if (interfaceC0366n != InterfaceC0364l.b.f1213a) {
            z4.p(gVar, interfaceC0366n.a());
        }
        Z.g gVar2 = S.f1960f;
        z4.e(gVar2);
        byte[] bArrA = K2.H.a(c0373v);
        if (bArrA.length != 0) {
            z4.p(gVar2, bArrA);
        }
        z4.e(S.f1961g);
        Z.g gVar3 = S.f1962h;
        z4.e(gVar3);
        if (z5) {
            z4.p(gVar3, f2555u);
        }
    }

    public final ScheduledFuture A(C0371t c0371t) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long jO = c0371t.o(timeUnit);
        return this.f2572p.schedule(new RunnableC0417e0(new g(jO)), jO, timeUnit);
    }

    public final void B(AbstractC0359g.a aVar, K2.Z z4) {
        InterfaceC0366n interfaceC0366nB;
        Z1.m.u(this.f2566j == null, "Already started");
        Z1.m.u(!this.f2568l, "call was cancelled");
        Z1.m.o(aVar, "observer");
        Z1.m.o(z4, "headers");
        if (this.f2562f.h()) {
            this.f2566j = C0439p0.f2553a;
            this.f2559c.execute(new b(aVar));
            return;
        }
        m();
        String strB = this.f2565i.b();
        if (strB != null) {
            interfaceC0366nB = this.f2575s.b(strB);
            if (interfaceC0366nB == null) {
                this.f2566j = C0439p0.f2553a;
                this.f2559c.execute(new c(aVar, strB));
                return;
            }
        } else {
            interfaceC0366nB = InterfaceC0364l.b.f1213a;
        }
        u(z4, this.f2574r, interfaceC0366nB, this.f2573q);
        C0371t c0371tP = p();
        if (c0371tP == null || !c0371tP.m()) {
            s(c0371tP, this.f2562f.g(), this.f2565i.d());
            this.f2566j = this.f2570n.a(this.f2557a, this.f2565i, z4, this.f2562f);
        } else {
            AbstractC0363k[] abstractC0363kArrF = S.f(this.f2565i, z4, 0, false);
            String str = r(this.f2565i.d(), this.f2562f.g()) ? "CallOptions" : "Context";
            Long l4 = (Long) this.f2565i.h(AbstractC0363k.f1205a);
            double dO = c0371tP.o(TimeUnit.NANOSECONDS);
            double d4 = f2556v;
            this.f2566j = new G(K2.l0.f1219i.q(String.format("ClientCall started after %s deadline was exceeded %.9f seconds ago. Name resolution delay %.9f seconds.", str, Double.valueOf(dO / d4), Double.valueOf(l4 == null ? 0.0d : l4.longValue() / d4))), abstractC0363kArrF);
        }
        if (this.f2560d) {
            this.f2566j.q();
        }
        if (this.f2565i.a() != null) {
            this.f2566j.l(this.f2565i.a());
        }
        if (this.f2565i.f() != null) {
            this.f2566j.f(this.f2565i.f().intValue());
        }
        if (this.f2565i.g() != null) {
            this.f2566j.g(this.f2565i.g().intValue());
        }
        if (c0371tP != null) {
            this.f2566j.h(c0371tP);
        }
        this.f2566j.b(interfaceC0366nB);
        boolean z5 = this.f2573q;
        if (z5) {
            this.f2566j.r(z5);
        }
        this.f2566j.o(this.f2574r);
        this.f2561e.b();
        this.f2566j.i(new d(aVar));
        this.f2562f.a(this.f2571o, AbstractC1234f.a());
        if (c0371tP != null && !c0371tP.equals(this.f2562f.g()) && this.f2572p != null) {
            this.f2563g = A(c0371tP);
        }
        if (this.f2567k) {
            v();
        }
    }

    @Override // K2.AbstractC0359g
    public void cancel(String str, Throwable th) {
        U2.e eVarH = U2.c.h("ClientCall.cancel");
        try {
            U2.c.a(this.f2558b);
            n(str, th);
            if (eVarH != null) {
                eVarH.close();
            }
        } catch (Throwable th2) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // K2.AbstractC0359g
    public C0353a getAttributes() {
        r rVar = this.f2566j;
        return rVar != null ? rVar.d() : C0353a.f1111c;
    }

    @Override // K2.AbstractC0359g
    public void halfClose() {
        U2.e eVarH = U2.c.h("ClientCall.halfClose");
        try {
            U2.c.a(this.f2558b);
            q();
            if (eVarH != null) {
                eVarH.close();
            }
        } catch (Throwable th) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // K2.AbstractC0359g
    public boolean isReady() {
        if (this.f2569m) {
            return false;
        }
        return this.f2566j.j();
    }

    public final void m() {
        C0429k0.b bVar = (C0429k0.b) this.f2565i.h(C0429k0.b.f2449g);
        if (bVar == null) {
            return;
        }
        Long l4 = bVar.f2450a;
        if (l4 != null) {
            C0371t c0371tA = C0371t.a(l4.longValue(), TimeUnit.NANOSECONDS);
            C0371t c0371tD = this.f2565i.d();
            if (c0371tD == null || c0371tA.compareTo(c0371tD) < 0) {
                this.f2565i = this.f2565i.m(c0371tA);
            }
        }
        Boolean bool = bVar.f2451b;
        if (bool != null) {
            this.f2565i = bool.booleanValue() ? this.f2565i.s() : this.f2565i.t();
        }
        if (bVar.f2452c != null) {
            Integer numF = this.f2565i.f();
            if (numF != null) {
                this.f2565i = this.f2565i.o(Math.min(numF.intValue(), bVar.f2452c.intValue()));
            } else {
                this.f2565i = this.f2565i.o(bVar.f2452c.intValue());
            }
        }
        if (bVar.f2453d != null) {
            Integer numG = this.f2565i.g();
            if (numG != null) {
                this.f2565i = this.f2565i.p(Math.min(numG.intValue(), bVar.f2453d.intValue()));
            } else {
                this.f2565i = this.f2565i.p(bVar.f2453d.intValue());
            }
        }
    }

    public final void n(String str, Throwable th) {
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            f2554t.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th);
        }
        if (this.f2568l) {
            return;
        }
        this.f2568l = true;
        try {
            if (this.f2566j != null) {
                K2.l0 l0Var = K2.l0.f1216f;
                K2.l0 l0VarQ = str != null ? l0Var.q(str) : l0Var.q("Call cancelled without message");
                if (th != null) {
                    l0VarQ = l0VarQ.p(th);
                }
                this.f2566j.c(l0VarQ);
            }
            v();
        } catch (Throwable th2) {
            v();
            throw th2;
        }
    }

    public final void o(AbstractC0359g.a aVar, K2.l0 l0Var, K2.Z z4) {
        aVar.onClose(l0Var, z4);
    }

    public final C0371t p() {
        return t(this.f2565i.d(), this.f2562f.g());
    }

    public final void q() {
        Z1.m.u(this.f2566j != null, "Not started");
        Z1.m.u(!this.f2568l, "call was cancelled");
        Z1.m.u(!this.f2569m, "call already half-closed");
        this.f2569m = true;
        this.f2566j.m();
    }

    @Override // K2.AbstractC0359g
    public void request(int i4) {
        U2.e eVarH = U2.c.h("ClientCall.request");
        try {
            U2.c.a(this.f2558b);
            Z1.m.u(this.f2566j != null, "Not started");
            Z1.m.e(i4 >= 0, "Number requested must be non-negative");
            this.f2566j.e(i4);
            if (eVarH != null) {
                eVarH.close();
            }
        } catch (Throwable th) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // K2.AbstractC0359g
    public void sendMessage(Object obj) {
        U2.e eVarH = U2.c.h("ClientCall.sendMessage");
        try {
            U2.c.a(this.f2558b);
            w(obj);
            if (eVarH != null) {
                eVarH.close();
            }
        } catch (Throwable th) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // K2.AbstractC0359g
    public void setMessageCompression(boolean z4) {
        Z1.m.u(this.f2566j != null, "Not started");
        this.f2566j.a(z4);
    }

    @Override // K2.AbstractC0359g
    public void start(AbstractC0359g.a aVar, K2.Z z4) {
        U2.e eVarH = U2.c.h("ClientCall.start");
        try {
            U2.c.a(this.f2558b);
            B(aVar, z4);
            if (eVarH != null) {
                eVarH.close();
            }
        } catch (Throwable th) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String toString() {
        return Z1.g.b(this).d("method", this.f2557a).toString();
    }

    public final void v() {
        this.f2562f.i(this.f2571o);
        ScheduledFuture scheduledFuture = this.f2563g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public final void w(Object obj) {
        Z1.m.u(this.f2566j != null, "Not started");
        Z1.m.u(!this.f2568l, "call was cancelled");
        Z1.m.u(!this.f2569m, "call was half-closed");
        try {
            r rVar = this.f2566j;
            if (rVar instanceof C0) {
                ((C0) rVar).p0(obj);
            } else {
                rVar.p(this.f2557a.j(obj));
            }
            if (this.f2564h) {
                return;
            }
            this.f2566j.flush();
        } catch (Error e4) {
            this.f2566j.c(K2.l0.f1216f.q("Client sendMessage() failed with Error"));
            throw e4;
        } catch (RuntimeException e5) {
            this.f2566j.c(K2.l0.f1216f.p(e5).q("Failed to stream message"));
        }
    }

    public C0440q x(C0367o c0367o) {
        this.f2575s = c0367o;
        return this;
    }

    public C0440q y(C0373v c0373v) {
        this.f2574r = c0373v;
        return this;
    }

    public C0440q z(boolean z4) {
        this.f2573q = z4;
        return this;
    }
}
