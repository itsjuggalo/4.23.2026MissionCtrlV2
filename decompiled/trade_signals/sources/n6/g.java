package n6;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import l6.q;
import l6.t;
import p5.AbstractC2595q;
import p5.r;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f21674a;

    public g(t typeTable) {
        AbstractC2304t.f(typeTable, "typeTable");
        List listB = typeTable.B();
        if (typeTable.C()) {
            int iY = typeTable.y();
            List listB2 = typeTable.B();
            AbstractC2304t.e(listB2, "getTypeList(...)");
            ArrayList arrayList = new ArrayList(r.s(listB2, 10));
            int i8 = 0;
            for (Object obj : listB2) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    AbstractC2595q.r();
                }
                q qVarS = (q) obj;
                if (i8 >= iY) {
                    qVarS = qVarS.g().I(true).a();
                }
                arrayList.add(qVarS);
                i8 = i9;
            }
            listB = arrayList;
        }
        AbstractC2304t.e(listB, "run(...)");
        this.f21674a = listB;
    }

    public final q a(int i8) {
        return (q) this.f21674a.get(i8);
    }
}
