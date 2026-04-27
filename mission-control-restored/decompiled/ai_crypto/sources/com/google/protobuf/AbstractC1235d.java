package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1235d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f12630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f12631b = a("libcore.io.Memory");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f12632c;

    static {
        f12632c = (f12630a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class b() {
        return f12631b;
    }

    public static boolean c() {
        return f12630a || !(f12631b == null || f12632c);
    }
}
