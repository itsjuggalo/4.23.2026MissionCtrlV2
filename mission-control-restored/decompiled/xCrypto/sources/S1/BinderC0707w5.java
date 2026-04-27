package S1;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: S1.w5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC0707w5 extends AbstractBinderC0617l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5018a;

    public BinderC0707w5(C0565e6 c0565e6, AtomicReference atomicReference) {
        this.f5018a = atomicReference;
        Objects.requireNonNull(c0565e6);
    }

    @Override // S1.InterfaceC0625m2
    public final void zze(List list) {
        AtomicReference atomicReference = this.f5018a;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }
}
