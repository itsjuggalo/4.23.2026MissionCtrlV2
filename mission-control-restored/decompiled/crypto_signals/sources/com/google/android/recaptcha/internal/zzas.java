package com.google.android.recaptcha.internal;

import a5.F;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zzas {
    public static final Task zza(F f6) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(new CancellationTokenSource().getToken());
        f6.invokeOnCompletion(new zzar(taskCompletionSource, f6));
        return taskCompletionSource.getTask();
    }
}
