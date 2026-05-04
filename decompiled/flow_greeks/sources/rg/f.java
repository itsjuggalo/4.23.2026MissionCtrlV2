package rg;

import kotlin.jvm.internal.t0;
import sg.k0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final Object b(gd.i iVar, Object obj, Object obj2, pd.o oVar, gd.e eVar) {
        Object objI = k0.i(iVar, obj2);
        try {
            t tVar = new t(eVar, iVar);
            Object objD = !(oVar instanceof id.a) ? hd.b.d(oVar, obj, tVar) : ((pd.o) t0.c(oVar, 2)).invoke(obj, tVar);
            k0.f(iVar, objI);
            if (objD == hd.c.f()) {
                id.h.c(eVar);
            }
            return objD;
        } catch (Throwable th) {
            k0.f(iVar, objI);
            throw th;
        }
    }

    public static /* synthetic */ Object c(gd.i iVar, Object obj, Object obj2, pd.o oVar, gd.e eVar, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = k0.g(iVar);
        }
        return b(iVar, obj, obj2, oVar, eVar);
    }

    public static final qg.e d(qg.e eVar, gd.i iVar) {
        return !(eVar instanceof s) ? new u(eVar, iVar) : eVar;
    }
}
