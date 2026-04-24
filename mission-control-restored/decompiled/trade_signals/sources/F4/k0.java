package F4;

/* JADX INFO: loaded from: classes.dex */
public class k0 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f1848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X f1849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1850c;

    public k0(j0 j0Var) {
        this(j0Var, null);
    }

    public final j0 a() {
        return this.f1848a;
    }

    public final X b() {
        return this.f1849b;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.f1850c ? super.fillInStackTrace() : this;
    }

    public k0(j0 j0Var, X x8) {
        this(j0Var, x8, true);
    }

    public k0(j0 j0Var, X x8, boolean z7) {
        super(j0.h(j0Var), j0Var.m());
        this.f1848a = j0Var;
        this.f1849b = x8;
        this.f1850c = z7;
        fillInStackTrace();
    }
}
