package ga;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f10470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f10471b;

    public k(p pVar, TaskCompletionSource taskCompletionSource) {
        this.f10470a = pVar;
        this.f10471b = taskCompletionSource;
    }

    @Override // ga.o
    public boolean a(Exception exc) {
        this.f10471b.trySetException(exc);
        return true;
    }

    @Override // ga.o
    public boolean b(ha.d dVar) {
        if (!dVar.k() || this.f10470a.f(dVar)) {
            return false;
        }
        this.f10471b.setResult(m.a().b(dVar.b()).d(dVar.c()).c(dVar.h()).a());
        return true;
    }
}
