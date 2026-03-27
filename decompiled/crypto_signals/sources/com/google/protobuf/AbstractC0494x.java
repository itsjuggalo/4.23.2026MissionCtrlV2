package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0494x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0493w f5813a = new C0493w();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0493w f5814b;

    static {
        C0493w c0493w;
        try {
            c0493w = (C0493w) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            c0493w = null;
        }
        f5814b = c0493w;
    }
}
