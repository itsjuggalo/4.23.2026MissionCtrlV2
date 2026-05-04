package j$.time;

import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements j$.time.temporal.m, j$.time.temporal.n, j$.time.chrono.b, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f13699d = b0(-999999999, 1, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f13700e = b0(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final short f13702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f13703c;

    static {
        b0(1970, 1, 1);
    }

    public static h b0(int i10, int i11, int i12) {
        j$.time.temporal.a.YEAR.X(i10);
        j$.time.temporal.a.MONTH_OF_YEAR.X(i11);
        j$.time.temporal.a.DAY_OF_MONTH.X(i12);
        return A(i10, i11, i12);
    }

    public static h d0(int i10, int i11) {
        long j10 = i10;
        j$.time.temporal.a.YEAR.X(j10);
        j$.time.temporal.a.DAY_OF_YEAR.X(i11);
        j$.time.chrono.s.f13607c.getClass();
        boolean zX = j$.time.chrono.s.X(j10);
        if (i11 == 366 && !zX) {
            throw new c("Invalid date 'DayOfYear 366' as '" + i10 + "' is not a leap year");
        }
        n nVarI = n.I(((i11 - 1) / 31) + 1);
        if (i11 > (nVarI.A(zX) + nVarI.s(zX)) - 1) {
            nVarI = n.f13717a[((((int) 1) + 12) + nVarI.ordinal()) % 12];
        }
        return new h(i10, nVarI.getValue(), (i11 - nVarI.s(zX)) + 1);
    }

    public static h c0(long j10) {
        long j11;
        j$.time.temporal.a.EPOCH_DAY.X(j10);
        long j12 = 719468 + j10;
        if (j12 < 0) {
            long j13 = ((j10 + 719469) / 146097) - 1;
            j11 = j13 * 400;
            j12 += (-j13) * 146097;
        } else {
            j11 = 0;
        }
        long j14 = ((j12 * 400) + 591) / 146097;
        long j15 = j12 - ((j14 / 400) + (((j14 / 4) + (j14 * 365)) - (j14 / 100)));
        if (j15 < 0) {
            j14--;
            j15 = j12 - ((j14 / 400) + (((j14 / 4) + (365 * j14)) - (j14 / 100)));
        }
        int i10 = (int) j15;
        int i11 = ((i10 * 5) + 2) / 153;
        int i12 = ((i11 + 2) % 12) + 1;
        int i13 = (i10 - (((i11 * 306) + 5) / 10)) + 1;
        long j16 = j14 + j11 + ((long) (i11 / 10));
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return new h(aVar.f13735b.a(j16, aVar), i12, i13);
    }

    public static h F(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        h hVar = (h) temporalAccessor.b(j$.time.temporal.r.f13758f);
        if (hVar != null) {
            return hVar;
        }
        throw new c("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static h A(int i10, int i11, int i12) {
        int i13 = 28;
        if (i12 > 28) {
            if (i11 != 2) {
                i13 = (i11 == 4 || i11 == 6 || i11 == 9 || i11 == 11) ? 30 : 31;
            } else {
                j$.time.chrono.s.f13607c.getClass();
                if (j$.time.chrono.s.X(i10)) {
                    i13 = 29;
                }
            }
            if (i12 > i13) {
                if (i12 == 29) {
                    throw new c("Invalid date 'February 29' as '" + i10 + "' is not a leap year");
                }
                throw new c("Invalid date '" + n.I(i11).name() + " " + i12 + "'");
            }
        }
        return new h(i10, i11, i12);
    }

    public static h j0(int i10, int i11, int i12) {
        if (i11 == 2) {
            j$.time.chrono.s.f13607c.getClass();
            i12 = Math.min(i12, j$.time.chrono.s.X((long) i10) ? 29 : 28);
        } else if (i11 == 4 || i11 == 6 || i11 == 9 || i11 == 11) {
            i12 = Math.min(i12, 30);
        }
        return new h(i10, i11, i12);
    }

    public h(int i10, int i11, int i12) {
        this.f13701a = i10;
        this.f13702b = (short) i11;
        this.f13703c = (short) i12;
    }

    public static h a0(a aVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Instant instant = Instant.f13541c;
        long j10 = 1000;
        Instant instantS = Instant.s(Math.floorDiv(jCurrentTimeMillis, j10), ((int) Math.floorMod(jCurrentTimeMillis, j10)) * 1000000);
        ZoneId zoneId = aVar.f13562a;
        Objects.requireNonNull(instantS, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return c0(Math.floorDiv(instantS.f13542a + ((long) zoneId.s().d(instantS).f13556b), 86400));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.A(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        if (!aVar.isDateBased()) {
            throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
        int i10 = g.f13697a[aVar.ordinal()];
        if (i10 == 1) {
            return j$.time.temporal.u.f(1L, Z());
        }
        if (i10 == 2) {
            return j$.time.temporal.u.f(1L, Y() ? 366 : 365);
        }
        if (i10 != 3) {
            return i10 != 4 ? aVar.f13735b : this.f13701a <= 0 ? j$.time.temporal.u.f(1L, 1000000000L) : j$.time.temporal.u.f(1L, 999999999L);
        }
        return j$.time.temporal.u.f(1L, (n.I(this.f13702b) != n.FEBRUARY || Y()) ? 5L : 4L);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return I(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.EPOCH_DAY) {
                return K();
            }
            if (qVar != j$.time.temporal.a.PROLEPTIC_MONTH) {
                return I(qVar);
            }
            return ((((long) this.f13701a) * 12) + ((long) this.f13702b)) - 1;
        }
        return qVar.P(this);
    }

    public final int I(j$.time.temporal.q qVar) {
        switch (g.f13697a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f13703c;
            case 2:
                return V();
            case 3:
                return ((this.f13703c - 1) / 7) + 1;
            case 4:
                int i10 = this.f13701a;
                return i10 >= 1 ? i10 : 1 - i10;
            case 5:
                return P().getValue();
            case 6:
                return ((this.f13703c - 1) % 7) + 1;
            case 7:
                return ((V() - 1) % 7) + 1;
            case 8:
                throw new j$.time.temporal.t("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((V() - 1) / 7) + 1;
            case 10:
                return this.f13702b;
            case 11:
                throw new j$.time.temporal.t("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.f13701a;
            case 13:
                return this.f13701a >= 1 ? 1 : 0;
            default:
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.l f() {
        return j$.time.chrono.s.f13607c;
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.m N() {
        return this.f13701a >= 1 ? j$.time.chrono.t.CE : j$.time.chrono.t.BCE;
    }

    public final int V() {
        return (n.I(this.f13702b).s(Y()) + this.f13703c) - 1;
    }

    public final DayOfWeek P() {
        return DayOfWeek.s(((int) Math.floorMod(K() + 3, 7)) + 1);
    }

    public final boolean Y() {
        j$.time.chrono.s sVar = j$.time.chrono.s.f13607c;
        long j10 = this.f13701a;
        sVar.getClass();
        return j$.time.chrono.s.X(j10);
    }

    public final int Z() {
        short s10 = this.f13702b;
        return s10 != 2 ? (s10 == 4 || s10 == 6 || s10 == 9 || s10 == 11) ? 30 : 31 : Y() ? 29 : 28;
    }

    @Override // j$.time.chrono.b
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final h m(j$.time.temporal.n nVar) {
        if (nVar instanceof h) {
            return (h) nVar;
        }
        return (h) nVar.e(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public final h c(long j10, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (h) qVar.V(this, j10);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.X(j10);
        switch (g.f13697a[aVar.ordinal()]) {
            case 1:
                int i10 = (int) j10;
                if (this.f13703c != i10) {
                    return b0(this.f13701a, this.f13702b, i10);
                }
                return this;
            case 2:
                int i11 = (int) j10;
                if (V() != i11) {
                    return d0(this.f13701a, i11);
                }
                return this;
            case 3:
                return h0(j10 - i(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (this.f13701a < 1) {
                    j10 = 1 - j10;
                }
                return m0((int) j10);
            case 5:
                return f0(j10 - ((long) P().getValue()));
            case 6:
                return f0(j10 - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return f0(j10 - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return c0(j10);
            case 9:
                return h0(j10 - i(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
            case 10:
                int i12 = (int) j10;
                if (this.f13702b != i12) {
                    j$.time.temporal.a.MONTH_OF_YEAR.X(i12);
                    return j0(this.f13701a, i12, this.f13703c);
                }
                return this;
            case 11:
                return g0(j10 - (((((long) this.f13701a) * 12) + ((long) this.f13702b)) - 1));
            case 12:
                return m0((int) j10);
            case 13:
                if (i(j$.time.temporal.a.ERA) != j10) {
                    return m0(1 - this.f13701a);
                }
                return this;
            default:
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
    }

    public final h m0(int i10) {
        if (this.f13701a == i10) {
            return this;
        }
        j$.time.temporal.a.YEAR.X(i10);
        return j0(i10, this.f13702b, this.f13703c);
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.b R(j$.time.temporal.p pVar) {
        if (pVar != null) {
            s sVar = (s) pVar;
            return g0((((long) sVar.f13728a) * 12) + ((long) sVar.f13729b)).f0(sVar.f13730c);
        }
        Objects.requireNonNull(pVar, "amountToAdd");
        return (h) ((s) pVar).s(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public final h d(long j10, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (h) sVar.s(this, j10);
        }
        switch (g.f13698b[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return f0(j10);
            case 2:
                return h0(j10);
            case 3:
                return g0(j10);
            case 4:
                return i0(j10);
            case 5:
                return i0(Math.multiplyExact(j10, 10));
            case 6:
                return i0(Math.multiplyExact(j10, 100));
            case 7:
                return i0(Math.multiplyExact(j10, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return c(Math.addExact(i(aVar), j10), aVar);
            default:
                throw new j$.time.temporal.t("Unsupported unit: " + sVar);
        }
    }

    public final h i0(long j10) {
        if (j10 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return j0(aVar.f13735b.a(((long) this.f13701a) + j10, aVar), this.f13702b, this.f13703c);
    }

    public final h g0(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = (((long) this.f13701a) * 12) + ((long) (this.f13702b - 1)) + j10;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        long j12 = 12;
        return j0(aVar.f13735b.a(Math.floorDiv(j11, j12), aVar), ((int) Math.floorMod(j11, j12)) + 1, this.f13703c);
    }

    public final h h0(long j10) {
        return f0(Math.multiplyExact(j10, 7));
    }

    public final h f0(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = ((long) this.f13703c) + j10;
        if (j11 > 0) {
            if (j11 <= 28) {
                return new h(this.f13701a, this.f13702b, (int) j11);
            }
            if (j11 <= 59) {
                long jZ = Z();
                if (j11 <= jZ) {
                    return new h(this.f13701a, this.f13702b, (int) j11);
                }
                short s10 = this.f13702b;
                if (s10 < 12) {
                    return new h(this.f13701a, s10 + 1, (int) (j11 - jZ));
                }
                j$.time.temporal.a.YEAR.X(this.f13701a + 1);
                return new h(this.f13701a + 1, 1, (int) (j11 - jZ));
            }
        }
        return c0(Math.addExact(K(), j10));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.s sVar) {
        return j10 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j10, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        return iVar == j$.time.temporal.r.f13758f ? this : super.b(iVar);
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.e L(l lVar) {
        return LocalDateTime.I(this, lVar);
    }

    @Override // j$.time.chrono.b
    public final long K() {
        long j10 = this.f13701a;
        long j11 = this.f13702b;
        long j12 = 365 * j10;
        long j13 = (((367 * j11) - 362) / 12) + (j10 >= 0 ? ((j10 + 399) / 400) + (((3 + j10) / 4) - ((99 + j10) / 100)) + j12 : j12 - ((j10 / (-400)) + ((j10 / (-4)) - (j10 / (-100))))) + ((long) (this.f13703c - 1));
        if (j11 > 2) {
            j13 = !Y() ? j13 - 2 : j13 - 1;
        }
        return j13 - 719528;
    }

    @Override // j$.time.chrono.b, java.lang.Comparable
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.b bVar) {
        if (bVar instanceof h) {
            return s((h) bVar);
        }
        return super.compareTo(bVar);
    }

    public final int s(h hVar) {
        int i10 = this.f13701a - hVar.f13701a;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.f13702b - hVar.f13702b;
        return i11 == 0 ? this.f13703c - hVar.f13703c : i11;
    }

    public final boolean X(j$.time.chrono.b bVar) {
        return bVar instanceof h ? s((h) bVar) < 0 : K() < bVar.K();
    }

    @Override // j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && s((h) obj) == 0;
    }

    @Override // j$.time.chrono.b
    public final int hashCode() {
        int i10 = this.f13701a;
        return (((i10 << 11) + (this.f13702b << 6)) + this.f13703c) ^ (i10 & (-2048));
    }

    @Override // j$.time.chrono.b
    public final String toString() {
        int i10 = this.f13701a;
        short s10 = this.f13702b;
        short s11 = this.f13703c;
        int iAbs = Math.abs(i10);
        StringBuilder sb2 = new StringBuilder(10);
        if (iAbs >= 1000) {
            if (i10 > 9999) {
                sb2.append('+');
            }
            sb2.append(i10);
        } else if (i10 < 0) {
            sb2.append(i10 - 10000);
            sb2.deleteCharAt(1);
        } else {
            sb2.append(i10 + 10000);
            sb2.deleteCharAt(0);
        }
        sb2.append(s10 < 10 ? "-0" : "-");
        sb2.append((int) s10);
        sb2.append(s11 < 10 ? "-0" : "-");
        sb2.append((int) s11);
        return sb2.toString();
    }

    private Object writeReplace() {
        return new t((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
