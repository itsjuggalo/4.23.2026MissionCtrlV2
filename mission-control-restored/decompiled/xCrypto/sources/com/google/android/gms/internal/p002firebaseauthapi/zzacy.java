package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* JADX INFO: loaded from: classes.dex */
final class zzacy extends zzaex<AuthResult, zzl> {
    private final EmailAuthCredential zzu;

    public zzacy(EmailAuthCredential emailAuthCredential) {
        super(2);
        this.zzu = (EmailAuthCredential) AbstractC0940s.l(emailAuthCredential, "credential cannot be null");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final String zza() {
        return "linkEmailAuthCredential";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final void zzb() {
        zzaf zzafVarZza = zzach.zza(this.zzc, this.zzk);
        ((zzl) this.zze).zza(this.zzj, zzafVarZza);
        zzb(new zzz(zzafVarZza));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final void zza(TaskCompletionSource taskCompletionSource, zzaef zzaefVar) {
        this.zzg = new zzafh(this, taskCompletionSource);
        zzaefVar.zza(new zzagp(this.zzu.zza(this.zzd), null, null), this.zzb);
    }
}
