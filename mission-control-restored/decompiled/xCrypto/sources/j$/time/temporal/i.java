package j$.time.temporal;

import j$.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
enum i implements u {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13309a;

    static {
        Duration duration = Duration.f13108c;
    }

    i(String str) {
        this.f13309a = str;
    }

    @Override // j$.time.temporal.u
    public final m p(m mVar, long j4) {
        int i4 = c.f13305a[ordinal()];
        if (i4 == 1) {
            return mVar.b(Math.addExact(mVar.i(r0), j4), j.f13312c);
        }
        if (i4 == 2) {
            return mVar.d(j4 / 4, b.YEARS).d((j4 % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f13309a;
    }
}
