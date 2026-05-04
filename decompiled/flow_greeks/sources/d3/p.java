package d3;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f7732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f7735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f7736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f7737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f7738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f7739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f7740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f7741k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7743b;

        public a(JSONObject jSONObject) {
            this.f7742a = jSONObject.getInt("commitmentPaymentsCount");
            this.f7743b = jSONObject.optInt("subsequentCommitmentPaymentsCount");
        }

        public int a() {
            return this.f7742a;
        }

        public int b() {
            return this.f7743b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f7745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f7746c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f7747d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f7748e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f7749f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List f7750g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Long f7751h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final a f7752i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final d f7753j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final C0143b f7754k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f7755l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final c f7756m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final z1 f7757n;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Integer f7758a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final C0142a f7759b;

            /* JADX INFO: renamed from: d3.p$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class C0142a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final String f7760a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final long f7761b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final String f7762c;

                public C0142a(JSONObject jSONObject) {
                    this.f7760a = jSONObject.optString("formattedDiscountAmount");
                    this.f7761b = jSONObject.optLong("discountAmountMicros");
                    this.f7762c = jSONObject.optString("discountAmountCurrencyCode");
                }
            }

            public a(JSONObject jSONObject) {
                this.f7758a = jSONObject.has("percentageDiscount") ? Integer.valueOf(jSONObject.optInt("percentageDiscount")) : null;
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountAmount");
                this.f7759b = jSONObjectOptJSONObject != null ? new C0142a(jSONObjectOptJSONObject) : null;
            }
        }

        /* JADX INFO: renamed from: d3.p$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0143b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f7763a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f7764b;

            public C0143b(JSONObject jSONObject) {
                this.f7763a = jSONObject.getInt("maximumQuantity");
                this.f7764b = jSONObject.getInt("remainingQuantity");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f7765a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f7766b;

            public c(JSONObject jSONObject) {
                this.f7765a = jSONObject.getString("rentalPeriod");
                String strOptString = jSONObject.optString("rentalExpirationPeriod");
                this.f7766b = true == strOptString.isEmpty() ? null : strOptString;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Long f7767a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Long f7768b;

            public d(JSONObject jSONObject) {
                this.f7767a = jSONObject.has("startTimeMillis") ? Long.valueOf(jSONObject.optLong("startTimeMillis")) : null;
                this.f7768b = jSONObject.has("endTimeMillis") ? Long.valueOf(jSONObject.optLong("endTimeMillis")) : null;
            }
        }

        public b(JSONObject jSONObject) throws JSONException {
            this.f7744a = jSONObject.optString("formattedPrice");
            this.f7745b = jSONObject.optLong("priceAmountMicros");
            this.f7746c = jSONObject.optString("priceCurrencyCode");
            String strOptString = jSONObject.optString("offerIdToken");
            this.f7747d = true == strOptString.isEmpty() ? null : strOptString;
            String strOptString2 = jSONObject.optString("offerId");
            this.f7748e = true == strOptString2.isEmpty() ? null : strOptString2;
            String strOptString3 = jSONObject.optString("purchaseOptionId");
            this.f7749f = true == strOptString3.isEmpty() ? null : strOptString3;
            jSONObject.optInt("offerType");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            this.f7750g = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    this.f7750g.add(jSONArrayOptJSONArray.getString(i10));
                }
            }
            this.f7751h = jSONObject.has("fullPriceMicros") ? Long.valueOf(jSONObject.optLong("fullPriceMicros")) : null;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
            this.f7752i = jSONObjectOptJSONObject == null ? null : new a(jSONObjectOptJSONObject);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
            this.f7753j = jSONObjectOptJSONObject2 == null ? null : new d(jSONObjectOptJSONObject2);
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
            this.f7754k = jSONObjectOptJSONObject3 == null ? null : new C0143b(jSONObjectOptJSONObject3);
            this.f7755l = jSONObject.optString("serializedDocid");
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("preorderDetails");
            if (jSONObjectOptJSONObject4 != null) {
                jSONObjectOptJSONObject4.getLong("preorderReleaseTimeMillis");
                jSONObjectOptJSONObject4.getLong("preorderPresaleEndTimeMillis");
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("rentalDetails");
            this.f7756m = jSONObjectOptJSONObject5 == null ? null : new c(jSONObjectOptJSONObject5);
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("autoPayDetails");
            this.f7757n = jSONObjectOptJSONObject6 != null ? new z1(jSONObjectOptJSONObject6) : null;
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("pricingPhases");
            if (jSONArrayOptJSONArray2 == null) {
                return;
            }
            new d(jSONArrayOptJSONArray2);
        }

        public String a() {
            return this.f7744a;
        }

        public String b() {
            return this.f7747d;
        }

        public long c() {
            return this.f7745b;
        }

        public String d() {
            return this.f7746c;
        }

        public final z1 e() {
            return this.f7757n;
        }

        public final String f() {
            return this.f7755l;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f7770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f7771c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f7772d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f7773e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7774f;

        public c(JSONObject jSONObject) {
            this.f7772d = jSONObject.optString("billingPeriod");
            this.f7771c = jSONObject.optString("priceCurrencyCode");
            this.f7769a = jSONObject.optString("formattedPrice");
            this.f7770b = jSONObject.optLong("priceAmountMicros");
            this.f7774f = jSONObject.optInt("recurrenceMode");
            this.f7773e = jSONObject.optInt("billingCycleCount");
        }

        public int a() {
            return this.f7773e;
        }

        public String b() {
            return this.f7772d;
        }

        public String c() {
            return this.f7769a;
        }

        public long d() {
            return this.f7770b;
        }

        public String e() {
            return this.f7771c;
        }

        public int f() {
            return this.f7774f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f7775a;

        public d(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new c(jSONObjectOptJSONObject));
                    }
                }
            }
            this.f7775a = arrayList;
        }

        public List a() {
            return this.f7775a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f7778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d f7779d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f7780e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f7781f;

        public e(JSONObject jSONObject) throws JSONException {
            this.f7776a = jSONObject.optString("basePlanId");
            String strOptString = jSONObject.optString("offerId");
            this.f7777b = true == strOptString.isEmpty() ? null : strOptString;
            this.f7778c = jSONObject.getString("offerIdToken");
            this.f7779d = new d(jSONObject.getJSONArray("pricingPhases"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            this.f7781f = jSONObjectOptJSONObject != null ? new a(jSONObjectOptJSONObject) : null;
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("transitionPlanDetails");
            if (jSONObjectOptJSONObject2 != null) {
                jSONObjectOptJSONObject2.getString("productId");
                jSONObjectOptJSONObject2.optString(com.amazon.a.a.o.b.S);
                jSONObjectOptJSONObject2.optString("name");
                jSONObjectOptJSONObject2.optString(com.amazon.a.a.o.b.f4549c);
                jSONObjectOptJSONObject2.optString("basePlanId");
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("pricingPhase");
                if (jSONObjectOptJSONObject3 != null) {
                    new c(jSONObjectOptJSONObject3);
                }
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            if (jSONArrayOptJSONArray != null) {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i10));
                }
            }
            this.f7780e = arrayList;
        }

        public String a() {
            return this.f7776a;
        }

        public a b() {
            return this.f7781f;
        }

        public String c() {
            return this.f7777b;
        }

        public List d() {
            return this.f7780e;
        }

        public String e() {
            return this.f7778c;
        }

        public d f() {
            return this.f7779d;
        }
    }

    public p(String str) {
        this.f7731a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f7732b = jSONObject;
        String strOptString = jSONObject.optString("productId");
        this.f7733c = strOptString;
        String strOptString2 = jSONObject.optString("type");
        this.f7734d = strOptString2;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if (TextUtils.isEmpty(strOptString2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.f7735e = jSONObject.optString(com.amazon.a.a.o.b.S);
        this.f7736f = jSONObject.optString("name");
        this.f7737g = jSONObject.optString(com.amazon.a.a.o.b.f4549c);
        jSONObject.optString("packageDisplayName");
        jSONObject.optString(com.amazon.a.a.o.b.f4556j);
        this.f7738h = jSONObject.optString("skuDetailsToken");
        this.f7739i = jSONObject.optString("serializedDocid");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                arrayList.add(new e(jSONArrayOptJSONArray.getJSONObject(i10)));
            }
            this.f7740j = arrayList;
        } else {
            this.f7740j = (strOptString2.equals("subs") || strOptString2.equals("play_pass_subs")) ? new ArrayList() : null;
        }
        JSONObject jSONObjectOptJSONObject = this.f7732b.optJSONObject("oneTimePurchaseOfferDetails");
        JSONArray jSONArrayOptJSONArray2 = this.f7732b.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                arrayList2.add(new b(jSONArrayOptJSONArray2.getJSONObject(i11)));
            }
            this.f7741k = arrayList2;
            return;
        }
        if (jSONObjectOptJSONObject == null) {
            this.f7741k = null;
        } else {
            arrayList2.add(new b(jSONObjectOptJSONObject));
            this.f7741k = arrayList2;
        }
    }

    public String a() {
        return this.f7737g;
    }

    public String b() {
        return this.f7736f;
    }

    public b c() {
        List list = this.f7741k;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (b) list.get(0);
    }

    public List d() {
        return this.f7741k;
    }

    public String e() {
        return this.f7733c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return TextUtils.equals(this.f7731a, ((p) obj).f7731a);
        }
        return false;
    }

    public String f() {
        return this.f7734d;
    }

    public List g() {
        return this.f7740j;
    }

    public String h() {
        return this.f7735e;
    }

    public int hashCode() {
        return this.f7731a.hashCode();
    }

    public final String i() {
        return this.f7732b.optString("packageName");
    }

    public final String j() {
        return this.f7738h;
    }

    public String k() {
        return this.f7739i;
    }

    public final List l() {
        return this.f7741k;
    }

    public String toString() {
        List list = this.f7740j;
        return "ProductDetails{jsonString='" + this.f7731a + "', parsedJson=" + this.f7732b.toString() + ", productId='" + this.f7733c + "', productType='" + this.f7734d + "', title='" + this.f7735e + "', productDetailsToken='" + this.f7738h + "', subscriptionOfferDetails=" + String.valueOf(list) + "}";
    }
}
