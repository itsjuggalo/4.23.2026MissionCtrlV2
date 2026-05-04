package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.s;
import io.flutter.plugins.firebase.auth.Constants;
import m7.f;
import m7.j;
import org.json.JSONException;
import org.json.JSONObject;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class zzagx implements zzafa {
    private static final String zza = "zzagx";
    private final String zzb;
    private final String zzc;
    private final j zzd;
    private final String zze;
    private final String zzf;

    static {
        new a(zzagx.class.getSimpleName(), new String[0]);
    }

    public zzagx(j jVar, String str, String str2) {
        this.zzd = (j) s.k(jVar);
        this.zzb = s.e(jVar.zzc());
        this.zzc = s.e(jVar.zze());
        this.zze = str;
        this.zzf = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafa
    public final String zza() throws JSONException {
        f fVarC = f.c(this.zzc);
        String strA = fVarC != null ? fVarC.a() : null;
        String strD = fVarC != null ? fVarC.d() : null;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.EMAIL, this.zzb);
        if (strA != null) {
            jSONObject.put("oobCode", strA);
        }
        if (strD != null) {
            jSONObject.put("tenantId", strD);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put(Constants.ID_TOKEN, str);
        }
        String str2 = this.zzf;
        if (str2 != null) {
            zzajk.zza(jSONObject, "captchaResp", str2);
        } else {
            zzajk.zza(jSONObject);
        }
        return jSONObject.toString();
    }

    public final j zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzf;
    }
}
