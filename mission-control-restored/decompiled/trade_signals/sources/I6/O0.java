package I6;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class O0 extends S {
    public O0() {
        super(null);
    }

    @Override // I6.S
    public List M0() {
        return S0().M0();
    }

    @Override // I6.S
    public r0 N0() {
        return S0().N0();
    }

    @Override // I6.S
    public v0 O0() {
        return S0().O0();
    }

    @Override // I6.S
    public boolean P0() {
        return S0().P0();
    }

    @Override // I6.S
    public final M0 R0() {
        S sS0 = S0();
        while (sS0 instanceof O0) {
            sS0 = ((O0) sS0).S0();
        }
        AbstractC2304t.d(sS0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (M0) sS0;
    }

    public abstract S S0();

    public abstract boolean T0();

    @Override // I6.S
    public B6.k r() {
        return S0().r();
    }

    public String toString() {
        return T0() ? S0().toString() : "<Not computed yet>";
    }
}
