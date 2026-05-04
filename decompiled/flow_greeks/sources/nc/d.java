package nc;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends cc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f17006a;

    public d(Callable callable) {
        this.f17006a = callable;
    }

    @Override // cc.b
    public void m(cc.c cVar) {
        fc.b bVarB = fc.c.b();
        cVar.a(bVarB);
        try {
            this.f17006a.call();
            if (bVarB.c()) {
                return;
            }
            cVar.onComplete();
        } catch (Throwable th) {
            gc.b.b(th);
            if (bVarB.c()) {
                yc.a.q(th);
            } else {
                cVar.onError(th);
            }
        }
    }
}
