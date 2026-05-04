package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f1 extends a0 implements j2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f24960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r0 f24961c;

    public f1(c1 delegate, r0 enhancement) {
        kotlin.jvm.internal.t.f(delegate, "delegate");
        kotlin.jvm.internal.t.f(enhancement, "enhancement");
        this.f24960b = delegate;
        this.f24961c = enhancement;
    }

    @Override // xf.j2
    public r0 I() {
        return this.f24961c;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: U0 */
    public c1 R0(boolean z10) {
        l2 l2VarD = k2.d(F0().R0(z10), I().Q0().R0(z10));
        kotlin.jvm.internal.t.d(l2VarD, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (c1) l2VarD;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: V0 */
    public c1 T0(q1 newAttributes) {
        kotlin.jvm.internal.t.f(newAttributes, "newAttributes");
        l2 l2VarD = k2.d(F0().T0(newAttributes), I());
        kotlin.jvm.internal.t.d(l2VarD, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (c1) l2VarD;
    }

    @Override // xf.a0
    public c1 W0() {
        return this.f24960b;
    }

    @Override // xf.j2
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public c1 F0() {
        return W0();
    }

    @Override // xf.a0
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public f1 X0(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        r0 r0VarA = kotlinTypeRefiner.a(W0());
        kotlin.jvm.internal.t.d(r0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new f1((c1) r0VarA, kotlinTypeRefiner.a(I()));
    }

    @Override // xf.a0
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public f1 Y0(c1 delegate) {
        kotlin.jvm.internal.t.f(delegate, "delegate");
        return new f1(delegate, I());
    }

    @Override // xf.c1
    public String toString() {
        return "[@EnhancedForWarnings(" + I() + ")] " + F0();
    }
}
