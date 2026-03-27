package R2;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q2.j f2778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f2779b;

    public g(Q2.j jVar, p pVar) {
        this.f2778a = jVar;
        this.f2779b = pVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f2778a.equals(gVar.f2778a)) {
            return this.f2779b.equals(gVar.f2779b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2779b.hashCode() + (this.f2778a.hashCode() * 31);
    }
}
