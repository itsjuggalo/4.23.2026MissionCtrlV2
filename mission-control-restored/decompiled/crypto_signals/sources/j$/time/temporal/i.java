package j$.time.temporal;

import j$.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
enum i implements u {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7545a;

    static {
        Duration duration = Duration.f7357c;
    }

    i(String str) {
        this.f7545a = str;
    }

    @Override // j$.time.temporal.u
    public final m p(m mVar, long j4) {
        int i = c.f7541a[ordinal()];
        if (i == 1) {
            return mVar.b(Math.addExact(mVar.i(r0), j4), j.f7548c);
        }
        if (i == 2) {
            return mVar.d(j4 / 4, b.YEARS).d((j4 % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f7545a;
    }
}
