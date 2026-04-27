package i5;

/* JADX INFO: renamed from: i5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1929c extends AbstractC1927a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x7.b f18805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f18806b;

    public AbstractC1929c(x7.b bVar) {
        this.f18805a = bVar;
    }

    public void cancel() {
        set(4);
        this.f18806b = null;
    }

    @Override // Y4.j
    public final void clear() {
        lazySet(32);
        this.f18806b = null;
    }

    public final void f(Object obj) {
        int i8 = get();
        while (i8 != 8) {
            if ((i8 & (-3)) != 0) {
                return;
            }
            if (i8 == 2) {
                lazySet(3);
                x7.b bVar = this.f18805a;
                bVar.c(obj);
                if (get() != 4) {
                    bVar.a();
                    return;
                }
                return;
            }
            this.f18806b = obj;
            if (compareAndSet(0, 1)) {
                return;
            }
            i8 = get();
            if (i8 == 4) {
                this.f18806b = null;
                return;
            }
        }
        this.f18806b = obj;
        lazySet(16);
        x7.b bVar2 = this.f18805a;
        bVar2.c(obj);
        if (get() != 4) {
            bVar2.a();
        }
    }

    @Override // x7.c
    public final void i(long j8) {
        Object obj;
        if (EnumC1933g.n(j8)) {
            do {
                int i8 = get();
                if ((i8 & (-2)) != 0) {
                    return;
                }
                if (i8 == 1) {
                    if (!compareAndSet(1, 3) || (obj = this.f18806b) == null) {
                        return;
                    }
                    this.f18806b = null;
                    x7.b bVar = this.f18805a;
                    bVar.c(obj);
                    if (get() != 4) {
                        bVar.a();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    @Override // Y4.j
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // Y4.f
    public final int k(int i8) {
        if ((i8 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    @Override // Y4.j
    public final Object poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        Object obj = this.f18806b;
        this.f18806b = null;
        return obj;
    }
}
