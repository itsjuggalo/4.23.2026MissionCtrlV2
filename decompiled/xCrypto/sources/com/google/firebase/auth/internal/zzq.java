package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzks;
import com.google.android.gms.internal.p002firebaseauthapi.zzkv;
import com.google.android.gms.internal.p002firebaseauthapi.zzlg;
import com.google.android.gms.internal.p002firebaseauthapi.zzmy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzq {
    private static zzq zza;
    private final String zzb;
    private final zzmy zzc;

    private zzq(Context context, String str, boolean z4) {
        zzmy zzmyVarZza;
        this.zzb = str;
        try {
            zzks.zza();
            zzmy.zza zzaVarZza = new zzmy.zza().zza(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", str)).zza(zzlg.zza);
            zzaVarZza.zza(String.format("android-keystore://firebear_master_key_id.%s", str));
            zzmyVarZza = zzaVarZza.zza();
        } catch (IOException | GeneralSecurityException e4) {
            Log.e("FirebearCryptoHelper", "Exception encountered during crypto setup:\n" + e4.getMessage());
            zzmyVarZza = null;
        }
        this.zzc = zzmyVarZza;
    }

    public static zzq zza(Context context, String str) {
        zzq zzqVar = zza;
        if (zzqVar == null || !com.google.android.gms.internal.p002firebaseauthapi.zzp.zza(zzqVar.zzb, str)) {
            zza = new zzq(context, str, true);
        }
        return zza;
    }

    public final String zza(String str) {
        String str2;
        zzmy zzmyVar = this.zzc;
        if (zzmyVar == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to decrypt payload");
            return null;
        }
        try {
            synchronized (zzmyVar) {
                str2 = new String(((com.google.android.gms.internal.p002firebaseauthapi.zzbh) this.zzc.zza().zza(zzkv.zza(), com.google.android.gms.internal.p002firebaseauthapi.zzbh.class)).zza(Base64.decode(str, 8), null), "UTF-8");
            }
            return str2;
        } catch (UnsupportedEncodingException | GeneralSecurityException e4) {
            Log.e("FirebearCryptoHelper", "Exception encountered while decrypting bytes:\n" + e4.getMessage());
            return null;
        }
    }

    public final String zza() {
        if (this.zzc == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to get Public key");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.google.android.gms.internal.p002firebaseauthapi.zzbx zzbxVarZza = com.google.android.gms.internal.p002firebaseauthapi.zzbg.zza(byteArrayOutputStream);
        try {
            synchronized (this.zzc) {
                this.zzc.zza().zzb().zza(zzbxVarZza);
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e4) {
            Log.e("FirebearCryptoHelper", "Exception encountered when attempting to get Public Key:\n" + e4.getMessage());
            return null;
        }
    }
}
