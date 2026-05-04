package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class OffsetDateTime implements j$.time.temporal.m, j$.time.temporal.n, Comparable<OffsetDateTime>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f13548c = 0;
    private static final long serialVersionUID = 2287754244819255394L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocalDateTime f13549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ZoneOffset f13550b;

    @Override // java.lang.Comparable
    public final int compareTo(OffsetDateTime offsetDateTime) {
        int iCompare;
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if (this.f13550b.equals(offsetDateTime2.f13550b)) {
            iCompare = toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime());
        } else {
            iCompare = Long.compare(this.f13549a.w(this.f13550b), offsetDateTime2.f13549a.w(offsetDateTime2.f13550b));
            if (iCompare == 0) {
                iCompare = this.f13549a.f13547b.f13715d - offsetDateTime2.f13549a.f13547b.f13715d;
            }
        }
        return iCompare == 0 ? toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime()) : iCompare;
    }

    static {
        LocalDateTime localDateTime = LocalDateTime.f13544c;
        ZoneOffset zoneOffset = ZoneOffset.f13555g;
        localDateTime.getClass();
        new OffsetDateTime(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.f13545d;
        ZoneOffset zoneOffset2 = ZoneOffset.f13554f;
        localDateTime2.getClass();
        new OffsetDateTime(localDateTime2, zoneOffset2);
    }

    public static OffsetDateTime s(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        ZoneOffset zoneOffsetD = zoneId.s().d(instant);
        return new OffsetDateTime(LocalDateTime.P(instant.f13542a, instant.f13543b, zoneOffsetD), zoneOffsetD);
    }

    public OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "dateTime");
        this.f13549a = localDateTime;
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        this.f13550b = zoneOffset;
    }

    public final OffsetDateTime F(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.f13549a == localDateTime && this.f13550b.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
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
            if (qVar != j$.time.temporal.a.INSTANT_SECONDS && qVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f13549a.l(qVar);
            }
            return ((j$.time.temporal.a) qVar).f13735b;
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i10 = q.f13723a[((j$.time.temporal.a) qVar).ordinal()];
            if (i10 == 1) {
                throw new j$.time.temporal.t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i10 == 2) {
                return this.f13550b.f13556b;
            }
            return this.f13549a.g(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i10 = q.f13723a[((j$.time.temporal.a) qVar).ordinal()];
            if (i10 == 1) {
                return this.f13549a.w(this.f13550b);
            }
            if (i10 == 2) {
                return this.f13550b.f13556b;
            }
            return this.f13549a.i(qVar);
        }
        return qVar.P(this);
    }

    public LocalDateTime toLocalDateTime() {
        return this.f13549a;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        LocalDateTime localDateTime = this.f13549a;
        return F(localDateTime.a0(hVar, localDateTime.f13547b), this.f13550b);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i10 = q.f13723a[aVar.ordinal()];
            if (i10 == 1) {
                return s(Instant.A(j10, this.f13549a.f13547b.f13715d), this.f13550b);
            }
            if (i10 == 2) {
                return F(this.f13549a, ZoneOffset.Y(aVar.f13735b.a(j10, aVar)));
            }
            return F(this.f13549a.c(j10, qVar), this.f13550b);
        }
        return (OffsetDateTime) qVar.V(this, j10);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final OffsetDateTime d(long j10, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return F(this.f13549a.d(j10, sVar), this.f13550b);
        }
        return (OffsetDateTime) sVar.s(this, j10);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.s sVar) {
        return j10 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j10, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f13756d || iVar == j$.time.temporal.r.f13757e) {
            return this.f13550b;
        }
        if (iVar == j$.time.temporal.r.f13753a) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f13758f) {
            return this.f13549a.f13546a;
        }
        if (iVar == j$.time.temporal.r.f13759g) {
            return this.f13549a.f13547b;
        }
        if (iVar == j$.time.temporal.r.f13754b) {
            return j$.time.chrono.s.f13607c;
        }
        if (iVar == j$.time.temporal.r.f13755c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(this.f13549a.f13546a.K(), j$.time.temporal.a.EPOCH_DAY).c(this.f13549a.f13547b.d0(), j$.time.temporal.a.NANO_OF_DAY).c(this.f13550b.f13556b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            if (this.f13549a.equals(offsetDateTime.f13549a) && this.f13550b.equals(offsetDateTime.f13550b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13549a.hashCode() ^ this.f13550b.f13556b;
    }

    public final String toString() {
        return this.f13549a.toString() + this.f13550b.f13557c;
    }

    private Object writeReplace() {
        return new t((byte) 10, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
