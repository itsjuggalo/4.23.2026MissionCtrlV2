package r1;

import o1.EnumC2294f;
import o1.InterfaceC2297i;
import v1.AbstractC2763a;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static void a(InterfaceC2297i interfaceC2297i, EnumC2294f enumC2294f) {
        if (!(interfaceC2297i instanceof s)) {
            AbstractC2763a.g("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", interfaceC2297i);
        } else {
            u.c().e().u(((s) interfaceC2297i).d().f(enumC2294f), 1);
        }
    }
}
