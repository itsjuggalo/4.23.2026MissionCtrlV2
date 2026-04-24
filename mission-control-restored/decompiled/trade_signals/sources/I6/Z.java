package I6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class Z extends B {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z(AbstractC0613d0 delegate) {
        super(delegate);
        AbstractC2304t.f(delegate, "delegate");
    }

    @Override // I6.A, I6.S
    public boolean P0() {
        return false;
    }

    @Override // I6.A
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public Z Z0(AbstractC0613d0 delegate) {
        AbstractC2304t.f(delegate, "delegate");
        return new Z(delegate);
    }
}
