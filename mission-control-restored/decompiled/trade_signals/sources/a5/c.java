package a5;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends P4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.a f9971a;

    public c(V4.a aVar) {
        this.f9971a = aVar;
    }

    @Override // P4.b
    public void p(P4.c cVar) {
        S4.b bVarB = S4.c.b();
        cVar.b(bVarB);
        try {
            this.f9971a.run();
            if (bVarB.g()) {
                return;
            }
            cVar.a();
        } catch (Throwable th) {
            T4.b.b(th);
            if (bVarB.g()) {
                return;
            }
            cVar.onError(th);
        }
    }
}
