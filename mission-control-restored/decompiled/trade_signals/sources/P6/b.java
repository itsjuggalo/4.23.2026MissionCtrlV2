package P6;

import P6.g;
import R5.InterfaceC0868z;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public final g a(InterfaceC0868z functionDescriptor) {
        AbstractC2304t.f(functionDescriptor, "functionDescriptor");
        for (h hVar : b()) {
            if (hVar.b(functionDescriptor)) {
                return hVar.a(functionDescriptor);
            }
        }
        return g.a.f6494b;
    }

    public abstract List b();
}
