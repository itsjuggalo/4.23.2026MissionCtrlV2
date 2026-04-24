package com.google.firebase.auth;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
final class zzag implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ FirebaseUser zza;

    public zzag(FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<GetTokenResult> task) {
        return FirebaseAuth.getInstance(this.zza.zza()).zza((ActionCodeSettings) null, (String) AbstractC0940s.k(task.getResult().getToken()));
    }
}
