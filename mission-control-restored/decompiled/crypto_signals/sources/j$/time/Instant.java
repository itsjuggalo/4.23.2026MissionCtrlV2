package j$.time;

import j$.time.format.DateTimeFormatter;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class Instant implements j$.time.temporal.m, j$.time.temporal.n, Comparable<Instant>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Instant f7360c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f7361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7362b;

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant instant2 = instant;
        int iCompare = Long.compare(this.f7361a, instant2.f7361a);
        return iCompare != 0 ? iCompare : this.f7362b - instant2.f7362b;
    }

    static {
        W(-31557014167219200L, 0L);
        W(31556889864403199L, 999999999L);
    }

    public static Instant T(long j4) {
        return r(j4, 0);
    }

    public static Instant W(long j4, long j6) {
        return r(Math.addExact(j4, Math.floorDiv(j6, 1000000000L)), (int) Math.floorMod(j6, 1000000000L));
    }

    public static Instant S(long j4) {
        long j6 = 1000;
        return r(Math.floorDiv(j4, j6), ((int) Math.floorMod(j4, j6)) * 1000000);
    }

    private static Instant r(long j4, int i) {
        if ((((long) i) | j4) == 0) {
            return f7360c;
        }
        if (j4 < -31557014167219200L || j4 > 31556889864403199L) {
            throw new c("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j4, i);
    }

    private Instant(long j4, int i) {
        this.f7361a = j4;
        this.f7362b = i;
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
        int i = e.f7436a[((j$.time.temporal.a) rVar).ordinal()];
        int i6 = this.f7362b;
        if (i == 1) {
            return i6;
        }
        if (i == 2) {
            return i6 / 1000;
        }
        if (i == 3) {
            return i6 / 1000000;
        }
        if (i == 4) {
            j$.time.temporal.a.INSTANT_SECONDS.Z(this.f7361a);
        }
        throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        int i;
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.r(this);
        }
        int i6 = e.f7436a[((j$.time.temporal.a) rVar).ordinal()];
        int i7 = this.f7362b;
        if (i6 == 1) {
            return i7;
        }
        if (i6 == 2) {
            i = i7 / 1000;
        } else {
            if (i6 != 3) {
                if (i6 == 4) {
                    return this.f7361a;
                }
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
            }
            i = i7 / 1000000;
        }
        return i;
    }

    public final long C() {
        return this.f7361a;
    }

    public final int J() {
        return this.f7362b;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(g gVar) {
        return (Instant) gVar.c(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m b(long j4, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (Instant) rVar.p(this, j4);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        aVar.a0(j4);
        int i = e.f7436a[aVar.ordinal()];
        int i6 = this.f7362b;
        long j6 = this.f7361a;
        if (i != 1) {
            if (i == 2) {
                int i7 = ((int) j4) * 1000;
                if (i7 != i6) {
                    return r(j6, i7);
                }
            } else if (i == 3) {
                int i8 = ((int) j4) * 1000000;
                if (i8 != i6) {
                    return r(j6, i8);
                }
            } else {
                if (i != 4) {
                    throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
                }
                if (j4 != j6) {
                    return r(j4, i6);
                }
            }
        } else if (j4 != i6) {
            return r(j6, (int) j4);
        }
        return this;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public final Instant d(long j4, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (Instant) uVar.p(this, j4);
        }
        switch (e.f7437b[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return Z(0L, j4);
            case 2:
                return Z(j4 / 1000000, (j4 % 1000000) * 1000);
            case 3:
                return Z(j4 / 1000, (j4 % 1000) * 1000000);
            case 4:
                return Z(j4, 0L);
            case 5:
                return Z(Math.multiplyExact(j4, 60), 0L);
            case 6:
                return Z(Math.multiplyExact(j4, 3600), 0L);
            case 7:
                return Z(Math.multiplyExact(j4, 43200), 0L);
            case 8:
                return Z(Math.multiplyExact(j4, 86400), 0L);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    private Instant Z(long j4, long j6) {
        if ((j4 | j6) == 0) {
            return this;
        }
        return W(Math.addExact(Math.addExact(this.f7361a, j4), j6 / 1000000000), ((long) this.f7362b) + (j6 % 1000000000));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, uVar).d(1L, uVar) : d(-j4, uVar);
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
        return mVar.b(this.f7361a, j$.time.temporal.a.INSTANT_SECONDS).b(this.f7362b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.C(this, zoneOffset);
    }

    public long toEpochMilli() {
        long j4 = this.f7361a;
        return (j4 >= 0 || this.f7362b <= 0) ? Math.addExact(Math.multiplyExact(j4, 1000), r5 / 1000000) : Math.addExact(Math.multiplyExact(j4 + 1, 1000), (r5 / 1000000) - 1000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            if (this.f7361a == instant.f7361a && this.f7362b == instant.f7362b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f7361a;
        return (this.f7362b * 51) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        return DateTimeFormatter.f7441f.format(this);
    }

    private Object writeReplace() {
        return new s((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void b0(DataOutput dataOutput) {
        dataOutput.writeLong(this.f7361a);
        dataOutput.writeInt(this.f7362b);
    }
}
