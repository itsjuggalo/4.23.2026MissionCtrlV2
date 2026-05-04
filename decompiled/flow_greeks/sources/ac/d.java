package ac;

import java.util.List;
import rb.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends r0.i {
    @Override // rb.r0.i
    public List b() {
        return j().b();
    }

    @Override // rb.r0.i
    public rb.a c() {
        return j().c();
    }

    @Override // rb.r0.i
    public rb.f d() {
        return j().d();
    }

    @Override // rb.r0.i
    public Object e() {
        return j().e();
    }

    @Override // rb.r0.i
    public void f() {
        j().f();
    }

    @Override // rb.r0.i
    public void g() {
        j().g();
    }

    @Override // rb.r0.i
    public void h(r0.k kVar) {
        j().h(kVar);
    }

    @Override // rb.r0.i
    public void i(List list) {
        j().i(list);
    }

    public abstract r0.i j();

    public String toString() {
        return p6.h.b(this).d("delegate", j()).toString();
    }
}
