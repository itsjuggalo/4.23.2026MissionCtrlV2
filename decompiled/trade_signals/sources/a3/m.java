package a3;

import S2.D;
import a3.C1067d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m implements i {
    public static C1067d.a b(JSONObject jSONObject) {
        return new C1067d.a(jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_anrs", false), jSONObject.optBoolean("collect_build_ids", false));
    }

    public static C1067d.b c(JSONObject jSONObject) {
        return new C1067d.b(jSONObject.optInt("max_custom_exception_events", 8), 4);
    }

    public static long d(D d8, long j8, JSONObject jSONObject) {
        return jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : d8.getCurrentTimeMillis() + (j8 * 1000);
    }

    @Override // a3.i
    public C1067d a(D d8, JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("settings_version", 0);
        int iOptInt2 = jSONObject.optInt("cache_duration", 3600);
        return new C1067d(d(d8, iOptInt2, jSONObject), c(jSONObject.has("session") ? jSONObject.getJSONObject("session") : new JSONObject()), b(jSONObject.getJSONObject("features")), iOptInt, iOptInt2, jSONObject.optDouble("on_demand_upload_rate_per_minute", 10.0d), jSONObject.optDouble("on_demand_backoff_base", 1.2d), jSONObject.optInt("on_demand_backoff_step_duration_seconds", 60));
    }
}
