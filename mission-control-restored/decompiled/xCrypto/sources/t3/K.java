package t3;

import W2.AbstractC0737e;
import java.lang.reflect.InvocationTargetException;
import y3.AbstractC1954h;

/* JADX INFO: loaded from: classes3.dex */
public abstract class K {
    public static final void a(Z2.i iVar, Throwable th) {
        try {
            J j4 = (J) iVar.get(J.f14949L);
            if (j4 != null) {
                j4.A(iVar, th);
            } else {
                AbstractC1954h.a(iVar, th);
            }
        } catch (Throwable th2) {
            AbstractC1954h.a(iVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        AbstractC0737e.a(runtimeException, th);
        return runtimeException;
    }
}
