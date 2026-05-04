package oc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends cc.f implements lc.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17851b;

    public p(Object obj) {
        this.f17851b = obj;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        bVar.b(new wc.e(bVar, this.f17851b));
    }

    @Override // lc.g, java.util.concurrent.Callable
    public Object call() {
        return this.f17851b;
    }
}
