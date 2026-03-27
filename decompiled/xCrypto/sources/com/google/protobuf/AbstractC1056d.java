package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1056d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f11005b = a("libcore.io.Memory");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f11006c;

    static {
        f11006c = (f11004a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class b() {
        return f11005b;
    }

    public static boolean c() {
        if (f11004a) {
            return true;
        }
        return (f11005b == null || f11006c) ? false : true;
    }
}
