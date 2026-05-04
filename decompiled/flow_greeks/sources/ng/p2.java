package ng;

import cd.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p2 extends d2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gd.e f17175e;

    public p2(gd.e eVar) {
        this.f17175e = eVar;
    }

    @Override // ng.d2
    public boolean u() {
        return false;
    }

    @Override // ng.d2
    public void v(Throwable th) {
        gd.e eVar = this.f17175e;
        r.a aVar = cd.r.f3870b;
        eVar.resumeWith(cd.r.b(cd.h0.f3852a));
    }
}
