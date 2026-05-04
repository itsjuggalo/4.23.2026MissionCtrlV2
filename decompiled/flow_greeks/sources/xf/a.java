package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f24933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c1 f24934c;

    public a(c1 delegate, c1 abbreviation) {
        kotlin.jvm.internal.t.f(delegate, "delegate");
        kotlin.jvm.internal.t.f(abbreviation, "abbreviation");
        this.f24933b = delegate;
        this.f24934c = abbreviation;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: V0 */
    public c1 T0(q1 newAttributes) {
        kotlin.jvm.internal.t.f(newAttributes, "newAttributes");
        return new a(W0().T0(newAttributes), this.f24934c);
    }

    @Override // xf.a0
    public c1 W0() {
        return this.f24933b;
    }

    public final c1 X() {
        return W0();
    }

    public final c1 Z0() {
        return this.f24934c;
    }

    @Override // xf.c1
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public a R0(boolean z10) {
        return new a(W0().R0(z10), this.f24934c.R0(z10));
    }

    @Override // xf.a0
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a X0(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        r0 r0VarA = kotlinTypeRefiner.a(W0());
        kotlin.jvm.internal.t.d(r0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        r0 r0VarA2 = kotlinTypeRefiner.a(this.f24934c);
        kotlin.jvm.internal.t.d(r0VarA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new a((c1) r0VarA, (c1) r0VarA2);
    }

    @Override // xf.a0
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public a Y0(c1 delegate) {
        kotlin.jvm.internal.t.f(delegate, "delegate");
        return new a(delegate, this.f24934c);
    }
}
