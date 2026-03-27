package com.google.android.gms.internal.p002firebaseauthapi;

import io.flutter.plugins.firebase.auth.Constants;
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
            jSONObject.optString(Constants.PROVIDER_ID, null);
            jSONObject.optBoolean("forExistingProvider", false);
            if (jSONObject.has("allProviders")) {
                new zzaio(1, zzajc.zza(jSONObject.optJSONArray("allProviders")));
            } else {
                zzaio.zza();
            }
            this.zzb = zzajc.zza(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException e4) {
            e = e4;
            throw zzajc.zza(e, zza, str);
        } catch (JSONException e5) {
            e = e5;
            throw zzajc.zza(e, zza, str);
        }
    }

    public final List<String> zza() {
        return this.zzb;
    }
}
