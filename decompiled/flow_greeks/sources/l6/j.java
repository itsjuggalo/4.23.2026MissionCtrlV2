package l6;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource f15498a;

    public j() {
        this.f15498a = null;
    }

    public abstract void a();

    public final TaskCompletionSource b() {
        return this.f15498a;
    }

    public final void c(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f15498a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e10) {
            c(e10);
        }
    }

    public j(TaskCompletionSource taskCompletionSource) {
        this.f15498a = taskCompletionSource;
    }
}
