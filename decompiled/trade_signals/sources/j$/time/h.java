package j$.time;

import j$.time.chrono.InterfaceC2186b;
import j$.time.chrono.InterfaceC2189e;
import j$.time.temporal.TemporalAccessor;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements j$.time.temporal.m, j$.time.temporal.n, InterfaceC2186b, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f19805d = e0(-999999999, 1, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f19806e = e0(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final short f19808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f19809c;

    static {
        e0(1970, 1, 1);
    }

    private h(int i8, int i9, int i10) {
        this.f19807a = i8;
        this.f19808b = (short) i9;
        this.f19809c = (short) i10;
    }

    private static h A(int i8, int i9, int i10) {
        int i11 = 28;
        if (i10 > 28) {
            if (i9 != 2) {
                i11 = (i9 == 4 || i9 == 6 || i9 == 9 || i9 == 11) ? 30 : 31;
            } else {
                j$.time.chrono.s.f19713d.getClass();
                if (j$.time.chrono.s.X(i8)) {
                    i11 = 29;
                }
            }
            if (i10 > i11) {
                if (i10 == 29) {
                    throw new c("Invalid date 'February 29' as '" + i8 + "' is not a leap year");
                }
                throw new c("Invalid date '" + n.M(i9).name() + " " + i10 + "'");
            }
        }
        return new h(i8, i9, i10);
    }

    public static h H(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        h hVar = (h) temporalAccessor.b(j$.time.temporal.s.b());
        if (hVar != null) {
            return hVar;
        }
        throw new c("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    private int M(j$.time.temporal.r rVar) {
        int i8;
        int i9 = g.f19803a[((j$.time.temporal.a) rVar).ordinal()];
        short s8 = this.f19809c;
        int i10 = this.f19807a;
        switch (i9) {
            case 1:
                return s8;
            case 2:
                return X();
            case 3:
                i8 = (s8 - 1) / 7;
                break;
            case 4:
                return i10 >= 1 ? i10 : 1 - i10;
            case 5:
                return U().o();
            case 6:
                i8 = (s8 - 1) % 7;
                break;
            case 7:
                return ((X() - 1) % 7) + 1;
            case 8:
                throw new j$.time.temporal.v("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((X() - 1) / 7) + 1;
            case 10:
                return this.f19808b;
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                throw new j$.time.temporal.v("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return i10;
            case 13:
                return i10 >= 1 ? 1 : 0;
            default:
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        return i8 + 1;
    }

    public static h d0(b bVar) {
        Instant instantR = Instant.R(System.currentTimeMillis());
        ZoneId zoneIdA = bVar.a();
        Objects.requireNonNull(instantR, "instant");
        Objects.requireNonNull(zoneIdA, "zone");
        return g0(Math.floorDiv(instantR.A() + ((long) zoneIdA.q().d(instantR).X()), 86400));
    }

    public static h e0(int i8, int i9, int i10) {
        j$.time.temporal.a.YEAR.Y(i8);
        j$.time.temporal.a.MONTH_OF_YEAR.Y(i9);
        j$.time.temporal.a.DAY_OF_MONTH.Y(i10);
        return A(i8, i9, i10);
    }

    public static h f0(int i8, n nVar, int i9) {
        j$.time.temporal.a.YEAR.Y(i8);
        Objects.requireNonNull(nVar, "month");
        j$.time.temporal.a.DAY_OF_MONTH.Y(i9);
        return A(i8, nVar.o(), i9);
    }

    public static h g0(long j8) {
        long j9;
        j$.time.temporal.a.EPOCH_DAY.Y(j8);
        long j10 = 719468 + j8;
        if (j10 < 0) {
            long j11 = ((j8 + 719469) / 146097) - 1;
            j9 = j11 * 400;
            j10 += (-j11) * 146097;
        } else {
            j9 = 0;
        }
        long j12 = ((j10 * 400) + 591) / 146097;
        long j13 = j10 - ((j12 / 400) + (((j12 / 4) + (j12 * 365)) - (j12 / 100)));
        if (j13 < 0) {
            j12--;
            j13 = j10 - ((j12 / 400) + (((j12 / 4) + (365 * j12)) - (j12 / 100)));
        }
        int i8 = (int) j13;
        int i9 = ((i8 * 5) + 2) / 153;
        return new h(j$.time.temporal.a.YEAR.X(j12 + j9 + ((long) (i9 / 10))), ((i9 + 2) % 12) + 1, (i8 - (((i9 * 306) + 5) / 10)) + 1);
    }

    public static h h0(int i8, int i9) {
        long j8 = i8;
        j$.time.temporal.a.YEAR.Y(j8);
        j$.time.temporal.a.DAY_OF_YEAR.Y(i9);
        j$.time.chrono.s.f19713d.getClass();
        boolean zX = j$.time.chrono.s.X(j8);
        if (i9 == 366 && !zX) {
            throw new c("Invalid date 'DayOfYear 366' as '" + i8 + "' is not a leap year");
        }
        n nVarM = n.M(((i9 - 1) / 31) + 1);
        if (i9 > (nVarM.A(zX) + nVarM.q(zX)) - 1) {
            nVarM = nVarM.R();
        }
        return new h(i8, nVarM.o(), (i9 - nVarM.q(zX)) + 1);
    }

    private static h n0(int i8, int i9, int i10) {
        int i11;
        if (i9 != 2) {
            if (i9 == 4 || i9 == 6 || i9 == 9 || i9 == 11) {
                i11 = 30;
            }
            return new h(i8, i9, i10);
        }
        j$.time.chrono.s.f19713d.getClass();
        i11 = j$.time.chrono.s.X((long) i8) ? 29 : 28;
        i10 = Math.min(i10, i11);
        return new h(i8, i9, i10);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 3, this);
    }

    @Override // j$.time.chrono.InterfaceC2186b
    public final InterfaceC2189e I(l lVar) {
        return LocalDateTime.f0(this, lVar);
    }

    @Override // j$.time.chrono.InterfaceC2186b
    public final InterfaceC2186b K(j$.time.temporal.q qVar) {
        if (qVar instanceof s) {
            return k0(((s) qVar).d()).j0(r4.a());
        }
        Objects.requireNonNull(qVar, "amountToAdd");
        return (h) qVar.o(this);
    }

    public final int R() {
        return this.f19809c;
    }

    @Override // j$.time.chrono.InterfaceC2186b, java.lang.Comparable
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public final int compareTo(InterfaceC2186b interfaceC2186b) {
        return interfaceC2186b instanceof h ? q((h) interfaceC2186b) : super.compareTo(interfaceC2186b);
    }

    public final DayOfWeek U() {
        return DayOfWeek.q(((int) Math.floorMod(t() + 3, 7)) + 1);
    }

    public final int X() {
        return (n.M(this.f19808b).q(b0()) + this.f19809c) - 1;
    }

    public final int Y() {
        return this.f19808b;
    }

    public final int Z() {
        return this.f19807a;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j8, j$.time.temporal.u uVar) {
        return j8 == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j8, uVar);
    }

    public final boolean a0(InterfaceC2186b interfaceC2186b) {
        return interfaceC2186b instanceof h ? q((h) interfaceC2186b) < 0 : t() < interfaceC2186b.t();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.s.b() ? this : super.b(tVar);
    }

    public final boolean b0() {
        j$.time.chrono.s sVar = j$.time.chrono.s.f19713d;
        long j8 = this.f19807a;
        sVar.getClass();
        return j$.time.chrono.s.X(j8);
    }

    public final int c0() {
        short s8 = this.f19808b;
        return s8 != 2 ? (s8 == 4 || s8 == 6 || s8 == 9 || s8 == 11) ? 30 : 31 : b0() ? 29 : 28;
    }

    @Override // j$.time.chrono.InterfaceC2186b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && q((h) obj) == 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.EPOCH_DAY ? t() : rVar == j$.time.temporal.a.PROLEPTIC_MONTH ? ((((long) this.f19807a) * 12) + ((long) this.f19808b)) - 1 : M(rVar) : rVar.q(this);
    }

    @Override // j$.time.chrono.InterfaceC2186b
    public final j$.time.chrono.l h() {
        return j$.time.chrono.s.f19713d;
    }

    @Override // j$.time.chrono.InterfaceC2186b
    public final int hashCode() {
        int i8 = this.f19807a;
        return (((i8 << 11) + (this.f19808b << 6)) + this.f19809c) ^ (i8 & (-2048));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? M(rVar) : super.i(rVar);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public final h e(long j8, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (h) uVar.o(this, j8);
        }
        switch (g.f19804b[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return j0(j8);
            case 2:
                return l0(j8);
            case 3:
                return k0(j8);
            case 4:
                return m0(j8);
            case 5:
                return m0(Math.multiplyExact(j8, 10));
            case 6:
                return m0(Math.multiplyExact(j8, 100));
            case 7:
                return m0(Math.multiplyExact(j8, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return c(Math.addExact(g(aVar), j8), aVar);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    public final h j0(long j8) {
        if (j8 == 0) {
            return this;
        }
        long j9 = ((long) this.f19809c) + j8;
        if (j9 > 0) {
            short s8 = this.f19808b;
            int i8 = this.f19807a;
            if (j9 <= 28) {
                return new h(i8, s8, (int) j9);
            }
            if (j9 <= 59) {
                long jC0 = c0();
                if (j9 <= jC0) {
                    return new h(i8, s8, (int) j9);
                }
                if (s8 < 12) {
                    return new h(i8, s8 + 1, (int) (j9 - jC0));
                }
                int i9 = i8 + 1;
                j$.time.temporal.a.YEAR.Y(i9);
                return new h(i9, 1, (int) (j9 - jC0));
            }
        }
        return g0(Math.addExact(t(), j8));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w k(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.H(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        if (!aVar.R()) {
            throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        int i8 = g.f19803a[aVar.ordinal()];
        if (i8 == 1) {
            return j$.time.temporal.w.j(1L, c0());
        }
        if (i8 == 2) {
            return j$.time.temporal.w.j(1L, b0() ? 366 : 365);
        }
        if (i8 == 3) {
            return j$.time.temporal.w.j(1L, (n.M(this.f19808b) != n.FEBRUARY || b0()) ? 5L : 4L);
        }
        if (i8 != 4) {
            return ((j$.time.temporal.a) rVar).A();
        }
        return j$.time.temporal.w.j(1L, this.f19807a <= 0 ? 1000000000L : 999999999L);
    }

    public final h k0(long j8) {
        if (j8 == 0) {
            return this;
        }
        long j9 = (((long) this.f19807a) * 12) + ((long) (this.f19808b - 1)) + j8;
        long j10 = 12;
        return n0(j$.time.temporal.a.YEAR.X(Math.floorDiv(j9, j10)), ((int) Math.floorMod(j9, j10)) + 1, this.f19809c);
    }

    public final h l0(long j8) {
        return j0(Math.multiplyExact(j8, 7));
    }

    public final h m0(long j8) {
        return j8 == 0 ? this : n0(j$.time.temporal.a.YEAR.X(((long) this.f19807a) + j8), this.f19808b, this.f19809c);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public final h c(long j8, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (h) rVar.o(this, j8);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        aVar.Y(j8);
        int i8 = g.f19803a[aVar.ordinal()];
        short s8 = this.f19809c;
        short s9 = this.f19808b;
        int i9 = this.f19807a;
        switch (i8) {
            case 1:
                int i10 = (int) j8;
                return s8 == i10 ? this : e0(i9, s9, i10);
            case 2:
                return q0((int) j8);
            case 3:
                return l0(j8 - g(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (i9 < 1) {
                    j8 = 1 - j8;
                }
                return r0((int) j8);
            case 5:
                return j0(j8 - ((long) U().o()));
            case 6:
                return j0(j8 - g(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return j0(j8 - g(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return g0(j8);
            case 9:
                return l0(j8 - g(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
            case 10:
                int i11 = (int) j8;
                if (s9 == i11) {
                    return this;
                }
                j$.time.temporal.a.MONTH_OF_YEAR.Y(i11);
                return n0(i9, i11, s8);
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                return k0(j8 - (((((long) i9) * 12) + ((long) s9)) - 1));
            case 12:
                return r0((int) j8);
            case 13:
                return g(j$.time.temporal.a.ERA) == j8 ? this : r0(1 - i9);
            default:
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
    }

    @Override // j$.time.chrono.InterfaceC2186b
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final h l(j$.time.temporal.n nVar) {
        return nVar instanceof h ? (h) nVar : (h) nVar.d(this);
    }

    final int q(h hVar) {
        int i8 = this.f19807a - hVar.f19807a;
        if (i8 != 0) {
            return i8;
        }
        int i9 = this.f19808b - hVar.f19808b;
        return i9 == 0 ? this.f19809c - hVar.f19809c : i9;
    }

    public final h q0(int i8) {
        return X() == i8 ? this : h0(this.f19807a, i8);
    }

    public final h r0(int i8) {
        if (this.f19807a == i8) {
            return this;
        }
        j$.time.temporal.a.YEAR.Y(i8);
        return n0(i8, this.f19808b, this.f19809c);
    }

    @Override // j$.time.chrono.InterfaceC2186b
    public final j$.time.chrono.m s() {
        return this.f19807a >= 1 ? j$.time.chrono.t.CE : j$.time.chrono.t.BCE;
    }

    final void s0(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.f19807a);
        dataOutput.writeByte(this.f19808b);
        dataOutput.writeByte(this.f19809c);
    }

    @Override // j$.time.chrono.InterfaceC2186b
    public final long t() {
        long j8 = this.f19807a;
        long j9 = this.f19808b;
        long j10 = 365 * j8;
        long j11 = (((367 * j9) - 362) / 12) + (j8 >= 0 ? ((j8 + 399) / 400) + (((3 + j8) / 4) - ((99 + j8) / 100)) + j10 : j10 - ((j8 / (-400)) + ((j8 / (-4)) - (j8 / (-100))))) + ((long) (this.f19809c - 1));
        if (j9 > 2) {
            j11 = !b0() ? j11 - 2 : j11 - 1;
        }
        return j11 - 719528;
    }

    @Override // j$.time.chrono.InterfaceC2186b
    public final String toString() {
        int i8;
        int i9 = this.f19807a;
        int iAbs = Math.abs(i9);
        StringBuilder sb = new StringBuilder(10);
        if (iAbs < 1000) {
            if (i9 < 0) {
                sb.append(i9 - 10000);
                i8 = 1;
            } else {
                sb.append(i9 + 10000);
                i8 = 0;
            }
            sb.deleteCharAt(i8);
        } else {
            if (i9 > 9999) {
                sb.append('+');
            }
            sb.append(i9);
        }
        short s8 = this.f19808b;
        sb.append(s8 < 10 ? "-0" : "-");
        sb.append((int) s8);
        short s9 = this.f19809c;
        sb.append(s9 < 10 ? "-0" : "-");
        sb.append((int) s9);
        return sb.toString();
    }
}
