package t3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: t3.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1842u0 extends AbstractC1850y0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15035f = AtomicIntegerFieldUpdater.newUpdater(C1842u0.class, "_invoked");
    private volatile int _invoked;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i3.k f15036e;

    public C1842u0(i3.k kVar) {
        this.f15036e = kVar;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return W2.E.f5463a;
    }

    @Override // t3.E
    public void q(Throwable th) {
        if (f15035f.compareAndSet(this, 0, 1)) {
            this.f15036e.invoke(th);
        }
    }
}
