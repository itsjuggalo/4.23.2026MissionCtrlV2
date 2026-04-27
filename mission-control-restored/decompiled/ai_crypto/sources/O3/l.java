package O3;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public class l implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource f4192a;

    public l(TaskCompletionSource taskCompletionSource) {
        this.f4192a = taskCompletionSource;
    }

    @Override // O3.o
    public boolean a(Exception exc) {
        return false;
    }

    @Override // O3.o
    public boolean b(P3.d dVar) {
        if (!dVar.l() && !dVar.k() && !dVar.i()) {
            return false;
        }
        this.f4192a.trySetResult(dVar.d());
        return true;
    }
}
