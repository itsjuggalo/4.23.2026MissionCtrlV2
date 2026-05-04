package h7;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11041b;

    public a(String str, String str2) {
        com.google.android.gms.common.internal.s.k(str);
        com.google.android.gms.common.internal.s.k(str2);
        this.f11040a = str;
        this.f11041b = str2;
    }

    public static a a(String str) throws a7.m {
        JSONObject jSONObject = new JSONObject(str);
        String strA = t5.p.a(jSONObject.optString("token"));
        String strA2 = t5.p.a(jSONObject.optString("ttl"));
        if (strA == null || strA2 == null) {
            throw new a7.m("Unexpected server response.");
        }
        return new a(strA, strA2);
    }

    public String b() {
        return this.f11041b;
    }

    public String c() {
        return this.f11040a;
    }
}
