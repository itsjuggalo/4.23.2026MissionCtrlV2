package pg;

import cd.h0;
import ng.m0;
import pg.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends h implements v {
    public u(gd.i iVar, g gVar) {
        super(iVar, gVar, true, true);
    }

    @Override // ng.a
    public void L0(Throwable th, boolean z10) {
        if (O0().d(th) || z10) {
            return;
        }
        m0.a(getContext(), th);
    }

    @Override // ng.a
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public void M0(h0 h0Var) {
        x.a.a(O0(), null, 1, null);
    }

    @Override // ng.a, ng.e2, ng.y1
    public boolean isActive() {
        return super.isActive();
    }
}
