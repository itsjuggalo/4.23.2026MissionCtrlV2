package p3;

import e3.C1478g;
import h3.InterfaceC1677H;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1677H f21529a;

    public h(InterfaceC1677H interfaceC1677H) {
        this.f21529a = interfaceC1677H;
    }

    public static i a(int i7) {
        if (i7 == 3) {
            return new m();
        }
        C1478g.f().d("Could not determine SettingsJsonTransform for settings version " + i7 + ". Using default settings values.");
        return new C2373b();
    }

    public C2375d b(JSONObject jSONObject) {
        return a(jSONObject.getInt("settings_version")).a(this.f21529a, jSONObject);
    }
}
