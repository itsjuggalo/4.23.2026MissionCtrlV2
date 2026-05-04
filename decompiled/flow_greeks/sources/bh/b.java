package bh;

import dh.r1;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final wd.d a(e eVar) {
        t.f(eVar, "<this>");
        if (eVar instanceof r1) {
            return a(((r1) eVar).b());
        }
        return null;
    }

    public static final e b(gh.e eVar, e descriptor) {
        zg.b bVarC;
        t.f(eVar, "<this>");
        t.f(descriptor, "descriptor");
        wd.d dVarA = a(descriptor);
        if (dVarA == null || (bVarC = gh.e.c(eVar, dVarA, null, 2, null)) == null) {
            return null;
        }
        return bVarC.getDescriptor();
    }
}
