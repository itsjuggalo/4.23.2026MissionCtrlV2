package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class E5 extends A {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f3923e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E5(C0565e6 c0565e6, V3 v32) {
        super(v32);
        Objects.requireNonNull(c0565e6);
        this.f3923e = c0565e6;
    }

    @Override // S1.A
    public final void a() {
        C0565e6 c0565e6 = this.f3923e;
        c0565e6.h();
        if (c0565e6.W()) {
            c0565e6.f4245a.a().w().a("Inactivity, disconnecting from the service");
            c0565e6.A();
        }
    }
}
