package j$.time;

import j$.time.format.z;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {
    private static final long serialVersionUID = 4183400860270640070L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13337b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        w wVar = (w) obj;
        int i4 = this.f13336a - wVar.f13336a;
        return i4 == 0 ? this.f13337b - wVar.f13337b : i4;
    }

    static {
        j$.time.format.p pVar = new j$.time.format.p();
        pVar.l(j$.time.temporal.a.YEAR, 4, 10, z.EXCEEDS_PAD);
        pVar.e('-');
        pVar.k(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        pVar.t();
    }

    private w(int i4, int i5) {
        this.f13336a = i4;
        this.f13337b = i5;
    }

    private w W(int i4, int i5) {
        return (this.f13336a == i4 && this.f13337b == i5) ? this : new w(i4, i5);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.YEAR || rVar == j$.time.temporal.a.MONTH_OF_YEAR || rVar == j$.time.temporal.a.PROLEPTIC_MONTH || rVar == j$.time.temporal.a.YEAR_OF_ERA || rVar == j$.time.temporal.a.ERA : rVar != null && rVar.W(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.w.j(1L, this.f13336a <= 0 ? 1000000000L : 999999999L);
        }
        return super.l(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        return l(rVar).a(g(rVar), rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.r(this);
        }
        int i4 = v.f13334a[((j$.time.temporal.a) rVar).ordinal()];
        if (i4 == 1) {
            return this.f13337b;
        }
        if (i4 == 2) {
            return r();
        }
        int i5 = this.f13336a;
        if (i4 == 3) {
            if (i5 < 1) {
                i5 = 1 - i5;
            }
            return i5;
        }
        if (i4 == 4) {
            return i5;
        }
        if (i4 == 5) {
            return i5 < 1 ? 0 : 1;
        }
        throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
    }

    private long r() {
        return ((((long) this.f13336a) * 12) + ((long) this.f13337b)) - 1;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(g gVar) {
        return (w) gVar.c(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final w b(long j4, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (w) rVar.p(this, j4);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        aVar.a0(j4);
        int i4 = v.f13334a[aVar.ordinal()];
        int i5 = this.f13336a;
        if (i4 == 1) {
            int i6 = (int) j4;
            j$.time.temporal.a.MONTH_OF_YEAR.a0(i6);
            return W(i5, i6);
        }
        if (i4 == 2) {
            return J(j4 - r());
        }
        int i7 = this.f13337b;
        if (i4 == 3) {
            if (i5 < 1) {
                j4 = 1 - j4;
            }
            int i8 = (int) j4;
            j$.time.temporal.a.YEAR.a0(i8);
            return W(i8, i7);
        }
        if (i4 == 4) {
            int i9 = (int) j4;
            j$.time.temporal.a.YEAR.a0(i9);
            return W(i9, i7);
        }
        if (i4 != 5) {
            throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        if (g(j$.time.temporal.a.ERA) == j4) {
            return this;
        }
        int i10 = 1 - i5;
        j$.time.temporal.a.YEAR.a0(i10);
        return W(i10, i7);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final w d(long j4, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (w) uVar.p(this, j4);
        }
        switch (v.f13335b[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return J(j4);
            case 2:
                return S(j4);
            case 3:
                return S(Math.multiplyExact(j4, 10));
            case 4:
                return S(Math.multiplyExact(j4, 100));
            case 5:
                return S(Math.multiplyExact(j4, 1000));
            case 6:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return b(Math.addExact(g(aVar), j4), aVar);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    public final w S(long j4) {
        return j4 == 0 ? this : W(j$.time.temporal.a.YEAR.Z(((long) this.f13336a) + j4), this.f13337b);
    }

    public final w J(long j4) {
        if (j4 == 0) {
            return this;
        }
        long j5 = (((long) this.f13336a) * 12) + ((long) (this.f13337b - 1)) + j4;
        long j6 = 12;
        return W(j$.time.temporal.a.YEAR.Z(Math.floorDiv(j5, j6)), ((int) Math.floorMod(j5, j6)) + 1);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, uVar).d(1L, uVar) : d(-j4, uVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.a()) {
            return j$.time.chrono.s.f13177d;
        }
        if (tVar == j$.time.temporal.s.e()) {
            return j$.time.temporal.b.MONTHS;
        }
        return super.a(tVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m c(j$.time.temporal.m mVar) {
        if (!j$.time.chrono.l.F(mVar).equals(j$.time.chrono.s.f13177d)) {
            throw new c("Adjustment only supported on ISO date-time");
        }
        return mVar.b(r(), j$.time.temporal.a.PROLEPTIC_MONTH);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (this.f13336a == wVar.f13336a && this.f13337b == wVar.f13337b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f13337b << 27) ^ this.f13336a;
    }

    public final String toString() {
        int i4 = this.f13336a;
        int iAbs = Math.abs(i4);
        StringBuilder sb = new StringBuilder(9);
        if (iAbs >= 1000) {
            sb.append(i4);
        } else if (i4 < 0) {
            sb.append(i4 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i4 + 10000);
            sb.deleteCharAt(0);
        }
        int i5 = this.f13337b;
        sb.append(i5 < 10 ? "-0" : "-");
        sb.append(i5);
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 12, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void a0(DataOutput dataOutput) {
        dataOutput.writeInt(this.f13336a);
        dataOutput.writeByte(this.f13337b);
    }

    static w T(ObjectInput objectInput) throws IOException {
        int i4 = objectInput.readInt();
        byte b4 = objectInput.readByte();
        j$.time.temporal.a.YEAR.a0(i4);
        j$.time.temporal.a.MONTH_OF_YEAR.a0(b4);
        return new w(i4, b4);
    }
}
