package i5;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: i5.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1931e extends AtomicInteger implements Y4.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x7.b f18810b;

    public C1931e(x7.b bVar, Object obj) {
        this.f18810b = bVar;
        this.f18809a = obj;
    }

    @Override // x7.c
    public void cancel() {
        lazySet(2);
    }

    @Override // Y4.j
    public void clear() {
        lazySet(1);
    }

    @Override // x7.c
    public void i(long j8) {
        if (EnumC1933g.n(j8) && compareAndSet(0, 1)) {
            x7.b bVar = this.f18810b;
            bVar.c(this.f18809a);
            if (get() != 2) {
                bVar.a();
            }
        }
    }

    @Override // Y4.j
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // Y4.f
    public int k(int i8) {
        return i8 & 1;
    }

    @Override // Y4.j
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // Y4.j
    public Object poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.f18809a;
    }
}
