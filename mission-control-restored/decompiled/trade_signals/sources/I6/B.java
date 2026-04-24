package I6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class B extends A {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC0613d0 f4331b;

    public B(AbstractC0613d0 delegate) {
        AbstractC2304t.f(delegate, "delegate");
        this.f4331b = delegate;
    }

    @Override // I6.M0
    /* JADX INFO: renamed from: V0 */
    public AbstractC0613d0 S0(boolean z7) {
        return z7 == P0() ? this : X0().S0(z7).U0(N0());
    }

    @Override // I6.M0
    /* JADX INFO: renamed from: W0 */
    public AbstractC0613d0 U0(r0 newAttributes) {
        AbstractC2304t.f(newAttributes, "newAttributes");
        return newAttributes != N0() ? new C0617f0(this, newAttributes) : this;
    }

    @Override // I6.A
    public AbstractC0613d0 X0() {
        return this.f4331b;
    }
}
