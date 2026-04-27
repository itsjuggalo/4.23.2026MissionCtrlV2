package r5;

import java.util.concurrent.TimeoutException;
import r5.l0;

/* JADX INFO: renamed from: r5.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2602s {
    public static l0 a(r rVar) {
        H2.m.o(rVar, "context must not be null");
        if (!rVar.h()) {
            return null;
        }
        Throwable thC = rVar.c();
        if (thC == null) {
            return l0.f22706f.q("io.grpc.Context was cancelled without error");
        }
        if (thC instanceof TimeoutException) {
            return l0.f22709i.q(thC.getMessage()).p(thC);
        }
        l0 l0VarK = l0.k(thC);
        return (l0.b.UNKNOWN.equals(l0VarK.m()) && l0VarK.l() == thC) ? l0.f22706f.q("Context cancelled").p(thC) : l0VarK.p(thC);
    }
}
