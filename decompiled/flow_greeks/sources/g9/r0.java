package g9;

import g9.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r0 extends p {
    public r0(j9.q qVar, bb.d0 d0Var) {
        super(qVar, p.b.IN, d0Var);
        n9.b.d(j9.y.u(d0Var), "InFilter expects an ArrayValue", new Object[0]);
    }

    @Override // g9.p, g9.q
    public boolean d(j9.h hVar) {
        bb.d0 d0VarH = hVar.h(f());
        return d0VarH != null && j9.y.q(h().l0(), d0VarH);
    }
}
