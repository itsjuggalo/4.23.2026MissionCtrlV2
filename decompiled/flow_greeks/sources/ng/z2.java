package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z2 extends k0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z2 f17201c = new z2();

    @Override // ng.k0
    public void Z(gd.i iVar, Runnable runnable) {
        android.support.v4.media.session.b.a(iVar.get(d3.f17085b));
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // ng.k0
    public boolean a0(gd.i iVar) {
        return false;
    }

    @Override // ng.k0
    public k0 c0(int i10, String str) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // ng.k0
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
