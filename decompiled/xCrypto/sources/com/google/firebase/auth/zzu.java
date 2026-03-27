package com.google.firebase.auth;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: loaded from: classes.dex */
final class zzu implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ FirebaseAuth zzb;

    public zzu(FirebaseAuth firebaseAuth, String str) {
        this.zza = str;
        this.zzb = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<GetTokenResult> task) {
        return !task.isSuccessful() ? Tasks.forException((Exception) AbstractC0940s.k(task.getException())) : this.zzb.zze.zza(this.zza, (String) AbstractC0940s.k(task.getResult().getToken()), "apple.com", this.zzb.zzk);
    }
}
