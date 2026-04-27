package j$.time.chrono;

/* JADX INFO: renamed from: j$.time.chrono.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2186b extends j$.time.temporal.m, j$.time.temporal.n, Comparable {
    default InterfaceC2189e I(j$.time.l lVar) {
        return C2191g.A(this, lVar);
    }

    InterfaceC2186b K(j$.time.temporal.q qVar);

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: T */
    default int compareTo(InterfaceC2186b interfaceC2186b) {
        int iCompare = Long.compare(t(), interfaceC2186b.t());
        if (iCompare != 0) {
            return iCompare;
        }
        return ((AbstractC2185a) h()).getId().compareTo(interfaceC2186b.h().getId());
    }

    @Override // j$.time.temporal.m
    default InterfaceC2186b a(long j8, j$.time.temporal.u uVar) {
        return AbstractC2188d.q(h(), super.a(j8, uVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.g() || tVar == j$.time.temporal.s.f() || tVar == j$.time.temporal.s.d() || tVar == j$.time.temporal.s.c()) {
            return null;
        }
        return tVar == j$.time.temporal.s.a() ? h() : tVar == j$.time.temporal.s.e() ? j$.time.temporal.b.DAYS : tVar.j(this);
    }

    @Override // j$.time.temporal.m
    InterfaceC2186b c(long j8, j$.time.temporal.r rVar);

    @Override // j$.time.temporal.n
    default j$.time.temporal.m d(j$.time.temporal.m mVar) {
        return mVar.c(t(), j$.time.temporal.a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.m
    InterfaceC2186b e(long j8, j$.time.temporal.u uVar);

    boolean equals(Object obj);

    @Override // j$.time.temporal.TemporalAccessor
    default boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).R() : rVar != null && rVar.U(this);
    }

    l h();

    int hashCode();

    InterfaceC2186b l(j$.time.temporal.n nVar);

    default m s() {
        return h().L(i(j$.time.temporal.a.ERA));
    }

    default long t() {
        return g(j$.time.temporal.a.EPOCH_DAY);
    }

    String toString();
}
