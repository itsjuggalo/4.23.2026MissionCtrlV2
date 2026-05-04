package j$.time;

import j$.time.chrono.ChronoZonedDateTime;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalDateTime implements j$.time.temporal.m, j$.time.temporal.n, j$.time.chrono.e, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LocalDateTime f13544c = I(h.f13699d, l.f13708e);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LocalDateTime f13545d = I(h.f13700e, l.f13709f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f13546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f13547b;

    public static LocalDateTime I(h hVar, l lVar) {
        Objects.requireNonNull(hVar, "date");
        Objects.requireNonNull(lVar, com.amazon.a.a.h.a.f4275b);
        return new LocalDateTime(hVar, lVar);
    }

    public static LocalDateTime P(long j10, int i10, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        long j11 = i10;
        j$.time.temporal.a.NANO_OF_SECOND.X(j11);
        long j12 = j10 + ((long) zoneOffset.f13556b);
        long j13 = 86400;
        return new LocalDateTime(h.c0(Math.floorDiv(j12, j13)), l.V((((long) ((int) Math.floorMod(j12, j13))) * 1000000000) + j11));
    }

    public static LocalDateTime A(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (!(temporalAccessor instanceof ZonedDateTime)) {
            if (temporalAccessor instanceof OffsetDateTime) {
                return ((OffsetDateTime) temporalAccessor).toLocalDateTime();
            }
            try {
                return new LocalDateTime(h.F(temporalAccessor), l.F(temporalAccessor));
            } catch (c e10) {
                throw new c("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e10);
            }
        }
        return ((ZonedDateTime) temporalAccessor).f13558a;
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        String string;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        i iVar = new i(0);
        Objects.requireNonNull(charSequence, "text");
        try {
            return (LocalDateTime) dateTimeFormatter.a(charSequence).b(iVar);
        } catch (j$.time.format.q e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (charSequence.length() > 64) {
                string = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                string = charSequence.toString();
            }
            j$.time.format.q qVar = new j$.time.format.q("Text '" + string + "' could not be parsed: " + e11.getMessage(), e11);
            charSequence.toString();
            throw qVar;
        }
    }

    public LocalDateTime(h hVar, l lVar) {
        this.f13546a = hVar;
        this.f13547b = lVar;
    }

    public final LocalDateTime a0(h hVar, l lVar) {
        return (this.f13546a == hVar && this.f13547b == lVar) ? this : new LocalDateTime(hVar, lVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.s(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        return aVar.isDateBased() || aVar.Y();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f13547b.l(qVar) : this.f13546a.l(qVar);
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f13547b.g(qVar) : this.f13546a.g(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f13547b.i(qVar) : this.f13546a.i(qVar);
        }
        return qVar.P(this);
    }

    @Override // j$.time.chrono.e
    public final j$.time.chrono.b n() {
        return this.f13546a;
    }

    @Override // j$.time.chrono.e
    public final l j() {
        return this.f13547b;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return a0(hVar, this.f13547b);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime c(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (((j$.time.temporal.a) qVar).Y()) {
                return a0(this.f13546a, this.f13547b.c(j10, qVar));
            }
            return a0(this.f13546a.c(j10, qVar), this.f13547b);
        }
        return (LocalDateTime) qVar.V(this, j10);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime d(long j10, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (LocalDateTime) sVar.s(this, j10);
        }
        switch (j.f13705a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return Y(this.f13546a, 0L, 0L, 0L, j10);
            case 2:
                LocalDateTime localDateTimePlusDays = plusDays(j10 / 86400000000L);
                return localDateTimePlusDays.Y(localDateTimePlusDays.f13546a, 0L, 0L, 0L, (j10 % 86400000000L) * 1000);
            case 3:
                LocalDateTime localDateTimePlusDays2 = plusDays(j10 / 86400000);
                return localDateTimePlusDays2.Y(localDateTimePlusDays2.f13546a, 0L, 0L, 0L, (j10 % 86400000) * 1000000);
            case 4:
                return X(j10);
            case 5:
                return Y(this.f13546a, 0L, j10, 0L, 0L);
            case 6:
                return Y(this.f13546a, j10, 0L, 0L, 0L);
            case 7:
                LocalDateTime localDateTimePlusDays3 = plusDays(j10 / 256);
                return localDateTimePlusDays3.Y(localDateTimePlusDays3.f13546a, (j10 % 256) * 12, 0L, 0L, 0L);
            default:
                return a0(this.f13546a.d(j10, sVar), this.f13547b);
        }
    }

    public LocalDateTime plusWeeks(long j10) {
        return a0(this.f13546a.h0(j10), this.f13547b);
    }

    public LocalDateTime plusDays(long j10) {
        return a0(this.f13546a.f0(j10), this.f13547b);
    }

    public final LocalDateTime X(long j10) {
        return Y(this.f13546a, 0L, 0L, j10, 0L);
    }

    @Override // j$.time.temporal.m
    public final j$.time.chrono.e a(long j10, j$.time.temporal.s sVar) {
        return j10 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j10, sVar);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.s sVar) {
        return j10 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j10, sVar);
    }

    public final LocalDateTime Y(h hVar, long j10, long j11, long j12, long j13) {
        if ((j10 | j11 | j12 | j13) == 0) {
            return a0(hVar, this.f13547b);
        }
        long j14 = 1;
        long jD0 = this.f13547b.d0();
        long j15 = ((((j10 % 24) * 3600000000000L) + ((j11 % 1440) * 60000000000L) + ((j12 % 86400) * 1000000000) + (j13 % 86400000000000L)) * j14) + jD0;
        long jFloorDiv = Math.floorDiv(j15, 86400000000000L) + (((j10 / 24) + (j11 / 1440) + (j12 / 86400) + (j13 / 86400000000000L)) * j14);
        long jFloorMod = Math.floorMod(j15, 86400000000000L);
        return a0(hVar.f0(jFloorDiv), jFloorMod == jD0 ? this.f13547b : l.V(jFloorMod));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f13758f) {
            return this.f13546a;
        }
        return super.b(iVar);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // j$.time.chrono.e
    public final ChronoZonedDateTime E(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    @Override // j$.time.chrono.e, java.lang.Comparable
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.e eVar) {
        if (eVar instanceof LocalDateTime) {
            return s((LocalDateTime) eVar);
        }
        return super.compareTo(eVar);
    }

    public final int s(LocalDateTime localDateTime) {
        int iS = this.f13546a.s(localDateTime.f13546a);
        return iS == 0 ? this.f13547b.compareTo(localDateTime.f13547b) : iS;
    }

    public final boolean F(j$.time.chrono.e eVar) {
        if (eVar instanceof LocalDateTime) {
            return s((LocalDateTime) eVar) < 0;
        }
        long jK = this.f13546a.K();
        long jK2 = eVar.n().K();
        if (jK >= jK2) {
            return jK == jK2 && this.f13547b.d0() < eVar.j().d0();
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.f13546a.equals(localDateTime.f13546a) && this.f13547b.equals(localDateTime.f13547b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13546a.hashCode() ^ this.f13547b.hashCode();
    }

    public final String toString() {
        return this.f13546a.toString() + "T" + this.f13547b.toString();
    }

    private Object writeReplace() {
        return new t((byte) 5, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
