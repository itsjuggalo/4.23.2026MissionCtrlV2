package p6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import o6.AbstractC2492a;

/* JADX INFO: renamed from: p6.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2605h {
    public static final List a(List list) {
        AbstractC2304t.f(list, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC2492a.e.c cVar = (AbstractC2492a.e.c) it.next();
            int iG = cVar.G();
            for (int i8 = 0; i8 < iG; i8++) {
                arrayList.add(cVar);
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
