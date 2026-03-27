package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PurchaseHistoryRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f9372c;

    public PurchaseHistoryRecord(String str, String str2) {
        this.f9370a = str;
        this.f9371b = str2;
        this.f9372c = new JSONObject(str);
    }

    public String a() {
        return this.f9370a;
    }

    public List b() {
        return g();
    }

    public long c() {
        return this.f9372c.optLong("purchaseTime");
    }

    public String d() {
        JSONObject jSONObject = this.f9372c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String e() {
        return this.f9371b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseHistoryRecord)) {
            return false;
        }
        PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
        return TextUtils.equals(this.f9370a, purchaseHistoryRecord.a()) && TextUtils.equals(this.f9371b, purchaseHistoryRecord.e());
    }

    public ArrayList f() {
        return g();
    }

    public final ArrayList g() {
        ArrayList arrayList = new ArrayList();
        if (this.f9372c.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = this.f9372c.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i4));
                }
            }
        } else if (this.f9372c.has("productId")) {
            arrayList.add(this.f9372c.optString("productId"));
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f9370a.hashCode();
    }

    public String toString() {
        return "PurchaseHistoryRecord. Json: ".concat(String.valueOf(this.f9370a));
    }
}
