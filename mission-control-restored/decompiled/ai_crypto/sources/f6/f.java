package f6;

import g6.J;
import kotlin.jvm.internal.L;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {
    public static final Object b(H5.g gVar, Object obj, Object obj2, Q5.o oVar, H5.d dVar) {
        Object objC = J.c(gVar, obj2);
        try {
            Object objInvoke = ((Q5.o) L.b(oVar, 2)).invoke(obj, new r(dVar, gVar));
            J.a(gVar, objC);
            if (objInvoke == I5.c.e()) {
                J5.h.c(dVar);
            }
            return objInvoke;
        } catch (Throwable th) {
            J.a(gVar, objC);
            throw th;
        }
    }

    public static /* synthetic */ Object c(H5.g gVar, Object obj, Object obj2, Q5.o oVar, H5.d dVar, int i7, Object obj3) {
        if ((i7 & 4) != 0) {
            obj2 = J.b(gVar);
        }
        return b(gVar, obj, obj2, oVar, dVar);
    }

    public static final e6.e d(e6.e eVar, H5.g gVar) {
        return eVar instanceof q ? eVar : new s(eVar, gVar);
    }
}
