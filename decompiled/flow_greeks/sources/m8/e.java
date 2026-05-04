package m8;

import java.util.Iterator;
import r8.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static long a(r8.k kVar) {
        long length = 8;
        if (!(kVar instanceof r8.f) && !(kVar instanceof r8.l)) {
            if (kVar instanceof r8.a) {
                length = 4;
            } else {
                if (!(kVar instanceof t)) {
                    throw new IllegalArgumentException("Unknown leaf node type: " + kVar.getClass());
                }
                length = ((long) ((String) kVar.getValue()).length()) + 2;
            }
        }
        return kVar.n().isEmpty() ? length : length + 24 + a((r8.k) kVar.n());
    }

    public static long b(r8.n nVar) {
        if (nVar.isEmpty()) {
            return 4L;
        }
        if (nVar.J()) {
            return a((r8.k) nVar);
        }
        m.g(nVar instanceof r8.c, "Unexpected node type: " + nVar.getClass());
        Iterator it = nVar.iterator();
        long length = 1;
        while (it.hasNext()) {
            r8.m mVar = (r8.m) it.next();
            length = length + ((long) mVar.c().b().length()) + 4 + b(mVar.d());
        }
        return !nVar.n().isEmpty() ? length + 12 + a((r8.k) nVar.n()) : length;
    }

    public static int c(r8.n nVar) {
        int iC = 0;
        if (nVar.isEmpty()) {
            return 0;
        }
        if (nVar.J()) {
            return 1;
        }
        m.g(nVar instanceof r8.c, "Unexpected node type: " + nVar.getClass());
        Iterator it = nVar.iterator();
        while (it.hasNext()) {
            iC += c(((r8.m) it.next()).d());
        }
        return iC;
    }
}
