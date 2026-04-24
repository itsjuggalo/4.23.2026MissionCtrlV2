package com.google.firebase.auth.internal;

import A1.e;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzce {
    private static final Map<String, String> zza;

    static {
        HashMap map = new HashMap();
        zza = map;
        map.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        map.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        map.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        map.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
        map.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }

    public static Status zza(Intent intent) {
        AbstractC0940s.k(intent);
        AbstractC0940s.a(zzb(intent));
        return (Status) e.b(intent, "com.google.firebase.auth.internal.STATUS", Status.CREATOR);
    }

    public static boolean zzb(Intent intent) {
        AbstractC0940s.k(intent);
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }

    public static Status zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("code");
            String string2 = jSONObject.getString(Constants.MESSAGE);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                Map<String, String> map = zza;
                if (map.containsKey(string)) {
                    return zzao.zza(map.get(string) + com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + string2);
                }
            }
            return zzao.zza("WEB_INTERNAL_ERROR:" + str);
        } catch (JSONException e4) {
            return zzao.zza("WEB_INTERNAL_ERROR:" + str + "[ " + e4.getLocalizedMessage() + " ]");
        }
    }

    public static void zza(Intent intent, Status status) {
        e.e(status, intent, "com.google.firebase.auth.internal.STATUS");
    }
}
