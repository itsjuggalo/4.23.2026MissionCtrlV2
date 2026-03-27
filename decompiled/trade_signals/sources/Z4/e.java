package Z4;

import java.util.concurrent.atomic.AtomicReference;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends AtomicReference implements P4.c, S4.b {
    @Override // P4.c
    public void a() {
        lazySet(W4.b.DISPOSED);
    }

    @Override // P4.c
    public void b(S4.b bVar) {
        W4.b.m(this, bVar);
    }

    @Override // S4.b
    public void dispose() {
        W4.b.a(this);
    }

    @Override // S4.b
    public boolean g() {
        return get() == W4.b.DISPOSED;
    }

    @Override // P4.c
    public void onError(Throwable th) {
        lazySet(W4.b.DISPOSED);
        AbstractC2283a.q(new T4.d(th));
    }
}
