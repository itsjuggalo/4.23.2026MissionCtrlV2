package o7;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o7.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2516l0 {
    public static final int a(m7.e eVar, m7.e[] typeParams) {
        AbstractC2304t.f(eVar, "<this>");
        AbstractC2304t.f(typeParams, "typeParams");
        int iHashCode = (eVar.a().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable iterableA = m7.i.a(eVar);
        Iterator it = iterableA.iterator();
        int iHashCode2 = 1;
        int i8 = 1;
        while (true) {
            int iHashCode3 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i9 = i8 * 31;
            String strA = ((m7.e) it.next()).a();
            if (strA != null) {
                iHashCode3 = strA.hashCode();
            }
            i8 = i9 + iHashCode3;
        }
        Iterator it2 = iterableA.iterator();
        while (it2.hasNext()) {
            int i10 = iHashCode2 * 31;
            m7.l lVarI = ((m7.e) it2.next()).i();
            iHashCode2 = i10 + (lVarI != null ? lVarI.hashCode() : 0);
        }
        return (((iHashCode * 31) + i8) * 31) + iHashCode2;
    }
}
