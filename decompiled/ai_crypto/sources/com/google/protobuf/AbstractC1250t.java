package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1250t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f12782a = new C1249s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f12783b = c();

    public static r a() {
        r rVar = f12783b;
        if (rVar != null) {
            return rVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static r b() {
        return f12782a;
    }

    public static r c() {
        try {
            return (r) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
