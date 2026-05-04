package j8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f13961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r8.n f13962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f13963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13964e;

    public c0(long j10, l lVar, r8.n nVar, boolean z10) {
        this.f13960a = j10;
        this.f13961b = lVar;
        this.f13962c = nVar;
        this.f13963d = null;
        this.f13964e = z10;
    }

    public b a() {
        b bVar = this.f13963d;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalArgumentException("Can't access merge when write is an overwrite!");
    }

    public r8.n b() {
        r8.n nVar = this.f13962c;
        if (nVar != null) {
            return nVar;
        }
        throw new IllegalArgumentException("Can't access overwrite when write is a merge!");
    }

    public l c() {
        return this.f13961b;
    }

    public long d() {
        return this.f13960a;
    }

    public boolean e() {
        return this.f13962c != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c0.class != obj.getClass()) {
            return false;
        }
        c0 c0Var = (c0) obj;
        if (this.f13960a != c0Var.f13960a || !this.f13961b.equals(c0Var.f13961b) || this.f13964e != c0Var.f13964e) {
            return false;
        }
        r8.n nVar = this.f13962c;
        if (nVar == null ? c0Var.f13962c != null : !nVar.equals(c0Var.f13962c)) {
            return false;
        }
        b bVar = this.f13963d;
        b bVar2 = c0Var.f13963d;
        return bVar == null ? bVar2 == null : bVar.equals(bVar2);
    }

    public boolean f() {
        return this.f13964e;
    }

    public int hashCode() {
        int iHashCode = ((((Long.valueOf(this.f13960a).hashCode() * 31) + Boolean.valueOf(this.f13964e).hashCode()) * 31) + this.f13961b.hashCode()) * 31;
        r8.n nVar = this.f13962c;
        int iHashCode2 = (iHashCode + (nVar != null ? nVar.hashCode() : 0)) * 31;
        b bVar = this.f13963d;
        return iHashCode2 + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "UserWriteRecord{id=" + this.f13960a + " path=" + this.f13961b + " visible=" + this.f13964e + " overwrite=" + this.f13962c + " merge=" + this.f13963d + "}";
    }

    public c0(long j10, l lVar, b bVar) {
        this.f13960a = j10;
        this.f13961b = lVar;
        this.f13962c = null;
        this.f13963d = bVar;
        this.f13964e = true;
    }
}
