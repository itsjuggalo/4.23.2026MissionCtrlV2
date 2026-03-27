package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f11224a = 100;

    public abstract void a(Object obj, int i8, int i9);

    public abstract void b(Object obj, int i8, long j8);

    public abstract void c(Object obj, int i8, Object obj2);

    public abstract void d(Object obj, int i8, AbstractC1104f abstractC1104f);

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

    public final boolean m(Object obj, X x8, int i8) throws C1119v {
        int iA = x8.a();
        int iA2 = k0.a(iA);
        int iB = k0.b(iA);
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
                throw C1119v.e();
            }
            a(obj, iA2, x8.h());
            return true;
        }
        Object objN = n();
        int iC = k0.c(iA2, 4);
        int i9 = i8 + 1;
        if (i9 >= f11224a) {
            throw C1119v.i();
        }
        l(objN, x8, i9);
        if (iC != x8.a()) {
            throw C1119v.b();
        }
        c(obj, iA2, r(objN));
        return true;
    }

    public abstract Object n();

    public abstract void o(Object obj, Object obj2);

    public abstract void p(Object obj, Object obj2);

    public abstract boolean q(X x8);

    public abstract Object r(Object obj);

    public abstract void s(Object obj, l0 l0Var);

    public abstract void t(Object obj, l0 l0Var);
}
