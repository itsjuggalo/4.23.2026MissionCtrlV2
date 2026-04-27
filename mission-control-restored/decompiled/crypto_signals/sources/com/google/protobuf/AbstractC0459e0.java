package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0459e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0457d0 f5717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0457d0 f5718b;

    static {
        C0457d0 c0457d0;
        try {
            c0457d0 = (C0457d0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            c0457d0 = null;
        }
        f5717a = c0457d0;
        f5718b = new C0457d0();
    }
}
