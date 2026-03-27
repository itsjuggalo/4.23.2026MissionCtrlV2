package S1;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: S1.x5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC0715x5 extends AbstractBinderC0641o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f5048b;

    public BinderC0715x5(C0565e6 c0565e6, AtomicReference atomicReference) {
        this.f5047a = atomicReference;
        Objects.requireNonNull(c0565e6);
        this.f5048b = c0565e6;
    }

    @Override // S1.InterfaceC0649p2
    public final void v(K6 k6) {
        AtomicReference atomicReference = this.f5047a;
        synchronized (atomicReference) {
            this.f5048b.f4245a.a().w().b("[sgtm] Got upload batches from service. count", Integer.valueOf(k6.f4079a.size()));
            atomicReference.set(k6);
            atomicReference.notifyAll();
        }
    }
}
