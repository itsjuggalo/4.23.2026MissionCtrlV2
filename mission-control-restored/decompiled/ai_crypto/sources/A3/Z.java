package A3;

/* JADX INFO: loaded from: classes.dex */
public final class Z implements Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0402b0 f162a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InterfaceC0402b0 f163a;

        public Z a() {
            return new Z(this.f163a);
        }

        public b() {
            this.f163a = C0400a0.a().a();
        }
    }

    public static b b() {
        return new b();
    }

    public InterfaceC0402b0 a() {
        return this.f162a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Z.class != obj.getClass()) {
            return false;
        }
        return a().equals(((Z) obj).a());
    }

    public int hashCode() {
        return this.f162a.hashCode();
    }

    public String toString() {
        return "MemoryCacheSettings{gcSettings=" + a() + "}";
    }

    public Z(InterfaceC0402b0 interfaceC0402b0) {
        this.f162a = interfaceC0402b0;
    }
}
