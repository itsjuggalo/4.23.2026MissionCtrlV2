package s2;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final E.l f9569a;

    static {
        H2.d dVar = new H2.d();
        C0998a c0998a = C0998a.f9534a;
        dVar.a(n.class, c0998a);
        dVar.a(C0999b.class, c0998a);
        f9569a = new E.l(dVar, 2);
    }

    public static C0999b a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("rolloutId");
        String string2 = jSONObject.getString("parameterKey");
        String string3 = jSONObject.getString("parameterValue");
        String string4 = jSONObject.getString("variantId");
        long j4 = jSONObject.getLong("templateVersion");
        if (string3.length() > 256) {
            string3 = string3.substring(0, 256);
        }
        return new C0999b(string, string2, string3, string4, j4);
    }
}
