package M2;

/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f5274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f5275b;

    public @interface a {
    }

    public E(Class cls, Class cls2) {
        this.f5274a = cls;
        this.f5275b = cls2;
    }

    public static E a(Class cls, Class cls2) {
        return new E(cls, cls2);
    }

    public static E b(Class cls) {
        return new E(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || E.class != obj.getClass()) {
            return false;
        }
        E e8 = (E) obj;
        if (this.f5275b.equals(e8.f5275b)) {
            return this.f5274a.equals(e8.f5274a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f5275b.hashCode() * 31) + this.f5274a.hashCode();
    }

    public String toString() {
        if (this.f5274a == a.class) {
            return this.f5275b.getName();
        }
        return "@" + this.f5274a.getName() + " " + this.f5275b.getName();
    }
}
