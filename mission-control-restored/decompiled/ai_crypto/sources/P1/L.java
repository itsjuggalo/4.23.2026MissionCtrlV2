package P1;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class L {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final L f4277e = new L(true, 3, 1, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f4280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4281d;

    public L(boolean z7, int i7, int i8, String str, Throwable th) {
        this.f4278a = z7;
        this.f4281d = i7;
        this.f4279b = str;
        this.f4280c = th;
    }

    public static L b() {
        return f4277e;
    }

    public static L c(String str) {
        return new L(false, 1, 5, str, null);
    }

    public static L d(String str, Throwable th) {
        return new L(false, 1, 5, str, th);
    }

    public static L f(int i7) {
        return new L(true, i7, 1, null, null);
    }

    public static L g(int i7, int i8, String str, Throwable th) {
        return new L(false, i7, i8, str, th);
    }

    public String a() {
        return this.f4279b;
    }

    public final void e() {
        if (this.f4278a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f4280c != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f4280c);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
