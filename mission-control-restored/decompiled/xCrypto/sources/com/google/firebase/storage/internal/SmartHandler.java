package com.google.firebase.storage.internal;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.storage.StorageTaskScheduler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class SmartHandler {
    static boolean testMode = false;
    private final Executor executor;

    public SmartHandler(Executor executor) {
        if (executor != null) {
            this.executor = executor;
        } else if (testMode) {
            this.executor = null;
        } else {
            this.executor = StorageTaskScheduler.getInstance().getMainThreadExecutor();
        }
    }

    public void callBack(Runnable runnable) {
        AbstractC0940s.k(runnable);
        Executor executor = this.executor;
        if (executor != null) {
            executor.execute(runnable);
        } else {
            StorageTaskScheduler.getInstance().scheduleCallback(runnable);
        }
    }
}
