package tf;

import fe.q1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y0 {
    public static final q1 a(ze.c cVar, bf.c nameResolver, bf.g typeTable, pd.k typeDeserializer, pd.k typeOfPublicProperty) {
        bg.j jVar;
        List listR0;
        kotlin.jvm.internal.t.f(cVar, "<this>");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(typeTable, "typeTable");
        kotlin.jvm.internal.t.f(typeDeserializer, "typeDeserializer");
        kotlin.jvm.internal.t.f(typeOfPublicProperty, "typeOfPublicProperty");
        if (cVar.L0() <= 0) {
            if (!cVar.n1()) {
                return null;
            }
            ef.f fVarB = l0.b(nameResolver, cVar.I0());
            ze.q qVarI = bf.f.i(cVar, typeTable);
            if ((qVarI != null && (jVar = (bg.j) typeDeserializer.invoke(qVarI)) != null) || (jVar = (bg.j) typeOfPublicProperty.invoke(fVarB)) != null) {
                return new fe.a0(fVarB, jVar);
            }
            throw new IllegalStateException(("cannot determine underlying type for value class " + l0.b(nameResolver, cVar.E0()) + " with property " + fVarB).toString());
        }
        List<Integer> listM0 = cVar.M0();
        kotlin.jvm.internal.t.e(listM0, "getMultiFieldValueClassUnderlyingNameList(...)");
        ArrayList arrayList = new ArrayList(dd.s.u(listM0, 10));
        for (Integer num : listM0) {
            kotlin.jvm.internal.t.c(num);
            arrayList.add(l0.b(nameResolver, num.intValue()));
        }
        cd.q qVarA = cd.w.a(Integer.valueOf(cVar.P0()), Integer.valueOf(cVar.O0()));
        if (kotlin.jvm.internal.t.b(qVarA, cd.w.a(Integer.valueOf(arrayList.size()), 0))) {
            List<Integer> listQ0 = cVar.Q0();
            kotlin.jvm.internal.t.e(listQ0, "getMultiFieldValueClassUnderlyingTypeIdList(...)");
            listR0 = new ArrayList(dd.s.u(listQ0, 10));
            for (Integer num2 : listQ0) {
                kotlin.jvm.internal.t.c(num2);
                listR0.add(typeTable.a(num2.intValue()));
            }
        } else {
            if (!kotlin.jvm.internal.t.b(qVarA, cd.w.a(0, Integer.valueOf(arrayList.size())))) {
                throw new IllegalStateException(("class " + l0.b(nameResolver, cVar.E0()) + " has illegal multi-field value class representation").toString());
            }
            listR0 = cVar.R0();
        }
        kotlin.jvm.internal.t.c(listR0);
        ArrayList arrayList2 = new ArrayList(dd.s.u(listR0, 10));
        Iterator it = listR0.iterator();
        while (it.hasNext()) {
            arrayList2.add(typeDeserializer.invoke(it.next()));
        }
        return new fe.i0(dd.a0.S0(arrayList, arrayList2));
    }
}
