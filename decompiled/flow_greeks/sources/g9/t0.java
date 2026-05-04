package g9;

import g9.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class t0 extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f10369d;

    /* JADX WARN: Illegal instructions before constructor call */
    public t0(j9.q qVar, bb.d0 d0Var) {
        p.b bVar = p.b.IN;
        super(qVar, bVar, d0Var);
        ArrayList arrayList = new ArrayList();
        this.f10369d = arrayList;
        arrayList.addAll(k(bVar, d0Var));
    }

    public static List k(p.b bVar, bb.d0 d0Var) {
        n9.b.d(bVar == p.b.IN || bVar == p.b.NOT_IN, "extractDocumentKeysFromArrayValue requires IN or NOT_IN operators", new Object[0]);
        n9.b.d(j9.y.u(d0Var), "KeyFieldInFilter/KeyFieldNotInFilter expects an ArrayValue", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (bb.d0 d0Var2 : d0Var.l0().h()) {
            n9.b.d(j9.y.C(d0Var2), "Comparing on key with " + bVar.toString() + ", but an array value was not a ReferenceValue", new Object[0]);
            arrayList.add(j9.k.i(d0Var2.t0()));
        }
        return arrayList;
    }

    @Override // g9.p, g9.q
    public boolean d(j9.h hVar) {
        return this.f10369d.contains(hVar.getKey());
    }
}
