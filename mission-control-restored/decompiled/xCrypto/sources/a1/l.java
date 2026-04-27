package a1;

import e1.AbstractC1228a;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static void a(X0.i iVar, X0.f fVar) {
        if (!(iVar instanceof s)) {
            AbstractC1228a.g("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", iVar);
        } else {
            u.c().e().l(((s) iVar).d().f(fVar), 1);
        }
    }
}
