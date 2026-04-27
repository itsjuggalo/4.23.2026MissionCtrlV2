package J3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H3.e[] f905a = new H3.e[0];

    public static final Set a(H3.e eVar) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        if (eVar instanceof InterfaceC0339l) {
            return ((InterfaceC0339l) eVar).b();
        }
        HashSet hashSet = new HashSet(eVar.f());
        int iF = eVar.f();
        for (int i4 = 0; i4 < iF; i4++) {
            hashSet.add(eVar.g(i4));
        }
        return hashSet;
    }

    public static final H3.e[] b(List list) {
        H3.e[] eVarArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (eVarArr = (H3.e[]) list.toArray(new H3.e[0])) == null) ? f905a : eVarArr;
    }
}
