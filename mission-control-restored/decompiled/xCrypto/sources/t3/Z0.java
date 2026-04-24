package t3;

/* JADX INFO: loaded from: classes3.dex */
public final class Z0 extends y3.B {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ThreadLocal f14973e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public Z0(Z2.i iVar, Z2.e eVar) {
        a1 a1Var = a1.f14979a;
        super(iVar.get(a1Var) == null ? iVar.plus(a1Var) : iVar, eVar);
        this.f14973e = new ThreadLocal();
        if (eVar.getContext().get(Z2.f.f6010J) instanceof I) {
            return;
        }
        Object objC = y3.J.c(iVar, null);
        y3.J.a(iVar, objC);
        P0(iVar, objC);
    }

    @Override // y3.B, t3.AbstractC1802a
    public void K0(Object obj) {
        if (this.threadLocalIsSet) {
            W2.o oVar = (W2.o) this.f14973e.get();
            if (oVar != null) {
                y3.J.a((Z2.i) oVar.a(), oVar.b());
            }
            this.f14973e.remove();
        }
        Object objA = G.a(obj, this.f15953d);
        Z2.e eVar = this.f15953d;
        Z2.i context = eVar.getContext();
        Object objC = y3.J.c(context, null);
        Z0 z0G = objC != y3.J.f15961a ? H.g(eVar, context, objC) : null;
        try {
            this.f15953d.resumeWith(objA);
            W2.E e4 = W2.E.f5463a;
            if (z0G == null || z0G.O0()) {
                y3.J.a(context, objC);
            }
        } catch (Throwable th) {
            if (z0G == null || z0G.O0()) {
                y3.J.a(context, objC);
            }
            throw th;
        }
    }

    public final boolean O0() {
        boolean z4 = this.threadLocalIsSet && this.f14973e.get() == null;
        this.f14973e.remove();
        return !z4;
    }

    public final void P0(Z2.i iVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f14973e.set(W2.t.a(iVar, obj));
    }
}
