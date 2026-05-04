package o7;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f17587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17589c;

    public q(Class cls, int i10, int i11) {
        this(e0.b(cls), i10, i11);
    }

    public static q a(Class cls) {
        return new q(cls, 0, 2);
    }

    public static String b(int i10) {
        if (i10 == 0) {
            return "direct";
        }
        if (i10 == 1) {
            return "provider";
        }
        if (i10 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i10);
    }

    public static q h(Class cls) {
        return new q(cls, 0, 0);
    }

    public static q i(Class cls) {
        return new q(cls, 0, 1);
    }

    public static q j(e0 e0Var) {
        return new q(e0Var, 0, 1);
    }

    public static q k(Class cls) {
        return new q(cls, 1, 0);
    }

    public static q l(e0 e0Var) {
        return new q(e0Var, 1, 0);
    }

    public static q m(Class cls) {
        return new q(cls, 1, 1);
    }

    public static q n(e0 e0Var) {
        return new q(e0Var, 1, 1);
    }

    public static q o(Class cls) {
        return new q(cls, 2, 0);
    }

    public e0 c() {
        return this.f17587a;
    }

    public boolean d() {
        return this.f17589c == 2;
    }

    public boolean e() {
        return this.f17589c == 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f17587a.equals(qVar.f17587a) && this.f17588b == qVar.f17588b && this.f17589c == qVar.f17589c) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.f17588b == 1;
    }

    public boolean g() {
        return this.f17588b == 2;
    }

    public int hashCode() {
        return ((((this.f17587a.hashCode() ^ 1000003) * 1000003) ^ this.f17588b) * 1000003) ^ this.f17589c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.f17587a);
        sb2.append(", type=");
        int i10 = this.f17588b;
        sb2.append(i10 == 1 ? "required" : i10 == 0 ? "optional" : "set");
        sb2.append(", injection=");
        sb2.append(b(this.f17589c));
        sb2.append("}");
        return sb2.toString();
    }

    public q(e0 e0Var, int i10, int i11) {
        this.f17587a = (e0) d0.c(e0Var, "Null dependency anInterface.");
        this.f17588b = i10;
        this.f17589c = i11;
    }
}
