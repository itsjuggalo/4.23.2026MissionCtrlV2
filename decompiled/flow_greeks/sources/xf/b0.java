package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 extends a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f24935b;

    public b0(c1 delegate) {
        kotlin.jvm.internal.t.f(delegate, "delegate");
        this.f24935b = delegate;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: U0 */
    public c1 R0(boolean z10) {
        return z10 == O0() ? this : W0().R0(z10).T0(M0());
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: V0 */
    public c1 T0(q1 newAttributes) {
        kotlin.jvm.internal.t.f(newAttributes, "newAttributes");
        return newAttributes != M0() ? new e1(this, newAttributes) : this;
    }

    @Override // xf.a0
    public c1 W0() {
        return this.f24935b;
    }
}
