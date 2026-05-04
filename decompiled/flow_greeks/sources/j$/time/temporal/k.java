package j$.time.temporal;

import j$.time.format.w;
import j$.time.format.x;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum k implements q {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);

    private static final long serialVersionUID = -7501623920830201812L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f13747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient u f13748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient long f13749c;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j10) {
        this.f13747a = str;
        this.f13748b = u.f((-365243219162L) + j10, 365241780471L + j10);
        this.f13749c = j10;
    }

    @Override // j$.time.temporal.q
    public final u I() {
        return this.f13748b;
    }

    @Override // j$.time.temporal.q
    public final m V(m mVar, long j10) {
        if (!this.f13748b.e(j10)) {
            throw new j$.time.c("Invalid value: " + this.f13747a + " " + j10);
        }
        return mVar.c(Math.subtractExact(j10, this.f13749c), a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final u A(TemporalAccessor temporalAccessor) {
        if (temporalAccessor.h(a.EPOCH_DAY)) {
            return this.f13748b;
        }
        throw new j$.time.c("Unsupported field: " + this);
    }

    @Override // j$.time.temporal.q
    public final boolean s(TemporalAccessor temporalAccessor) {
        return temporalAccessor.h(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final long P(TemporalAccessor temporalAccessor) {
        return temporalAccessor.i(a.EPOCH_DAY) + this.f13749c;
    }

    @Override // j$.time.temporal.q
    public final TemporalAccessor F(Map map, w wVar, x xVar) {
        long jLongValue = ((Long) map.remove(this)).longValue();
        j$.time.chrono.l lVarR = j$.time.chrono.l.r(wVar);
        x xVar2 = x.LENIENT;
        long j10 = this.f13749c;
        if (xVar == xVar2) {
            return lVarR.p(Math.subtractExact(jLongValue, j10));
        }
        this.f13748b.b(jLongValue, this);
        return lVarR.p(jLongValue - j10);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f13747a;
    }
}
