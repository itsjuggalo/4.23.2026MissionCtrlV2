package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class B implements InterfaceC0461f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final B f5633b = new B(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5634a;

    public /* synthetic */ B(int i) {
        this.f5634a = i;
    }

    @Override // com.google.protobuf.InterfaceC0461f0
    public final C0483q0 a(Class cls) {
        switch (this.f5634a) {
            case 0:
                if (!E.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (C0483q0) E.i(cls.asSubclass(E.class)).h(3);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // com.google.protobuf.InterfaceC0461f0
    public final boolean b(Class cls) {
        switch (this.f5634a) {
            case 0:
                return E.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
