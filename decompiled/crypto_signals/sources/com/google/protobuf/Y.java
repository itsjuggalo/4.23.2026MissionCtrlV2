package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class Y implements InterfaceC0461f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0461f0[] f5700a;

    @Override // com.google.protobuf.InterfaceC0461f0
    public final C0483q0 a(Class cls) {
        for (InterfaceC0461f0 interfaceC0461f0 : this.f5700a) {
            if (interfaceC0461f0.b(cls)) {
                return interfaceC0461f0.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.protobuf.InterfaceC0461f0
    public final boolean b(Class cls) {
        for (InterfaceC0461f0 interfaceC0461f0 : this.f5700a) {
            if (interfaceC0461f0.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
