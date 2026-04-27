package F4;

import F4.j0;
import java.util.concurrent.TimeoutException;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: F4.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0504s {
    public static j0 a(r rVar) {
        AbstractC2848n.o(rVar, "context must not be null");
        if (!rVar.h()) {
            return null;
        }
        Throwable thC = rVar.c();
        if (thC == null) {
            return j0.f1798f.r("io.grpc.Context was cancelled without error");
        }
        if (thC instanceof TimeoutException) {
            return j0.f1801i.r(thC.getMessage()).q(thC);
        }
        j0 j0VarL = j0.l(thC);
        return (j0.b.UNKNOWN.equals(j0VarL.n()) && j0VarL.m() == thC) ? j0.f1798f.r("Context cancelled").q(thC) : j0VarL.q(thC);
    }
}
