package g9;

import g9.j;
import i9.l4;
import i9.q0;
import m9.s0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class x0 extends j {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements s0.c {
        public b() {
        }

        @Override // m9.s0.c
        public void a(z0 z0Var) {
            x0.this.r().a(z0Var);
        }

        @Override // m9.s0.c
        public g8.e b(int i10) {
            return x0.this.r().b(i10);
        }

        @Override // m9.s0.c
        public void c(k9.h hVar) {
            x0.this.r().c(hVar);
        }

        @Override // m9.s0.c
        public void d(m9.n0 n0Var) {
            x0.this.r().d(n0Var);
        }

        @Override // m9.s0.c
        public void e(int i10, rb.k1 k1Var) {
            x0.this.r().e(i10, k1Var);
        }

        @Override // m9.s0.c
        public void f(int i10, rb.k1 k1Var) {
            x0.this.r().f(i10, k1Var);
        }
    }

    public x0(com.google.firebase.firestore.g gVar) {
        super(gVar);
    }

    @Override // g9.j
    public o a(j.a aVar) {
        return new o(r());
    }

    @Override // g9.j
    public l4 b(j.a aVar) {
        return null;
    }

    @Override // g9.j
    public i9.l c(j.a aVar) {
        return null;
    }

    @Override // g9.j
    public i9.k0 d(j.a aVar) {
        return new i9.k0(o(), new i9.j1(), aVar.f10247d);
    }

    @Override // g9.j
    public i9.h1 e(j.a aVar) {
        if (!t(this.f10235a)) {
            return i9.b1.o();
        }
        return i9.b1.p(q0.b.a(this.f10235a.g()), new i9.p(p()));
    }

    @Override // g9.j
    public m9.s0 f(j.a aVar) {
        return new m9.s0(aVar.f10246c.a(), new b(), n(), j(), aVar.f10245b, i());
    }

    @Override // g9.j
    public f1 g(j.a aVar) {
        return new f1(n(), q(), aVar.f10247d, aVar.f10248e);
    }

    public final boolean t(com.google.firebase.firestore.g gVar) {
        if (gVar.f() != null && (gVar.f() instanceof d9.y0)) {
            ((d9.y0) gVar.f()).a();
        }
        return false;
    }
}
