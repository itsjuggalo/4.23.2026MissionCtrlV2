package tb;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n2 f21557c = new n2(new rb.n1[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.n1[] f21558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f21559b = new AtomicBoolean(false);

    public n2(rb.n1[] n1VarArr) {
        this.f21558a = n1VarArr;
    }

    public static n2 h(rb.k[] kVarArr, rb.a aVar, rb.y0 y0Var) {
        n2 n2Var = new n2(kVarArr);
        for (rb.k kVar : kVarArr) {
            kVar.n(aVar, y0Var);
        }
        return n2Var;
    }

    public void a() {
        for (rb.n1 n1Var : this.f21558a) {
            ((rb.k) n1Var).k();
        }
    }

    public void b(rb.y0 y0Var) {
        for (rb.n1 n1Var : this.f21558a) {
            ((rb.k) n1Var).l(y0Var);
        }
    }

    public void c() {
        for (rb.n1 n1Var : this.f21558a) {
            ((rb.k) n1Var).m();
        }
    }

    public void d(int i10) {
        for (rb.n1 n1Var : this.f21558a) {
            n1Var.a(i10);
        }
    }

    public void e(int i10, long j10, long j11) {
        for (rb.n1 n1Var : this.f21558a) {
            n1Var.b(i10, j10, j11);
        }
    }

    public void f(long j10) {
        for (rb.n1 n1Var : this.f21558a) {
            n1Var.c(j10);
        }
    }

    public void g(long j10) {
        for (rb.n1 n1Var : this.f21558a) {
            n1Var.d(j10);
        }
    }

    public void i(int i10) {
        for (rb.n1 n1Var : this.f21558a) {
            n1Var.e(i10);
        }
    }

    public void j(int i10, long j10, long j11) {
        for (rb.n1 n1Var : this.f21558a) {
            n1Var.f(i10, j10, j11);
        }
    }

    public void k(long j10) {
        for (rb.n1 n1Var : this.f21558a) {
            n1Var.g(j10);
        }
    }

    public void l(long j10) {
        for (rb.n1 n1Var : this.f21558a) {
            n1Var.h(j10);
        }
    }

    public void m(rb.k1 k1Var) {
        if (this.f21559b.compareAndSet(false, true)) {
            for (rb.n1 n1Var : this.f21558a) {
                n1Var.i(k1Var);
            }
        }
    }
}
