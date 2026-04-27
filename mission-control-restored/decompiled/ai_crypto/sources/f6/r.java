package f6;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements H5.d, J5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H5.d f14222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H5.g f14223b;

    public r(H5.d dVar, H5.g gVar) {
        this.f14222a = dVar;
        this.f14223b = gVar;
    }

    @Override // J5.e
    public J5.e getCallerFrame() {
        H5.d dVar = this.f14222a;
        if (dVar instanceof J5.e) {
            return (J5.e) dVar;
        }
        return null;
    }

    @Override // H5.d
    public H5.g getContext() {
        return this.f14223b;
    }

    @Override // H5.d
    public void resumeWith(Object obj) {
        this.f14222a.resumeWith(obj);
    }
}
