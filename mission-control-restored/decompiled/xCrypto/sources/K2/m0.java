package K2;

/* JADX INFO: loaded from: classes3.dex */
public class m0 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f1268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Z f1269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1270c;

    public m0(l0 l0Var) {
        this(l0Var, null);
    }

    public final l0 a() {
        return this.f1268a;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.f1270c ? super.fillInStackTrace() : this;
    }

    public m0(l0 l0Var, Z z4) {
        this(l0Var, z4, true);
    }

    public m0(l0 l0Var, Z z4, boolean z5) {
        super(l0.g(l0Var), l0Var.l());
        this.f1268a = l0Var;
        this.f1269b = z4;
        this.f1270c = z5;
        fillInStackTrace();
    }
}
