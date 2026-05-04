package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class Purchase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f5137c;

    public Purchase(String str, String str2) {
        this.f5135a = str;
        this.f5136b = str2;
        this.f5137c = new JSONObject(str);
    }

    public String a() {
        String strOptString = this.f5137c.optString("orderId");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    public String b() {
        return this.f5135a;
    }

    public List c() {
        return j();
    }

    public int d() {
        return this.f5137c.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public long e() {
        return this.f5137c.optLong("purchaseTime");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.f5135a, purchase.b()) && TextUtils.equals(this.f5136b, purchase.g());
    }

    public String f() {
        JSONObject jSONObject = this.f5137c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String g() {
        return this.f5136b;
    }

    public boolean h() {
        return this.f5137c.optBoolean("acknowledged", true);
    }

    public int hashCode() {
        return this.f5135a.hashCode();
    }

    public boolean i() {
        return this.f5137c.optBoolean("autoRenewing");
    }

    public final ArrayList j() {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = this.f5137c;
        if (jSONObject.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i10));
                }
            }
        } else if (jSONObject.has("productId")) {
            arrayList.add(jSONObject.optString("productId"));
        }
        return arrayList;
    }

    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.f5135a));
    }
}
