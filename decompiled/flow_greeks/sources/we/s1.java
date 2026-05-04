package we;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import xf.g2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s1 {
    public static final h a(h hVar, Collection superQualifiers, boolean z10, boolean z11, boolean z12) {
        k kVarE;
        boolean z13;
        kotlin.jvm.internal.t.f(hVar, "<this>");
        kotlin.jvm.internal.t.f(superQualifiers, "superQualifiers");
        ArrayList arrayList = new ArrayList();
        Iterator it = superQualifiers.iterator();
        while (it.hasNext()) {
            k kVarB = b((h) it.next());
            if (kVarB != null) {
                arrayList.add(kVarB);
            }
        }
        k kVarE2 = e(dd.a0.N0(arrayList), b(hVar), z10);
        if (kVarE2 == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = superQualifiers.iterator();
            while (it2.hasNext()) {
                k kVarF = ((h) it2.next()).f();
                if (kVarF != null) {
                    arrayList2.add(kVarF);
                }
            }
            kVarE = e(dd.a0.N0(arrayList2), hVar.f(), z10);
        } else {
            kVarE = kVarE2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = superQualifiers.iterator();
        while (it3.hasNext()) {
            i iVarE = ((h) it3.next()).e();
            if (iVarE != null) {
                arrayList3.add(iVarE);
            }
        }
        i iVar = (i) d(dd.a0.N0(arrayList3), i.f23984b, i.f23983a, hVar.e(), z10);
        k kVar = null;
        if (kVarE != null && !z12 && (!z11 || kVarE != k.f23993b)) {
            kVar = kVarE;
        }
        boolean z14 = false;
        if (kVar == k.f23994c) {
            if (!hVar.d()) {
                if (!superQualifiers.isEmpty()) {
                    Iterator it4 = superQualifiers.iterator();
                    while (it4.hasNext()) {
                        if (((h) it4.next()).d()) {
                        }
                    }
                }
                z13 = false;
            }
            z13 = true;
            break;
        }
        z13 = false;
        if (kVar != null && kVarE2 != kVarE) {
            z14 = true;
        }
        return new h(kVar, iVar, z13, z14);
    }

    public static final k b(h hVar) {
        if (hVar.g()) {
            return null;
        }
        return hVar.f();
    }

    public static final boolean c(g2 g2Var, bg.i type) {
        kotlin.jvm.internal.t.f(g2Var, "<this>");
        kotlin.jvm.internal.t.f(type, "type");
        ef.c ENHANCED_NULLABILITY_ANNOTATION = oe.i0.f18002v;
        kotlin.jvm.internal.t.e(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return g2Var.O(type, ENHANCED_NULLABILITY_ANNOTATION);
    }

    public static final Object d(Set set, Object obj, Object obj2, Object obj3, boolean z10) {
        Set setN0;
        if (!z10) {
            if (obj3 != null && (setN0 = dd.a0.N0(dd.v0.m(set, obj3))) != null) {
                set = setN0;
            }
            return dd.a0.w0(set);
        }
        Object obj4 = set.contains(obj) ? obj : set.contains(obj2) ? obj2 : null;
        if (kotlin.jvm.internal.t.b(obj4, obj) && kotlin.jvm.internal.t.b(obj3, obj2)) {
            return null;
        }
        return obj3 == null ? obj4 : obj3;
    }

    public static final k e(Set set, k kVar, boolean z10) {
        k kVar2 = k.f23992a;
        return kVar == kVar2 ? kVar2 : (k) d(set, k.f23994c, k.f23993b, kVar, z10);
    }
}
