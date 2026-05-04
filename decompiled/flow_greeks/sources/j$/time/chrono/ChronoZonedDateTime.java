package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.b;

/* JADX INFO: loaded from: classes2.dex */
public interface ChronoZonedDateTime<D extends b> extends j$.time.temporal.m, Comparable<ChronoZonedDateTime<?>> {
    ChronoZonedDateTime D(ZoneId zoneId);

    ZoneId J();

    @Override // j$.time.temporal.m
    ChronoZonedDateTime c(long j10, j$.time.temporal.q qVar);

    @Override // j$.time.temporal.m
    ChronoZonedDateTime d(long j10, j$.time.temporal.s sVar);

    ZoneOffset o();

    e x();

    @Override // j$.time.temporal.TemporalAccessor
    default j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar != j$.time.temporal.a.INSTANT_SECONDS && qVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return x().l(qVar);
            }
            return ((j$.time.temporal.a) qVar).f13735b;
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i10 = i.f13583a[((j$.time.temporal.a) qVar).ordinal()];
            if (i10 == 1) {
                throw new j$.time.temporal.t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i10 != 2) {
                return x().g(qVar);
            }
            return o().f13556b;
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i10 = i.f13583a[((j$.time.temporal.a) qVar).ordinal()];
            if (i10 == 1) {
                return W();
            }
            if (i10 != 2) {
                return x().i(qVar);
            }
            return o().f13556b;
        }
        return qVar.P(this);
    }

    default b n() {
        return x().n();
    }

    default j$.time.l j() {
        return x().j();
    }

    default l f() {
        return n().f();
    }

    @Override // j$.time.temporal.m
    default ChronoZonedDateTime m(j$.time.temporal.n nVar) {
        return k.s(f(), nVar.e(this));
    }

    @Override // j$.time.temporal.m
    default ChronoZonedDateTime a(long j10, j$.time.temporal.s sVar) {
        return k.s(f(), super.a(j10, sVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f13757e || iVar == j$.time.temporal.r.f13753a) {
            return J();
        }
        if (iVar == j$.time.temporal.r.f13756d) {
            return o();
        }
        if (iVar == j$.time.temporal.r.f13759g) {
            return j();
        }
        if (iVar == j$.time.temporal.r.f13754b) {
            return f();
        }
        if (iVar == j$.time.temporal.r.f13755c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    default Instant toInstant() {
        return Instant.A(W(), j().f13715d);
    }

    default long W() {
        return ((n().K() * 86400) + ((long) j().e0())) - ((long) o().f13556b);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    default int compareTo(ChronoZonedDateTime chronoZonedDateTime) {
        int iCompare = Long.compare(W(), chronoZonedDateTime.W());
        return (iCompare == 0 && (iCompare = j().f13715d - chronoZonedDateTime.j().f13715d) == 0 && (iCompare = x().compareTo(chronoZonedDateTime.x())) == 0 && (iCompare = J().q().compareTo(chronoZonedDateTime.J().q())) == 0) ? ((a) f()).q().compareTo(chronoZonedDateTime.f().q()) : iCompare;
    }

    default boolean isBefore(ChronoZonedDateTime<?> chronoZonedDateTime) {
        long jW = W();
        long jW2 = chronoZonedDateTime.W();
        if (jW >= jW2) {
            return jW == jW2 && j().f13715d < chronoZonedDateTime.j().f13715d;
        }
        return true;
    }
}
