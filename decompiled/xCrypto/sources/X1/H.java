package X1;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class H implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskCompletionSource f5540a;

    public H() {
        this.f5540a = null;
    }

    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f5540a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    public abstract void b();

    public final TaskCompletionSource c() {
        return this.f5540a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b();
        } catch (Exception e4) {
            a(e4);
        }
    }

    public H(TaskCompletionSource taskCompletionSource) {
        this.f5540a = taskCompletionSource;
    }
}
