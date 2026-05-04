package com.amazon.a.a.o;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4603a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f4604b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4605c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f4606d = "Kiwi";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4607e;

    public c(String str) {
        this.f4607e = str;
    }

    private String d(String str) {
        return this.f4607e + ": " + str;
    }

    public void a(String str) {
        if (f4603a) {
            Log.d(f4606d, d(str));
        }
    }

    public void b(String str) {
        if (f4604b) {
            Log.e(f4606d, d(str));
        }
    }

    public void c(String str) {
        if (f4605c) {
            Log.e(f4606d, "TEST-" + d(str));
        }
    }

    public void a(String str, Throwable th) {
        if (f4603a) {
            Log.d(f4606d, d(str), th);
        }
    }

    public void b(String str, Throwable th) {
        if (f4604b) {
            Log.e(f4606d, d(str), th);
        }
    }

    public static void a() {
        f4605c = true;
    }

    public static boolean b() {
        return f4605c;
    }
}
