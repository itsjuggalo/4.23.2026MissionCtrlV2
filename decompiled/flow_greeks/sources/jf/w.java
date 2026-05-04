package jf;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w {
    public static final fe.b a(Collection descriptors) {
        Integer numD;
        kotlin.jvm.internal.t.f(descriptors, "descriptors");
        descriptors.isEmpty();
        Iterator it = descriptors.iterator();
        fe.b bVar = null;
        while (it.hasNext()) {
            fe.b bVar2 = (fe.b) it.next();
            if (bVar == null || ((numD = fe.t.d(bVar.getVisibility(), bVar2.getVisibility())) != null && numD.intValue() < 0)) {
                bVar = bVar2;
            }
        }
        kotlin.jvm.internal.t.c(bVar);
        return bVar;
    }
}
