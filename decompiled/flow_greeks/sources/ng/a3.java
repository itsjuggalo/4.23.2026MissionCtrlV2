package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a3 extends sg.z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ThreadLocal f17069e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public a3(gd.i iVar, gd.e eVar) {
        b3 b3Var = b3.f17076a;
        super(iVar.get(b3Var) == null ? iVar.plus(b3Var) : iVar, eVar);
        this.f17069e = new ThreadLocal();
        if (eVar.getContext().get(gd.f.K) instanceof k0) {
            return;
        }
        Object objI = sg.k0.i(iVar, null);
        sg.k0.f(iVar, objI);
        P0(iVar, objI);
    }

    @Override // sg.z, ng.a
    public void K0(Object obj) {
        if (this.threadLocalIsSet) {
            cd.q qVar = (cd.q) this.f17069e.get();
            if (qVar != null) {
                sg.k0.f((gd.i) qVar.a(), qVar.b());
            }
            this.f17069e.remove();
        }
        Object objA = e0.a(obj, this.f20435d);
        gd.e eVar = this.f20435d;
        gd.i context = eVar.getContext();
        Object objI = sg.k0.i(context, null);
        a3 a3VarM = objI != sg.k0.f20405a ? i0.m(eVar, context, objI) : null;
        try {
            this.f20435d.resumeWith(objA);
            cd.h0 h0Var = cd.h0.f3852a;
            if (a3VarM == null || a3VarM.O0()) {
                sg.k0.f(context, objI);
            }
        } catch (Throwable th) {
            if (a3VarM == null || a3VarM.O0()) {
                sg.k0.f(context, objI);
            }
            throw th;
        }
    }

    public final boolean O0() {
        boolean z10 = this.threadLocalIsSet && this.f17069e.get() == null;
        this.f17069e.remove();
        return !z10;
    }

    public final void P0(gd.i iVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f17069e.set(cd.w.a(iVar, obj));
    }
}
