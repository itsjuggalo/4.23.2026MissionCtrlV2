package I6;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A extends AbstractC0613d0 {
    @Override // I6.S
    public List M0() {
        return X0().M0();
    }

    @Override // I6.S
    public r0 N0() {
        return X0().N0();
    }

    @Override // I6.S
    public v0 O0() {
        return X0().O0();
    }

    @Override // I6.S
    public boolean P0() {
        return X0().P0();
    }

    public abstract AbstractC0613d0 X0();

    @Override // I6.M0
    public AbstractC0613d0 Y0(J6.g kotlinTypeRefiner) {
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        S sA = kotlinTypeRefiner.a(X0());
        AbstractC2304t.d(sA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return Z0((AbstractC0613d0) sA);
    }

    public abstract A Z0(AbstractC0613d0 abstractC0613d0);

    @Override // I6.S
    public B6.k r() {
        return X0().r();
    }
}
