package b6;

import E5.p;
import g6.C1650j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class P {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(H5.d dVar) {
        Object objB;
        if (dVar instanceof C1650j) {
            return dVar.toString();
        }
        try {
            p.a aVar = E5.p.f1681b;
            objB = E5.p.b(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            p.a aVar2 = E5.p.f1681b;
            objB = E5.p.b(E5.q.a(th));
        }
        if (E5.p.e(objB) != null) {
            objB = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) objB;
    }
}
