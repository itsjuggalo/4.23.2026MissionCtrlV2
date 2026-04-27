package K4;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends a {
    public h(I4.d dVar) {
        super(dVar);
        if (dVar != null && dVar.getContext() != I4.j.f650a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // I4.d
    public final I4.i getContext() {
        return I4.j.f650a;
    }
}
