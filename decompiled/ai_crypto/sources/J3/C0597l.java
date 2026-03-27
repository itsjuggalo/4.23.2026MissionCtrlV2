package J3;

import J3.Y;

/* JADX INFO: renamed from: J3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0597l extends Y.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Y.a f3255e;

    public C0597l(int i7, int i8, String str, String str2, Y.a aVar) {
        this.f3251a = i7;
        this.f3252b = i8;
        if (str == null) {
            throw new NullPointerException("Null projectId");
        }
        this.f3253c = str;
        if (str2 == null) {
            throw new NullPointerException("Null databaseId");
        }
        this.f3254d = str2;
        this.f3255e = aVar;
    }

    @Override // J3.Y.b
    public Y.a a() {
        return this.f3255e;
    }

    @Override // J3.Y.b
    public String c() {
        return this.f3254d;
    }

    @Override // J3.Y.b
    public int d() {
        return this.f3252b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Y.b)) {
            return false;
        }
        Y.b bVar = (Y.b) obj;
        if (this.f3251a == bVar.f() && this.f3252b == bVar.d() && this.f3253c.equals(bVar.g()) && this.f3254d.equals(bVar.c())) {
            Y.a aVar = this.f3255e;
            if (aVar == null) {
                if (bVar.a() == null) {
                    return true;
                }
            } else if (aVar.equals(bVar.a())) {
                return true;
            }
        }
        return false;
    }

    @Override // J3.Y.b
    public int f() {
        return this.f3251a;
    }

    @Override // J3.Y.b
    public String g() {
        return this.f3253c;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f3251a ^ 1000003) * 1000003) ^ this.f3252b) * 1000003) ^ this.f3253c.hashCode()) * 1000003) ^ this.f3254d.hashCode()) * 1000003;
        Y.a aVar = this.f3255e;
        return iHashCode ^ (aVar == null ? 0 : aVar.hashCode());
    }

    public String toString() {
        return "ExistenceFilterMismatchInfo{localCacheCount=" + this.f3251a + ", existenceFilterCount=" + this.f3252b + ", projectId=" + this.f3253c + ", databaseId=" + this.f3254d + ", bloomFilter=" + this.f3255e + "}";
    }
}
