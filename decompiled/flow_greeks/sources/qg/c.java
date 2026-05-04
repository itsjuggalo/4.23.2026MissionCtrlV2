package qg;

import cd.h0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class c extends rg.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pd.o f19117d;

    public /* synthetic */ c(pd.o oVar, gd.i iVar, int i10, pg.a aVar, int i11, kotlin.jvm.internal.k kVar) {
        this(oVar, (i11 & 2) != 0 ? gd.j.f10531a : iVar, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? pg.a.f18621a : aVar);
    }

    public static /* synthetic */ Object j(c cVar, pg.v vVar, gd.e eVar) {
        Object objInvoke = cVar.f19117d.invoke(vVar, eVar);
        return objInvoke == hd.c.f() ? objInvoke : h0.f3852a;
    }

    @Override // rg.e
    public Object e(pg.v vVar, gd.e eVar) {
        return j(this, vVar, eVar);
    }

    @Override // rg.e
    public rg.e f(gd.i iVar, int i10, pg.a aVar) {
        return new c(this.f19117d, iVar, i10, aVar);
    }

    @Override // rg.e
    public String toString() {
        return "block[" + this.f19117d + "] -> " + super.toString();
    }

    public c(pd.o oVar, gd.i iVar, int i10, pg.a aVar) {
        super(iVar, i10, aVar);
        this.f19117d = oVar;
    }
}
