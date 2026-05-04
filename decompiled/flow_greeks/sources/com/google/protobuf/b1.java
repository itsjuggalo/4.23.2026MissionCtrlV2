package com.google.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0 f6937a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z0 f6938b = new a1();

    public static z0 a() {
        return f6937a;
    }

    public static z0 b() {
        return f6938b;
    }

    public static z0 c() {
        try {
            return (z0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
