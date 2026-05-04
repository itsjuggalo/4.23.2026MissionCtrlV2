package m9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.protobuf.i f16297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g8.e f16299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g8.e f16300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g8.e f16301e;

    public v0(com.google.protobuf.i iVar, boolean z10, g8.e eVar, g8.e eVar2, g8.e eVar3) {
        this.f16297a = iVar;
        this.f16298b = z10;
        this.f16299c = eVar;
        this.f16300d = eVar2;
        this.f16301e = eVar3;
    }

    public static v0 a(boolean z10, com.google.protobuf.i iVar) {
        return new v0(iVar, z10, j9.k.h(), j9.k.h(), j9.k.h());
    }

    public g8.e b() {
        return this.f16299c;
    }

    public g8.e c() {
        return this.f16300d;
    }

    public g8.e d() {
        return this.f16301e;
    }

    public com.google.protobuf.i e() {
        return this.f16297a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v0.class != obj.getClass()) {
            return false;
        }
        v0 v0Var = (v0) obj;
        if (this.f16298b == v0Var.f16298b && this.f16297a.equals(v0Var.f16297a) && this.f16299c.equals(v0Var.f16299c) && this.f16300d.equals(v0Var.f16300d)) {
            return this.f16301e.equals(v0Var.f16301e);
        }
        return false;
    }

    public boolean f() {
        return this.f16298b;
    }

    public int hashCode() {
        return (((((((this.f16297a.hashCode() * 31) + (this.f16298b ? 1 : 0)) * 31) + this.f16299c.hashCode()) * 31) + this.f16300d.hashCode()) * 31) + this.f16301e.hashCode();
    }
}
