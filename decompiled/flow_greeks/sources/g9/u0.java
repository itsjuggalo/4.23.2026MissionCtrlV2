package g9;

import g9.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u0 extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f10374d;

    /* JADX WARN: Illegal instructions before constructor call */
    public u0(j9.q qVar, bb.d0 d0Var) {
        p.b bVar = p.b.NOT_IN;
        super(qVar, bVar, d0Var);
        ArrayList arrayList = new ArrayList();
        this.f10374d = arrayList;
        arrayList.addAll(t0.k(bVar, d0Var));
    }

    @Override // g9.p, g9.q
    public boolean d(j9.h hVar) {
        return !this.f10374d.contains(hVar.getKey());
    }
}
