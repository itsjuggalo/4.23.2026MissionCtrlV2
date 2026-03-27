package S1;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class F4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f3952b;

    public F4(C0540b5 c0540b5, AtomicReference atomicReference) {
        this.f3951a = atomicReference;
        Objects.requireNonNull(c0540b5);
        this.f3952b = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f3951a;
        synchronized (atomicReference) {
            try {
                try {
                    C0540b5 c0540b5 = this.f3952b;
                    atomicReference.set(Integer.valueOf(c0540b5.f4245a.w().E(c0540b5.f4245a.L().q(), AbstractC0569f2.f4567e0)));
                } finally {
                    this.f3951a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
