package com.google.android.recaptcha.internal;

import b6.T;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zzas {
    public static final Task zza(T t7) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(new CancellationTokenSource().getToken());
        t7.invokeOnCompletion(new zzar(taskCompletionSource, t7));
        return taskCompletionSource.getTask();
    }
}
