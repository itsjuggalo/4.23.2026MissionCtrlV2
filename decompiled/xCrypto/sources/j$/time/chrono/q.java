package j$.time.chrono;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends AbstractC1551d {
    private static final long serialVersionUID = -5207853542612002020L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient o f13172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient int f13173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient int f13174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int f13175d;

    static q Z(o oVar, int i4, int i5, int i6) {
        return new q(oVar, i4, i5, i6);
    }

    static q a0(o oVar, long j4) {
        return new q(oVar, j4);
    }

    private q(o oVar, int i4, int i5, int i6) {
        oVar.d0(i4, i5, i6);
        this.f13172a = oVar;
        this.f13173b = i4;
        this.f13174c = i5;
        this.f13175d = i6;
    }

    private q(o oVar, long j4) {
        int[] iArrE0 = oVar.e0((int) j4);
        this.f13172a = oVar;
        this.f13173b = iArrE0[0];
        this.f13174c = iArrE0[1];
        this.f13175d = iArrE0[2];
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final l h() {
        return this.f13172a;
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final m u() {
        return r.AH;
    }

    public final int W() {
        return this.f13172a.g0(this.f13173b);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.J(this);
        }
        if (!f(rVar)) {
            throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        int i4 = p.f13171a[aVar.ordinal()];
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? this.f13172a.U(aVar) : j$.time.temporal.w.j(1L, 5L) : j$.time.temporal.w.j(1L, W()) : j$.time.temporal.w.j(1L, r2.f0(this.f13173b, this.f13174c));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.r(this);
        }
        int i4 = p.f13171a[((j$.time.temporal.a) rVar).ordinal()];
        int i5 = this.f13174c;
        int i6 = this.f13175d;
        int i7 = this.f13173b;
        switch (i4) {
            case 1:
                return i6;
            case 2:
                return T();
            case 3:
                return ((i6 - 1) / 7) + 1;
            case 4:
                return ((int) Math.floorMod(v() + 3, 7)) + 1;
            case 5:
                return ((i6 - 1) % 7) + 1;
            case 6:
                return ((T() - 1) % 7) + 1;
            case 7:
                return v();
            case 8:
                return ((T() - 1) / 7) + 1;
            case 9:
                return i5;
            case 10:
                return ((((long) i7) * 12) + ((long) i5)) - 1;
            case 11:
                return i7;
            case 12:
                return i7;
            case 13:
                return i7 <= 1 ? 0 : 1;
            default:
                throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.temporal.m
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public final q b(long j4, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (q) super.b(j4, rVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        o oVar = this.f13172a;
        oVar.U(aVar).b(j4, aVar);
        int i4 = (int) j4;
        int i5 = p.f13171a[aVar.ordinal()];
        int i6 = this.f13175d;
        int i7 = this.f13174c;
        int i8 = this.f13173b;
        switch (i5) {
            case 1:
                return d0(i8, i7, i4);
            case 2:
                return C(Math.min(i4, W()) - T());
            case 3:
                return C((j4 - g(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return C(j4 - ((long) (((int) Math.floorMod(v() + 3, 7)) + 1)));
            case 5:
                return C(j4 - g(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return C(j4 - g(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new q(oVar, j4);
            case 8:
                return C((j4 - g(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return d0(i8, i4, i6);
            case 10:
                return J(j4 - (((((long) i8) * 12) + ((long) i7)) - 1));
            case 11:
                if (i8 < 1) {
                    i4 = 1 - i4;
                }
                return d0(i4, i7, i6);
            case 12:
                return d0(i4, i7, i6);
            case 13:
                return d0(1 - i8, i7, i6);
            default:
                throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
    }

    private q d0(int i4, int i5, int i6) {
        o oVar = this.f13172a;
        int iF0 = oVar.f0(i4, i5);
        if (i6 > iF0) {
            i6 = iF0;
        }
        return new q(oVar, i4, i5, i6);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(j$.time.g gVar) {
        return (q) super.m(gVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final InterfaceC1549b m(j$.time.temporal.n nVar) {
        return (q) super.m(nVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final InterfaceC1549b M(j$.time.temporal.q qVar) {
        return (q) super.M(qVar);
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final long v() {
        return this.f13172a.d0(this.f13173b, this.f13174c, this.f13175d);
    }

    private int T() {
        return this.f13172a.c0(this.f13173b, this.f13174c) + this.f13175d;
    }

    @Override // j$.time.chrono.AbstractC1551d
    final InterfaceC1549b S(long j4) {
        return j4 == 0 ? this : d0(Math.addExact(this.f13173b, (int) j4), this.f13174c, this.f13175d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.time.chrono.AbstractC1551d
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public final q J(long j4) {
        if (j4 == 0) {
            return this;
        }
        long j5 = (((long) this.f13173b) * 12) + ((long) (this.f13174c - 1)) + j4;
        return d0(this.f13172a.a0(Math.floorDiv(j5, 12L)), ((int) Math.floorMod(j5, 12L)) + 1, this.f13175d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.time.chrono.AbstractC1551d
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public final q C(long j4) {
        return new q(this.f13172a, v() + j4);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public final InterfaceC1549b d(long j4, j$.time.temporal.u uVar) {
        return (q) super.d(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j4, j$.time.temporal.u uVar) {
        return (q) super.d(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public final InterfaceC1549b e(long j4, j$.time.temporal.u uVar) {
        return (q) super.e(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        return (q) super.e(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f13173b == qVar.f13173b && this.f13174c == qVar.f13174c && this.f13175d == qVar.f13175d && this.f13172a.equals(qVar.f13172a)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final int hashCode() {
        this.f13172a.getClass();
        int i4 = this.f13173b;
        return (((i4 << 11) + (this.f13174c << 6)) + this.f13175d) ^ ((i4 & (-2048)) ^ 2100100019);
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final InterfaceC1552e K(j$.time.k kVar) {
        return C1554g.C(this, kVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 6, this);
    }

    final void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.f13172a);
        objectOutput.writeInt(i(j$.time.temporal.a.YEAR));
        objectOutput.writeByte(i(j$.time.temporal.a.MONTH_OF_YEAR));
        objectOutput.writeByte(i(j$.time.temporal.a.DAY_OF_MONTH));
    }
}
