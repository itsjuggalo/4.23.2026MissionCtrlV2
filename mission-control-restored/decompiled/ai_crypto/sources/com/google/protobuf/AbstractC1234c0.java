package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1234c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC1230a0 f12628a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InterfaceC1230a0 f12629b = new C1232b0();

    public static InterfaceC1230a0 a() {
        return f12628a;
    }

    public static InterfaceC1230a0 b() {
        return f12629b;
    }

    public static InterfaceC1230a0 c() {
        try {
            return (InterfaceC1230a0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
