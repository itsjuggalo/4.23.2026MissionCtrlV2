package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f1681a = 100;

    public abstract void a(Object obj, int i10, int i11);

    public abstract void b(Object obj, int i10, long j10);

    public abstract void c(Object obj, int i10, Object obj2);

    public abstract void d(Object obj, int i10, f fVar);

    public abstract void e(Object obj, int i10, long j10);

    public abstract Object f(Object obj);

    public abstract Object g(Object obj);

    public abstract int h(Object obj);

    public abstract int i(Object obj);

    public abstract void j(Object obj);

    public abstract Object k(Object obj, Object obj2);

    public final void l(Object obj, w0 w0Var, int i10) {
        while (w0Var.w() != Integer.MAX_VALUE && m(obj, w0Var, i10)) {
        }
    }

    public final boolean m(Object obj, w0 w0Var, int i10) throws v {
        int iA = w0Var.a();
        int iA2 = j1.a(iA);
        int iB = j1.b(iA);
        if (iB == 0) {
            e(obj, iA2, w0Var.G());
            return true;
        }
        if (iB == 1) {
            b(obj, iA2, w0Var.d());
            return true;
        }
        if (iB == 2) {
            d(obj, iA2, w0Var.z());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw v.e();
            }
            a(obj, iA2, w0Var.h());
            return true;
        }
        Object objN = n();
        int iC = j1.c(iA2, 4);
        int i11 = i10 + 1;
        if (i11 >= f1681a) {
            throw v.i();
        }
        l(objN, w0Var, i11);
        if (iC != w0Var.a()) {
            throw v.b();
        }
        c(obj, iA2, r(objN));
        return true;
    }

    public abstract Object n();

    public abstract void o(Object obj, Object obj2);

    public abstract void p(Object obj, Object obj2);

    public abstract boolean q(w0 w0Var);

    public abstract Object r(Object obj);

    public abstract void s(Object obj, k1 k1Var);

    public abstract void t(Object obj, k1 k1Var);
}
