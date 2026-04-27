package u4;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f10454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10455b;

    public k0(j0 j0Var) {
        super(j0.b(j0Var), j0Var.f10448c);
        this.f10454a = j0Var;
        this.f10455b = true;
        fillInStackTrace();
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return this.f10455b ? super.fillInStackTrace() : this;
    }
}
