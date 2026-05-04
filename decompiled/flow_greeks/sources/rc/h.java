package rc;

import cc.q;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends AtomicInteger implements lc.d, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f19814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f19815b;

    public h(q qVar, Object obj) {
        this.f19814a = qVar;
        this.f19815b = obj;
    }

    @Override // fc.b
    public boolean c() {
        return get() == 3;
    }

    @Override // lc.i
    public void clear() {
        lazySet(3);
    }

    @Override // fc.b
    public void dispose() {
        set(3);
    }

    @Override // lc.i
    public boolean isEmpty() {
        return get() != 1;
    }

    @Override // lc.i
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // lc.i
    public Object poll() {
        if (get() != 1) {
            return null;
        }
        lazySet(3);
        return this.f19815b;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() == 0 && compareAndSet(0, 2)) {
            this.f19814a.onNext(this.f19815b);
            if (get() == 2) {
                lazySet(3);
                this.f19814a.onComplete();
            }
        }
    }
}
