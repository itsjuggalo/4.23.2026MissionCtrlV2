package V2;

import V2.G;

/* JADX INFO: loaded from: classes.dex */
public final class D extends G.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f8509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f8510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f8511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f8513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f8514i;

    public D(int i8, String str, int i9, long j8, long j9, boolean z7, int i10, String str2, String str3) {
        this.f8506a = i8;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f8507b = str;
        this.f8508c = i9;
        this.f8509d = j8;
        this.f8510e = j9;
        this.f8511f = z7;
        this.f8512g = i10;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.f8513h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
        this.f8514i = str3;
    }

    @Override // V2.G.b
    public int a() {
        return this.f8506a;
    }

    @Override // V2.G.b
    public int b() {
        return this.f8508c;
    }

    @Override // V2.G.b
    public long d() {
        return this.f8510e;
    }

    @Override // V2.G.b
    public boolean e() {
        return this.f8511f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof G.b)) {
            return false;
        }
        G.b bVar = (G.b) obj;
        return this.f8506a == bVar.a() && this.f8507b.equals(bVar.g()) && this.f8508c == bVar.b() && this.f8509d == bVar.j() && this.f8510e == bVar.d() && this.f8511f == bVar.e() && this.f8512g == bVar.i() && this.f8513h.equals(bVar.f()) && this.f8514i.equals(bVar.h());
    }

    @Override // V2.G.b
    public String f() {
        return this.f8513h;
    }

    @Override // V2.G.b
    public String g() {
        return this.f8507b;
    }

    @Override // V2.G.b
    public String h() {
        return this.f8514i;
    }

    public int hashCode() {
        int iHashCode = (((((this.f8506a ^ 1000003) * 1000003) ^ this.f8507b.hashCode()) * 1000003) ^ this.f8508c) * 1000003;
        long j8 = this.f8509d;
        int i8 = (iHashCode ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        long j9 = this.f8510e;
        return ((((((((i8 ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003) ^ (this.f8511f ? 1231 : 1237)) * 1000003) ^ this.f8512g) * 1000003) ^ this.f8513h.hashCode()) * 1000003) ^ this.f8514i.hashCode();
    }

    @Override // V2.G.b
    public int i() {
        return this.f8512g;
    }

    @Override // V2.G.b
    public long j() {
        return this.f8509d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f8506a + ", model=" + this.f8507b + ", availableProcessors=" + this.f8508c + ", totalRam=" + this.f8509d + ", diskSpace=" + this.f8510e + ", isEmulator=" + this.f8511f + ", state=" + this.f8512g + ", manufacturer=" + this.f8513h + ", modelClass=" + this.f8514i + "}";
    }
}
