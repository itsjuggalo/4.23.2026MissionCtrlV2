package wc;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends AtomicInteger implements lc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f23889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kh.b f23890b;

    public e(kh.b bVar, Object obj) {
        this.f23890b = bVar;
        this.f23889a = obj;
    }

    @Override // kh.c
    public void cancel() {
        lazySet(2);
    }

    @Override // lc.i
    public void clear() {
        lazySet(1);
    }

    @Override // lc.e
    public int h(int i10) {
        return i10 & 1;
    }

    @Override // lc.i
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // lc.i
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // lc.i
    public Object poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.f23889a;
    }

    @Override // kh.c
    public void request(long j10) {
        if (g.l(j10) && compareAndSet(0, 1)) {
            kh.b bVar = this.f23890b;
            bVar.onNext(this.f23889a);
            if (get() != 2) {
                bVar.onComplete();
            }
        }
    }
}
