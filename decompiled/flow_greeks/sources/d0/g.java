package d0;

import d0.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7445m;

    public g(p pVar) {
        super(pVar);
        if (pVar instanceof l) {
            this.f7428e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f7428e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // d0.f
    public void d(int i10) {
        if (this.f7433j) {
            return;
        }
        this.f7433j = true;
        this.f7430g = i10;
        for (d dVar : this.f7434k) {
            dVar.a(dVar);
        }
    }
}
