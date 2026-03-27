package U2;

import a.AbstractC0284a;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f3127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Thread f3129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f3130d;

    public d(f fVar) {
        this.f3130d = fVar;
        c cVar = new c(this);
        Thread threadNewThread = Executors.defaultThreadFactory().newThread(cVar);
        this.f3129c = threadNewThread;
        threadNewThread.setName("FirestoreWorker");
        threadNewThread.setDaemon(true);
        threadNewThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: U2.a
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                this.f3122a.f3130d.c(th);
            }
        });
        b bVar = new b(this, cVar);
        this.f3127a = bVar;
        bVar.setKeepAliveTime(3L, TimeUnit.SECONDS);
        this.f3128b = false;
    }

    public final Task a(Callable callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            execute(new E3.h(18, taskCompletionSource, callable));
        } catch (RejectedExecutionException unused) {
            AbstractC0284a.f(2, f.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
        }
        return taskCompletionSource.getTask();
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (!this.f3128b) {
            this.f3127a.execute(runnable);
        }
    }
}
