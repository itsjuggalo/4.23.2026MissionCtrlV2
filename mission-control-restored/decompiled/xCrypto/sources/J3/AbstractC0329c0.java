package J3;

import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: renamed from: J3.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0329c0 {
    public static final int a(H3.e eVar, H3.e[] typeParams) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        kotlin.jvm.internal.r.f(typeParams, "typeParams");
        int iHashCode = (eVar.a().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable iterableA = H3.g.a(eVar);
        Iterator it = iterableA.iterator();
        int iHashCode2 = 1;
        int i4 = 1;
        while (true) {
            int iHashCode3 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i5 = i4 * 31;
            String strA = ((H3.e) it.next()).a();
            if (strA != null) {
                iHashCode3 = strA.hashCode();
            }
            i4 = i5 + iHashCode3;
        }
        Iterator it2 = iterableA.iterator();
        while (it2.hasNext()) {
            int i6 = iHashCode2 * 31;
            H3.i iVarE = ((H3.e) it2.next()).e();
            iHashCode2 = i6 + (iVarE != null ? iVarE.hashCode() : 0);
        }
        return (((iHashCode * 31) + i4) * 31) + iHashCode2;
    }
}
