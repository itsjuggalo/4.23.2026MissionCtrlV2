package com.google.android.gms.internal.p002firebaseauthapi;

import W1.q;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzail implements zzaer<zzail> {
    private static final String zza = "zzail";
    private String zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzail zza(String str) throws zzaci {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("phoneResponseInfo");
            if (jSONObjectOptJSONObject != null) {
                this.zzb = q.a(jSONObjectOptJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e7) {
            throw zzajc.zza(e7, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }
}
