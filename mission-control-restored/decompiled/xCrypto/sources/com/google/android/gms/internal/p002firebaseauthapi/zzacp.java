package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* JADX INFO: loaded from: classes.dex */
final class zzacp extends zzaex<AuthResult, zzl> {
    private final MultiFactorAssertion zzu;
    private final String zzv;
    private final String zzw;

    public zzacp(MultiFactorAssertion multiFactorAssertion, String str, String str2) {
        super(2);
        this.zzu = (MultiFactorAssertion) AbstractC0940s.k(multiFactorAssertion);
        this.zzv = AbstractC0940s.e(str);
        this.zzw = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final String zza() {
        return "finalizeMfaSignIn";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final void zzb() {
        zzaf zzafVarZza = zzach.zza(this.zzc, this.zzk);
        FirebaseUser firebaseUser = this.zzd;
        if (firebaseUser != null && !firebaseUser.getUid().equalsIgnoreCase(zzafVarZza.getUid())) {
            zza(new Status(FirebaseError.ERROR_USER_MISMATCH));
        } else {
            ((zzl) this.zze).zza(this.zzj, zzafVarZza);
            zzb(new zzz(zzafVarZza));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final void zza(TaskCompletionSource taskCompletionSource, zzaef zzaefVar) {
        this.zzg = new zzafh(this, taskCompletionSource);
        zzaefVar.zza(this.zzv, this.zzu, this.zzw, this.zzb);
    }
}
