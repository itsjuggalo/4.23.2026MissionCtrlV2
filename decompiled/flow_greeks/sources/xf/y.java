package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends a0 implements w, bg.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f25097d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f25098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f25099c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static /* synthetic */ y c(a aVar, l2 l2Var, boolean z10, boolean z11, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            if ((i10 & 4) != 0) {
                z11 = false;
            }
            return aVar.b(l2Var, z10, z11);
        }

        public final boolean a(l2 l2Var) {
            l2Var.N0();
            return (l2Var.N0().b() instanceof fe.l1) || (l2Var instanceof yf.i);
        }

        public final y b(l2 type, boolean z10, boolean z11) {
            kotlin.jvm.internal.t.f(type, "type");
            if (type instanceof y) {
                return (y) type;
            }
            kotlin.jvm.internal.k kVar = null;
            if (!z11 && !d(type, z10)) {
                return null;
            }
            if (type instanceof i0) {
                i0 i0Var = (i0) type;
                kotlin.jvm.internal.t.b(i0Var.V0().N0(), i0Var.W0().N0());
            }
            return new y(l0.c(type).R0(false), z10, kVar);
        }

        public final boolean d(l2 l2Var, boolean z10) {
            if (!a(l2Var)) {
                return false;
            }
            fe.h hVarB = l2Var.N0().b();
            ie.t0 t0Var = hVarB instanceof ie.t0 ? (ie.t0) hVarB : null;
            if (t0Var == null || t0Var.T0()) {
                return (z10 && (l2Var.N0().b() instanceof fe.l1)) ? i2.l(l2Var) : !yf.r.f25428a.a(l2Var);
            }
            return true;
        }

        public a() {
        }
    }

    public /* synthetic */ y(c1 c1Var, boolean z10, kotlin.jvm.internal.k kVar) {
        this(c1Var, z10);
    }

    @Override // xf.a0, xf.r0
    public boolean O0() {
        return false;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: U0 */
    public c1 R0(boolean z10) {
        return z10 ? W0().R0(z10) : this;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: V0 */
    public c1 T0(q1 newAttributes) {
        kotlin.jvm.internal.t.f(newAttributes, "newAttributes");
        return new y(W0().T0(newAttributes), this.f25099c);
    }

    @Override // xf.a0
    public c1 W0() {
        return this.f25098b;
    }

    public final c1 Z0() {
        return this.f25098b;
    }

    @Override // xf.a0
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public y Y0(c1 delegate) {
        kotlin.jvm.internal.t.f(delegate, "delegate");
        return new y(delegate, this.f25099c);
    }

    @Override // xf.c1
    public String toString() {
        return W0() + " & Any";
    }

    @Override // xf.w
    public r0 w(r0 replacement) {
        kotlin.jvm.internal.t.f(replacement, "replacement");
        return g1.e(replacement.Q0(), this.f25099c);
    }

    @Override // xf.w
    public boolean z0() {
        W0().N0();
        return W0().N0().b() instanceof fe.l1;
    }

    public y(c1 c1Var, boolean z10) {
        this.f25098b = c1Var;
        this.f25099c = z10;
    }
}
