package D3;

import D3.C0446p;
import K3.AbstractC0612b;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public class T extends C0446p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final G3.k f1236d;

    public T(G3.q qVar, C0446p.b bVar, C2105D c2105d) {
        super(qVar, bVar, c2105d);
        AbstractC0612b.d(G3.y.C(c2105d), "KeyFieldFilter expects a ReferenceValue", new Object[0]);
        this.f1236d = G3.k.i(h().t0());
    }

    @Override // D3.C0446p, D3.AbstractC0447q
    public boolean d(G3.h hVar) {
        return j(hVar.getKey().compareTo(this.f1236d));
    }
}
