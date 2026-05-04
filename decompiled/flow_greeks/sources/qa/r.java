package qa;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fa.b f19026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f19027b = Collections.synchronizedMap(new HashMap());

    public r(fa.b bVar) {
        this.f19026a = bVar;
    }

    public void a(String str, com.google.firebase.remoteconfig.internal.b bVar) {
        JSONObject jSONObjectOptJSONObject;
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) this.f19026a.get();
        if (analyticsConnector == null) {
            return;
        }
        JSONObject jSONObjectI = bVar.i();
        if (jSONObjectI.length() < 1) {
            return;
        }
        JSONObject jSONObjectG = bVar.g();
        if (jSONObjectG.length() >= 1 && (jSONObjectOptJSONObject = jSONObjectI.optJSONObject(str)) != null) {
            String strOptString = jSONObjectOptJSONObject.optString("choiceId");
            if (strOptString.isEmpty()) {
                return;
            }
            synchronized (this.f19027b) {
                try {
                    if (strOptString.equals(this.f19027b.get(str))) {
                        return;
                    }
                    this.f19027b.put(str, strOptString);
                    Bundle bundle = new Bundle();
                    bundle.putString("arm_key", str);
                    bundle.putString("arm_value", jSONObjectG.optString(str));
                    bundle.putString("personalization_id", jSONObjectOptJSONObject.optString("personalizationId"));
                    bundle.putInt("arm_index", jSONObjectOptJSONObject.optInt("armIndex", -1));
                    bundle.putString("group", jSONObjectOptJSONObject.optString("group"));
                    analyticsConnector.logEvent("fp", "personalization_assignment", bundle);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_fpid", strOptString);
                    analyticsConnector.logEvent("fp", "_fpc", bundle2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
