package g9;

import g9.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class s0 extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j9.k f10364d;

    public s0(j9.q qVar, p.b bVar, bb.d0 d0Var) {
        super(qVar, bVar, d0Var);
        n9.b.d(j9.y.C(d0Var), "KeyFieldFilter expects a ReferenceValue", new Object[0]);
        this.f10364d = j9.k.i(h().t0());
    }

    @Override // g9.p, g9.q
    public boolean d(j9.h hVar) {
        return j(hVar.getKey().compareTo(this.f10364d));
    }
}
