package t3;

import Z2.i;
import a3.AbstractC0786b;
import a3.AbstractC0787c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class W {
    public static final Object a(long j4, Z2.e eVar) {
        if (j4 <= 0) {
            return W2.E.f5463a;
        }
        C1832p c1832p = new C1832p(AbstractC0786b.c(eVar), 1);
        c1832p.A();
        if (j4 < Long.MAX_VALUE) {
            b(c1832p.getContext()).p(j4, c1832p);
        }
        Object objX = c1832p.x();
        if (objX == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objX == AbstractC0787c.e() ? objX : W2.E.f5463a;
    }

    public static final V b(Z2.i iVar) {
        i.b bVar = iVar.get(Z2.f.f6010J);
        V v4 = bVar instanceof V ? (V) bVar : null;
        return v4 == null ? S.a() : v4;
    }
}
