package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.InterfaceC1549b;

/* JADX INFO: loaded from: classes2.dex */
public interface ChronoZonedDateTime<D extends InterfaceC1549b> extends j$.time.temporal.m, Comparable<ChronoZonedDateTime<?>> {
    InterfaceC1552e B();

    ZoneOffset E();

    ChronoZonedDateTime I(ZoneId zoneId);

    ZoneId Q();

    @Override // j$.time.temporal.m
    ChronoZonedDateTime b(long j4, j$.time.temporal.r rVar);

    @Override // j$.time.temporal.m
    ChronoZonedDateTime d(long j4, j$.time.temporal.u uVar);

    @Override // j$.time.temporal.TemporalAccessor
    default j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            if (rVar == j$.time.temporal.a.INSTANT_SECONDS || rVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return ((j$.time.temporal.a) rVar).C();
            }
            return B().l(rVar);
        }
        return rVar.J(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int i(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            int i4 = AbstractC1556i.f13155a[((j$.time.temporal.a) rVar).ordinal()];
            if (i4 == 1) {
                throw new j$.time.temporal.v("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i4 == 2) {
                return E().Z();
            }
            return B().i(rVar);
        }
        return super.i(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long g(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            int i4 = AbstractC1556i.f13155a[((j$.time.temporal.a) rVar).ordinal()];
            if (i4 == 1) {
                return O();
            }
            if (i4 == 2) {
                return E().Z();
            }
            return B().g(rVar);
        }
        return rVar.r(this);
    }

    default InterfaceC1549b o() {
        return B().o();
    }

    default j$.time.k n() {
        return B().n();
    }

    default l h() {
        return o().h();
    }

    @Override // j$.time.temporal.m
    default ChronoZonedDateTime m(j$.time.temporal.n nVar) {
        return k.r(h(), nVar.c(this));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    default ChronoZonedDateTime e(long j4, j$.time.temporal.b bVar) {
        return k.r(h(), super.e(j4, bVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.f() || tVar == j$.time.temporal.s.g()) {
            return Q();
        }
        if (tVar == j$.time.temporal.s.d()) {
            return E();
        }
        if (tVar == j$.time.temporal.s.c()) {
            return n();
        }
        if (tVar == j$.time.temporal.s.a()) {
            return h();
        }
        if (tVar == j$.time.temporal.s.e()) {
            return j$.time.temporal.b.NANOS;
        }
        return tVar.j(this);
    }

    default Instant toInstant() {
        return Instant.ofEpochSecond(O(), n().Z());
    }

    default long O() {
        return ((o().v() * 86400) + ((long) n().m0())) - ((long) E().Z());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    default int compareTo(ChronoZonedDateTime chronoZonedDateTime) {
        int iCompare = Long.compare(O(), chronoZonedDateTime.O());
        return (iCompare == 0 && (iCompare = n().Z() - chronoZonedDateTime.n().Z()) == 0 && (iCompare = B().compareTo(chronoZonedDateTime.B())) == 0 && (iCompare = Q().s().compareTo(chronoZonedDateTime.Q().s())) == 0) ? ((AbstractC1548a) h()).s().compareTo(chronoZonedDateTime.h().s()) : iCompare;
    }

    default boolean isBefore(ChronoZonedDateTime<?> chronoZonedDateTime) {
        long jO = O();
        long jO2 = chronoZonedDateTime.O();
        if (jO >= jO2) {
            return jO == jO2 && n().Z() < chronoZonedDateTime.n().Z();
        }
        return true;
    }
}
