package I6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: I6.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0617f0 extends B {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r0 f4422c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0617f0(AbstractC0613d0 delegate, r0 attributes) {
        super(delegate);
        AbstractC2304t.f(delegate, "delegate");
        AbstractC2304t.f(attributes, "attributes");
        this.f4422c = attributes;
    }

    @Override // I6.A, I6.S
    public r0 N0() {
        return this.f4422c;
    }

    @Override // I6.A
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public C0617f0 Z0(AbstractC0613d0 delegate) {
        AbstractC2304t.f(delegate, "delegate");
        return new C0617f0(delegate, N0());
    }
}
