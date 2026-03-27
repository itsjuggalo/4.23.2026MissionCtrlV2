package j$.time;

import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.InterfaceC1549b;
import j$.time.chrono.InterfaceC1552e;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class ZonedDateTime implements j$.time.temporal.m, ChronoZonedDateTime<g>, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalDateTime f13127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ZoneOffset f13128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ZoneId f13129c;

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        j$.time.temporal.b bVar = (j$.time.temporal.b) uVar;
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, bVar).d(1L, bVar) : d(-j4, bVar);
    }

    public static ZonedDateTime now(ZoneId zoneId) {
        a aVar;
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId == ZoneOffset.UTC) {
            aVar = a.f13130b;
        } else {
            aVar = new a(zoneId);
        }
        Objects.requireNonNull(aVar, "clock");
        return C(Instant.C(System.currentTimeMillis()), aVar.a());
    }

    public static ZonedDateTime of(LocalDateTime localDateTime, ZoneId zoneId) {
        return J(localDateTime, zoneId, null);
    }

    public static ZonedDateTime of(int i4, int i5, int i6, int i7, int i8, int i9, int i10, ZoneId zoneId) {
        return J(LocalDateTime.g0(i4, i5, i6, i7, i8, i9, i10), zoneId, null);
    }

    public static ZonedDateTime J(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        j$.time.zone.f fVarR = zoneId.r();
        List listG = fVarR.g(localDateTime);
        if (listG.size() == 1) {
            zoneOffset = (ZoneOffset) listG.get(0);
        } else if (listG.size() == 0) {
            j$.time.zone.b bVarF = fVarR.f(localDateTime);
            localDateTime = localDateTime.k0(bVarF.C().J());
            zoneOffset = bVarF.J();
        } else if (zoneOffset == null || !listG.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) listG.get(0);
            Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        }
        return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
    }

    public static ZonedDateTime C(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return r(instant.getEpochSecond(), instant.getNano(), zoneId);
    }

    private static ZonedDateTime r(long j4, int i4, ZoneId zoneId) {
        ZoneOffset zoneOffsetD = zoneId.r().d(Instant.ofEpochSecond(j4, i4));
        return new ZonedDateTime(LocalDateTime.i0(j4, i4, zoneOffsetD), zoneId, zoneOffsetD);
    }

    private ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.f13127a = localDateTime;
        this.f13128b = zoneOffset;
        this.f13129c = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return true;
        }
        return rVar != null && rVar.W(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            if (rVar == j$.time.temporal.a.INSTANT_SECONDS || rVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return ((j$.time.temporal.a) rVar).C();
            }
            return this.f13127a.l(rVar);
        }
        return rVar.J(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            int i4 = y.f13341a[((j$.time.temporal.a) rVar).ordinal()];
            if (i4 == 1) {
                throw new j$.time.temporal.v("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i4 == 2) {
                return this.f13128b.Z();
            }
            return this.f13127a.i(rVar);
        }
        return super.i(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            int i4 = y.f13341a[((j$.time.temporal.a) rVar).ordinal()];
            if (i4 == 1) {
                return O();
            }
            if (i4 == 2) {
                return this.f13128b.Z();
            }
            return this.f13127a.g(rVar);
        }
        return rVar.r(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset E() {
        return this.f13128b;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId Q() {
        return this.f13129c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime I(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.f13129c.equals(zoneId) ? this : J(this.f13127a, zoneId, this.f13128b);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final InterfaceC1552e B() {
        return this.f13127a;
    }

    public final LocalDateTime W() {
        return this.f13127a;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final InterfaceC1549b o() {
        return this.f13127a.m0();
    }

    public int getYear() {
        return this.f13127a.c0();
    }

    public int getMonthValue() {
        return this.f13127a.Z();
    }

    public int getDayOfMonth() {
        return this.f13127a.J();
    }

    public DayOfWeek getDayOfWeek() {
        return this.f13127a.S();
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final k n() {
        return this.f13127a.n();
    }

    public int getHour() {
        return this.f13127a.T();
    }

    public int getMinute() {
        return this.f13127a.W();
    }

    public int getSecond() {
        return this.f13127a.b0();
    }

    public int getNano() {
        return this.f13127a.a0();
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime m(g gVar) {
        return J(LocalDateTime.h0(gVar, this.f13127a.n()), this.f13129c, this.f13128b);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime b(long j4, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
            int i4 = y.f13341a[aVar.ordinal()];
            ZoneId zoneId = this.f13129c;
            if (i4 == 1) {
                return r(j4, getNano(), zoneId);
            }
            ZoneOffset zoneOffset = this.f13128b;
            LocalDateTime localDateTime = this.f13127a;
            if (i4 != 2) {
                return J(localDateTime.b(j4, rVar), zoneId, zoneOffset);
            }
            ZoneOffset zoneOffsetC0 = ZoneOffset.c0(aVar.Z(j4));
            return (zoneOffsetC0.equals(zoneOffset) || !zoneId.r().g(localDateTime).contains(zoneOffsetC0)) ? this : new ZonedDateTime(localDateTime, zoneId, zoneOffsetC0);
        }
        return (ZonedDateTime) rVar.p(this, j4);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime d(long j4, j$.time.temporal.u uVar) {
        if (uVar instanceof j$.time.temporal.b) {
            j$.time.temporal.b bVar = (j$.time.temporal.b) uVar;
            int iCompareTo = bVar.compareTo(j$.time.temporal.b.DAYS);
            ZoneOffset zoneOffset = this.f13128b;
            ZoneId zoneId = this.f13129c;
            LocalDateTime localDateTime = this.f13127a;
            if (iCompareTo >= 0 && bVar != j$.time.temporal.b.FOREVER) {
                return J(localDateTime.d(j4, uVar), zoneId, zoneOffset);
            }
            LocalDateTime localDateTimeD = localDateTime.d(j4, uVar);
            Objects.requireNonNull(localDateTimeD, "localDateTime");
            Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
            Objects.requireNonNull(zoneId, "zone");
            if (zoneId.r().g(localDateTimeD).contains(zoneOffset)) {
                return new ZonedDateTime(localDateTimeD, zoneId, zoneOffset);
            }
            return r(localDateTimeD.Y(zoneOffset), localDateTimeD.a0(), zoneId);
        }
        return (ZonedDateTime) uVar.p(this, j4);
    }

    public ZonedDateTime plusDays(long j4) {
        return J(this.f13127a.plusDays(j4), this.f13129c, this.f13128b);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    /* JADX INFO: renamed from: k */
    public final ChronoZonedDateTime e(long j4, j$.time.temporal.b bVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, bVar).d(1L, bVar) : d(-j4, bVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.b()) {
            return this.f13127a.m0();
        }
        return super.a(tVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            if (this.f13127a.equals(zonedDateTime.f13127a) && this.f13128b.equals(zonedDateTime.f13128b) && this.f13129c.equals(zonedDateTime.f13129c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f13127a.hashCode() ^ this.f13128b.hashCode()) ^ Integer.rotateLeft(this.f13129c.hashCode(), 3);
    }

    public final String toString() {
        String string = this.f13127a.toString();
        ZoneOffset zoneOffset = this.f13128b;
        String str = string + zoneOffset.toString();
        ZoneId zoneId = this.f13129c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    private Object writeReplace() {
        return new s((byte) 6, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void b0(DataOutput dataOutput) {
        this.f13127a.q0(dataOutput);
        this.f13128b.f0(dataOutput);
        this.f13129c.T((ObjectOutput) dataOutput);
    }

    static ZonedDateTime T(ObjectInput objectInput) throws IOException {
        LocalDateTime localDateTime = LocalDateTime.f13114c;
        g gVar = g.f13267d;
        LocalDateTime localDateTimeH0 = LocalDateTime.h0(g.g0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.k0(objectInput));
        ZoneOffset zoneOffsetE0 = ZoneOffset.e0(objectInput);
        ZoneId zoneId = (ZoneId) s.a(objectInput);
        Objects.requireNonNull(zoneId, "zone");
        if ((zoneId instanceof ZoneOffset) && !zoneOffsetE0.equals(zoneId)) {
            throw new IllegalArgumentException("ZoneId must match ZoneOffset");
        }
        return new ZonedDateTime(localDateTimeH0, zoneId, zoneOffsetE0);
    }
}
