package j$.time.temporal;

import j$.time.format.y;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
enum k implements r {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);

    private static final long serialVersionUID = -7501623920830201812L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient String f17273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient w f17274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient long f17275c;

    @Override // j$.time.temporal.r
    public final boolean T() {
        return true;
    }

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j7) {
        this.f17273a = str;
        this.f17274b = w.j((-365243219162L) + j7, 365241780471L + j7);
        this.f17275c = j7;
    }

    @Override // j$.time.temporal.r
    public final w C() {
        return this.f17274b;
    }

    @Override // j$.time.temporal.r
    public final w J(TemporalAccessor temporalAccessor) {
        if (!temporalAccessor.f(a.EPOCH_DAY)) {
            throw new j$.time.c("Unsupported field: " + this);
        }
        return this.f17274b;
    }

    @Override // j$.time.temporal.r
    public final boolean W(TemporalAccessor temporalAccessor) {
        return temporalAccessor.f(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.r
    public final long r(TemporalAccessor temporalAccessor) {
        return temporalAccessor.g(a.EPOCH_DAY) + this.f17275c;
    }

    @Override // j$.time.temporal.r
    public final m p(m mVar, long j7) {
        if (!this.f17274b.i(j7)) {
            throw new j$.time.c("Invalid value: " + this.f17273a + " " + j7);
        }
        return mVar.b(Math.subtractExact(j7, this.f17275c), a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.r
    public final TemporalAccessor S(HashMap map, TemporalAccessor temporalAccessor, y yVar) {
        long jLongValue = ((Long) map.remove(this)).longValue();
        j$.time.chrono.l lVarF = j$.time.chrono.l.F(temporalAccessor);
        y yVar2 = y.LENIENT;
        long j7 = this.f17275c;
        if (yVar == yVar2) {
            return lVarF.q(Math.subtractExact(jLongValue, j7));
        }
        this.f17274b.b(jLongValue, this);
        return lVarF.q(jLongValue - j7);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f17273a;
    }
}
