package r5;

/* JADX INFO: loaded from: classes2.dex */
public class m0 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f22758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Z f22759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22760c;

    public m0(l0 l0Var) {
        this(l0Var, null);
    }

    public final l0 a() {
        return this.f22758a;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.f22760c ? super.fillInStackTrace() : this;
    }

    public m0(l0 l0Var, Z z7) {
        this(l0Var, z7, true);
    }

    public m0(l0 l0Var, Z z7, boolean z8) {
        super(l0.g(l0Var), l0Var.l());
        this.f22758a = l0Var;
        this.f22759b = z7;
        this.f22760c = z8;
        fillInStackTrace();
    }
}
