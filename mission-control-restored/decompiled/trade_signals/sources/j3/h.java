package j3;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f20013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m3.i f20014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f20016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f20017e;

    public h(long j8, m3.i iVar, long j9, boolean z7, boolean z8) {
        this.f20013a = j8;
        if (iVar.g() && !iVar.f()) {
            throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
        }
        this.f20014b = iVar;
        this.f20015c = j9;
        this.f20016d = z7;
        this.f20017e = z8;
    }

    public h a(boolean z7) {
        return new h(this.f20013a, this.f20014b, this.f20015c, this.f20016d, z7);
    }

    public h b() {
        return new h(this.f20013a, this.f20014b, this.f20015c, true, this.f20017e);
    }

    public h c(long j8) {
        return new h(this.f20013a, this.f20014b, j8, this.f20016d, this.f20017e);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != h.class) {
            return false;
        }
        h hVar = (h) obj;
        return this.f20013a == hVar.f20013a && this.f20014b.equals(hVar.f20014b) && this.f20015c == hVar.f20015c && this.f20016d == hVar.f20016d && this.f20017e == hVar.f20017e;
    }

    public int hashCode() {
        return (((((((Long.valueOf(this.f20013a).hashCode() * 31) + this.f20014b.hashCode()) * 31) + Long.valueOf(this.f20015c).hashCode()) * 31) + Boolean.valueOf(this.f20016d).hashCode()) * 31) + Boolean.valueOf(this.f20017e).hashCode();
    }

    public String toString() {
        return "TrackedQuery{id=" + this.f20013a + ", querySpec=" + this.f20014b + ", lastUse=" + this.f20015c + ", complete=" + this.f20016d + ", active=" + this.f20017e + "}";
    }
}
