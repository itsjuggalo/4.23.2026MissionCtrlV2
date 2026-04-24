package f5;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import n2.C0873b;
import org.json.JSONObject;
import p0.C0901m;
import y2.C1427d;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6534b;

    public static void a(f.d dVar, C1427d c1427d) {
        String str = c1427d.f11651a;
        if (str != null) {
            dVar.M("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        }
        dVar.M("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        dVar.M("X-CRASHLYTICS-API-CLIENT-VERSION", "20.0.0");
        dVar.M("Accept", "application/json");
        String str2 = c1427d.f11652b;
        if (str2 != null) {
            dVar.M("X-CRASHLYTICS-DEVICE-MODEL", str2);
        }
        String str3 = c1427d.f11653c;
        if (str3 != null) {
            dVar.M("X-CRASHLYTICS-OS-BUILD-VERSION", str3);
        }
        String str4 = c1427d.f11654d;
        if (str4 != null) {
            dVar.M("X-CRASHLYTICS-OS-DISPLAY-VERSION", str4);
        }
        String str5 = c1427d.e.c().f9166a;
        if (str5 != null) {
            dVar.M("X-CRASHLYTICS-INSTALLATION-ID", str5);
        }
    }

    public static HashMap b(C1427d c1427d) {
        HashMap map = new HashMap();
        map.put("build_version", c1427d.f11657h);
        map.put("display_version", c1427d.f11656g);
        map.put("source", Integer.toString(c1427d.i));
        String str = c1427d.f11655f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public JSONObject c(E2.a aVar) {
        StringBuilder sb = new StringBuilder("Settings response code was: ");
        int i = aVar.f389a;
        sb.append(i);
        String string = sb.toString();
        C0873b c0873b = C0873b.f8554a;
        c0873b.f(string);
        String str = this.f6534b;
        if (i == 200 || i == 201 || i == 202 || i == 203) {
            String str2 = aVar.f390b;
            try {
                return new JSONObject(str2);
            } catch (Exception e) {
                c0873b.g("Failed to parse settings JSON from " + str, e);
                c0873b.g("Settings response " + str2, null);
            }
        } else {
            String str3 = "Settings request failed; (status: " + i + ") from " + str;
            if (c0873b.b(6)) {
                Log.e("FirebaseCrashlytics", str3, null);
                return null;
            }
        }
        return null;
    }

    public String toString() {
        switch (this.f6533a) {
            case 0:
                return "<" + this.f6534b + '>';
            case 3:
                return this.f6534b;
            default:
                return super.toString();
        }
    }

    public /* synthetic */ t(String str, int i) {
        this.f6533a = i;
        this.f6534b = str;
    }

    public t(String str, C0901m c0901m) {
        this.f6533a = 4;
        if (str != null) {
            this.f6534b = str;
            return;
        }
        throw new IllegalArgumentException("url must not be null.");
    }
}
