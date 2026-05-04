package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o0 {
    public static final n0 a(gd.i iVar) {
        if (iVar.get(y1.N) == null) {
            iVar = iVar.plus(c2.b(null, 1, null));
        }
        return new sg.d(iVar);
    }

    public static final n0 b() {
        return new sg.d(t2.b(null, 1, null).plus(c1.c()));
    }

    public static final Object c(pd.o oVar, gd.e eVar) {
        sg.z zVar = new sg.z(eVar.getContext(), eVar);
        Object objB = tg.b.b(zVar, zVar, oVar);
        if (objB == hd.c.f()) {
            id.h.c(eVar);
        }
        return objB;
    }

    public static final void d(n0 n0Var) {
        b2.g(n0Var.g());
    }

    public static final boolean e(n0 n0Var) {
        y1 y1Var = (y1) n0Var.g().get(y1.N);
        if (y1Var != null) {
            return y1Var.isActive();
        }
        return true;
    }
}
