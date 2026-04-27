package j$.time.temporal;

import j$.time.format.y;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
enum k implements r {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);

    private static final long serialVersionUID = -7501623920830201812L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient String f13314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient w f13315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient long f13316c;

    @Override // j$.time.temporal.r
    public final boolean T() {
        return true;
    }

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j4) {
        this.f13314a = str;
        this.f13315b = w.j((-365243219162L) + j4, 365241780471L + j4);
        this.f13316c = j4;
    }

    @Override // j$.time.temporal.r
    public final w C() {
        return this.f13315b;
    }

    @Override // j$.time.temporal.r
    public final w J(TemporalAccessor temporalAccessor) {
        if (temporalAccessor.f(a.EPOCH_DAY)) {
            return this.f13315b;
        }
        throw new j$.time.c("Unsupported field: " + this);
    }

    @Override // j$.time.temporal.r
    public final boolean W(TemporalAccessor temporalAccessor) {
        return temporalAccessor.f(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.r
    public final long r(TemporalAccessor temporalAccessor) {
        return temporalAccessor.g(a.EPOCH_DAY) + this.f13316c;
    }

    @Override // j$.time.temporal.r
    public final m p(m mVar, long j4) {
        if (!this.f13315b.i(j4)) {
            throw new j$.time.c("Invalid value: " + this.f13314a + " " + j4);
        }
        return mVar.b(Math.subtractExact(j4, this.f13316c), a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.r
    public final TemporalAccessor S(HashMap map, TemporalAccessor temporalAccessor, y yVar) {
        long jLongValue = ((Long) map.remove(this)).longValue();
        j$.time.chrono.l lVarF = j$.time.chrono.l.F(temporalAccessor);
        y yVar2 = y.LENIENT;
        long j4 = this.f13316c;
        if (yVar == yVar2) {
            return lVarF.q(Math.subtractExact(jLongValue, j4));
        }
        this.f13315b.b(jLongValue, this);
        return lVarF.q(jLongValue - j4);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f13314a;
    }
}
