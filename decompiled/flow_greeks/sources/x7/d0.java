package x7;

import x7.g0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends g0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f24465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f24466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f24467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f24468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f24469i;

    public d0(int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
        this.f24461a = i10;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f24462b = str;
        this.f24463c = i11;
        this.f24464d = j10;
        this.f24465e = j11;
        this.f24466f = z10;
        this.f24467g = i12;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.f24468h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
        this.f24469i = str3;
    }

    @Override // x7.g0.b
    public int a() {
        return this.f24461a;
    }

    @Override // x7.g0.b
    public int b() {
        return this.f24463c;
    }

    @Override // x7.g0.b
    public long d() {
        return this.f24465e;
    }

    @Override // x7.g0.b
    public boolean e() {
        return this.f24466f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0.b) {
            g0.b bVar = (g0.b) obj;
            if (this.f24461a == bVar.a() && this.f24462b.equals(bVar.g()) && this.f24463c == bVar.b() && this.f24464d == bVar.j() && this.f24465e == bVar.d() && this.f24466f == bVar.e() && this.f24467g == bVar.i() && this.f24468h.equals(bVar.f()) && this.f24469i.equals(bVar.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // x7.g0.b
    public String f() {
        return this.f24468h;
    }

    @Override // x7.g0.b
    public String g() {
        return this.f24462b;
    }

    @Override // x7.g0.b
    public String h() {
        return this.f24469i;
    }

    public int hashCode() {
        int iHashCode = (((((this.f24461a ^ 1000003) * 1000003) ^ this.f24462b.hashCode()) * 1000003) ^ this.f24463c) * 1000003;
        long j10 = this.f24464d;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f24465e;
        return ((((((((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ (this.f24466f ? 1231 : 1237)) * 1000003) ^ this.f24467g) * 1000003) ^ this.f24468h.hashCode()) * 1000003) ^ this.f24469i.hashCode();
    }

    @Override // x7.g0.b
    public int i() {
        return this.f24467g;
    }

    @Override // x7.g0.b
    public long j() {
        return this.f24464d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f24461a + ", model=" + this.f24462b + ", availableProcessors=" + this.f24463c + ", totalRam=" + this.f24464d + ", diskSpace=" + this.f24465e + ", isEmulator=" + this.f24466f + ", state=" + this.f24467g + ", manufacturer=" + this.f24468h + ", modelClass=" + this.f24469i + "}";
    }
}
