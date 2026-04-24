package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Purchase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f14668c;

    public Purchase(String str, String str2) {
        this.f14666a = str;
        this.f14667b = str2;
        this.f14668c = new JSONObject(str);
    }

    public String a() {
        String strOptString = this.f14668c.optString("orderId");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    public String b() {
        return this.f14666a;
    }

    public List c() {
        return j();
    }

    public int d() {
        return this.f14668c.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public long e() {
        return this.f14668c.optLong("purchaseTime");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.f14666a, purchase.b()) && TextUtils.equals(this.f14667b, purchase.g());
    }

    public String f() {
        JSONObject jSONObject = this.f14668c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String g() {
        return this.f14667b;
    }

    public boolean h() {
        return this.f14668c.optBoolean("acknowledged", true);
    }

    public int hashCode() {
        return this.f14666a.hashCode();
    }

    public boolean i() {
        return this.f14668c.optBoolean("autoRenewing");
    }

    public final ArrayList j() {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = this.f14668c;
        if (jSONObject.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i8));
                }
            }
        } else if (jSONObject.has("productId")) {
            arrayList.add(jSONObject.optString("productId"));
        }
        return arrayList;
    }

    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.f14666a));
    }
}
