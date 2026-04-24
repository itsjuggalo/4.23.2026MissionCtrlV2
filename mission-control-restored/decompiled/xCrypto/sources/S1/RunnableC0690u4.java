package S1;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: S1.u4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0690u4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4969b;

    public RunnableC0690u4(C0540b5 c0540b5, AtomicReference atomicReference) {
        this.f4968a = atomicReference;
        Objects.requireNonNull(c0540b5);
        this.f4969b = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f4968a;
        synchronized (atomicReference) {
            try {
                try {
                    C0540b5 c0540b5 = this.f4969b;
                    atomicReference.set(Boolean.valueOf(c0540b5.f4245a.w().H(c0540b5.f4245a.L().q(), AbstractC0569f2.f4558b0)));
                } finally {
                    this.f4968a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
