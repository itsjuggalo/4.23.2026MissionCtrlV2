package v7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f23147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f23148b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Task f23149c = Tasks.forResult(null);

    public e(ExecutorService executorService) {
        this.f23147a = executorService;
    }

    public static /* synthetic */ Task a(Runnable runnable, Task task) {
        runnable.run();
        return Tasks.forResult(null);
    }

    public static /* synthetic */ Task b(Callable callable, Task task) {
        return (Task) callable.call();
    }

    public ExecutorService d() {
        return this.f23147a;
    }

    public Task e(final Runnable runnable) {
        Task taskContinueWithTask;
        synchronized (this.f23148b) {
            taskContinueWithTask = this.f23149c.continueWithTask(this.f23147a, new Continuation() { // from class: v7.d
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return e.a(runnable, task);
                }
            });
            this.f23149c = taskContinueWithTask;
        }
        return taskContinueWithTask;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f23147a.execute(runnable);
    }

    public Task f(final Callable callable) {
        Task taskContinueWithTask;
        synchronized (this.f23148b) {
            taskContinueWithTask = this.f23149c.continueWithTask(this.f23147a, new Continuation() { // from class: v7.c
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return e.b(callable, task);
                }
            });
            this.f23149c = taskContinueWithTask;
        }
        return taskContinueWithTask;
    }
}
