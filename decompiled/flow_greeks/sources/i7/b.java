package i7;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f11835c = new b("FirebaseAppCheck");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11837b = 4;

    public b(String str) {
        this.f11836a = str;
    }

    public static b f() {
        return f11835c;
    }

    public final boolean a(int i10) {
        return this.f11837b <= i10 || Log.isLoggable(this.f11836a, i10);
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, Throwable th) {
        if (a(3)) {
            Log.d(this.f11836a, str, th);
        }
    }

    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.f11836a, str, th);
        }
    }
}
