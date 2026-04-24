package r6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p6.e[] f22862a = new p6.e[0];

    public static final Set a(p6.e eVar) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        if (eVar instanceof InterfaceC2625l) {
            return ((InterfaceC2625l) eVar).b();
        }
        HashSet hashSet = new HashSet(eVar.f());
        int iF = eVar.f();
        for (int i7 = 0; i7 < iF; i7++) {
            hashSet.add(eVar.g(i7));
        }
        return hashSet;
    }

    public static final p6.e[] b(List list) {
        p6.e[] eVarArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (eVarArr = (p6.e[]) list.toArray(new p6.e[0])) == null) ? f22862a : eVarArr;
    }
}
