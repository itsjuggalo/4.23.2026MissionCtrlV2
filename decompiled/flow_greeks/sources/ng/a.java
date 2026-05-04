package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends e2 implements y1, gd.e, n0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gd.i f17067c;

    public a(gd.i iVar, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            e0((y1) iVar.get(y1.N));
        }
        this.f17067c = iVar.plus(this);
    }

    @Override // ng.e2
    public String I() {
        return r0.a(this) + " was cancelled";
    }

    public void K0(Object obj) {
        x(obj);
    }

    public final void N0(p0 p0Var, Object obj, pd.o oVar) {
        p0Var.b(oVar, obj, this);
    }

    @Override // ng.e2
    public final void d0(Throwable th) {
        m0.a(this.f17067c, th);
    }

    @Override // ng.n0
    public gd.i g() {
        return this.f17067c;
    }

    @Override // gd.e
    public final gd.i getContext() {
        return this.f17067c;
    }

    @Override // ng.e2, ng.y1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // ng.e2
    public String m0() {
        String strG = i0.g(this.f17067c);
        if (strG == null) {
            return super.m0();
        }
        return '\"' + strG + "\":" + super.m0();
    }

    @Override // gd.e
    public final void resumeWith(Object obj) {
        Object objL0 = l0(e0.b(obj));
        if (objL0 == f2.f17125b) {
            return;
        }
        K0(objL0);
    }

    @Override // ng.e2
    public final void t0(Object obj) {
        if (!(obj instanceof c0)) {
            M0(obj);
        } else {
            c0 c0Var = (c0) obj;
            L0(c0Var.f17078a, c0Var.a());
        }
    }

    public void M0(Object obj) {
    }

    public void L0(Throwable th, boolean z10) {
    }
}
