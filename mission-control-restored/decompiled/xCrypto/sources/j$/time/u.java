package j$.time;

import j$.time.format.z;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f13332b = 0;
    private static final long serialVersionUID = -23038383694477807L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13333a;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f13333a - ((u) obj).f13333a;
    }

    static {
        j$.time.format.p pVar = new j$.time.format.p();
        pVar.l(j$.time.temporal.a.YEAR, 4, 10, z.EXCEEDS_PAD);
        pVar.t();
    }

    public static u r(int i4) {
        j$.time.temporal.a.YEAR.a0(i4);
        return new u(i4);
    }

    private u(int i4) {
        this.f13333a = i4;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.YEAR || rVar == j$.time.temporal.a.YEAR_OF_ERA || rVar == j$.time.temporal.a.ERA : rVar != null && rVar.W(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.w.j(1L, this.f13333a <= 0 ? 1000000000L : 999999999L);
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
        int i4 = t.f13298a[((j$.time.temporal.a) rVar).ordinal()];
        int i5 = this.f13333a;
        if (i4 == 1) {
            if (i5 < 1) {
                i5 = 1 - i5;
            }
            return i5;
        }
        if (i4 == 2) {
            return i5;
        }
        if (i4 == 3) {
            return i5 < 1 ? 0 : 1;
        }
        throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(g gVar) {
        return (u) gVar.c(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final u b(long j4, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (u) rVar.p(this, j4);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        aVar.a0(j4);
        int i4 = t.f13298a[aVar.ordinal()];
        int i5 = this.f13333a;
        if (i4 == 1) {
            if (i5 < 1) {
                j4 = 1 - j4;
            }
            return r((int) j4);
        }
        if (i4 == 2) {
            return r((int) j4);
        }
        if (i4 == 3) {
            return g(j$.time.temporal.a.ERA) == j4 ? this : r(1 - i5);
        }
        throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final u d(long j4, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (u) uVar.p(this, j4);
        }
        int i4 = t.f13299b[((j$.time.temporal.b) uVar).ordinal()];
        if (i4 == 1) {
            return J(j4);
        }
        if (i4 == 2) {
            return J(Math.multiplyExact(j4, 10));
        }
        if (i4 == 3) {
            return J(Math.multiplyExact(j4, 100));
        }
        if (i4 == 4) {
            return J(Math.multiplyExact(j4, 1000));
        }
        if (i4 == 5) {
            j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
            return b(Math.addExact(g(aVar), j4), aVar);
        }
        throw new j$.time.temporal.v("Unsupported unit: " + uVar);
    }

    public final u J(long j4) {
        return j4 == 0 ? this : r(j$.time.temporal.a.YEAR.Z(((long) this.f13333a) + j4));
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
            return j$.time.temporal.b.YEARS;
        }
        return super.a(tVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m c(j$.time.temporal.m mVar) {
        if (!j$.time.chrono.l.F(mVar).equals(j$.time.chrono.s.f13177d)) {
            throw new c("Adjustment only supported on ISO date-time");
        }
        return mVar.b(this.f13333a, j$.time.temporal.a.YEAR);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            if (this.f13333a == ((u) obj).f13333a) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13333a;
    }

    public final String toString() {
        return Integer.toString(this.f13333a);
    }

    private Object writeReplace() {
        return new s((byte) 11, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void T(DataOutput dataOutput) {
        dataOutput.writeInt(this.f13333a);
    }
}
