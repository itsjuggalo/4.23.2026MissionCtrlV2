package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f1829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e1 f1830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f1832d;

    public n0(e1 e1Var, n nVar, j0 j0Var) {
        this.f1830b = e1Var;
        this.f1831c = nVar.e(j0Var);
        this.f1832d = nVar;
        this.f1829a = j0Var;
    }

    private int j(e1 e1Var, Object obj) {
        return e1Var.i(e1Var.g(obj));
    }

    private void k(e1 e1Var, n nVar, Object obj, w0 w0Var, m mVar) throws Throwable {
        e1 e1Var2;
        Object objF = e1Var.f(obj);
        q qVarD = nVar.d(obj);
        while (w0Var.w() != Integer.MAX_VALUE) {
            try {
                e1Var2 = e1Var;
                n nVar2 = nVar;
                w0 w0Var2 = w0Var;
                m mVar2 = mVar;
                try {
                    if (!m(w0Var2, mVar2, nVar2, qVarD, e1Var2, objF)) {
                        e1Var2.o(obj, objF);
                        return;
                    }
                    w0Var = w0Var2;
                    mVar = mVar2;
                    nVar = nVar2;
                    e1Var = e1Var2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    e1Var2.o(obj, objF);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                e1Var2 = e1Var;
            }
        }
        e1Var.o(obj, objF);
    }

    public static n0 l(e1 e1Var, n nVar, j0 j0Var) {
        return new n0(e1Var, nVar, j0Var);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void a(Object obj, Object obj2) {
        z0.F(this.f1830b, obj, obj2);
        if (this.f1831c) {
            z0.D(this.f1832d, obj, obj2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void b(Object obj) {
        this.f1830b.j(obj);
        this.f1832d.f(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public final boolean c(Object obj) {
        return this.f1832d.c(obj).k();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public boolean d(Object obj, Object obj2) {
        if (!this.f1830b.g(obj).equals(this.f1830b.g(obj2))) {
            return false;
        }
        if (this.f1831c) {
            return this.f1832d.c(obj).equals(this.f1832d.c(obj2));
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int e(Object obj) {
        int iJ = j(this.f1830b, obj);
        return this.f1831c ? iJ + this.f1832d.c(obj).f() : iJ;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public Object f() {
        j0 j0Var = this.f1829a;
        return j0Var instanceof t ? ((t) j0Var).I() : j0Var.c().e();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int g(Object obj) {
        int iHashCode = this.f1830b.g(obj).hashCode();
        return this.f1831c ? (iHashCode * 53) + this.f1832d.c(obj).hashCode() : iHashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void h(Object obj, w0 w0Var, m mVar) throws Throwable {
        k(this.f1830b, this.f1832d, obj, w0Var, mVar);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void i(Object obj, k1 k1Var) {
        Iterator itN = this.f1832d.c(obj).n();
        if (itN.hasNext()) {
            android.support.v4.media.session.b.a(((Map.Entry) itN.next()).getKey());
            throw null;
        }
        n(this.f1830b, obj, k1Var);
    }

    public final boolean m(w0 w0Var, m mVar, n nVar, q qVar, e1 e1Var, Object obj) throws v {
        int iA = w0Var.a();
        int iL = 0;
        if (iA != j1.f1764a) {
            if (j1.b(iA) != 2) {
                return w0Var.C();
            }
            Object objB = nVar.b(mVar, this.f1829a, j1.a(iA));
            if (objB == null) {
                return e1Var.m(obj, w0Var, 0);
            }
            nVar.h(w0Var, objB, mVar, qVar);
            return true;
        }
        Object objB2 = null;
        f fVarZ = null;
        while (w0Var.w() != Integer.MAX_VALUE) {
            int iA2 = w0Var.a();
            if (iA2 == j1.f1766c) {
                iL = w0Var.l();
                objB2 = nVar.b(mVar, this.f1829a, iL);
            } else if (iA2 == j1.f1767d) {
                if (objB2 != null) {
                    nVar.h(w0Var, objB2, mVar, qVar);
                } else {
                    fVarZ = w0Var.z();
                }
            } else if (!w0Var.C()) {
                break;
            }
        }
        if (w0Var.a() != j1.f1765b) {
            throw v.b();
        }
        if (fVarZ != null) {
            if (objB2 != null) {
                nVar.i(fVarZ, objB2, mVar, qVar);
            } else {
                e1Var.d(obj, iL, fVarZ);
            }
        }
        return true;
    }

    public final void n(e1 e1Var, Object obj, k1 k1Var) {
        e1Var.s(e1Var.g(obj), k1Var);
    }
}
