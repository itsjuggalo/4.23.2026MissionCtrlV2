package M2;

import K2.AbstractC0363k;
import K2.C0353a;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class O0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final O0 f1949c = new O0(new K2.o0[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.o0[] f1950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f1951b = new AtomicBoolean(false);

    public O0(K2.o0[] o0VarArr) {
        this.f1950a = o0VarArr;
    }

    public static O0 h(AbstractC0363k[] abstractC0363kArr, C0353a c0353a, K2.Z z4) {
        O0 o02 = new O0(abstractC0363kArr);
        for (AbstractC0363k abstractC0363k : abstractC0363kArr) {
            abstractC0363k.n(c0353a, z4);
        }
        return o02;
    }

    public void a() {
        for (K2.o0 o0Var : this.f1950a) {
            ((AbstractC0363k) o0Var).k();
        }
    }

    public void b(K2.Z z4) {
        for (K2.o0 o0Var : this.f1950a) {
            ((AbstractC0363k) o0Var).l(z4);
        }
    }

    public void c() {
        for (K2.o0 o0Var : this.f1950a) {
            ((AbstractC0363k) o0Var).m();
        }
    }

    public void d(int i4) {
        for (K2.o0 o0Var : this.f1950a) {
            o0Var.a(i4);
        }
    }

    public void e(int i4, long j4, long j5) {
        for (K2.o0 o0Var : this.f1950a) {
            o0Var.b(i4, j4, j5);
        }
    }

    public void f(long j4) {
        for (K2.o0 o0Var : this.f1950a) {
            o0Var.c(j4);
        }
    }

    public void g(long j4) {
        for (K2.o0 o0Var : this.f1950a) {
            o0Var.d(j4);
        }
    }

    public void i(int i4) {
        for (K2.o0 o0Var : this.f1950a) {
            o0Var.e(i4);
        }
    }

    public void j(int i4, long j4, long j5) {
        for (K2.o0 o0Var : this.f1950a) {
            o0Var.f(i4, j4, j5);
        }
    }

    public void k(long j4) {
        for (K2.o0 o0Var : this.f1950a) {
            o0Var.g(j4);
        }
    }

    public void l(long j4) {
        for (K2.o0 o0Var : this.f1950a) {
            o0Var.h(j4);
        }
    }

    public void m(K2.l0 l0Var) {
        if (this.f1951b.compareAndSet(false, true)) {
            for (K2.o0 o0Var : this.f1950a) {
                o0Var.i(l0Var);
            }
        }
    }
}
