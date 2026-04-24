package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class I5 extends A {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f4003e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I5(C0565e6 c0565e6, V3 v32) {
        super(v32);
        Objects.requireNonNull(c0565e6);
        this.f4003e = c0565e6;
    }

    @Override // S1.A
    public final void a() {
        this.f4003e.f4245a.a().r().a("Tasks have been queued for a long time");
    }
}
