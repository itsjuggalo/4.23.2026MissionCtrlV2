package w3;

import W2.E;
import a3.AbstractC0787c;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i3.o f15666a;

    public p(i3.o oVar) {
        this.f15666a = oVar;
    }

    @Override // w3.a
    public Object c(e eVar, Z2.e eVar2) {
        Object objInvoke = this.f15666a.invoke(eVar, eVar2);
        return objInvoke == AbstractC0787c.e() ? objInvoke : E.f5463a;
    }
}
