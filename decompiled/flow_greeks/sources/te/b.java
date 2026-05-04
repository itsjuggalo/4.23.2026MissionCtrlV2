package te;

import dd.t0;
import fe.l1;
import kotlin.jvm.internal.t;
import xf.h2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final a a(h2 h2Var, boolean z10, boolean z11, l1 l1Var) {
        t.f(h2Var, "<this>");
        return new a(h2Var, null, z11, z10, l1Var != null ? t0.c(l1Var) : null, null, 34, null);
    }

    public static /* synthetic */ a b(h2 h2Var, boolean z10, boolean z11, l1 l1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        if ((i10 & 4) != 0) {
            l1Var = null;
        }
        return a(h2Var, z10, z11, l1Var);
    }
}
