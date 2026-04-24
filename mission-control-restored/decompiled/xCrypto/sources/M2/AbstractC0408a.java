package M2;

import K2.C0355c;
import K2.C0371t;
import K2.C0373v;
import K2.InterfaceC0364l;
import K2.InterfaceC0366n;
import K2.InterfaceC0372u;
import K2.Z;
import M2.AbstractC0412c;
import M2.C0435n0;
import M2.InterfaceC0443s;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: M2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0408a extends AbstractC0412c implements r, C0435n0.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f2120g = Logger.getLogger(AbstractC0408a.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U0 f2121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P f2122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public K2.Z f2125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f2126f;

    /* JADX INFO: renamed from: M2.a$b */
    public interface b {
        void c(K2.l0 l0Var);

        void d(K2.Z z4, byte[] bArr);

        void e(V0 v02, boolean z4, boolean z5, int i4);
    }

    /* JADX INFO: renamed from: M2.a$c */
    public static abstract class c extends AbstractC0412c.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final O0 f2132i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f2133j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public InterfaceC0443s f2134k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f2135l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public C0373v f2136m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f2137n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Runnable f2138o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public volatile boolean f2139p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f2140q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f2141r;

        /* JADX INFO: renamed from: M2.a$c$a, reason: collision with other inner class name */
        public class RunnableC0042a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ K2.l0 f2142a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InterfaceC0443s.a f2143b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ K2.Z f2144c;

            public RunnableC0042a(K2.l0 l0Var, InterfaceC0443s.a aVar, K2.Z z4) {
                this.f2142a = l0Var;
                this.f2143b = aVar;
                this.f2144c = z4;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.C(this.f2142a, this.f2143b, this.f2144c);
            }
        }

        public c(int i4, O0 o02, U0 u02) {
            super(i4, o02, u02);
            this.f2136m = C0373v.c();
            this.f2137n = false;
            this.f2132i = (O0) Z1.m.o(o02, "statsTraceCtx");
        }

        public final void C(K2.l0 l0Var, InterfaceC0443s.a aVar, K2.Z z4) {
            if (this.f2133j) {
                return;
            }
            this.f2133j = true;
            this.f2132i.m(l0Var);
            if (m() != null) {
                m().f(l0Var.o());
            }
            o().b(l0Var, aVar, z4);
        }

        public void D(y0 y0Var) throws Throwable {
            Z1.m.o(y0Var, "frame");
            boolean z4 = true;
            try {
                if (this.f2140q) {
                    AbstractC0408a.f2120g.log(Level.INFO, "Received data on closed stream");
                    y0Var.close();
                    return;
                } else {
                    try {
                        l(y0Var);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        z4 = false;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (z4) {
                y0Var.close();
            }
            throw th;
        }

        public void E(K2.Z z4) {
            boolean z5 = true;
            Z1.m.u(!this.f2140q, "Received headers on closed stream");
            this.f2132i.a();
            String str = (String) z4.g(S.f1961g);
            if (!this.f2135l || str == null) {
                z5 = false;
            } else if (str.equalsIgnoreCase("gzip")) {
                w(new T());
            } else {
                if (!str.equalsIgnoreCase("identity")) {
                    e(K2.l0.f1229s.q(String.format("Can't find full stream decompressor for %s", str)).d());
                    return;
                }
                z5 = false;
            }
            String str2 = (String) z4.g(S.f1959e);
            if (str2 != null) {
                InterfaceC0372u interfaceC0372uE = this.f2136m.e(str2);
                if (interfaceC0372uE == null) {
                    e(K2.l0.f1229s.q(String.format("Can't find decompressor for %s", str2)).d());
                    return;
                } else if (interfaceC0372uE != InterfaceC0364l.b.f1213a) {
                    if (z5) {
                        e(K2.l0.f1229s.q("Full stream and gRPC message encoding cannot both be set").d());
                        return;
                    }
                    v(interfaceC0372uE);
                }
            }
            o().d(z4);
        }

        public void F(K2.Z z4, K2.l0 l0Var) {
            Z1.m.o(l0Var, "status");
            Z1.m.o(z4, "trailers");
            if (this.f2140q) {
                AbstractC0408a.f2120g.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{l0Var, z4});
            } else {
                this.f2132i.b(z4);
                N(l0Var, false, z4);
            }
        }

        public final boolean G() {
            return this.f2139p;
        }

        @Override // M2.AbstractC0412c.a
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public final InterfaceC0443s o() {
            return this.f2134k;
        }

        public final void I(C0373v c0373v) {
            Z1.m.u(this.f2134k == null, "Already called start");
            this.f2136m = (C0373v) Z1.m.o(c0373v, "decompressorRegistry");
        }

        public final void J(boolean z4) {
            this.f2135l = z4;
        }

        public final void K(InterfaceC0443s interfaceC0443s) {
            Z1.m.u(this.f2134k == null, "Already called setListener");
            this.f2134k = (InterfaceC0443s) Z1.m.o(interfaceC0443s, "listener");
        }

        public final void L() {
            this.f2139p = true;
        }

        public final void M(K2.l0 l0Var, InterfaceC0443s.a aVar, boolean z4, K2.Z z5) {
            Z1.m.o(l0Var, "status");
            Z1.m.o(z5, "trailers");
            if (!this.f2140q || z4) {
                this.f2140q = true;
                this.f2141r = l0Var.o();
                s();
                if (this.f2137n) {
                    this.f2138o = null;
                    C(l0Var, aVar, z5);
                } else {
                    this.f2138o = new RunnableC0042a(l0Var, aVar, z5);
                    k(z4);
                }
            }
        }

        public final void N(K2.l0 l0Var, boolean z4, K2.Z z5) {
            M(l0Var, InterfaceC0443s.a.PROCESSED, z4, z5);
        }

        public void c(boolean z4) {
            Z1.m.u(this.f2140q, "status should have been reported on deframer closed");
            this.f2137n = true;
            if (this.f2141r && z4) {
                N(K2.l0.f1229s.q("Encountered end-of-stream mid-frame"), true, new K2.Z());
            }
            Runnable runnable = this.f2138o;
            if (runnable != null) {
                runnable.run();
                this.f2138o = null;
            }
        }
    }

    public AbstractC0408a(W0 w02, O0 o02, U0 u02, K2.Z z4, C0355c c0355c, boolean z5) {
        Z1.m.o(z4, "headers");
        this.f2121a = (U0) Z1.m.o(u02, "transportTracer");
        this.f2123c = S.p(c0355c);
        this.f2124d = z5;
        if (z5) {
            this.f2122b = new C0041a(z4, o02);
        } else {
            this.f2122b = new C0435n0(this, w02, o02);
            this.f2125e = z4;
        }
    }

    public abstract c A();

    @Override // M2.r
    public final void c(K2.l0 l0Var) {
        Z1.m.e(!l0Var.o(), "Should not cancel with OK status");
        this.f2126f = true;
        w().c(l0Var);
    }

    @Override // M2.r
    public void f(int i4) {
        A().x(i4);
    }

    @Override // M2.r
    public void g(int i4) {
        this.f2122b.g(i4);
    }

    @Override // M2.r
    public void h(C0371t c0371t) {
        K2.Z z4 = this.f2125e;
        Z.g gVar = S.f1958d;
        z4.e(gVar);
        this.f2125e.p(gVar, Long.valueOf(Math.max(0L, c0371t.o(TimeUnit.NANOSECONDS))));
    }

    @Override // M2.r
    public final void i(InterfaceC0443s interfaceC0443s) {
        A().K(interfaceC0443s);
        if (this.f2124d) {
            return;
        }
        w().d(this.f2125e, null);
        this.f2125e = null;
    }

    @Override // M2.AbstractC0412c, M2.P0
    public final boolean j() {
        return super.j() && !this.f2126f;
    }

    @Override // M2.C0435n0.d
    public final void k(V0 v02, boolean z4, boolean z5, int i4) {
        Z1.m.e(v02 != null || z4, "null frame before EOS");
        w().e(v02, z4, z5, i4);
    }

    @Override // M2.r
    public final void m() {
        if (A().G()) {
            return;
        }
        A().L();
        s();
    }

    @Override // M2.r
    public final void n(Y y4) {
        y4.b("remote_addr", d().b(K2.C.f1009a));
    }

    @Override // M2.r
    public final void o(C0373v c0373v) {
        A().I(c0373v);
    }

    @Override // M2.r
    public final void r(boolean z4) {
        A().J(z4);
    }

    @Override // M2.AbstractC0412c
    public final P t() {
        return this.f2122b;
    }

    public abstract b w();

    public U0 y() {
        return this.f2121a;
    }

    public final boolean z() {
        return this.f2123c;
    }

    /* JADX INFO: renamed from: M2.a$a, reason: collision with other inner class name */
    public class C0041a implements P {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public K2.Z f2127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final O0 f2129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f2130d;

        public C0041a(K2.Z z4, O0 o02) {
            this.f2127a = (K2.Z) Z1.m.o(z4, "headers");
            this.f2129c = (O0) Z1.m.o(o02, "statsTraceCtx");
        }

        @Override // M2.P
        public boolean c() {
            return this.f2128b;
        }

        @Override // M2.P
        public void close() {
            this.f2128b = true;
            Z1.m.u(this.f2130d != null, "Lack of request message. GET request is only supported for unary requests");
            AbstractC0408a.this.w().d(this.f2127a, this.f2130d);
            this.f2130d = null;
            this.f2127a = null;
        }

        @Override // M2.P
        public void d(InputStream inputStream) {
            Z1.m.u(this.f2130d == null, "writePayload should not be called multiple times");
            try {
                this.f2130d = b2.b.d(inputStream);
                this.f2129c.i(0);
                O0 o02 = this.f2129c;
                byte[] bArr = this.f2130d;
                o02.j(0, bArr.length, bArr.length);
                this.f2129c.k(this.f2130d.length);
                this.f2129c.l(this.f2130d.length);
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
        }

        @Override // M2.P
        public void flush() {
        }

        @Override // M2.P
        public P a(boolean z4) {
            return this;
        }

        @Override // M2.P
        public P b(InterfaceC0366n interfaceC0366n) {
            return this;
        }

        @Override // M2.P
        public void g(int i4) {
        }
    }
}
