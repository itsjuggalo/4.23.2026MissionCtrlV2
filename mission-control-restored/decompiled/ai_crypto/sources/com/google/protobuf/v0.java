package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f12859a = 100;

    public abstract void a(Object obj, int i7, int i8);

    public abstract void b(Object obj, int i7, long j7);

    public abstract void c(Object obj, int i7, Object obj2);

    public abstract void d(Object obj, int i7, AbstractC1240i abstractC1240i);

    public abstract void e(Object obj, int i7, long j7);

    public abstract Object f(Object obj);

    public abstract Object g(Object obj);

    public abstract int h(Object obj);

    public abstract int i(Object obj);

    public abstract void j(Object obj);

    public abstract Object k(Object obj, Object obj2);

    public final void l(Object obj, l0 l0Var, int i7) {
        while (l0Var.w() != Integer.MAX_VALUE && m(obj, l0Var, i7)) {
        }
    }

    public final boolean m(Object obj, l0 l0Var, int i7) throws D {
        int iQ = l0Var.q();
        int iA = B0.a(iQ);
        int iB = B0.b(iQ);
        if (iB == 0) {
            e(obj, iA, l0Var.G());
            return true;
        }
        if (iB == 1) {
            b(obj, iA, l0Var.c());
            return true;
        }
        if (iB == 2) {
            d(obj, iA, l0Var.z());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw D.e();
            }
            a(obj, iA, l0Var.g());
            return true;
        }
        Object objN = n();
        int iC = B0.c(iA, 4);
        int i8 = i7 + 1;
        if (i8 >= f12859a) {
            throw D.i();
        }
        l(objN, l0Var, i8);
        if (iC != l0Var.q()) {
            throw D.b();
        }
        c(obj, iA, r(objN));
        return true;
    }

    public abstract Object n();

    public abstract void o(Object obj, Object obj2);

    public abstract void p(Object obj, Object obj2);

    public abstract boolean q(l0 l0Var);

    public abstract Object r(Object obj);

    public abstract void s(Object obj, C0 c02);

    public abstract void t(Object obj, C0 c02);
}
