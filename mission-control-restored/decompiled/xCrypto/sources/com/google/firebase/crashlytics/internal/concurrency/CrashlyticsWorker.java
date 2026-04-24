package com.google.firebase.crashlytics.internal.concurrency;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.storage.UploadTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class CrashlyticsWorker implements Executor {
    private final ExecutorService executor;
    private final Object tailLock = new Object();
    private Task<?> tail = Tasks.forResult(null);

    public CrashlyticsWorker(ExecutorService executorService) {
        this.executor = executorService;
    }

    public static /* synthetic */ Task a(Callable callable, Task task) {
        return (Task) callable.call();
    }

    public static /* synthetic */ void c() {
    }

    public static /* synthetic */ Task d(Runnable runnable, Task task) {
        runnable.run();
        return Tasks.forResult(null);
    }

    public static /* synthetic */ Task e(SuccessContinuation successContinuation, Task task) {
        return task.isSuccessful() ? successContinuation.then(task.getResult()) : task.getException() != null ? Tasks.forException(task.getException()) : Tasks.forCanceled();
    }

    public static /* synthetic */ Task f(Callable callable, Task task) {
        return (Task) callable.call();
    }

    public static /* synthetic */ Task h(Callable callable, Task task) {
        return (Task) callable.call();
    }

    public void await() throws InterruptedException, TimeoutException {
        Tasks.await(submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.concurrency.d
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsWorker.c();
            }
        }), 30L, TimeUnit.SECONDS);
        Thread.sleep(1L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.executor.execute(runnable);
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    public <T> Task<T> submit(final Callable<T> callable) {
        UploadTask uploadTask;
        synchronized (this.tailLock) {
            uploadTask = (Task<T>) this.tail.continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.c
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return Tasks.forResult(callable.call());
                }
            });
            this.tail = uploadTask;
        }
        return uploadTask;
    }

    public <T> Task<T> submitTask(final Callable<Task<T>> callable) {
        UploadTask uploadTask;
        synchronized (this.tailLock) {
            uploadTask = (Task<T>) this.tail.continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.e
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return CrashlyticsWorker.h(callable, task);
                }
            });
            this.tail = uploadTask;
        }
        return uploadTask;
    }

    public <T, R> Task<R> submitTaskOnSuccess(final Callable<Task<T>> callable, final SuccessContinuation<T, R> successContinuation) {
        UploadTask uploadTask;
        synchronized (this.tailLock) {
            uploadTask = (Task<R>) this.tail.continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.g
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return CrashlyticsWorker.f(callable, task);
                }
            }).continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.h
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return CrashlyticsWorker.e(successContinuation, task);
                }
            });
            this.tail = uploadTask;
        }
        return uploadTask;
    }

    public Task<Void> submit(final Runnable runnable) {
        Task taskContinueWithTask;
        synchronized (this.tailLock) {
            taskContinueWithTask = this.tail.continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.b
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return CrashlyticsWorker.d(runnable, task);
                }
            });
            this.tail = taskContinueWithTask;
        }
        return taskContinueWithTask;
    }

    public <T, R> Task<R> submitTask(final Callable<Task<T>> callable, Continuation<T, Task<R>> continuation) {
        UploadTask uploadTask;
        synchronized (this.tailLock) {
            uploadTask = (Task<R>) this.tail.continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.f
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return CrashlyticsWorker.a(callable, task);
                }
            }).continueWithTask(this.executor, continuation);
            this.tail = uploadTask;
        }
        return uploadTask;
    }
}
