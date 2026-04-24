package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzahi implements zzaer<zzahi> {
    private static final String zza = "zzahi";
    private List<String> zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzahi zza(String str) throws zzaci {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("authorizedDomains");
            if (jSONArrayOptJSONArray != null) {
                for (int i7 = 0; i7 < jSONArrayOptJSONArray.length(); i7++) {
                    this.zzb.add(jSONArrayOptJSONArray.getString(i7));
                }
            }
            return this;
        } catch (JSONException e7) {
            throw zzajc.zza(e7, zza, str);
        }
    }

    public final List<String> zza() {
        return this.zzb;
    }
}
