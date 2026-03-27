package Q2;

import P2.g;
import android.os.Bundle;
import io.flutter.plugins.firebase.analytics.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements b, R2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public R2.a f6724a;

    public static String c(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put(Constants.PARAMETERS, jSONObject2);
        return jSONObject.toString();
    }

    @Override // R2.b
    public void a(R2.a aVar) {
        this.f6724a = aVar;
        g.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    @Override // Q2.b
    public void b(String str, Bundle bundle) {
        R2.a aVar = this.f6724a;
        if (aVar != null) {
            try {
                aVar.a("$A$:" + c(str, bundle));
            } catch (JSONException unused) {
                g.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
