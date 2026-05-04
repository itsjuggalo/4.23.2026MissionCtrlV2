package wc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kh.b f23885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f23886b;

    public c(kh.b bVar) {
        this.f23885a = bVar;
    }

    public final void c(Object obj) {
        int i10 = get();
        while (i10 != 8) {
            if ((i10 & (-3)) != 0) {
                return;
            }
            if (i10 == 2) {
                lazySet(3);
                kh.b bVar = this.f23885a;
                bVar.onNext(obj);
                if (get() != 4) {
                    bVar.onComplete();
                    return;
                }
                return;
            }
            this.f23886b = obj;
            if (compareAndSet(0, 1)) {
                return;
            }
            i10 = get();
            if (i10 == 4) {
                this.f23886b = null;
                return;
            }
        }
        this.f23886b = obj;
        lazySet(16);
        kh.b bVar2 = this.f23885a;
        bVar2.onNext(obj);
        if (get() != 4) {
            bVar2.onComplete();
        }
    }

    public void cancel() {
        set(4);
        this.f23886b = null;
    }

    @Override // lc.i
    public final void clear() {
        lazySet(32);
        this.f23886b = null;
    }

    @Override // lc.e
    public final int h(int i10) {
        if ((i10 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    @Override // lc.i
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // lc.i
    public final Object poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        Object obj = this.f23886b;
        this.f23886b = null;
        return obj;
    }

    @Override // kh.c
    public final void request(long j10) {
        Object obj;
        if (g.l(j10)) {
            do {
                int i10 = get();
                if ((i10 & (-2)) != 0) {
                    return;
                }
                if (i10 == 1) {
                    if (!compareAndSet(1, 3) || (obj = this.f23886b) == null) {
                        return;
                    }
                    this.f23886b = null;
                    kh.b bVar = this.f23885a;
                    bVar.onNext(obj);
                    if (get() != 4) {
                        bVar.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }
}
