package rg;

import gd.i;
import ng.y1;
import sg.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r {
    public static final void b(final o oVar, gd.i iVar) {
        if (((Number) iVar.fold(0, new pd.o() { // from class: rg.q
            @Override // pd.o
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(r.c(oVar, ((Integer) obj).intValue(), (i.b) obj2));
            }
        })).intValue() == oVar.f19909c) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + oVar.f19908b + ",\n\t\tbut emission happened in " + iVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final int c(o oVar, int i10, i.b bVar) {
        i.c key = bVar.getKey();
        i.b bVar2 = oVar.f19908b.get(key);
        if (key != y1.N) {
            if (bVar != bVar2) {
                return Integer.MIN_VALUE;
            }
            return i10 + 1;
        }
        y1 y1Var = (y1) bVar2;
        kotlin.jvm.internal.t.d(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
        y1 y1VarD = d((y1) bVar, y1Var);
        if (y1VarD == y1Var) {
            return y1Var == null ? i10 : i10 + 1;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + y1VarD + ", expected child of " + y1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }

    public static final y1 d(y1 y1Var, y1 y1Var2) {
        while (y1Var != null) {
            if (y1Var == y1Var2 || !(y1Var instanceof z)) {
                return y1Var;
            }
            y1Var = ((z) y1Var).getParent();
        }
        return null;
    }
}
