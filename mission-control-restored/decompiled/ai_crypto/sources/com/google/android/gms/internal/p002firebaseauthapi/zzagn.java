package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzagn implements zzaer<zzagn> {
    private static final String zza = "zzagn";
    private List<String> zzb;

    public zzagn() {
        zzaio.zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagn zza(String str) throws zzaci {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("authUri", null);
            jSONObject.optBoolean("registered", false);
            jSONObject.optString("providerId", null);
            jSONObject.optBoolean("forExistingProvider", false);
            if (jSONObject.has("allProviders")) {
                new zzaio(1, zzajc.zza(jSONObject.optJSONArray("allProviders")));
            } else {
                zzaio.zza();
            }
            this.zzb = zzajc.zza(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException e7) {
            e = e7;
            throw zzajc.zza(e, zza, str);
        } catch (JSONException e8) {
            e = e8;
            throw zzajc.zza(e, zza, str);
        }
    }

    public final List<String> zza() {
        return this.zzb;
    }
}
