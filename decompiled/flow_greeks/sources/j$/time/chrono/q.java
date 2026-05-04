package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends d {
    private static final long serialVersionUID = -5207853542612002020L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient o f13602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient int f13603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f13604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f13605d;

    @Override // j$.time.chrono.b
    public final e L(j$.time.l lVar) {
        return new g(this, lVar);
    }

    public q(o oVar, int i10, int i11, int i12) {
        oVar.Z(i10, i11, i12);
        this.f13602a = oVar;
        this.f13603b = i10;
        this.f13604c = i11;
        this.f13605d = i12;
    }

    public q(o oVar, long j10) {
        int i10 = (int) j10;
        oVar.X();
        if (i10 < oVar.f13594e || i10 >= oVar.f13595f) {
            throw new j$.time.c("Hijrah date out of range");
        }
        int iBinarySearch = Arrays.binarySearch(oVar.f13593d, i10);
        iBinarySearch = iBinarySearch < 0 ? (-iBinarySearch) - 2 : iBinarySearch;
        int i11 = oVar.f13596g;
        int[] iArr = {(iBinarySearch + i11) / 12, ((i11 + iBinarySearch) % 12) + 1, (i10 - oVar.f13593d[iBinarySearch]) + 1};
        this.f13602a = oVar;
        this.f13603b = iArr[0];
        this.f13604c = iArr[1];
        this.f13605d = iArr[2];
    }

    @Override // j$.time.chrono.b
    public final l f() {
        return this.f13602a;
    }

    @Override // j$.time.chrono.b
    public final m N() {
        return r.AH;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.A(this);
        }
        if (!h(qVar)) {
            throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i10 = p.f13601a[aVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? this.f13602a.y(aVar) : j$.time.temporal.u.f(1L, 5L) : j$.time.temporal.u.f(1L, this.f13602a.c0(this.f13603b, 12)) : j$.time.temporal.u.f(1L, this.f13602a.a0(this.f13603b, this.f13604c));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.P(this);
        }
        switch (p.f13601a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f13605d;
            case 2:
                return P();
            case 3:
                return ((this.f13605d - 1) / 7) + 1;
            case 4:
                return ((int) Math.floorMod(K() + 3, 7)) + 1;
            case 5:
                return ((this.f13605d - 1) % 7) + 1;
            case 6:
                return ((P() - 1) % 7) + 1;
            case 7:
                return K();
            case 8:
                return ((P() - 1) / 7) + 1;
            case 9:
                return this.f13604c;
            case 10:
                return ((((long) this.f13603b) * 12) + ((long) this.f13604c)) - 1;
            case 11:
                return this.f13603b;
            case 12:
                return this.f13603b;
            case 13:
                return this.f13603b <= 1 ? 0 : 1;
            default:
                throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final q c(long j10, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (q) super.c(j10, qVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        this.f13602a.y(aVar).b(j10, aVar);
        int i10 = (int) j10;
        switch (p.f13601a[aVar.ordinal()]) {
            case 1:
                return Y(this.f13603b, this.f13604c, i10);
            case 2:
                return A(Math.min(i10, this.f13602a.c0(this.f13603b, 12)) - P());
            case 3:
                return A((j10 - i(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return A(j10 - ((long) (((int) Math.floorMod(K() + 3, 7)) + 1)));
            case 5:
                return A(j10 - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return A(j10 - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new q(this.f13602a, j10);
            case 8:
                return A((j10 - i(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return Y(this.f13603b, i10, this.f13605d);
            case 10:
                return F(j10 - (((((long) this.f13603b) * 12) + ((long) this.f13604c)) - 1));
            case 11:
                if (this.f13603b < 1) {
                    i10 = 1 - i10;
                }
                return Y(i10, this.f13604c, this.f13605d);
            case 12:
                return Y(i10, this.f13604c, this.f13605d);
            case 13:
                return Y(1 - this.f13603b, this.f13604c, this.f13605d);
            default:
                throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
    }

    public final q Y(int i10, int i11, int i12) {
        int iA0 = this.f13602a.a0(i10, i11);
        if (i12 > iA0) {
            i12 = iA0;
        }
        return new q(this.f13602a, i10, i11, i12);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.m m(j$.time.h hVar) {
        return (q) super.m(hVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b m(j$.time.temporal.n nVar) {
        return (q) super.m(nVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b R(j$.time.temporal.p pVar) {
        return (q) super.R(pVar);
    }

    @Override // j$.time.chrono.b
    public final long K() {
        return this.f13602a.Z(this.f13603b, this.f13604c, this.f13605d);
    }

    public final int P() {
        return this.f13602a.c0(this.f13603b, this.f13604c - 1) + this.f13605d;
    }

    @Override // j$.time.chrono.d
    public final b I(long j10) {
        return j10 == 0 ? this : Y(Math.addExact(this.f13603b, (int) j10), this.f13604c, this.f13605d);
    }

    @Override // j$.time.chrono.d
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final q F(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = (((long) this.f13603b) * 12) + ((long) (this.f13604c - 1)) + j10;
        o oVar = this.f13602a;
        long jFloorDiv = Math.floorDiv(j11, 12L);
        int i10 = oVar.f13596g;
        if (jFloorDiv >= i10 / 12 && jFloorDiv <= (((oVar.f13593d.length - 1) + i10) / 12) - 1) {
            return Y((int) jFloorDiv, ((int) Math.floorMod(j11, 12L)) + 1, this.f13605d);
        }
        throw new j$.time.c("Invalid Hijrah year: " + jFloorDiv);
    }

    @Override // j$.time.chrono.d
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public final q A(long j10) {
        return new q(this.f13602a, K() + j10);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b d(long j10, j$.time.temporal.s sVar) {
        return (q) super.d(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j10, j$.time.temporal.s sVar) {
        return (q) super.d(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b a(long j10, j$.time.temporal.s sVar) {
        return (q) super.a(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.s sVar) {
        return (q) super.a(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f13603b == qVar.f13603b && this.f13604c == qVar.f13604c && this.f13605d == qVar.f13605d && this.f13602a.equals(qVar.f13602a)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        int i10 = this.f13603b;
        int i11 = this.f13604c;
        int i12 = this.f13605d;
        this.f13602a.getClass();
        return (((i10 << 11) + (i11 << 6)) + i12) ^ ((i10 & (-2048)) ^ 2100100019);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 6, this);
    }
}
