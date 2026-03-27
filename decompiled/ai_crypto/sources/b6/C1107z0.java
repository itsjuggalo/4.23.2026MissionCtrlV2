package b6;

/* JADX INFO: renamed from: b6.z0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1107z0 extends E0 implements InterfaceC1054A {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9100c;

    public C1107z0(InterfaceC1101w0 interfaceC1101w0) {
        super(true);
        d0(interfaceC1101w0);
        this.f9100c = K0();
    }

    public final boolean K0() {
        E0 e0T;
        InterfaceC1096u interfaceC1096uY = Y();
        C1098v c1098v = interfaceC1096uY instanceof C1098v ? (C1098v) interfaceC1096uY : null;
        if (c1098v != null && (e0T = c1098v.t()) != null) {
            while (!e0T.S()) {
                InterfaceC1096u interfaceC1096uY2 = e0T.Y();
                C1098v c1098v2 = interfaceC1096uY2 instanceof C1098v ? (C1098v) interfaceC1096uY2 : null;
                if (c1098v2 == null || (e0T = c1098v2.t()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // b6.E0
    public boolean S() {
        return this.f9100c;
    }

    @Override // b6.E0
    public boolean U() {
        return true;
    }
}
