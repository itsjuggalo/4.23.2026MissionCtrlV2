package ra;

import android.util.Log;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pa.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qa.e f19448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public qa.e f19449b;

    public a(qa.e eVar, qa.e eVar2) {
        this.f19448a = eVar;
        this.f19449b = eVar2;
    }

    public static a a(qa.e eVar, qa.e eVar2) {
        return new a(eVar, eVar2);
    }

    public static String d(qa.e eVar, String str) {
        com.google.firebase.remoteconfig.internal.b bVarF = eVar.f();
        if (bVarF == null) {
            return null;
        }
        try {
            return bVarF.g().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public ta.e b(com.google.firebase.remoteconfig.internal.b bVar) throws p {
        JSONArray jSONArrayJ = bVar.j();
        long jK = bVar.k();
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < jSONArrayJ.length(); i10++) {
            try {
                JSONObject jSONObject = jSONArrayJ.getJSONObject(i10);
                String string = jSONObject.getString("rolloutId");
                JSONArray jSONArray = jSONObject.getJSONArray("affectedParameterKeys");
                if (jSONArray.length() > 1) {
                    Log.w("FirebaseRemoteConfig", String.format("Rollout has multiple affected parameter keys.Only the first key will be included in RolloutsState. rolloutId: %s, affectedParameterKeys: %s", string, jSONArray));
                }
                String strOptString = jSONArray.optString(0, "");
                hashSet.add(ta.d.a().d(string).f(jSONObject.getString("variantId")).b(strOptString).c(c(strOptString)).e(jK).a());
            } catch (JSONException e10) {
                throw new p("Exception parsing rollouts metadata to create RolloutsState.", e10);
            }
        }
        return ta.e.a(hashSet);
    }

    public final String c(String str) {
        String strD = d(this.f19448a, str);
        if (strD != null) {
            return strD;
        }
        String strD2 = d(this.f19449b, str);
        return strD2 != null ? strD2 : "";
    }
}
