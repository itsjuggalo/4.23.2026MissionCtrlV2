package com.google.android.gms.internal.p002firebaseauthapi;

import io.flutter.plugins.firebase.auth.Constants;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class zzagv implements zzaez<zzagv> {
    private static final String zza = "zzagv";
    private List<String> zzb;

    public zzagv() {
        zzaiw.zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaez
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagv zza(String str) throws zzacn {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("authUri", null);
            jSONObject.optBoolean("registered", false);
            jSONObject.optString(Constants.PROVIDER_ID, null);
            jSONObject.optBoolean("forExistingProvider", false);
            if (jSONObject.has("allProviders")) {
                new zzaiw(1, zzajk.zza(jSONObject.optJSONArray("allProviders")));
            } else {
                zzaiw.zza();
            }
            this.zzb = zzajk.zza(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException e10) {
            e = e10;
            throw zzajk.zza(e, zza, str);
        } catch (JSONException e11) {
            e = e11;
            throw zzajk.zza(e, zza, str);
        }
    }

    public final List<String> zza() {
        return this.zzb;
    }
}
