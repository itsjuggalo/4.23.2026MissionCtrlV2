package M2;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f5331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5333c;

    public q(E e8, int i8, int i9) {
        this.f5331a = (E) D.c(e8, "Null dependency anInterface.");
        this.f5332b = i8;
        this.f5333c = i9;
    }

    public static q a(Class cls) {
        return new q(cls, 0, 2);
    }

    public static String b(int i8) {
        if (i8 == 0) {
            return "direct";
        }
        if (i8 == 1) {
            return "provider";
        }
        if (i8 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i8);
    }

    public static q h(Class cls) {
        return new q(cls, 0, 0);
    }

    public static q i(E e8) {
        return new q(e8, 0, 1);
    }

    public static q j(Class cls) {
        return new q(cls, 0, 1);
    }

    public static q k(E e8) {
        return new q(e8, 1, 0);
    }

    public static q l(Class cls) {
        return new q(cls, 1, 0);
    }

    public static q m(E e8) {
        return new q(e8, 1, 1);
    }

    public static q n(Class cls) {
        return new q(cls, 1, 1);
    }

    public static q o(Class cls) {
        return new q(cls, 2, 0);
    }

    public E c() {
        return this.f5331a;
    }

    public boolean d() {
        return this.f5333c == 2;
    }

    public boolean e() {
        return this.f5333c == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f5331a.equals(qVar.f5331a) && this.f5332b == qVar.f5332b && this.f5333c == qVar.f5333c;
    }

    public boolean f() {
        return this.f5332b == 1;
    }

    public boolean g() {
        return this.f5332b == 2;
    }

    public int hashCode() {
        return ((((this.f5331a.hashCode() ^ 1000003) * 1000003) ^ this.f5332b) * 1000003) ^ this.f5333c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f5331a);
        sb.append(", type=");
        int i8 = this.f5332b;
        sb.append(i8 == 1 ? "required" : i8 == 0 ? "optional" : "set");
        sb.append(", injection=");
        sb.append(b(this.f5333c));
        sb.append("}");
        return sb.toString();
    }

    public q(Class cls, int i8, int i9) {
        this(E.b(cls), i8, i9);
    }
}
