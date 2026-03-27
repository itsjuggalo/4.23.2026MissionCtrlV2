package e7;

import B5.o;
import d7.AbstractC1648i;
import o5.AbstractC2491s;
import o5.C2470H;
import o5.C2490r;
import s5.InterfaceC2707e;
import t5.AbstractC2750b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final void a(InterfaceC2707e interfaceC2707e, Throwable th) throws Throwable {
        C2490r.a aVar = C2490r.f21981b;
        interfaceC2707e.resumeWith(C2490r.b(AbstractC2491s.a(th)));
        throw th;
    }

    public static final void b(o oVar, Object obj, InterfaceC2707e interfaceC2707e) {
        try {
            InterfaceC2707e interfaceC2707eC = AbstractC2750b.c(AbstractC2750b.a(oVar, obj, interfaceC2707e));
            C2490r.a aVar = C2490r.f21981b;
            AbstractC1648i.b(interfaceC2707eC, C2490r.b(C2470H.f21956a));
        } catch (Throwable th) {
            a(interfaceC2707e, th);
        }
    }

    public static final void c(InterfaceC2707e interfaceC2707e, InterfaceC2707e interfaceC2707e2) throws Throwable {
        try {
            InterfaceC2707e interfaceC2707eC = AbstractC2750b.c(interfaceC2707e);
            C2490r.a aVar = C2490r.f21981b;
            AbstractC1648i.b(interfaceC2707eC, C2490r.b(C2470H.f21956a));
        } catch (Throwable th) {
            a(interfaceC2707e2, th);
        }
    }
}
