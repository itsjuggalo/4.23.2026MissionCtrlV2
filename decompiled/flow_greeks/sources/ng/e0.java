package ng;

import cd.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e0 {
    public static final Object a(Object obj, gd.e eVar) {
        if (!(obj instanceof c0)) {
            return cd.r.b(obj);
        }
        r.a aVar = cd.r.f3870b;
        return cd.r.b(cd.s.a(((c0) obj).f17078a));
    }

    public static final Object b(Object obj) {
        Throwable thE = cd.r.e(obj);
        return thE == null ? obj : new c0(thE, false, 2, null);
    }

    public static final Object c(Object obj, n nVar) {
        Throwable thE = cd.r.e(obj);
        return thE == null ? obj : new c0(thE, false, 2, null);
    }
}
