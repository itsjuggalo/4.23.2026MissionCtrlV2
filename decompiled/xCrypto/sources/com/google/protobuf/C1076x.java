package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1076x implements V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1076x f11248a = new C1076x();

    public static C1076x c() {
        return f11248a;
    }

    @Override // com.google.protobuf.V
    public U a(Class cls) {
        if (!AbstractC1077y.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (U) AbstractC1077y.getDefaultInstance(cls.asSubclass(AbstractC1077y.class)).buildMessageInfo();
        } catch (Exception e4) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e4);
        }
    }

    @Override // com.google.protobuf.V
    public boolean b(Class cls) {
        return AbstractC1077y.class.isAssignableFrom(cls);
    }
}
