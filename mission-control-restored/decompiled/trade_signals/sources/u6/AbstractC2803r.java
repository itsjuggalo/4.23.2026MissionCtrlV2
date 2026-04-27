package u6;

import R5.InterfaceC0844a;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import p5.z;

/* JADX INFO: renamed from: u6.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2803r {
    public static final Collection b(Collection collection, B5.k descriptorByHandle) {
        AbstractC2304t.f(collection, "<this>");
        AbstractC2304t.f(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        S6.l lVarA = S6.l.f7769c.a();
        while (!linkedList.isEmpty()) {
            Object objY = z.Y(linkedList);
            S6.l lVarA2 = S6.l.f7769c.a();
            Collection collectionQ = C2800o.q(objY, linkedList, descriptorByHandle, new C2802q(lVarA2));
            AbstractC2304t.e(collectionQ, "extractMembersOverridableInBothWays(...)");
            if (collectionQ.size() == 1 && lVarA2.isEmpty()) {
                Object objT0 = z.t0(collectionQ);
                AbstractC2304t.e(objT0, "single(...)");
                lVarA.add(objT0);
            } else {
                Object objL = C2800o.L(collectionQ, descriptorByHandle);
                InterfaceC0844a interfaceC0844a = (InterfaceC0844a) descriptorByHandle.invoke(objL);
                for (Object obj : collectionQ) {
                    AbstractC2304t.c(obj);
                    if (!C2800o.B(interfaceC0844a, (InterfaceC0844a) descriptorByHandle.invoke(obj))) {
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

    public static final C2470H c(S6.l lVar, Object obj) {
        AbstractC2304t.c(obj);
        lVar.add(obj);
        return C2470H.f21956a;
    }
}
