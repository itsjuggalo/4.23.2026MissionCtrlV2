package j$.time.temporal;

import j$.time.DayOfWeek;
import j$.time.format.y;
import java.util.Map;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
abstract class h implements r {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f19842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ h[] f19843b;

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.r
            public final w A() {
                return w.k(90L, 92L);
            }

            @Override // j$.time.temporal.r
            public final w H(TemporalAccessor temporalAccessor) {
                if (!U(temporalAccessor)) {
                    throw new v("Unsupported field: DayOfQuarter");
                }
                long jG = temporalAccessor.g(h.QUARTER_OF_YEAR);
                if (jG != 1) {
                    return jG == 2 ? w.j(1L, 91L) : (jG == 3 || jG == 4) ? w.j(1L, 92L) : A();
                }
                long jG2 = temporalAccessor.g(a.YEAR);
                j$.time.chrono.s.f19713d.getClass();
                return j$.time.chrono.s.X(jG2) ? w.j(1L, 91L) : w.j(1L, 90L);
            }

            @Override // j$.time.temporal.r
            public final TemporalAccessor M(Map map, TemporalAccessor temporalAccessor, y yVar) {
                long jSubtractExact;
                j$.time.h hVarK0;
                a aVar = a.YEAR;
                Long l8 = (Long) map.get(aVar);
                r rVar = h.QUARTER_OF_YEAR;
                Long l9 = (Long) map.get(rVar);
                if (l8 == null || l9 == null) {
                    return null;
                }
                int iX = aVar.X(l8.longValue());
                long jLongValue = ((Long) map.get(h.DAY_OF_QUARTER)).longValue();
                if (!j.a(temporalAccessor)) {
                    throw new j$.time.c("Resolve requires IsoChronology");
                }
                if (yVar == y.LENIENT) {
                    hVarK0 = j$.time.h.e0(iX, 1, 1).k0(Math.multiplyExact(Math.subtractExact(l9.longValue(), 1L), 3));
                    jSubtractExact = Math.subtractExact(jLongValue, 1L);
                } else {
                    j$.time.h hVarE0 = j$.time.h.e0(iX, ((rVar.A().a(l9.longValue(), rVar) - 1) * 3) + 1, 1);
                    if (jLongValue < 1 || jLongValue > 90) {
                        (yVar == y.STRICT ? H(hVarE0) : A()).b(jLongValue, this);
                    }
                    jSubtractExact = jLongValue - 1;
                    hVarK0 = hVarE0;
                }
                map.remove(this);
                map.remove(aVar);
                map.remove(rVar);
                return hVarK0.j0(jSubtractExact);
            }

            @Override // j$.time.temporal.r
            public final boolean U(TemporalAccessor temporalAccessor) {
                return temporalAccessor.f(a.DAY_OF_YEAR) && temporalAccessor.f(a.MONTH_OF_YEAR) && temporalAccessor.f(a.YEAR) && j.a(temporalAccessor);
            }

            @Override // j$.time.temporal.r
            public final m o(m mVar, long j8) {
                long jQ = q(mVar);
                A().b(j8, this);
                a aVar = a.DAY_OF_YEAR;
                return mVar.c((j8 - jQ) + mVar.g(aVar), aVar);
            }

