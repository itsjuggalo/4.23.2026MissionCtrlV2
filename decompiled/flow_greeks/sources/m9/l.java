package m9;

import m9.x0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends x0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x0.a f16202e;

    public l(int i10, int i11, String str, String str2, x0.a aVar) {
        this.f16198a = i10;
        this.f16199b = i11;
        if (str == null) {
            throw new NullPointerException("Null projectId");
        }
        this.f16200c = str;
        if (str2 == null) {
            throw new NullPointerException("Null databaseId");
        }
        this.f16201d = str2;
        this.f16202e = aVar;
    }

    @Override // m9.x0.b
    public x0.a a() {
        return this.f16202e;
    }

    @Override // m9.x0.b
    public String c() {
        return this.f16201d;
    }

    @Override // m9.x0.b
    public int d() {
        return this.f16199b;
    }

    public boolean equals(Object obj) {
        x0.a aVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof x0.b) {
            x0.b bVar = (x0.b) obj;
            if (this.f16198a == bVar.f() && this.f16199b == bVar.d() && this.f16200c.equals(bVar.g()) && this.f16201d.equals(bVar.c()) && ((aVar = this.f16202e) != null ? aVar.equals(bVar.a()) : bVar.a() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // m9.x0.b
    public int f() {
        return this.f16198a;
    }

    @Override // m9.x0.b
    public String g() {
        return this.f16200c;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f16198a ^ 1000003) * 1000003) ^ this.f16199b) * 1000003) ^ this.f16200c.hashCode()) * 1000003) ^ this.f16201d.hashCode()) * 1000003;
        x0.a aVar = this.f16202e;
        return iHashCode ^ (aVar == null ? 0 : aVar.hashCode());
    }

    public String toString() {
        return "ExistenceFilterMismatchInfo{localCacheCount=" + this.f16198a + ", existenceFilterCount=" + this.f16199b + ", projectId=" + this.f16200c + ", databaseId=" + this.f16201d + ", bloomFilter=" + this.f16202e + "}";
    }
}
