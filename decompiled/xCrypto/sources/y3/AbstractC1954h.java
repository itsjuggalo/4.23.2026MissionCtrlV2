package y3;

import W2.AbstractC0737e;
import java.util.Iterator;

/* JADX INFO: renamed from: y3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1954h {
    public static final void a(Z2.i iVar, Throwable th) {
        Iterator it = AbstractC1953g.a().iterator();
        while (it.hasNext()) {
            try {
                ((t3.J) it.next()).A(iVar, th);
            } catch (Throwable th2) {
                AbstractC1953g.b(t3.K.b(th, th2));
            }
        }
        try {
            AbstractC0737e.a(th, new C1955i(iVar));
        } catch (Throwable unused) {
        }
        AbstractC1953g.b(th);
    }
}
