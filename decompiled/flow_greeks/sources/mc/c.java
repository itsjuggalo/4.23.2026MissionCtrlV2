package mc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends AtomicReference implements cc.c, fc.b {
    @Override // cc.c
    public void a(fc.b bVar) {
        jc.b.l(this, bVar);
    }

    @Override // fc.b
    public boolean c() {
        return get() == jc.b.DISPOSED;
    }

    @Override // fc.b
    public void dispose() {
        jc.b.a(this);
    }

    @Override // cc.c
    public void onComplete() {
        lazySet(jc.b.DISPOSED);
    }

    @Override // cc.c
    public void onError(Throwable th) {
        lazySet(jc.b.DISPOSED);
        yc.a.q(new gc.d(th));
    }
}
