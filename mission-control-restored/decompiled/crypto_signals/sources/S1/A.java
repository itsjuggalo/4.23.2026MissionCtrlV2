package S1;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class A implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskCompletionSource f2844a;

    public A() {
        this.f2844a = null;
    }

    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f2844a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    public abstract void b();

    public final TaskCompletionSource c() {
        return this.f2844a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b();
        } catch (Exception e) {
            a(e);
        }
    }

    public A(TaskCompletionSource taskCompletionSource) {
        this.f2844a = taskCompletionSource;
    }
}
