package j$.time.chrono;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import j$.time.DayOfWeek;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: j$.time.chrono.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1548a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap f13143a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap f13144b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f13145c = 0;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return s().compareTo(((l) obj).s());
    }

    static {
        new Locale("ja", "JP", "JP");
    }

    static l C(AbstractC1548a abstractC1548a, String str) {
        String strR;
        l lVar = (l) f13143a.putIfAbsent(str, abstractC1548a);
        if (lVar == null && (strR = abstractC1548a.R()) != null) {
            f13144b.putIfAbsent(strR, abstractC1548a);
        }
        return lVar;
    }

    static l r(String str) {
        Objects.requireNonNull(str, DiagnosticsEntry.ID_KEY);
        while (true) {
            ConcurrentHashMap concurrentHashMap = f13143a;
            l lVar = (l) concurrentHashMap.get(str);
            if (lVar == null) {
                lVar = (l) f13144b.get(str);
            }
            if (lVar != null) {
                return lVar;
            }
            if (concurrentHashMap.get("ISO") != null) {
                for (l lVar2 : ServiceLoader.load(l.class)) {
                    if (str.equals(lVar2.s()) || str.equals(lVar2.R())) {
                        return lVar2;
                    }
                }
                throw new j$.time.c("Unknown chronology: ".concat(str));
            }
            o oVar = o.f13161m;
            C(oVar, oVar.s());
            v vVar = v.f13180d;
            C(vVar, vVar.s());
            A a4 = A.f13132d;
            C(a4, a4.s());
            G g4 = G.f13139d;
            C(g4, g4.s());
            try {
                for (AbstractC1548a abstractC1548a : Arrays.asList(new AbstractC1548a[0])) {
                    if (!abstractC1548a.s().equals("ISO")) {
                        C(abstractC1548a, abstractC1548a.s());
                    }
                }
                s sVar = s.f13177d;
                C(sVar, sVar.s());
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    protected AbstractC1548a() {
    }

    @Override // j$.time.chrono.l
    public InterfaceC1549b P(Map map, j$.time.format.y yVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        if (map.containsKey(aVar)) {
            return q(((Long) map.remove(aVar)).longValue());
        }
        S(map, yVar);
        InterfaceC1549b interfaceC1549bW = W(map, yVar);
        if (interfaceC1549bW != null) {
            return interfaceC1549bW;
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
        if (!map.containsKey(aVar2)) {
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
        if (map.containsKey(aVar3)) {
            if (map.containsKey(j$.time.temporal.a.DAY_OF_MONTH)) {
                return T(map, yVar);
            }
            j$.time.temporal.a aVar4 = j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH;
            if (map.containsKey(aVar4)) {
                j$.time.temporal.a aVar5 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                if (map.containsKey(aVar5)) {
                    int iA = U(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (yVar == j$.time.format.y.LENIENT) {
                        long jSubtractExact = Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L);
                        return G(iA, 1, 1).d(jSubtractExact, (j$.time.temporal.u) j$.time.temporal.b.MONTHS).d(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), (j$.time.temporal.u) j$.time.temporal.b.WEEKS).d(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), (j$.time.temporal.u) j$.time.temporal.b.DAYS);
                    }
                    int iA2 = U(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    int iA3 = U(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                    InterfaceC1549b interfaceC1549bD = G(iA, iA2, 1).d((U(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5) - 1) + ((iA3 - 1) * 7), (j$.time.temporal.u) j$.time.temporal.b.DAYS);
                    if (yVar != j$.time.format.y.STRICT || interfaceC1549bD.i(aVar3) == iA2) {
                        return interfaceC1549bD;
                    }
                    throw new j$.time.c("Strict mode rejected resolved date as it is in a different month");
                }
                j$.time.temporal.a aVar6 = j$.time.temporal.a.DAY_OF_WEEK;
                if (map.containsKey(aVar6)) {
                    int iA4 = U(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (yVar == j$.time.format.y.LENIENT) {
                        return J(G(iA4, 1, 1), Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar6)).longValue(), 1L));
                    }
                    int iA5 = U(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    InterfaceC1549b interfaceC1549bM = G(iA4, iA5, 1).d((U(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4) - 1) * 7, (j$.time.temporal.u) j$.time.temporal.b.DAYS).m(new j$.time.temporal.o(DayOfWeek.r(U(aVar6).a(((Long) map.remove(aVar6)).longValue(), aVar6)).p(), 0));
                    if (yVar != j$.time.format.y.STRICT || interfaceC1549bM.i(aVar3) == iA5) {
                        return interfaceC1549bM;
                    }
                    throw new j$.time.c("Strict mode rejected resolved date as it is in a different month");
                }
            }
        }
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_YEAR;
        if (map.containsKey(aVar7)) {
            int iA6 = U(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
            if (yVar != j$.time.format.y.LENIENT) {
                return A(iA6, U(aVar7).a(((Long) map.remove(aVar7)).longValue(), aVar7));
            }
            return A(iA6, 1).d(Math.subtractExact(((Long) map.remove(aVar7)).longValue(), 1L), (j$.time.temporal.u) j$.time.temporal.b.DAYS);
        }
        j$.time.temporal.a aVar8 = j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR;
        if (!map.containsKey(aVar8)) {
            return null;
        }
        j$.time.temporal.a aVar9 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (map.containsKey(aVar9)) {
            int iA7 = U(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
            if (yVar == j$.time.format.y.LENIENT) {
                return A(iA7, 1).d(Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), (j$.time.temporal.u) j$.time.temporal.b.WEEKS).d(Math.subtractExact(((Long) map.remove(aVar9)).longValue(), 1L), (j$.time.temporal.u) j$.time.temporal.b.DAYS);
            }
            int iA8 = U(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8);
            InterfaceC1549b interfaceC1549bD2 = A(iA7, 1).d((U(aVar9).a(((Long) map.remove(aVar9)).longValue(), aVar9) - 1) + ((iA8 - 1) * 7), (j$.time.temporal.u) j$.time.temporal.b.DAYS);
            if (yVar != j$.time.format.y.STRICT || interfaceC1549bD2.i(aVar2) == iA7) {
                return interfaceC1549bD2;
            }
            throw new j$.time.c("Strict mode rejected resolved date as it is in a different year");
        }
        j$.time.temporal.a aVar10 = j$.time.temporal.a.DAY_OF_WEEK;
        if (!map.containsKey(aVar10)) {
            return null;
        }
        int iA9 = U(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        if (yVar == j$.time.format.y.LENIENT) {
            return J(A(iA9, 1), 0L, Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar10)).longValue(), 1L));
        }
        InterfaceC1549b interfaceC1549bM2 = A(iA9, 1).d((U(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8) - 1) * 7, (j$.time.temporal.u) j$.time.temporal.b.DAYS).m(new j$.time.temporal.o(DayOfWeek.r(U(aVar10).a(((Long) map.remove(aVar10)).longValue(), aVar10)).p(), 0));
        if (yVar != j$.time.format.y.STRICT || interfaceC1549bM2.i(aVar2) == iA9) {
            return interfaceC1549bM2;
        }
        throw new j$.time.c("Strict mode rejected resolved date as it is in a different year");
    }

    void S(Map map, j$.time.format.y yVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l4 = (Long) map.remove(aVar);
        if (l4 != null) {
            if (yVar != j$.time.format.y.LENIENT) {
                aVar.a0(l4.longValue());
            }
            InterfaceC1549b interfaceC1549bB = L().b(1L, (j$.time.temporal.r) j$.time.temporal.a.DAY_OF_MONTH).b(l4.longValue(), (j$.time.temporal.r) aVar);
            p(map, j$.time.temporal.a.MONTH_OF_YEAR, interfaceC1549bB.i(r0));
            p(map, j$.time.temporal.a.YEAR, interfaceC1549bB.i(r0));
        }
    }

    InterfaceC1549b W(Map map, j$.time.format.y yVar) {
        int intExact;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l4 = (Long) map.remove(aVar);
        if (l4 != null) {
            Long l5 = (Long) map.remove(j$.time.temporal.a.ERA);
            if (yVar != j$.time.format.y.LENIENT) {
                intExact = U(aVar).a(l4.longValue(), aVar);
            } else {
                intExact = Math.toIntExact(l4.longValue());
            }
            if (l5 != null) {
                p(map, j$.time.temporal.a.YEAR, w(N(U(r2).a(l5.longValue(), r2)), intExact));
                return null;
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
            if (map.containsKey(aVar2)) {
                p(map, aVar2, w(A(U(aVar2).a(((Long) map.get(aVar2)).longValue(), aVar2), 1).u(), intExact));
                return null;
            }
            if (yVar == j$.time.format.y.STRICT) {
                map.put(aVar, l4);
                return null;
            }
            if (D().isEmpty()) {
                p(map, aVar2, intExact);
                return null;
            }
            p(map, aVar2, w((m) r9.get(r9.size() - 1), intExact));
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.ERA;
        if (!map.containsKey(aVar3)) {
            return null;
        }
        U(aVar3).b(((Long) map.get(aVar3)).longValue(), aVar3);
        return null;
    }

    InterfaceC1549b T(Map map, j$.time.format.y yVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int iA = U(aVar).a(((Long) map.remove(aVar)).longValue(), aVar);
        if (yVar == j$.time.format.y.LENIENT) {
            long jSubtractExact = Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L);
            return G(iA, 1, 1).d(jSubtractExact, (j$.time.temporal.u) j$.time.temporal.b.MONTHS).d(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L), (j$.time.temporal.u) j$.time.temporal.b.DAYS);
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int iA2 = U(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int iA3 = U(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (yVar != j$.time.format.y.SMART) {
            return G(iA, iA2, iA3);
        }
        try {
            return G(iA, iA2, iA3);
        } catch (j$.time.c unused) {
            return G(iA, iA2, 1).m(new j$.time.temporal.p(0));
        }
    }

    static InterfaceC1549b J(InterfaceC1549b interfaceC1549b, long j4, long j5, long j6) {
        long j7;
        InterfaceC1549b interfaceC1549bD = interfaceC1549b.d(j4, (j$.time.temporal.u) j$.time.temporal.b.MONTHS);
        j$.time.temporal.b bVar = j$.time.temporal.b.WEEKS;
        InterfaceC1549b interfaceC1549bD2 = interfaceC1549bD.d(j5, (j$.time.temporal.u) bVar);
        if (j6 > 7) {
            long j8 = j6 - 1;
            interfaceC1549bD2 = interfaceC1549bD2.d(j8 / 7, (j$.time.temporal.u) bVar);
            j7 = j8 % 7;
        } else {
            if (j6 < 1) {
                interfaceC1549bD2 = interfaceC1549bD2.d(Math.subtractExact(j6, 7L) / 7, (j$.time.temporal.u) bVar);
                j7 = (j6 + 6) % 7;
            }
            return interfaceC1549bD2.m(new j$.time.temporal.o(DayOfWeek.r((int) j6).p(), 0));
        }
        j6 = j7 + 1;
        return interfaceC1549bD2.m(new j$.time.temporal.o(DayOfWeek.r((int) j6).p(), 0));
    }

    static void p(Map map, j$.time.temporal.a aVar, long j4) {
        Long l4 = (Long) map.get(aVar);
        if (l4 != null && l4.longValue() != j4) {
            throw new j$.time.c("Conflict found: " + aVar + " " + l4 + " differs from " + aVar + " " + j4);
        }
        map.put(aVar, Long.valueOf(j4));
    }

    @Override // j$.time.chrono.l
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractC1548a) && s().compareTo(((AbstractC1548a) obj).s()) == 0;
    }

    @Override // j$.time.chrono.l
    public final int hashCode() {
        return getClass().hashCode() ^ s().hashCode();
    }

    @Override // j$.time.chrono.l
    public final String toString() {
        return s();
    }
}
