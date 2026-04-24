package i6;

import I6.H0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: i6.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1998t0 {
    public static final C1973h a(C1973h c1973h, Collection superQualifiers, boolean z7, boolean z8, boolean z9) {
        EnumC1979k enumC1979kD;
        boolean z10;
        AbstractC2304t.f(c1973h, "<this>");
        AbstractC2304t.f(superQualifiers, "superQualifiers");
        ArrayList arrayList = new ArrayList();
        Iterator it = superQualifiers.iterator();
        while (it.hasNext()) {
            EnumC1979k enumC1979kB = b((C1973h) it.next());
            if (enumC1979kB != null) {
                arrayList.add(enumC1979kB);
            }
        }
        EnumC1979k enumC1979kD2 = d(p5.z.K0(arrayList), b(c1973h), z7);
        if (enumC1979kD2 == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = superQualifiers.iterator();
            while (it2.hasNext()) {
                EnumC1979k enumC1979kF = ((C1973h) it2.next()).f();
                if (enumC1979kF != null) {
                    arrayList2.add(enumC1979kF);
                }
            }
            enumC1979kD = d(p5.z.K0(arrayList2), c1973h.f(), z7);
        } else {
            enumC1979kD = enumC1979kD2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = superQualifiers.iterator();
        while (it3.hasNext()) {
            EnumC1975i enumC1975iE = ((C1973h) it3.next()).e();
            if (enumC1975iE != null) {
                arrayList3.add(enumC1975iE);
            }
        }
        EnumC1975i enumC1975i = (EnumC1975i) e(p5.z.K0(arrayList3), EnumC1975i.f18889b, EnumC1975i.f18888a, c1973h.e(), z7);
        EnumC1979k enumC1979k = null;
        if (enumC1979kD != null && !z9 && (!z8 || enumC1979kD != EnumC1979k.f18896b)) {
            enumC1979k = enumC1979kD;
        }
        boolean z11 = false;
        if (enumC1979k == EnumC1979k.f18897c) {
            if (!c1973h.d()) {
                if (!superQualifiers.isEmpty()) {
                    Iterator it4 = superQualifiers.iterator();
                    while (it4.hasNext()) {
                        if (((C1973h) it4.next()).d()) {
                        }
                    }
                }
                z10 = false;
            }
            z10 = true;
            break;
        }
        z10 = false;
        if (enumC1979k != null && enumC1979kD2 != enumC1979kD) {
            z11 = true;
        }
        return new C1973h(enumC1979k, enumC1975i, z10, z11);
    }

    public static final EnumC1979k b(C1973h c1973h) {
        if (c1973h.g()) {
            return null;
        }
        return c1973h.f();
    }

    public static final boolean c(H0 h02, M6.i type) {
        AbstractC2304t.f(h02, "<this>");
        AbstractC2304t.f(type, "type");
        q6.c ENHANCED_NULLABILITY_ANNOTATION = a6.I.f10046v;
        AbstractC2304t.e(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return h02.p0(type, ENHANCED_NULLABILITY_ANNOTATION);
    }

    public static final EnumC1979k d(Set set, EnumC1979k enumC1979k, boolean z7) {
        EnumC1979k enumC1979k2 = EnumC1979k.f18895a;
        return enumC1979k == enumC1979k2 ? enumC1979k2 : (EnumC1979k) e(set, EnumC1979k.f18897c, EnumC1979k.f18896b, enumC1979k, z7);
    }

    public static final Object e(Set set, Object obj, Object obj2, Object obj3, boolean z7) {
        Set setK0;
        if (!z7) {
            if (obj3 != null && (setK0 = p5.z.K0(p5.T.m(set, obj3))) != null) {
                set = setK0;
            }
            return p5.z.v0(set);
        }
        Object obj4 = set.contains(obj) ? obj : set.contains(obj2) ? obj2 : null;
        if (AbstractC2304t.b(obj4, obj) && AbstractC2304t.b(obj3, obj2)) {
            return null;
        }
        return obj3 == null ? obj4 : obj3;
    }
}
