package ce;

import dd.a0;
import java.util.Set;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static final boolean a(d dVar, fe.e classDescriptor) {
        t.f(dVar, "<this>");
        t.f(classDescriptor, "classDescriptor");
        if (!jf.i.x(classDescriptor)) {
            return false;
        }
        Set setB = dVar.b();
        ef.b bVarN = nf.e.n(classDescriptor);
        return a0.R(setB, bVarN != null ? bVarN.e() : null);
    }
}
