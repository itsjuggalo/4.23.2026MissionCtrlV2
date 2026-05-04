package j$.time.temporal;

import j$.time.DayOfWeek;
import j$.time.format.w;
import j$.time.format.x;
import java.util.Map;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements q {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f13739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h[] f13740b;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f13740b.clone();
    }

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.q
            public final u I() {
                return u.g(90L, 92L);
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.DAY_OF_YEAR) || !temporalAccessor.h(a.MONTH_OF_YEAR) || !temporalAccessor.h(a.YEAR)) {
                    return false;
                }
                h hVar2 = j.f13743a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f13607c);
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                long jI = temporalAccessor.i(h.QUARTER_OF_YEAR);
                if (jI == 1) {
                    long jI2 = temporalAccessor.i(a.YEAR);
                    j$.time.chrono.s.f13607c.getClass();
                    return j$.time.chrono.s.X(jI2) ? u.f(1L, 91L) : u.f(1L, 90L);
                }
                if (jI == 2) {
                    return u.f(1L, 91L);
                }
                if (jI == 3 || jI == 4) {
                    return u.f(1L, 92L);
                }
                return I();
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                int iG = temporalAccessor.g(a.DAY_OF_YEAR);
                int iG2 = temporalAccessor.g(a.MONTH_OF_YEAR);
                long jI = temporalAccessor.i(a.YEAR);
                int i10 = (iG2 - 1) / 3;
                j$.time.chrono.s.f13607c.getClass();
                return iG - h.f13739a[i10 + (j$.time.chrono.s.X(jI) ? 4 : 0)];
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j10) {
                long jP = P(mVar);
                I().b(j10, this);
                a aVar = a.DAY_OF_YEAR;
                return mVar.c((j10 - jP) + mVar.i(aVar), aVar);
            }

            @Override // j$.time.temporal.q
            public final TemporalAccessor F(Map map, w wVar, x xVar) {
                long jSubtractExact;
                j$.time.h hVarG0;
                a aVar = a.YEAR;
                Long l10 = (Long) map.get(aVar);
                q qVar = h.QUARTER_OF_YEAR;
                Long l11 = (Long) map.get(qVar);
                if (l10 == null || l11 == null) {
                    return null;
                }
                int iA = aVar.f13735b.a(l10.longValue(), aVar);
                long jLongValue = ((Long) map.get(h.DAY_OF_QUARTER)).longValue();
                h hVar2 = j.f13743a;
                if (!j$.time.chrono.l.r(wVar).equals(j$.time.chrono.s.f13607c)) {
                    throw new j$.time.c("Resolve requires IsoChronology");
                }
                if (xVar == x.LENIENT) {
                    hVarG0 = j$.time.h.b0(iA, 1, 1).g0(Math.multiplyExact(Math.subtractExact(l11.longValue(), 1L), 3));
                    jSubtractExact = Math.subtractExact(jLongValue, 1L);
                } else {
                    j$.time.h hVarB0 = j$.time.h.b0(iA, ((qVar.I().a(l11.longValue(), qVar) - 1) * 3) + 1, 1);
                    if (jLongValue < 1 || jLongValue > 90) {
                        if (xVar == x.STRICT) {
                            A(hVarB0).b(jLongValue, this);
                        } else {
                            I().b(jLongValue, this);
                        }
                    }
                    jSubtractExact = jLongValue - 1;
                    hVarG0 = hVarB0;
                }
                map.remove(this);
                map.remove(aVar);
                map.remove(qVar);
                return hVarG0.f0(jSubtractExact);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = hVar;
        h hVar2 = new h() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.q
            public final u I() {
                return u.f(1L, 4L);
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.MONTH_OF_YEAR)) {
                    return false;
                }
                h hVar3 = j.f13743a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f13607c);
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: QuarterOfYear");
                }
                return (temporalAccessor.i(a.MONTH_OF_YEAR) + 2) / 3;
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: QuarterOfYear");
                }
                return I();
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j10) {
                long jP = P(mVar);
                I().b(j10, this);
                a aVar = a.MONTH_OF_YEAR;
                return mVar.c(((j10 - jP) * 3) + mVar.i(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = hVar2;
        h hVar3 = new h() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.q
            public final u I() {
                return u.g(52L, 53L);
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar4 = j.f13743a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f13607c);
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (s(temporalAccessor)) {
                    return h.a0(j$.time.h.F(temporalAccessor));
                }
                throw new t("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: WeekOfWeekBasedYear");
                }
                return h.X(j$.time.h.F(temporalAccessor));
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j10) {
                I().b(j10, this);
                return mVar.d(Math.subtractExact(j10, P(mVar)), b.WEEKS);
            }

            @Override // j$.time.temporal.q
            public final TemporalAccessor F(Map map, w wVar, x xVar) {
                j$.time.h hVarC;
                long j10;
                long j11;
                q qVar = h.WEEK_BASED_YEAR;
                Long l10 = (Long) map.get(qVar);
                a aVar = a.DAY_OF_WEEK;
                Long l11 = (Long) map.get(aVar);
                if (l10 == null || l11 == null) {
                    return null;
                }
                int iA = qVar.I().a(l10.longValue(), qVar);
                long jLongValue = ((Long) map.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                h hVar4 = j.f13743a;
                if (!j$.time.chrono.l.r(wVar).equals(j$.time.chrono.s.f13607c)) {
                    throw new j$.time.c("Resolve requires IsoChronology");
                }
                j$.time.h hVarB0 = j$.time.h.b0(iA, 1, 4);
                if (xVar == x.LENIENT) {
                    long jLongValue2 = l11.longValue();
                    if (jLongValue2 > 7) {
                        long j12 = jLongValue2 - 1;
                        j10 = 1;
                        hVarB0 = hVarB0.h0(j12 / 7);
                        j11 = j12 % 7;
                    } else {
                        j10 = 1;
                        if (jLongValue2 < 1) {
                            hVarB0 = hVarB0.h0(Math.subtractExact(jLongValue2, 7L) / 7);
                            j11 = (jLongValue2 + 6) % 7;
                        }
                        hVarC = hVarB0.h0(Math.subtractExact(jLongValue, j10)).c(jLongValue2, aVar);
                    }
                    jLongValue2 = j11 + j10;
                    hVarC = hVarB0.h0(Math.subtractExact(jLongValue, j10)).c(jLongValue2, aVar);
                } else {
                    int iA2 = aVar.f13735b.a(l11.longValue(), aVar);
                    if (jLongValue < 1 || jLongValue > 52) {
                        if (xVar == x.STRICT) {
                            h.a0(hVarB0).b(jLongValue, this);
                        } else {
                            I().b(jLongValue, this);
                        }
                    }
                    hVarC = hVarB0.h0(jLongValue - 1).c(iA2, aVar);
                }
                map.remove(this);
                map.remove(qVar);
                map.remove(aVar);
                return hVarC;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = hVar3;
        h hVar4 = new h() { // from class: j$.time.temporal.g
            @Override // j$.time.temporal.q
            public final u I() {
                return a.YEAR.f13735b;
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar5 = j.f13743a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f13607c);
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (s(temporalAccessor)) {
                    return h.Y(j$.time.h.F(temporalAccessor));
                }
                throw new t("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                return I();
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j10) {
                if (!s(mVar)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.f13735b.a(j10, h.WEEK_BASED_YEAR);
                j$.time.h hVarF = j$.time.h.F(mVar);
                int iG = hVarF.g(a.DAY_OF_WEEK);
                int iX = h.X(hVarF);
                if (iX == 53 && h.Z(iA) == 52) {
                    iX = 52;
                }
                return mVar.m(j$.time.h.b0(iA, 1, 4).f0(((iX - 1) * 7) + (iG - r6.g(r0))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        f13740b = new h[]{hVar, hVar2, hVar3, hVar4};
        f13739a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    public static u a0(j$.time.h hVar) {
        return u.f(1L, Z(Y(hVar)));
    }

    public static int Z(int i10) {
        j$.time.h hVarB0 = j$.time.h.b0(i10, 1, 1);
        if (hVarB0.P() != DayOfWeek.THURSDAY) {
            return (hVarB0.P() == DayOfWeek.WEDNESDAY && hVarB0.Y()) ? 53 : 52;
        }
        return 53;
    }

    public static int X(j$.time.h hVar) {
        int iOrdinal = hVar.P().ordinal();
        int iV = hVar.V() - 1;
        int i10 = (3 - iOrdinal) + iV;
        int i11 = i10 - ((i10 / 7) * 7);
        int i12 = i11 - 3;
        if (i12 < -3) {
            i12 = i11 + 4;
        }
        if (iV >= i12) {
            int i13 = ((iV - i12) / 7) + 1;
            if (i13 != 53 || i12 == -3 || (i12 == -2 && hVar.Y())) {
                return i13;
            }
            return 1;
        }
        if (hVar.V() != 180) {
            hVar = j$.time.h.d0(hVar.f13701a, 180);
        }
        return (int) a0(hVar.i0(-1L)).f13763d;
    }

    public static int Y(j$.time.h hVar) {
        int i10 = hVar.f13701a;
        int iV = hVar.V();
        if (iV <= 3) {
            return iV - hVar.P().ordinal() < -2 ? i10 - 1 : i10;
        }
        if (iV >= 363) {
            return ((iV - 363) - (hVar.Y() ? 1 : 0)) - hVar.P().ordinal() >= 0 ? i10 + 1 : i10;
        }
        return i10;
    }
}