            @Override // j$.time.temporal.r
            public final long q(TemporalAccessor temporalAccessor) {
                if (!U(temporalAccessor)) {
                    throw new v("Unsupported field: DayOfQuarter");
                }
                int i8 = temporalAccessor.i(a.DAY_OF_YEAR);
                int i9 = temporalAccessor.i(a.MONTH_OF_YEAR);
                long jG = temporalAccessor.g(a.YEAR);
                int[] iArr = h.f19842a;
                int i10 = (i9 - 1) / 3;
                j$.time.chrono.s.f19713d.getClass();
                return i8 - iArr[i10 + (j$.time.chrono.s.X(jG) ? 4 : 0)];
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = hVar;
        h hVar2 = new h() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.r
            public final w A() {
                return w.j(1L, 4L);
            }

            @Override // j$.time.temporal.r
            public final w H(TemporalAccessor temporalAccessor) {
                if (U(temporalAccessor)) {
                    return A();
                }
                throw new v("Unsupported field: QuarterOfYear");
            }

            @Override // j$.time.temporal.r
            public final boolean U(TemporalAccessor temporalAccessor) {
                return temporalAccessor.f(a.MONTH_OF_YEAR) && j.a(temporalAccessor);
            }

            @Override // j$.time.temporal.r
            public final m o(m mVar, long j8) {
                long jQ = q(mVar);
                A().b(j8, this);
                a aVar = a.MONTH_OF_YEAR;
                return mVar.c(((j8 - jQ) * 3) + mVar.g(aVar), aVar);
            }

            @Override // j$.time.temporal.r
            public final long q(TemporalAccessor temporalAccessor) {
                if (U(temporalAccessor)) {
                    return (temporalAccessor.g(a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new v("Unsupported field: QuarterOfYear");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = hVar2;
        h hVar3 = new h() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.r
            public final w A() {
                return w.k(52L, 53L);
            }

            @Override // j$.time.temporal.r
            public final w H(TemporalAccessor temporalAccessor) {
                if (U(temporalAccessor)) {
                    return h.b0(j$.time.h.H(temporalAccessor));
                }
                throw new v("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.r
            public final TemporalAccessor M(Map map, TemporalAccessor temporalAccessor, y yVar) {
                j$.time.h hVarC;
                long j8;
                long j9;
                r rVar = h.WEEK_BASED_YEAR;
                Long l8 = (Long) map.get(rVar);
                a aVar = a.DAY_OF_WEEK;
                Long l9 = (Long) map.get(aVar);
                if (l8 == null || l9 == null) {
                    return null;
                }
                int iA = rVar.A().a(l8.longValue(), rVar);
                long jLongValue = ((Long) map.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                if (!j.a(temporalAccessor)) {
                    throw new j$.time.c("Resolve requires IsoChronology");
                }
                j$.time.h hVarE0 = j$.time.h.e0(iA, 1, 4);
                if (yVar == y.LENIENT) {
                    long jLongValue2 = l9.longValue();
                    if (jLongValue2 > 7) {
                        j9 = jLongValue2 - 1;
                        hVarE0 = hVarE0.l0(j9 / 7);
                    } else {
                        j8 = 1;
                        if (jLongValue2 < 1) {
                            hVarE0 = hVarE0.l0(Math.subtractExact(jLongValue2, 7L) / 7);
                            j9 = jLongValue2 + 6;
                        }
                        hVarC = hVarE0.l0(Math.subtractExact(jLongValue, j8)).c(jLongValue2, aVar);
                    }
                    j8 = 1;
                    jLongValue2 = (j9 % 7) + 1;
                    hVarC = hVarE0.l0(Math.subtractExact(jLongValue, j8)).c(jLongValue2, aVar);
                } else {
                    int iX = aVar.X(l9.longValue());
                    if (jLongValue < 1 || jLongValue > 52) {
                        (yVar == y.STRICT ? h.b0(hVarE0) : A()).b(jLongValue, this);
                    }
                    hVarC = hVarE0.l0(jLongValue - 1).c(iX, aVar);
                }
                map.remove(this);
                map.remove(rVar);
                map.remove(aVar);
                return hVarC;
            }

            @Override // j$.time.temporal.r
            public final boolean U(TemporalAccessor temporalAccessor) {
                return temporalAccessor.f(a.EPOCH_DAY) && j.a(temporalAccessor);
            }

            @Override // j$.time.temporal.r
            public final m o(m mVar, long j8) {
                A().b(j8, this);
                return mVar.e(Math.subtractExact(j8, q(mVar)), b.WEEKS);
            }

            @Override // j$.time.temporal.r
            public final long q(TemporalAccessor temporalAccessor) {
                if (U(temporalAccessor)) {
                    return h.Y(j$.time.h.H(temporalAccessor));
                }
                throw new v("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = hVar3;
        h hVar4 = new h() { // from class: j$.time.temporal.g
            @Override // j$.time.temporal.r
            public final w A() {
                return a.YEAR.A();
            }

            @Override // j$.time.temporal.r
            public final w H(TemporalAccessor temporalAccessor) {
                if (U(temporalAccessor)) {
                    return A();
                }
                throw new v("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.r
            public final boolean U(TemporalAccessor temporalAccessor) {
                return temporalAccessor.f(a.EPOCH_DAY) && j.a(temporalAccessor);
            }

            @Override // j$.time.temporal.r
            public final m o(m mVar, long j8) {
                if (!U(mVar)) {
                    throw new v("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.A().a(j8, h.WEEK_BASED_YEAR);
                j$.time.h hVarH = j$.time.h.H(mVar);
                int i8 = hVarH.i(a.DAY_OF_WEEK);
                int iY = h.Y(hVarH);
                if (iY == 53 && h.d0(iA) == 52) {
                    iY = 52;
                }
                return mVar.l(j$.time.h.e0(iA, 1, 4).j0(((iY - 1) * 7) + (i8 - r6.i(r0))));
            }

            @Override // j$.time.temporal.r
            public final long q(TemporalAccessor temporalAccessor) {
                if (U(temporalAccessor)) {
                    return h.c0(j$.time.h.H(temporalAccessor));
                }
                throw new v("Unsupported field: WeekBasedYear");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        f19843b = new h[]{hVar, hVar2, hVar3, hVar4};
        f19842a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    static int Y(j$.time.h hVar) {
        int iOrdinal = hVar.U().ordinal();
        int i8 = 1;
        int iX = hVar.X() - 1;
        int i9 = (3 - iOrdinal) + iX;
        int i10 = i9 - ((i9 / 7) * 7);
        int i11 = i10 - 3;
        if (i11 < -3) {
            i11 = i10 + 4;
        }
        if (iX < i11) {
            return (int) w.j(1L, d0(c0(hVar.q0(180).m0(-1L)))).d();
        }
        int i12 = ((iX - i11) / 7) + 1;
        if (i12 != 53 || i11 == -3 || (i11 == -2 && hVar.b0())) {
            i8 = i12;
        }
        return i8;
    }

    static w b0(j$.time.h hVar) {
        return w.j(1L, d0(c0(hVar)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c0(j$.time.h hVar) {
        int iZ = hVar.Z();
        int iX = hVar.X();
        if (iX <= 3) {
            return iX - hVar.U().ordinal() < -2 ? iZ - 1 : iZ;
        }
        if (iX >= 363) {
            return ((iX - 363) - (hVar.b0() ? 1 : 0)) - hVar.U().ordinal() >= 0 ? iZ + 1 : iZ;
        }
        return iZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d0(int i8) {
        j$.time.h hVarE0 = j$.time.h.e0(i8, 1, 1);
        if (hVarE0.U() != DayOfWeek.THURSDAY) {
            return (hVarE0.U() == DayOfWeek.WEDNESDAY && hVarE0.b0()) ? 53 : 52;
        }
        return 53;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f19843b.clone();
    }

    @Override // j$.time.temporal.r
    public final boolean R() {
        return true;
    }
}
