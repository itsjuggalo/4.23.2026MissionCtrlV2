package O3;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public class k implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f4190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f4191b;

    public k(p pVar, TaskCompletionSource taskCompletionSource) {
        this.f4190a = pVar;
        this.f4191b = taskCompletionSource;
    }

    @Override // O3.o
    public boolean a(Exception exc) {
        this.f4191b.trySetException(exc);
        return true;
    }

    @Override // O3.o
    public boolean b(P3.d dVar) {
        if (!dVar.k() || this.f4190a.f(dVar)) {
            return false;
        }
        this.f4191b.setResult(m.a().b(dVar.b()).d(dVar.c()).c(dVar.h()).a());
        return true;
    }
}
