package b3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends AbstractC0863a {
    public j(Z2.e eVar) {
        super(eVar);
        if (eVar != null && eVar.getContext() != Z2.j.f6012a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // Z2.e
    public Z2.i getContext() {
        return Z2.j.f6012a;
    }
}
