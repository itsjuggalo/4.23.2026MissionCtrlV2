package ac;

import rb.k1;
import rb.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends r0 {
    @Override // rb.r0
    public boolean b() {
        return g().b();
    }

    @Override // rb.r0
    public void c(k1 k1Var) {
        g().c(k1Var);
    }

    @Override // rb.r0
    public void d(r0.h hVar) {
        g().d(hVar);
    }

    @Override // rb.r0
    public void e() {
        g().e();
    }

    public abstract r0 g();

    public String toString() {
        return p6.h.b(this).d("delegate", g()).toString();
    }
}
