package n7;

import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import io.flutter.plugins.firebase.database.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f16804a;

    static {
        HashMap map = new HashMap();
        f16804a = map;
        map.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        map.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        map.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        map.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
        map.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }

    public static Status a(Intent intent) {
        com.google.android.gms.common.internal.s.k(intent);
        com.google.android.gms.common.internal.s.a(d(intent));
        return (Status) n5.e.b(intent, "com.google.firebase.auth.internal.STATUS", Status.CREATOR);
    }

    public static Status b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(Constants.ERROR_CODE);
            String string2 = jSONObject.getString(Constants.ERROR_MESSAGE);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                Map map = f16804a;
                if (map.containsKey(string)) {
                    return r.a(((String) map.get(string)) + com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + string2);
                }
            }
            return r.a("WEB_INTERNAL_ERROR:" + str);
        } catch (JSONException e10) {
            return r.a("WEB_INTERNAL_ERROR:" + str + "[ " + e10.getLocalizedMessage() + " ]");
        }
    }

    public static void c(Intent intent, Status status) {
        n5.e.e(status, intent, "com.google.firebase.auth.internal.STATUS");
    }

    public static boolean d(Intent intent) {
        com.google.android.gms.common.internal.s.k(intent);
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }
}
