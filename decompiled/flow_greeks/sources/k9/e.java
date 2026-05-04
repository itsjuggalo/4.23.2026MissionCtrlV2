package k9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j9.q f14774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f14775b;

    public e(j9.q qVar, p pVar) {
        this.f14774a = qVar;
        this.f14775b = pVar;
    }

    public j9.q a() {
        return this.f14774a;
    }

    public p b() {
        return this.f14775b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f14774a.equals(eVar.f14774a)) {
            return this.f14775b.equals(eVar.f14775b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f14774a.hashCode() * 31) + this.f14775b.hashCode();
    }
}
