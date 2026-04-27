package D;

import C.e;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static o a(C.e eVar, int i8, ArrayList arrayList, o oVar) {
        C.d dVar;
        int iO1;
        int i9 = i8 == 0 ? eVar.f304I0 : eVar.f306J0;
        if (i9 != -1 && (oVar == null || i9 != oVar.f710b)) {
            int i10 = 0;
            while (true) {
                if (i10 >= arrayList.size()) {
                    break;
                }
                o oVar2 = (o) arrayList.get(i10);
                if (oVar2.c() == i9) {
                    if (oVar != null) {
                        oVar.g(i8, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                } else {
                    i10++;
                }
            }
        } else if (i9 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if ((eVar instanceof C.i) && (iO1 = ((C.i) eVar).o1(i8)) != -1) {
                int i11 = 0;
                while (true) {
                    if (i11 >= arrayList.size()) {
                        break;
                    }
                    o oVar3 = (o) arrayList.get(i11);
                    if (oVar3.c() == iO1) {
                        oVar = oVar3;
                        break;
                    }
                    i11++;
                }
            }
            if (oVar == null) {
                oVar = new o(i8);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(eVar)) {
            if (eVar instanceof C.g) {
                C.g gVar = (C.g) eVar;
                gVar.n1().b(gVar.o1() == 0 ? 1 : 0, arrayList, oVar);
            }
            int iC = oVar.c();
            if (i8 == 0) {
                eVar.f304I0 = iC;
                eVar.f311O.b(i8, arrayList, oVar);
                dVar = eVar.f313Q;
            } else {
                eVar.f306J0 = iC;
                eVar.f312P.b(i8, arrayList, oVar);
                eVar.f315S.b(i8, arrayList, oVar);
                dVar = eVar.f314R;
            }
            dVar.b(i8, arrayList, oVar);
            eVar.f318V.b(i8, arrayList, oVar);
        }
        return oVar;
    }

    public static o b(ArrayList arrayList, int i8) {
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            o oVar = (o) arrayList.get(i9);
            if (i8 == oVar.f710b) {
                return oVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x0340  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(C.f r16, D.b.InterfaceC0012b r17) {
        /*
            Method dump skipped, instruction units count: 913
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.i.c(C.f, D.b$b):boolean");
    }

    public static boolean d(e.b bVar, e.b bVar2, e.b bVar3, e.b bVar4) {
        e.b bVar5;
        e.b bVar6;
        e.b bVar7 = e.b.FIXED;
        return (bVar3 == bVar7 || bVar3 == (bVar6 = e.b.WRAP_CONTENT) || (bVar3 == e.b.MATCH_PARENT && bVar != bVar6)) || (bVar4 == bVar7 || bVar4 == (bVar5 = e.b.WRAP_CONTENT) || (bVar4 == e.b.MATCH_PARENT && bVar2 != bVar5));
    }
}
