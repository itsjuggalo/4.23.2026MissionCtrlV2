package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0471k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0469j0 f5742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0469j0 f5743b;

    static {
        C0469j0 c0469j0;
        try {
            c0469j0 = (C0469j0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            c0469j0 = null;
        }
        f5742a = c0469j0;
        f5743b = new C0469j0();
    }
}
