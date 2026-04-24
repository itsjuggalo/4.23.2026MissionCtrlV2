package j$.time.chrono;

import j$.time.temporal.TemporalAccessor;

/* JADX INFO: loaded from: classes2.dex */
public interface m extends TemporalAccessor, j$.time.temporal.n {
    int p();

    @Override // j$.time.temporal.TemporalAccessor
    default boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.ERA : rVar != null && rVar.W(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int i(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.ERA) {
            return p();
        }
        return super.i(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long g(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.ERA) {
            return p();
        }
        if (rVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
        return rVar.r(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.e()) {
            return j$.time.temporal.b.ERAS;
        }
        return super.a(tVar);
    }

    @Override // j$.time.temporal.n
    default j$.time.temporal.m c(j$.time.temporal.m mVar) {
        return mVar.b(p(), j$.time.temporal.a.ERA);
    }
}
