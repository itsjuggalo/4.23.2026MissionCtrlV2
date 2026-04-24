package j$.time.temporal;

import j$.time.Duration;

/* JADX INFO: loaded from: classes3.dex */
enum i implements u {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17268a;

    static {
        Duration duration = Duration.f17067c;
    }

    i(String str) {
        this.f17268a = str;
    }

    @Override // j$.time.temporal.u
    public final m p(m mVar, long j7) {
        int i7 = c.f17264a[ordinal()];
        if (i7 == 1) {
            return mVar.b(Math.addExact(mVar.i(r0), j7), j.f17271c);
        }
        if (i7 == 2) {
            return mVar.d(j7 / 4, b.YEARS).d((j7 % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f17268a;
    }
}
