package b6;

/* JADX INFO: renamed from: b6.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1106z {
    public static final InterfaceC1102x a(InterfaceC1101w0 interfaceC1101w0) {
        return new C1104y(interfaceC1101w0);
    }

    public static /* synthetic */ InterfaceC1102x b(InterfaceC1101w0 interfaceC1101w0, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            interfaceC1101w0 = null;
        }
        return a(interfaceC1101w0);
    }

    public static final boolean c(InterfaceC1102x interfaceC1102x, Object obj) {
        Throwable thE = E5.p.e(obj);
        return thE == null ? interfaceC1102x.X(obj) : interfaceC1102x.V(thE);
    }
}
