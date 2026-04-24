package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import t3.T;

/* JADX INFO: loaded from: classes.dex */
public final class zzas {
    public static final Task zza(T t4) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(new CancellationTokenSource().getToken());
        t4.invokeOnCompletion(new zzar(taskCompletionSource, t4));
        return taskCompletionSource.getTask();
    }
}
