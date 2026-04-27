package X0;

import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import w4.C1343j;
import y2.C1425b;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f3493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f3494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f3495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f3496d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f3497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f3498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f3499h;
    public Object i;

    public static void c(JSONObject jSONObject, String str) {
        StringBuilder sbN = a3.d.n(str);
        sbN.append(jSONObject.toString());
        String string = sbN.toString();
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", string, null);
        }
    }

    public C1425b a(int i) {
        C1425b c1425b = null;
        try {
            if (!S.i.b(2, i)) {
                JSONObject jSONObjectC = ((C1343j) this.e).c();
                if (jSONObjectC != null) {
                    C1425b c1425bB = ((C1343j) this.f3495c).b(jSONObjectC);
                    c(jSONObjectC, "Loaded cached settings: ");
                    ((p0.p) this.f3496d).getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (S.i.b(3, i) || c1425bB.f11648c >= jCurrentTimeMillis) {
                        try {
                            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                                Log.v("FirebaseCrashlytics", "Returning cached settings.", null);
                            }
                            return c1425bB;
                        } catch (Exception e) {
                            e = e;
                            c1425b = c1425bB;
                            Log.e("FirebaseCrashlytics", "Failed to get cached settings", e);
                            return c1425b;
                        }
                    }
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", "Cached settings have expired.", null);
                        return null;
                    }
                } else if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "No cached settings data found.", null);
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public C1425b b() {
        return (C1425b) ((AtomicReference) this.f3499h).get();
    }
}
