package tb;

import com.google.firebase.analytics.FirebaseAnalytics;
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
import rb.g;
import rb.k1;
import rb.l;
import rb.r;
import rb.y0;
import rb.z0;
import tb.j1;
import tb.p2;
import tb.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends rb.g {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Logger f21574t = Logger.getLogger(q.class.getName());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final byte[] f21575u = "gzip".getBytes(Charset.forName("US-ASCII"));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final double f21576v = TimeUnit.SECONDS.toNanos(1) * 1.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.z0 f21577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bc.d f21578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f21579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f21580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f21581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final rb.r f21582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile ScheduledFuture f21583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f21584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public rb.c f21585i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f21586j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f21587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f21588l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f21589m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f21590n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ScheduledExecutorService f21592p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f21593q;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f f21591o = new f();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public rb.v f21594r = rb.v.c();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public rb.o f21595s = rb.o.a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g.a f21596b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g.a aVar) {
            super(q.this.f21582f);
            this.f21596b = aVar;
        }

        @Override // tb.y
        public void a() {
            q qVar = q.this;
            qVar.t(this.f21596b, rb.s.a(qVar.f21582f), new rb.y0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g.a f21598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f21599c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g.a aVar, String str) {
            super(q.this.f21582f);
            this.f21598b = aVar;
            this.f21599c = str;
        }

        @Override // tb.y
        public void a() {
            q.this.t(this.f21598b, rb.k1.f19606s.r(String.format("Unable to find compressor by name %s", this.f21599c)), new rb.y0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g.a f21601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public rb.k1 f21602b;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class a extends y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ bc.b f21604b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ rb.y0 f21605c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(bc.b bVar, rb.y0 y0Var) {
                super(q.this.f21582f);
                this.f21604b = bVar;
                this.f21605c = y0Var;
            }

            @Override // tb.y
            public void a() {
                bc.e eVarH = bc.c.h("ClientCall$Listener.headersRead");
                try {
                    bc.c.a(q.this.f21578b);
                    bc.c.e(this.f21604b);
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
                if (d.this.f21602b != null) {
                    return;
                }
                try {
                    d.this.f21601a.b(this.f21605c);
                } catch (Throwable th) {
                    d.this.i(rb.k1.f19593f.q(th).r("Failed to read headers"));
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class b extends y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ bc.b f21607b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ p2.a f21608c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(bc.b bVar, p2.a aVar) {
                super(q.this.f21582f);
                this.f21607b = bVar;
                this.f21608c = aVar;
            }

            private void b() {
                if (d.this.f21602b != null) {
                    r0.e(this.f21608c);
                    return;
                }
                while (true) {
                    try {
                        InputStream next = this.f21608c.next();
                        if (next == null) {
                            return;
                        }
                        try {
                            d.this.f21601a.c(q.this.f21577a.i(next));
                            next.close();
                        } finally {
                        }
                    } catch (Throwable th) {
                        r0.e(this.f21608c);
                        d.this.i(rb.k1.f19593f.q(th).r("Failed to read message."));
                        return;
                    }
                }
            }

            @Override // tb.y
            public void a() {
                bc.e eVarH = bc.c.h("ClientCall$Listener.messagesAvailable");
                try {
                    bc.c.a(q.this.f21578b);
                    bc.c.e(this.f21607b);
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

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class c extends y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ bc.b f21610b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ rb.k1 f21611c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ rb.y0 f21612d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(bc.b bVar, rb.k1 k1Var, rb.y0 y0Var) {
                super(q.this.f21582f);
                this.f21610b = bVar;
                this.f21611c = k1Var;
                this.f21612d = y0Var;
            }

            private void b() {
                rb.k1 k1Var = this.f21611c;
                rb.y0 y0Var = this.f21612d;
                if (d.this.f21602b != null) {
                    k1Var = d.this.f21602b;
                    y0Var = new rb.y0();
                }
                q.this.f21587k = true;
                try {
                    d dVar = d.this;
                    q.this.t(dVar.f21601a, k1Var, y0Var);
                } finally {
                    q.this.A();
                    q.this.f21581e.a(k1Var.p());
                }
            }

            @Override // tb.y
            public void a() {
                bc.e eVarH = bc.c.h("ClientCall$Listener.onClose");
                try {
                    bc.c.a(q.this.f21578b);
                    bc.c.e(this.f21610b);
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

        /* JADX INFO: renamed from: tb.q$d$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class C0375d extends y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ bc.b f21614b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0375d(bc.b bVar) {
                super(q.this.f21582f);
                this.f21614b = bVar;
            }

            private void b() {
                if (d.this.f21602b != null) {
                    return;
                }
                try {
                    d.this.f21601a.d();
                } catch (Throwable th) {
                    d.this.i(rb.k1.f19593f.q(th).r("Failed to call onReady."));
                }
            }

            @Override // tb.y
            public void a() {
                bc.e eVarH = bc.c.h("ClientCall$Listener.onReady");
                try {
                    bc.c.a(q.this.f21578b);
                    bc.c.e(this.f21614b);
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

        public d(g.a aVar) {
            this.f21601a = (g.a) p6.n.o(aVar, "observer");
        }

        @Override // tb.p2
        public void a(p2.a aVar) {
            bc.e eVarH = bc.c.h("ClientStreamListener.messagesAvailable");
            try {
                bc.c.a(q.this.f21578b);
                q.this.f21579c.execute(new b(bc.c.f(), aVar));
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

        @Override // tb.p2
        public void b() {
            if (q.this.f21577a.e().a()) {
                return;
            }
            bc.e eVarH = bc.c.h("ClientStreamListener.onReady");
            try {
                bc.c.a(q.this.f21578b);
                q.this.f21579c.execute(new C0375d(bc.c.f()));
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

        @Override // tb.s
        public void c(rb.y0 y0Var) {
            bc.e eVarH = bc.c.h("ClientStreamListener.headersRead");
            try {
                bc.c.a(q.this.f21578b);
                q.this.f21579c.execute(new a(bc.c.f(), y0Var));
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

        @Override // tb.s
        public void d(rb.k1 k1Var, s.a aVar, rb.y0 y0Var) {
            bc.e eVarH = bc.c.h("ClientStreamListener.closed");
            try {
                bc.c.a(q.this.f21578b);
                h(k1Var, aVar, y0Var);
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

        public final void h(rb.k1 k1Var, s.a aVar, rb.y0 y0Var) {
            rb.t tVarU = q.this.u();
            if (k1Var.n() == k1.b.CANCELLED && tVarU != null && tVarU.m()) {
                x0 x0Var = new x0();
                q.this.f21586j.l(x0Var);
                k1Var = rb.k1.f19596i.f("ClientCall was cancelled at or after deadline. " + x0Var);
                y0Var = new rb.y0();
            }
            q.this.f21579c.execute(new c(bc.c.f(), k1Var, y0Var));
        }

        public final void i(rb.k1 k1Var) {
            this.f21602b = k1Var;
            q.this.f21586j.e(k1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface e {
        r a(rb.z0 z0Var, rb.c cVar, rb.y0 y0Var, rb.r rVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class f implements r.a {
        public f() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f21617a;

        public g(long j10) {
            this.f21617a = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            x0 x0Var = new x0();
            q.this.f21586j.l(x0Var);
            long jAbs = Math.abs(this.f21617a);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long nanos = jAbs / timeUnit.toNanos(1L);
            long jAbs2 = Math.abs(this.f21617a) % timeUnit.toNanos(1L);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("deadline exceeded after ");
            if (this.f21617a < 0) {
                sb2.append('-');
            }
            sb2.append(nanos);
            Locale locale = Locale.US;
            sb2.append(String.format(locale, ".%09d", Long.valueOf(jAbs2)));
            sb2.append("s. ");
            sb2.append(String.format(locale, "Name resolution delay %.9f seconds. ", Double.valueOf(((Long) q.this.f21585i.h(rb.k.f19580a)) == null ? 0.0d : r2.longValue() / q.f21576v)));
            sb2.append(x0Var);
            q.this.f21586j.e(rb.k1.f19596i.f(sb2.toString()));
        }
    }

    public q(rb.z0 z0Var, Executor executor, rb.c cVar, e eVar, ScheduledExecutorService scheduledExecutorService, n nVar, rb.g0 g0Var) {
        this.f21577a = z0Var;
        bc.d dVarC = bc.c.c(z0Var.c(), System.identityHashCode(this));
        this.f21578b = dVarC;
        if (executor == u6.g.a()) {
            this.f21579c = new h2();
            this.f21580d = true;
        } else {
            this.f21579c = new i2(executor);
            this.f21580d = false;
        }
        this.f21581e = nVar;
        this.f21582f = rb.r.e();
        this.f21584h = z0Var.e() == z0.d.UNARY || z0Var.e() == z0.d.SERVER_STREAMING;
        this.f21585i = cVar;
        this.f21590n = eVar;
        this.f21592p = scheduledExecutorService;
        bc.c.d("ClientCall.<init>", dVarC);
    }

    public static boolean w(rb.t tVar, rb.t tVar2) {
        if (tVar == null) {
            return false;
        }
        if (tVar2 == null) {
            return true;
        }
        return tVar.l(tVar2);
    }

    public static void x(rb.t tVar, rb.t tVar2, rb.t tVar3) {
        Logger logger = f21574t;
        if (logger.isLoggable(Level.FINE) && tVar != null && tVar.equals(tVar2)) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long jMax = Math.max(0L, tVar.q(timeUnit));
            Locale locale = Locale.US;
            StringBuilder sb2 = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(jMax)));
            if (tVar3 == null) {
                sb2.append(" Explicit call timeout was not set.");
            } else {
                sb2.append(String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(tVar3.q(timeUnit))));
            }
            logger.fine(sb2.toString());
        }
    }

    public static rb.t y(rb.t tVar, rb.t tVar2) {
        return tVar == null ? tVar2 : tVar2 == null ? tVar : tVar.o(tVar2);
    }

    public static void z(rb.y0 y0Var, rb.v vVar, rb.n nVar, boolean z10) {
        y0Var.e(r0.f21632i);
        y0.g gVar = r0.f21628e;
        y0Var.e(gVar);
        if (nVar != l.b.f19636a) {
            y0Var.p(gVar, nVar.a());
        }
        y0.g gVar2 = r0.f21629f;
        y0Var.e(gVar2);
        byte[] bArrA = rb.h0.a(vVar);
        if (bArrA.length != 0) {
            y0Var.p(gVar2, bArrA);
        }
        y0Var.e(r0.f21630g);
        y0.g gVar3 = r0.f21631h;
        y0Var.e(gVar3);
        if (z10) {
            y0Var.p(gVar3, f21575u);
        }
    }

    public final void A() {
        this.f21582f.i(this.f21591o);
        ScheduledFuture scheduledFuture = this.f21583g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public final void B(Object obj) {
        p6.n.u(this.f21586j != null, "Not started");
        p6.n.u(!this.f21588l, "call was cancelled");
        p6.n.u(!this.f21589m, "call was half-closed");
        try {
            r rVar = this.f21586j;
            if (rVar instanceof b2) {
                ((b2) rVar).n0(obj);
            } else {
                rVar.n(this.f21577a.j(obj));
            }
            if (this.f21584h) {
                return;
            }
            this.f21586j.flush();
        } catch (Error e10) {
            this.f21586j.e(rb.k1.f19593f.r("Client sendMessage() failed with Error"));
            throw e10;
        } catch (RuntimeException e11) {
            this.f21586j.e(rb.k1.f19593f.q(e11).r("Failed to stream message"));
        }
    }

    public q C(rb.o oVar) {
        this.f21595s = oVar;
        return this;
    }

    public q D(rb.v vVar) {
        this.f21594r = vVar;
        return this;
    }

    public q E(boolean z10) {
        this.f21593q = z10;
        return this;
    }

    public final ScheduledFuture F(rb.t tVar) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long jQ = tVar.q(timeUnit);
        return this.f21592p.schedule(new d1(new g(jQ)), jQ, timeUnit);
    }

    public final void G(g.a aVar, rb.y0 y0Var) {
        rb.n nVarB;
        p6.n.u(this.f21586j == null, "Already started");
        p6.n.u(!this.f21588l, "call was cancelled");
        p6.n.o(aVar, "observer");
        p6.n.o(y0Var, "headers");
        if (this.f21582f.h()) {
            this.f21586j = o1.f21564a;
            this.f21579c.execute(new b(aVar));
            return;
        }
        r();
        String strB = this.f21585i.b();
        if (strB != null) {
            nVarB = this.f21595s.b(strB);
            if (nVarB == null) {
                this.f21586j = o1.f21564a;
                this.f21579c.execute(new c(aVar, strB));
                return;
            }
        } else {
            nVarB = l.b.f19636a;
        }
        z(y0Var, this.f21594r, nVarB, this.f21593q);
        rb.t tVarU = u();
        if (tVarU == null || !tVarU.m()) {
            x(tVarU, this.f21582f.g(), this.f21585i.d());
            this.f21586j = this.f21590n.a(this.f21577a, this.f21585i, y0Var, this.f21582f);
        } else {
            rb.k[] kVarArrF = r0.f(this.f21585i, y0Var, 0, false);
            String str = w(this.f21585i.d(), this.f21582f.g()) ? "CallOptions" : "Context";
            Long l10 = (Long) this.f21585i.h(rb.k.f19580a);
            double dQ = tVarU.q(TimeUnit.NANOSECONDS);
            double d10 = f21576v;
            this.f21586j = new g0(rb.k1.f19596i.r(String.format("ClientCall started after %s deadline was exceeded %.9f seconds ago. Name resolution delay %.9f seconds.", str, Double.valueOf(dQ / d10), Double.valueOf(l10 == null ? 0.0d : l10.longValue() / d10))), kVarArrF);
        }
        if (this.f21580d) {
            this.f21586j.o();
        }
        if (this.f21585i.a() != null) {
            this.f21586j.h(this.f21585i.a());
        }
        if (this.f21585i.f() != null) {
            this.f21586j.c(this.f21585i.f().intValue());
        }
        if (this.f21585i.g() != null) {
            this.f21586j.d(this.f21585i.g().intValue());
        }
        if (tVarU != null) {
            this.f21586j.g(tVarU);
        }
        this.f21586j.a(nVarB);
        boolean z10 = this.f21593q;
        if (z10) {
            this.f21586j.p(z10);
        }
        this.f21586j.k(this.f21594r);
        this.f21581e.b();
        this.f21586j.j(new d(aVar));
        this.f21582f.a(this.f21591o, u6.g.a());
        if (tVarU != null && !tVarU.equals(this.f21582f.g()) && this.f21592p != null) {
            this.f21583g = F(tVarU);
        }
        if (this.f21587k) {
            A();
        }
    }

    @Override // rb.g
    public void a(String str, Throwable th) {
        bc.e eVarH = bc.c.h("ClientCall.cancel");
        try {
            bc.c.a(this.f21578b);
            s(str, th);
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

    @Override // rb.g
    public void b() {
        bc.e eVarH = bc.c.h("ClientCall.halfClose");
        try {
            bc.c.a(this.f21578b);
            v();
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

    @Override // rb.g
    public void c(int i10) {
        bc.e eVarH = bc.c.h("ClientCall.request");
        try {
            bc.c.a(this.f21578b);
            p6.n.u(this.f21586j != null, "Not started");
            p6.n.e(i10 >= 0, "Number requested must be non-negative");
            this.f21586j.b(i10);
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

    @Override // rb.g
    public void d(Object obj) {
        bc.e eVarH = bc.c.h("ClientCall.sendMessage");
        try {
            bc.c.a(this.f21578b);
            B(obj);
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

    @Override // rb.g
    public void e(g.a aVar, rb.y0 y0Var) {
        bc.e eVarH = bc.c.h("ClientCall.start");
        try {
            bc.c.a(this.f21578b);
            G(aVar, y0Var);
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

    public final void r() {
        j1.b bVar = (j1.b) this.f21585i.h(j1.b.f21444g);
        if (bVar == null) {
            return;
        }
        Long l10 = bVar.f21445a;
        if (l10 != null) {
            rb.t tVarA = rb.t.a(l10.longValue(), TimeUnit.NANOSECONDS);
            rb.t tVarD = this.f21585i.d();
            if (tVarD == null || tVarA.compareTo(tVarD) < 0) {
                this.f21585i = this.f21585i.m(tVarA);
            }
        }
        Boolean bool = bVar.f21446b;
        if (bool != null) {
            this.f21585i = bool.booleanValue() ? this.f21585i.t() : this.f21585i.u();
        }
        if (bVar.f21447c != null) {
            Integer numF = this.f21585i.f();
            if (numF != null) {
                this.f21585i = this.f21585i.p(Math.min(numF.intValue(), bVar.f21447c.intValue()));
            } else {
                this.f21585i = this.f21585i.p(bVar.f21447c.intValue());
            }
        }
        if (bVar.f21448d != null) {
            Integer numG = this.f21585i.g();
            if (numG != null) {
                this.f21585i = this.f21585i.q(Math.min(numG.intValue(), bVar.f21448d.intValue()));
            } else {
                this.f21585i = this.f21585i.q(bVar.f21448d.intValue());
            }
        }
    }

    public final void s(String str, Throwable th) {
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            f21574t.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th);
        }
        if (this.f21588l) {
            return;
        }
        this.f21588l = true;
        try {
            if (this.f21586j != null) {
                rb.k1 k1Var = rb.k1.f19593f;
                rb.k1 k1VarR = str != null ? k1Var.r(str) : k1Var.r("Call cancelled without message");
                if (th != null) {
                    k1VarR = k1VarR.q(th);
                }
                this.f21586j.e(k1VarR);
            }
            A();
        } catch (Throwable th2) {
            A();
            throw th2;
        }
    }

    public final void t(g.a aVar, rb.k1 k1Var, rb.y0 y0Var) {
        aVar.a(k1Var, y0Var);
    }

    public String toString() {
        return p6.h.b(this).d(FirebaseAnalytics.Param.METHOD, this.f21577a).toString();
    }

    public final rb.t u() {
        return y(this.f21585i.d(), this.f21582f.g());
    }

    public final void v() {
        p6.n.u(this.f21586j != null, "Not started");
        p6.n.u(!this.f21588l, "call was cancelled");
        p6.n.u(!this.f21589m, "call already half-closed");
        this.f21589m = true;
        this.f21586j.i();
    }
}
