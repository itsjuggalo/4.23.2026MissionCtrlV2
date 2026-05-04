package xf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i0 extends l2 implements bg.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f24983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c1 f24984c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(c1 lowerBound, c1 upperBound) {
        super(null);
        kotlin.jvm.internal.t.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.t.f(upperBound, "upperBound");
        this.f24983b = lowerBound;
        this.f24984c = upperBound;
    }

    @Override // xf.r0
    public List L0() {
        return U0().L0();
    }

    @Override // xf.r0
    public q1 M0() {
        return U0().M0();
    }

    @Override // xf.r0
    public u1 N0() {
        return U0().N0();
    }

    @Override // xf.r0
    public boolean O0() {
        return U0().O0();
    }

    public abstract c1 U0();

    public final c1 V0() {
        return this.f24983b;
    }

    public final c1 W0() {
        return this.f24984c;
    }

    public abstract String X0(hf.n nVar, hf.w wVar);

    @Override // xf.r0
    public qf.k q() {
        return U0().q();
    }

    public String toString() {
        return hf.n.f11357k.S(this);
    }
}
