package rg;

import cd.h0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends g {
    public /* synthetic */ h(qg.d dVar, gd.i iVar, int i10, pg.a aVar, int i11, kotlin.jvm.internal.k kVar) {
        this(dVar, (i11 & 2) != 0 ? gd.j.f10531a : iVar, (i11 & 4) != 0 ? -3 : i10, (i11 & 8) != 0 ? pg.a.f18621a : aVar);
    }

    @Override // rg.e
    public e f(gd.i iVar, int i10, pg.a aVar) {
        return new h(this.f19896d, iVar, i10, aVar);
    }

    @Override // rg.g
    public Object m(qg.e eVar, gd.e eVar2) {
        Object objCollect = this.f19896d.collect(eVar, eVar2);
        return objCollect == hd.c.f() ? objCollect : h0.f3852a;
    }

    public h(qg.d dVar, gd.i iVar, int i10, pg.a aVar) {
        super(dVar, iVar, i10, aVar);
    }
}
