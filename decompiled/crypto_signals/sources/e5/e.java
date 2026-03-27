package e5;

import R4.p;

/* JADX INFO: loaded from: classes.dex */
public final class e implements I4.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I4.i f6360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f6361b;

    public e(I4.i iVar, Throwable th) {
        this.f6360a = iVar;
        this.f6361b = th;
    }

    @Override // I4.i
    public final Object fold(Object obj, p pVar) {
        return this.f6360a.fold(obj, pVar);
    }

    @Override // I4.i
    public final I4.g get(I4.h hVar) {
        return this.f6360a.get(hVar);
    }

    @Override // I4.i
    public final I4.i minusKey(I4.h hVar) {
        return this.f6360a.minusKey(hVar);
    }

    @Override // I4.i
    public final I4.i plus(I4.i iVar) {
        return this.f6360a.plus(iVar);
    }
}
