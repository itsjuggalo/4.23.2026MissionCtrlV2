package P2;

import com.google.protobuf.AbstractC0472l;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N2.K f2418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final B f2421d;
    public final Q2.n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Q2.n f2422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AbstractC0472l f2423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f2424h;

    public X(N2.K k6, int i, long j4, B b3, Q2.n nVar, Q2.n nVar2, AbstractC0472l abstractC0472l, Integer num) {
        k6.getClass();
        this.f2418a = k6;
        this.f2419b = i;
        this.f2420c = j4;
        this.f2422f = nVar2;
        this.f2421d = b3;
        nVar.getClass();
        this.e = nVar;
        abstractC0472l.getClass();
        this.f2423g = abstractC0472l;
        this.f2424h = num;
    }

    public final X a(AbstractC0472l abstractC0472l, Q2.n nVar) {
        return new X(this.f2418a, this.f2419b, this.f2420c, this.f2421d, nVar, this.f2422f, abstractC0472l, null);
    }

    public final X b(long j4) {
        return new X(this.f2418a, this.f2419b, j4, this.f2421d, this.e, this.f2422f, this.f2423g, this.f2424h);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && X.class == obj.getClass()) {
            X x6 = (X) obj;
            if (this.f2418a.equals(x6.f2418a) && this.f2419b == x6.f2419b && this.f2420c == x6.f2420c && this.f2421d.equals(x6.f2421d) && this.e.equals(x6.e) && this.f2422f.equals(x6.f2422f) && this.f2423g.equals(x6.f2423g) && Objects.equals(this.f2424h, x6.f2424h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f2424h) + ((this.f2423g.hashCode() + ((this.f2422f.f2688a.hashCode() + ((this.e.f2688a.hashCode() + ((this.f2421d.hashCode() + (((((this.f2418a.hashCode() * 31) + this.f2419b) * 31) + ((int) this.f2420c)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TargetData{target=" + this.f2418a + ", targetId=" + this.f2419b + ", sequenceNumber=" + this.f2420c + ", purpose=" + this.f2421d + ", snapshotVersion=" + this.e + ", lastLimboFreeSnapshotVersion=" + this.f2422f + ", resumeToken=" + this.f2423g + ", expectedCount=" + this.f2424h + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public X(N2.K k6, int i, long j4, B b3) {
        Q2.n nVar = Q2.n.f2687b;
        this(k6, i, j4, b3, nVar, nVar, T2.J.f2927s, null);
    }
}
