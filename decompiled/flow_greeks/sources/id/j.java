package id;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends a {
    public j(gd.e eVar) {
        super(eVar);
        if (eVar != null && eVar.getContext() != gd.j.f10531a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // gd.e
    public gd.i getContext() {
        return gd.j.f10531a;
    }
}
