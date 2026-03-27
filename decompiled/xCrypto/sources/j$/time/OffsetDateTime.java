package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class OffsetDateTime implements j$.time.temporal.m, j$.time.temporal.n, Comparable<OffsetDateTime>, Serializable {
    private static final long serialVersionUID = 2287754244819255394L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalDateTime f13118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ZoneOffset f13119b;

    @Override // java.lang.Comparable
    public final int compareTo(OffsetDateTime offsetDateTime) {
        int iZ;
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        ZoneOffset zoneOffset = offsetDateTime2.f13119b;
        ZoneOffset zoneOffset2 = this.f13119b;
        if (zoneOffset2.equals(zoneOffset)) {
            iZ = toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime());
        } else {
            LocalDateTime localDateTime = this.f13118a;
            long jY = localDateTime.Y(zoneOffset2);
            ZoneOffset zoneOffset3 = offsetDateTime2.f13119b;
            LocalDateTime localDateTime2 = offsetDateTime2.f13118a;
            int iCompare = Long.compare(jY, localDateTime2.Y(zoneOffset3));
            iZ = iCompare == 0 ? localDateTime.n().Z() - localDateTime2.n().Z() : iCompare;
        }
        return iZ == 0 ? toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime()) : iZ;
    }

    static {
        LocalDateTime localDateTime = LocalDateTime.f13114c;
        ZoneOffset zoneOffset = ZoneOffset.f13124g;
        localDateTime.getClass();
        r(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.f13115d;
        ZoneOffset zoneOffset2 = ZoneOffset.f13123f;
        localDateTime2.getClass();
        r(localDateTime2, zoneOffset2);
    }

    public static OffsetDateTime r(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    public static OffsetDateTime C(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        ZoneOffset zoneOffsetD = zoneId.r().d(instant);
        return new OffsetDateTime(LocalDateTime.i0(instant.getEpochSecond(), instant.getNano(), zoneOffsetD), zoneOffsetD);
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "dateTime");
        this.f13118a = localDateTime;
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        this.f13119b = zoneOffset;
    }

    private OffsetDateTime T(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.f13118a == localDateTime && this.f13119b.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
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
            return this.f13118a.l(rVar);
        }
        return rVar.J(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            int i4 = p.f13289a[((j$.time.temporal.a) rVar).ordinal()];
            if (i4 == 1) {
                throw new j$.time.temporal.v("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i4 == 2) {
                return this.f13119b.Z();
            }
            return this.f13118a.i(rVar);
        }
        return super.i(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            int i4 = p.f13289a[((j$.time.temporal.a) rVar).ordinal()];
            ZoneOffset zoneOffset = this.f13119b;
            LocalDateTime localDateTime = this.f13118a;
            if (i4 == 1) {
                return localDateTime.Y(zoneOffset);
            }
            if (i4 == 2) {
                return zoneOffset.Z();
            }
            return localDateTime.g(rVar);
        }
        return rVar.r(this);
    }

    public LocalDateTime toLocalDateTime() {
        return this.f13118a;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(g gVar) {
        return T(this.f13118a.o0(gVar), this.f13119b);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m b(long j4, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
            int i4 = p.f13289a[aVar.ordinal()];
            ZoneOffset zoneOffset = this.f13119b;
            LocalDateTime localDateTime = this.f13118a;
            if (i4 == 1) {
                return C(Instant.ofEpochSecond(j4, localDateTime.a0()), zoneOffset);
            }
            if (i4 == 2) {
                return T(localDateTime, ZoneOffset.c0(aVar.Z(j4)));
            }
            return T(localDateTime.b(j4, rVar), zoneOffset);
        }
        return (OffsetDateTime) rVar.p(this, j4);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final OffsetDateTime d(long j4, j$.time.temporal.u uVar) {
        if (uVar instanceof j$.time.temporal.b) {
            return T(this.f13118a.d(j4, uVar), this.f13119b);
        }
        return (OffsetDateTime) uVar.p(this, j4);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, uVar).d(1L, uVar) : d(-j4, uVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.d() || tVar == j$.time.temporal.s.f()) {
            return this.f13119b;
        }
        if (tVar == j$.time.temporal.s.g()) {
            return null;
        }
        j$.time.temporal.t tVarB = j$.time.temporal.s.b();
        LocalDateTime localDateTime = this.f13118a;
        if (tVar == tVarB) {
            return localDateTime.m0();
        }
        if (tVar == j$.time.temporal.s.c()) {
            return localDateTime.n();
        }
        if (tVar == j$.time.temporal.s.a()) {
            return j$.time.chrono.s.f13177d;
        }
        if (tVar == j$.time.temporal.s.e()) {
            return j$.time.temporal.b.NANOS;
        }
        return tVar.j(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m c(j$.time.temporal.m mVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        LocalDateTime localDateTime = this.f13118a;
        return mVar.b(localDateTime.m0().v(), aVar).b(localDateTime.n().l0(), j$.time.temporal.a.NANO_OF_DAY).b(this.f13119b.Z(), j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            if (this.f13118a.equals(offsetDateTime.f13118a) && this.f13119b.equals(offsetDateTime.f13119b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13118a.hashCode() ^ this.f13119b.hashCode();
    }

    public final String toString() {
        return this.f13118a.toString() + this.f13119b.toString();
    }

    private Object writeReplace() {
        return new s((byte) 10, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void writeExternal(ObjectOutput objectOutput) {
        this.f13118a.q0(objectOutput);
        this.f13119b.f0(objectOutput);
    }

    static OffsetDateTime S(ObjectInput objectInput) {
        LocalDateTime localDateTime = LocalDateTime.f13114c;
        g gVar = g.f13267d;
        return new OffsetDateTime(LocalDateTime.h0(g.g0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.k0(objectInput)), ZoneOffset.e0(objectInput));
    }
}
