package x3;

import W2.E;
import a3.AbstractC0787c;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends g {
    public /* synthetic */ h(w3.d dVar, Z2.i iVar, int i4, v3.a aVar, int i5, AbstractC1585j abstractC1585j) {
        this(dVar, (i5 & 2) != 0 ? Z2.j.f6012a : iVar, (i5 & 4) != 0 ? -3 : i4, (i5 & 8) != 0 ? v3.a.SUSPEND : aVar);
    }

    @Override // x3.e
    public e f(Z2.i iVar, int i4, v3.a aVar) {
        return new h(this.f15767d, iVar, i4, aVar);
    }

    @Override // x3.g
    public Object m(w3.e eVar, Z2.e eVar2) {
        Object objCollect = this.f15767d.collect(eVar, eVar2);
        return objCollect == AbstractC0787c.e() ? objCollect : E.f5463a;
    }

    public h(w3.d dVar, Z2.i iVar, int i4, v3.a aVar) {
        super(dVar, iVar, i4, aVar);
    }
}
