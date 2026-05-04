package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends a implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f13607c = new s();
    private static final long serialVersionUID = -1440403870442975015L;

    @Override // j$.time.chrono.l
    public final m B(int i10) {
        if (i10 == 0) {
            return t.BCE;
        }
        if (i10 == 1) {
            return t.CE;
        }
        throw new j$.time.c("Invalid era: " + i10);
    }

    @Override // j$.time.chrono.l
    public final String q() {
        return "ISO";
    }

    @Override // j$.time.chrono.l
    public final String u() {
        return "iso8601";
    }

    @Override // j$.time.chrono.l
    public final b Q(int i10, int i11, int i12) {
        return j$.time.h.b0(i10, i11, i12);
    }

    @Override // j$.time.chrono.l
    public final b v(int i10, int i11) {
        return j$.time.h.d0(i10, i11);
    }

    @Override // j$.time.chrono.l
    public final b p(long j10) {
        return j$.time.h.c0(j10);
    }

    @Override // j$.time.chrono.l
    public final b G(TemporalAccessor temporalAccessor) {
        return j$.time.h.F(temporalAccessor);
    }

    private s() {
    }

    @Override // j$.time.chrono.l
    public final e H(LocalDateTime localDateTime) {
        return LocalDateTime.A(localDateTime);
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime T(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return ZonedDateTime.s(instant.f13542a, instant.f13543b, zoneId);
    }

    @Override // j$.time.chrono.l
    public final b M() {
        return j$.time.h.F(j$.time.h.a0(j$.time.b.b()));
    }

    public static boolean X(long j10) {
        if ((3 & j10) == 0) {
            return j10 % 100 != 0 || j10 % 400 == 0;
        }
        return false;
    }

    @Override // j$.time.chrono.l
    public final int C(m mVar, int i10) {
        if (mVar instanceof t) {
            return mVar == t.CE ? i10 : 1 - i10;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // j$.time.chrono.l
    public final List z() {
        return j$.time.b.a(t.values());
    }

    @Override // j$.time.chrono.a, j$.time.chrono.l
    public final b S(Map map, j$.time.format.x xVar) {
        return (j$.time.h) super.S(map, xVar);
    }

    @Override // j$.time.chrono.a
    public final void I(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l10 = (Long) map.remove(aVar);
        if (l10 != null) {
            if (xVar != j$.time.format.x.LENIENT) {
                aVar.X(l10.longValue());
            }
            a.s(map, j$.time.temporal.a.MONTH_OF_YEAR, ((int) Math.floorMod(l10.longValue(), r4)) + 1);
            a.s(map, j$.time.temporal.a.YEAR, Math.floorDiv(l10.longValue(), 12));
        }
    }

    @Override // j$.time.chrono.a
    public final b V(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l10 = (Long) map.remove(aVar);
        if (l10 != null) {
            if (xVar != j$.time.format.x.LENIENT) {
                aVar.X(l10.longValue());
            }
            Long l11 = (Long) map.remove(j$.time.temporal.a.ERA);
            if (l11 != null) {
                if (l11.longValue() == 1) {
                    a.s(map, j$.time.temporal.a.YEAR, l10.longValue());
                    return null;
                }
                if (l11.longValue() == 0) {
                    a.s(map, j$.time.temporal.a.YEAR, Math.subtractExact(1L, l10.longValue()));
                    return null;
                }
                throw new j$.time.c("Invalid value for era: " + l11);
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
            Long l12 = (Long) map.get(aVar2);
            if (xVar != j$.time.format.x.STRICT) {
                a.s(map, aVar2, (l12 == null || l12.longValue() > 0) ? l10.longValue() : Math.subtractExact(1L, l10.longValue()));
                return null;
            }
            if (l12 != null) {
                long jLongValue = l12.longValue();
                long jLongValue2 = l10.longValue();
                if (jLongValue <= 0) {
                    jLongValue2 = Math.subtractExact(1L, jLongValue2);
                }
                a.s(map, aVar2, jLongValue2);
                return null;
            }
            map.put(aVar, l10);
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.ERA;
        if (!map.containsKey(aVar3)) {
            return null;
        }
        aVar3.X(((Long) map.get(aVar3)).longValue());
        return null;
    }

    @Override // j$.time.chrono.a
    public final b P(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int iA = aVar.f13735b.a(((Long) map.remove(aVar)).longValue(), aVar);
        boolean z10 = true;
        if (xVar == j$.time.format.x.LENIENT) {
            return j$.time.h.b0(iA, 1, 1).g0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L)).f0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L));
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int iA2 = aVar2.f13735b.a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int iA3 = aVar3.f13735b.a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (xVar == j$.time.format.x.SMART) {
            if (iA2 == 4 || iA2 == 6 || iA2 == 9 || iA2 == 11) {
                iA3 = Math.min(iA3, 30);
            } else if (iA2 == 2) {
                j$.time.n nVar = j$.time.n.FEBRUARY;
                long j10 = iA;
                int i10 = j$.time.v.f13766b;
                if ((3 & j10) != 0 || (j10 % 100 == 0 && j10 % 400 != 0)) {
                    z10 = false;
                }
                iA3 = Math.min(iA3, nVar.A(z10));
            }
        }
        return j$.time.h.b0(iA, iA2, iA3);
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.u y(j$.time.temporal.a aVar) {
        return aVar.f13735b;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }
}
