package j$.time.temporal;

import j$.time.Duration;

/* JADX INFO: loaded from: classes3.dex */
enum i implements u {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19845a;

    static {
        Duration duration = Duration.f19642c;
    }

    i(String str) {
        this.f19845a = str;
    }

    @Override // j$.time.temporal.u
    public final m o(m mVar, long j8) {
        int i8 = c.f19841a[ordinal()];
        if (i8 == 1) {
            return mVar.c(Math.addExact(mVar.i(r0), j8), j.f19848c);
        }
        if (i8 == 2) {
            return mVar.e(j8 / 4, b.YEARS).e((j8 % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f19845a;
    }
}
