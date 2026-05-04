package ng;

import gd.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x0 {
    public static final Object a(long j10, gd.e eVar) {
        if (j10 <= 0) {
            return cd.h0.f3852a;
        }
        p pVar = new p(hd.b.c(eVar), 1);
        pVar.E();
        if (j10 < Long.MAX_VALUE) {
            b(pVar.getContext()).b(j10, pVar);
        }
        Object objY = pVar.y();
        if (objY == hd.c.f()) {
            id.h.c(eVar);
        }
        return objY == hd.c.f() ? objY : cd.h0.f3852a;
    }

    public static final w0 b(gd.i iVar) {
        i.b bVar = iVar.get(gd.f.K);
        w0 w0Var = bVar instanceof w0 ? (w0) bVar : null;
        return w0Var == null ? t0.a() : w0Var;
    }
}
