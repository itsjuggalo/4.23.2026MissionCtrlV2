package com.google.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f7147a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p0 f7148b = new q0();

    public static p0 a() {
        return f7147a;
    }

    public static p0 b() {
        return f7148b;
    }

    public static p0 c() {
        try {
            return (p0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
