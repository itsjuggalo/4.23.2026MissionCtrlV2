package t3;

import y3.C1956j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r {
    public static final void a(InterfaceC1830o interfaceC1830o, InterfaceC1807c0 interfaceC1807c0) {
        interfaceC1830o.g(new C1809d0(interfaceC1807c0));
    }

    public static final C1832p b(Z2.e eVar) {
        if (!(eVar instanceof C1956j)) {
            return new C1832p(eVar, 1);
        }
        C1832p c1832pM = ((C1956j) eVar).m();
        if (c1832pM != null) {
            if (!c1832pM.J()) {
                c1832pM = null;
            }
            if (c1832pM != null) {
                return c1832pM;
            }
        }
        return new C1832p(eVar, 2);
    }
}
