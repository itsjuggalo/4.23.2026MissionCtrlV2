package l7;

import a7.m;
import com.google.android.gms.common.internal.s;
import org.json.JSONObject;
import t5.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15527b;

    public c(String str, String str2) {
        s.k(str);
        s.k(str2);
        this.f15526a = str;
        this.f15527b = str2;
    }

    public static c a(String str) throws m {
        JSONObject jSONObject = new JSONObject(str);
        String strA = p.a(jSONObject.optString("challenge"));
        String strA2 = p.a(jSONObject.optString("ttl"));
        if (strA == null || strA2 == null) {
            throw new m("Unexpected server response.");
        }
        return new c(strA, strA2);
    }

    public String b() {
        return this.f15526a;
    }
}
