package D3;

import D3.C0446p;
import java.util.ArrayList;
import java.util.List;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public class V extends C0446p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f1238d;

    /* JADX WARN: Illegal instructions before constructor call */
    public V(G3.q qVar, C2105D c2105d) {
        C0446p.b bVar = C0446p.b.NOT_IN;
        super(qVar, bVar, c2105d);
        ArrayList arrayList = new ArrayList();
        this.f1238d = arrayList;
        arrayList.addAll(U.k(bVar, c2105d));
    }

    @Override // D3.C0446p, D3.AbstractC0447q
    public boolean d(G3.h hVar) {
        return !this.f1238d.contains(hVar.getKey());
    }
}
