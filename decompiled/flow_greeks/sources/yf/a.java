package yf;

import xf.t1;
import yf.f;
import yf.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final t1 a(boolean z10, boolean z11, b typeSystemContext, f kotlinTypePreparator, g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(typeSystemContext, "typeSystemContext");
        kotlin.jvm.internal.t.f(kotlinTypePreparator, "kotlinTypePreparator");
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new t1(z10, z11, true, typeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
    }

    public static /* synthetic */ t1 b(boolean z10, boolean z11, b bVar, f fVar, g gVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        if ((i10 & 4) != 0) {
            bVar = s.f25429a;
        }
        if ((i10 & 8) != 0) {
            fVar = f.a.f25403a;
        }
        if ((i10 & 16) != 0) {
            gVar = g.a.f25404a;
        }
        return a(z10, z11, bVar, fVar, gVar);
    }
}
