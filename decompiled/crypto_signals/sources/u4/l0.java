package u4;

/* JADX INFO: loaded from: classes.dex */
public final class l0 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f10458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10459b;

    public l0(j0 j0Var) {
        super(j0.b(j0Var), j0Var.f10448c);
        this.f10458a = j0Var;
        this.f10459b = true;
        fillInStackTrace();
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return this.f10459b ? super.fillInStackTrace() : this;
    }
}
