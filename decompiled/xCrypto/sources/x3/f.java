package x3;

import a3.AbstractC0787c;
import kotlin.jvm.internal.K;
import y3.J;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final Object b(Z2.i iVar, Object obj, Object obj2, i3.o oVar, Z2.e eVar) {
        Object objC = J.c(iVar, obj2);
        try {
            Object objInvoke = ((i3.o) K.b(oVar, 2)).invoke(obj, new r(eVar, iVar));
            J.a(iVar, objC);
            if (objInvoke == AbstractC0787c.e()) {
                b3.h.c(eVar);
            }
            return objInvoke;
        } catch (Throwable th) {
            J.a(iVar, objC);
            throw th;
        }
    }

    public static /* synthetic */ Object c(Z2.i iVar, Object obj, Object obj2, i3.o oVar, Z2.e eVar, int i4, Object obj3) {
        if ((i4 & 4) != 0) {
            obj2 = J.b(iVar);
        }
        return b(iVar, obj, obj2, oVar, eVar);
    }

    public static final w3.e d(w3.e eVar, Z2.i iVar) {
        return eVar instanceof q ? eVar : new s(eVar, iVar);
    }
}
