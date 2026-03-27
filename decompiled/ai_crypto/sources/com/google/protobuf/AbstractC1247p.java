package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1247p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f12750a = c();

    public static C1248q a() {
        C1248q c1248qB = b("getEmptyRegistry");
        return c1248qB != null ? c1248qB : C1248q.f12756d;
    }

    public static final C1248q b(String str) {
        Class cls = f12750a;
        if (cls == null) {
            return null;
        }
        try {
            return (C1248q) cls.getDeclaredMethod(str, null).invoke(null, null);
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
