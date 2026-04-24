package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactorSession;

/* JADX INFO: loaded from: classes.dex */
final class zzai implements Continuation<GetTokenResult, Task<MultiFactorSession>> {
    private final /* synthetic */ zzaj zza;

    public zzai(zzaj zzajVar) {
        this.zza = zzajVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<MultiFactorSession> then(Task<GetTokenResult> task) {
        return !task.isSuccessful() ? Tasks.forException((Exception) AbstractC0940s.k(task.getException())) : Tasks.forResult(zzam.zza(task.getResult().getToken(), this.zza.zza));
    }
}
