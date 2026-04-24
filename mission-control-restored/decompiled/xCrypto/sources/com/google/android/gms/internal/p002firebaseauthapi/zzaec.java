package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

/* JADX INFO: loaded from: classes.dex */
final class zzaec extends zzaex<Void, Void> {
    private final zzahe zzu;

    public zzaec(String str, String str2, ActionCodeSettings actionCodeSettings) {
        super(6);
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(actionCodeSettings);
        this.zzu = zzahe.zza(actionCodeSettings, str, str2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final String zza() {
        return "verifyBeforeUpdateEmail";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final void zzb() {
        zzb(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final void zza(TaskCompletionSource taskCompletionSource, zzaef zzaefVar) {
        this.zzg = new zzafh(this, taskCompletionSource);
        zzaefVar.zzc(this.zzu, this.zzb);
    }
}
