package j$.time.chrono;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends j$.time.temporal.m, j$.time.temporal.n, Comparable {
    b R(j$.time.temporal.p pVar);

    @Override // j$.time.temporal.m
    b c(long j10, j$.time.temporal.q qVar);

    @Override // j$.time.temporal.m
    b d(long j10, j$.time.temporal.s sVar);

    boolean equals(Object obj);

    l f();

    int hashCode();

    b m(j$.time.temporal.n nVar);

    String toString();

    default e L(j$.time.l lVar) {
        return new g(this, lVar);
    }

    default m N() {
        return f().B(g(j$.time.temporal.a.ERA));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default boolean h(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).isDateBased();
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.m
    default b a(long j10, j$.time.temporal.s sVar) {
        return d.s(f(), super.a(j10, sVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f13753a || iVar == j$.time.temporal.r.f13757e || iVar == j$.time.temporal.r.f13756d || iVar == j$.time.temporal.r.f13759g) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f13754b) {
            return f();
        }
        if (iVar == j$.time.temporal.r.f13755c) {
            return j$.time.temporal.b.DAYS;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    default j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(K(), j$.time.temporal.a.EPOCH_DAY);
    }

    default long K() {
        return i(j$.time.temporal.a.EPOCH_DAY);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: U */
    default int compareTo(b bVar) {
        int iCompare = Long.compare(K(), bVar.K());
        if (iCompare != 0) {
            return iCompare;
        }
        return ((a) f()).q().compareTo(bVar.f().q());
    }
}
