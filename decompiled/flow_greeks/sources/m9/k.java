package m9;

import m9.x0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f16192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f16196e;

    public k(m mVar, boolean z10, int i10, int i11, int i12) {
        this.f16192a = mVar;
        this.f16193b = z10;
        this.f16194c = i10;
        this.f16195d = i11;
        this.f16196e = i12;
    }

    @Override // m9.x0.a
    public boolean a() {
        return this.f16193b;
    }

    @Override // m9.x0.a
    public int b() {
        return this.f16195d;
    }

    @Override // m9.x0.a
    public m c() {
        return this.f16192a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x0.a) {
            x0.a aVar = (x0.a) obj;
            m mVar = this.f16192a;
            if (mVar != null ? mVar.equals(aVar.c()) : aVar.c() == null) {
                if (this.f16193b == aVar.a() && this.f16194c == aVar.f() && this.f16195d == aVar.b() && this.f16196e == aVar.g()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // m9.x0.a
    public int f() {
        return this.f16194c;
    }

    @Override // m9.x0.a
    public int g() {
        return this.f16196e;
    }

    public int hashCode() {
        m mVar = this.f16192a;
        return (((((((((mVar == null ? 0 : mVar.hashCode()) ^ 1000003) * 1000003) ^ (this.f16193b ? 1231 : 1237)) * 1000003) ^ this.f16194c) * 1000003) ^ this.f16195d) * 1000003) ^ this.f16196e;
    }

    public String toString() {
        return "ExistenceFilterBloomFilterInfo{bloomFilter=" + this.f16192a + ", applied=" + this.f16193b + ", hashCount=" + this.f16194c + ", bitmapLength=" + this.f16195d + ", padding=" + this.f16196e + "}";
    }
}
