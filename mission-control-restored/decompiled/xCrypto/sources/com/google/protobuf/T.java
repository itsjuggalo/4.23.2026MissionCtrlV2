package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Q f10974a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Q f10975b = new S();

    public static Q a() {
        return f10974a;
    }

    public static Q b() {
        return f10975b;
    }

    public static Q c() {
        try {
            return (Q) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
