package c8;

import org.json.JSONObject;
import u7.b0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f3740a;

    public h(b0 b0Var) {
        this.f3740a = b0Var;
    }

    public static i a(int i10) {
        if (i10 == 3) {
            return new m();
        }
        r7.g.f().d("Could not determine SettingsJsonTransform for settings version " + i10 + ". Using default settings values.");
        return new b();
    }

    public d b(JSONObject jSONObject) {
        return a(jSONObject.getInt("settings_version")).a(this.f3740a, jSONObject);
    }
}
