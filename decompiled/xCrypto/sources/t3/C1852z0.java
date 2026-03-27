package t3;

/* JADX INFO: renamed from: t3.z0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1852z0 extends E0 implements A {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15042c;

    public C1852z0(InterfaceC1846w0 interfaceC1846w0) {
        super(true);
        e0(interfaceC1846w0);
        this.f15042c = K0();
    }

    public final boolean K0() {
        E0 e0R;
        InterfaceC1841u interfaceC1841uA0 = a0();
        C1843v c1843v = interfaceC1841uA0 instanceof C1843v ? (C1843v) interfaceC1841uA0 : null;
        if (c1843v != null && (e0R = c1843v.r()) != null) {
            while (!e0R.W()) {
                InterfaceC1841u interfaceC1841uA02 = e0R.a0();
                C1843v c1843v2 = interfaceC1841uA02 instanceof C1843v ? (C1843v) interfaceC1841uA02 : null;
                if (c1843v2 == null || (e0R = c1843v2.r()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // t3.E0
    public boolean W() {
        return this.f15042c;
    }

    @Override // t3.E0
    public boolean Y() {
        return true;
    }
}
