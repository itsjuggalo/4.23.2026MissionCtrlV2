package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f13770c = 0;
    private static final long serialVersionUID = 4183400860270640070L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13772b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        x xVar = (x) obj;
        int i10 = this.f13771a - xVar.f13771a;
        return i10 == 0 ? this.f13772b - xVar.f13772b : i10;
    }

    static {
        j$.time.format.o oVar = new j$.time.format.o();
        oVar.h(j$.time.temporal.a.YEAR, 4, 10, j$.time.format.y.EXCEEDS_PAD);
        oVar.c('-');
        oVar.g(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        oVar.l(Locale.getDefault(), j$.time.format.x.SMART, null);
    }

    public x(int i10, int i11) {
        this.f13771a = i10;
        this.f13772b = i11;
    }

    public final x P(int i10, int i11) {
        return (this.f13771a == i10 && this.f13772b == i11) ? this : new x(i10, i11);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.YEAR || qVar == j$.time.temporal.a.MONTH_OF_YEAR || qVar == j$.time.temporal.a.PROLEPTIC_MONTH || qVar == j$.time.temporal.a.YEAR_OF_ERA || qVar == j$.time.temporal.a.ERA : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.u.f(1L, this.f13771a <= 0 ? 1000000000L : 999999999L);
        }
        return super.l(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        return l(qVar).a(i(qVar), qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        int i10;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.P(this);
        }
        int i11 = w.f13768a[((j$.time.temporal.a) qVar).ordinal()];
        if (i11 == 1) {
            i10 = this.f13772b;
        } else {
            if (i11 == 2) {
                return s();
            }
            if (i11 == 3) {
                int i12 = this.f13771a;
                if (i12 < 1) {
                    i12 = 1 - i12;
                }
                return i12;
            }
            if (i11 != 4) {
                if (i11 == 5) {
                    return this.f13771a < 1 ? 0 : 1;
                }
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
            }
            i10 = this.f13771a;
        }
        return i10;
    }

    public final long s() {
        return ((((long) this.f13771a) * 12) + ((long) this.f13772b)) - 1;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return (x) hVar.e(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public final x c(long j10, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (x) qVar.V(this, j10);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.X(j10);
        int i10 = w.f13768a[aVar.ordinal()];
        if (i10 == 1) {
            int i11 = (int) j10;
            j$.time.temporal.a.MONTH_OF_YEAR.X(i11);
            return P(this.f13771a, i11);
        }
        if (i10 == 2) {
            return F(j10 - s());
        }
        if (i10 == 3) {
            if (this.f13771a < 1) {
                j10 = 1 - j10;
            }
            int i12 = (int) j10;
            j$.time.temporal.a.YEAR.X(i12);
            return P(i12, this.f13772b);
        }
        if (i10 == 4) {
            int i13 = (int) j10;
            j$.time.temporal.a.YEAR.X(i13);
            return P(i13, this.f13772b);
        }
        if (i10 != 5) {
            throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
        if (i(j$.time.temporal.a.ERA) == j10) {
            return this;
        }
        int i14 = 1 - this.f13771a;
        j$.time.temporal.a.YEAR.X(i14);
        return P(i14, this.f13772b);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final x d(long j10, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (x) sVar.s(this, j10);
        }
        switch (w.f13769b[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return F(j10);
            case 2:
                return I(j10);
            case 3:
                return I(Math.multiplyExact(j10, 10));
            case 4:
                return I(Math.multiplyExact(j10, 100));
            case 5:
                return I(Math.multiplyExact(j10, 1000));
            case 6:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return c(Math.addExact(i(aVar), j10), aVar);
            default:
                throw new j$.time.temporal.t("Unsupported unit: " + sVar);
        }
    }

    public final x I(long j10) {
        if (j10 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return P(aVar.f13735b.a(((long) this.f13771a) + j10, aVar), this.f13772b);
    }

    public final x F(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = (((long) this.f13771a) * 12) + ((long) (this.f13772b - 1)) + j10;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        long j12 = 12;
        return P(aVar.f13735b.a(Math.floorDiv(j11, j12), aVar), ((int) Math.floorMod(j11, j12)) + 1);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.s sVar) {
        return j10 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j10, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f13754b) {
            return j$.time.chrono.s.f13607c;
        }
        if (iVar == j$.time.temporal.r.f13755c) {
            return j$.time.temporal.b.MONTHS;
        }
        return super.b(iVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        if (!j$.time.chrono.l.r(mVar).equals(j$.time.chrono.s.f13607c)) {
            throw new c("Adjustment only supported on ISO date-time");
        }
        return mVar.c(s(), j$.time.temporal.a.PROLEPTIC_MONTH);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.f13771a == xVar.f13771a && this.f13772b == xVar.f13772b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13771a ^ (this.f13772b << 27);
    }

    public final String toString() {
        int iAbs = Math.abs(this.f13771a);
        StringBuilder sb2 = new StringBuilder(9);
        if (iAbs < 1000) {
            int i10 = this.f13771a;
            if (i10 < 0) {
                sb2.append(i10 - 10000);
                sb2.deleteCharAt(1);
            } else {
                sb2.append(i10 + 10000);
                sb2.deleteCharAt(0);
            }
        } else {
            sb2.append(this.f13771a);
        }
        sb2.append(this.f13772b < 10 ? "-0" : "-");
        sb2.append(this.f13772b);
        return sb2.toString();
    }

    private Object writeReplace() {
        return new t((byte) 12, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
