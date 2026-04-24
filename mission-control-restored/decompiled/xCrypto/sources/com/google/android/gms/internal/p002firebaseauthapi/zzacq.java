package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: loaded from: classes.dex */
final class zzacq extends zzaex<Void, zzl> {
    private final MultiFactorAssertion zzu;
    private final String zzv;
    private final String zzw;
    private final String zzx;

    public zzacq(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3) {
        super(2);
        this.zzu = (MultiFactorAssertion) AbstractC0940s.k(multiFactorAssertion);
        this.zzv = AbstractC0940s.e(str);
        this.zzw = str2;
        this.zzx = str3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final String zza() {
        return "finalizeMfaEnrollment";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final void zzb() {
        ((zzl) this.zze).zza(this.zzj, zzach.zza(this.zzc, this.zzk));
        zzb(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final void zza(TaskCompletionSource taskCompletionSource, zzaef zzaefVar) {
        this.zzg = new zzafh(this, taskCompletionSource);
        zzaefVar.zza(this.zzu, this.zzv, this.zzw, this.zzx, this.zzb);
    }
}
