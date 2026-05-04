package j$.time;

import j$.time.format.DateTimeFormatter;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class Instant implements j$.time.temporal.m, j$.time.temporal.n, Comparable<Instant>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Instant f13541c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13543b;

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant instant2 = instant;
        int iCompare = Long.compare(this.f13542a, instant2.f13542a);
        return iCompare != 0 ? iCompare : this.f13543b - instant2.f13543b;
    }

    static {
        A(-31557014167219200L, 0L);
        A(31556889864403199L, 999999999L);
    }

    public static Instant A(long j10, long j11) {
        return s(Math.addExact(j10, Math.floorDiv(j11, 1000000000L)), (int) Math.floorMod(j11, 1000000000L));
    }

    public static Instant s(long j10, int i10) {
        if ((((long) i10) | j10) == 0) {
            return f13541c;
        }
        if (j10 < -31557014167219200L || j10 > 31556889864403199L) {
            throw new c("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j10, i10);
    }

    public Instant(long j10, int i10) {
        this.f13542a = j10;
        this.f13543b = i10;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.NANO_OF_SECOND || qVar == j$.time.temporal.a.MICRO_OF_SECOND || qVar == j$.time.temporal.a.MILLI_OF_SECOND : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return super.l(qVar).a(qVar.P(this), qVar);
        }
        int i10 = f.f13625a[((j$.time.temporal.a) qVar).ordinal()];
        if (i10 == 1) {
            return this.f13543b;
        }
        if (i10 == 2) {
            return this.f13543b / 1000;
        }
        if (i10 == 3) {
            return this.f13543b / 1000000;
        }
        if (i10 == 4) {
            j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
            aVar.f13735b.a(this.f13542a, aVar);
        }
        throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        int i10;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.P(this);
        }
        int i11 = f.f13625a[((j$.time.temporal.a) qVar).ordinal()];
        if (i11 == 1) {
            i10 = this.f13543b;
        } else if (i11 == 2) {
            i10 = this.f13543b / 1000;
        } else {
            if (i11 != 3) {
                if (i11 == 4) {
                    return this.f13542a;
                }
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
            }
            i10 = this.f13543b / 1000000;
        }
        return i10;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return (Instant) hVar.e(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j10, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (Instant) qVar.V(this, j10);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.X(j10);
        int i10 = f.f13625a[aVar.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                int i11 = ((int) j10) * 1000;
                if (i11 != this.f13543b) {
                    return s(this.f13542a, i11);
                }
            } else if (i10 == 3) {
                int i12 = ((int) j10) * 1000000;
                if (i12 != this.f13543b) {
                    return s(this.f13542a, i12);
                }
            } else {
                if (i10 != 4) {
                    throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
                }
                if (j10 != this.f13542a) {
                    return s(j10, this.f13543b);
                }
            }
        } else if (j10 != this.f13543b) {
            return s(this.f13542a, (int) j10);
        }
        return this;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final Instant d(long j10, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (Instant) sVar.s(this, j10);
        }
        switch (f.f13626b[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return F(0L, j10);
            case 2:
                return F(j10 / 1000000, (j10 % 1000000) * 1000);
            case 3:
                return F(j10 / 1000, (j10 % 1000) * 1000000);
            case 4:
                return F(j10, 0L);
            case 5:
                return F(Math.multiplyExact(j10, 60), 0L);
            case 6:
                return F(Math.multiplyExact(j10, 3600), 0L);
            case 7:
                return F(Math.multiplyExact(j10, 43200), 0L);
            case 8:
                return F(Math.multiplyExact(j10, 86400), 0L);
            default:
                throw new j$.time.temporal.t("Unsupported unit: " + sVar);
        }
    }

    public final Instant F(long j10, long j11) {
        if ((j10 | j11) == 0) {
            return this;
        }
        return A(Math.addExact(Math.addExact(this.f13542a, j10), j11 / 1000000000), ((long) this.f13543b) + (j11 % 1000000000));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.s sVar) {
        return j10 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j10, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f13755c) {
            return j$.time.temporal.b.NANOS;
        }
        if (iVar == j$.time.temporal.r.f13754b || iVar == j$.time.temporal.r.f13753a || iVar == j$.time.temporal.r.f13757e || iVar == j$.time.temporal.r.f13756d || iVar == j$.time.temporal.r.f13758f || iVar == j$.time.temporal.r.f13759g) {
            return null;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(this.f13542a, j$.time.temporal.a.INSTANT_SECONDS).c(this.f13543b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.s(this, zoneOffset);
    }

    public long toEpochMilli() {
        long j10 = this.f13542a;
        return (j10 >= 0 || this.f13543b <= 0) ? Math.addExact(Math.multiplyExact(j10, 1000), this.f13543b / 1000000) : Math.addExact(Math.multiplyExact(j10 + 1, 1000), (this.f13543b / 1000000) - 1000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            if (this.f13542a == instant.f13542a && this.f13543b == instant.f13543b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f13542a;
        return (this.f13543b * 51) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        return DateTimeFormatter.f13627f.format(this);
    }

    private Object writeReplace() {
        return new t((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
