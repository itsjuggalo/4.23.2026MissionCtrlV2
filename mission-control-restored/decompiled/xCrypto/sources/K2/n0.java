package K2;

/* JADX INFO: loaded from: classes3.dex */
public class n0 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f1271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Z f1272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1273c;

    public n0(l0 l0Var) {
        this(l0Var, null);
    }

    public final l0 a() {
        return this.f1271a;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.f1273c ? super.fillInStackTrace() : this;
    }

    public n0(l0 l0Var, Z z4) {
        this(l0Var, z4, true);
    }

    public n0(l0 l0Var, Z z4, boolean z5) {
        super(l0.g(l0Var), l0Var.l());
        this.f1271a = l0Var;
        this.f1272b = z4;
        this.f1273c = z5;
        fillInStackTrace();
    }
}
