package com.google.firebase.storage;

import N2.C0169s;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f5587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Continuation f5588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CancellationTokenSource f5590d;

    public /* synthetic */ p(s sVar, Continuation continuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource) {
        this.f5587a = sVar;
        this.f5588b = continuation;
        this.f5589c = taskCompletionSource;
        this.f5590d = cancellationTokenSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        Continuation continuation = this.f5588b;
        TaskCompletionSource taskCompletionSource = this.f5589c;
        s sVar = this.f5587a;
        sVar.getClass();
        try {
            Task task2 = (Task) continuation.then(sVar);
            if (taskCompletionSource.getTask().isComplete()) {
                return;
            }
            if (task2 == null) {
                taskCompletionSource.setException(new NullPointerException("Continuation returned null"));
                return;
            }
            task2.addOnSuccessListener(new N2.r(1, taskCompletionSource));
            task2.addOnFailureListener(new C0169s(1, taskCompletionSource));
            task2.addOnCanceledListener(new o(this.f5590d));
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
