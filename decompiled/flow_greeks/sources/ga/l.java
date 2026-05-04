package ga;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource f10472a;

    public l(TaskCompletionSource taskCompletionSource) {
        this.f10472a = taskCompletionSource;
    }

    @Override // ga.o
    public boolean a(Exception exc) {
        return false;
    }

    @Override // ga.o
    public boolean b(ha.d dVar) {
        if (!dVar.l() && !dVar.k() && !dVar.i()) {
            return false;
        }
        this.f10472a.trySetResult(dVar.d());
        return true;
    }
}
