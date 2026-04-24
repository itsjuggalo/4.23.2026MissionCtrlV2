package a3;

import S2.C0917y;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: a3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1066c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X2.b f9916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final P2.g f9917c;

    public C1066c(String str, X2.b bVar) {
        this(str, bVar, P2.g.f());
    }

    @Override // a3.l
    public JSONObject a(k kVar, boolean z7) {
        T2.i.d();
        if (!z7) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        try {
            Map mapF = f(kVar);
            X2.a aVarB = b(d(mapF), kVar);
            this.f9917c.b("Requesting settings from " + this.f9915a);
            this.f9917c.i("Settings query params were: " + mapF);
            return g(aVarB.c());
        } catch (IOException e8) {
            this.f9917c.e("Settings request failed.", e8);
            return null;
        }
    }

    public final X2.a b(X2.a aVar, k kVar) {
        c(aVar, "X-CRASHLYTICS-GOOGLE-APP-ID", kVar.f9948a);
        c(aVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c(aVar, "X-CRASHLYTICS-API-CLIENT-VERSION", C0917y.k());
        c(aVar, "Accept", "application/json");
        c(aVar, "X-CRASHLYTICS-DEVICE-MODEL", kVar.f9949b);
        c(aVar, "X-CRASHLYTICS-OS-BUILD-VERSION", kVar.f9950c);
        c(aVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", kVar.f9951d);
        c(aVar, "X-CRASHLYTICS-INSTALLATION-ID", kVar.f9952e.a().c());
        return aVar;
    }

    public final void c(X2.a aVar, String str, String str2) {
        if (str2 != null) {
            aVar.d(str, str2);
        }
    }

    public X2.a d(Map map) {
        return this.f9916b.a(this.f9915a, map).d("User-Agent", "Crashlytics Android SDK/" + C0917y.k()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    public final JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e8) {
            this.f9917c.l("Failed to parse settings JSON from " + this.f9915a, e8);
            this.f9917c.k("Settings response " + str);
            return null;
        }
    }

    public final Map f(k kVar) {
        HashMap map = new HashMap();
        map.put("build_version", kVar.f9955h);
        map.put("display_version", kVar.f9954g);
        map.put(FirebaseAnalytics.Param.SOURCE, Integer.toString(kVar.f9956i));
        String str = kVar.f9953f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public JSONObject g(X2.c cVar) {
        int iB = cVar.b();
        this.f9917c.i("Settings response code was: " + iB);
        if (h(iB)) {
            return e(cVar.a());
        }
        this.f9917c.d("Settings request failed; (status: " + iB + ") from " + this.f9915a);
        return null;
    }

    public boolean h(int i8) {
        return i8 == 200 || i8 == 201 || i8 == 202 || i8 == 203;
    }

    public C1066c(String str, X2.b bVar, P2.g gVar) {
        if (str == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        this.f9917c = gVar;
        this.f9916b = bVar;
        this.f9915a = str;
    }
}
