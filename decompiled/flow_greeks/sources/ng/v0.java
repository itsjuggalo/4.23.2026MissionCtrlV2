package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class v0 extends a implements u0 {
    public v0(gd.i iVar, boolean z10) {
        super(iVar, true, z10);
    }

    public static /* synthetic */ Object O0(v0 v0Var, gd.e eVar) throws Throwable {
        Object objY = v0Var.y(eVar);
        hd.c.f();
        return objY;
    }

    @Override // ng.u0
    public Object await(gd.e eVar) {
        return O0(this, eVar);
    }

    @Override // ng.u0
    public Object getCompleted() {
        return Q();
    }
}
