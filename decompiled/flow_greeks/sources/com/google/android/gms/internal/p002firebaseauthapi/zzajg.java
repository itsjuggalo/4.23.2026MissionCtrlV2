package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.s;
import io.flutter.plugins.firebase.database.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzajg implements zzafa {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzajg() {
    }

    public static zzajg zza(String str, String str2, boolean z10) {
        zzajg zzajgVar = new zzajg();
        zzajgVar.zzb = s.e(str);
        zzajgVar.zzc = s.e(str2);
        zzajgVar.zzf = z10;
        return zzajgVar;
    }

    public static zzajg zzb(String str, String str2, boolean z10) {
        zzajg zzajgVar = new zzajg();
        zzajgVar.zza = s.e(str);
        zzajgVar.zzd = s.e(str2);
        zzajgVar.zzf = z10;
        return zzajgVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafa
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("phoneNumber", this.zza);
            jSONObject.put("temporaryProof", this.zzd);
        } else {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put(Constants.ERROR_CODE, this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put(io.flutter.plugins.firebase.auth.Constants.ID_TOKEN, str);
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
