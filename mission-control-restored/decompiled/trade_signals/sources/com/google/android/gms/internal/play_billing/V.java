package com.google.android.gms.internal.play_billing;

import R0.C0830o;
import R0.C0838u;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public abstract class V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f15366a = Runtime.getRuntime().availableProcessors();

    public static int a(Intent intent, String str) {
        if (intent != null) {
            return o(intent.getExtras(), "ProxyBillingActivity");
        }
        m("ProxyBillingActivity", "Got null intent!");
        return 0;
    }

    public static int b(Bundle bundle, String str) {
        String strConcat;
        if (bundle == null) {
            strConcat = "Unexpected null bundle received!";
        } else {
            Object obj = bundle.get("RESPONSE_CODE");
            if (obj == null) {
                l(str, "getResponseCodeFromBundle() got null response code, assuming OK");
                return 0;
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            strConcat = "Unexpected type for bundle response code: ".concat(obj.getClass().getName());
        }
        m(str, strConcat);
        return 6;
    }

    public static Bundle c(Bundle bundle, String str, String str2, long j8) {
        bundle.putString("playBillingLibraryVersion", str);
        if (str2 != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str2);
        }
        bundle.putLong("billingClientSessionId", j8);
        return bundle;
    }

    public static Bundle d(com.android.billingclient.api.a aVar, R2 r22) {
        Bundle bundle = new Bundle();
        bundle.putInt("RESPONSE_CODE", aVar.c());
        bundle.putString("DEBUG_MESSAGE", aVar.a());
        bundle.putInt("LOG_REASON", r22.zza());
        return bundle;
    }

    public static Bundle e(com.android.billingclient.api.a aVar, R2 r22, String str) {
        Bundle bundleD = d(aVar, r22);
        if (str != null) {
            bundleD.putString("ADDITIONAL_LOG_DETAILS", str);
        }
        return bundleD;
    }

    public static Bundle f(String str, String str2, ArrayList arrayList, String str3, String str4, C1306a c1306a, long j8) {
        Bundle bundle = new Bundle();
        c(bundle, str, str2, j8);
        bundle.putBoolean(com.amazon.a.a.o.b.ac, true);
        bundle.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_MULTIPLE_OFFERS", new ArrayList<>(N.K("subs", "inapp")));
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_RENT_OFFERS", new ArrayList<>(N.J("inapp")));
        bundle.putBoolean("SHOULD_RETURN_UNFETCHED_PRODUCTS", true);
        if (c1306a.f15390a) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        int size = arrayList.size();
        boolean z7 = false;
        boolean z8 = false;
        for (int i8 = 0; i8 < size; i8++) {
            C0838u.b bVar = (C0838u.b) arrayList.get(i8);
            arrayList2.add(null);
            z7 |= !TextUtils.isEmpty(null);
            arrayList4.add(null);
            z8 |= !TextUtils.isEmpty(null);
            if (bVar.c().equals("first_party")) {
                A.c(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                arrayList3.add(null);
            }
        }
        if (z7) {
            bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList3);
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("accountName", null);
        }
        if (z8) {
            bundle.putStringArrayList("SKU_DYNAMIC_PRODUCT_TOKEN_LIST", arrayList4);
        }
        return bundle;
    }

    public static com.android.billingclient.api.a g(Intent intent, String str) {
        if (intent != null) {
            a.C0247a c0247aD = com.android.billingclient.api.a.d();
            c0247aD.d(b(intent.getExtras(), str));
            c0247aD.b(i(intent.getExtras(), str));
            return c0247aD.a();
        }
        m("BillingHelper", "Got null intent!");
        a.C0247a c0247aD2 = com.android.billingclient.api.a.d();
        c0247aD2.d(6);
        c0247aD2.b("An internal error occurred.");
        return c0247aD2.a();
    }

    public static C0830o h(Bundle bundle, String str) {
        return bundle == null ? new C0830o(0, null) : new C0830o(o(bundle, "BillingClient"), bundle.getString("IN_APP_MESSAGE_PURCHASE_TOKEN"));
    }

    public static String i(Bundle bundle, String str) {
        if (bundle == null) {
            m(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            l(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        m(str, "Unexpected type for debug message: ".concat(obj.getClass().getName()));
        return "";
    }

    public static String j(int i8) {
        return EnumC1400t.a(i8).toString();
    }

    public static List k(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            Purchase purchaseP = p(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
            if (purchaseP == null) {
                l("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(purchaseP);
        } else {
            l("BillingHelper", "Found purchase list of " + stringArrayList.size() + " items");
            for (int i8 = 0; i8 < stringArrayList.size() && i8 < stringArrayList2.size(); i8++) {
                Purchase purchaseP2 = p(stringArrayList.get(i8), stringArrayList2.get(i8));
                if (purchaseP2 != null) {
                    arrayList.add(purchaseP2);
                }
            }
        }
        return arrayList;
    }

    public static void l(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            if (str2.isEmpty()) {
                Log.v(str, str2);
                return;
            }
            int i8 = 40000;
            while (!str2.isEmpty() && i8 > 0) {
                int iMin = Math.min(str2.length(), Math.min(4000, i8));
                Log.v(str, str2.substring(0, iMin));
                str2 = str2.substring(iMin);
                i8 -= iMin;
            }
        }
    }

    public static void m(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void n(String str, String str2, Throwable th) {
        try {
            if (Log.isLoggable(str, 5)) {
                if (th == null) {
                    Log.w(str, str2);
                } else {
                    Log.w(str, str2, th);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static int o(Bundle bundle, String str) {
        if (bundle != null) {
            return bundle.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
        }
        m(str, "Unexpected null bundle received!");
        return 0;
    }

    public static Purchase p(String str, String str2) {
        if (str == null || str2 == null) {
            l("BillingHelper", "Received a null purchase data.");
            return null;
        }
        try {
            return new Purchase(str, str2);
        } catch (JSONException e8) {
            m("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e8.toString()));
            return null;
        }
    }
}
