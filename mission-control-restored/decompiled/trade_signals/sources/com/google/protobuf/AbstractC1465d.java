package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1465d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f16356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f16357b = a("libcore.io.Memory");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f16358c;

    static {
        f16358c = (f16356a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class b() {
        return f16357b;
    }

    public static boolean c() {
        return f16356a || !(f16357b == null || f16358c);
    }
}
