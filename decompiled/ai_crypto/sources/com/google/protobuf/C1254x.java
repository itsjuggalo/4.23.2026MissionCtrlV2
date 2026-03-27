package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1254x implements U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1254x f12866a = new C1254x();

    public static C1254x c() {
        return f12866a;
    }

    @Override // com.google.protobuf.U
    public T a(Class cls) {
        if (!AbstractC1255y.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (T) AbstractC1255y.B(cls.asSubclass(AbstractC1255y.class)).o();
        } catch (Exception e7) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e7);
        }
    }

    @Override // com.google.protobuf.U
    public boolean b(Class cls) {
        return AbstractC1255y.class.isAssignableFrom(cls);
    }
}
