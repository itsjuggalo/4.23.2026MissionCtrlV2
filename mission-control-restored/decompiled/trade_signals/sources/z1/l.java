package z1;

import w1.EnumC2903f;
import w1.InterfaceC2906i;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static void a(InterfaceC2906i interfaceC2906i, EnumC2903f enumC2903f) {
        if (!(interfaceC2906i instanceof s)) {
            D1.a.g("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", interfaceC2906i);
        } else {
            u.c().e().u(((s) interfaceC2906i).d().f(enumC2903f), 1);
        }
    }
}
