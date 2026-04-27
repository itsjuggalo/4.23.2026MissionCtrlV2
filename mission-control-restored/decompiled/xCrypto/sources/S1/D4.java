package S1;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class D4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f3907b;

    public D4(C0540b5 c0540b5, AtomicReference atomicReference) {
        this.f3906a = atomicReference;
        Objects.requireNonNull(c0540b5);
        this.f3907b = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f3906a;
        synchronized (atomicReference) {
            try {
                try {
                    C0540b5 c0540b5 = this.f3907b;
                    atomicReference.set(c0540b5.f4245a.w().C(c0540b5.f4245a.L().q(), AbstractC0569f2.f4561c0));
                } finally {
                    this.f3906a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
