package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* JADX INFO: loaded from: classes.dex */
final class zzadg extends zzaex<AuthResult, zzl> {
    private final zzaai zzu;

    public zzadg(PhoneAuthCredential phoneAuthCredential, String str) {
        super(2);
        AbstractC0940s.l(phoneAuthCredential, "credential cannot be null");
        this.zzu = new zzaai(phoneAuthCredential.zza(false), str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final String zza() {
        return "reauthenticateWithPhoneCredentialWithData";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final void zzb() {
        zzaf zzafVarZza = zzach.zza(this.zzc, this.zzk);
        if (!this.zzd.getUid().equalsIgnoreCase(zzafVarZza.getUid())) {
            zza(new Status(FirebaseError.ERROR_USER_MISMATCH));
        } else {
            ((zzl) this.zze).zza(this.zzj, zzafVarZza);
            zzb(new zzz(zzafVarZza));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final void zza(TaskCompletionSource taskCompletionSource, zzaef zzaefVar) {
        this.zzg = new zzafh(this, taskCompletionSource);
        zzaefVar.zza(this.zzu, this.zzb);
    }
}
