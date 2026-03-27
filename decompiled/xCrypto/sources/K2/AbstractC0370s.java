package K2;

import K2.l0;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: K2.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0370s {
    public static l0 a(r rVar) {
        Z1.m.o(rVar, "context must not be null");
        if (!rVar.h()) {
            return null;
        }
        Throwable thC = rVar.c();
        if (thC == null) {
            return l0.f1216f.q("io.grpc.Context was cancelled without error");
        }
        if (thC instanceof TimeoutException) {
            return l0.f1219i.q(thC.getMessage()).p(thC);
        }
        l0 l0VarK = l0.k(thC);
        return (l0.b.UNKNOWN.equals(l0VarK.m()) && l0VarK.l() == thC) ? l0.f1216f.q("Context cancelled").p(thC) : l0VarK.p(thC);
    }
}
