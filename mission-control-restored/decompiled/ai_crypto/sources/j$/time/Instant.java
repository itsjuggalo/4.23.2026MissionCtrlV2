package j$.time;

import j$.time.format.DateTimeFormatter;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class Instant implements j$.time.temporal.m, j$.time.temporal.n, Comparable<Instant>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Instant f17070c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17072b;

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant instant2 = instant;
        int iCompare = Long.compare(this.f17071a, instant2.f17071a);
        return iCompare != 0 ? iCompare : this.f17072b - instant2.f17072b;
    }

    static {
        W(-31557014167219200L, 0L);
        W(31556889864403199L, 999999999L);
    }

    public static Instant T(long j7) {
        return r(j7, 0);
    }

    public static Instant W(long j7, long j8) {
        return r(Math.addExact(j7, Math.floorDiv(j8, 1000000000L)), (int) Math.floorMod(j8, 1000000000L));
    }

    public static Instant S(long j7) {
        long j8 = 1000;
        return r(Math.floorDiv(j7, j8), ((int) Math.floorMod(j7, j8)) * 1000000);
    }

    private static Instant r(long j7, int i7) {
        if ((((long) i7) | j7) == 0) {
            return f17070c;
        }
        if (j7 < -31557014167219200L || j7 > 31556889864403199L) {
            throw new c("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j7, i7);
    }

    private Instant(long j7, int i7) {
        this.f17071a = j7;
        this.f17072b = i7;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.INSTANT_SECONDS || rVar == j$.time.temporal.a.NANO_OF_SECOND || rVar == j$.time.temporal.a.MICRO_OF_SECOND || rVar == j$.time.temporal.a.MILLI_OF_SECOND : rVar != null && rVar.W(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return super.l(rVar).a(rVar.r(this), rVar);
        }
        int i7 = f.f17153a[((j$.time.temporal.a) rVar).ordinal()];
        int i8 = this.f17072b;
        if (i7 == 1) {
            return i8;
        }
        if (i7 == 2) {
            return i8 / 1000;
        }
        if (i7 == 3) {
            return i8 / 1000000;
        }
        if (i7 == 4) {
            j$.time.temporal.a.INSTANT_SECONDS.Z(this.f17071a);
        }
        throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        int i7;
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.r(this);
        }
        int i8 = f.f17153a[((j$.time.temporal.a) rVar).ordinal()];
        int i9 = this.f17072b;
        if (i8 == 1) {
            return i9;
        }
        if (i8 == 2) {
            i7 = i9 / 1000;
        } else {
            if (i8 != 3) {
                if (i8 == 4) {
                    return this.f17071a;
                }
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
            }
            i7 = i9 / 1000000;
        }
        return i7;
    }

    public final long C() {
        return this.f17071a;
    }

    public final int J() {
        return this.f17072b;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(h hVar) {
        return (Instant) hVar.c(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m b(long j7, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (Instant) rVar.p(this, j7);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        aVar.a0(j7);
        int i7 = f.f17153a[aVar.ordinal()];
        int i8 = this.f17072b;
        long j8 = this.f17071a;
        if (i7 != 1) {
            if (i7 == 2) {
                int i9 = ((int) j7) * 1000;
                if (i9 != i8) {
                    return r(j8, i9);
                }
            } else if (i7 == 3) {
                int i10 = ((int) j7) * 1000000;
                if (i10 != i8) {
                    return r(j8, i10);
                }
            } else {
                if (i7 != 4) {
                    throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
                }
                if (j7 != j8) {
                    return r(j7, i8);
                }
            }
        } else if (j7 != i8) {
            return r(j8, (int) j7);
        }
        return this;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public final Instant d(long j7, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (Instant) uVar.p(this, j7);
        }
        switch (f.f17154b[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return Z(0L, j7);
            case 2:
                return Z(j7 / 1000000, (j7 % 1000000) * 1000);
            case 3:
                return Z(j7 / 1000, (j7 % 1000) * 1000000);
            case 4:
                return Z(j7, 0L);
            case 5:
                return Z(Math.multiplyExact(j7, 60), 0L);
            case 6:
                return Z(Math.multiplyExact(j7, 3600), 0L);
            case 7:
                return Z(Math.multiplyExact(j7, 43200), 0L);
            case 8:
                return Z(Math.multiplyExact(j7, 86400), 0L);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    private Instant Z(long j7, long j8) {
        if ((j7 | j8) == 0) {
            return this;
        }
        return W(Math.addExact(Math.addExact(this.f17071a, j7), j8 / 1000000000), ((long) this.f17072b) + (j8 % 1000000000));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m e(long j7, j$.time.temporal.u uVar) {
        return j7 == Long.MIN_VALUE ? d(Long.MAX_VALUE, uVar).d(1L, uVar) : d(-j7, uVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.e()) {
            return j$.time.temporal.b.NANOS;
        }
        if (tVar == j$.time.temporal.s.a() || tVar == j$.time.temporal.s.g() || tVar == j$.time.temporal.s.f() || tVar == j$.time.temporal.s.d() || tVar == j$.time.temporal.s.b() || tVar == j$.time.temporal.s.c()) {
            return null;
        }
        return tVar.j(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m c(j$.time.temporal.m mVar) {
        return mVar.b(this.f17071a, j$.time.temporal.a.INSTANT_SECONDS).b(this.f17072b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.C(this, zoneOffset);
    }

    public long toEpochMilli() {
        long j7 = this.f17071a;
        return (j7 >= 0 || this.f17072b <= 0) ? Math.addExact(Math.multiplyExact(j7, 1000), r5 / 1000000) : Math.addExact(Math.multiplyExact(j7 + 1, 1000), (r5 / 1000000) - 1000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.f17071a == instant.f17071a && this.f17072b == instant.f17072b;
    }

    public final int hashCode() {
        long j7 = this.f17071a;
        return (this.f17072b * 51) + ((int) (j7 ^ (j7 >>> 32)));
    }

    public final String toString() {
        return DateTimeFormatter.f17156f.format(this);
    }

    private Object writeReplace() {
        return new t((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void b0(DataOutput dataOutput) {
        dataOutput.writeLong(this.f17071a);
        dataOutput.writeInt(this.f17072b);
    }
}
