package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends AbstractC1548a implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f13180d = new v();
    private static final long serialVersionUID = 459996390165777884L;

    @Override // j$.time.chrono.l
    public final String s() {
        return "Japanese";
    }

    @Override // j$.time.chrono.l
    public final String R() {
        return "japanese";
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b G(int i4, int i5, int i6) {
        return new x(j$.time.g.g0(i4, i5, i6));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b A(int i4, int i5) {
        return new x(j$.time.g.j0(i4, i5));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b q(long j4) {
        return new x(j$.time.g.i0(j4));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b L() {
        return new x(j$.time.g.J(j$.time.g.f0(j$.time.b.c())));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b t(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof x) {
            return (x) temporalAccessor;
        }
        return new x(j$.time.g.J(temporalAccessor));
    }

    private v() {
    }

    @Override // j$.time.chrono.l
    public final int w(m mVar, int i4) {
        if (!(mVar instanceof y)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        y yVar = (y) mVar;
        int iB0 = (yVar.s().b0() + i4) - 1;
        if (i4 != 1 && (iB0 < -999999999 || iB0 > 999999999 || iB0 < yVar.s().b0() || mVar != y.q(j$.time.g.g0(iB0, 1, 1)))) {
            throw new j$.time.c("Invalid yearOfEra value");
        }
        return iB0;
    }

    @Override // j$.time.chrono.l
    public final m N(int i4) {
        return y.w(i4);
    }

    @Override // j$.time.chrono.l
    public final List D() {
        return j$.time.b.b(y.A());
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.w U(j$.time.temporal.a aVar) {
        switch (u.f13179a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new j$.time.temporal.v("Unsupported field: " + aVar);
            case 5:
                return j$.time.temporal.w.k(y.y(), 999999999 - y.r().s().b0());
            case 6:
                return j$.time.temporal.w.k(y.x(), j$.time.temporal.a.DAY_OF_YEAR.C().d());
            case 7:
                return j$.time.temporal.w.j(x.f13182d.b0(), 999999999L);
            case 8:
                return j$.time.temporal.w.j(y.f13186d.p(), y.r().p());
            default:
                return aVar.C();
        }
    }

    @Override // j$.time.chrono.AbstractC1548a, j$.time.chrono.l
    public final InterfaceC1549b P(Map map, j$.time.format.y yVar) {
        return (x) super.P(map, yVar);
    }

    @Override // j$.time.chrono.AbstractC1548a
    final InterfaceC1549b W(Map map, j$.time.format.y yVar) {
        x xVarB0;
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        Long l4 = (Long) map.get(aVar);
        y yVarW = l4 != null ? y.w(U(aVar).a(l4.longValue(), aVar)) : null;
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR_OF_ERA;
        Long l5 = (Long) map.get(aVar2);
        int iA = l5 != null ? U(aVar2).a(l5.longValue(), aVar2) : 0;
        if (yVarW == null && l5 != null && !map.containsKey(j$.time.temporal.a.YEAR) && yVar != j$.time.format.y.STRICT) {
            yVarW = y.A()[y.A().length - 1];
        }
        if (l5 != null && yVarW != null) {
            j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                j$.time.temporal.a aVar4 = j$.time.temporal.a.DAY_OF_MONTH;
                if (map.containsKey(aVar4)) {
                    map.remove(aVar);
                    map.remove(aVar2);
                    if (yVar == j$.time.format.y.LENIENT) {
                        return new x(j$.time.g.g0((yVarW.s().b0() + iA) - 1, 1, 1)).W(Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), j$.time.temporal.b.MONTHS).W(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), j$.time.temporal.b.DAYS);
                    }
                    int iA2 = U(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    int iA3 = U(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                    if (yVar != j$.time.format.y.SMART) {
                        j$.time.g gVar = x.f13182d;
                        j$.time.g gVarG0 = j$.time.g.g0((yVarW.s().b0() + iA) - 1, iA2, iA3);
                        if (gVarG0.c0(yVarW.s()) || yVarW != y.q(gVarG0)) {
                            throw new j$.time.c("year, month, and day not valid for Era");
                        }
                        return new x(yVarW, iA, gVarG0);
                    }
                    if (iA < 1) {
                        throw new j$.time.c("Invalid YearOfEra: " + iA);
                    }
                    int iB0 = (yVarW.s().b0() + iA) - 1;
                    try {
                        xVarB0 = new x(j$.time.g.g0(iB0, iA2, iA3));
                    } catch (j$.time.c unused) {
                        xVarB0 = new x(j$.time.g.g0(iB0, iA2, 1)).b0(new j$.time.temporal.p(0));
                    }
                    if (xVarB0.T() == yVarW || xVarB0.i(j$.time.temporal.a.YEAR_OF_ERA) <= 1 || iA <= 1) {
                        return xVarB0;
                    }
                    throw new j$.time.c("Invalid YearOfEra for Era: " + yVarW + " " + iA);
                }
            }
            j$.time.temporal.a aVar5 = j$.time.temporal.a.DAY_OF_YEAR;
            if (map.containsKey(aVar5)) {
                map.remove(aVar);
                map.remove(aVar2);
                if (yVar == j$.time.format.y.LENIENT) {
                    return new x(j$.time.g.j0((yVarW.s().b0() + iA) - 1, 1)).W(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), j$.time.temporal.b.DAYS);
                }
                int iA4 = U(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5);
                j$.time.g gVar2 = x.f13182d;
                j$.time.g gVarJ0 = iA == 1 ? j$.time.g.j0(yVarW.s().b0(), (yVarW.s().Z() + iA4) - 1) : j$.time.g.j0((yVarW.s().b0() + iA) - 1, iA4);
                if (gVarJ0.c0(yVarW.s()) || yVarW != y.q(gVarJ0)) {
                    throw new j$.time.c("Invalid parameters");
                }
                return new x(yVarW, iA, gVarJ0);
            }
        }
        return null;
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime y(Instant instant, ZoneId zoneId) {
        return k.J(this, instant, zoneId);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    Object writeReplace() {
        return new E((byte) 1, this);
    }
}
