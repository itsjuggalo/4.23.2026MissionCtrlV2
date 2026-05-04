package tb;

import io.flutter.plugins.firebase.database.Constants;
import java.io.InputStream;
import rb.l;
import tb.e;
import tb.l1;
import tb.p2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements o2 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a implements e.h, l1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z f21071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f21072b = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final n2 f21073c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final t2 f21074d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final l1 f21075e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f21076f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f21077g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f21078h;

        /* JADX INFO: renamed from: tb.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class RunnableC0372a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ bc.b f21079a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f21080b;

            public RunnableC0372a(bc.b bVar, int i10) {
                this.f21079a = bVar;
                this.f21080b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    bc.e eVarH = bc.c.h("AbstractStream.request");
                    try {
                        bc.c.e(this.f21079a);
                        a.this.f21071a.b(this.f21080b);
                        if (eVarH != null) {
                            eVarH.close();
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    a.this.e(th);
                }
            }
        }

        public a(int i10, n2 n2Var, t2 t2Var) {
            this.f21073c = (n2) p6.n.o(n2Var, "statsTraceCtx");
            this.f21074d = (t2) p6.n.o(t2Var, "transportTracer");
            l1 l1Var = new l1(this, l.b.f19636a, i10, n2Var, t2Var);
            this.f21075e = l1Var;
            this.f21071a = l1Var;
        }

        @Override // tb.l1.b
        public void a(p2.a aVar) {
            o().a(aVar);
        }

        public final void b(int i10) {
            boolean z10;
            synchronized (this.f21072b) {
                p6.n.u(this.f21077g, "onStreamAllocated was not called, but it seems the stream is active");
                int i11 = this.f21076f;
                z10 = false;
                boolean z11 = i11 < 32768;
                int i12 = i11 - i10;
                this.f21076f = i12;
                boolean z12 = i12 < 32768;
                if (!z11 && z12) {
                    z10 = true;
                }
            }
            if (z10) {
                p();
            }
        }

        public final void k(boolean z10) {
            if (z10) {
                this.f21071a.close();
            } else {
                this.f21071a.u();
            }
        }

        public final void l(x1 x1Var) {
            try {
                this.f21071a.e(x1Var);
            } catch (Throwable th) {
                e(th);
            }
        }

        public t2 m() {
            return this.f21074d;
        }

        public final boolean n() {
            boolean z10;
            synchronized (this.f21072b) {
                try {
                    z10 = this.f21077g && this.f21076f < 32768 && !this.f21078h;
                } finally {
                }
            }
            return z10;
        }

        public abstract p2 o();

        public final void p() {
            boolean zN;
            synchronized (this.f21072b) {
                zN = n();
            }
            if (zN) {
                o().b();
            }
        }

        public final void q(int i10) {
            synchronized (this.f21072b) {
                this.f21076f += i10;
            }
        }

        public void r() {
            p6.n.t(o() != null);
            synchronized (this.f21072b) {
                p6.n.u(!this.f21077g, "Already allocated");
                this.f21077g = true;
            }
            p();
        }

        public final void s() {
            synchronized (this.f21072b) {
                this.f21078h = true;
            }
        }

        public final void t() {
            this.f21075e.a0(this);
            this.f21071a = this.f21075e;
        }

        public final void u(int i10) {
            f(new RunnableC0372a(bc.c.f(), i10));
        }

        public final void v(rb.u uVar) {
            this.f21071a.o(uVar);
        }

        public void w(s0 s0Var) {
            this.f21075e.Z(s0Var);
            this.f21071a = new e(this, this, this.f21075e);
        }

        public final void x(int i10) {
            this.f21071a.c(i10);
        }
    }

    @Override // tb.o2
    public final void a(rb.n nVar) {
        r().a((rb.n) p6.n.o(nVar, "compressor"));
    }

    @Override // tb.o2
    public final void b(int i10) {
        t().u(i10);
    }

    @Override // tb.o2
    public boolean f() {
        return t().n();
    }

    @Override // tb.o2
    public final void flush() {
        if (r().isClosed()) {
            return;
        }
        r().flush();
    }

    @Override // tb.o2
    public final void n(InputStream inputStream) {
        p6.n.o(inputStream, Constants.ERROR_MESSAGE);
        try {
            if (!r().isClosed()) {
                r().b(inputStream);
            }
        } finally {
            r0.d(inputStream);
        }
    }

    @Override // tb.o2
    public void o() {
        t().t();
    }

    public final void q() {
        r().close();
    }

    public abstract p0 r();

    public final void s(int i10) {
        t().q(i10);
    }

    public abstract a t();
}
