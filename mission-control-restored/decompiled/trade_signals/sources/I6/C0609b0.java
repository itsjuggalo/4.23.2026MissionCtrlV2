package I6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: I6.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0609b0 extends B {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0609b0(AbstractC0613d0 delegate) {
        super(delegate);
        AbstractC2304t.f(delegate, "delegate");
    }

    @Override // I6.A, I6.S
    public boolean P0() {
        return true;
    }

    @Override // I6.A
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public C0609b0 Z0(AbstractC0613d0 delegate) {
        AbstractC2304t.f(delegate, "delegate");
        return new C0609b0(delegate);
    }
}
