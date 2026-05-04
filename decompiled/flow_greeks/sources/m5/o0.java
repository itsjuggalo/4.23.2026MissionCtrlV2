package m5;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final o0 f15956e = new o0(true, 3, 1, null, null, -1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f15957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f15959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15960d;

    public o0(boolean z10, int i10, int i11, String str, Throwable th, long j10) {
        this.f15957a = z10;
        this.f15960d = i10;
        this.f15958b = str;
        this.f15959c = th;
    }

    public static o0 b() {
        return f15956e;
    }

    public static o0 c(String str) {
        return new o0(false, 1, 5, str, null, -1L);
    }

    public static o0 d(String str, Throwable th) {
        return new o0(false, 1, 5, str, th, -1L);
    }

    public static o0 f(int i10, long j10) {
        return new o0(true, i10, 1, null, null, j10);
    }

    public static o0 g(int i10, int i11, String str, Throwable th) {
        return new o0(false, i10, i11, str, th, -1L);
    }

    public String a() {
        return this.f15958b;
    }

    public final void e() {
        if (this.f15957a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        Throwable th = this.f15959c;
        if (th != null) {
            Log.d("GoogleCertificatesRslt", a(), th);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }

    public /* synthetic */ o0(boolean z10, int i10, int i11, String str, Throwable th, long j10, byte[] bArr) {
        this(false, 1, 5, null, null, -1L);
    }
}
