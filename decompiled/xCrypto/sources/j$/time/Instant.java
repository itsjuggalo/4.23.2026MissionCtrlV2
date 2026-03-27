package j$.time;

import j$.time.format.DateTimeFormatter;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class Instant implements j$.time.temporal.m, j$.time.temporal.n, Comparable<Instant>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Instant f13111c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f13112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13113b;

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant instant2 = instant;
        int iCompare = Long.compare(this.f13112a, instant2.f13112a);
        return iCompare != 0 ? iCompare : this.f13113b - instant2.f13113b;
    }

    static {
        ofEpochSecond(-31557014167219200L, 0L);
        ofEpochSecond(31556889864403199L, 999999999L);
    }

    public static Instant J(long j4) {
        return r(j4, 0);
    }

    public static Instant ofEpochSecond(long j4, long j5) {
        return r(Math.addExact(j4, Math.floorDiv(j5, 1000000000L)), (int) Math.floorMod(j5, 1000000000L));
    }

    public static Instant C(long j4) {
        long j5 = 1000;
        return r(Math.floorDiv(j4, j5), ((int) Math.floorMod(j4, j5)) * 1000000);
    }

    private static Instant r(long j4, int i4) {
        if ((((long) i4) | j4) == 0) {
            return f13111c;
        }
        if (j4 < -31557014167219200L || j4 > 31556889864403199L) {
            throw new c("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j4, i4);
    }

    private Instant(long j4, int i4) {
        this.f13112a = j4;
        this.f13113b = i4;
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
        int i4 = e.f13192a[((j$.time.temporal.a) rVar).ordinal()];
        int i5 = this.f13113b;
        if (i4 == 1) {
            return i5;
        }
        if (i4 == 2) {
            return i5 / 1000;
        }
        if (i4 == 3) {
            return i5 / 1000000;
        }
        if (i4 == 4) {
            j$.time.temporal.a.INSTANT_SECONDS.Z(this.f13112a);
        }
        throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        int i4;
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.r(this);
        }
        int i5 = e.f13192a[((j$.time.temporal.a) rVar).ordinal()];
        int i6 = this.f13113b;
        if (i5 == 1) {
            return i6;
        }
        if (i5 == 2) {
            i4 = i6 / 1000;
        } else {
            if (i5 != 3) {
                if (i5 == 4) {
                    return this.f13112a;
                }
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
            }
            i4 = i6 / 1000000;
        }
        return i4;
    }

    public long getEpochSecond() {
        return this.f13112a;
    }

    public int getNano() {
        return this.f13113b;
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
        int i4 = e.f13192a[aVar.ordinal()];
        int i5 = this.f13113b;
        long j5 = this.f13112a;
        if (i4 != 1) {
            if (i4 == 2) {
                int i6 = ((int) j4) * 1000;
                if (i6 != i5) {
                    return r(j5, i6);
                }
            } else if (i4 == 3) {
                int i7 = ((int) j4) * 1000000;
                if (i7 != i5) {
                    return r(j5, i7);
                }
            } else {
                if (i4 != 4) {
                    throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
                }
                if (j4 != j5) {
                    return r(j4, i5);
                }
            }
        } else if (j4 != i5) {
            return r(j5, (int) j4);
        }
        return this;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public final Instant d(long j4, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (Instant) uVar.p(this, j4);
        }
        switch (e.f13193b[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return S(0L, j4);
            case 2:
                return S(j4 / 1000000, (j4 % 1000000) * 1000);
            case 3:
                return S(j4 / 1000, (j4 % 1000) * 1000000);
            case 4:
                return S(j4, 0L);
            case 5:
                return S(Math.multiplyExact(j4, 60), 0L);
            case 6:
                return S(Math.multiplyExact(j4, 3600), 0L);
            case 7:
                return S(Math.multiplyExact(j4, 43200), 0L);
            case 8:
                return S(Math.multiplyExact(j4, 86400), 0L);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    private Instant S(long j4, long j5) {
        if ((j4 | j5) == 0) {
            return this;
        }
        return ofEpochSecond(Math.addExact(Math.addExact(this.f13112a, j4), j5 / 1000000000), ((long) this.f13113b) + (j5 % 1000000000));
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
        return mVar.b(this.f13112a, j$.time.temporal.a.INSTANT_SECONDS).b(this.f13113b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.C(this, zoneOffset);
    }

    public long toEpochMilli() {
        long j4 = this.f13112a;
        return (j4 >= 0 || this.f13113b <= 0) ? Math.addExact(Math.multiplyExact(j4, 1000), r5 / 1000000) : Math.addExact(Math.multiplyExact(j4 + 1, 1000), (r5 / 1000000) - 1000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            if (this.f13112a == instant.f13112a && this.f13113b == instant.f13113b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f13112a;
        return (this.f13113b * 51) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        return DateTimeFormatter.f13197f.format(this);
    }

    private Object writeReplace() {
        return new s((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void W(DataOutput dataOutput) {
        dataOutput.writeLong(this.f13112a);
        dataOutput.writeInt(this.f13113b);
    }
}
