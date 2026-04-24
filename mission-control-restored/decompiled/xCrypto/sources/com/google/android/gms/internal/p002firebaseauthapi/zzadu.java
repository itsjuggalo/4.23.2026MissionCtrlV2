package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* JADX INFO: loaded from: classes.dex */
final class zzadu extends zzaex<Void, PhoneAuthProvider.OnVerificationStateChangedCallbacks> {
    private final zzaah zzu;

    public zzadu(PhoneMultiFactorInfo phoneMultiFactorInfo, String str, String str2, long j4, boolean z4, boolean z5, String str3, String str4, String str5, boolean z6) {
        super(8);
        AbstractC0940s.k(phoneMultiFactorInfo);
        AbstractC0940s.e(str);
        this.zzu = new zzaah(phoneMultiFactorInfo, str, str2, j4, z4, z5, str3, str4, str5, z6);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final String zza() {
        return "startMfaSignInWithPhoneNumber";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final void zza(TaskCompletionSource taskCompletionSource, zzaef zzaefVar) {
        this.zzg = new zzafh(this, taskCompletionSource);
        zzaefVar.zza(this.zzu, this.zzb);
    }
}
