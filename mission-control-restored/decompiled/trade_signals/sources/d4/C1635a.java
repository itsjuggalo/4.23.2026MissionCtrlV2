package d4;

import android.util.Log;
import b4.p;
import f4.AbstractC1755d;
import f4.AbstractC1756e;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: d4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1635a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c4.e f16878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c4.e f16879b;

    public C1635a(c4.e eVar, c4.e eVar2) {
        this.f16878a = eVar;
        this.f16879b = eVar2;
    }

    public static C1635a a(c4.e eVar, c4.e eVar2) {
        return new C1635a(eVar, eVar2);
    }

    public static String d(c4.e eVar, String str) {
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

    public AbstractC1756e b(com.google.firebase.remoteconfig.internal.b bVar) throws p {
        JSONArray jSONArrayJ = bVar.j();
        long jK = bVar.k();
        HashSet hashSet = new HashSet();
        for (int i8 = 0; i8 < jSONArrayJ.length(); i8++) {
            try {
                JSONObject jSONObject = jSONArrayJ.getJSONObject(i8);
                String string = jSONObject.getString("rolloutId");
                JSONArray jSONArray = jSONObject.getJSONArray("affectedParameterKeys");
                if (jSONArray.length() > 1) {
                    Log.w("FirebaseRemoteConfig", String.format("Rollout has multiple affected parameter keys.Only the first key will be included in RolloutsState. rolloutId: %s, affectedParameterKeys: %s", string, jSONArray));
                }
                String strOptString = jSONArray.optString(0, "");
                hashSet.add(AbstractC1755d.a().d(string).f(jSONObject.getString("variantId")).b(strOptString).c(c(strOptString)).e(jK).a());
            } catch (JSONException e8) {
                throw new p("Exception parsing rollouts metadata to create RolloutsState.", e8);
            }
        }
        return AbstractC1756e.a(hashSet);
    }

    public final String c(String str) {
        String strD = d(this.f16878a, str);
        if (strD != null) {
            return strD;
        }
        String strD2 = d(this.f16879b, str);
        return strD2 != null ? strD2 : "";
    }
}
