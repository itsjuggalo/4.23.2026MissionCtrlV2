package com.google.android.gms.internal.p002firebaseauthapi;

import W1.q;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzagq implements zzaer<zzagq> {
    private static final String zza = "zzagq";
    private String zzb;
    private String zzc;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagq zza(String str) throws zzaci {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = q.a(jSONObject.optString("idToken"));
            this.zzc = q.a(jSONObject.optString("refreshToken"));
            return this;
        } catch (NullPointerException | JSONException e7) {
            throw zzajc.zza(e7, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }
}
