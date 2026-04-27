package i3;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: i3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class ExecutorC1978e implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f16257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f16258b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Task f16259c = Tasks.forResult(null);

    public ExecutorC1978e(ExecutorService executorService) {
        this.f16257a = executorService;
    }

    public static /* synthetic */ Task d(Runnable runnable, Task task) {
        runnable.run();
        return Tasks.forResult(null);
    }

    public static /* synthetic */ Task e(Callable callable, Task task) {
        return (Task) callable.call();
    }

    public ExecutorService c() {
        return this.f16257a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f16257a.execute(runnable);
    }

    public Task f(final Runnable runnable) {
        Task taskContinueWithTask;
        synchronized (this.f16258b) {
            taskContinueWithTask = this.f16259c.continueWithTask(this.f16257a, new Continuation() { // from class: i3.d
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return ExecutorC1978e.d(runnable, task);
                }
            });
            this.f16259c = taskContinueWithTask;
        }
        return taskContinueWithTask;
    }

    public Task g(final Callable callable) {
        Task taskContinueWithTask;
        synchronized (this.f16258b) {
            taskContinueWithTask = this.f16259c.continueWithTask(this.f16257a, new Continuation() { // from class: i3.c
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return ExecutorC1978e.e(callable, task);
                }
            });
            this.f16259c = taskContinueWithTask;
        }
        return taskContinueWithTask;
    }
}
