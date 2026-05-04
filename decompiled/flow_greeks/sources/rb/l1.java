package rb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class l1 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1 f19637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y0 f19638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19639c;

    public l1(k1 k1Var) {
        this(k1Var, null);
    }

    public final k1 a() {
        return this.f19637a;
    }

    public final y0 b() {
        return this.f19638b;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.f19639c ? super.fillInStackTrace() : this;
    }

    public l1(k1 k1Var, y0 y0Var) {
        this(k1Var, y0Var, true);
    }

    public l1(k1 k1Var, y0 y0Var, boolean z10) {
        super(k1.h(k1Var), k1Var.m());
        this.f19637a = k1Var;
        this.f19638b = y0Var;
        this.f19639c = z10;
        fillInStackTrace();
    }
}
