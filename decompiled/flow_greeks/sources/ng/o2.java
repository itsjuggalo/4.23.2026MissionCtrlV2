package ng;

import cd.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o2 extends d2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f17161e;

    public o2(p pVar) {
        this.f17161e = pVar;
    }

    @Override // ng.d2
    public boolean u() {
        return false;
    }

    @Override // ng.d2
    public void v(Throwable th) {
        Object objZ = t().Z();
        if (objZ instanceof c0) {
            p pVar = this.f17161e;
            r.a aVar = cd.r.f3870b;
            pVar.resumeWith(cd.r.b(cd.s.a(((c0) objZ).f17078a)));
        } else {
            p pVar2 = this.f17161e;
            r.a aVar2 = cd.r.f3870b;
            pVar2.resumeWith(cd.r.b(f2.h(objZ)));
        }
    }
}
