package rg;

import gd.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements gd.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gd.i f19900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f19901b;

    public i(Throwable th, gd.i iVar) {
        this.f19900a = iVar;
        this.f19901b = th;
    }

    @Override // gd.i
    public Object fold(Object obj, pd.o oVar) {
        return this.f19900a.fold(obj, oVar);
    }

    @Override // gd.i
    public i.b get(i.c cVar) {
        return this.f19900a.get(cVar);
    }

    @Override // gd.i
    public gd.i minusKey(i.c cVar) {
        return this.f19900a.minusKey(cVar);
    }

    @Override // gd.i
    public gd.i plus(gd.i iVar) {
        return this.f19900a.plus(iVar);
    }
}
