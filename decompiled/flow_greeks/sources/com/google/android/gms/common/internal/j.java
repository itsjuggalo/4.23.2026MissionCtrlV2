package com.google.android.gms.common.internal;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5736b;

    public j(String str) {
        this(str, null);
    }

    public boolean a(int i10) {
        return Log.isLoggable(this.f5735a, i10);
    }

    public void b(String str, String str2) {
        if (a(3)) {
            Log.d(str, f(str2));
        }
    }

    public void c(String str, String str2, Throwable th) {
        if (a(6)) {
            Log.e(str, f(str2), th);
        }
    }

    public void d(String str, String str2) {
        if (a(2)) {
            Log.v(str, f(str2));
        }
    }

    public void e(String str, String str2) {
        if (a(5)) {
            Log.w(str, f(str2));
        }
    }

    public final String f(String str) {
        String str2 = this.f5736b;
        return str2 == null ? str : str2.concat(str);
    }

    public j(String str, String str2) {
        s.l(str, "log tag cannot be null");
        s.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f5735a = str;
        this.f5736b = (str2 == null || str2.length() <= 0) ? null : str2;
    }
}
