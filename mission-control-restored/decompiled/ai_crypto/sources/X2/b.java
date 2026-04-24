package X2;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f5483c = new b("FirebaseAppCheck");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5485b = 4;

    public b(String str) {
        this.f5484a = str;
    }

    public static b f() {
        return f5483c;
    }

    public final boolean a(int i7) {
        return this.f5485b <= i7 || Log.isLoggable(this.f5484a, i7);
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, Throwable th) {
        if (a(3)) {
            Log.d(this.f5484a, str, th);
        }
    }

    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.f5484a, str, th);
        }
    }
}
