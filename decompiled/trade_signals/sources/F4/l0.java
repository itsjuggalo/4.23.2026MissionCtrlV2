package F4;

/* JADX INFO: loaded from: classes.dex */
public class l0 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f1852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X f1853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1854c;

    public l0(j0 j0Var) {
        this(j0Var, null);
    }

    public final j0 a() {
        return this.f1852a;
    }

    public final X b() {
        return this.f1853b;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.f1854c ? super.fillInStackTrace() : this;
    }

    public l0(j0 j0Var, X x8) {
        this(j0Var, x8, true);
    }

    public l0(j0 j0Var, X x8, boolean z7) {
        super(j0.h(j0Var), j0Var.m());
        this.f1852a = j0Var;
        this.f1853b = x8;
        this.f1854c = z7;
        fillInStackTrace();
    }
}
