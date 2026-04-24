package com.amazon.device.iap.internal.c;

import com.amazon.device.iap.model.Promotion;
import com.amazon.device.iap.model.PromotionPlan;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class a {
    public static List<Promotion> a(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray(com.amazon.a.a.o.b.f9954q);
        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
            arrayList.add(b(jSONArray.getJSONObject(i7)));
        }
        return arrayList;
    }

    private static Promotion b(JSONObject jSONObject) {
        return new Promotion(jSONObject.getString(com.amazon.a.a.o.b.f9955r), a(jSONObject.getJSONArray(com.amazon.a.a.o.b.f9956s)));
    }

    private static PromotionPlan c(JSONObject jSONObject) throws JSONException {
        String str;
        String string = jSONObject.getString(com.amazon.a.a.o.b.f9957t);
        int i7 = jSONObject.getInt(com.amazon.a.a.o.b.f9958u);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.f9960w);
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject == JSONObject.NULL) {
            str = null;
        } else {
            Currency currency = Currency.getInstance(jSONObjectOptJSONObject.optString(com.amazon.a.a.o.b.f9938a));
            str = currency.getSymbol() + jSONObjectOptJSONObject.optString("value");
        }
        return new PromotionPlan(string, str, i7);
    }

    private static List<PromotionPlan> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
            arrayList.add(c(jSONArray.getJSONObject(i7)));
        }
        return arrayList;
    }
}
