package o7;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o7.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2502e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m7.e[] f22162a = new m7.e[0];

    public static final Set a(m7.e eVar) {
        AbstractC2304t.f(eVar, "<this>");
        if (eVar instanceof InterfaceC2515l) {
            return ((InterfaceC2515l) eVar).b();
        }
        HashSet hashSet = new HashSet(eVar.e());
        int iE = eVar.e();
        for (int i8 = 0; i8 < iE; i8++) {
            hashSet.add(eVar.f(i8));
        }
        return hashSet;
    }

    public static final m7.e[] b(List list) {
        m7.e[] eVarArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (eVarArr = (m7.e[]) list.toArray(new m7.e[0])) == null) ? f22162a : eVarArr;
    }
}
