package xe;

import cf.a;
import df.d;
import gf.i;
import xe.a0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final a0 a(ze.n proto, bf.c nameResolver, bf.g typeTable, boolean z10, boolean z11, boolean z12) {
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(typeTable, "typeTable");
        i.f propertySignature = cf.a.f4053d;
        kotlin.jvm.internal.t.e(propertySignature, "propertySignature");
        a.d dVar = (a.d) bf.e.a(proto, propertySignature);
        if (dVar == null) {
            return null;
        }
        if (z10) {
            d.a aVarC = df.i.f8111a.c(proto, nameResolver, typeTable, z12);
            if (aVarC == null) {
                return null;
            }
            return a0.f24814b.b(aVarC);
        }
        if (!z11 || !dVar.I()) {
            return null;
        }
        a0.a aVar = a0.f24814b;
        a.c cVarD = dVar.D();
        kotlin.jvm.internal.t.e(cVarD, "getSyntheticMethod(...)");
        return aVar.c(nameResolver, cVarD);
    }

    public static /* synthetic */ a0 b(ze.n nVar, bf.c cVar, bf.g gVar, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        if ((i10 & 16) != 0) {
            z11 = false;
        }
        if ((i10 & 32) != 0) {
            z12 = true;
        }
        return a(nVar, cVar, gVar, z10, z11, z12);
    }
}
