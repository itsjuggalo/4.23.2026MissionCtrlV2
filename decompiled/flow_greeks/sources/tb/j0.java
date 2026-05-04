package tb;

import tb.p2;
import tb.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j0 implements s {
    @Override // tb.p2
    public void a(p2.a aVar) {
        e().a(aVar);
    }

    @Override // tb.p2
    public void b() {
        e().b();
    }

    @Override // tb.s
    public void c(rb.y0 y0Var) {
        e().c(y0Var);
    }

    @Override // tb.s
    public void d(rb.k1 k1Var, s.a aVar, rb.y0 y0Var) {
        e().d(k1Var, aVar, y0Var);
    }

    public abstract s e();

    public String toString() {
        return p6.h.b(this).d("delegate", e()).toString();
    }
}
