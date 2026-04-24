package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.AbstractC0940s;
import io.flutter.plugins.firebase.auth.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzaie implements zzaes {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;

    public zzaie(String str) {
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        if (str != null) {
            jSONObject.put(Constants.EMAIL, str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put("password", str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("tenantId", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            zzajc.zza(jSONObject, "captchaResponse", str4);
        } else {
            zzajc.zza(jSONObject);
        }
        String str5 = this.zze;
        if (str5 != null) {
            jSONObject.put(Constants.ID_TOKEN, str5);
        }
        return jSONObject.toString();
    }

    public zzaie(String str, String str2, String str3, String str4, String str5, String str6) {
        this.zza = AbstractC0940s.e(str);
        this.zzb = AbstractC0940s.e(str2);
        this.zzc = str4;
        this.zzd = str5;
        this.zze = str6;
    }
}
