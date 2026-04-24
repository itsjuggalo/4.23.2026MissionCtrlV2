package com.google.firebase.storage;

import N2.C0169s;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SuccessContinuation f5591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CancellationTokenSource f5593c;

    public /* synthetic */ q(SuccessContinuation successContinuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource) {
        this.f5591a = successContinuation;
        this.f5592b = taskCompletionSource;
        this.f5593c = cancellationTokenSource;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        SuccessContinuation successContinuation = this.f5591a;
        TaskCompletionSource taskCompletionSource = this.f5592b;
        try {
            Task taskThen = successContinuation.then((r) obj);
            taskThen.addOnSuccessListener(new N2.r(1, taskCompletionSource));
            taskThen.addOnFailureListener(new C0169s(1, taskCompletionSource));
            taskThen.addOnCanceledListener(new o(this.f5593c));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e.getCause());
            } else {
                taskCompletionSource.setException(e);
            }
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }
}
