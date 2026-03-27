package J3;

import J3.Y;

/* JADX INFO: renamed from: J3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0596k extends Y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0598m f3246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3250e;

    public C0596k(C0598m c0598m, boolean z7, int i7, int i8, int i9) {
        this.f3246a = c0598m;
        this.f3247b = z7;
        this.f3248c = i7;
        this.f3249d = i8;
        this.f3250e = i9;
    }

    @Override // J3.Y.a
    public boolean a() {
        return this.f3247b;
    }

    @Override // J3.Y.a
    public int b() {
        return this.f3249d;
    }

    @Override // J3.Y.a
    public C0598m c() {
        return this.f3246a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Y.a)) {
            return false;
        }
        Y.a aVar = (Y.a) obj;
        C0598m c0598m = this.f3246a;
        if (c0598m != null ? c0598m.equals(aVar.c()) : aVar.c() == null) {
            if (this.f3247b == aVar.a() && this.f3248c == aVar.f() && this.f3249d == aVar.b() && this.f3250e == aVar.g()) {
                return true;
            }
        }
        return false;
    }

    @Override // J3.Y.a
    public int f() {
        return this.f3248c;
    }

    @Override // J3.Y.a
    public int g() {
        return this.f3250e;
    }

    public int hashCode() {
        C0598m c0598m = this.f3246a;
        return (((((((((c0598m == null ? 0 : c0598m.hashCode()) ^ 1000003) * 1000003) ^ (this.f3247b ? 1231 : 1237)) * 1000003) ^ this.f3248c) * 1000003) ^ this.f3249d) * 1000003) ^ this.f3250e;
    }

    public String toString() {
        return "ExistenceFilterBloomFilterInfo{bloomFilter=" + this.f3246a + ", applied=" + this.f3247b + ", hashCount=" + this.f3248c + ", bitmapLength=" + this.f3249d + ", padding=" + this.f3250e + "}";
    }
}
