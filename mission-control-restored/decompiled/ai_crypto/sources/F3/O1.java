package F3;

import com.google.protobuf.AbstractC1240i;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class O1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D3.h0 f2045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EnumC0511l0 f2048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final G3.v f2049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final G3.v f2050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AbstractC1240i f2051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f2052h;

    public O1(D3.h0 h0Var, int i7, long j7, EnumC0511l0 enumC0511l0, G3.v vVar, G3.v vVar2, AbstractC1240i abstractC1240i, Integer num) {
        this.f2045a = (D3.h0) K3.z.b(h0Var);
        this.f2046b = i7;
        this.f2047c = j7;
        this.f2050f = vVar2;
        this.f2048d = enumC0511l0;
        this.f2049e = (G3.v) K3.z.b(vVar);
        this.f2051g = (AbstractC1240i) K3.z.b(abstractC1240i);
        this.f2052h = num;
    }

    public Integer a() {
        return this.f2052h;
    }

    public G3.v b() {
        return this.f2050f;
    }

    public EnumC0511l0 c() {
        return this.f2048d;
    }

    public AbstractC1240i d() {
        return this.f2051g;
    }

    public long e() {
        return this.f2047c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || O1.class != obj.getClass()) {
            return false;
        }
        O1 o12 = (O1) obj;
        return this.f2045a.equals(o12.f2045a) && this.f2046b == o12.f2046b && this.f2047c == o12.f2047c && this.f2048d.equals(o12.f2048d) && this.f2049e.equals(o12.f2049e) && this.f2050f.equals(o12.f2050f) && this.f2051g.equals(o12.f2051g) && Objects.equals(this.f2052h, o12.f2052h);
    }

    public G3.v f() {
        return this.f2049e;
    }

    public D3.h0 g() {
        return this.f2045a;
    }

    public int h() {
        return this.f2046b;
    }

    public int hashCode() {
        return (((((((((((((this.f2045a.hashCode() * 31) + this.f2046b) * 31) + ((int) this.f2047c)) * 31) + this.f2048d.hashCode()) * 31) + this.f2049e.hashCode()) * 31) + this.f2050f.hashCode()) * 31) + this.f2051g.hashCode()) * 31) + Objects.hashCode(this.f2052h);
    }

    public O1 i(Integer num) {
        return new O1(this.f2045a, this.f2046b, this.f2047c, this.f2048d, this.f2049e, this.f2050f, this.f2051g, num);
    }

    public O1 j(G3.v vVar) {
        return new O1(this.f2045a, this.f2046b, this.f2047c, this.f2048d, this.f2049e, vVar, this.f2051g, this.f2052h);
    }

    public O1 k(AbstractC1240i abstractC1240i, G3.v vVar) {
        return new O1(this.f2045a, this.f2046b, this.f2047c, this.f2048d, vVar, this.f2050f, abstractC1240i, null);
    }

    public O1 l(long j7) {
        return new O1(this.f2045a, this.f2046b, j7, this.f2048d, this.f2049e, this.f2050f, this.f2051g, this.f2052h);
    }

    public String toString() {
        return "TargetData{target=" + this.f2045a + ", targetId=" + this.f2046b + ", sequenceNumber=" + this.f2047c + ", purpose=" + this.f2048d + ", snapshotVersion=" + this.f2049e + ", lastLimboFreeSnapshotVersion=" + this.f2050f + ", resumeToken=" + this.f2051g + ", expectedCount=" + this.f2052h + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public O1(D3.h0 h0Var, int i7, long j7, EnumC0511l0 enumC0511l0) {
        G3.v vVar = G3.v.f2475b;
        this(h0Var, i7, j7, enumC0511l0, vVar, vVar, J3.b0.f3193t, null);
    }
}
