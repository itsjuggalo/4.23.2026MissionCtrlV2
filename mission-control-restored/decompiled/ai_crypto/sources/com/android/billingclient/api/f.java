package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzco;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f10628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f10632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f10633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f10634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f10635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f10636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f10637k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10639b;

        public a(JSONObject jSONObject) {
            this.f10638a = jSONObject.getInt("commitmentPaymentsCount");
            this.f10639b = jSONObject.optInt("subsequentCommitmentPaymentsCount");
        }

        public int a() {
            return this.f10638a;
        }

        public int b() {
            return this.f10639b;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f10641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f10642c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f10643d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f10644e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final l f10645f;

        public b(JSONObject jSONObject) throws JSONException {
            this.f10640a = jSONObject.optString("formattedPrice");
            this.f10641b = jSONObject.optLong("priceAmountMicros");
            this.f10642c = jSONObject.optString("priceCurrencyCode");
            String strOptString = jSONObject.optString("offerIdToken");
            this.f10643d = true == strOptString.isEmpty() ? null : strOptString;
            jSONObject.optString("offerId").isEmpty();
            jSONObject.optString("purchaseOptionId").isEmpty();
            jSONObject.optInt("offerType");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i7 = 0; i7 < jSONArrayOptJSONArray.length(); i7++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i7));
                }
            }
            zzco.zzk(arrayList);
            if (jSONObject.has("fullPriceMicros")) {
                jSONObject.optLong("fullPriceMicros");
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.getInt("percentageDiscount");
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
            if (jSONObjectOptJSONObject2 != null) {
                jSONObjectOptJSONObject2.getLong("startTimeMillis");
                jSONObjectOptJSONObject2.getLong("endTimeMillis");
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
            if (jSONObjectOptJSONObject3 != null) {
                jSONObjectOptJSONObject3.getInt("maximumQuantity");
                jSONObjectOptJSONObject3.getInt("remainingQuantity");
            }
            this.f10644e = jSONObject.optString("serializedDocid");
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("preorderDetails");
            if (jSONObjectOptJSONObject4 != null) {
                jSONObjectOptJSONObject4.getLong("preorderReleaseTimeMillis");
                jSONObjectOptJSONObject4.getLong("preorderPresaleEndTimeMillis");
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("rentalDetails");
            if (jSONObjectOptJSONObject5 != null) {
                jSONObjectOptJSONObject5.getString("rentalPeriod");
                jSONObjectOptJSONObject5.optString("rentalExpirationPeriod").isEmpty();
            }
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("autoPayDetails");
            this.f10645f = jSONObjectOptJSONObject6 != null ? new l(jSONObjectOptJSONObject6) : null;
        }

        public String a() {
            return this.f10640a;
        }

        public long b() {
            return this.f10641b;
        }

        public String c() {
            return this.f10642c;
        }

        public final l d() {
            return this.f10645f;
        }

        public final String e() {
            return this.f10643d;
        }

        public final String f() {
            return this.f10644e;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f10647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f10648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f10649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f10650e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f10651f;

        public c(JSONObject jSONObject) {
            this.f10649d = jSONObject.optString("billingPeriod");
            this.f10648c = jSONObject.optString("priceCurrencyCode");
            this.f10646a = jSONObject.optString("formattedPrice");
            this.f10647b = jSONObject.optLong("priceAmountMicros");
            this.f10651f = jSONObject.optInt("recurrenceMode");
            this.f10650e = jSONObject.optInt("billingCycleCount");
        }

        public int a() {
            return this.f10650e;
        }

        public String b() {
            return this.f10649d;
        }

        public String c() {
            return this.f10646a;
        }

        public long d() {
            return this.f10647b;
        }

        public String e() {
            return this.f10648c;
        }

        public int f() {
            return this.f10651f;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f10652a;

        public d(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i7);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new c(jSONObjectOptJSONObject));
                    }
                }
            }
            this.f10652a = arrayList;
        }

        public List a() {
            return this.f10652a;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f10655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d f10656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f10657e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f10658f;

        public e(JSONObject jSONObject) throws JSONException {
            this.f10653a = jSONObject.optString("basePlanId");
            String strOptString = jSONObject.optString("offerId");
            this.f10654b = true == strOptString.isEmpty() ? null : strOptString;
            this.f10655c = jSONObject.getString("offerIdToken");
            this.f10656d = new d(jSONObject.getJSONArray("pricingPhases"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            this.f10658f = jSONObjectOptJSONObject != null ? new a(jSONObjectOptJSONObject) : null;
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("transitionPlanDetails");
            if (jSONObjectOptJSONObject2 != null) {
                jSONObjectOptJSONObject2.getString("productId");
                jSONObjectOptJSONObject2.optString(com.amazon.a.a.o.b.f9930S);
                jSONObjectOptJSONObject2.optString("name");
                jSONObjectOptJSONObject2.optString(com.amazon.a.a.o.b.f9940c);
                jSONObjectOptJSONObject2.optString("basePlanId");
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("pricingPhase");
                if (jSONObjectOptJSONObject3 != null) {
                    new c(jSONObjectOptJSONObject3);
                }
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            if (jSONArrayOptJSONArray != null) {
                for (int i7 = 0; i7 < jSONArrayOptJSONArray.length(); i7++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i7));
                }
            }
            this.f10657e = arrayList;
        }

        public String a() {
            return this.f10653a;
        }

        public a b() {
            return this.f10658f;
        }

        public String c() {
            return this.f10654b;
        }

        public List d() {
            return this.f10657e;
        }

        public String e() {
            return this.f10655c;
        }

        public d f() {
            return this.f10656d;
        }
    }

    public f(String str) {
        this.f10627a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f10628b = jSONObject;
        String strOptString = jSONObject.optString("productId");
        this.f10629c = strOptString;
        String strOptString2 = jSONObject.optString("type");
        this.f10630d = strOptString2;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if (TextUtils.isEmpty(strOptString2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.f10631e = jSONObject.optString(com.amazon.a.a.o.b.f9930S);
        this.f10632f = jSONObject.optString("name");
        this.f10633g = jSONObject.optString(com.amazon.a.a.o.b.f9940c);
        jSONObject.optString("packageDisplayName");
        jSONObject.optString(com.amazon.a.a.o.b.f9947j);
        this.f10634h = jSONObject.optString("skuDetailsToken");
        this.f10635i = jSONObject.optString("serializedDocid");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < jSONArrayOptJSONArray.length(); i7++) {
                arrayList.add(new e(jSONArrayOptJSONArray.getJSONObject(i7)));
            }
            this.f10636j = arrayList;
        } else {
            this.f10636j = (strOptString2.equals("subs") || strOptString2.equals("play_pass_subs")) ? new ArrayList() : null;
        }
        JSONObject jSONObjectOptJSONObject = this.f10628b.optJSONObject("oneTimePurchaseOfferDetails");
        JSONArray jSONArrayOptJSONArray2 = this.f10628b.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i8 = 0; i8 < jSONArrayOptJSONArray2.length(); i8++) {
                arrayList2.add(new b(jSONArrayOptJSONArray2.getJSONObject(i8)));
            }
            this.f10637k = arrayList2;
            return;
        }
        if (jSONObjectOptJSONObject == null) {
            this.f10637k = null;
        } else {
            arrayList2.add(new b(jSONObjectOptJSONObject));
            this.f10637k = arrayList2;
        }
    }

    public String a() {
        return this.f10633g;
    }

    public String b() {
        return this.f10632f;
    }

    public b c() {
        List list = this.f10637k;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (b) this.f10637k.get(0);
    }

    public String d() {
        return this.f10629c;
    }

    public String e() {
        return this.f10630d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return TextUtils.equals(this.f10627a, ((f) obj).f10627a);
        }
        return false;
    }

    public List f() {
        return this.f10636j;
    }

    public String g() {
        return this.f10631e;
    }

    public final String h() {
        return this.f10628b.optString("packageName");
    }

    public int hashCode() {
        return this.f10627a.hashCode();
    }

    public final String i() {
        return this.f10634h;
    }

    public String j() {
        return this.f10635i;
    }

    public final List k() {
        return this.f10637k;
    }

    public String toString() {
        List list = this.f10636j;
        return "ProductDetails{jsonString='" + this.f10627a + "', parsedJson=" + this.f10628b.toString() + ", productId='" + this.f10629c + "', productType='" + this.f10630d + "', title='" + this.f10631e + "', productDetailsToken='" + this.f10634h + "', subscriptionOfferDetails=" + String.valueOf(list) + "}";
    }
}
