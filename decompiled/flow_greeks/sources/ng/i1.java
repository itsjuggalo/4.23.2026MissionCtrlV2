package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i1 extends k0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f17140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f17141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public dd.i f17142e;

    public static /* synthetic */ void f0(i1 i1Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        i1Var.e0(z10);
    }

    public static /* synthetic */ void k0(i1 i1Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        i1Var.j0(z10);
    }

    @Override // ng.k0
    public final k0 c0(int i10, String str) {
        sg.l.a(i10);
        return sg.l.b(this, str);
    }

    public final void e0(boolean z10) {
        long jG0 = this.f17140c - g0(z10);
        this.f17140c = jG0;
        if (jG0 <= 0 && this.f17141d) {
            shutdown();
        }
    }

    public final long g0(boolean z10) {
        return z10 ? 4294967296L : 1L;
    }

    public final void h0(z0 z0Var) {
        dd.i iVar = this.f17142e;
        if (iVar == null) {
            iVar = new dd.i();
            this.f17142e = iVar;
        }
        iVar.addLast(z0Var);
    }

    public long i0() {
        dd.i iVar = this.f17142e;
        return (iVar == null || iVar.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void j0(boolean z10) {
        this.f17140c += g0(z10);
        if (z10) {
            return;
        }
        this.f17141d = true;
    }

    public final boolean l0() {
        return this.f17140c >= g0(true);
    }

    public final boolean m0() {
        dd.i iVar = this.f17142e;
        if (iVar != null) {
            return iVar.isEmpty();
        }
        return true;
    }

    public abstract long n0();

    public final boolean o0() {
        z0 z0Var;
        dd.i iVar = this.f17142e;
        if (iVar == null || (z0Var = (z0) iVar.w()) == null) {
            return false;
        }
        z0Var.run();
        return true;
    }

    public boolean p0() {
        return false;
    }

    public abstract void shutdown();
}
