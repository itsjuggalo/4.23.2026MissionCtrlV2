package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f16373a = 100;

    public abstract void a(Object obj, int i8, int i9);

    public abstract void b(Object obj, int i8, long j8);

    public abstract void c(Object obj, int i8, Object obj2);

    public abstract void d(Object obj, int i8, AbstractC1467f abstractC1467f);

    public abstract void e(Object obj, int i8, long j8);

    public abstract Object f(Object obj);

    public abstract Object g(Object obj);

    public abstract int h(Object obj);

    public abstract int i(Object obj);

    public abstract void j(Object obj);

    public abstract Object k(Object obj, Object obj2);

    public final void l(Object obj, X x8, int i8) {
        while (x8.w() != Integer.MAX_VALUE && m(obj, x8, i8)) {
        }
    }

    public final boolean m(Object obj, X x8, int i8) throws C1482v {
        int iA = x8.a();
        int iA2 = l0.a(iA);
        int iB = l0.b(iA);
        if (iB == 0) {
            e(obj, iA2, x8.G());
            return true;
        }
        if (iB == 1) {
            b(obj, iA2, x8.d());
            return true;
        }
        if (iB == 2) {
            d(obj, iA2, x8.z());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw C1482v.e();
            }
            a(obj, iA2, x8.h());
            return true;
        }
        Object objN = n();
        int iC = l0.c(iA2, 4);
        int i9 = i8 + 1;
        if (i9 >= f16373a) {
            throw C1482v.i();
        }
        l(objN, x8, i9);
        if (iC != x8.a()) {
            throw C1482v.b();
        }
        c(obj, iA2, r(objN));
        return true;
    }

    public abstract Object n();

    public abstract void o(Object obj, Object obj2);

    public abstract void p(Object obj, Object obj2);

    public abstract boolean q(X x8);

    public abstract Object r(Object obj);

    public abstract void s(Object obj, m0 m0Var);

    public abstract void t(Object obj, m0 m0Var);
}
