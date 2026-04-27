package w3;

import W2.E;
import a3.AbstractC0787c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends x3.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i3.o f15592d;

    public c(i3.o oVar, Z2.i iVar, int i4, v3.a aVar) {
        super(iVar, i4, aVar);
        this.f15592d = oVar;
    }

    public static /* synthetic */ Object j(c cVar, v3.s sVar, Z2.e eVar) {
        Object objInvoke = cVar.f15592d.invoke(sVar, eVar);
        return objInvoke == AbstractC0787c.e() ? objInvoke : E.f5463a;
    }

    @Override // x3.e
    public Object e(v3.s sVar, Z2.e eVar) {
        return j(this, sVar, eVar);
    }

    @Override // x3.e
    public String toString() {
        return "block[" + this.f15592d + "] -> " + super.toString();
    }
}
