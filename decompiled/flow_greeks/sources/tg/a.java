package tg;

import cd.h0;
import cd.r;
import cd.s;
import gd.e;
import pd.o;
import sg.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final void a(e eVar, Throwable th) throws Throwable {
        r.a aVar = r.f3870b;
        eVar.resumeWith(r.b(s.a(th)));
        throw th;
    }

    public static final void b(e eVar, e eVar2) throws Throwable {
        try {
            e eVarC = hd.b.c(eVar);
            r.a aVar = r.f3870b;
            i.b(eVarC, r.b(h0.f3852a));
        } catch (Throwable th) {
            a(eVar2, th);
        }
    }

    public static final void c(o oVar, Object obj, e eVar) {
        try {
            e eVarC = hd.b.c(hd.b.a(oVar, obj, eVar));
            r.a aVar = r.f3870b;
            i.b(eVarC, r.b(h0.f3852a));
        } catch (Throwable th) {
            a(eVar, th);
        }
    }
}
