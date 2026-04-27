package I6;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: renamed from: I6.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0613d0 extends M0 implements M6.k, M6.l {
    public AbstractC0613d0() {
        super(null);
    }

    public abstract AbstractC0613d0 V0(boolean z7);

    public abstract AbstractC0613d0 W0(r0 r0Var);

    public String toString() throws IOException {
        StringBuilder sb = new StringBuilder();
        Iterator it = getAnnotations().iterator();
        while (it.hasNext()) {
            V6.x.j(sb, "[", t6.n.O(t6.n.f23389k, (S5.c) it.next(), null, 2, null), "] ");
        }
        sb.append(O0());
        if (!M0().isEmpty()) {
            p5.z.e0(M0(), sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "<", (124 & 8) == 0 ? ">" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        if (P0()) {
            sb.append("?");
        }
        return sb.toString();
    }
}
