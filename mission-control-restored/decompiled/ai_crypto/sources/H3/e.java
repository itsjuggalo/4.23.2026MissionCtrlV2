package H3;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G3.q f2635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f2636b;

    public e(G3.q qVar, p pVar) {
        this.f2635a = qVar;
        this.f2636b = pVar;
    }

    public G3.q a() {
        return this.f2635a;
    }

    public p b() {
        return this.f2636b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f2635a.equals(eVar.f2635a)) {
            return this.f2636b.equals(eVar.f2636b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f2635a.hashCode() * 31) + this.f2636b.hashCode();
    }
}
