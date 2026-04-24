package m7;

import kotlin.jvm.internal.AbstractC2304t;
import o7.s0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static final I5.d a(e eVar) {
        AbstractC2304t.f(eVar, "<this>");
        if (eVar instanceof s0) {
            return a(((s0) eVar).k());
        }
        return null;
    }

    public static final e b(r7.e eVar, e descriptor) {
        k7.b bVarC;
        AbstractC2304t.f(eVar, "<this>");
        AbstractC2304t.f(descriptor, "descriptor");
        I5.d dVarA = a(descriptor);
        if (dVarA == null || (bVarC = r7.e.c(eVar, dVarA, null, 2, null)) == null) {
            return null;
        }
        return bVarC.getDescriptor();
    }
}
