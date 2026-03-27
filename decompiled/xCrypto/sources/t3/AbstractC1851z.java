package t3;

/* JADX INFO: renamed from: t3.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1851z {
    public static final InterfaceC1847x a(InterfaceC1846w0 interfaceC1846w0) {
        return new C1849y(interfaceC1846w0);
    }

    public static /* synthetic */ InterfaceC1847x b(InterfaceC1846w0 interfaceC1846w0, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            interfaceC1846w0 = null;
        }
        return a(interfaceC1846w0);
    }

    public static final boolean c(InterfaceC1847x interfaceC1847x, Object obj) {
        Throwable thE = W2.p.e(obj);
        return thE == null ? interfaceC1847x.K(obj) : interfaceC1847x.G(thE);
    }
}
