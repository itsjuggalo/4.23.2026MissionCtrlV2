package tb;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import rb.l;
import rb.y0;
import tb.c;
import tb.m1;
import tb.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends tb.c implements r, m1.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f20861g = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t2 f20862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f20863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public rb.y0 f20866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f20867f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void e(rb.k1 k1Var);

        void f(u2 u2Var, boolean z10, boolean z11, int i10);

        void g(rb.y0 y0Var, byte[] bArr);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class c extends c.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final n2 f20873i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f20874j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public s f20875k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f20876l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public rb.v f20877m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f20878n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Runnable f20879o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public volatile boolean f20880p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f20881q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f20882r;

        /* JADX INFO: renamed from: tb.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class RunnableC0371a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rb.k1 f20883a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s.a f20884b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ rb.y0 f20885c;

            public RunnableC0371a(rb.k1 k1Var, s.a aVar, rb.y0 y0Var) {
                this.f20883a = k1Var;
                this.f20884b = aVar;
                this.f20885c = y0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.C(this.f20883a, this.f20884b, this.f20885c);
            }
        }

        public c(int i10, n2 n2Var, t2 t2Var) {
            super(i10, n2Var, t2Var);
            this.f20877m = rb.v.c();
            this.f20878n = false;
            this.f20873i = (n2) p6.n.o(n2Var, "statsTraceCtx");
        }

        public final void C(rb.k1 k1Var, s.a aVar, rb.y0 y0Var) {
            if (this.f20874j) {
                return;
            }
            this.f20874j = true;
            this.f20873i.m(k1Var);
            if (m() != null) {
                m().f(k1Var.p());
            }
            o().d(k1Var, aVar, y0Var);
        }

        public void D(x1 x1Var) throws Throwable {
            p6.n.o(x1Var, "frame");
            boolean z10 = true;
            try {
                if (this.f20881q) {
                    a.f20861g.log(Level.INFO, "Received data on closed stream");
                    x1Var.close();
                    return;
                } else {
                    try {
                        l(x1Var);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        z10 = false;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (z10) {
                x1Var.close();
            }
            throw th;
        }

        public void E(rb.y0 y0Var) {
            boolean z10 = true;
            p6.n.u(!this.f20881q, "Received headers on closed stream");
            this.f20873i.a();
            String str = (String) y0Var.g(r0.f21630g);
            if (!this.f20876l || str == null) {
                z10 = false;
            } else if (str.equalsIgnoreCase("gzip")) {
                w(new s0());
            } else {
                if (!str.equalsIgnoreCase("identity")) {
                    e(rb.k1.f19606s.r(String.format("Can't find full stream decompressor for %s", str)).d());
                    return;
                }
                z10 = false;
            }
            String str2 = (String) y0Var.g(r0.f21628e);
            if (str2 != null) {
                rb.u uVarE = this.f20877m.e(str2);
                if (uVarE == null) {
                    e(rb.k1.f19606s.r(String.format("Can't find decompressor for %s", str2)).d());
                    return;
                } else if (uVarE != l.b.f19636a) {
                    if (z10) {
                        e(rb.k1.f19606s.r("Full stream and gRPC message encoding cannot both be set").d());
                        return;
                    }
                    v(uVarE);
                }
            }
            o().c(y0Var);
        }

        public void F(rb.y0 y0Var, rb.k1 k1Var) {
            p6.n.o(k1Var, "status");
            p6.n.o(y0Var, "trailers");
            if (this.f20881q) {
                a.f20861g.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{k1Var, y0Var});
            } else {
                this.f20873i.b(y0Var);
                N(k1Var, false, y0Var);
            }
        }

        public final boolean G() {
            return this.f20880p;
        }

        @Override // tb.c.a
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public final s o() {
            return this.f20875k;
        }

        public final void I(rb.v vVar) {
            p6.n.u(this.f20875k == null, "Already called start");
            this.f20877m = (rb.v) p6.n.o(vVar, "decompressorRegistry");
        }

        public final void J(boolean z10) {
            this.f20876l = z10;
        }

        public final void K(s sVar) {
            p6.n.u(this.f20875k == null, "Already called setListener");
            this.f20875k = (s) p6.n.o(sVar, "listener");
        }

        public final void L() {
            this.f20880p = true;
        }

        public final void M(rb.k1 k1Var, s.a aVar, boolean z10, rb.y0 y0Var) {
            p6.n.o(k1Var, "status");
            p6.n.o(y0Var, "trailers");
            if (!this.f20881q || z10) {
                this.f20881q = true;
                this.f20882r = k1Var.p();
                s();
                if (this.f20878n) {
                    this.f20879o = null;
                    C(k1Var, aVar, y0Var);
                } else {
                    this.f20879o = new RunnableC0371a(k1Var, aVar, y0Var);
                    k(z10);
                }
            }
        }

        public final void N(rb.k1 k1Var, boolean z10, rb.y0 y0Var) {
            M(k1Var, s.a.PROCESSED, z10, y0Var);
        }

        @Override // tb.l1.b
        public void c(boolean z10) {
            p6.n.u(this.f20881q, "status should have been reported on deframer closed");
            this.f20878n = true;
            if (this.f20882r && z10) {
                N(rb.k1.f19606s.r("Encountered end-of-stream mid-frame"), true, new rb.y0());
            }
            Runnable runnable = this.f20879o;
            if (runnable != null) {
                runnable.run();
                this.f20879o = null;
            }
        }
    }

    public a(v2 v2Var, n2 n2Var, t2 t2Var, rb.y0 y0Var, rb.c cVar, boolean z10) {
        p6.n.o(y0Var, "headers");
        this.f20862a = (t2) p6.n.o(t2Var, "transportTracer");
        this.f20864c = r0.p(cVar);
        this.f20865d = z10;
        if (z10) {
            this.f20863b = new C0370a(y0Var, n2Var);
        } else {
            this.f20863b = new m1(this, v2Var, n2Var);
            this.f20866e = y0Var;
        }
    }

    @Override // tb.r
    public void c(int i10) {
        y().x(i10);
    }

    @Override // tb.r
    public void d(int i10) {
        this.f20863b.d(i10);
    }

    @Override // tb.r
    public final void e(rb.k1 k1Var) {
        p6.n.e(!k1Var.p(), "Should not cancel with OK status");
        this.f20867f = true;
        u().e(k1Var);
    }

    @Override // tb.c, tb.o2
    public final boolean f() {
        return super.f() && !this.f20867f;
    }

    @Override // tb.r
    public void g(rb.t tVar) {
        rb.y0 y0Var = this.f20866e;
        y0.g gVar = r0.f21627d;
        y0Var.e(gVar);
        this.f20866e.p(gVar, Long.valueOf(Math.max(0L, tVar.q(TimeUnit.NANOSECONDS))));
    }

    @Override // tb.r
    public final void i() {
        if (y().G()) {
            return;
        }
        y().L();
        q();
    }

    @Override // tb.r
    public final void j(s sVar) {
        y().K(sVar);
        if (this.f20865d) {
            return;
        }
        u().g(this.f20866e, null);
        this.f20866e = null;
    }

    @Override // tb.r
    public final void k(rb.v vVar) {
        y().I(vVar);
    }

    @Override // tb.r
    public final void l(x0 x0Var) {
        x0Var.b("remote_addr", getAttributes().b(rb.c0.f19517a));
    }

    @Override // tb.m1.d
    public final void m(u2 u2Var, boolean z10, boolean z11, int i10) {
        p6.n.e(u2Var != null || z10, "null frame before EOS");
        u().f(u2Var, z10, z11, i10);
    }

    @Override // tb.r
    public final void p(boolean z10) {
        y().J(z10);
    }

    @Override // tb.c
    public final p0 r() {
        return this.f20863b;
    }

    public abstract b u();

    public t2 w() {
        return this.f20862a;
    }

    public final boolean x() {
        return this.f20864c;
    }

    public abstract c y();

    /* JADX INFO: renamed from: tb.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0370a implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public rb.y0 f20868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f20869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final n2 f20870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f20871d;

        public C0370a(rb.y0 y0Var, n2 n2Var) {
            this.f20868a = (rb.y0) p6.n.o(y0Var, "headers");
            this.f20870c = (n2) p6.n.o(n2Var, "statsTraceCtx");
        }

        @Override // tb.p0
        public void b(InputStream inputStream) {
            p6.n.u(this.f20871d == null, "writePayload should not be called multiple times");
            try {
                this.f20871d = r6.b.d(inputStream);
                this.f20870c.i(0);
                n2 n2Var = this.f20870c;
                byte[] bArr = this.f20871d;
                n2Var.j(0, bArr.length, bArr.length);
                this.f20870c.k(this.f20871d.length);
                this.f20870c.l(this.f20871d.length);
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // tb.p0
        public void close() {
            this.f20869b = true;
            p6.n.u(this.f20871d != null, "Lack of request message. GET request is only supported for unary requests");
            a.this.u().g(this.f20868a, this.f20871d);
            this.f20871d = null;
            this.f20868a = null;
        }

        @Override // tb.p0
        public boolean isClosed() {
            return this.f20869b;
        }

        @Override // tb.p0
        public void flush() {
        }

        @Override // tb.p0
        public p0 a(rb.n nVar) {
            return this;
        }

        @Override // tb.p0
        public void d(int i10) {
        }
    }
}
