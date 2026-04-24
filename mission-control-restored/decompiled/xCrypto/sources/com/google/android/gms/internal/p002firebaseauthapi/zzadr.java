package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzam;

/* JADX INFO: loaded from: classes.dex */
final class zzadr extends zzaex<zzaij, Void> {
    private final zzaim zzu;

    public zzadr(zzam zzamVar, String str) {
        super(12);
        AbstractC0940s.k(zzamVar);
        this.zzu = zzaim.zza(AbstractC0940s.e(zzamVar.zzb()), str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final String zza() {
        return "startMfaEnrollment";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final void zzb() {
        zzb(this.zzt);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final void zza(TaskCompletionSource taskCompletionSource, zzaef zzaefVar) {
        this.zzg = new zzafh(this, taskCompletionSource);
        zzaefVar.zza(this.zzu, this.zzb);
    }
}
