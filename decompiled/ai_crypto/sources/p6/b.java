package p6;

import kotlin.jvm.internal.r;
import r6.j0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static final X5.c a(e eVar) {
        r.f(eVar, "<this>");
        if (eVar instanceof j0) {
            return a(((j0) eVar).k());
        }
        return null;
    }

    public static final e b(u6.e eVar, e descriptor) {
        n6.b bVarC;
        r.f(eVar, "<this>");
        r.f(descriptor, "descriptor");
        X5.c cVarA = a(descriptor);
        if (cVarA == null || (bVarC = u6.e.c(eVar, cVarA, null, 2, null)) == null) {
            return null;
        }
        return bVarC.getDescriptor();
    }
}
