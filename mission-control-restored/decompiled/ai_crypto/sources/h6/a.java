package h6;

import E5.E;
import E5.p;
import E5.q;
import H5.d;
import Q5.k;
import Q5.o;
import g6.AbstractC1651k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final void a(d dVar, Throwable th) throws Throwable {
        p.a aVar = p.f1681b;
        dVar.resumeWith(p.b(q.a(th)));
        throw th;
    }

    public static final void b(d dVar, d dVar2) throws Throwable {
        try {
            d dVarC = I5.b.c(dVar);
            p.a aVar = p.f1681b;
            AbstractC1651k.c(dVarC, p.b(E.f1657a), null, 2, null);
        } catch (Throwable th) {
            a(dVar2, th);
        }
    }

    public static final void c(o oVar, Object obj, d dVar, k kVar) throws Throwable {
        try {
            d dVarC = I5.b.c(I5.b.a(oVar, obj, dVar));
            p.a aVar = p.f1681b;
            AbstractC1651k.b(dVarC, p.b(E.f1657a), kVar);
        } catch (Throwable th) {
            a(dVar, th);
        }
    }

    public static /* synthetic */ void d(o oVar, Object obj, d dVar, k kVar, int i7, Object obj2) throws Throwable {
        if ((i7 & 4) != 0) {
            kVar = null;
        }
        c(oVar, obj, dVar, kVar);
    }
}
