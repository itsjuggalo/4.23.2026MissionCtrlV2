package com.amazon.a.a.o;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f8809a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f8810b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f8811c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f8812d = "Kiwi";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8813e;

    public c(String str) {
        this.f8813e = str;
    }

    private String d(String str) {
        return this.f8813e + ": " + str;
    }

    public void a(String str) {
        if (f8809a) {
            Log.d(f8812d, d(str));
        }
    }

    public void b(String str) {
        if (f8810b) {
            Log.e(f8812d, d(str));
        }
    }

    public void c(String str) {
        if (f8811c) {
            Log.e(f8812d, "TEST-" + d(str));
        }
    }

    public void a(String str, Throwable th) {
        if (f8809a) {
            Log.d(f8812d, d(str), th);
        }
    }

    public void b(String str, Throwable th) {
        if (f8810b) {
            Log.e(f8812d, d(str), th);
        }
    }

    public static void a() {
        f8811c = true;
    }

    public static boolean b() {
        return f8811c;
    }
}
