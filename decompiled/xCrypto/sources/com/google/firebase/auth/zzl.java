package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: loaded from: classes.dex */
final class zzl implements OnCompleteListener<com.google.firebase.auth.internal.zzj> {
    private final /* synthetic */ PhoneAuthOptions zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    public zzl(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zza = phoneAuthOptions;
        this.zzb = str;
        this.zzc = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<com.google.firebase.auth.internal.zzj> task) {
        String strZzd;
        String strZzb;
        String strZzc;
        if (task.isSuccessful()) {
            strZzd = task.getResult().zzd();
            strZzb = task.getResult().zzb();
            strZzc = task.getResult().zzc();
        } else {
            Exception exception = task.getException();
            String str = "Error while validating application identity: ";
            if (exception != null) {
                str = "Error while validating application identity: " + exception.getMessage();
            }
            Log.e("FirebaseAuth", str);
            if (exception != null && com.google.firebase.auth.internal.zzb.zza(exception)) {
                FirebaseAuth.zza((FirebaseException) exception, this.zza, this.zzb);
                return;
            }
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            strZzc = null;
            strZzd = null;
            strZzb = null;
        }
        long jLongValue = this.zza.zzg().longValue();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZza = this.zzc.zza(this.zza.zzh(), this.zza.zze());
        if (TextUtils.isEmpty(strZzd)) {
            onVerificationStateChangedCallbacksZza = this.zzc.zza(this.zza, onVerificationStateChangedCallbacksZza, task.getResult());
        }
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = onVerificationStateChangedCallbacksZza;
        com.google.firebase.auth.internal.zzam zzamVar = (com.google.firebase.auth.internal.zzam) AbstractC0940s.k(this.zza.zzc());
        if (com.google.android.gms.internal.p002firebaseauthapi.zzae.zzc(strZzc) && this.zzc.zzb() != null && this.zzc.zzb().zza("PHONE_PROVIDER")) {
            strZzc = "NO_RECAPTCHA";
        }
        String str2 = strZzc;
        if (zzamVar.zzd()) {
            this.zzc.zze.zza(zzamVar, (String) AbstractC0940s.k(this.zza.zzh()), this.zzc.zzi, jLongValue, this.zza.zzd() != null, this.zza.zzk(), strZzd, strZzb, str2, this.zzc.zzi(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
        } else {
            this.zzc.zze.zza(zzamVar, (PhoneMultiFactorInfo) AbstractC0940s.k(this.zza.zzf()), this.zzc.zzi, jLongValue, this.zza.zzd() != null, this.zza.zzk(), strZzd, strZzb, str2, this.zzc.zzi(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
        }
    }
}
