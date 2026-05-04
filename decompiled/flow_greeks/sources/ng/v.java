package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends d2 implements u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f17188e;

    public v(w wVar) {
        this.f17188e = wVar;
    }

    @Override // ng.u
    public boolean a(Throwable th) {
        return t().J(th);
    }

    @Override // ng.u
    public y1 getParent() {
        return t();
    }

    @Override // ng.d2
    public boolean u() {
        return true;
    }

    @Override // ng.d2
    public void v(Throwable th) {
        this.f17188e.C(t());
    }
}
