package com.google.android.gms.internal.p002firebaseauthapi;

import S1.a;
import Z2.C0755f;
import Z2.C0763j;
import com.google.android.gms.common.internal.AbstractC1207s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzagp implements zzaes {
    private static final String zza = "zzagp";
    private final String zzb;
    private final String zzc;
    private final C0763j zzd;
    private final String zze;
    private final String zzf;

    static {
        new a(zzagp.class.getSimpleName(), new String[0]);
    }

    public zzagp(C0763j c0763j, String str, String str2) {
        this.zzd = (C0763j) AbstractC1207s.k(c0763j);
        this.zzb = AbstractC1207s.e(c0763j.zzc());
        this.zzc = AbstractC1207s.e(c0763j.zze());
        this.zze = str;
        this.zzf = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza() throws JSONException {
        C0755f c0755fC = C0755f.c(this.zzc);
        String strA = c0755fC != null ? c0755fC.a() : null;
        String strD = c0755fC != null ? c0755fC.d() : null;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.zzb);
        if (strA != null) {
            jSONObject.put("oobCode", strA);
        }
        if (strD != null) {
            jSONObject.put("tenantId", strD);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        String str2 = this.zzf;
        if (str2 != null) {
            zzajc.zza(jSONObject, "captchaResp", str2);
        } else {
            zzajc.zza(jSONObject);
        }
        return jSONObject.toString();
    }

    public final C0763j zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzf;
    }
}
