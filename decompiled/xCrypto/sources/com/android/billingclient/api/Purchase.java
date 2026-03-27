package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Purchase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f9369c;

    public Purchase(String str, String str2) {
        this.f9367a = str;
        this.f9368b = str2;
        this.f9369c = new JSONObject(str);
    }

    public String a() {
        String strOptString = this.f9369c.optString("orderId");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    public String b() {
        return this.f9367a;
    }

    public List c() {
        return j();
    }

    public int d() {
        return this.f9369c.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public long e() {
        return this.f9369c.optLong("purchaseTime");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.f9367a, purchase.b()) && TextUtils.equals(this.f9368b, purchase.g());
    }

    public String f() {
        JSONObject jSONObject = this.f9369c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String g() {
        return this.f9368b;
    }

    public boolean h() {
        return this.f9369c.optBoolean("acknowledged", true);
    }

    public int hashCode() {
        return this.f9367a.hashCode();
    }

    public boolean i() {
        return this.f9369c.optBoolean("autoRenewing");
    }

    public final ArrayList j() {
        ArrayList arrayList = new ArrayList();
        if (this.f9369c.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = this.f9369c.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i4));
                }
            }
        } else if (this.f9369c.has("productId")) {
            arrayList.add(this.f9369c.optString("productId"));
        }
        return arrayList;
    }

    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.f9367a));
    }
}
