package b3;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0982E f8564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8566c;

    public q(Class cls, int i7, int i8) {
        this(C0982E.b(cls), i7, i8);
    }

    public static q a(Class cls) {
        return new q(cls, 0, 2);
    }

    public static String b(int i7) {
        if (i7 == 0) {
            return "direct";
        }
        if (i7 == 1) {
            return "provider";
        }
        if (i7 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i7);
    }

    public static q h(Class cls) {
        return new q(cls, 0, 0);
    }

    public static q i(C0982E c0982e) {
        return new q(c0982e, 0, 1);
    }

    public static q j(Class cls) {
        return new q(cls, 0, 1);
    }

    public static q k(C0982E c0982e) {
        return new q(c0982e, 1, 0);
    }

    public static q l(Class cls) {
        return new q(cls, 1, 0);
    }

    public static q m(C0982E c0982e) {
        return new q(c0982e, 1, 1);
    }

    public static q n(Class cls) {
        return new q(cls, 1, 1);
    }

    public static q o(Class cls) {
        return new q(cls, 2, 0);
    }

    public C0982E c() {
        return this.f8564a;
    }

    public boolean d() {
        return this.f8566c == 2;
    }

    public boolean e() {
        return this.f8566c == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f8564a.equals(qVar.f8564a) && this.f8565b == qVar.f8565b && this.f8566c == qVar.f8566c;
    }

    public boolean f() {
        return this.f8565b == 1;
    }

    public boolean g() {
        return this.f8565b == 2;
    }

    public int hashCode() {
        return ((((this.f8564a.hashCode() ^ 1000003) * 1000003) ^ this.f8565b) * 1000003) ^ this.f8566c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f8564a);
        sb.append(", type=");
        int i7 = this.f8565b;
        sb.append(i7 == 1 ? "required" : i7 == 0 ? "optional" : "set");
        sb.append(", injection=");
        sb.append(b(this.f8566c));
        sb.append("}");
        return sb.toString();
    }

    public q(C0982E c0982e, int i7, int i8) {
        this.f8564a = (C0982E) AbstractC0981D.c(c0982e, "Null dependency anInterface.");
        this.f8565b = i7;
        this.f8566c = i8;
    }
}
