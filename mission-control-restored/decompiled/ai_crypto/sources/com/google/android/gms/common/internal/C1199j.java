package com.google.android.gms.common.internal;

import android.util.Log;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1199j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11112b;

    public C1199j(String str) {
        this(str, null);
    }

    public boolean a(int i7) {
        return Log.isLoggable(this.f11111a, i7);
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
        String str2 = this.f11112b;
        return str2 == null ? str : str2.concat(str);
    }

    public C1199j(String str, String str2) {
        AbstractC1207s.l(str, "log tag cannot be null");
        AbstractC1207s.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f11111a = str;
        this.f11112b = (str2 == null || str2.length() <= 0) ? null : str2;
    }
}
