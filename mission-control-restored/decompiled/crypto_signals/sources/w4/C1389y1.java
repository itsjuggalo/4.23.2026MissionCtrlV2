package w4;

import java.lang.Thread;

/* JADX INFO: renamed from: w4.y1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1389y1 implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        throw new u4.l0(u4.j0.d(th).g("Uncaught exception in the SynchronizationContext. Re-thrown."));
    }
}
