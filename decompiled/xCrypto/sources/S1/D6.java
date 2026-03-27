package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class D6 extends A {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ E6 f3910e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D6(E6 e6, V3 v32) {
        super(v32);
        Objects.requireNonNull(e6);
        this.f3910e = e6;
    }

    @Override // S1.A
    public final void a() {
        E6 e6 = this.f3910e;
        e6.n();
        e6.f4245a.a().w().a("Starting upload from DelayedRunnable");
        e6.f3955b.r();
    }
}
