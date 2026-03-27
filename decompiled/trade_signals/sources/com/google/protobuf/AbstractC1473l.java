package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1473l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f16454a = c();

    public static C1474m a() {
        C1474m c1474mB = b("getEmptyRegistry");
        return c1474mB != null ? c1474mB : C1474m.f16493d;
    }

    public static final C1474m b(String str) {
        Class cls = f16454a;
        if (cls == null) {
            return null;
        }
        try {
            return (C1474m) cls.getDeclaredMethod(str, null).invoke(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Class c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
