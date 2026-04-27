package Y6;

import d7.AbstractC1645f;
import java.lang.reflect.InvocationTargetException;
import o5.AbstractC2477e;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class K {
    public static final void a(InterfaceC2711i interfaceC2711i, Throwable th) {
        try {
            J j8 = (J) interfaceC2711i.a(J.f9627K);
            if (j8 != null) {
                j8.M(interfaceC2711i, th);
            } else {
                AbstractC1645f.a(interfaceC2711i, th);
            }
        } catch (Throwable th2) {
            AbstractC1645f.a(interfaceC2711i, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        AbstractC2477e.a(runtimeException, th);
        return runtimeException;
    }
}
