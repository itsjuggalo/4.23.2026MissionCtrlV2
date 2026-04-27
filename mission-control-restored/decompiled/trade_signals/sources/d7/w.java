package d7;

import java.lang.reflect.InvocationTargetException;
import o5.AbstractC2477e;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w {
    public static final void a(B5.k kVar, Object obj, InterfaceC2711i interfaceC2711i) throws IllegalAccessException, InvocationTargetException {
        P pB = b(kVar, obj, null);
        if (pB != null) {
            Y6.K.a(interfaceC2711i, pB);
        }
    }

    public static final P b(B5.k kVar, Object obj, P p8) throws IllegalAccessException, InvocationTargetException {
        try {
            kVar.invoke(obj);
        } catch (Throwable th) {
            if (p8 == null || p8.getCause() == th) {
                return new P("Exception in undelivered element handler for " + obj, th);
            }
            AbstractC2477e.a(p8, th);
        }
        return p8;
    }

    public static /* synthetic */ P c(B5.k kVar, Object obj, P p8, int i8, Object obj2) {
        if ((i8 & 2) != 0) {
            p8 = null;
        }
        return b(kVar, obj, p8);
    }
}
