package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class N implements Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J f6945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f6946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0801n f6948d;

    public N(f0 f0Var, AbstractC0801n abstractC0801n, J j4) {
        this.f6946b = f0Var;
        this.f6947c = abstractC0801n.e(j4);
        this.f6948d = abstractC0801n;
        this.f6945a = j4;
    }

    private int j(f0 f0Var, Object obj) {
        return f0Var.i(f0Var.g(obj));
    }

    private void k(f0 f0Var, AbstractC0801n abstractC0801n, Object obj, X x4, C0800m c0800m) throws Throwable {
        f0 f0Var2;
        Object objF = f0Var.f(obj);
        C0804q c0804qD = abstractC0801n.d(obj);
        while (x4.w() != Integer.MAX_VALUE) {
            try {
                f0Var2 = f0Var;
                AbstractC0801n abstractC0801n2 = abstractC0801n;
                X x5 = x4;
                C0800m c0800m2 = c0800m;
                try {
                    if (!m(x5, c0800m2, abstractC0801n2, c0804qD, f0Var2, objF)) {
                        f0Var2.o(obj, objF);
                        return;
                    }
                    x4 = x5;
                    c0800m = c0800m2;
                    abstractC0801n = abstractC0801n2;
                    f0Var = f0Var2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    f0Var2.o(obj, objF);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                f0Var2 = f0Var;
            }
        }
        f0Var.o(obj, objF);
    }

    public static N l(f0 f0Var, AbstractC0801n abstractC0801n, J j4) {
        return new N(f0Var, abstractC0801n, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void a(Object obj, Object obj2) {
        a0.F(this.f6946b, obj, obj2);
        if (this.f6947c) {
            a0.D(this.f6948d, obj, obj2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void b(Object obj) {
        this.f6946b.j(obj);
        this.f6948d.f(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public final boolean c(Object obj) {
        return this.f6948d.c(obj).k();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public boolean d(Object obj, Object obj2) {
        if (!this.f6946b.g(obj).equals(this.f6946b.g(obj2))) {
            return false;
        }
        if (this.f6947c) {
            return this.f6948d.c(obj).equals(this.f6948d.c(obj2));
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public int e(Object obj) {
        int iJ = j(this.f6946b, obj);
        return this.f6947c ? iJ + this.f6948d.c(obj).f() : iJ;
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public Object f() {
        J j4 = this.f6945a;
        return j4 instanceof AbstractC0806t ? ((AbstractC0806t) j4).E() : j4.newBuilderForType().buildPartial();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public int g(Object obj) {
        int iHashCode = this.f6946b.g(obj).hashCode();
        return this.f6947c ? (iHashCode * 53) + this.f6948d.c(obj).hashCode() : iHashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void h(Object obj, X x4, C0800m c0800m) throws Throwable {
        k(this.f6946b, this.f6948d, obj, x4, c0800m);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void i(Object obj, l0 l0Var) {
        Iterator itN = this.f6948d.c(obj).n();
        if (itN.hasNext()) {
            android.support.v4.media.session.b.a(((Map.Entry) itN.next()).getKey());
            throw null;
        }
        n(this.f6946b, obj, l0Var);
    }

    public final boolean m(X x4, C0800m c0800m, AbstractC0801n abstractC0801n, C0804q c0804q, f0 f0Var, Object obj) throws C0808v {
        int iQ = x4.q();
        int iK = 0;
        if (iQ != k0.f7075a) {
            if (k0.b(iQ) != 2) {
                return x4.C();
            }
            Object objB = abstractC0801n.b(c0800m, this.f6945a, k0.a(iQ));
            if (objB == null) {
                return f0Var.m(obj, x4, 0);
            }
            abstractC0801n.h(x4, objB, c0800m, c0804q);
            return true;
        }
        Object objB2 = null;
        AbstractC0793f abstractC0793fZ = null;
        while (x4.w() != Integer.MAX_VALUE) {
            int iQ2 = x4.q();
            if (iQ2 == k0.f7077c) {
                iK = x4.k();
                objB2 = abstractC0801n.b(c0800m, this.f6945a, iK);
            } else if (iQ2 == k0.f7078d) {
                if (objB2 != null) {
                    abstractC0801n.h(x4, objB2, c0800m, c0804q);
                } else {
                    abstractC0793fZ = x4.z();
                }
            } else if (!x4.C()) {
                break;
            }
        }
        if (x4.q() != k0.f7076b) {
            throw C0808v.b();
        }
        if (abstractC0793fZ != null) {
            if (objB2 != null) {
                abstractC0801n.i(abstractC0793fZ, objB2, c0800m, c0804q);
            } else {
                f0Var.d(obj, iK, abstractC0793fZ);
            }
        }
        return true;
    }

    public final void n(f0 f0Var, Object obj, l0 l0Var) {
        f0Var.s(f0Var.g(obj), l0Var);
    }
}
