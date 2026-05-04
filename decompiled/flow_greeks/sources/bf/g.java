package bf;

import dd.r;
import dd.s;
import java.util.ArrayList;
import java.util.List;
import ze.q;
import ze.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3347a;

    public g(t typeTable) {
        kotlin.jvm.internal.t.f(typeTable, "typeTable");
        List listA = typeTable.A();
        if (typeTable.B()) {
            int iX = typeTable.x();
            List listA2 = typeTable.A();
            kotlin.jvm.internal.t.e(listA2, "getTypeList(...)");
            ArrayList arrayList = new ArrayList(s.u(listA2, 10));
            int i10 = 0;
            for (Object obj : listA2) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    r.t();
                }
                q qVarQ = (q) obj;
                if (i10 >= iX) {
                    qVarQ = qVarQ.f().H(true).build();
                }
                arrayList.add(qVarQ);
                i10 = i11;
            }
            listA = arrayList;
        }
        kotlin.jvm.internal.t.e(listA, "run(...)");
        this.f3347a = listA;
    }

    public final q a(int i10) {
        return (q) this.f3347a.get(i10);
    }
}
