package j$.time.temporal;

import j$.time.DayOfWeek;
import j$.time.format.y;
import java.util.HashMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
abstract class h implements r {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f13306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ h[] f13307b;

    @Override // j$.time.temporal.r
    public final boolean T() {
        return true;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f13307b.clone();
    }

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.r
            public final w C() {
                return w.k(90L, 92L);
            }

            @Override // j$.time.temporal.r
            public final boolean W(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.f(a.DAY_OF_YEAR) || !temporalAccessor.f(a.MONTH_OF_YEAR) || !temporalAccessor.f(a.YEAR)) {
                    return false;
                }
                r rVar = j.f13310a;
                return j$.time.chrono.l.F(temporalAccessor).equals(j$.time.chrono.s.f13177d);
            }

            @Override // j$.time.temporal.r
            public final w J(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: DayOfQuarter");
                }
                long jG = temporalAccessor.g(h.QUARTER_OF_YEAR);
                if (jG == 1) {
                    long jG2 = temporalAccessor.g(a.YEAR);
                    j$.time.chrono.s.f13177d.getClass();
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
                int i4 = temporalAccessor.i(a.DAY_OF_YEAR);
                int i5 = temporalAccessor.i(a.MONTH_OF_YEAR);
                long jG = temporalAccessor.g(a.YEAR);
                int[] iArr = h.f13306a;
                int i6 = (i5 - 1) / 3;
                j$.time.chrono.s.f13177d.getClass();
                return i4 - iArr[i6 + (j$.time.chrono.s.Z(jG) ? 4 : 0)];
            }

            @Override // j$.time.temporal.r
            public final m p(m mVar, long j4) {
                long jR = r(mVar);
                C().b(j4, this);
                a aVar = a.DAY_OF_YEAR;
                return mVar.b((j4 - jR) + mVar.g(aVar), aVar);
            }

            @Override // j$.time.temporal.r
            public final TemporalAccessor S(HashMap map, TemporalAccessor temporalAccessor, y yVar) {
                long jSubtractExact;
                j$.time.g gVarM0;
                a aVar = a.YEAR;
                Long l4 = (Long) map.get(aVar);
                r rVar = h.QUARTER_OF_YEAR;
                Long l5 = (Long) map.get(rVar);
                if (l4 == null || l5 == null) {
                    return null;
                }
                int iZ = aVar.Z(l4.longValue());
                long jLongValue = ((Long) map.get(h.DAY_OF_QUARTER)).longValue();
                r rVar2 = j.f13310a;
                if (!j$.time.chrono.l.F(temporalAccessor).equals(j$.time.chrono.s.f13177d)) {
                    throw new j$.time.c("Resolve requires IsoChronology");
                }
                if (yVar == y.LENIENT) {
                    gVarM0 = j$.time.g.g0(iZ, 1, 1).m0(Math.multiplyExact(Math.subtractExact(l5.longValue(), 1L), 3));
                    jSubtractExact = Math.subtractExact(jLongValue, 1L);
                } else {
                    j$.time.g gVarG0 = j$.time.g.g0(iZ, ((rVar.C().a(l5.longValue(), rVar) - 1) * 3) + 1, 1);
                    if (jLongValue < 1 || jLongValue > 90) {
                        if (yVar == y.STRICT) {
                            J(gVarG0).b(jLongValue, this);
                        } else {
                            C().b(jLongValue, this);
                        }
                    }
                    jSubtractExact = jLongValue - 1;
                    gVarM0 = gVarG0;
                }
                map.remove(this);
                map.remove(aVar);
                map.remove(rVar);
                return gVarM0.l0(jSubtractExact);
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
                if (!temporalAccessor.f(a.MONTH_OF_YEAR)) {
                    return false;
                }
                r rVar = j.f13310a;
                return j$.time.chrono.l.F(temporalAccessor).equals(j$.time.chrono.s.f13177d);
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
            public final m p(m mVar, long j4) {
                long jR = r(mVar);
                C().b(j4, this);
                a aVar = a.MONTH_OF_YEAR;
                return mVar.b(((j4 - jR) * 3) + mVar.g(aVar), aVar);
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
                if (!temporalAccessor.f(a.EPOCH_DAY)) {
                    return false;
                }
                r rVar = j.f13310a;
                return j$.time.chrono.l.F(temporalAccessor).equals(j$.time.chrono.s.f13177d);
            }

            @Override // j$.time.temporal.r
            public final w J(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: WeekOfWeekBasedYear");
                }
                return h.d0(j$.time.g.J(temporalAccessor));
            }

            @Override // j$.time.temporal.r
            public final long r(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: WeekOfWeekBasedYear");
                }
                return h.a0(j$.time.g.J(temporalAccessor));
            }

            @Override // j$.time.temporal.r
            public final m p(m mVar, long j4) {
                C().b(j4, this);
                return mVar.d(Math.subtractExact(j4, r(mVar)), b.WEEKS);
            }

            @Override // j$.time.temporal.r
            public final TemporalAccessor S(HashMap map, TemporalAccessor temporalAccessor, y yVar) {
                j$.time.g gVarB;
                long j4;
                long j5;
                r rVar = h.WEEK_BASED_YEAR;
                Long l4 = (Long) map.get(rVar);
                a aVar = a.DAY_OF_WEEK;
                Long l5 = (Long) map.get(aVar);
                if (l4 == null || l5 == null) {
                    return null;
                }
                int iA = rVar.C().a(l4.longValue(), rVar);
                long jLongValue = ((Long) map.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                r rVar2 = j.f13310a;
                if (j$.time.chrono.l.F(temporalAccessor).equals(j$.time.chrono.s.f13177d)) {
                    j$.time.g gVarG0 = j$.time.g.g0(iA, 1, 4);
                    if (yVar == y.LENIENT) {
                        long jLongValue2 = l5.longValue();
                        if (jLongValue2 > 7) {
                            long j6 = jLongValue2 - 1;
                            j4 = 1;
                            gVarG0 = gVarG0.n0(j6 / 7);
                            j5 = j6 % 7;
                        } else {
                            j4 = 1;
                            if (jLongValue2 < 1) {
                                gVarG0 = gVarG0.n0(Math.subtractExact(jLongValue2, 7L) / 7);
                                j5 = (jLongValue2 + 6) % 7;
                            }
                            gVarB = gVarG0.n0(Math.subtractExact(jLongValue, j4)).b(jLongValue2, aVar);
                        }
                        jLongValue2 = j5 + j4;
                        gVarB = gVarG0.n0(Math.subtractExact(jLongValue, j4)).b(jLongValue2, aVar);
                    } else {
                        int iZ = aVar.Z(l5.longValue());
                        if (jLongValue < 1 || jLongValue > 52) {
                            if (yVar == y.STRICT) {
                                h.d0(gVarG0).b(jLongValue, this);
                            } else {
                                C().b(jLongValue, this);
                            }
                        }
                        gVarB = gVarG0.n0(jLongValue - 1).b(iZ, aVar);
                    }
                    map.remove(this);
                    map.remove(rVar);
                    map.remove(aVar);
                    return gVarB;
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
                if (!temporalAccessor.f(a.EPOCH_DAY)) {
                    return false;
                }
                r rVar = j.f13310a;
                return j$.time.chrono.l.F(temporalAccessor).equals(j$.time.chrono.s.f13177d);
            }

            @Override // j$.time.temporal.r
            public final long r(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: WeekBasedYear");
                }
                return h.e0(j$.time.g.J(temporalAccessor));
            }

            @Override // j$.time.temporal.r
            public final w J(TemporalAccessor temporalAccessor) {
                if (!W(temporalAccessor)) {
                    throw new v("Unsupported field: WeekBasedYear");
                }
                return C();
            }

            @Override // j$.time.temporal.r
            public final m p(m mVar, long j4) {
                if (!W(mVar)) {
                    throw new v("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.C().a(j4, h.WEEK_BASED_YEAR);
                j$.time.g gVarJ = j$.time.g.J(mVar);
                int i4 = gVarJ.i(a.DAY_OF_WEEK);
                int iA0 = h.a0(gVarJ);
                if (iA0 == 53 && h.f0(iA) == 52) {
                    iA0 = 52;
                }
                return mVar.m(j$.time.g.g0(iA, 1, 4).l0(((iA0 - 1) * 7) + (i4 - r6.i(r0))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        f13307b = new h[]{hVar, hVar2, hVar3, hVar4};
        f13306a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    static w d0(j$.time.g gVar) {
        return w.j(1L, f0(e0(gVar)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f0(int i4) {
        j$.time.g gVarG0 = j$.time.g.g0(i4, 1, 1);
        if (gVarG0.W() != DayOfWeek.THURSDAY) {
            return (gVarG0.W() == DayOfWeek.WEDNESDAY && gVarG0.d0()) ? 53 : 52;
        }
        return 53;
    }

    static int a0(j$.time.g gVar) {
        int iOrdinal = gVar.W().ordinal();
        int iZ = gVar.Z() - 1;
        int i4 = (3 - iOrdinal) + iZ;
        int i5 = i4 - ((i4 / 7) * 7);
        int i6 = i5 - 3;
        if (i6 < -3) {
            i6 = i5 + 4;
        }
        if (iZ < i6) {
            return (int) w.j(1L, f0(e0(gVar.s0(180).o0(-1L)))).d();
        }
        int i7 = ((iZ - i6) / 7) + 1;
        if (i7 != 53 || i6 == -3 || (i6 == -2 && gVar.d0())) {
            return i7;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e0(j$.time.g gVar) {
        int iB0 = gVar.b0();
        int iZ = gVar.Z();
        if (iZ <= 3) {
            return iZ - gVar.W().ordinal() < -2 ? iB0 - 1 : iB0;
        }
        if (iZ >= 363) {
            return ((iZ - 363) - (gVar.d0() ? 1 : 0)) - gVar.W().ordinal() >= 0 ? iB0 + 1 : iB0;
        }
        return iB0;
    }
}
