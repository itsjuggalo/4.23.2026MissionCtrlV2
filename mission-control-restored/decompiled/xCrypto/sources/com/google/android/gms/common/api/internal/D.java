package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class D implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f9701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E f9702b;

    public D(E e4, TaskCompletionSource taskCompletionSource) {
        this.f9702b = e4;
        this.f9701a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        this.f9702b.f9704b.remove(this.f9701a);
    }
}
