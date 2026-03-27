package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1057d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC1053b0 f11007a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InterfaceC1053b0 f11008b = new C1055c0();

    public static InterfaceC1053b0 a() {
        return f11007a;
    }

    public static InterfaceC1053b0 b() {
        return f11008b;
    }

    public static InterfaceC1053b0 c() {
        try {
            return (InterfaceC1053b0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
