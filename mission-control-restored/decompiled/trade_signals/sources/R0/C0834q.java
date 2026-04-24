package R0;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: R0.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0834q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f7020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f7023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f7024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f7025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f7026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f7027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f7028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f7029k;

    /* JADX INFO: renamed from: R0.q$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7031b;

        public a(JSONObject jSONObject) {
            this.f7030a = jSONObject.getInt("commitmentPaymentsCount");
            this.f7031b = jSONObject.optInt("subsequentCommitmentPaymentsCount");
        }

        public int a() {
            return this.f7030a;
        }

        public int b() {
            return this.f7031b;
        }
    }

    /* JADX INFO: renamed from: R0.q$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f7033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f7034c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f7035d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f7036e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f7037f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List f7038g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Long f7039h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final a f7040i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final d f7041j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final C0098b f7042k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f7043l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final c f7044m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final B0 f7045n;

        /* JADX INFO: renamed from: R0.q$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Integer f7046a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final C0097a f7047b;

            /* JADX INFO: renamed from: R0.q$b$a$a, reason: collision with other inner class name */
            public static final class C0097a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final String f7048a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final long f7049b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final String f7050c;

                public C0097a(JSONObject jSONObject) {
                    this.f7048a = jSONObject.optString("formattedDiscountAmount");
                    this.f7049b = jSONObject.optLong("discountAmountMicros");
                    this.f7050c = jSONObject.optString("discountAmountCurrencyCode");
                }
            }

            public a(JSONObject jSONObject) {
                this.f7046a = jSONObject.has("percentageDiscount") ? Integer.valueOf(jSONObject.optInt("percentageDiscount")) : null;
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountAmount");
                this.f7047b = jSONObjectOptJSONObject != null ? new C0097a(jSONObjectOptJSONObject) : null;
            }
        }

        /* JADX INFO: renamed from: R0.q$b$b, reason: collision with other inner class name */
        public static final class C0098b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f7051a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f7052b;

            public C0098b(JSONObject jSONObject) {
                this.f7051a = jSONObject.getInt("maximumQuantity");
                this.f7052b = jSONObject.getInt("remainingQuantity");
            }
        }

        /* JADX INFO: renamed from: R0.q$b$c */
        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f7053a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f7054b;

            public c(JSONObject jSONObject) {
                this.f7053a = jSONObject.getString("rentalPeriod");
                String strOptString = jSONObject.optString("rentalExpirationPeriod");
                this.f7054b = true == strOptString.isEmpty() ? null : strOptString;
            }
        }

        /* JADX INFO: renamed from: R0.q$b$d */
        public static final class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Long f7055a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Long f7056b;

            public d(JSONObject jSONObject) {
                this.f7055a = jSONObject.has("startTimeMillis") ? Long.valueOf(jSONObject.optLong("startTimeMillis")) : null;
                this.f7056b = jSONObject.has("endTimeMillis") ? Long.valueOf(jSONObject.optLong("endTimeMillis")) : null;
            }
        }

        public b(JSONObject jSONObject) throws JSONException {
            this.f7032a = jSONObject.optString("formattedPrice");
            this.f7033b = jSONObject.optLong("priceAmountMicros");
            this.f7034c = jSONObject.optString("priceCurrencyCode");
            String strOptString = jSONObject.optString("offerIdToken");
            this.f7035d = true == strOptString.isEmpty() ? null : strOptString;
            String strOptString2 = jSONObject.optString("offerId");
            this.f7036e = true == strOptString2.isEmpty() ? null : strOptString2;
            String strOptString3 = jSONObject.optString("purchaseOptionId");
            this.f7037f = true == strOptString3.isEmpty() ? null : strOptString3;
            jSONObject.optInt("offerType");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            this.f7038g = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                    this.f7038g.add(jSONArrayOptJSONArray.getString(i8));
                }
            }
            this.f7039h = jSONObject.has("fullPriceMicros") ? Long.valueOf(jSONObject.optLong("fullPriceMicros")) : null;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
            this.f7040i = jSONObjectOptJSONObject == null ? null : new a(jSONObjectOptJSONObject);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
            this.f7041j = jSONObjectOptJSONObject2 == null ? null : new d(jSONObjectOptJSONObject2);
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
            this.f7042k = jSONObjectOptJSONObject3 == null ? null : new C0098b(jSONObjectOptJSONObject3);
            this.f7043l = jSONObject.optString("serializedDocid");
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("preorderDetails");
            if (jSONObjectOptJSONObject4 != null) {
                jSONObjectOptJSONObject4.getLong("preorderReleaseTimeMillis");
                jSONObjectOptJSONObject4.getLong("preorderPresaleEndTimeMillis");
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("rentalDetails");
            this.f7044m = jSONObjectOptJSONObject5 == null ? null : new c(jSONObjectOptJSONObject5);
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("autoPayDetails");
            this.f7045n = jSONObjectOptJSONObject6 != null ? new B0(jSONObjectOptJSONObject6) : null;
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("pricingPhases");
            if (jSONArrayOptJSONArray2 == null) {
                return;
            }
            new d(jSONArrayOptJSONArray2);
        }

        public String a() {
            return this.f7032a;
        }

        public String b() {
            return this.f7035d;
        }

        public long c() {
            return this.f7033b;
        }

        public String d() {
            return this.f7034c;
        }

        public final B0 e() {
            return this.f7045n;
        }

        public final String f() {
            return this.f7043l;
        }
    }

    /* JADX INFO: renamed from: R0.q$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f7058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f7059c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f7060d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f7061e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7062f;

        public c(JSONObject jSONObject) {
            this.f7060d = jSONObject.optString("billingPeriod");
            this.f7059c = jSONObject.optString("priceCurrencyCode");
            this.f7057a = jSONObject.optString("formattedPrice");
            this.f7058b = jSONObject.optLong("priceAmountMicros");
            this.f7062f = jSONObject.optInt("recurrenceMode");
            this.f7061e = jSONObject.optInt("billingCycleCount");
        }

        public int a() {
            return this.f7061e;
        }

        public String b() {
            return this.f7060d;
        }

        public String c() {
            return this.f7057a;
        }

        public long d() {
            return this.f7058b;
        }

        public String e() {
            return this.f7059c;
        }

        public int f() {
            return this.f7062f;
        }
    }

    /* JADX INFO: renamed from: R0.q$d */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f7063a;

        public d(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i8);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new c(jSONObjectOptJSONObject));
                    }
                }
            }
            this.f7063a = arrayList;
        }

        public List a() {
            return this.f7063a;
        }
    }

    /* JADX INFO: renamed from: R0.q$e */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f7066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d f7067d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f7068e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f7069f;

        public e(JSONObject jSONObject) throws JSONException {
            this.f7064a = jSONObject.optString("basePlanId");
            String strOptString = jSONObject.optString("offerId");
            this.f7065b = true == strOptString.isEmpty() ? null : strOptString;
            this.f7066c = jSONObject.getString("offerIdToken");
            this.f7067d = new d(jSONObject.getJSONArray("pricingPhases"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            this.f7069f = jSONObjectOptJSONObject != null ? new a(jSONObjectOptJSONObject) : null;
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("transitionPlanDetails");
            if (jSONObjectOptJSONObject2 != null) {
                jSONObjectOptJSONObject2.getString("productId");
                jSONObjectOptJSONObject2.optString(com.amazon.a.a.o.b.f14041S);
                jSONObjectOptJSONObject2.optString("name");
                jSONObjectOptJSONObject2.optString(com.amazon.a.a.o.b.f14051c);
                jSONObjectOptJSONObject2.optString("basePlanId");
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("pricingPhase");
                if (jSONObjectOptJSONObject3 != null) {
                    new c(jSONObjectOptJSONObject3);
                }
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            if (jSONArrayOptJSONArray != null) {
                for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i8));
                }
            }
            this.f7068e = arrayList;
        }

        public String a() {
            return this.f7064a;
        }

        public a b() {
            return this.f7069f;
        }

        public String c() {
            return this.f7065b;
        }

        public List d() {
            return this.f7068e;
        }

        public String e() {
            return this.f7066c;
        }

        public d f() {
            return this.f7067d;
        }
    }

    public C0834q(String str) {
        this.f7019a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f7020b = jSONObject;
        String strOptString = jSONObject.optString("productId");
        this.f7021c = strOptString;
        String strOptString2 = jSONObject.optString("type");
        this.f7022d = strOptString2;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if (TextUtils.isEmpty(strOptString2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.f7023e = jSONObject.optString(com.amazon.a.a.o.b.f14041S);
        this.f7024f = jSONObject.optString("name");
        this.f7025g = jSONObject.optString(com.amazon.a.a.o.b.f14051c);
        jSONObject.optString("packageDisplayName");
        jSONObject.optString(com.amazon.a.a.o.b.f14058j);
        this.f7026h = jSONObject.optString("skuDetailsToken");
        this.f7027i = jSONObject.optString("serializedDocid");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                arrayList.add(new e(jSONArrayOptJSONArray.getJSONObject(i8)));
            }
            this.f7028j = arrayList;
        } else {
            this.f7028j = (strOptString2.equals("subs") || strOptString2.equals("play_pass_subs")) ? new ArrayList() : null;
        }
        JSONObject jSONObjectOptJSONObject = this.f7020b.optJSONObject("oneTimePurchaseOfferDetails");
        JSONArray jSONArrayOptJSONArray2 = this.f7020b.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i9 = 0; i9 < jSONArrayOptJSONArray2.length(); i9++) {
                arrayList2.add(new b(jSONArrayOptJSONArray2.getJSONObject(i9)));
            }
            this.f7029k = arrayList2;
            return;
        }
        if (jSONObjectOptJSONObject == null) {
            this.f7029k = null;
        } else {
            arrayList2.add(new b(jSONObjectOptJSONObject));
            this.f7029k = arrayList2;
        }
    }

    public String a() {
        return this.f7025g;
    }

    public String b() {
        return this.f7024f;
    }

    public b c() {
        List list = this.f7029k;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (b) list.get(0);
    }

    public List d() {
        return this.f7029k;
    }

    public String e() {
        return this.f7021c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0834q) {
            return TextUtils.equals(this.f7019a, ((C0834q) obj).f7019a);
        }
        return false;
    }

    public String f() {
        return this.f7022d;
    }

    public List g() {
        return this.f7028j;
    }

    public String h() {
        return this.f7023e;
    }

    public int hashCode() {
        return this.f7019a.hashCode();
    }

    public final String i() {
        return this.f7020b.optString("packageName");
    }

    public final String j() {
        return this.f7026h;
    }

    public String k() {
        return this.f7027i;
    }

    public final List l() {
        return this.f7029k;
    }

    public String toString() {
        List list = this.f7028j;
        return "ProductDetails{jsonString='" + this.f7019a + "', parsedJson=" + this.f7020b.toString() + ", productId='" + this.f7021c + "', productType='" + this.f7022d + "', title='" + this.f7023e + "', productDetailsToken='" + this.f7026h + "', subscriptionOfferDetails=" + String.valueOf(list) + "}";
    }
}
