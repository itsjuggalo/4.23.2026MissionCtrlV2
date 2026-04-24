package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes.dex */
public class BackgroundQueue implements Executor {
    private Semaphore completedTasks = new Semaphore(0);
    private int pendingTaskCount = 0;

    public static /* synthetic */ void a(BackgroundQueue backgroundQueue, Runnable runnable) {
        backgroundQueue.getClass();
        runnable.run();
        backgroundQueue.completedTasks.release();
    }

    public void drain() {
        try {
            this.completedTasks.acquire(this.pendingTaskCount);
            this.pendingTaskCount = 0;
        } catch (InterruptedException e4) {
            Thread.currentThread().interrupt();
            Assert.fail("Interrupted while waiting for background task", e4);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        this.pendingTaskCount++;
        Executors.BACKGROUND_EXECUTOR.execute(new Runnable() { // from class: com.google.firebase.firestore.util.l
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundQueue.a(this.f10727a, runnable);
            }
        });
    }
}
