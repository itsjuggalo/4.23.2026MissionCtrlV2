package com.google.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class x implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f7216a = new x();

    public static x c() {
        return f7216a;
    }

    @Override // com.google.protobuf.t0
    public s0 a(Class cls) {
        if (!y.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (s0) y.B(cls.asSubclass(y.class)).o();
        } catch (Exception e10) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e10);
        }
    }

    @Override // com.google.protobuf.t0
    public boolean b(Class cls) {
        return y.class.isAssignableFrom(cls);
    }
}
