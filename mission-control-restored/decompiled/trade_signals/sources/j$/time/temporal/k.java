package j$.time.temporal;

import j$.time.format.y;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
enum k implements r {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);

    private static final long serialVersionUID = -7501623920830201812L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient String f19850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient w f19851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient long f19852c;

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j8) {
        this.f19850a = str;
        this.f19851b = w.j((-365243219162L) + j8, 365241780471L + j8);
        this.f19852c = j8;
    }

    @Override // j$.time.temporal.r
    public final w A() {
        return this.f19851b;
    }

    @Override // j$.time.temporal.r
    public final w H(TemporalAccessor temporalAccessor) {
        if (temporalAccessor.f(a.EPOCH_DAY)) {
            return this.f19851b;
        }
        throw new j$.time.c("Unsupported field: " + this);
    }

    @Override // j$.time.temporal.r
    public final TemporalAccessor M(Map map, TemporalAccessor temporalAccessor, y yVar) {
        long jLongValue = ((Long) map.remove(this)).longValue();
        j$.time.chrono.l lVarD = j$.time.chrono.l.D(temporalAccessor);
        y yVar2 = y.LENIENT;
        long j8 = this.f19852c;
        if (yVar == yVar2) {
            return lVarD.p(Math.subtractExact(jLongValue, j8));
        }
        this.f19851b.b(jLongValue, this);
        return lVarD.p(jLongValue - j8);
    }

    @Override // j$.time.temporal.r
    public final boolean R() {
        return true;
    }

    @Override // j$.time.temporal.r
    public final boolean U(TemporalAccessor temporalAccessor) {
        return temporalAccessor.f(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.r
    public final m o(m mVar, long j8) {
        if (this.f19851b.i(j8)) {
            return mVar.c(Math.subtractExact(j8, this.f19852c), a.EPOCH_DAY);
        }
        throw new j$.time.c("Invalid value: " + this.f19850a + " " + j8);
    }

    @Override // j$.time.temporal.r
    public final long q(TemporalAccessor temporalAccessor) {
        return temporalAccessor.g(a.EPOCH_DAY) + this.f19852c;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f19850a;
    }
}
