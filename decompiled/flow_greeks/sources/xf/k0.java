package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends i0 implements j2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i0 f24998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r0 f24999e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(i0 origin, r0 enhancement) {
        super(origin.V0(), origin.W0());
        kotlin.jvm.internal.t.f(origin, "origin");
        kotlin.jvm.internal.t.f(enhancement, "enhancement");
        this.f24998d = origin;
        this.f24999e = enhancement;
    }

    @Override // xf.j2
    public r0 I() {
        return this.f24999e;
    }

    @Override // xf.l2
    public l2 R0(boolean z10) {
        return k2.d(F0().R0(z10), I().Q0().R0(z10));
    }

    @Override // xf.l2
    public l2 T0(q1 newAttributes) {
        kotlin.jvm.internal.t.f(newAttributes, "newAttributes");
        return k2.d(F0().T0(newAttributes), I());
    }

    @Override // xf.i0
    public c1 U0() {
        return F0().U0();
    }

    @Override // xf.i0
    public String X0(hf.n renderer, hf.w options) {
        kotlin.jvm.internal.t.f(renderer, "renderer");
        kotlin.jvm.internal.t.f(options, "options");
        return options.f() ? renderer.S(I()) : F0().X0(renderer, options);
    }

    @Override // xf.j2
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public i0 F0() {
        return this.f24998d;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public k0 X0(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        r0 r0VarA = kotlinTypeRefiner.a(F0());
        kotlin.jvm.internal.t.d(r0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return new k0((i0) r0VarA, kotlinTypeRefiner.a(I()));
    }

    @Override // xf.i0
    public String toString() {
        return "[@EnhancedForWarnings(" + I() + ")] " + F0();
    }
}
