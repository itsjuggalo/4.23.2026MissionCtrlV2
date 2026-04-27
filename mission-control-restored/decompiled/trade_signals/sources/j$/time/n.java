package j$.time;

import j$.time.chrono.AbstractC2185a;
import j$.time.temporal.TemporalAccessor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements TemporalAccessor, j$.time.temporal.n {
    public static final n APRIL;
    public static final n AUGUST;
    public static final n DECEMBER;
    public static final n FEBRUARY;
    public static final n JANUARY;
    public static final n JULY;
    public static final n JUNE;
    public static final n MARCH;
    public static final n MAY;
    public static final n NOVEMBER;
    public static final n OCTOBER;
    public static final n SEPTEMBER;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final n[] f19822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ n[] f19823b;

    static {
        n nVar = new n("JANUARY", 0);
        JANUARY = nVar;
        n nVar2 = new n("FEBRUARY", 1);
        FEBRUARY = nVar2;
        n nVar3 = new n("MARCH", 2);
        MARCH = nVar3;
        n nVar4 = new n("APRIL", 3);
        APRIL = nVar4;
        n nVar5 = new n("MAY", 4);
        MAY = nVar5;
        n nVar6 = new n("JUNE", 5);
        JUNE = nVar6;
        n nVar7 = new n("JULY", 6);
        JULY = nVar7;
        n nVar8 = new n("AUGUST", 7);
        AUGUST = nVar8;
        n nVar9 = new n("SEPTEMBER", 8);
        SEPTEMBER = nVar9;
        n nVar10 = new n("OCTOBER", 9);
        OCTOBER = nVar10;
        n nVar11 = new n("NOVEMBER", 10);
        NOVEMBER = nVar11;
        n nVar12 = new n("DECEMBER", 11);
        DECEMBER = nVar12;
        f19823b = new n[]{nVar, nVar2, nVar3, nVar4, nVar5, nVar6, nVar7, nVar8, nVar9, nVar10, nVar11, nVar12};
        f19822a = values();
    }

    public static n M(int i8) {
        if (i8 >= 1 && i8 <= 12) {
            return f19822a[i8 - 1];
        }
        throw new c("Invalid value for MonthOfYear: " + i8);
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f19823b.clone();
    }

    public final int A(boolean z7) {
        int i8 = m.f19821a[ordinal()];
        return i8 != 1 ? (i8 == 2 || i8 == 3 || i8 == 4 || i8 == 5) ? 30 : 31 : z7 ? 29 : 28;
    }

    public final int H() {
        int i8 = m.f19821a[ordinal()];
        if (i8 != 1) {
            return (i8 == 2 || i8 == 3 || i8 == 4 || i8 == 5) ? 30 : 31;
        }
        return 29;
    }

    public final n R() {
        return f19822a[((((int) 1) + 12) + ordinal()) % 12];
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.s.a() ? j$.time.chrono.s.f19713d : tVar == j$.time.temporal.s.e() ? j$.time.temporal.b.MONTHS : super.b(tVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m d(j$.time.temporal.m mVar) {
        if (!((AbstractC2185a) j$.time.chrono.l.D(mVar)).equals(j$.time.chrono.s.f19713d)) {
            throw new c("Adjustment only supported on ISO date-time");
        }
        return mVar.c(o(), j$.time.temporal.a.MONTH_OF_YEAR);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.MONTH_OF_YEAR : rVar != null && rVar.U(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return o();
        }
        if (rVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        return rVar.q(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        return rVar == j$.time.temporal.a.MONTH_OF_YEAR ? o() : super.i(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w k(j$.time.temporal.r rVar) {
        return rVar == j$.time.temporal.a.MONTH_OF_YEAR ? rVar.A() : super.k(rVar);
    }

    public final int o() {
        return ordinal() + 1;
    }

    public final int q(boolean z7) {
        switch (m.f19821a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z7 ? 1 : 0) + 91;
            case 3:
                return (z7 ? 1 : 0) + 152;
            case 4:
                return (z7 ? 1 : 0) + 244;
            case 5:
                return (z7 ? 1 : 0) + 305;
            case 6:
                return 1;
            case 7:
                return (z7 ? 1 : 0) + 60;
            case 8:
                return (z7 ? 1 : 0) + 121;
            case 9:
                return (z7 ? 1 : 0) + 182;
            case 10:
                return (z7 ? 1 : 0) + 213;
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                return (z7 ? 1 : 0) + 274;
            default:
                return (z7 ? 1 : 0) + 335;
        }
    }
}
