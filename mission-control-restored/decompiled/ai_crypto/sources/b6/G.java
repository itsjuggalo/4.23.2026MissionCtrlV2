package b6;

import E5.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class G {
    public static final Object a(Object obj, H5.d dVar) {
        if (!(obj instanceof C1056C)) {
            return E5.p.b(obj);
        }
        p.a aVar = E5.p.f1681b;
        return E5.p.b(E5.q.a(((C1056C) obj).f8965a));
    }

    public static final Object b(Object obj, Q5.k kVar) {
        Throwable thE = E5.p.e(obj);
        return thE == null ? kVar != null ? new D(obj, kVar) : obj : new C1056C(thE, false, 2, null);
    }

    public static final Object c(Object obj, InterfaceC1085o interfaceC1085o) {
        Throwable thE = E5.p.e(obj);
        return thE == null ? obj : new C1056C(thE, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, Q5.k kVar, int i7, Object obj2) {
        if ((i7 & 1) != 0) {
            kVar = null;
        }
        return b(obj, kVar);
    }
}
