package j$.time.temporal;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public interface TemporalAccessor {
    default Object b(t tVar) {
        if (tVar == s.f19857a || tVar == s.f19858b || tVar == s.f19859c) {
            return null;
        }
        return tVar.j(this);
    }

    boolean f(r rVar);

    long g(r rVar);

    default int i(r rVar) {
        w wVarK = k(rVar);
        if (!wVarK.h()) {
            throw new v("Invalid field " + rVar + " for get() method, use getLong() instead");
        }
        long jG = g(rVar);
        if (wVarK.i(jG)) {
            return (int) jG;
        }
        throw new j$.time.c("Invalid value for " + rVar + " (valid values " + wVarK + "): " + jG);
    }

    default w k(r rVar) {
        if (!(rVar instanceof a)) {
            Objects.requireNonNull(rVar, "field");
            return rVar.H(this);
        }
        if (f(rVar)) {
            return ((a) rVar).A();
        }
        throw new v(j$.time.d.a("Unsupported field: ", rVar));
    }
}
