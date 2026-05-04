package j$.time.temporal;

/* JADX INFO: loaded from: classes2.dex */
public enum i implements s {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13742a;

    static {
        j$.time.e.A(31556952L, 0);
        j$.time.e.A(7889238L, 0);
    }

    i(String str) {
        this.f13742a = str;
    }

    @Override // j$.time.temporal.s
    public final m s(m mVar, long j10) {
        int i10 = c.f13738a[ordinal()];
        if (i10 == 1) {
            return mVar.c(Math.addExact(mVar.g(r0), j10), j.f13745c);
        }
        if (i10 == 2) {
            return mVar.d(j10 / 4, b.YEARS).d((j10 % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f13742a;
    }
}
