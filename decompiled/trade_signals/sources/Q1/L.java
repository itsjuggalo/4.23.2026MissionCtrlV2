package Q1;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class L {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final L f6671e = new L(true, 3, 1, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f6674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6675d;

    public L(boolean z7, int i8, int i9, String str, Throwable th) {
        this.f6672a = z7;
        this.f6675d = i8;
        this.f6673b = str;
        this.f6674c = th;
    }

    public static L b() {
        return f6671e;
    }

    public static L c(String str) {
        return new L(false, 1, 5, str, null);
    }

    public static L d(String str, Throwable th) {
        return new L(false, 1, 5, str, th);
    }

    public static L f(int i8) {
        return new L(true, i8, 1, null, null);
    }

    public static L g(int i8, int i9, String str, Throwable th) {
        return new L(false, i8, i9, str, th);
    }

    public String a() {
        return this.f6673b;
    }

    public final void e() {
        if (this.f6672a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f6674c != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f6674c);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
