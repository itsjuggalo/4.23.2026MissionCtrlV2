package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e1 extends b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q1 f24955c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(c1 delegate, q1 attributes) {
        super(delegate);
        kotlin.jvm.internal.t.f(delegate, "delegate");
        kotlin.jvm.internal.t.f(attributes, "attributes");
        this.f24955c = attributes;
    }

    @Override // xf.a0, xf.r0
    public q1 M0() {
        return this.f24955c;
    }

    @Override // xf.a0
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public e1 Y0(c1 delegate) {
        kotlin.jvm.internal.t.f(delegate, "delegate");
        return new e1(delegate, M0());
    }
}
