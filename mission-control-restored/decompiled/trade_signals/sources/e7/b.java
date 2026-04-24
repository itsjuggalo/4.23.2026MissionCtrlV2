package e7;

import B5.o;
import Y6.A;
import Y6.B0;
import d7.K;
import d7.z;
import kotlin.jvm.internal.V;
import o5.AbstractC2491s;
import o5.C2490r;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import t5.AbstractC2750b;
import t5.AbstractC2751c;
import u5.AbstractC2774a;
import u5.AbstractC2781h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static final void a(o oVar, Object obj, InterfaceC2707e interfaceC2707e) {
        InterfaceC2707e interfaceC2707eA = AbstractC2781h.a(interfaceC2707e);
        try {
            InterfaceC2711i context = interfaceC2707eA.getContext();
            Object objI = K.i(context, null);
            try {
                AbstractC2781h.b(interfaceC2707eA);
                Object objD = !(oVar instanceof AbstractC2774a) ? AbstractC2750b.d(oVar, obj, interfaceC2707eA) : ((o) V.c(oVar, 2)).invoke(obj, interfaceC2707eA);
                K.f(context, objI);
                if (objD != AbstractC2751c.f()) {
                    interfaceC2707eA.resumeWith(C2490r.b(objD));
                }
            } catch (Throwable th) {
                K.f(context, objI);
                throw th;
            }
        } catch (Throwable th2) {
            C2490r.a aVar = C2490r.f21981b;
            interfaceC2707eA.resumeWith(C2490r.b(AbstractC2491s.a(th2)));
        }
    }

    public static final Object b(z zVar, Object obj, o oVar) {
        Object a8;
        Object objT0;
        try {
            a8 = !(oVar instanceof AbstractC2774a) ? AbstractC2750b.d(oVar, obj, zVar) : ((o) V.c(oVar, 2)).invoke(obj, zVar);
        } catch (Throwable th) {
            a8 = new A(th, false, 2, null);
        }
        if (a8 == AbstractC2751c.f() || (objT0 = zVar.t0(a8)) == B0.f9615b) {
            return AbstractC2751c.f();
        }
        if (objT0 instanceof A) {
            throw ((A) objT0).f9602a;
        }
        return B0.h(objT0);
    }
}
