package k3;

import k3.AbstractC2075G;

/* JADX INFO: renamed from: k3.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2072D extends AbstractC2075G.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f17589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f17590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f17592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f17593i;

    public C2072D(int i7, String str, int i8, long j7, long j8, boolean z7, int i9, String str2, String str3) {
        this.f17585a = i7;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f17586b = str;
        this.f17587c = i8;
        this.f17588d = j7;
        this.f17589e = j8;
        this.f17590f = z7;
        this.f17591g = i9;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.f17592h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
        this.f17593i = str3;
    }

    @Override // k3.AbstractC2075G.b
    public int a() {
        return this.f17585a;
    }

    @Override // k3.AbstractC2075G.b
    public int b() {
        return this.f17587c;
    }

    @Override // k3.AbstractC2075G.b
    public long d() {
        return this.f17589e;
    }

    @Override // k3.AbstractC2075G.b
    public boolean e() {
        return this.f17590f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2075G.b)) {
            return false;
        }
        AbstractC2075G.b bVar = (AbstractC2075G.b) obj;
        return this.f17585a == bVar.a() && this.f17586b.equals(bVar.g()) && this.f17587c == bVar.b() && this.f17588d == bVar.j() && this.f17589e == bVar.d() && this.f17590f == bVar.e() && this.f17591g == bVar.i() && this.f17592h.equals(bVar.f()) && this.f17593i.equals(bVar.h());
    }

    @Override // k3.AbstractC2075G.b
    public String f() {
        return this.f17592h;
    }

    @Override // k3.AbstractC2075G.b
    public String g() {
        return this.f17586b;
    }

    @Override // k3.AbstractC2075G.b
    public String h() {
        return this.f17593i;
    }

    public int hashCode() {
        int iHashCode = (((((this.f17585a ^ 1000003) * 1000003) ^ this.f17586b.hashCode()) * 1000003) ^ this.f17587c) * 1000003;
        long j7 = this.f17588d;
        int i7 = (iHashCode ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        long j8 = this.f17589e;
        return ((((((((i7 ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ (this.f17590f ? 1231 : 1237)) * 1000003) ^ this.f17591g) * 1000003) ^ this.f17592h.hashCode()) * 1000003) ^ this.f17593i.hashCode();
    }

    @Override // k3.AbstractC2075G.b
    public int i() {
        return this.f17591g;
    }

    @Override // k3.AbstractC2075G.b
    public long j() {
        return this.f17588d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f17585a + ", model=" + this.f17586b + ", availableProcessors=" + this.f17587c + ", totalRam=" + this.f17588d + ", diskSpace=" + this.f17589e + ", isEmulator=" + this.f17590f + ", state=" + this.f17591g + ", manufacturer=" + this.f17592h + ", modelClass=" + this.f17593i + "}";
    }
}
