package c7;

import d7.K;
import kotlin.jvm.internal.V;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import t5.AbstractC2750b;
import t5.AbstractC2751c;
import u5.AbstractC2774a;
import u5.AbstractC2781h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {
    public static final Object b(InterfaceC2711i interfaceC2711i, Object obj, Object obj2, B5.o oVar, InterfaceC2707e interfaceC2707e) {
        Object objI = K.i(interfaceC2711i, obj2);
        try {
            t tVar = new t(interfaceC2707e, interfaceC2711i);
            Object objD = !(oVar instanceof AbstractC2774a) ? AbstractC2750b.d(oVar, obj, tVar) : ((B5.o) V.c(oVar, 2)).invoke(obj, tVar);
            K.f(interfaceC2711i, objI);
            if (objD == AbstractC2751c.f()) {
                AbstractC2781h.c(interfaceC2707e);
            }
            return objD;
        } catch (Throwable th) {
            K.f(interfaceC2711i, objI);
            throw th;
        }
    }

    public static /* synthetic */ Object c(InterfaceC2711i interfaceC2711i, Object obj, Object obj2, B5.o oVar, InterfaceC2707e interfaceC2707e, int i8, Object obj3) {
        if ((i8 & 4) != 0) {
            obj2 = K.g(interfaceC2711i);
        }
        return b(interfaceC2711i, obj, obj2, oVar, interfaceC2707e);
    }

    public static final b7.e d(b7.e eVar, InterfaceC2711i interfaceC2711i) {
        return !(eVar instanceof s) ? new u(eVar, interfaceC2711i) : eVar;
    }
}
