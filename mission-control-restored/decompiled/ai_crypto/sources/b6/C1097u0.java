package b6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: b6.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1097u0 extends AbstractC1105y0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f9093f = AtomicIntegerFieldUpdater.newUpdater(C1097u0.class, "_invoked");
    private volatile int _invoked;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Q5.k f9094e;

    public C1097u0(Q5.k kVar) {
        this.f9094e = kVar;
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return E5.E.f1657a;
    }

    @Override // b6.E
    public void s(Throwable th) {
        if (f9093f.compareAndSet(this, 0, 1)) {
            this.f9094e.invoke(th);
        }
    }
}
