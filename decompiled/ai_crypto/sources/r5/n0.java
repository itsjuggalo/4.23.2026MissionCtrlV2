package r5;

/* JADX INFO: loaded from: classes2.dex */
public class n0 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f22761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Z f22762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22763c;

    public n0(l0 l0Var) {
        this(l0Var, null);
    }

    public final l0 a() {
        return this.f22761a;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.f22763c ? super.fillInStackTrace() : this;
    }

    public n0(l0 l0Var, Z z7) {
        this(l0Var, z7, true);
    }

    public n0(l0 l0Var, Z z7, boolean z8) {
        super(l0.g(l0Var), l0Var.l());
        this.f22761a = l0Var;
        this.f22762b = z7;
        this.f22763c = z8;
        fillInStackTrace();
    }
}
