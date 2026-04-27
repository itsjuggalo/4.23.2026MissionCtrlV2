package r6;

import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: renamed from: r6.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2615c0 {
    public static final int a(p6.e eVar, p6.e[] typeParams) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        kotlin.jvm.internal.r.f(typeParams, "typeParams");
        int iHashCode = (eVar.a().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable iterableA = p6.g.a(eVar);
        Iterator it = iterableA.iterator();
        int iHashCode2 = 1;
        int i7 = 1;
        while (true) {
            int iHashCode3 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i8 = i7 * 31;
            String strA = ((p6.e) it.next()).a();
            if (strA != null) {
                iHashCode3 = strA.hashCode();
            }
            i7 = i8 + iHashCode3;
        }
        Iterator it2 = iterableA.iterator();
        while (it2.hasNext()) {
            int i9 = iHashCode2 * 31;
            p6.i iVarE = ((p6.e) it2.next()).e();
            iHashCode2 = i9 + (iVarE != null ? iVarE.hashCode() : 0);
        }
        return (((iHashCode * 31) + i7) * 31) + iHashCode2;
    }
}
