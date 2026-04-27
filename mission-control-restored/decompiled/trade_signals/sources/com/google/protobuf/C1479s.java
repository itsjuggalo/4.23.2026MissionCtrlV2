package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1479s implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1479s f16575a = new C1479s();

    public static C1479s c() {
        return f16575a;
    }

    @Override // com.google.protobuf.I
    public H a(Class cls) {
        if (!AbstractC1480t.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (H) AbstractC1480t.y(cls.asSubclass(AbstractC1480t.class)).n();
        } catch (Exception e8) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e8);
        }
    }

    @Override // com.google.protobuf.I
    public boolean b(Class cls) {
        return AbstractC1480t.class.isAssignableFrom(cls);
    }
}
