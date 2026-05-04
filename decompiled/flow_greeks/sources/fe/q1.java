package fe;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q1 {
    public /* synthetic */ q1(kotlin.jvm.internal.k kVar) {
        this();
    }

    public abstract boolean a(ef.f fVar);

    public final q1 b(pd.k transform) {
        kotlin.jvm.internal.t.f(transform, "transform");
        if (this instanceof a0) {
            a0 a0Var = (a0) this;
            return new a0(a0Var.c(), (bg.j) transform.invoke(a0Var.d()));
        }
        if (!(this instanceof i0)) {
            throw new cd.o();
        }
        List<cd.q> listC = ((i0) this).c();
        ArrayList arrayList = new ArrayList(dd.s.u(listC, 10));
        for (cd.q qVar : listC) {
            arrayList.add(cd.w.a((ef.f) qVar.a(), transform.invoke((bg.j) qVar.b())));
        }
        return new i0(arrayList);
    }

    public q1() {
    }
}
