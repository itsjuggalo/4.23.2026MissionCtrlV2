package com.amazon.a.a.o;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f14105a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f14106b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f14107c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14108d = "Kiwi";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14109e;

    public c(String str) {
        this.f14109e = str;
    }

    public static void a() {
        f14107c = true;
    }

    private String d(String str) {
        return this.f14109e + ": " + str;
    }

    public void b(String str) {
        if (f14106b) {
            Log.e(f14108d, d(str));
        }
    }

    public void c(String str) {
        if (f14107c) {
            Log.e(f14108d, "TEST-" + d(str));
        }
    }

    public void a(String str) {
        if (f14105a) {
            Log.d(f14108d, d(str));
        }
    }

    public void b(String str, Throwable th) {
        if (f14106b) {
            Log.e(f14108d, d(str), th);
        }
    }

    public static boolean b() {
        return f14107c;
    }

    public void a(String str, Throwable th) {
        if (f14105a) {
            Log.d(f14108d, d(str), th);
        }
    }
}
