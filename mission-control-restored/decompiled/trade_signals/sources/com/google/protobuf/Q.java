package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final O f16314a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final O f16315b = new P();

    public static O a() {
        return f16314a;
    }

    public static O b() {
        return f16315b;
    }

    public static O c() {
        try {
            return (O) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
