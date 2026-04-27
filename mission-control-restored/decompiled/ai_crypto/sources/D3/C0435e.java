package D3;

import D3.C0446p;
import K3.AbstractC0612b;
import java.util.Iterator;
import k4.C2105D;

/* JADX INFO: renamed from: D3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0435e extends C0446p {
    public C0435e(G3.q qVar, C2105D c2105d) {
        super(qVar, C0446p.b.ARRAY_CONTAINS_ANY, c2105d);
        AbstractC0612b.d(G3.y.u(c2105d), "ArrayContainsAnyFilter expects an ArrayValue", new Object[0]);
    }

    @Override // D3.C0446p, D3.AbstractC0447q
    public boolean d(G3.h hVar) {
        C2105D c2105dI = hVar.i(f());
        if (!G3.y.u(c2105dI)) {
            return false;
        }
        Iterator it = c2105dI.l0().g().iterator();
        while (it.hasNext()) {
            if (G3.y.q(h().l0(), (C2105D) it.next())) {
                return true;
            }
        }
        return false;
    }
}
