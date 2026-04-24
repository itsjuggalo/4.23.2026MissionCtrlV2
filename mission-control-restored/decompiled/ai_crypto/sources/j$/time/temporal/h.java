package j$.time.temporal;

import j$.time.DayOfWeek;
import j$.time.format.y;
import java.util.HashMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
abstract class h implements r {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f17265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ h[] f17266b;

    @Override // j$.time.temporal.r
    public final boolean T() {
        return true;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f17266b.clone();
    }

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.r
            public final w C() {
                return w.k(90L, 92L);
            }

            @Override // j$.time.temporal.r
            public final boolean W(TemporalAccessor temporalAccessor) {
                return temporalAccessor.f(a.DAY_OF_YEAR) && temporalAccessor.f(a.MONTH_OF_YEAR) && temporalAccessor.f(a.YEAR) && j.a(temporalAccessor);
            }

            @Override // j$.time.temporal.r
            public final w J(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: DayOfQuarter");
                }
                long jG = temporalAccessor.g(h.QUARTER_OF_YEAR);
                if (jG == 1) {
                    long jG2 = temporalAccessor.g(a.YEAR);
                    j$.time.chrono.s.f17138d.getClass();
                    return j$.time.chrono.s.Z(jG2) ? w.j(1L, 91L) : w.j(1L, 90L);
                }
                if (jG == 2) {
                    return w.j(1L, 91L);
                }
                if (jG == 3 || jG == 4) {
                    return w.j(1L, 92L);
                }
                return C();
            }

            @Override // j$.time.temporal.r
            public final long r(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: DayOfQuarter");
                }
                int i7 = temporalAccessor.i(a.DAY_OF_YEAR);
                int i8 = temporalAccessor.i(a.MONTH_OF_YEAR);
                long jG = temporalAccessor.g(a.YEAR);
                int[] iArr = h.f17265a;
                int i9 = (i8 - 1) / 3;
                j$.time.chrono.s.f17138d.getClass();
                return i7 - iArr[i9 + (j$.time.chrono.s.Z(jG) ? 4 : 0)];
            }

            @Override // j$.time.temporal.r
            public final m p(m mVar, long j7) {
                long jR = r(mVar);
                C().b(j7, this);
                a aVar = a.DAY_OF_YEAR;
                return mVar.b((j7 - jR) + mVar.g(aVar), aVar);
            }

            @Override // j$.time.temporal.r
            public final TemporalAccessor S(HashMap map, TemporalAccessor temporalAccessor, y yVar) {
                long jSubtractExact;
                j$.time.h hVarM0;
                a aVar = a.YEAR;
                Long l7 = (Long) map.get(aVar);
                r rVar = h.QUARTER_OF_YEAR;
                Long l8 = (Long) map.get(rVar);
                if (l7 == null || l8 == null) {
                    return null;
                }
                int iZ = aVar.Z(l7.longValue());
                long jLongValue = ((Long) map.get(h.DAY_OF_QUARTER)).longValue();
                if (!j.a(temporalAccessor)) {
                    throw new j$.time.c("Resolve requires IsoChronology");
                }
                if (yVar == y.LENIENT) {
                    hVarM0 = j$.time.h.g0(iZ, 1, 1).m0(Math.multiplyExact(Math.subtractExact(l8.longValue(), 1L), 3));
                    jSubtractExact = Math.subtractExact(jLongValue, 1L);
                } else {
                    j$.time.h hVarG0 = j$.time.h.g0(iZ, ((rVar.C().a(l8.longValue(), rVar) - 1) * 3) + 1, 1);
                    if (jLongValue < 1 || jLongValue > 90) {
                        if (yVar == y.STRICT) {
                            J(hVarG0).b(jLongValue, this);
                        } else {
                            C().b(jLongValue, this);
                        }
                    }
                    jSubtractExact = jLongValue - 1;
                    hVarM0 = hVarG0;
                }
                map.remove(this);
                map.remove(aVar);
                map.remove(rVar);
                return hVarM0.l0(jSubtractExact);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = hVar;
        h hVar2 = new h() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.r
            public final w C() {
                return w.j(1L, 4L);
            }

            @Override // j$.time.temporal.r
            public final boolean W(TemporalAccessor temporalAccessor) {
                return temporalAccessor.f(a.MONTH_OF_YEAR) && j.a(temporalAccessor);
            }

            @Override // j$.time.temporal.r
            public final long r(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: QuarterOfYear");
                }
                return (temporalAccessor.g(a.MONTH_OF_YEAR) + 2) / 3;
            }

            @Override // j$.time.temporal.r
            public final w J(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: QuarterOfYear");
                }
                return C();
            }

            @Override // j$.time.temporal.r
            public final m p(m mVar, long j7) {
                long jR = r(mVar);
                C().b(j7, this);
                a aVar = a.MONTH_OF_YEAR;
                return mVar.b(((j7 - jR) * 3) + mVar.g(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = hVar2;
        h hVar3 = new h() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.r
            public final w C() {
                return w.k(52L, 53L);
            }

            @Override // j$.time.temporal.r
            public final boolean W(TemporalAccessor temporalAccessor) {
                return temporalAccessor.f(a.EPOCH_DAY) && j.a(temporalAccessor);
            }

            @Override // j$.time.temporal.r
            public final w J(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: WeekOfWeekBasedYear");
                }
                return h.d0(j$.time.h.J(temporalAccessor));
            }

            @Override // j$.time.temporal.r
            public final long r(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: WeekOfWeekBasedYear");
                }
                return h.a0(j$.time.h.J(temporalAccessor));
            }

            @Override // j$.time.temporal.r
            public final m p(m mVar, long j7) {
                C().b(j7, this);
                return mVar.d(Math.subtractExact(j7, r(mVar)), b.WEEKS);
            }

            @Override // j$.time.temporal.r
            public final TemporalAccessor S(HashMap map, TemporalAccessor temporalAccessor, y yVar) {
                j$.time.h hVarB;
                long j7;
                long j8;
                r rVar = h.WEEK_BASED_YEAR;
                Long l7 = (Long) map.get(rVar);
                a aVar = a.DAY_OF_WEEK;
                Long l8 = (Long) map.get(aVar);
                if (l7 == null || l8 == null) {
                    return null;
                }
                int iA = rVar.C().a(l7.longValue(), rVar);
                long jLongValue = ((Long) map.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                if (j.a(temporalAccessor)) {
                    j$.time.h hVarG0 = j$.time.h.g0(iA, 1, 4);
                    if (yVar == y.LENIENT) {
                        long jLongValue2 = l8.longValue();
                        if (jLongValue2 > 7) {
                            long j9 = jLongValue2 - 1;
                            hVarG0 = hVarG0.n0(j9 / 7);
                            j8 = j9 % 7;
                        } else {
                            j7 = 1;
                            if (jLongValue2 < 1) {
                                hVarG0 = hVarG0.n0(Math.subtractExact(jLongValue2, 7L) / 7);
                                j8 = (jLongValue2 + 6) % 7;
                            }
                            hVarB = hVarG0.n0(Math.subtractExact(jLongValue, j7)).b(jLongValue2, aVar);
                        }
                        j7 = 1;
                        jLongValue2 = j8 + 1;
                        hVarB = hVarG0.n0(Math.subtractExact(jLongValue, j7)).b(jLongValue2, aVar);
                    } else {
                        int iZ = aVar.Z(l8.longValue());
                        if (jLongValue < 1 || jLongValue > 52) {
                            if (yVar == y.STRICT) {
                                h.d0(hVarG0).b(jLongValue, this);
                            } else {
                                C().b(jLongValue, this);
                            }
                        }
                        hVarB = hVarG0.n0(jLongValue - 1).b(iZ, aVar);
                    }
                    map.remove(this);
                    map.remove(rVar);
                    map.remove(aVar);
                    return hVarB;
                }
                throw new j$.time.c("Resolve requires IsoChronology");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = hVar3;
        h hVar4 = new h() { // from class: j$.time.temporal.g
            @Override // j$.time.temporal.r
            public final w C() {
                return a.YEAR.C();
            }

            @Override // j$.time.temporal.r
            public final boolean W(TemporalAccessor temporalAccessor) {
                return temporalAccessor.f(a.EPOCH_DAY) && j.a(temporalAccessor);
            }

            @Override // j$.time.temporal.r
            public final long r(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: WeekBasedYear");
                }
                return h.e0(j$.time.h.J(temporalAccessor));
            }

            @Override // j$.time.temporal.r
            public final w J(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: WeekBasedYear");
                }
                return C();
            }

            @Override // j$.time.temporal.r
            public final m p(m mVar, long j7) {
                if (!W(mVar)) {
                    throw new v("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.C().a(j7, h.WEEK_BASED_YEAR);
                j$.time.h hVarJ = j$.time.h.J(mVar);
                int i7 = hVarJ.i(a.DAY_OF_WEEK);
                int iA0 = h.a0(hVarJ);
                if (iA0 == 53 && h.f0(iA) == 52) {
                    iA0 = 52;
                }
                return mVar.m(j$.time.h.g0(iA, 1, 4).l0(((iA0 - 1) * 7) + (i7 - r6.i(r0))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        f17266b = new h[]{hVar, hVar2, hVar3, hVar4};
        f17265a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    static w d0(j$.time.h hVar) {
        return w.j(1L, f0(e0(hVar)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f0(int i7) {
        j$.time.h hVarG0 = j$.time.h.g0(i7, 1, 1);
        if (hVarG0.W() != DayOfWeek.THURSDAY) {
            return (hVarG0.W() == DayOfWeek.WEDNESDAY && hVarG0.d0()) ? 53 : 52;
        }
        return 53;
    }

    static int a0(j$.time.h hVar) {
        int iOrdinal = hVar.W().ordinal();
        int i7 = 1;
        int iZ = hVar.Z() - 1;
        int i8 = (3 - iOrdinal) + iZ;
        int i9 = i8 - ((i8 / 7) * 7);
        int i10 = i9 - 3;
        if (i10 < -3) {
            i10 = i9 + 4;
        }
        if (iZ < i10) {
            return (int) w.j(1L, f0(e0(hVar.s0(180).o0(-1L)))).d();
        }
        int i11 = ((iZ - i10) / 7) + 1;
        if (i11 != 53 || i10 == -3 || (i10 == -2 && hVar.d0())) {
            i7 = i11;
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e0(j$.time.h hVar) {
        int iB0 = hVar.b0();
        int iZ = hVar.Z();
        if (iZ <= 3) {
            return iZ - hVar.W().ordinal() < -2 ? iB0 - 1 : iB0;
        }
        if (iZ >= 363) {
            return ((iZ - 363) - (hVar.d0() ? 1 : 0)) - hVar.W().ordinal() >= 0 ? iB0 + 1 : iB0;
        }
        return iB0;
    }
}
