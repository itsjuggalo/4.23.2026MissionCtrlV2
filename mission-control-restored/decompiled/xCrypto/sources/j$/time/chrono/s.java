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

/* JADX INFO: loaded from: classes2.dex */
public final class s extends AbstractC1548a implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s f13177d = new s();
    private static final long serialVersionUID = -1440403870442975015L;

    @Override // j$.time.chrono.l
    public final m N(int i4) {
        if (i4 == 0) {
            return t.BCE;
        }
        if (i4 == 1) {
            return t.CE;
        }
        throw new j$.time.c("Invalid era: " + i4);
    }

    @Override // j$.time.chrono.l
    public final String s() {
        return "ISO";
    }

    @Override // j$.time.chrono.l
    public final String R() {
        return "iso8601";
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b G(int i4, int i5, int i6) {
        return j$.time.g.g0(i4, i5, i6);
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b A(int i4, int i5) {
        return j$.time.g.j0(i4, i5);
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b q(long j4) {
        return j$.time.g.i0(j4);
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b t(TemporalAccessor temporalAccessor) {
        return j$.time.g.J(temporalAccessor);
    }

    private s() {
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1552e x(LocalDateTime localDateTime) {
        return LocalDateTime.C(localDateTime);
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime y(Instant instant, ZoneId zoneId) {
        return ZonedDateTime.C(instant, zoneId);
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b L() {
        return j$.time.g.J(j$.time.g.f0(j$.time.b.c()));
    }

    public static boolean Z(long j4) {
        if ((3 & j4) == 0) {
            return j4 % 100 != 0 || j4 % 400 == 0;
        }
        return false;
    }

    @Override // j$.time.chrono.l
    public final int w(m mVar, int i4) {
        if (mVar instanceof t) {
            return mVar == t.CE ? i4 : 1 - i4;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // j$.time.chrono.l
    public final List D() {
        return j$.time.b.b(t.values());
    }

    @Override // j$.time.chrono.AbstractC1548a, j$.time.chrono.l
    public final InterfaceC1549b P(Map map, j$.time.format.y yVar) {
        return (j$.time.g) super.P(map, yVar);
    }

    @Override // j$.time.chrono.AbstractC1548a
    final void S(Map map, j$.time.format.y yVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l4 = (Long) map.remove(aVar);
        if (l4 != null) {
            if (yVar != j$.time.format.y.LENIENT) {
                aVar.a0(l4.longValue());
            }
            AbstractC1548a.p(map, j$.time.temporal.a.MONTH_OF_YEAR, ((int) Math.floorMod(l4.longValue(), r4)) + 1);
            AbstractC1548a.p(map, j$.time.temporal.a.YEAR, Math.floorDiv(l4.longValue(), 12));
        }
    }

    @Override // j$.time.chrono.AbstractC1548a
    final InterfaceC1549b W(Map map, j$.time.format.y yVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l4 = (Long) map.remove(aVar);
        if (l4 != null) {
            if (yVar != j$.time.format.y.LENIENT) {
                aVar.a0(l4.longValue());
            }
            Long l5 = (Long) map.remove(j$.time.temporal.a.ERA);
            if (l5 != null) {
                if (l5.longValue() == 1) {
                    AbstractC1548a.p(map, j$.time.temporal.a.YEAR, l4.longValue());
                    return null;
                }
                if (l5.longValue() == 0) {
                    AbstractC1548a.p(map, j$.time.temporal.a.YEAR, Math.subtractExact(1L, l4.longValue()));
                    return null;
                }
                throw new j$.time.c("Invalid value for era: " + l5);
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
            Long l6 = (Long) map.get(aVar2);
            if (yVar != j$.time.format.y.STRICT) {
                AbstractC1548a.p(map, aVar2, (l6 == null || l6.longValue() > 0) ? l4.longValue() : Math.subtractExact(1L, l4.longValue()));
                return null;
            }
            if (l6 != null) {
                long jLongValue = l6.longValue();
                long jLongValue2 = l4.longValue();
                if (jLongValue <= 0) {
                    jLongValue2 = Math.subtractExact(1L, jLongValue2);
                }
                AbstractC1548a.p(map, aVar2, jLongValue2);
                return null;
            }
            map.put(aVar, l4);
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.ERA;
        if (!map.containsKey(aVar3)) {
            return null;
        }
        aVar3.a0(((Long) map.get(aVar3)).longValue());
        return null;
    }

    @Override // j$.time.chrono.AbstractC1548a
    final InterfaceC1549b T(Map map, j$.time.format.y yVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int iZ = aVar.Z(((Long) map.remove(aVar)).longValue());
        boolean z4 = true;
        if (yVar == j$.time.format.y.LENIENT) {
            return j$.time.g.g0(iZ, 1, 1).m0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L)).l0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L));
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int iZ2 = aVar2.Z(((Long) map.remove(aVar2)).longValue());
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int iZ3 = aVar3.Z(((Long) map.remove(aVar3)).longValue());
        if (yVar == j$.time.format.y.SMART) {
            if (iZ2 == 4 || iZ2 == 6 || iZ2 == 9 || iZ2 == 11) {
                iZ3 = Math.min(iZ3, 30);
            } else if (iZ2 == 2) {
                j$.time.m mVar = j$.time.m.FEBRUARY;
                long j4 = iZ;
                int i4 = j$.time.u.f13332b;
                if ((3 & j4) != 0 || (j4 % 100 == 0 && j4 % 400 != 0)) {
                    z4 = false;
                }
                iZ3 = Math.min(iZ3, mVar.C(z4));
            }
        }
        return j$.time.g.g0(iZ, iZ2, iZ3);
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.w U(j$.time.temporal.a aVar) {
        return aVar.C();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    Object writeReplace() {
        return new E((byte) 1, this);
    }
}
