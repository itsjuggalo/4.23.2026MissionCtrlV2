package t3;

import a3.AbstractC0787c;

/* JADX INFO: renamed from: t3.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1849y extends E0 implements InterfaceC1847x {
    public C1849y(InterfaceC1846w0 interfaceC1846w0) {
        super(true);
        e0(interfaceC1846w0);
    }

    @Override // t3.InterfaceC1847x
    public boolean G(Throwable th) {
        return j0(new C(th, false, 2, null));
    }

    @Override // t3.InterfaceC1847x
    public boolean K(Object obj) {
        return j0(obj);
    }

    @Override // t3.E0
    public boolean Y() {
        return true;
    }

    @Override // t3.T
    public Object await(Z2.e eVar) throws Throwable {
        Object objZ = z(eVar);
        AbstractC0787c.e();
        return objZ;
    }

    @Override // t3.T
    public Object getCompleted() {
        return T();
    }

    @Override // t3.T
    public B3.c getOnAwait() {
        B3.c cVarX = X();
        kotlin.jvm.internal.r.d(cVarX, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return cVarX;
    }
}
