package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1477p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC1475n f16500a = new C1476o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC1475n f16501b = c();

    public static AbstractC1475n a() {
        AbstractC1475n abstractC1475n = f16501b;
        if (abstractC1475n != null) {
            return abstractC1475n;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static AbstractC1475n b() {
        return f16500a;
    }

    public static AbstractC1475n c() {
        try {
            return (AbstractC1475n) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
