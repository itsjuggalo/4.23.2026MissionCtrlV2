package h7;

import io.flutter.plugins.firebase.database.Constants;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11080b;

    public n(int i10, String str) {
        this.f11079a = i10;
        this.f11080b = str;
    }

    public static n a(String str) {
        JSONObject jSONObject = new JSONObject(new JSONObject(str).optString("error"));
        return new n(jSONObject.optInt(Constants.ERROR_CODE), jSONObject.optString(Constants.ERROR_MESSAGE));
    }

    public int b() {
        return this.f11079a;
    }

    public String c() {
        return this.f11080b;
    }
}
