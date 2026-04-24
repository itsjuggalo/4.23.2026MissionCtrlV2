package j$.time.chrono;

import j$.time.temporal.TemporalAccessor;

/* JADX INFO: loaded from: classes3.dex */
public interface m extends TemporalAccessor, j$.time.temporal.n {
    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.s.e() ? j$.time.temporal.b.ERAS : super.b(tVar);
    }

    @Override // j$.time.temporal.n
    default j$.time.temporal.m d(j$.time.temporal.m mVar) {
        return mVar.c(o(), j$.time.temporal.a.ERA);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.ERA : rVar != null && rVar.U(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long g(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.ERA) {
            return o();
        }
        if (rVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
        return rVar.q(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int i(j$.time.temporal.r rVar) {
        return rVar == j$.time.temporal.a.ERA ? o() : super.i(rVar);
    }

    int o();
}
