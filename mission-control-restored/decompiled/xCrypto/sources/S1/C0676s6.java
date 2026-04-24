package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.s6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0676s6 extends A {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0684t6 f4931e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0676s6(C0684t6 c0684t6, V3 v32) {
        super(v32);
        Objects.requireNonNull(c0684t6);
        this.f4931e = c0684t6;
    }

    @Override // S1.A
    public final void a() {
        C0684t6 c0684t6 = this.f4931e;
        C0708w6 c0708w6 = c0684t6.f4956d;
        c0708w6.h();
        C0658q3 c0658q3 = c0708w6.f4245a;
        c0684t6.d(false, false, c0658q3.f().a());
        c0708w6.f4245a.M().k(c0658q3.f().a());
    }
}
