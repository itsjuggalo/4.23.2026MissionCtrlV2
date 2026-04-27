package G4;

import F4.AbstractC0497k;
import F4.C0487a;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class O0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final O0 f2537c = new O0(new F4.m0[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F4.m0[] f2538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f2539b = new AtomicBoolean(false);

    public O0(F4.m0[] m0VarArr) {
        this.f2538a = m0VarArr;
    }

    public static O0 h(AbstractC0497k[] abstractC0497kArr, C0487a c0487a, F4.X x8) {
        O0 o02 = new O0(abstractC0497kArr);
        for (AbstractC0497k abstractC0497k : abstractC0497kArr) {
            abstractC0497k.n(c0487a, x8);
        }
        return o02;
    }

    public void a() {
        for (F4.m0 m0Var : this.f2538a) {
            ((AbstractC0497k) m0Var).k();
        }
    }

    public void b(F4.X x8) {
        for (F4.m0 m0Var : this.f2538a) {
            ((AbstractC0497k) m0Var).l(x8);
        }
    }

    public void c() {
        for (F4.m0 m0Var : this.f2538a) {
            ((AbstractC0497k) m0Var).m();
        }
    }

    public void d(int i8) {
        for (F4.m0 m0Var : this.f2538a) {
            m0Var.a(i8);
        }
    }

    public void e(int i8, long j8, long j9) {
        for (F4.m0 m0Var : this.f2538a) {
            m0Var.b(i8, j8, j9);
        }
    }

    public void f(long j8) {
        for (F4.m0 m0Var : this.f2538a) {
            m0Var.c(j8);
        }
    }

    public void g(long j8) {
        for (F4.m0 m0Var : this.f2538a) {
            m0Var.d(j8);
        }
    }

    public void i(int i8) {
        for (F4.m0 m0Var : this.f2538a) {
            m0Var.e(i8);
        }
    }

    public void j(int i8, long j8, long j9) {
        for (F4.m0 m0Var : this.f2538a) {
            m0Var.f(i8, j8, j9);
        }
    }

    public void k(long j8) {
        for (F4.m0 m0Var : this.f2538a) {
            m0Var.g(j8);
        }
    }

    public void l(long j8) {
        for (F4.m0 m0Var : this.f2538a) {
            m0Var.h(j8);
        }
    }

    public void m(F4.j0 j0Var) {
        if (this.f2539b.compareAndSet(false, true)) {
            for (F4.m0 m0Var : this.f2538a) {
                m0Var.i(j0Var);
            }
        }
    }
}
