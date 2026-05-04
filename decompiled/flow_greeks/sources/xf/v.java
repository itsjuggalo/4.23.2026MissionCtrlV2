package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25084a;

    @Override // xf.u1
    public abstract fe.h b();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u1) || obj.hashCode() != hashCode()) {
            return false;
        }
        u1 u1Var = (u1) obj;
        if (u1Var.getParameters().size() != getParameters().size()) {
            return false;
        }
        fe.h hVarB = b();
        fe.h hVarB2 = u1Var.b();
        if (hVarB2 != null && g(hVarB) && g(hVarB2)) {
            return h(hVarB2);
        }
        return false;
    }

    public final boolean f(fe.h first, fe.h second) {
        kotlin.jvm.internal.t.f(first, "first");
        kotlin.jvm.internal.t.f(second, "second");
        if (!kotlin.jvm.internal.t.b(first.getName(), second.getName())) {
            return false;
        }
        fe.m mVarB = first.b();
        for (fe.m mVarB2 = second.b(); mVarB != null && mVarB2 != null; mVarB2 = mVarB2.b()) {
            if (mVarB instanceof fe.h0) {
                return mVarB2 instanceof fe.h0;
            }
            if (mVarB2 instanceof fe.h0) {
                return false;
            }
            if (mVarB instanceof fe.n0) {
                return (mVarB2 instanceof fe.n0) && kotlin.jvm.internal.t.b(((fe.n0) mVarB).e(), ((fe.n0) mVarB2).e());
            }
            if ((mVarB2 instanceof fe.n0) || !kotlin.jvm.internal.t.b(mVarB.getName(), mVarB2.getName())) {
                return false;
            }
            mVarB = mVarB.b();
        }
        return true;
    }

    public final boolean g(fe.h hVar) {
        return (zf.l.m(hVar) || jf.i.E(hVar)) ? false : true;
    }

    public abstract boolean h(fe.h hVar);

    public int hashCode() {
        int i10 = this.f25084a;
        if (i10 != 0) {
            return i10;
        }
        fe.h hVarB = b();
        int iHashCode = g(hVarB) ? jf.i.m(hVarB).hashCode() : System.identityHashCode(this);
        this.f25084a = iHashCode;
        return iHashCode;
    }
}
