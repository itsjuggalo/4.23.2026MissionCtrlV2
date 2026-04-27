package p3;

import h3.InterfaceC1677H;
import org.json.JSONObject;
import p3.C2375d;

/* JADX INFO: loaded from: classes.dex */
public class m implements i {
    public static C2375d.a b(JSONObject jSONObject) {
        return new C2375d.a(jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_anrs", false), jSONObject.optBoolean("collect_build_ids", false));
    }

    public static C2375d.b c(JSONObject jSONObject) {
        return new C2375d.b(jSONObject.optInt("max_custom_exception_events", 8), 4);
    }

    public static long d(InterfaceC1677H interfaceC1677H, long j7, JSONObject jSONObject) {
        return jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : interfaceC1677H.getCurrentTimeMillis() + (j7 * 1000);
    }

    @Override // p3.i
    public C2375d a(InterfaceC1677H interfaceC1677H, JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("settings_version", 0);
        int iOptInt2 = jSONObject.optInt("cache_duration", 3600);
        return new C2375d(d(interfaceC1677H, iOptInt2, jSONObject), jSONObject.has("session") ? c(jSONObject.getJSONObject("session")) : c(new JSONObject()), b(jSONObject.getJSONObject("features")), iOptInt, iOptInt2, jSONObject.optDouble("on_demand_upload_rate_per_minute", 10.0d), jSONObject.optDouble("on_demand_backoff_base", 1.2d), jSONObject.optInt("on_demand_backoff_step_duration_seconds", 60));
    }
}
