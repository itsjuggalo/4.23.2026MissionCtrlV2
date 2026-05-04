package ee;

import dd.a0;
import dd.o0;
import fe.l1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xf.c1;
import xf.v1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y {
    public static final v1 a(fe.e from, fe.e to) {
        kotlin.jvm.internal.t.f(from, "from");
        kotlin.jvm.internal.t.f(to, "to");
        from.v().size();
        to.v().size();
        v1.a aVar = v1.f25085c;
        List listV = from.v();
        kotlin.jvm.internal.t.e(listV, "getDeclaredTypeParameters(...)");
        ArrayList arrayList = new ArrayList(dd.s.u(listV, 10));
        Iterator it = listV.iterator();
        while (it.hasNext()) {
            arrayList.add(((l1) it.next()).k());
        }
        List listV2 = to.v();
        kotlin.jvm.internal.t.e(listV2, "getDeclaredTypeParameters(...)");
        ArrayList arrayList2 = new ArrayList(dd.s.u(listV2, 10));
        Iterator it2 = listV2.iterator();
        while (it2.hasNext()) {
            c1 c1VarS = ((l1) it2.next()).s();
            kotlin.jvm.internal.t.e(c1VarS, "getDefaultType(...)");
            arrayList2.add(cg.d.d(c1VarS));
        }
        return v1.a.e(aVar, o0.t(a0.S0(arrayList, arrayList2)), false, 2, null);
    }
}
