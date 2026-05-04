package c8;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import u7.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z7.b f3709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r7.g f3710c;

    public c(String str, z7.b bVar) {
        this(str, bVar, r7.g.f());
    }

    @Override // c8.l
    public JSONObject a(k kVar, boolean z10) {
        v7.i.d();
        if (!z10) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        try {
            Map mapF = f(kVar);
            z7.a aVarB = b(d(mapF), kVar);
            this.f3710c.b("Requesting settings from " + this.f3708a);
            this.f3710c.i("Settings query params were: " + mapF);
            return g(aVarB.c());
        } catch (IOException e10) {
            this.f3710c.e("Settings request failed.", e10);
            return null;
        }
    }

    public final z7.a b(z7.a aVar, k kVar) {
        c(aVar, "X-CRASHLYTICS-GOOGLE-APP-ID", kVar.f3741a);
        c(aVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c(aVar, "X-CRASHLYTICS-API-CLIENT-VERSION", w.k());
        c(aVar, "Accept", "application/json");
        c(aVar, "X-CRASHLYTICS-DEVICE-MODEL", kVar.f3742b);
        c(aVar, "X-CRASHLYTICS-OS-BUILD-VERSION", kVar.f3743c);
        c(aVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", kVar.f3744d);
        c(aVar, "X-CRASHLYTICS-INSTALLATION-ID", kVar.f3745e.a().c());
        return aVar;
    }

    public final void c(z7.a aVar, String str, String str2) {
        if (str2 != null) {
            aVar.d(str, str2);
        }
    }

    public z7.a d(Map map) {
        return this.f3709b.a(this.f3708a, map).d("User-Agent", "Crashlytics Android SDK/" + w.k()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    public final JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e10) {
            this.f3710c.l("Failed to parse settings JSON from " + this.f3708a, e10);
            this.f3710c.k("Settings response " + str);
            return null;
        }
    }

    public final Map f(k kVar) {
        HashMap map = new HashMap();
        map.put("build_version", kVar.f3748h);
        map.put("display_version", kVar.f3747g);
        map.put(FirebaseAnalytics.Param.SOURCE, Integer.toString(kVar.f3749i));
        String str = kVar.f3746f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public JSONObject g(z7.c cVar) {
        int iB = cVar.b();
        this.f3710c.i("Settings response code was: " + iB);
        if (h(iB)) {
            return e(cVar.a());
        }
        this.f3710c.d("Settings request failed; (status: " + iB + ") from " + this.f3708a);
        return null;
    }

    public boolean h(int i10) {
        return i10 == 200 || i10 == 201 || i10 == 202 || i10 == 203;
    }

    public c(String str, z7.b bVar, r7.g gVar) {
        if (str == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        this.f3710c = gVar;
        this.f3709b = bVar;
        this.f3708a = str;
    }
}
