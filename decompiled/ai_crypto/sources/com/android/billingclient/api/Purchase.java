package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Purchase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f10554c;

    public Purchase(String str, String str2) {
        this.f10552a = str;
        this.f10553b = str2;
        this.f10554c = new JSONObject(str);
    }

    public String a() {
        String strOptString = this.f10554c.optString("orderId");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    public String b() {
        return this.f10552a;
    }

    public List c() {
        return j();
    }

    public int d() {
        return this.f10554c.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public long e() {
        return this.f10554c.optLong("purchaseTime");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.f10552a, purchase.b()) && TextUtils.equals(this.f10553b, purchase.g());
    }

    public String f() {
        JSONObject jSONObject = this.f10554c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String g() {
        return this.f10553b;
    }

    public boolean h() {
        return this.f10554c.optBoolean("acknowledged", true);
    }

    public int hashCode() {
        return this.f10552a.hashCode();
    }

    public boolean i() {
        return this.f10554c.optBoolean("autoRenewing");
    }

    public final ArrayList j() {
        ArrayList arrayList = new ArrayList();
        if (this.f10554c.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = this.f10554c.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i7 = 0; i7 < jSONArrayOptJSONArray.length(); i7++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i7));
                }
            }
        } else if (this.f10554c.has("productId")) {
            arrayList.add(this.f10554c.optString("productId"));
        }
        return arrayList;
    }

    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.f10552a));
    }
}
