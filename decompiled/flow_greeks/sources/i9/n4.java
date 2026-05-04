package i9;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g9.g1 f12093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k1 f12096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j9.v f12097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j9.v f12098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.protobuf.i f12099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f12100h;

    public n4(g9.g1 g1Var, int i10, long j10, k1 k1Var, j9.v vVar, j9.v vVar2, com.google.protobuf.i iVar, Integer num) {
        this.f12093a = (g9.g1) n9.x.b(g1Var);
        this.f12094b = i10;
        this.f12095c = j10;
        this.f12098f = vVar2;
        this.f12096d = k1Var;
        this.f12097e = (j9.v) n9.x.b(vVar);
        this.f12099g = (com.google.protobuf.i) n9.x.b(iVar);
        this.f12100h = num;
    }

    public Integer a() {
        return this.f12100h;
    }

    public j9.v b() {
        return this.f12098f;
    }

    public k1 c() {
        return this.f12096d;
    }

    public com.google.protobuf.i d() {
        return this.f12099g;
    }

    public long e() {
        return this.f12095c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n4.class == obj.getClass()) {
            n4 n4Var = (n4) obj;
            if (this.f12093a.equals(n4Var.f12093a) && this.f12094b == n4Var.f12094b && this.f12095c == n4Var.f12095c && this.f12096d.equals(n4Var.f12096d) && this.f12097e.equals(n4Var.f12097e) && this.f12098f.equals(n4Var.f12098f) && this.f12099g.equals(n4Var.f12099g) && Objects.equals(this.f12100h, n4Var.f12100h)) {
                return true;
            }
        }
        return false;
    }

    public j9.v f() {
        return this.f12097e;
    }

    public g9.g1 g() {
        return this.f12093a;
    }

    public int h() {
        return this.f12094b;
    }

    public int hashCode() {
        return (((((((((((((this.f12093a.hashCode() * 31) + this.f12094b) * 31) + ((int) this.f12095c)) * 31) + this.f12096d.hashCode()) * 31) + this.f12097e.hashCode()) * 31) + this.f12098f.hashCode()) * 31) + this.f12099g.hashCode()) * 31) + Objects.hashCode(this.f12100h);
    }

    public n4 i(Integer num) {
        return new n4(this.f12093a, this.f12094b, this.f12095c, this.f12096d, this.f12097e, this.f12098f, this.f12099g, num);
    }

    public n4 j(j9.v vVar) {
        return new n4(this.f12093a, this.f12094b, this.f12095c, this.f12096d, this.f12097e, vVar, this.f12099g, this.f12100h);
    }

    public n4 k(com.google.protobuf.i iVar, j9.v vVar) {
        return new n4(this.f12093a, this.f12094b, this.f12095c, this.f12096d, vVar, this.f12098f, iVar, null);
    }

    public n4 l(long j10) {
        return new n4(this.f12093a, this.f12094b, j10, this.f12096d, this.f12097e, this.f12098f, this.f12099g, this.f12100h);
    }

    public String toString() {
        return "TargetData{target=" + this.f12093a + ", targetId=" + this.f12094b + ", sequenceNumber=" + this.f12095c + ", purpose=" + this.f12096d + ", snapshotVersion=" + this.f12097e + ", lastLimboFreeSnapshotVersion=" + this.f12098f + ", resumeToken=" + this.f12099g + ", expectedCount=" + this.f12100h + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public n4(g9.g1 g1Var, int i10, long j10, k1 k1Var) {
        j9.v vVar = j9.v.f14278b;
        this(g1Var, i10, j10, k1Var, vVar, vVar, m9.a1.f16118t, null);
    }
}
