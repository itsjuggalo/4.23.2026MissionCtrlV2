package yf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import xf.c1;
import xf.e0;
import xf.i0;
import xf.l0;
import xf.l2;
import xf.u0;
import xf.v0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static final l2 a(Collection types) {
        c1 c1VarV0;
        kotlin.jvm.internal.t.f(types, "types");
        int size = types.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types");
        }
        if (size == 1) {
            return (l2) dd.a0.u0(types);
        }
        ArrayList arrayList = new ArrayList(dd.s.u(types, 10));
        Iterator it = types.iterator();
        boolean z10 = false;
        boolean z11 = false;
        while (it.hasNext()) {
            l2 l2Var = (l2) it.next();
            z10 = z10 || v0.a(l2Var);
            if (l2Var instanceof c1) {
                c1VarV0 = (c1) l2Var;
            } else {
                if (!(l2Var instanceof i0)) {
                    throw new cd.o();
                }
                if (e0.a(l2Var)) {
                    return l2Var;
                }
                c1VarV0 = ((i0) l2Var).V0();
                z11 = true;
            }
            arrayList.add(c1VarV0);
        }
        if (z10) {
            return zf.l.d(zf.k.C0, types.toString());
        }
        if (!z11) {
            return z.f25434a.d(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(dd.s.u(types, 10));
        Iterator it2 = types.iterator();
        while (it2.hasNext()) {
            arrayList2.add(l0.d((l2) it2.next()));
        }
        z zVar = z.f25434a;
        return u0.e(zVar.d(arrayList), zVar.d(arrayList2));
    }
}
