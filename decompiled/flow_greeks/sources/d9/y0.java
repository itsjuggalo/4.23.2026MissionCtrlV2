package d9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a1 f7979a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a1 f7980a;

        public y0 a() {
            return new y0(this.f7980a);
        }

        public b() {
            this.f7980a = z0.a().a();
        }
    }

    public static b b() {
        return new b();
    }

    public a1 a() {
        return this.f7979a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y0.class != obj.getClass()) {
            return false;
        }
        return a().equals(((y0) obj).a());
    }

    public int hashCode() {
        return this.f7979a.hashCode();
    }

    public String toString() {
        return "MemoryCacheSettings{gcSettings=" + a() + "}";
    }

    public y0(a1 a1Var) {
        this.f7979a = a1Var;
    }
}
