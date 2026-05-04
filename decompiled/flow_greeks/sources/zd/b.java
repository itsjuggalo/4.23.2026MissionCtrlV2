package zd;

import cd.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    static {
        Object objB;
        try {
            r.a aVar = cd.r.f3870b;
            objB = cd.r.b(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            r.a aVar2 = cd.r.f3870b;
            objB = cd.r.b(cd.s.a(th));
        }
        if (cd.r.h(objB)) {
            objB = Boolean.TRUE;
        }
        Object objB2 = cd.r.b(objB);
        Boolean bool = Boolean.FALSE;
        if (cd.r.g(objB2)) {
            objB2 = bool;
        }
        ((Boolean) objB2).getClass();
    }

    public static final a a(pd.k compute) {
        kotlin.jvm.internal.t.f(compute, "compute");
        return new i(compute);
    }
}
