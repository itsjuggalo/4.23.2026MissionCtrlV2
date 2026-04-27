package i2;

import android.util.Log;

/* JADX INFO: renamed from: i2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0655a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6768b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f6769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f6770d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f6771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f6772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f6773h;

    public synchronized boolean a() {
        boolean zK;
        Boolean bool = (Boolean) this.f6772g;
        if (bool != null) {
            zK = bool.booleanValue();
        } else {
            try {
                zK = ((Z1.h) this.f6770d).k();
            } catch (IllegalStateException unused) {
                zK = false;
            }
        }
        b(zK);
        return zK;
    }

    public void b(boolean z6) {
        String str = "Crashlytics automatic data collection " + (z6 ? "ENABLED" : "DISABLED") + " by " + (((Boolean) this.f6772g) == null ? "global Firebase setting" : this.f6768b ? "firebase_crashlytics_collection_enabled manifest flag" : "API") + ".";
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }
}
