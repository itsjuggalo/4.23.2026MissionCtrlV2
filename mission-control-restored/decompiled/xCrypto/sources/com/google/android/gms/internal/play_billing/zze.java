package com.google.android.gms.internal.play_billing;

import H0.C0309k;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.amazon.a.a.o.b;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class zze {
    public static final int zza = Runtime.getRuntime().availableProcessors();

    public static int zza(Intent intent, String str) {
        if (intent != null) {
            return zzp(intent.getExtras(), "ProxyBillingActivity");
        }
        zzl("ProxyBillingActivity", "Got null intent!");
        return 0;
    }

    public static int zzb(Bundle bundle, String str) {
        if (bundle == null) {
            zzl(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zzk(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        zzl(str, "Unexpected type for bundle response code: ".concat(obj.getClass().getName()));
        return 6;
    }

    public static Bundle zzc(Bundle bundle, String str, long j4) {
        bundle.putString("playBillingLibraryVersion", str);
        bundle.putLong("billingClientSessionId", j4);
        return bundle;
    }

    public static Bundle zzd(boolean z4, boolean z5, boolean z6, boolean z7, String str, long j4) {
        Bundle bundle = new Bundle();
        zzc(bundle, str, j4);
        if (z4 && z6) {
            bundle.putBoolean(b.ac, true);
        }
        if (z5 && z7) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        return bundle;
    }

    public static Bundle zze(String str, long j4) {
        Bundle bundle = new Bundle();
        zzc(bundle, str, j4);
        return bundle;
    }

    public static d zzf(Intent intent, String str) {
        if (intent != null) {
            d.a aVarC = d.c();
            aVarC.c(zzb(intent.getExtras(), str));
            aVarC.b(zzh(intent.getExtras(), str));
            return aVarC.a();
        }
        zzl("BillingHelper", "Got null intent!");
        d.a aVarC2 = d.c();
        aVarC2.c(6);
        aVarC2.b("An internal error occurred.");
        return aVarC2.a();
    }

    public static C0309k zzg(Bundle bundle, String str) {
        return bundle == null ? new C0309k(0, null) : new C0309k(zzp(bundle, "BillingClient"), bundle.getString("IN_APP_MESSAGE_PURCHASE_TOKEN"));
    }

    public static String zzh(Bundle bundle, String str) {
        if (bundle == null) {
            zzl(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            zzk(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        zzl(str, "Unexpected type for debug message: ".concat(obj.getClass().getName()));
        return "";
    }

    public static String zzi(int i4) {
        return zzd.zza(i4).toString();
    }

    public static List zzj(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            Purchase purchaseZzq = zzq(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
            if (purchaseZzq == null) {
                zzk("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(purchaseZzq);
            return arrayList;
        }
        zzk("BillingHelper", "Found purchase list of " + stringArrayList.size() + " items");
        for (int i4 = 0; i4 < stringArrayList.size() && i4 < stringArrayList2.size(); i4++) {
            Purchase purchaseZzq2 = zzq(stringArrayList.get(i4), stringArrayList2.get(i4));
            if (purchaseZzq2 != null) {
                arrayList.add(purchaseZzq2);
            }
        }
        return arrayList;
    }

    public static void zzk(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            if (str2.isEmpty()) {
                Log.v(str, str2);
                return;
            }
            int i4 = 40000;
            while (!str2.isEmpty() && i4 > 0) {
                int iMin = Math.min(str2.length(), Math.min(4000, i4));
                Log.v(str, str2.substring(0, iMin));
                str2 = str2.substring(iMin);
                i4 -= iMin;
            }
        }
    }

    public static void zzl(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void zzm(String str, String str2, Throwable th) {
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

    public static Bundle zzn(d dVar, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("RESPONSE_CODE", dVar.b());
        bundle.putString("DEBUG_MESSAGE", dVar.a());
        bundle.putInt("LOG_REASON", i4 - 1);
        return bundle;
    }

    public static Bundle zzo(d dVar, int i4, String str) {
        Bundle bundleZzn = zzn(dVar, 5);
        if (str != null) {
            bundleZzn.putString("ADDITIONAL_LOG_DETAILS", str);
        }
        return bundleZzn;
    }

    private static int zzp(Bundle bundle, String str) {
        if (bundle != null) {
            return bundle.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
        }
        zzl(str, "Unexpected null bundle received!");
        return 0;
    }

    private static Purchase zzq(String str, String str2) {
        if (str == null || str2 == null) {
            zzk("BillingHelper", "Received a null purchase data.");
            return null;
        }
        try {
            return new Purchase(str, str2);
        } catch (JSONException e4) {
            zzl("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e4.toString()));
            return null;
        }
    }
}
