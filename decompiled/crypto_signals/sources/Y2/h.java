package Y2;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class h implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource f3610a;

    public h(TaskCompletionSource taskCompletionSource) {
        this.f3610a = taskCompletionSource;
    }

    @Override // Y2.j
    public final boolean a(Z2.b bVar) {
        int i = bVar.f3993b;
        if (i != 3 && i != 4 && i != 5) {
            return false;
        }
        this.f3610a.trySetResult(bVar.f3992a);
        return true;
    }

    @Override // Y2.j
    public final boolean b(Exception exc) {
        return false;
    }
}
