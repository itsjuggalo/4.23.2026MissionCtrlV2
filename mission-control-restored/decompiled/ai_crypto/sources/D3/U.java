package D3;

import D3.C0446p;
import K3.AbstractC0612b;
import java.util.ArrayList;
import java.util.List;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public class U extends C0446p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f1237d;

    /* JADX WARN: Illegal instructions before constructor call */
    public U(G3.q qVar, C2105D c2105d) {
        C0446p.b bVar = C0446p.b.IN;
        super(qVar, bVar, c2105d);
        ArrayList arrayList = new ArrayList();
        this.f1237d = arrayList;
        arrayList.addAll(k(bVar, c2105d));
    }

    public static List k(C0446p.b bVar, C2105D c2105d) {
        AbstractC0612b.d(bVar == C0446p.b.IN || bVar == C0446p.b.NOT_IN, "extractDocumentKeysFromArrayValue requires IN or NOT_IN operators", new Object[0]);
        AbstractC0612b.d(G3.y.u(c2105d), "KeyFieldInFilter/KeyFieldNotInFilter expects an ArrayValue", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (C2105D c2105d2 : c2105d.l0().g()) {
            AbstractC0612b.d(G3.y.C(c2105d2), "Comparing on key with " + bVar.toString() + ", but an array value was not a ReferenceValue", new Object[0]);
            arrayList.add(G3.k.i(c2105d2.t0()));
        }
        return arrayList;
    }

    @Override // D3.C0446p, D3.AbstractC0447q
    public boolean d(G3.h hVar) {
        return this.f1237d.contains(hVar.getKey());
    }
}
