package h7;

import android.util.Log;
import i7.a;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends e7.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f11042d = "h7.b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11045c;

    public b(String str, long j10) {
        this(str, j10, new a.C0224a().a());
    }

    public static b c(a aVar) {
        long jG;
        com.google.android.gms.common.internal.s.k(aVar);
        try {
            jG = (long) (Double.parseDouble(aVar.b().replace("s", "")) * 1000.0d);
        } catch (NumberFormatException unused) {
            Map mapB = i7.c.b(aVar.c());
            jG = 1000 * (g(mapB, "exp") - g(mapB, "iat"));
        }
        return new b(aVar.c(), jG);
    }

    public static b d(String str) {
        com.google.android.gms.common.internal.s.k(str);
        Map mapB = i7.c.b(str);
        long jG = g(mapB, "iat");
        return new b(str, (g(mapB, "exp") - jG) * 1000, jG * 1000);
    }

    public static b e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new b(jSONObject.getString("token"), jSONObject.getLong("expiresIn"), jSONObject.getLong("receivedAt"));
        } catch (JSONException e10) {
            Log.e(f11042d, "Could not deserialize token: " + e10.getMessage());
            return null;
        }
    }

    public static long g(Map map, String str) {
        com.google.android.gms.common.internal.s.k(map);
        com.google.android.gms.common.internal.s.e(str);
        Integer num = (Integer) map.get(str);
        if (num == null) {
            return 0L;
        }
        return num.longValue();
    }

    @Override // e7.c
    public long a() {
        return this.f11044b + this.f11045c;
    }

    @Override // e7.c
    public String b() {
        return this.f11043a;
    }

    public long f() {
        return this.f11045c;
    }

    public long h() {
        return this.f11044b;
    }

    public String i() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", this.f11043a);
            jSONObject.put("receivedAt", this.f11044b);
            jSONObject.put("expiresIn", this.f11045c);
            return jSONObject.toString();
        } catch (JSONException e10) {
            Log.e(f11042d, "Could not serialize token: " + e10.getMessage());
            return null;
        }
    }

    public b(String str, long j10, long j11) {
        com.google.android.gms.common.internal.s.e(str);
        this.f11043a = str;
        this.f11045c = j10;
        this.f11044b = j11;
    }
}
