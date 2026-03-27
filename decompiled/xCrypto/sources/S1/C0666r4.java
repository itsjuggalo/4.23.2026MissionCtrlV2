package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.r4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0666r4 extends A {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4900e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0666r4(C0540b5 c0540b5, V3 v32) {
        super(v32);
        Objects.requireNonNull(c0540b5);
        this.f4900e = c0540b5;
    }

    @Override // S1.A
    public final void a() {
        this.f4900e.r();
    }
}
