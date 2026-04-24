package z3;

import W2.E;
import W2.p;
import W2.q;
import Z2.e;
import a3.AbstractC0786b;
import i3.k;
import i3.o;
import y3.AbstractC1957k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final void a(e eVar, Throwable th) throws Throwable {
        p.a aVar = p.f5487b;
        eVar.resumeWith(p.b(q.a(th)));
        throw th;
    }

    public static final void b(e eVar, e eVar2) throws Throwable {
        try {
            e eVarC = AbstractC0786b.c(eVar);
            p.a aVar = p.f5487b;
            AbstractC1957k.c(eVarC, p.b(E.f5463a), null, 2, null);
        } catch (Throwable th) {
            a(eVar2, th);
        }
    }

    public static final void c(o oVar, Object obj, e eVar, k kVar) throws Throwable {
        try {
            e eVarC = AbstractC0786b.c(AbstractC0786b.a(oVar, obj, eVar));
            p.a aVar = p.f5487b;
            AbstractC1957k.b(eVarC, p.b(E.f5463a), kVar);
        } catch (Throwable th) {
            a(eVar, th);
        }
    }

    public static /* synthetic */ void d(o oVar, Object obj, e eVar, k kVar, int i4, Object obj2) throws Throwable {
        if ((i4 & 4) != 0) {
            kVar = null;
        }
        c(oVar, obj, eVar, kVar);
    }
}
