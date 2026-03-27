package p3;

/* JADX INFO: renamed from: p3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2559m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2559m f22304c = new C2559m(C2548b.m(), C2553g.M());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2559m f22305d = new C2559m(C2548b.l(), InterfaceC2560n.f22308N);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2548b f22306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2560n f22307b;

    public C2559m(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
        this.f22306a = c2548b;
        this.f22307b = interfaceC2560n;
    }

    public static C2559m a() {
        return f22305d;
    }

    public static C2559m b() {
        return f22304c;
    }

    public C2548b c() {
        return this.f22306a;
    }

    public InterfaceC2560n d() {
        return this.f22307b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2559m.class != obj.getClass()) {
            return false;
        }
        C2559m c2559m = (C2559m) obj;
        return this.f22306a.equals(c2559m.f22306a) && this.f22307b.equals(c2559m.f22307b);
    }

    public int hashCode() {
        return (this.f22306a.hashCode() * 31) + this.f22307b.hashCode();
    }

    public String toString() {
        return "NamedNode{name=" + this.f22306a + ", node=" + this.f22307b + '}';
    }
}
