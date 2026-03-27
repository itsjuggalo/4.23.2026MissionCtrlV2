package f6;

import H5.g;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements H5.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f14205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ H5.g f14206b;

    public i(Throwable th, H5.g gVar) {
        this.f14205a = th;
        this.f14206b = gVar;
    }

    @Override // H5.g
    public Object fold(Object obj, Q5.o oVar) {
        return this.f14206b.fold(obj, oVar);
    }

    @Override // H5.g
    public g.b get(g.c cVar) {
        return this.f14206b.get(cVar);
    }

    @Override // H5.g
    public H5.g minusKey(g.c cVar) {
        return this.f14206b.minusKey(cVar);
    }

    @Override // H5.g
    public H5.g plus(H5.g gVar) {
        return this.f14206b.plus(gVar);
    }
}
