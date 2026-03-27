package j$.time.chrono;

/* JADX INFO: renamed from: j$.time.chrono.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2030b extends j$.time.temporal.m, j$.time.temporal.n, Comparable {
    InterfaceC2030b M(j$.time.temporal.q qVar);

    @Override // j$.time.temporal.m
    InterfaceC2030b b(long j7, j$.time.temporal.r rVar);

    @Override // j$.time.temporal.m
    InterfaceC2030b d(long j7, j$.time.temporal.u uVar);

    boolean equals(Object obj);

    l h();

    int hashCode();

    InterfaceC2030b m(j$.time.temporal.n nVar);

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
    default InterfaceC2030b e(long j7, j$.time.temporal.u uVar) {
        return AbstractC2032d.r(h(), super.e(j7, uVar));
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

    default InterfaceC2033e K(j$.time.l lVar) {
        return C2035g.C(this, lVar);
    }

    default long v() {
        return g(j$.time.temporal.a.EPOCH_DAY);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: V */
    default int compareTo(InterfaceC2030b interfaceC2030b) {
        int iCompare = Long.compare(v(), interfaceC2030b.v());
        if (iCompare != 0) {
            return iCompare;
        }
        return ((AbstractC2029a) h()).s().compareTo(interfaceC2030b.h().s());
    }
}
