package com.google.android.gms.internal.p002firebaseauthapi;

import G1.q;
import com.google.firebase.auth.zzal;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzahd implements zzaer<zzahd> {
    private static final String zza = "zzahd";
    private zzahf zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzahd zza(String str) throws zzaci {
        zzahf zzahfVar;
        int i4;
        zzahc zzahcVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("users")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("users");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    zzahfVar = new zzahf(new ArrayList());
                } else {
                    ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                    boolean z4 = false;
                    int i5 = 0;
                    while (i5 < jSONArrayOptJSONArray.length()) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i5);
                        if (jSONObject2 == null) {
                            zzahcVar = new zzahc();
                            i4 = i5;
                        } else {
                            i4 = i5;
                            zzahcVar = new zzahc(q.a(jSONObject2.optString("localId", null)), q.a(jSONObject2.optString(Constants.EMAIL, null)), jSONObject2.optBoolean("emailVerified", z4), q.a(jSONObject2.optString("displayName", null)), q.a(jSONObject2.optString("photoUrl", null)), zzahs.zza(jSONObject2.optJSONArray("providerUserInfo")), q.a(jSONObject2.optString("rawPassword", null)), q.a(jSONObject2.optString("phoneNumber", null)), jSONObject2.optLong("createdAt", 0L), jSONObject2.optLong("lastLoginAt", 0L), false, null, zzahq.zza(jSONObject2.optJSONArray("mfaInfo")), zzal.zza(jSONObject2.optJSONArray("passkeyInfo")));
                        }
                        arrayList.add(zzahcVar);
                        i5 = i4 + 1;
                        z4 = false;
                    }
                    zzahfVar = new zzahf(arrayList);
                }
            } else {
                zzahfVar = new zzahf();
            }
            this.zzb = zzahfVar;
            return this;
        } catch (NullPointerException e4) {
            e = e4;
            throw zzajc.zza(e, zza, str);
        } catch (JSONException e5) {
            e = e5;
            throw zzajc.zza(e, zza, str);
        }
    }

    public final List<zzahc> zza() {
        return this.zzb.zza();
    }
}
