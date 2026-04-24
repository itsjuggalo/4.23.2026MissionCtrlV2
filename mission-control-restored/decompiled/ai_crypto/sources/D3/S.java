package D3;

import D3.C0446p;
import K3.AbstractC0612b;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public class S extends C0446p {
    public S(G3.q qVar, C2105D c2105d) {
        super(qVar, C0446p.b.IN, c2105d);
        AbstractC0612b.d(G3.y.u(c2105d), "InFilter expects an ArrayValue", new Object[0]);
    }

    @Override // D3.C0446p, D3.AbstractC0447q
    public boolean d(G3.h hVar) {
        C2105D c2105dI = hVar.i(f());
        return c2105dI != null && G3.y.q(h().l0(), c2105dI);
    }
}
