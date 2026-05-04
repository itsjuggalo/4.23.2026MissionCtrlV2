package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import m7.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzafp<ResultT, CallbackT> implements zzafg<ResultT> {
    private final zzaff<ResultT, CallbackT> zza;
    private final TaskCompletionSource<ResultT> zzb;

    public zzafp(zzaff<ResultT, CallbackT> zzaffVar, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.zza = zzaffVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafg
    public final void zza(ResultT resultt, Status status) {
        s.l(this.zzb, "completion source cannot be null");
        if (status == null) {
            this.zzb.setResult(resultt);
            return;
        }
        zzaff<ResultT, CallbackT> zzaffVar = this.zza;
        if (zzaffVar.zzq != null) {
            TaskCompletionSource<ResultT> taskCompletionSource = this.zzb;
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(zzaffVar.zzc);
            zzaff<ResultT, CallbackT> zzaffVar2 = this.zza;
            taskCompletionSource.setException(zzaen.zza(firebaseAuth, zzaffVar2.zzq, ("reauthenticateWithCredential".equals(zzaffVar2.zza()) || "reauthenticateWithCredentialWithData".equals(this.zza.zza())) ? this.zza.zzd : null));
            return;
        }
        h hVar = zzaffVar.zzn;
        if (hVar != null) {
            this.zzb.setException(zzaen.zza(status, hVar, zzaffVar.zzo, zzaffVar.zzp));
        } else {
            this.zzb.setException(zzaen.zza(status));
        }
    }
}
