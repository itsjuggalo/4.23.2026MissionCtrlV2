package z1;

import android.util.Log;

/* JADX INFO: renamed from: z1.L, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1981L {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C1981L f16074e = new C1981L(true, 3, 1, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f16077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16078d;

    public C1981L(boolean z4, int i4, int i5, String str, Throwable th) {
        this.f16075a = z4;
        this.f16078d = i4;
        this.f16076b = str;
        this.f16077c = th;
    }

    public static C1981L b() {
        return f16074e;
    }

    public static C1981L c(String str) {
        return new C1981L(false, 1, 5, str, null);
    }

    public static C1981L d(String str, Throwable th) {
        return new C1981L(false, 1, 5, str, th);
    }

    public static C1981L f(int i4) {
        return new C1981L(true, i4, 1, null, null);
    }

    public static C1981L g(int i4, int i5, String str, Throwable th) {
        return new C1981L(false, i4, i5, str, th);
    }

    public String a() {
        return this.f16076b;
    }

    public final void e() {
        if (this.f16075a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f16077c != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f16077c);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
