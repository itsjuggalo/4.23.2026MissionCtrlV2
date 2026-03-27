package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0422z implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A f5175b;

    public C0422z(A a6, TaskCompletionSource taskCompletionSource) {
        this.f5175b = a6;
        this.f5174a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        ((Map) this.f5175b.f5070b).remove(this.f5174a);
    }
}
