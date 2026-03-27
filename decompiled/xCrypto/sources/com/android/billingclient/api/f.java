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
    public final String f9442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f9443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f9446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f9447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f9449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f9450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f9451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f9452k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f9454b;

        public a(JSONObject jSONObject) {
            this.f9453a = jSONObject.getInt("commitmentPaymentsCount");
            this.f9454b = jSONObject.optInt("subsequentCommitmentPaymentsCount");
        }

        public int a() {
            return this.f9453a;
        }

        public int b() {
            return this.f9454b;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f9456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f9457c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f9458d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f9459e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final l f9460f;

        public b(JSONObject jSONObject) throws JSONException {
            this.f9455a = jSONObject.optString("formattedPrice");
            this.f9456b = jSONObject.optLong("priceAmountMicros");
            this.f9457c = jSONObject.optString("priceCurrencyCode");
            String strOptString = jSONObject.optString("offerIdToken");
            this.f9458d = true == strOptString.isEmpty() ? null : strOptString;
            jSONObject.optString("offerId").getClass();
            jSONObject.optString("purchaseOptionId").getClass();
            jSONObject.optInt("offerType");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i4));
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
            this.f9459e = jSONObject.optString("serializedDocid");
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("preorderDetails");
            if (jSONObjectOptJSONObject4 != null) {
                jSONObjectOptJSONObject4.getLong("preorderReleaseTimeMillis");
                jSONObjectOptJSONObject4.getLong("preorderPresaleEndTimeMillis");
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("rentalDetails");
            if (jSONObjectOptJSONObject5 != null) {
                jSONObjectOptJSONObject5.getString("rentalPeriod");
                jSONObjectOptJSONObject5.optString("rentalExpirationPeriod").getClass();
            }
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("autoPayDetails");
            this.f9460f = jSONObjectOptJSONObject6 != null ? new l(jSONObjectOptJSONObject6) : null;
        }

        public String a() {
            return this.f9455a;
        }

        public long b() {
            return this.f9456b;
        }

        public String c() {
            return this.f9457c;
        }

        public final l d() {
            return this.f9460f;
        }

        public final String e() {
            return this.f9458d;
        }

        public final String f() {
            return this.f9459e;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f9462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f9463c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f9464d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f9465e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f9466f;

        public c(JSONObject jSONObject) {
            this.f9464d = jSONObject.optString("billingPeriod");
            this.f9463c = jSONObject.optString("priceCurrencyCode");
            this.f9461a = jSONObject.optString("formattedPrice");
            this.f9462b = jSONObject.optLong("priceAmountMicros");
            this.f9466f = jSONObject.optInt("recurrenceMode");
            this.f9465e = jSONObject.optInt("billingCycleCount");
        }

        public int a() {
            return this.f9465e;
        }

        public String b() {
            return this.f9464d;
        }

        public String c() {
            return this.f9461a;
        }

        public long d() {
            return this.f9462b;
        }

        public String e() {
            return this.f9463c;
        }

        public int f() {
            return this.f9466f;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f9467a;

        public d(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i4);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new c(jSONObjectOptJSONObject));
                    }
                }
            }
            this.f9467a = arrayList;
        }

        public List a() {
            return this.f9467a;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f9469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f9470c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d f9471d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f9472e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f9473f;

        public e(JSONObject jSONObject) throws JSONException {
            this.f9468a = jSONObject.optString("basePlanId");
            String strOptString = jSONObject.optString("offerId");
            this.f9469b = true == strOptString.isEmpty() ? null : strOptString;
            this.f9470c = jSONObject.getString("offerIdToken");
            this.f9471d = new d(jSONObject.getJSONArray("pricingPhases"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            this.f9473f = jSONObjectOptJSONObject != null ? new a(jSONObjectOptJSONObject) : null;
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("transitionPlanDetails");
            if (jSONObjectOptJSONObject2 != null) {
                jSONObjectOptJSONObject2.getString("productId");
                jSONObjectOptJSONObject2.optString(com.amazon.a.a.o.b.f8745S);
                jSONObjectOptJSONObject2.optString("name");
                jSONObjectOptJSONObject2.optString(com.amazon.a.a.o.b.f8755c);
                jSONObjectOptJSONObject2.optString("basePlanId");
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("pricingPhase");
                if (jSONObjectOptJSONObject3 != null) {
                    new c(jSONObjectOptJSONObject3);
                }
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            if (jSONArrayOptJSONArray != null) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i4));
                }
            }
            this.f9472e = arrayList;
        }

        public String a() {
            return this.f9468a;
        }

        public a b() {
            return this.f9473f;
        }

        public String c() {
            return this.f9469b;
        }

        public List d() {
            return this.f9472e;
        }

        public String e() {
            return this.f9470c;
        }

        public d f() {
            return this.f9471d;
        }
    }

    public f(String str) {
        this.f9442a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f9443b = jSONObject;
        String strOptString = jSONObject.optString("productId");
        this.f9444c = strOptString;
        String strOptString2 = jSONObject.optString("type");
        this.f9445d = strOptString2;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if (TextUtils.isEmpty(strOptString2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.f9446e = jSONObject.optString(com.amazon.a.a.o.b.f8745S);
        this.f9447f = jSONObject.optString("name");
        this.f9448g = jSONObject.optString(com.amazon.a.a.o.b.f8755c);
        jSONObject.optString("packageDisplayName");
        jSONObject.optString(com.amazon.a.a.o.b.f8762j);
        this.f9449h = jSONObject.optString("skuDetailsToken");
        this.f9450i = jSONObject.optString("serializedDocid");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                arrayList.add(new e(jSONArrayOptJSONArray.getJSONObject(i4)));
            }
            this.f9451j = arrayList;
        } else {
            this.f9451j = (strOptString2.equals("subs") || strOptString2.equals("play_pass_subs")) ? new ArrayList() : null;
        }
        JSONObject jSONObjectOptJSONObject = this.f9443b.optJSONObject("oneTimePurchaseOfferDetails");
        JSONArray jSONArrayOptJSONArray2 = this.f9443b.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray2.length(); i5++) {
                arrayList2.add(new b(jSONArrayOptJSONArray2.getJSONObject(i5)));
            }
            this.f9452k = arrayList2;
            return;
        }
        if (jSONObjectOptJSONObject == null) {
            this.f9452k = null;
        } else {
            arrayList2.add(new b(jSONObjectOptJSONObject));
            this.f9452k = arrayList2;
        }
    }

    public String a() {
        return this.f9448g;
    }

    public String b() {
        return this.f9447f;
    }

    public b c() {
        List list = this.f9452k;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (b) this.f9452k.get(0);
    }

    public String d() {
        return this.f9444c;
    }

    public String e() {
        return this.f9445d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return TextUtils.equals(this.f9442a, ((f) obj).f9442a);
        }
        return false;
    }

    public List f() {
        return this.f9451j;
    }

    public String g() {
        return this.f9446e;
    }

    public final String h() {
        return this.f9443b.optString("packageName");
    }

    public int hashCode() {
        return this.f9442a.hashCode();
    }

    public final String i() {
        return this.f9449h;
    }

    public String j() {
        return this.f9450i;
    }

    public final List k() {
        return this.f9452k;
    }

    public String toString() {
        List list = this.f9451j;
        return "ProductDetails{jsonString='" + this.f9442a + "', parsedJson=" + this.f9443b.toString() + ", productId='" + this.f9444c + "', productType='" + this.f9445d + "', title='" + this.f9446e + "', productDetailsToken='" + this.f9449h + "', subscriptionOfferDetails=" + String.valueOf(list) + "}";
    }
}
