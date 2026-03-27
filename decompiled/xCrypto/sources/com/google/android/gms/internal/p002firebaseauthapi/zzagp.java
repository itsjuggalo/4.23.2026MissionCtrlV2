package com.google.android.gms.internal.p002firebaseauthapi;

import C1.a;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.auth.ActionCodeUrl;
import com.google.firebase.auth.EmailAuthCredential;
import io.flutter.plugins.firebase.auth.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzagp implements zzaes {
    private static final String zza = "zzagp";
    private final String zzb;
    private final String zzc;
    private final EmailAuthCredential zzd;
    private final String zze;
    private final String zzf;

    static {
        new a(zzagp.class.getSimpleName(), new String[0]);
    }

    public zzagp(EmailAuthCredential emailAuthCredential, String str, String str2) {
        this.zzd = (EmailAuthCredential) AbstractC0940s.k(emailAuthCredential);
        this.zzb = AbstractC0940s.e(emailAuthCredential.zzc());
        this.zzc = AbstractC0940s.e(emailAuthCredential.zze());
        this.zze = str;
        this.zzf = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza() throws JSONException {
        ActionCodeUrl link = ActionCodeUrl.parseLink(this.zzc);
        String code = link != null ? link.getCode() : null;
        String strZza = link != null ? link.zza() : null;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.EMAIL, this.zzb);
        if (code != null) {
            jSONObject.put("oobCode", code);
        }
        if (strZza != null) {
            jSONObject.put("tenantId", strZza);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put(Constants.ID_TOKEN, str);
        }
        String str2 = this.zzf;
        if (str2 != null) {
            zzajc.zza(jSONObject, "captchaResp", str2);
        } else {
            zzajc.zza(jSONObject);
        }
        return jSONObject.toString();
    }

    public final EmailAuthCredential zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzf;
    }
}
