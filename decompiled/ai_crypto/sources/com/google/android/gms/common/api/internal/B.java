package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class B implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f10877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C f10878b;

    public B(C c7, TaskCompletionSource taskCompletionSource) {
        this.f10878b = c7;
        this.f10877a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        this.f10878b.f10880b.remove(this.f10877a);
    }
}
