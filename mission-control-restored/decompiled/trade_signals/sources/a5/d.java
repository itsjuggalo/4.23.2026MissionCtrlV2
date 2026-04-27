package a5;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends P4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f9972a;

    public d(Callable callable) {
        this.f9972a = callable;
    }

    @Override // P4.b
    public void p(P4.c cVar) {
        S4.b bVarB = S4.c.b();
        cVar.b(bVarB);
        try {
            this.f9972a.call();
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
