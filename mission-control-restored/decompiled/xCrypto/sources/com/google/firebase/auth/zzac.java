package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth.zza;
import com.google.firebase.auth.internal.zzbo;
import com.google.firebase.auth.internal.zzcf;

/* JADX INFO: loaded from: classes.dex */
final class zzac extends zzbo<Void> {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ FirebaseUser zzb;
    private final /* synthetic */ EmailAuthCredential zzc;
    private final /* synthetic */ FirebaseAuth zzd;

    public zzac(FirebaseAuth firebaseAuth, boolean z4, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.zza = z4;
        this.zzb = firebaseUser;
        this.zzc = emailAuthCredential;
        this.zzd = firebaseAuth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzcf] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzcf] */
    @Override // com.google.firebase.auth.internal.zzbo
    public final Task<Void> zza(String str) {
        if (this.zza) {
            if (TextUtils.isEmpty(str)) {
                Log.i("FirebaseAuth", " Email link reauth with empty reCAPTCHA token");
            } else {
                Log.i("FirebaseAuth", "Got reCAPTCHA token for reauth with email link");
            }
            return this.zzd.zze.zza(this.zzd.zza, this.zzb, this.zzc, str, (zzcf) this.zzd.new zza());
        }
        String strZzc = this.zzc.zzc();
        String strZzd = this.zzc.zzd();
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Reauthenticating " + strZzc + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for reauth with " + strZzc);
        }
        return this.zzd.zze.zza(this.zzd.zza, this.zzb, strZzc, AbstractC0940s.e(strZzd), this.zzb.getTenantId(), str, this.zzd.new zza());
    }
}
