package g6;

import E5.AbstractC0460e;
import java.util.Iterator;

/* JADX INFO: renamed from: g6.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1648h {
    public static final void a(H5.g gVar, Throwable th) {
        Iterator it = AbstractC1647g.a().iterator();
        while (it.hasNext()) {
            try {
                ((b6.J) it.next()).M(gVar, th);
            } catch (Throwable th2) {
                AbstractC1647g.b(b6.K.b(th, th2));
            }
        }
        try {
            AbstractC0460e.a(th, new C1649i(gVar));
        } catch (Throwable unused) {
        }
        AbstractC1647g.b(th);
    }
}
