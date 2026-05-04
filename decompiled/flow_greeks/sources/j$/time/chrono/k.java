package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements ChronoZonedDateTime, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient g f13587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient ZoneOffset f13588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient ZoneId f13589c;

    public static k A(ZoneId zoneId, ZoneOffset zoneOffset, g gVar) {
        Objects.requireNonNull(gVar, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new k(zoneId, (ZoneOffset) zoneId, gVar);
        }
        j$.time.zone.f fVarS = zoneId.s();
        LocalDateTime localDateTimeA = LocalDateTime.A(gVar);
        List listF = fVarS.f(localDateTimeA);
        if (listF.size() == 1) {
            zoneOffset = (ZoneOffset) listF.get(0);
        } else if (listF.size() != 0) {
            if (zoneOffset == null || !listF.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) listF.get(0);
            }
            gVar = gVar;
        } else {
            Object objE = fVarS.e(localDateTimeA);
            j$.time.zone.b bVar = objE instanceof j$.time.zone.b ? (j$.time.zone.b) objE : null;
            gVar = gVar.F(gVar.f13574a, 0L, 0L, j$.time.e.A(bVar.f13783d.f13556b - bVar.f13782c.f13556b, 0).f13623a, 0L);
            zoneOffset = bVar.f13783d;
        }
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        return new k(zoneId, zoneOffset, gVar);
    }

    public static k F(l lVar, Instant instant, ZoneId zoneId) {
        ZoneOffset zoneOffsetD = zoneId.s().d(instant);
        Objects.requireNonNull(zoneOffsetD, com.amazon.device.iap.internal.c.b.as);
        return new k(zoneId, zoneOffsetD, (g) lVar.H(LocalDateTime.P(instant.f13542a, instant.f13543b, zoneOffsetD)));
    }

    public static k s(l lVar, j$.time.temporal.m mVar) {
        k kVar = (k) mVar;
        if (lVar.equals(kVar.f())) {
            return kVar;
        }
        throw new ClassCastException("Chronology mismatch, required: " + lVar.q() + ", actual: " + kVar.f().q());
    }

    public k(ZoneId zoneId, ZoneOffset zoneOffset, g gVar) {
        Objects.requireNonNull(gVar, "dateTime");
        this.f13587a = gVar;
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        this.f13588b = zoneOffset;
        Objects.requireNonNull(zoneId, "zone");
        this.f13589c = zoneId;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset o() {
        return this.f13588b;
    }

    public final int hashCode() {
        return (this.f13587a.hashCode() ^ this.f13588b.f13556b) ^ Integer.rotateLeft(this.f13589c.hashCode(), 3);
    }

    public final String toString() {
        String str = this.f13587a.toString() + this.f13588b.f13557c;
        ZoneOffset zoneOffset = this.f13588b;
        ZoneId zoneId = this.f13589c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final e x() {
        return this.f13587a;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId J() {
        return this.f13589c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime D(ZoneId zoneId) {
        return A(zoneId, this.f13588b, this.f13587a);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return true;
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.m
    public final ChronoZonedDateTime c(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i10 = j.f13585a[aVar.ordinal()];
            if (i10 == 1) {
                return d(j10 - W(), (j$.time.temporal.s) j$.time.temporal.b.SECONDS);
            }
            if (i10 == 2) {
                ZoneOffset zoneOffsetY = ZoneOffset.Y(aVar.f13735b.a(j10, aVar));
                return F(f(), Instant.A(this.f13587a.w(zoneOffsetY), r5.f13575b.f13715d), this.f13589c);
            }
            return A(this.f13589c, this.f13588b, this.f13587a.c(j10, qVar));
        }
        return s(f(), qVar.V(this, j10));
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.m
    public final ChronoZonedDateTime d(long j10, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return m(this.f13587a.d(j10, sVar));
        }
        return s(f(), sVar.s(this, j10));
    }

    private Object writeReplace() {
        return new e0((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && compareTo((ChronoZonedDateTime) obj) == 0;
    }
}
