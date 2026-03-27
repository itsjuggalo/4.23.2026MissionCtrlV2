package com.android.billingclient.api;

import com.android.billingclient.api.f;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public l(JSONObject jSONObject) throws JSONException {
        jSONObject.getString("type");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("balanceThresholds");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i4)));
            }
        }
        new f.d(jSONObject.getJSONArray("pricingPhases"));
    }
}
