package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final P f12599a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final P f12600b = new Q();

    public static P a() {
        return f12599a;
    }

    public static P b() {
        return f12600b;
    }

    public static P c() {
        try {
            return (P) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
