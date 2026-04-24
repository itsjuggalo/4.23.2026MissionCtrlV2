package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PurchaseHistoryRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f10557c;

    public PurchaseHistoryRecord(String str, String str2) {
        this.f10555a = str;
        this.f10556b = str2;
        this.f10557c = new JSONObject(str);
    }

    public String a() {
        return this.f10555a;
    }

    public List b() {
        return g();
    }

    public long c() {
        return this.f10557c.optLong("purchaseTime");
    }

    public String d() {
        JSONObject jSONObject = this.f10557c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String e() {
        return this.f10556b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseHistoryRecord)) {
            return false;
        }
        PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
        return TextUtils.equals(this.f10555a, purchaseHistoryRecord.a()) && TextUtils.equals(this.f10556b, purchaseHistoryRecord.e());
    }

    public ArrayList f() {
        return g();
    }

    public final ArrayList g() {
        ArrayList arrayList = new ArrayList();
        if (this.f10557c.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = this.f10557c.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i7 = 0; i7 < jSONArrayOptJSONArray.length(); i7++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i7));
                }
            }
        } else if (this.f10557c.has("productId")) {
            arrayList.add(this.f10557c.optString("productId"));
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f10555a.hashCode();
    }

    public String toString() {
        return "PurchaseHistoryRecord. Json: ".concat(String.valueOf(this.f10555a));
    }
}
