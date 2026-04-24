package com.google.android.gms.internal.p002firebaseauthapi;

import W1.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzahs {
    private List<zzaht> zza;

    public zzahs() {
        this.zza = new ArrayList();
    }

    public static zzahs zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzahs(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i7);
            arrayList.add(jSONObject == null ? new zzaht() : new zzaht(q.a(jSONObject.optString("federatedId")), q.a(jSONObject.optString("displayName")), q.a(jSONObject.optString("photoUrl")), q.a(jSONObject.optString("providerId")), null, q.a(jSONObject.optString("phoneNumber")), q.a(jSONObject.optString("email"))));
        }
        return new zzahs(arrayList);
    }

    private zzahs(List<zzaht> list) {
        if (!list.isEmpty()) {
            this.zza = Collections.unmodifiableList(list);
        } else {
            this.zza = Collections.emptyList();
        }
    }

    public final List<zzaht> zza() {
        return this.zza;
    }
}
