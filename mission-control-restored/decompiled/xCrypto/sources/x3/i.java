package x3;

import Z2.i;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Z2.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f15771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Z2.i f15772b;

    public i(Throwable th, Z2.i iVar) {
        this.f15771a = th;
        this.f15772b = iVar;
    }

    @Override // Z2.i
    public Object fold(Object obj, i3.o oVar) {
        return this.f15772b.fold(obj, oVar);
    }

    @Override // Z2.i
    public i.b get(i.c cVar) {
        return this.f15772b.get(cVar);
    }

    @Override // Z2.i
    public Z2.i minusKey(i.c cVar) {
        return this.f15772b.minusKey(cVar);
    }

    @Override // Z2.i
    public Z2.i plus(Z2.i iVar) {
        return this.f15772b.plus(iVar);
    }
}
