package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends i0 implements w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f24992e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f24993f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24994d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(c1 lowerBound, c1 upperBound) {
        super(lowerBound, upperBound);
        kotlin.jvm.internal.t.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.t.f(upperBound, "upperBound");
    }

    @Override // xf.l2
    public l2 R0(boolean z10) {
        return u0.e(V0().R0(z10), W0().R0(z10));
    }

    @Override // xf.l2
    public l2 T0(q1 newAttributes) {
        kotlin.jvm.internal.t.f(newAttributes, "newAttributes");
        return u0.e(V0().T0(newAttributes), W0().T0(newAttributes));
    }

    @Override // xf.i0
    public c1 U0() {
        Z0();
        return V0();
    }

    @Override // xf.i0
    public String X0(hf.n renderer, hf.w options) {
        kotlin.jvm.internal.t.f(renderer, "renderer");
        kotlin.jvm.internal.t.f(options, "options");
        if (!options.n()) {
            return renderer.P(renderer.S(V0()), renderer.S(W0()), cg.d.n(this));
        }
        return '(' + renderer.S(V0()) + ".." + renderer.S(W0()) + ')';
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public i0 X0(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        r0 r0VarA = kotlinTypeRefiner.a(V0());
        kotlin.jvm.internal.t.d(r0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        r0 r0VarA2 = kotlinTypeRefiner.a(W0());
        kotlin.jvm.internal.t.d(r0VarA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new j0((c1) r0VarA, (c1) r0VarA2);
    }

    public final void Z0() {
        if (!f24993f || this.f24994d) {
            return;
        }
        this.f24994d = true;
        l0.b(V0());
        l0.b(W0());
        kotlin.jvm.internal.t.b(V0(), W0());
        yf.e.f25402a.c(V0(), W0());
    }

    @Override // xf.i0
    public String toString() {
        return '(' + V0() + ".." + W0() + ')';
    }

    @Override // xf.w
    public r0 w(r0 replacement) {
        l2 l2VarE;
        kotlin.jvm.internal.t.f(replacement, "replacement");
        l2 l2VarQ0 = replacement.Q0();
        if (l2VarQ0 instanceof i0) {
            l2VarE = l2VarQ0;
        } else {
            if (!(l2VarQ0 instanceof c1)) {
                throw new cd.o();
            }
            c1 c1Var = (c1) l2VarQ0;
            l2VarE = u0.e(c1Var, c1Var.R0(true));
        }
        return k2.b(l2VarE, l2VarQ0);
    }

    @Override // xf.w
    public boolean z0() {
        return (V0().N0().b() instanceof fe.l1) && kotlin.jvm.internal.t.b(V0().N0(), W0().N0());
    }
}
