package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1069p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f11134a = c();

    public static C1070q a() {
        C1070q c1070qB = b("getEmptyRegistry");
        return c1070qB != null ? c1070qB : C1070q.f11137d;
    }

    public static final C1070q b(String str) {
        Class cls = f11134a;
        if (cls == null) {
            return null;
        }
        try {
            return (C1070q) cls.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
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
