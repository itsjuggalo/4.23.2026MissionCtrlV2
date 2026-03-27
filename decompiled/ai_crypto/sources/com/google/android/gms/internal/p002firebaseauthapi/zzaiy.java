package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1207s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzaiy implements zzaes {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzaiy() {
    }

    public static zzaiy zza(String str, String str2, boolean z7) {
        zzaiy zzaiyVar = new zzaiy();
        zzaiyVar.zzb = AbstractC1207s.e(str);
        zzaiyVar.zzc = AbstractC1207s.e(str2);
        zzaiyVar.zzf = z7;
        return zzaiyVar;
    }

    public static zzaiy zzb(String str, String str2, boolean z7) {
        zzaiy zzaiyVar = new zzaiy();
        zzaiyVar.zza = AbstractC1207s.e(str);
        zzaiyVar.zzd = AbstractC1207s.e(str2);
        zzaiyVar.zzf = z7;
        return zzaiyVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("phoneNumber", this.zza);
            jSONObject.put("temporaryProof", this.zzd);
        } else {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put("code", this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    public final void zza(String str) {
        this.zze = str;
    }
}
