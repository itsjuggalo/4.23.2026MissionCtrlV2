package rb;

import java.util.concurrent.TimeoutException;
import rb.k1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public static k1 a(r rVar) {
        p6.n.o(rVar, "context must not be null");
        if (!rVar.h()) {
            return null;
        }
        Throwable thC = rVar.c();
        if (thC == null) {
            return k1.f19593f.r("io.grpc.Context was cancelled without error");
        }
        if (thC instanceof TimeoutException) {
            return k1.f19596i.r(thC.getMessage()).q(thC);
        }
        k1 k1VarL = k1.l(thC);
        return (k1.b.UNKNOWN.equals(k1VarL.n()) && k1VarL.m() == thC) ? k1.f19593f.r("Context cancelled").q(thC) : k1VarL.q(thC);
    }
}
