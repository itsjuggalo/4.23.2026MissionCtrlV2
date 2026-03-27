package a3;

import S2.D;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D f9947a;

    public h(D d8) {
        this.f9947a = d8;
    }

    public static i a(int i8) {
        if (i8 == 3) {
            return new m();
        }
        P2.g.f().d("Could not determine SettingsJsonTransform for settings version " + i8 + ". Using default settings values.");
        return new C1065b();
    }

    public C1067d b(JSONObject jSONObject) {
        return a(jSONObject.getInt("settings_version")).a(this.f9947a, jSONObject);
    }
}
