package t3;

import W2.p;

/* JADX INFO: loaded from: classes3.dex */
public abstract class G {
    public static final Object a(Object obj, Z2.e eVar) {
        if (!(obj instanceof C)) {
            return W2.p.b(obj);
        }
        p.a aVar = W2.p.f5487b;
        return W2.p.b(W2.q.a(((C) obj).f14907a));
    }

    public static final Object b(Object obj, i3.k kVar) {
        Throwable thE = W2.p.e(obj);
        return thE == null ? kVar != null ? new D(obj, kVar) : obj : new C(thE, false, 2, null);
    }

    public static final Object c(Object obj, InterfaceC1830o interfaceC1830o) {
        Throwable thE = W2.p.e(obj);
        return thE == null ? obj : new C(thE, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, i3.k kVar, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            kVar = null;
        }
        return b(obj, kVar);
    }
}
