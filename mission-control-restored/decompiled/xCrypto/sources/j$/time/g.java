package j$.time;

import j$.time.chrono.InterfaceC1549b;
import j$.time.chrono.InterfaceC1552e;
import j$.time.temporal.TemporalAccessor;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements j$.time.temporal.m, j$.time.temporal.n, InterfaceC1549b, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f13267d = g0(-999999999, 1, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f13268e = g0(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final short f13270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f13271c;

    static {
        g0(1970, 1, 1);
    }

    public static g h0(int i4, m mVar, int i5) {
        j$.time.temporal.a.YEAR.a0(i4);
        j$.time.temporal.a.DAY_OF_MONTH.a0(i5);
        return C(i4, mVar.p(), i5);
    }

    public static g g0(int i4, int i5, int i6) {
        j$.time.temporal.a.YEAR.a0(i4);
        j$.time.temporal.a.MONTH_OF_YEAR.a0(i5);
        j$.time.temporal.a.DAY_OF_MONTH.a0(i6);
        return C(i4, i5, i6);
    }

    public static g j0(int i4, int i5) {
        long j4 = i4;
        j$.time.temporal.a.YEAR.a0(j4);
        j$.time.temporal.a.DAY_OF_YEAR.a0(i5);
        j$.time.chrono.s.f13177d.getClass();
        boolean Z3 = j$.time.chrono.s.Z(j4);
        if (i5 == 366 && !Z3) {
            throw new c("Invalid date 'DayOfYear 366' as '" + i4 + "' is not a leap year");
        }
        m mVarS = m.S(((i5 - 1) / 31) + 1);
        if (i5 > (mVarS.C(Z3) + mVarS.r(Z3)) - 1) {
            mVarS = mVarS.T();
        }
        return new g(i4, mVarS.p(), (i5 - mVarS.r(Z3)) + 1);
    }

    public static g i0(long j4) {
        long j5;
        j$.time.temporal.a.EPOCH_DAY.a0(j4);
        long j6 = 719468 + j4;
        if (j6 < 0) {
            long j7 = ((j4 + 719469) / 146097) - 1;
            j5 = j7 * 400;
            j6 += (-j7) * 146097;
        } else {
            j5 = 0;
        }
        long j8 = ((j6 * 400) + 591) / 146097;
        long j9 = j6 - ((j8 / 400) + (((j8 / 4) + (j8 * 365)) - (j8 / 100)));
        if (j9 < 0) {
            j8--;
            j9 = j6 - ((j8 / 400) + (((j8 / 4) + (365 * j8)) - (j8 / 100)));
        }
        int i4 = (int) j9;
        int i5 = ((i4 * 5) + 2) / 153;
        return new g(j$.time.temporal.a.YEAR.Z(j8 + j5 + ((long) (i5 / 10))), ((i5 + 2) % 12) + 1, (i4 - (((i5 * 306) + 5) / 10)) + 1);
    }

    public static g J(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        g gVar = (g) temporalAccessor.a(j$.time.temporal.s.b());
        if (gVar != null) {
            return gVar;
        }
        throw new c("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    private static g C(int i4, int i5, int i6) {
        int i7 = 28;
        if (i6 > 28) {
            if (i5 != 2) {
                i7 = (i5 == 4 || i5 == 6 || i5 == 9 || i5 == 11) ? 30 : 31;
            } else {
                j$.time.chrono.s.f13177d.getClass();
                if (j$.time.chrono.s.Z(i4)) {
                    i7 = 29;
                }
            }
            if (i6 > i7) {
                if (i6 == 29) {
                    throw new c("Invalid date 'February 29' as '" + i4 + "' is not a leap year");
                }
                throw new c("Invalid date '" + m.S(i5).name() + " " + i6 + "'");
            }
        }
        return new g(i4, i5, i6);
    }

    private static g p0(int i4, int i5, int i6) {
        if (i5 == 2) {
            j$.time.chrono.s.f13177d.getClass();
            i6 = Math.min(i6, j$.time.chrono.s.Z((long) i4) ? 29 : 28);
        } else if (i5 == 4 || i5 == 6 || i5 == 9 || i5 == 11) {
            i6 = Math.min(i6, 30);
        }
        return new g(i4, i5, i6);
    }

    private g(int i4, int i5, int i6) {
        this.f13269a = i4;
        this.f13270b = (short) i5;
        this.f13271c = (short) i6;
    }

    public static g f0(b bVar) {
        Instant instantC = Instant.C(System.currentTimeMillis());
        ZoneId zoneIdA = bVar.a();
        Objects.requireNonNull(zoneIdA, "zone");
        return i0(Math.floorDiv(instantC.getEpochSecond() + ((long) zoneIdA.r().d(instantC).Z()), 86400));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.J(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        if (!aVar.T()) {
            throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        int i4 = f.f13194a[aVar.ordinal()];
        if (i4 == 1) {
            return j$.time.temporal.w.j(1L, e0());
        }
        if (i4 == 2) {
            return j$.time.temporal.w.j(1L, d0() ? 366 : 365);
        }
        if (i4 != 3) {
            return i4 != 4 ? ((j$.time.temporal.a) rVar).C() : this.f13269a <= 0 ? j$.time.temporal.w.j(1L, 1000000000L) : j$.time.temporal.w.j(1L, 999999999L);
        }
        return j$.time.temporal.w.j(1L, (m.S(this.f13270b) != m.FEBRUARY || d0()) ? 5L : 4L);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return S(rVar);
        }
        return super.i(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            if (rVar == j$.time.temporal.a.EPOCH_DAY) {
                return v();
            }
            if (rVar != j$.time.temporal.a.PROLEPTIC_MONTH) {
                return S(rVar);
            }
            return ((((long) this.f13269a) * 12) + ((long) this.f13270b)) - 1;
        }
        return rVar.r(this);
    }

    private int S(j$.time.temporal.r rVar) {
        int i4;
        int i5 = f.f13194a[((j$.time.temporal.a) rVar).ordinal()];
        short s4 = this.f13271c;
        int i6 = this.f13269a;
        switch (i5) {
            case 1:
                return s4;
            case 2:
                return Z();
            case 3:
                i4 = (s4 - 1) / 7;
                break;
            case 4:
                return i6 >= 1 ? i6 : 1 - i6;
            case 5:
                return W().p();
            case 6:
                i4 = (s4 - 1) % 7;
                break;
            case 7:
                return ((Z() - 1) % 7) + 1;
            case 8:
                throw new j$.time.temporal.v("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((Z() - 1) / 7) + 1;
            case 10:
                return this.f13270b;
            case 11:
                throw new j$.time.temporal.v("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return i6;
            case 13:
                return i6 >= 1 ? 1 : 0;
            default:
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        return i4 + 1;
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final j$.time.chrono.l h() {
        return j$.time.chrono.s.f13177d;
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final j$.time.chrono.m u() {
        return this.f13269a >= 1 ? j$.time.chrono.t.CE : j$.time.chrono.t.BCE;
    }

    public final int b0() {
        return this.f13269a;
    }

    public final int a0() {
        return this.f13270b;
    }

    public final int Z() {
        return (m.S(this.f13270b).r(d0()) + this.f13271c) - 1;
    }

    public final int T() {
        return this.f13271c;
    }

    public final DayOfWeek W() {
        return DayOfWeek.r(((int) Math.floorMod(v() + 3, 7)) + 1);
    }

    public final boolean d0() {
        j$.time.chrono.s sVar = j$.time.chrono.s.f13177d;
        long j4 = this.f13269a;
        sVar.getClass();
        return j$.time.chrono.s.Z(j4);
    }

    public final int e0() {
        short s4 = this.f13270b;
        return s4 != 2 ? (s4 == 4 || s4 == 6 || s4 == 9 || s4 == 11) ? 30 : 31 : d0() ? 29 : 28;
    }

    @Override // j$.time.chrono.InterfaceC1549b
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final g m(j$.time.temporal.n nVar) {
        if (nVar instanceof g) {
            return (g) nVar;
        }
        return (g) nVar.c(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public final g b(long j4, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (g) rVar.p(this, j4);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        aVar.a0(j4);
        int i4 = f.f13194a[aVar.ordinal()];
        short s4 = this.f13271c;
        short s5 = this.f13270b;
        int i5 = this.f13269a;
        switch (i4) {
            case 1:
                int i6 = (int) j4;
                if (s4 != i6) {
                    return g0(i5, s5, i6);
                }
                return this;
            case 2:
                return s0((int) j4);
            case 3:
                return n0(j4 - g(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (i5 < 1) {
                    j4 = 1 - j4;
                }
                return t0((int) j4);
            case 5:
                return l0(j4 - ((long) W().p()));
            case 6:
                return l0(j4 - g(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return l0(j4 - g(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return i0(j4);
            case 9:
                return n0(j4 - g(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
            case 10:
                int i7 = (int) j4;
                if (s5 != i7) {
                    j$.time.temporal.a.MONTH_OF_YEAR.a0(i7);
                    return p0(i5, i7, s4);
                }
                return this;
            case 11:
                return m0(j4 - (((((long) i5) * 12) + ((long) s5)) - 1));
            case 12:
                return t0((int) j4);
            case 13:
                if (g(j$.time.temporal.a.ERA) != j4) {
                    return t0(1 - i5);
                }
                return this;
            default:
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
    }

    public final g t0(int i4) {
        if (this.f13269a == i4) {
            return this;
        }
        j$.time.temporal.a.YEAR.a0(i4);
        return p0(i4, this.f13270b, this.f13271c);
    }

    public final g s0(int i4) {
        return Z() == i4 ? this : j0(this.f13269a, i4);
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final InterfaceC1549b M(j$.time.temporal.q qVar) {
        if (qVar instanceof r) {
            return m0(((r) qVar).d()).l0(r4.a());
        }
        Objects.requireNonNull(qVar, "amountToAdd");
        return (g) qVar.p(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public final g d(long j4, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (g) uVar.p(this, j4);
        }
        switch (f.f13195b[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return l0(j4);
            case 2:
                return n0(j4);
            case 3:
                return m0(j4);
            case 4:
                return o0(j4);
            case 5:
                return o0(Math.multiplyExact(j4, 10));
            case 6:
                return o0(Math.multiplyExact(j4, 100));
            case 7:
                return o0(Math.multiplyExact(j4, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return b(Math.addExact(g(aVar), j4), aVar);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    public final g o0(long j4) {
        return j4 == 0 ? this : p0(j$.time.temporal.a.YEAR.Z(((long) this.f13269a) + j4), this.f13270b, this.f13271c);
    }

    public final g m0(long j4) {
        if (j4 == 0) {
            return this;
        }
        long j5 = (((long) this.f13269a) * 12) + ((long) (this.f13270b - 1)) + j4;
        long j6 = 12;
        return p0(j$.time.temporal.a.YEAR.Z(Math.floorDiv(j5, j6)), ((int) Math.floorMod(j5, j6)) + 1, this.f13271c);
    }

    public final g n0(long j4) {
        return l0(Math.multiplyExact(j4, 7));
    }

    public final g l0(long j4) {
        if (j4 == 0) {
            return this;
        }
        long j5 = ((long) this.f13271c) + j4;
        if (j5 > 0) {
            short s4 = this.f13270b;
            int i4 = this.f13269a;
            if (j5 <= 28) {
                return new g(i4, s4, (int) j5);
            }
            if (j5 <= 59) {
                long jE0 = e0();
                if (j5 <= jE0) {
                    return new g(i4, s4, (int) j5);
                }
                if (s4 < 12) {
                    return new g(i4, s4 + 1, (int) (j5 - jE0));
                }
                int i5 = i4 + 1;
                j$.time.temporal.a.YEAR.a0(i5);
                return new g(i5, 1, (int) (j5 - jE0));
            }
        }
        return i0(Math.addExact(v(), j4));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, uVar).d(1L, uVar) : d(-j4, uVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.s.b() ? this : super.a(tVar);
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final InterfaceC1552e K(k kVar) {
        return LocalDateTime.h0(this, kVar);
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final long v() {
        long j4 = this.f13269a;
        long j5 = this.f13270b;
        long j6 = 365 * j4;
        long j7 = (((367 * j5) - 362) / 12) + (j4 >= 0 ? ((j4 + 399) / 400) + (((3 + j4) / 4) - ((99 + j4) / 100)) + j6 : j6 - ((j4 / (-400)) + ((j4 / (-4)) - (j4 / (-100))))) + ((long) (this.f13271c - 1));
        if (j5 > 2) {
            j7 = !d0() ? j7 - 2 : j7 - 1;
        }
        return j7 - 719528;
    }

    @Override // j$.time.chrono.InterfaceC1549b, java.lang.Comparable
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public final int compareTo(InterfaceC1549b interfaceC1549b) {
        if (interfaceC1549b instanceof g) {
            return r((g) interfaceC1549b);
        }
        return super.compareTo(interfaceC1549b);
    }

    final int r(g gVar) {
        int i4 = this.f13269a - gVar.f13269a;
        if (i4 != 0) {
            return i4;
        }
        int i5 = this.f13270b - gVar.f13270b;
        return i5 == 0 ? this.f13271c - gVar.f13271c : i5;
    }

    public final boolean c0(g gVar) {
        return gVar != null ? r(gVar) < 0 : v() < gVar.v();
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && r((g) obj) == 0;
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final int hashCode() {
        int i4 = this.f13269a;
        return (((i4 << 11) + (this.f13270b << 6)) + this.f13271c) ^ (i4 & (-2048));
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final String toString() {
        int i4 = this.f13269a;
        int iAbs = Math.abs(i4);
        StringBuilder sb = new StringBuilder(10);
        if (iAbs >= 1000) {
            if (i4 > 9999) {
                sb.append('+');
            }
            sb.append(i4);
        } else if (i4 < 0) {
            sb.append(i4 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i4 + 10000);
            sb.deleteCharAt(0);
        }
        short s4 = this.f13270b;
        sb.append(s4 < 10 ? "-0" : "-");
        sb.append((int) s4);
        short s5 = this.f13271c;
        sb.append(s5 < 10 ? "-0" : "-");
        sb.append((int) s5);
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void u0(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.f13269a);
        dataOutput.writeByte(this.f13270b);
        dataOutput.writeByte(this.f13271c);
    }
}
