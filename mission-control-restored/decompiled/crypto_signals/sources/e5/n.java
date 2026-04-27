package e5;

/* JADX INFO: loaded from: classes.dex */
public final class n implements I4.d, K4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I4.d f6372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final I4.i f6373b;

    public n(I4.d dVar, I4.i iVar) {
        this.f6372a = dVar;
        this.f6373b = iVar;
    }

    @Override // K4.d
    public final K4.d getCallerFrame() {
        I4.d dVar = this.f6372a;
        if (dVar instanceof K4.d) {
            return (K4.d) dVar;
        }
        return null;
    }

    @Override // I4.d
    public final I4.i getContext() {
        return this.f6373b;
    }

    @Override // I4.d
    public final void resumeWith(Object obj) {
        this.f6372a.resumeWith(obj);
    }
}
