package j$.time;

import j$.time.chrono.InterfaceC2030b;
import j$.time.chrono.InterfaceC2033e;
import j$.time.temporal.TemporalAccessor;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import k4.C2105D;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements j$.time.temporal.m, j$.time.temporal.n, InterfaceC2030b, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f17228d = g0(-999999999, 1, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f17229e = g0(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final short f17231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f17232c;

    static {
        g0(1970, 1, 1);
    }

    public static h h0(int i7, n nVar, int i8) {
        j$.time.temporal.a.YEAR.a0(i7);
        j$.time.temporal.a.DAY_OF_MONTH.a0(i8);
        return C(i7, nVar.p(), i8);
    }

    public static h g0(int i7, int i8, int i9) {
        j$.time.temporal.a.YEAR.a0(i7);
        j$.time.temporal.a.MONTH_OF_YEAR.a0(i8);
        j$.time.temporal.a.DAY_OF_MONTH.a0(i9);
        return C(i7, i8, i9);
    }

    public static h j0(int i7, int i8) {
        long j7 = i7;
        j$.time.temporal.a.YEAR.a0(j7);
        j$.time.temporal.a.DAY_OF_YEAR.a0(i8);
        j$.time.chrono.s.f17138d.getClass();
        boolean Z6 = j$.time.chrono.s.Z(j7);
        if (i8 == 366 && !Z6) {
            throw new c("Invalid date 'DayOfYear 366' as '" + i7 + "' is not a leap year");
        }
        n nVarS = n.S(((i8 - 1) / 31) + 1);
        if (i8 > (nVarS.C(Z6) + nVarS.r(Z6)) - 1) {
            nVarS = nVarS.T();
        }
        return new h(i7, nVarS.p(), (i8 - nVarS.r(Z6)) + 1);
    }

    public static h i0(long j7) {
        long j8;
        j$.time.temporal.a.EPOCH_DAY.a0(j7);
        long j9 = 719468 + j7;
        if (j9 < 0) {
            long j10 = ((j7 + 719469) / 146097) - 1;
            j8 = j10 * 400;
            j9 += (-j10) * 146097;
        } else {
            j8 = 0;
        }
        long j11 = ((j9 * 400) + 591) / 146097;
        long j12 = j9 - ((j11 / 400) + (((j11 / 4) + (j11 * 365)) - (j11 / 100)));
        if (j12 < 0) {
            j11--;
            j12 = j9 - ((j11 / 400) + (((j11 / 4) + (365 * j11)) - (j11 / 100)));
        }
        int i7 = (int) j12;
        int i8 = ((i7 * 5) + 2) / 153;
        return new h(j$.time.temporal.a.YEAR.Z(j11 + j8 + ((long) (i8 / 10))), ((i8 + 2) % 12) + 1, (i7 - (((i8 * 306) + 5) / 10)) + 1);
    }

    public static h J(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        h hVar = (h) temporalAccessor.a(j$.time.temporal.s.b());
        if (hVar != null) {
            return hVar;
        }
        throw new c("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    private static h C(int i7, int i8, int i9) {
        int i10 = 28;
        if (i9 > 28) {
            if (i8 != 2) {
                i10 = (i8 == 4 || i8 == 6 || i8 == 9 || i8 == 11) ? 30 : 31;
            } else {
                j$.time.chrono.s.f17138d.getClass();
                if (j$.time.chrono.s.Z(i7)) {
                    i10 = 29;
                }
            }
            if (i9 > i10) {
                if (i9 == 29) {
                    throw new c("Invalid date 'February 29' as '" + i7 + "' is not a leap year");
                }
                throw new c("Invalid date '" + n.S(i8).name() + " " + i9 + "'");
            }
        }
        return new h(i7, i8, i9);
    }

    private static h p0(int i7, int i8, int i9) {
        if (i8 == 2) {
            j$.time.chrono.s.f17138d.getClass();
            i9 = Math.min(i9, j$.time.chrono.s.Z((long) i7) ? 29 : 28);
        } else if (i8 == 4 || i8 == 6 || i8 == 9 || i8 == 11) {
            i9 = Math.min(i9, 30);
        }
        return new h(i7, i8, i9);
    }

    private h(int i7, int i8, int i9) {
        this.f17230a = i7;
        this.f17231b = (short) i8;
        this.f17232c = (short) i9;
    }

    public static h f0(b bVar) {
        Instant instantS = Instant.S(System.currentTimeMillis());
        ZoneId zoneIdA = bVar.a();
        Objects.requireNonNull(instantS, "instant");
        Objects.requireNonNull(zoneIdA, "zone");
        return i0(Math.floorDiv(instantS.C() + ((long) zoneIdA.r().d(instantS).Z()), 86400));
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
        int i7 = g.f17226a[aVar.ordinal()];
        if (i7 == 1) {
            return j$.time.temporal.w.j(1L, e0());
        }
        if (i7 == 2) {
            return j$.time.temporal.w.j(1L, d0() ? 366 : 365);
        }
        if (i7 == 3) {
            return j$.time.temporal.w.j(1L, (n.S(this.f17231b) != n.FEBRUARY || d0()) ? 5L : 4L);
        }
        if (i7 != 4) {
            return ((j$.time.temporal.a) rVar).C();
        }
        return j$.time.temporal.w.j(1L, this.f17230a <= 0 ? 1000000000L : 999999999L);
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
            return ((((long) this.f17230a) * 12) + ((long) this.f17231b)) - 1;
        }
        return rVar.r(this);
    }

    private int S(j$.time.temporal.r rVar) {
        int i7;
        int i8 = g.f17226a[((j$.time.temporal.a) rVar).ordinal()];
        short s7 = this.f17232c;
        int i9 = this.f17230a;
        switch (i8) {
            case 1:
                return s7;
            case 2:
                return Z();
            case 3:
                i7 = (s7 - 1) / 7;
                break;
            case 4:
                return i9 >= 1 ? i9 : 1 - i9;
            case 5:
                return W().p();
            case 6:
                i7 = (s7 - 1) % 7;
                break;
            case 7:
                return ((Z() - 1) % 7) + 1;
            case 8:
                throw new j$.time.temporal.v("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return ((Z() - 1) / 7) + 1;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return this.f17231b;
            case 11:
                throw new j$.time.temporal.v("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return i9;
            case 13:
                return i9 >= 1 ? 1 : 0;
            default:
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        return i7 + 1;
    }

    @Override // j$.time.chrono.InterfaceC2030b
    public final j$.time.chrono.l h() {
        return j$.time.chrono.s.f17138d;
    }

    @Override // j$.time.chrono.InterfaceC2030b
    public final j$.time.chrono.m u() {
        return this.f17230a >= 1 ? j$.time.chrono.t.CE : j$.time.chrono.t.BCE;
    }

    public final int b0() {
        return this.f17230a;
    }

    public final int a0() {
        return this.f17231b;
    }

    public final int Z() {
        return (n.S(this.f17231b).r(d0()) + this.f17232c) - 1;
    }

    public final int T() {
        return this.f17232c;
    }

    public final DayOfWeek W() {
        return DayOfWeek.r(((int) Math.floorMod(v() + 3, 7)) + 1);
    }

    public final boolean d0() {
        j$.time.chrono.s sVar = j$.time.chrono.s.f17138d;
        long j7 = this.f17230a;
        sVar.getClass();
        return j$.time.chrono.s.Z(j7);
    }

    public final int e0() {
        short s7 = this.f17231b;
        return s7 != 2 ? (s7 == 4 || s7 == 6 || s7 == 9 || s7 == 11) ? 30 : 31 : d0() ? 29 : 28;
    }

    @Override // j$.time.chrono.InterfaceC2030b
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final h m(j$.time.temporal.n nVar) {
        if (nVar instanceof h) {
            return (h) nVar;
        }
        return (h) nVar.c(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public final h b(long j7, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (h) rVar.p(this, j7);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        aVar.a0(j7);
        int i7 = g.f17226a[aVar.ordinal()];
        short s7 = this.f17232c;
        short s8 = this.f17231b;
        int i8 = this.f17230a;
        switch (i7) {
            case 1:
                int i9 = (int) j7;
                return s7 == i9 ? this : g0(i8, s8, i9);
            case 2:
                return s0((int) j7);
            case 3:
                return n0(j7 - g(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (i8 < 1) {
                    j7 = 1 - j7;
                }
                return t0((int) j7);
            case 5:
                return l0(j7 - ((long) W().p()));
            case 6:
                return l0(j7 - g(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return l0(j7 - g(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return i0(j7);
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return n0(j7 - g(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                int i10 = (int) j7;
                if (s8 == i10) {
                    return this;
                }
                j$.time.temporal.a.MONTH_OF_YEAR.a0(i10);
                return p0(i8, i10, s7);
            case 11:
                return m0(j7 - (((((long) i8) * 12) + ((long) s8)) - 1));
            case 12:
                return t0((int) j7);
            case 13:
                return g(j$.time.temporal.a.ERA) == j7 ? this : t0(1 - i8);
            default:
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
    }

    public final h t0(int i7) {
        if (this.f17230a == i7) {
            return this;
        }
        j$.time.temporal.a.YEAR.a0(i7);
        return p0(i7, this.f17231b, this.f17232c);
    }

    public final h s0(int i7) {
        return Z() == i7 ? this : j0(this.f17230a, i7);
    }

    @Override // j$.time.chrono.InterfaceC2030b
    public final InterfaceC2030b M(j$.time.temporal.q qVar) {
        if (qVar instanceof s) {
            return m0(((s) qVar).d()).l0(r4.a());
        }
        Objects.requireNonNull(qVar, "amountToAdd");
        return (h) qVar.p(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public final h d(long j7, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (h) uVar.p(this, j7);
        }
        switch (g.f17227b[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return l0(j7);
            case 2:
                return n0(j7);
            case 3:
                return m0(j7);
            case 4:
                return o0(j7);
            case 5:
                return o0(Math.multiplyExact(j7, 10));
            case 6:
                return o0(Math.multiplyExact(j7, 100));
            case 7:
                return o0(Math.multiplyExact(j7, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return b(Math.addExact(g(aVar), j7), aVar);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    public final h o0(long j7) {
        return j7 == 0 ? this : p0(j$.time.temporal.a.YEAR.Z(((long) this.f17230a) + j7), this.f17231b, this.f17232c);
    }

    public final h m0(long j7) {
        if (j7 == 0) {
            return this;
        }
        long j8 = (((long) this.f17230a) * 12) + ((long) (this.f17231b - 1)) + j7;
        long j9 = 12;
        return p0(j$.time.temporal.a.YEAR.Z(Math.floorDiv(j8, j9)), ((int) Math.floorMod(j8, j9)) + 1, this.f17232c);
    }

    public final h n0(long j7) {
        return l0(Math.multiplyExact(j7, 7));
    }

    public final h l0(long j7) {
        if (j7 == 0) {
            return this;
        }
        long j8 = ((long) this.f17232c) + j7;
        if (j8 > 0) {
            short s7 = this.f17231b;
            int i7 = this.f17230a;
            if (j8 <= 28) {
                return new h(i7, s7, (int) j8);
            }
            if (j8 <= 59) {
                long jE0 = e0();
                if (j8 <= jE0) {
                    return new h(i7, s7, (int) j8);
                }
                if (s7 < 12) {
                    return new h(i7, s7 + 1, (int) (j8 - jE0));
                }
                int i8 = i7 + 1;
                j$.time.temporal.a.YEAR.a0(i8);
                return new h(i8, 1, (int) (j8 - jE0));
            }
        }
        return i0(Math.addExact(v(), j7));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m e(long j7, j$.time.temporal.u uVar) {
        return j7 == Long.MIN_VALUE ? d(Long.MAX_VALUE, uVar).d(1L, uVar) : d(-j7, uVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.s.b() ? this : super.a(tVar);
    }

    @Override // j$.time.chrono.InterfaceC2030b
    public final InterfaceC2033e K(l lVar) {
        return LocalDateTime.h0(this, lVar);
    }

    @Override // j$.time.chrono.InterfaceC2030b
    public final long v() {
        long j7 = this.f17230a;
        long j8 = this.f17231b;
        long j9 = 365 * j7;
        long j10 = (((367 * j8) - 362) / 12) + (j7 >= 0 ? ((j7 + 399) / 400) + (((3 + j7) / 4) - ((99 + j7) / 100)) + j9 : j9 - ((j7 / (-400)) + ((j7 / (-4)) - (j7 / (-100))))) + ((long) (this.f17232c - 1));
        if (j8 > 2) {
            j10 = !d0() ? j10 - 2 : j10 - 1;
        }
        return j10 - 719528;
    }

    @Override // j$.time.chrono.InterfaceC2030b, java.lang.Comparable
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public final int compareTo(InterfaceC2030b interfaceC2030b) {
        if (interfaceC2030b instanceof h) {
            return r((h) interfaceC2030b);
        }
        return super.compareTo(interfaceC2030b);
    }

    final int r(h hVar) {
        int i7 = this.f17230a - hVar.f17230a;
        if (i7 != 0) {
            return i7;
        }
        int i8 = this.f17231b - hVar.f17231b;
        return i8 == 0 ? this.f17232c - hVar.f17232c : i8;
    }

    public final boolean c0(h hVar) {
        return hVar != null ? r(hVar) < 0 : v() < hVar.v();
    }

    @Override // j$.time.chrono.InterfaceC2030b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && r((h) obj) == 0;
    }

    @Override // j$.time.chrono.InterfaceC2030b
    public final int hashCode() {
        int i7 = this.f17230a;
        return (((i7 << 11) + (this.f17231b << 6)) + this.f17232c) ^ (i7 & (-2048));
    }

    @Override // j$.time.chrono.InterfaceC2030b
    public final String toString() {
        int i7 = this.f17230a;
        int iAbs = Math.abs(i7);
        StringBuilder sb = new StringBuilder(10);
        if (iAbs >= 1000) {
            if (i7 > 9999) {
                sb.append('+');
            }
            sb.append(i7);
        } else if (i7 < 0) {
            sb.append(i7 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i7 + 10000);
            sb.deleteCharAt(0);
        }
        short s7 = this.f17231b;
        sb.append(s7 < 10 ? "-0" : "-");
        sb.append((int) s7);
        short s8 = this.f17232c;
        sb.append(s8 < 10 ? "-0" : "-");
        sb.append((int) s8);
        return sb.toString();
    }

    private Object writeReplace() {
        return new t((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void u0(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.f17230a);
        dataOutput.writeByte(this.f17231b);
        dataOutput.writeByte(this.f17232c);
    }
}
