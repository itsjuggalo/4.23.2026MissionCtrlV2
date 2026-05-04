package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends e2 implements x {
    public y(y1 y1Var) {
        super(true);
        e0(y1Var);
    }

    @Override // ng.x
    public boolean E(Throwable th) {
        return k0(new c0(th, false, 2, null));
    }

    @Override // ng.x
    public boolean H(Object obj) {
        return k0(obj);
    }

    @Override // ng.e2
    public boolean W() {
        return true;
    }

    @Override // ng.u0
    public Object await(gd.e eVar) throws Throwable {
        Object objY = y(eVar);
        hd.c.f();
        return objY;
    }

    @Override // ng.u0
    public Object getCompleted() {
        return Q();
    }

    @Override // ng.u0
    public vg.c getOnAwait() {
        vg.c cVarV = V();
        kotlin.jvm.internal.t.d(cVarV, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return cVarV;
    }
}
