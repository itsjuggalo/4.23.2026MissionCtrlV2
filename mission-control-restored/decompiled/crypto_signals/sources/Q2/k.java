package Q2;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f2679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f2681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f2682d;
    public l e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2683f;

    public k(h hVar) {
        this.f2679a = hVar;
        this.f2682d = n.f2687b;
    }

    public static k g(h hVar) {
        n nVar = n.f2687b;
        return new k(hVar, 1, nVar, nVar, new l(), 3);
    }

    public static k h(h hVar, n nVar) {
        k kVar = new k(hVar);
        kVar.b(nVar);
        return kVar;
    }

    public final void a(n nVar, l lVar) {
        this.f2681c = nVar;
        this.f2680b = 2;
        this.e = lVar;
        this.f2683f = 3;
    }

    public final void b(n nVar) {
        this.f2681c = nVar;
        this.f2680b = 3;
        this.e = new l();
        this.f2683f = 3;
    }

    public final boolean c() {
        return S.i.b(this.f2683f, 1);
    }

    public final boolean d() {
        return S.i.b(this.f2680b, 2);
    }

    public final boolean e() {
        return S.i.b(this.f2680b, 3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f2679a.equals(kVar.f2679a) && this.f2681c.equals(kVar.f2681c) && S.i.b(this.f2680b, kVar.f2680b) && S.i.b(this.f2683f, kVar.f2683f)) {
            return this.e.equals(kVar.e);
        }
        return false;
    }

    public final k f() {
        return new k(this.f2679a, this.f2680b, this.f2681c, this.f2682d, new l(this.e.b()), this.f2683f);
    }

    public final int hashCode() {
        return this.f2679a.f2674a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Document{key=");
        sb.append(this.f2679a);
        sb.append(", version=");
        sb.append(this.f2681c);
        sb.append(", readTime=");
        sb.append(this.f2682d);
        sb.append(", type=");
        int i = this.f2680b;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "UNKNOWN_DOCUMENT" : "NO_DOCUMENT" : "FOUND_DOCUMENT" : "INVALID");
        sb.append(", documentState=");
        int i6 = this.f2683f;
        sb.append(i6 != 1 ? i6 != 2 ? i6 != 3 ? "null" : "SYNCED" : "HAS_COMMITTED_MUTATIONS" : "HAS_LOCAL_MUTATIONS");
        sb.append(", value=");
        sb.append(this.e);
        sb.append('}');
        return sb.toString();
    }

    public k(h hVar, int i, n nVar, n nVar2, l lVar, int i6) {
        this.f2679a = hVar;
        this.f2681c = nVar;
        this.f2682d = nVar2;
        this.f2680b = i;
        this.f2683f = i6;
        this.e = lVar;
    }
}
