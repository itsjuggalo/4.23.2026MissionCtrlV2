package dh;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bh.e[] f8133a = new bh.e[0];

    public static final Set a(bh.e eVar) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        if (eVar instanceof l) {
            return ((l) eVar).a();
        }
        HashSet hashSet = new HashSet(eVar.l());
        int iL = eVar.l();
        for (int i10 = 0; i10 < iL; i10++) {
            hashSet.add(eVar.m(i10));
        }
        return hashSet;
    }

    public static final bh.e[] b(List list) {
        bh.e[] eVarArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (eVarArr = (bh.e[]) list.toArray(new bh.e[0])) == null) ? f8133a : eVarArr;
    }
}
