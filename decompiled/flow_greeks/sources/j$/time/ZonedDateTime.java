package j$.time;

import j$.time.chrono.ChronoZonedDateTime;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class ZonedDateTime implements j$.time.temporal.m, ChronoZonedDateTime<h>, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocalDateTime f13558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ZoneOffset f13559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ZoneId f13560c;

    public static ZonedDateTime now(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        a aVar = zoneId == ZoneOffset.UTC ? a.f13561b : new a(zoneId);
        Objects.requireNonNull(aVar, "clock");
        long jCurrentTimeMillis = System.currentTimeMillis();
        Instant instant = Instant.f13541c;
        long j10 = 1000;
        Instant instantS = Instant.s(Math.floorDiv(jCurrentTimeMillis, j10), ((int) Math.floorMod(jCurrentTimeMillis, j10)) * 1000000);
        ZoneId zoneId2 = aVar.f13562a;
        Objects.requireNonNull(instantS, "instant");
        Objects.requireNonNull(zoneId2, "zone");
        return s(instantS.f13542a, instantS.f13543b, zoneId2);
    }

    public static ZonedDateTime of(LocalDateTime localDateTime, ZoneId zoneId) {
        return A(localDateTime, zoneId, null);
    }

    public static ZonedDateTime of(int i10, int i11, int i12, int i13, int i14, int i15, int i16, ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.f13544c;
        return A(new LocalDateTime(h.b0(i10, i11, i12), l.P(i13, i14, i15, i16)), zoneId, null);
    }

    public static ZonedDateTime A(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        j$.time.zone.f fVarS = zoneId.s();
        List listF = fVarS.f(localDateTime);
        if (listF.size() == 1) {
            zoneOffset = (ZoneOffset) listF.get(0);
        } else if (listF.size() != 0) {
            if (zoneOffset == null || !listF.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) listF.get(0);
                Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
            }
        } else {
            Object objE = fVarS.e(localDateTime);
            j$.time.zone.b bVar = objE instanceof j$.time.zone.b ? (j$.time.zone.b) objE : null;
            localDateTime = localDateTime.X(e.A(bVar.f13783d.f13556b - bVar.f13782c.f13556b, 0).f13623a);
            zoneOffset = bVar.f13783d;
        }
        return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
    }

    public static ZonedDateTime s(long j10, int i10, ZoneId zoneId) {
        ZoneOffset zoneOffsetD = zoneId.s().d(Instant.A(j10, i10));
        return new ZonedDateTime(LocalDateTime.P(j10, i10, zoneOffsetD), zoneId, zoneOffsetD);
    }

    public ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.f13558a = localDateTime;
        this.f13559b = zoneOffset;
        this.f13560c = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return true;
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return ((j$.time.temporal.a) qVar).f13735b;
            }
            return this.f13558a.l(qVar);
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i10 = z.f13776a[((j$.time.temporal.a) qVar).ordinal()];
            if (i10 == 1) {
                throw new j$.time.temporal.t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i10 == 2) {
                return this.f13559b.f13556b;
            }
            return this.f13558a.g(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i10 = z.f13776a[((j$.time.temporal.a) qVar).ordinal()];
            if (i10 == 1) {
                return W();
            }
            if (i10 == 2) {
                return this.f13559b.f13556b;
            }
            return this.f13558a.i(qVar);
        }
        return qVar.P(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset o() {
        return this.f13559b;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId J() {
        return this.f13560c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime D(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.f13560c.equals(zoneId) ? this : A(this.f13558a, zoneId, this.f13559b);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final j$.time.chrono.e x() {
        return this.f13558a;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final j$.time.chrono.b n() {
        return this.f13558a.f13546a;
    }

    public int getYear() {
        return this.f13558a.f13546a.f13701a;
    }

    public int getMonthValue() {
        return this.f13558a.f13546a.f13702b;
    }

    public int getDayOfMonth() {
        return this.f13558a.f13546a.f13703c;
    }

    public DayOfWeek getDayOfWeek() {
        return this.f13558a.f13546a.P();
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final l j() {
        return this.f13558a.f13547b;
    }

    public int getHour() {
        return this.f13558a.f13547b.f13712a;
    }

    public int getMinute() {
        return this.f13558a.f13547b.f13713b;
    }

    public int getSecond() {
        return this.f13558a.f13547b.f13714c;
    }

    public int getNano() {
        return this.f13558a.f13547b.f13715d;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime m(h hVar) {
        return A(LocalDateTime.I(hVar, this.f13558a.f13547b), this.f13560c, this.f13559b);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime c(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i10 = z.f13776a[aVar.ordinal()];
            if (i10 == 1) {
                return s(j10, getNano(), this.f13560c);
            }
            if (i10 != 2) {
                return A(this.f13558a.c(j10, qVar), this.f13560c, this.f13559b);
            }
            ZoneOffset zoneOffsetY = ZoneOffset.Y(aVar.f13735b.a(j10, aVar));
            return (zoneOffsetY.equals(this.f13559b) || !this.f13560c.s().f(this.f13558a).contains(zoneOffsetY)) ? this : new ZonedDateTime(this.f13558a, this.f13560c, zoneOffsetY);
        }
        return (ZonedDateTime) qVar.V(this, j10);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime d(long j10, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            j$.time.temporal.b bVar = (j$.time.temporal.b) sVar;
            if (bVar.compareTo(j$.time.temporal.b.DAYS) >= 0 && bVar != j$.time.temporal.b.FOREVER) {
                return A(this.f13558a.d(j10, sVar), this.f13560c, this.f13559b);
            }
            LocalDateTime localDateTimeD = this.f13558a.d(j10, sVar);
            ZoneOffset zoneOffset = this.f13559b;
            ZoneId zoneId = this.f13560c;
            Objects.requireNonNull(localDateTimeD, "localDateTime");
            Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
            Objects.requireNonNull(zoneId, "zone");
            if (zoneId.s().f(localDateTimeD).contains(zoneOffset)) {
                return new ZonedDateTime(localDateTimeD, zoneId, zoneOffset);
            }
            return s(localDateTimeD.w(zoneOffset), localDateTimeD.f13547b.f13715d, zoneId);
        }
        return (ZonedDateTime) sVar.s(this, j10);
    }

    public ZonedDateTime plusDays(long j10) {
        return A(this.f13558a.plusDays(j10), this.f13560c, this.f13559b);
    }

    @Override // j$.time.temporal.m
    public final ChronoZonedDateTime a(long j10, j$.time.temporal.s sVar) {
        return j10 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j10, sVar);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.s sVar) {
        return j10 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j10, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f13758f) {
            return this.f13558a.f13546a;
        }
        return super.b(iVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            if (this.f13558a.equals(zonedDateTime.f13558a) && this.f13559b.equals(zonedDateTime.f13559b) && this.f13560c.equals(zonedDateTime.f13560c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f13558a.hashCode() ^ this.f13559b.f13556b) ^ Integer.rotateLeft(this.f13560c.hashCode(), 3);
    }

    public final String toString() {
        String str = this.f13558a.toString() + this.f13559b.f13557c;
        ZoneOffset zoneOffset = this.f13559b;
        ZoneId zoneId = this.f13560c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    private Object writeReplace() {
        return new t((byte) 6, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
