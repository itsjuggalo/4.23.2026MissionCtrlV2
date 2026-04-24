package H3;

import J3.j0;
import kotlin.jvm.internal.r;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final InterfaceC1716c a(e eVar) {
        r.f(eVar, "<this>");
        if (eVar instanceof j0) {
            return a(((j0) eVar).k());
        }
        return null;
    }

    public static final e b(M3.e eVar, e descriptor) {
        F3.b bVarC;
        r.f(eVar, "<this>");
        r.f(descriptor, "descriptor");
        InterfaceC1716c interfaceC1716cA = a(descriptor);
        if (interfaceC1716cA == null || (bVarC = M3.e.c(eVar, interfaceC1716cA, null, 2, null)) == null) {
            return null;
        }
        return bVarC.getDescriptor();
    }
}
