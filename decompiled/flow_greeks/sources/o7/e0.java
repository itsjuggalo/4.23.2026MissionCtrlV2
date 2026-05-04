package o7;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f17547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f17548b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public @interface a {
    }

    public e0(Class cls, Class cls2) {
        this.f17547a = cls;
        this.f17548b = cls2;
    }

    public static e0 a(Class cls, Class cls2) {
        return new e0(cls, cls2);
    }

    public static e0 b(Class cls) {
        return new e0(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e0.class != obj.getClass()) {
            return false;
        }
        e0 e0Var = (e0) obj;
        if (this.f17548b.equals(e0Var.f17548b)) {
            return this.f17547a.equals(e0Var.f17547a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f17548b.hashCode() * 31) + this.f17547a.hashCode();
    }

    public String toString() {
        if (this.f17547a == a.class) {
            return this.f17548b.getName();
        }
        return "@" + this.f17547a.getName() + " " + this.f17548b.getName();
    }
}
