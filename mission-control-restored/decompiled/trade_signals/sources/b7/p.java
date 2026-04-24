package b7;

import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B5.o f13303a;

    public p(B5.o oVar) {
        this.f13303a = oVar;
    }

    @Override // b7.a
    public Object c(e eVar, InterfaceC2707e interfaceC2707e) {
        Object objInvoke = this.f13303a.invoke(eVar, interfaceC2707e);
        return objInvoke == AbstractC2751c.f() ? objInvoke : C2470H.f21956a;
    }
}
