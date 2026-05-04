package jf;

import cd.h0;
import dd.a0;
import java.util.Collection;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r {
    public static final Collection b(Collection collection, pd.k descriptorByHandle) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        kotlin.jvm.internal.t.f(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        hg.l lVarA = hg.l.f11443c.a();
        while (!linkedList.isEmpty()) {
            Object objZ = a0.Z(linkedList);
            hg.l lVarA2 = hg.l.f11443c.a();
            Collection collectionQ = o.q(objZ, linkedList, descriptorByHandle, new q(lVarA2));
            kotlin.jvm.internal.t.e(collectionQ, "extractMembersOverridableInBothWays(...)");
            if (collectionQ.size() == 1 && lVarA2.isEmpty()) {
                Object objU0 = a0.u0(collectionQ);
                kotlin.jvm.internal.t.e(objU0, "single(...)");
                lVarA.add(objU0);
            } else {
                Object objL = o.L(collectionQ, descriptorByHandle);
                fe.a aVar = (fe.a) descriptorByHandle.invoke(objL);
                for (Object obj : collectionQ) {
                    kotlin.jvm.internal.t.c(obj);
                    if (!o.B(aVar, (fe.a) descriptorByHandle.invoke(obj))) {
                        lVarA2.add(obj);
                    }
                }
                if (!lVarA2.isEmpty()) {
                    lVarA.addAll(lVarA2);
                }
                lVarA.add(objL);
            }
        }
        return lVarA;
    }

    public static final h0 c(hg.l lVar, Object obj) {
        kotlin.jvm.internal.t.c(obj);
        lVar.add(obj);
        return h0.f3852a;
    }
}
