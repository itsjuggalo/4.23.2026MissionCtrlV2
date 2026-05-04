package ng;

import cd.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(gd.e eVar) {
        Object objB;
        if (eVar instanceof sg.h) {
            return ((sg.h) eVar).toString();
        }
        try {
            r.a aVar = cd.r.f3870b;
            objB = cd.r.b(eVar + '@' + b(eVar));
        } catch (Throwable th) {
            r.a aVar2 = cd.r.f3870b;
            objB = cd.r.b(cd.s.a(th));
        }
        if (cd.r.e(objB) != null) {
            objB = eVar.getClass().getName() + '@' + b(eVar);
        }
        return (String) objB;
    }
}
