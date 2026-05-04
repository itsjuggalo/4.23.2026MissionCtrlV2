package rc;

import cc.o;
import cc.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends o implements lc.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f19811a;

    public f(Object obj) {
        this.f19811a = obj;
    }

    @Override // lc.g, java.util.concurrent.Callable
    public Object call() {
        return this.f19811a;
    }

    @Override // cc.o
    public void k(q qVar) {
        h hVar = new h(qVar, this.f19811a);
        qVar.a(hVar);
        hVar.run();
    }
}
