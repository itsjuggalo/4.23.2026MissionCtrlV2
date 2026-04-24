package b6;

import E5.AbstractC0460e;
import g6.AbstractC1648h;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class K {
    public static final void a(H5.g gVar, Throwable th) {
        try {
            J j7 = (J) gVar.get(J.f9007K);
            if (j7 != null) {
                j7.M(gVar, th);
            } else {
                AbstractC1648h.a(gVar, th);
            }
        } catch (Throwable th2) {
            AbstractC1648h.a(gVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        AbstractC0460e.a(runtimeException, th);
        return runtimeException;
    }
}
