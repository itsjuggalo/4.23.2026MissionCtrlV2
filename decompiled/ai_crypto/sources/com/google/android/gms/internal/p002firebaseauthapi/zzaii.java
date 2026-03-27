package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1207s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzaii implements zzaes {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private zzage zzi;

    private zzaii(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.zza = AbstractC1207s.e(str);
        this.zzb = AbstractC1207s.e(str2);
        this.zzc = AbstractC1207s.e(str3);
        this.zze = str4;
        this.zzd = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
    }

    public static zzaii zza(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AbstractC1207s.e(str3);
        return new zzaii("phone", str, str2, str3, str4, str5, str6, str7);
    }

    public final String zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mfaPendingCredential", this.zzb);
        jSONObject.put("mfaEnrollmentId", this.zzc);
        this.zza.hashCode();
        jSONObject.put("mfaProvider", 1);
        if (this.zze != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("phoneNumber", this.zze);
            if (!TextUtils.isEmpty(this.zzf)) {
                jSONObject2.put("recaptchaToken", this.zzf);
            }
            if (!TextUtils.isEmpty(this.zzg)) {
                jSONObject2.put("playIntegrityToken", this.zzg);
            }
            String str = this.zzh;
            if (str != null) {
                zzajc.zza(jSONObject2, "captchaResponse", str);
            } else {
                zzajc.zza(jSONObject2);
            }
            zzage zzageVar = this.zzi;
            if (zzageVar != null) {
                jSONObject2.put("autoRetrievalInfo", zzageVar.zza());
            }
            jSONObject.put("phoneSignInInfo", jSONObject2);
        }
        return jSONObject.toString();
    }

    public final void zza(zzage zzageVar) {
        this.zzi = zzageVar;
    }
}
