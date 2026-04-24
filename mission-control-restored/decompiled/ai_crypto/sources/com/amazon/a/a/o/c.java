package com.amazon.a.a.o;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9994a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f9995b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f9996c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9997d = "Kiwi";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9998e;

    public c(String str) {
        this.f9998e = str;
    }

    private String d(String str) {
        return this.f9998e + ": " + str;
    }

    public void a(String str) {
        if (f9994a) {
            Log.d(f9997d, d(str));
        }
    }

    public void b(String str) {
        if (f9995b) {
            Log.e(f9997d, d(str));
        }
    }

    public void c(String str) {
        if (f9996c) {
            Log.e(f9997d, "TEST-" + d(str));
        }
    }

    public void a(String str, Throwable th) {
        if (f9994a) {
            Log.d(f9997d, d(str), th);
        }
    }

    public void b(String str, Throwable th) {
        if (f9995b) {
            Log.e(f9997d, d(str), th);
        }
    }

    public static void a() {
        f9996c = true;
    }

    public static boolean b() {
        return f9996c;
    }
}
