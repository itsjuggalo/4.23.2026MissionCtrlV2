package dh;

import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k1 {
    public static final int a(bh.e eVar, bh.e[] typeParams) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        kotlin.jvm.internal.t.f(typeParams, "typeParams");
        int iHashCode = (eVar.i().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable iterableA = bh.i.a(eVar);
        Iterator it = iterableA.iterator();
        int iHashCode2 = 1;
        int i10 = 1;
        while (true) {
            int iHashCode3 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i11 = i10 * 31;
            String strI = ((bh.e) it.next()).i();
            if (strI != null) {
                iHashCode3 = strI.hashCode();
            }
            i10 = i11 + iHashCode3;
        }
        Iterator it2 = iterableA.iterator();
        while (it2.hasNext()) {
            int i12 = iHashCode2 * 31;
            bh.l lVarH = ((bh.e) it2.next()).h();
            iHashCode2 = i12 + (lVarH != null ? lVarH.hashCode() : 0);
        }
        return (((iHashCode * 31) + i10) * 31) + iHashCode2;
    }
}
