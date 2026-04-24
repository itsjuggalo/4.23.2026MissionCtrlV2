package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes.dex */
class ThrottledForwardingExecutor implements Executor {
    private final Semaphore availableSlots;
    private final Executor executor;

    public ThrottledForwardingExecutor(int i4, Executor executor) {
        this.availableSlots = new Semaphore(i4);
        this.executor = executor;
    }

    public static /* synthetic */ void a(ThrottledForwardingExecutor throttledForwardingExecutor, Runnable runnable) {
        throttledForwardingExecutor.getClass();
        runnable.run();
        throttledForwardingExecutor.availableSlots.release();
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        if (!this.availableSlots.tryAcquire()) {
            runnable.run();
            return;
        }
        try {
            this.executor.execute(new Runnable() { // from class: com.google.firebase.firestore.util.p
                @Override // java.lang.Runnable
                public final void run() {
                    ThrottledForwardingExecutor.a(this.f10731a, runnable);
                }
            });
        } catch (RejectedExecutionException unused) {
            runnable.run();
        }
    }
}
