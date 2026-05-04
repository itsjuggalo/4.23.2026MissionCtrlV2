package xf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 implements ge.a, bg.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25044a;

    public /* synthetic */ r0(kotlin.jvm.internal.k kVar) {
        this();
    }

    public final int K0() {
        return v0.a(this) ? super.hashCode() : (((N0().hashCode() * 31) + L0().hashCode()) * 31) + (O0() ? 1 : 0);
    }

    public abstract List L0();

    public abstract q1 M0();

    public abstract u1 N0();

    public abstract boolean O0();

    public abstract r0 P0(yf.g gVar);

    public abstract l2 Q0();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return O0() == r0Var.O0() && yf.t.f25430a.a(Q0(), r0Var.Q0());
    }

    @Override // ge.a
    public ge.h getAnnotations() {
        return t.a(M0());
    }

    public final int hashCode() {
        int i10 = this.f25044a;
        if (i10 != 0) {
            return i10;
        }
        int iK0 = K0();
        this.f25044a = iK0;
        return iK0;
    }

    public abstract qf.k q();

    public r0() {
    }
}
