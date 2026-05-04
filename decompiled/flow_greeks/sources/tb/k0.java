package tb;

import java.util.concurrent.Executor;
import tb.k1;
import tb.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k0 implements w {
    public abstract w a();

    @Override // tb.t
    public void b(t.a aVar, Executor executor) {
        a().b(aVar, executor);
    }

    @Override // tb.k1
    public void c(rb.k1 k1Var) {
        a().c(k1Var);
    }

    @Override // tb.k1
    public Runnable d(k1.a aVar) {
        return a().d(aVar);
    }

    @Override // rb.p0
    public rb.k0 f() {
        return a().f();
    }

    @Override // tb.t
    public r g(rb.z0 z0Var, rb.y0 y0Var, rb.c cVar, rb.k[] kVarArr) {
        return a().g(z0Var, y0Var, cVar, kVarArr);
    }

    @Override // tb.w
    public rb.a getAttributes() {
        return a().getAttributes();
    }

    @Override // tb.k1
    public void h(rb.k1 k1Var) {
        a().h(k1Var);
    }

    public String toString() {
        return p6.h.b(this).d("delegate", a()).toString();
    }
}
