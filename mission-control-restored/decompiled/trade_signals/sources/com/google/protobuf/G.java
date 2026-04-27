package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final E f16288a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final E f16289b = new F();

    public static E a() {
        return f16288a;
    }

    public static E b() {
        return f16289b;
    }

    public static E c() {
        try {
            return (E) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
