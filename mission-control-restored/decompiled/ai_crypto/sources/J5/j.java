package J5;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends a {
    public j(H5.d dVar) {
        super(dVar);
        if (dVar != null && dVar.getContext() != H5.h.f2671a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // H5.d
    public H5.g getContext() {
        return H5.h.f2671a;
    }
}
