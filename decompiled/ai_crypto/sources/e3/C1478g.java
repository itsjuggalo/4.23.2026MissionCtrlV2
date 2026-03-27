package e3;

import android.util.Log;

/* JADX INFO: renamed from: e3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1478g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1478g f13603c = new C1478g("FirebaseCrashlytics");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13605b = 4;

    public C1478g(String str) {
        this.f13604a = str;
    }

    public static C1478g f() {
        return f13603c;
    }

    public final boolean a(int i7) {
        return this.f13605b <= i7 || Log.isLoggable(this.f13604a, i7);
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, Throwable th) {
        if (a(3)) {
            Log.d(this.f13604a, str, th);
        }
    }

    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.f13604a, str, th);
        }
    }

    public void g(String str) {
        h(str, null);
    }

    public void h(String str, Throwable th) {
        if (a(4)) {
            Log.i(this.f13604a, str, th);
        }
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th) {
        if (a(2)) {
            Log.v(this.f13604a, str, th);
        }
    }

    public void k(String str) {
        l(str, null);
    }

    public void l(String str, Throwable th) {
        if (a(5)) {
            Log.w(this.f13604a, str, th);
        }
    }
}
