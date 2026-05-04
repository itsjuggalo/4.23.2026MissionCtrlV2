package xf;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c1 extends l2 implements bg.k, bg.l {
    public c1() {
        super(null);
    }

    public abstract c1 U0(boolean z10);

    public abstract c1 V0(q1 q1Var);

    public String toString() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = getAnnotations().iterator();
        while (it.hasNext()) {
            kg.w.j(sb2, "[", hf.n.O(hf.n.f11357k, (ge.c) it.next(), null, 2, null), "] ");
        }
        sb2.append(N0());
        if (!L0().isEmpty()) {
            dd.a0.f0(L0(), sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "<", (124 & 8) == 0 ? ">" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        if (O0()) {
            sb2.append("?");
        }
        return sb2.toString();
    }
}
