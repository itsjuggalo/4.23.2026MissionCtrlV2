package b6;

/* JADX INFO: renamed from: b6.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1104y extends E0 implements InterfaceC1102x {
    public C1104y(InterfaceC1101w0 interfaceC1101w0) {
        super(true);
        d0(interfaceC1101w0);
    }

    @Override // b6.E0
    public boolean U() {
        return true;
    }

    @Override // b6.InterfaceC1102x
    public boolean V(Throwable th) {
        return j0(new C1056C(th, false, 2, null));
    }

    @Override // b6.InterfaceC1102x
    public boolean X(Object obj) {
        return j0(obj);
    }

    @Override // b6.T
    public Object await(H5.d dVar) throws Throwable {
        Object objW = w(dVar);
        I5.c.e();
        return objW;
    }

    @Override // b6.T
    public Object getCompleted() {
        return P();
    }

    @Override // b6.T
    public j6.c getOnAwait() {
        j6.c cVarT = T();
        kotlin.jvm.internal.r.d(cVarT, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return cVarT;
    }
}
