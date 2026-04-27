package S1;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class G4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f3970b;

    public G4(C0540b5 c0540b5, AtomicReference atomicReference) {
        this.f3969a = atomicReference;
        Objects.requireNonNull(c0540b5);
        this.f3970b = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f3969a;
        synchronized (atomicReference) {
            try {
                try {
                    C0540b5 c0540b5 = this.f3970b;
                    atomicReference.set(Double.valueOf(c0540b5.f4245a.w().G(c0540b5.f4245a.L().q(), AbstractC0569f2.f4570f0)));
                } finally {
                    this.f3969a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
