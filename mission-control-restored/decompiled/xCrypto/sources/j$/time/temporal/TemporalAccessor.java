package j$.time.temporal;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface TemporalAccessor {
    boolean f(r rVar);

    long g(r rVar);

    default w l(r rVar) {
        if (!(rVar instanceof a)) {
            Objects.requireNonNull(rVar, "field");
            return rVar.J(this);
        }
        if (f(rVar)) {
            return ((a) rVar).C();
        }
        throw new v(j$.time.d.a("Unsupported field: ", rVar));
    }

    default int i(r rVar) {
        w wVarL = l(rVar);
        if (!wVarL.h()) {
            throw new v("Invalid field " + rVar + " for get() method, use getLong() instead");
        }
        long jG = g(rVar);
        if (wVarL.i(jG)) {
            return (int) jG;
        }
        throw new j$.time.c("Invalid value for " + rVar + " (valid values " + wVarL + "): " + jG);
    }

    default Object a(t tVar) {
        if (tVar == s.f13321a || tVar == s.f13322b || tVar == s.f13323c) {
            return null;
        }
        return tVar.j(this);
    }
}
