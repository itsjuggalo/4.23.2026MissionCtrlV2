package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.v4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0698v4 extends A {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f5000e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0698v4(C0540b5 c0540b5, V3 v32) {
        super(v32);
        Objects.requireNonNull(c0540b5);
        this.f5000e = c0540b5;
    }

    @Override // S1.A
    public final void a() {
        C0540b5 c0540b5 = this.f5000e;
        if (c0540b5.f4245a.n()) {
            c0540b5.b0().b(2000L);
        }
    }
}
