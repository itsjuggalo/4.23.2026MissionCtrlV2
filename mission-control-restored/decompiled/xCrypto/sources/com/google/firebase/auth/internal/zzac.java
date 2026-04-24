package com.google.firebase.auth.internal;

import com.google.firebase.auth.FirebaseAuthSettings;

/* JADX INFO: loaded from: classes.dex */
public final class zzac extends FirebaseAuthSettings {
    private String zza;
    private String zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final void forceRecaptchaFlowForTesting(boolean z4) {
        this.zzd = z4;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final void setAppVerificationDisabledForTesting(boolean z4) {
        this.zzc = z4;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final void setAutoRetrievedSmsCodeForPhoneNumber(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return (this.zza == null || this.zzb == null) ? false : true;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
