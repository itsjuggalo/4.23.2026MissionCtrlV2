package k2;

/* JADX INFO: renamed from: k2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0769o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f7865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f7866b;

    public C0769o(Class cls, Class cls2) {
        this.f7865a = cls;
        this.f7866b = cls2;
    }

    public static C0769o a(Class cls) {
        return new C0769o(InterfaceC0768n.class, cls);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0769o.class != obj.getClass()) {
            return false;
        }
        C0769o c0769o = (C0769o) obj;
        if (this.f7866b.equals(c0769o.f7866b)) {
            return this.f7865a.equals(c0769o.f7865a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7865a.hashCode() + (this.f7866b.hashCode() * 31);
    }

    public final String toString() {
        Class cls = this.f7866b;
        Class cls2 = this.f7865a;
        if (cls2 == InterfaceC0768n.class) {
            return cls.getName();
        }
        return "@" + cls2.getName() + " " + cls.getName();
    }
}
