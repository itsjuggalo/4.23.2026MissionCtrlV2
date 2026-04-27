package t5;

import java.util.concurrent.atomic.AtomicBoolean;
import r5.AbstractC2595k;
import r5.C2585a;

/* JADX INFO: loaded from: classes2.dex */
public final class O0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final O0 f23500c = new O0(new r5.o0[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r5.o0[] f23501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f23502b = new AtomicBoolean(false);

    public O0(r5.o0[] o0VarArr) {
        this.f23501a = o0VarArr;
    }

    public static O0 h(AbstractC2595k[] abstractC2595kArr, C2585a c2585a, r5.Z z7) {
        O0 o02 = new O0(abstractC2595kArr);
        for (AbstractC2595k abstractC2595k : abstractC2595kArr) {
            abstractC2595k.n(c2585a, z7);
        }
        return o02;
    }

    public void a() {
        for (r5.o0 o0Var : this.f23501a) {
            ((AbstractC2595k) o0Var).k();
        }
    }

    public void b(r5.Z z7) {
        for (r5.o0 o0Var : this.f23501a) {
            ((AbstractC2595k) o0Var).l(z7);
        }
    }

    public void c() {
        for (r5.o0 o0Var : this.f23501a) {
            ((AbstractC2595k) o0Var).m();
        }
    }

    public void d(int i7) {
        for (r5.o0 o0Var : this.f23501a) {
            o0Var.a(i7);
        }
    }

    public void e(int i7, long j7, long j8) {
        for (r5.o0 o0Var : this.f23501a) {
            o0Var.b(i7, j7, j8);
        }
    }

    public void f(long j7) {
        for (r5.o0 o0Var : this.f23501a) {
            o0Var.c(j7);
        }
    }

    public void g(long j7) {
        for (r5.o0 o0Var : this.f23501a) {
            o0Var.d(j7);
        }
    }

    public void i(int i7) {
        for (r5.o0 o0Var : this.f23501a) {
            o0Var.e(i7);
        }
    }

    public void j(int i7, long j7, long j8) {
        for (r5.o0 o0Var : this.f23501a) {
            o0Var.f(i7, j7, j8);
        }
    }

    public void k(long j7) {
        for (r5.o0 o0Var : this.f23501a) {
            o0Var.g(j7);
        }
    }

    public void l(long j7) {
        for (r5.o0 o0Var : this.f23501a) {
            o0Var.h(j7);
        }
    }

    public void m(r5.l0 l0Var) {
        if (this.f23502b.compareAndSet(false, true)) {
            for (r5.o0 o0Var : this.f23501a) {
                o0Var.i(l0Var);
            }
        }
    }
}
