package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: loaded from: classes.dex */
final class zzadz extends zzaex<Void, zzl> {
    private final UserProfileChangeRequest zzu;

    public zzadz(UserProfileChangeRequest userProfileChangeRequest) {
        super(2);
        this.zzu = (UserProfileChangeRequest) AbstractC0940s.l(userProfileChangeRequest, "request cannot be null");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final String zza() {
        return "updateProfile";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final void zzb() {
        ((zzl) this.zze).zza(this.zzj, zzach.zza(this.zzc, this.zzk));
        zzb(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final void zza(TaskCompletionSource taskCompletionSource, zzaef zzaefVar) {
        this.zzg = new zzafh(this, taskCompletionSource);
        zzaefVar.zza(this.zzd.zze(), this.zzu, this.zzb);
    }
}
