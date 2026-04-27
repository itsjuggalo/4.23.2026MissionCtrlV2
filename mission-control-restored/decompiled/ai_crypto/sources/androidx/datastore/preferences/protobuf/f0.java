package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f7412a = 100;

    public abstract void a(Object obj, int i7, int i8);

    public abstract void b(Object obj, int i7, long j7);

    public abstract void c(Object obj, int i7, Object obj2);

    public abstract void d(Object obj, int i7, AbstractC0935f abstractC0935f);

    public abstract void e(Object obj, int i7, long j7);

    public abstract Object f(Object obj);

    public abstract Object g(Object obj);

    public abstract int h(Object obj);

    public abstract int i(Object obj);

    public abstract void j(Object obj);

    public abstract Object k(Object obj, Object obj2);

    public final void l(Object obj, X x7, int i7) {
        while (x7.w() != Integer.MAX_VALUE && m(obj, x7, i7)) {
        }
    }

    public final boolean m(Object obj, X x7, int i7) throws C0950v {
        int iQ = x7.q();
        int iA = k0.a(iQ);
        int iB = k0.b(iQ);
        if (iB == 0) {
            e(obj, iA, x7.G());
            return true;
        }
        if (iB == 1) {
            b(obj, iA, x7.c());
            return true;
        }
        if (iB == 2) {
            d(obj, iA, x7.z());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw C0950v.e();
            }
            a(obj, iA, x7.g());
            return true;
        }
        Object objN = n();
        int iC = k0.c(iA, 4);
        int i8 = i7 + 1;
        if (i8 >= f7412a) {
            throw C0950v.i();
        }
        l(objN, x7, i8);
        if (iC != x7.q()) {
            throw C0950v.b();
        }
        c(obj, iA, r(objN));
        return true;
    }

    public abstract Object n();

    public abstract void o(Object obj, Object obj2);

    public abstract void p(Object obj, Object obj2);

    public abstract boolean q(X x7);

    public abstract Object r(Object obj);

    public abstract void s(Object obj, l0 l0Var);

    public abstract void t(Object obj, l0 l0Var);
}
