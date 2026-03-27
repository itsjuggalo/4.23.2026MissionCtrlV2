package d7;

import java.util.Iterator;
import o5.AbstractC2477e;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: d7.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1645f {
    public static final void a(InterfaceC2711i interfaceC2711i, Throwable th) {
        Iterator it = AbstractC1644e.a().iterator();
        while (it.hasNext()) {
            try {
                ((Y6.J) it.next()).M(interfaceC2711i, th);
            } catch (Throwable th2) {
                AbstractC1644e.b(Y6.K.b(th, th2));
            }
        }
        try {
            AbstractC2477e.a(th, new C1646g(interfaceC2711i));
        } catch (Throwable unused) {
        }
        AbstractC1644e.b(th);
    }
}
