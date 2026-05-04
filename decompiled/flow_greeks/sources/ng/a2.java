package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class a2 extends e2 implements a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17068c;

    public a2(y1 y1Var) {
        super(true);
        e0(y1Var);
        this.f17068c = K0();
    }

    public final boolean K0() {
        e2 e2VarT;
        u uVarY = Y();
        v vVar = uVarY instanceof v ? (v) uVarY : null;
        if (vVar != null && (e2VarT = vVar.t()) != null) {
            while (!e2VarT.U()) {
                u uVarY2 = e2VarT.Y();
                v vVar2 = uVarY2 instanceof v ? (v) uVarY2 : null;
                if (vVar2 == null || (e2VarT = vVar2.t()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // ng.e2
    public boolean U() {
        return this.f17068c;
    }

    @Override // ng.e2
    public boolean W() {
        return true;
    }
}
