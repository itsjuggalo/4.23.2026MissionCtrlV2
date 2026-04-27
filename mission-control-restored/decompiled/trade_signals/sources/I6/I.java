package I6;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class I extends M0 implements M6.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC0613d0 f4350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC0613d0 f4351c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(AbstractC0613d0 lowerBound, AbstractC0613d0 upperBound) {
        super(null);
        AbstractC2304t.f(lowerBound, "lowerBound");
        AbstractC2304t.f(upperBound, "upperBound");
        this.f4350b = lowerBound;
        this.f4351c = upperBound;
    }

    @Override // I6.S
    public List M0() {
        return V0().M0();
    }

    @Override // I6.S
    public r0 N0() {
        return V0().N0();
    }

    @Override // I6.S
    public v0 O0() {
        return V0().O0();
    }

    @Override // I6.S
    public boolean P0() {
        return V0().P0();
    }

    public abstract AbstractC0613d0 V0();

    public final AbstractC0613d0 W0() {
        return this.f4350b;
    }

    public final AbstractC0613d0 X0() {
        return this.f4351c;
    }

    public abstract String Y0(t6.n nVar, t6.w wVar);

    @Override // I6.S
    public B6.k r() {
        return V0().r();
    }

    public String toString() {
        return t6.n.f23389k.S(this);
    }
}
