package W2;

import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends V2.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5384d = "W2.a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5387c;

    public a(String str, long j7, long j8) {
        AbstractC1207s.e(str);
        this.f5385a = str;
        this.f5387c = j7;
        this.f5386b = j8;
    }

    public static a c(String str) {
        AbstractC1207s.k(str);
        Map mapB = X2.c.b(str);
        long jE = e(mapB, "iat");
        return new a(str, (e(mapB, "exp") - jE) * 1000, jE * 1000);
    }

    public static a d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new a(jSONObject.getString("token"), jSONObject.getLong("expiresIn"), jSONObject.getLong("receivedAt"));
        } catch (JSONException e7) {
            Log.e(f5384d, "Could not deserialize token: " + e7.getMessage());
            return null;
        }
    }

    public static long e(Map map, String str) {
        AbstractC1207s.k(map);
        AbstractC1207s.e(str);
        Integer num = (Integer) map.get(str);
        if (num == null) {
            return 0L;
        }
        return num.longValue();
    }

    @Override // V2.a
    public long a() {
        return this.f5386b + this.f5387c;
    }

    @Override // V2.a
    public String b() {
        return this.f5385a;
    }
}
