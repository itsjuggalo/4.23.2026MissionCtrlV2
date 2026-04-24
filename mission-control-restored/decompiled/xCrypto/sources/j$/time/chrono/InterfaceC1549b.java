package j$.time.chrono;

/* JADX INFO: renamed from: j$.time.chrono.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC1549b extends j$.time.temporal.m, j$.time.temporal.n, Comparable {
    InterfaceC1549b M(j$.time.temporal.q qVar);

    @Override // j$.time.temporal.m
    InterfaceC1549b b(long j4, j$.time.temporal.r rVar);

    @Override // j$.time.temporal.m
    InterfaceC1549b d(long j4, j$.time.temporal.u uVar);

    boolean equals(Object obj);

    l h();

    int hashCode();

    InterfaceC1549b m(j$.time.temporal.n nVar);

    String toString();

    default m u() {
        return h().N(i(j$.time.temporal.a.ERA));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default boolean f(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) rVar).T();
        }
        return rVar != null && rVar.W(this);
    }

    @Override // j$.time.temporal.m
    default InterfaceC1549b e(long j4, j$.time.temporal.u uVar) {
        return AbstractC1551d.r(h(), super.e(j4, uVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.g() || tVar == j$.time.temporal.s.f() || tVar == j$.time.temporal.s.d() || tVar == j$.time.temporal.s.c()) {
            return null;
        }
        if (tVar == j$.time.temporal.s.a()) {
            return h();
        }
        if (tVar == j$.time.temporal.s.e()) {
            return j$.time.temporal.b.DAYS;
        }
        return tVar.j(this);
    }

    @Override // j$.time.temporal.n
    default j$.time.temporal.m c(j$.time.temporal.m mVar) {
        return mVar.b(v(), j$.time.temporal.a.EPOCH_DAY);
    }

    default InterfaceC1552e K(j$.time.k kVar) {
        return C1554g.C(this, kVar);
    }

    default long v() {
        return g(j$.time.temporal.a.EPOCH_DAY);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: V */
    default int compareTo(InterfaceC1549b interfaceC1549b) {
        int iCompare = Long.compare(v(), interfaceC1549b.v());
        if (iCompare != 0) {
            return iCompare;
        }
        return ((AbstractC1548a) h()).s().compareTo(interfaceC1549b.h().s());
    }
}
