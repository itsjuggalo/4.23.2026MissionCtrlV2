package com.google.firebase.auth;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaij;
import com.google.android.gms.internal.p002firebaseauthapi.zzaip;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.internal.zzcc;

/* JADX INFO: loaded from: classes.dex */
final class zzv implements Continuation<zzaij, Task<TotpSecret>> {
    private final /* synthetic */ FirebaseAuth zza;

    public zzv(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<TotpSecret> then(Task<zzaij> task) {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) AbstractC0940s.k(task.getException()));
        }
        zzaij result = task.getResult();
        if (result instanceof zzaip) {
            zzaip zzaipVar = (zzaip) result;
            return Tasks.forResult(new zzcc(AbstractC0940s.e(zzaipVar.zzf()), AbstractC0940s.e(zzaipVar.zze()), zzaipVar.zzc(), zzaipVar.zzb(), zzaipVar.zzd(), AbstractC0940s.e(zzaipVar.zza()), this.zza));
        }
        throw new IllegalArgumentException("Response should be an instance of StartTotpMfaEnrollmentResponse but was " + result.getClass().getName() + ".");
    }
}
