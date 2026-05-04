package ng;

import gd.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i0 {
    public static final gd.i d(gd.i iVar, gd.i iVar2, final boolean z10) {
        boolean zH = h(iVar);
        boolean zH2 = h(iVar2);
        if (!zH && !zH2) {
            return iVar.plus(iVar2);
        }
        final kotlin.jvm.internal.m0 m0Var = new kotlin.jvm.internal.m0();
        m0Var.f14947a = iVar2;
        gd.j jVar = gd.j.f10531a;
        gd.i iVar3 = (gd.i) iVar.fold(jVar, new pd.o() { // from class: ng.g0
            @Override // pd.o
            public final Object invoke(Object obj, Object obj2) {
                return i0.e(m0Var, z10, (gd.i) obj, (i.b) obj2);
            }
        });
        if (zH2) {
            m0Var.f14947a = ((gd.i) m0Var.f14947a).fold(jVar, new pd.o() { // from class: ng.h0
                @Override // pd.o
                public final Object invoke(Object obj, Object obj2) {
                    return i0.f((gd.i) obj, (i.b) obj2);
                }
            });
        }
        return iVar3.plus((gd.i) m0Var.f14947a);
    }

    public static final gd.i e(kotlin.jvm.internal.m0 m0Var, boolean z10, gd.i iVar, i.b bVar) {
        return iVar.plus(bVar);
    }

    public static final gd.i f(gd.i iVar, i.b bVar) {
        return iVar.plus(bVar);
    }

    public static final String g(gd.i iVar) {
        return null;
    }

    public static final boolean h(gd.i iVar) {
        return ((Boolean) iVar.fold(Boolean.FALSE, new pd.o() { // from class: ng.f0
            @Override // pd.o
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(i0.i(((Boolean) obj).booleanValue(), (i.b) obj2));
            }
        })).booleanValue();
    }

    public static final boolean i(boolean z10, i.b bVar) {
        return z10;
    }

    public static final gd.i j(gd.i iVar, gd.i iVar2) {
        return !h(iVar2) ? iVar.plus(iVar2) : d(iVar, iVar2, false);
    }

    public static final gd.i k(n0 n0Var, gd.i iVar) {
        gd.i iVarD = d(n0Var.g(), iVar, true);
        return (iVarD == c1.a() || iVarD.get(gd.f.K) != null) ? iVarD : iVarD.plus(c1.a());
    }

    public static final a3 l(id.e eVar) {
        while (!(eVar instanceof y0) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof a3) {
                return (a3) eVar;
            }
        }
        return null;
    }

    public static final a3 m(gd.e eVar, gd.i iVar, Object obj) {
        if (!(eVar instanceof id.e) || iVar.get(b3.f17076a) == null) {
            return null;
        }
        a3 a3VarL = l((id.e) eVar);
        if (a3VarL != null) {
            a3VarL.P0(iVar, obj);
        }
        return a3VarL;
    }
}
