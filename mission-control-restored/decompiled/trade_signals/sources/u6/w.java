package u6;

import R5.AbstractC0862t;
import R5.InterfaceC0845b;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w {
    public static final InterfaceC0845b a(Collection descriptors) {
        Integer numD;
        AbstractC2304t.f(descriptors, "descriptors");
        descriptors.isEmpty();
        Iterator it = descriptors.iterator();
        InterfaceC0845b interfaceC0845b = null;
        while (it.hasNext()) {
            InterfaceC0845b interfaceC0845b2 = (InterfaceC0845b) it.next();
            if (interfaceC0845b == null || ((numD = AbstractC0862t.d(interfaceC0845b.getVisibility(), interfaceC0845b2.getVisibility())) != null && numD.intValue() < 0)) {
                interfaceC0845b = interfaceC0845b2;
            }
        }
        AbstractC2304t.c(interfaceC0845b);
        return interfaceC0845b;
    }
}
