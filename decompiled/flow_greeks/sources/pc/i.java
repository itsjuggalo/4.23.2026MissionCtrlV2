package pc;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends cc.j implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f18524a;

    public i(Callable callable) {
        this.f18524a = callable;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f18524a.call();
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        fc.b bVarB = fc.c.b();
        lVar.a(bVarB);
        if (bVarB.c()) {
            return;
        }
        try {
            Object objCall = this.f18524a.call();
            if (bVarB.c()) {
                return;
            }
            if (objCall == null) {
                lVar.onComplete();
            } else {
                lVar.onSuccess(objCall);
            }
        } catch (Throwable th) {
            gc.b.b(th);
            if (bVarB.c()) {
                yc.a.q(th);
            } else {
                lVar.onError(th);
            }
        }
    }
}
