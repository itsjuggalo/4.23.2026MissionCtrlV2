package S1;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class E4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f3922b;

    public E4(C0540b5 c0540b5, AtomicReference atomicReference) {
        this.f3921a = atomicReference;
        Objects.requireNonNull(c0540b5);
        this.f3922b = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f3921a;
        synchronized (atomicReference) {
            try {
                try {
                    C0540b5 c0540b5 = this.f3922b;
                    atomicReference.set(Long.valueOf(c0540b5.f4245a.w().D(c0540b5.f4245a.L().q(), AbstractC0569f2.f4564d0)));
                } finally {
                    this.f3921a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
