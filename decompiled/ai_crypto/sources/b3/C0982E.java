package b3;

/* JADX INFO: renamed from: b3.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0982E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f8507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f8508b;

    /* JADX INFO: renamed from: b3.E$a */
    public @interface a {
    }

    public C0982E(Class cls, Class cls2) {
        this.f8507a = cls;
        this.f8508b = cls2;
    }

    public static C0982E a(Class cls, Class cls2) {
        return new C0982E(cls, cls2);
    }

    public static C0982E b(Class cls) {
        return new C0982E(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0982E.class != obj.getClass()) {
            return false;
        }
        C0982E c0982e = (C0982E) obj;
        if (this.f8508b.equals(c0982e.f8508b)) {
            return this.f8507a.equals(c0982e.f8507a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f8508b.hashCode() * 31) + this.f8507a.hashCode();
    }

    public String toString() {
        if (this.f8507a == a.class) {
            return this.f8508b.getName();
        }
        return "@" + this.f8507a.getName() + " " + this.f8508b.getName();
    }
}
