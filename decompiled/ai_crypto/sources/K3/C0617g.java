package K3;

import K3.C0617g;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: K3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0617g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f3399c = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3398b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f3397a = new c();

    /* JADX INFO: renamed from: K3.g$b */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f3400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f3401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f3402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ScheduledFuture f3403d;

        public void c() {
            C0617g.this.x();
            ScheduledFuture scheduledFuture = this.f3403d;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                e();
            }
        }

        public final void d() {
            C0617g.this.x();
            if (this.f3403d != null) {
                e();
                this.f3402c.run();
            }
        }

        public final void e() {
            AbstractC0612b.d(this.f3403d != null, "Caller should have verified scheduledFuture is non-null.", new Object[0]);
            this.f3403d = null;
            C0617g.this.v(this);
        }

        public final void f(long j7) {
            this.f3403d = C0617g.this.f3397a.schedule(new Runnable() { // from class: K3.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3426a.d();
                }
            }, j7, TimeUnit.MILLISECONDS);
        }

        public b(d dVar, long j7, Runnable runnable) {
            this.f3400a = dVar;
            this.f3401b = j7;
            this.f3402c = runnable;
        }
    }

    /* JADX INFO: renamed from: K3.g$c */
    public class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledThreadPoolExecutor f3405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Thread f3407c;

        /* JADX INFO: renamed from: K3.g$c$a */
        public class a extends ScheduledThreadPoolExecutor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0617g f3409a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(int i7, ThreadFactory threadFactory, C0617g c0617g) {
                super(i7, threadFactory);
                this.f3409a = c0617g;
            }

            @Override // java.util.concurrent.ThreadPoolExecutor
            public void afterExecute(Runnable runnable, Throwable th) {
                super.afterExecute(runnable, th);
                if (th == null && (runnable instanceof Future)) {
                    Future future = (Future) runnable;
                    try {
                        if (future.isDone()) {
                            future.get();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    } catch (CancellationException unused2) {
                    } catch (ExecutionException e7) {
                        th = e7.getCause();
                    }
                }
                if (th != null) {
                    C0617g.this.u(th);
                }
            }
        }

        /* JADX INFO: renamed from: K3.g$c$b */
        public class b implements Runnable, ThreadFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CountDownLatch f3411a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Runnable f3412b;

            public b() {
                this.f3411a = new CountDownLatch(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                AbstractC0612b.d(this.f3412b == null, "Only one thread may be created in an AsyncQueue.", new Object[0]);
                this.f3412b = runnable;
                this.f3411a.countDown();
                return c.this.f3407c;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f3411a.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                this.f3412b.run();
            }
        }

        public c() {
            b bVar = new b();
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(bVar);
            this.f3407c = threadNewThread;
            threadNewThread.setName("FirestoreWorker");
            threadNewThread.setDaemon(true);
            threadNewThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: K3.i
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread, Throwable th) {
                    this.f3427a.r(thread, th);
                }
            });
            a aVar = new a(1, bVar, C0617g.this);
            this.f3405a = aVar;
            aVar.setKeepAliveTime(3L, TimeUnit.SECONDS);
            this.f3406b = false;
        }

        public static /* synthetic */ Void p(Runnable runnable) {
            runnable.run();
            return null;
        }

        public static /* synthetic */ void q(TaskCompletionSource taskCompletionSource, Callable callable) {
            try {
                taskCompletionSource.setResult(callable.call());
            } catch (Exception e7) {
                taskCompletionSource.setException(e7);
                throw new RuntimeException(e7);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            if (!this.f3406b) {
                this.f3405a.execute(runnable);
            }
        }

        public final synchronized Task l(final Runnable runnable) {
            if (!o()) {
                Task taskM = m(new Callable() { // from class: K3.j
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return C0617g.c.p(runnable);
                    }
                });
                this.f3406b = true;
                return taskM;
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(null);
            return taskCompletionSource.getTask();
        }

        public final Task m(final Callable callable) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            try {
                execute(new Runnable() { // from class: K3.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0617g.c.q(taskCompletionSource, callable);
                    }
                });
            } catch (RejectedExecutionException unused) {
                x.e(C0617g.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
            return taskCompletionSource.getTask();
        }

        public void n(Runnable runnable) {
            try {
                this.f3405a.execute(runnable);
            } catch (RejectedExecutionException unused) {
                x.e(C0617g.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
        }

        public final synchronized boolean o() {
            return this.f3406b;
        }

        public final /* synthetic */ void r(Thread thread, Throwable th) {
            C0617g.this.u(th);
        }

        public final void s(int i7) {
            this.f3405a.setCorePoolSize(i7);
        }

        public final synchronized ScheduledFuture schedule(Runnable runnable, long j7, TimeUnit timeUnit) {
            if (this.f3406b) {
                return null;
            }
            return this.f3405a.schedule(runnable, j7, timeUnit);
        }

        public final void t() {
            this.f3405a.shutdownNow();
        }
    }

    /* JADX INFO: renamed from: K3.g$d */
    public enum d {
        ALL,
        LISTEN_STREAM_IDLE,
        LISTEN_STREAM_CONNECTION_BACKOFF,
        WRITE_STREAM_IDLE,
        WRITE_STREAM_CONNECTION_BACKOFF,
        HEALTH_CHECK_TIMEOUT,
        ONLINE_STATE_TIMEOUT,
        GARBAGE_COLLECTION,
        RETRY_TRANSACTION,
        CONNECTIVITY_ATTEMPT_TIMER,
        INDEX_BACKFILL
    }

    public static Task g(final Executor executor, final Callable callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: K3.e
            @Override // java.lang.Runnable
            public final void run() {
                C0617g.r(callable, executor, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static /* synthetic */ Void q(TaskCompletionSource taskCompletionSource, Task task) {
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(task.getResult());
            return null;
        }
        taskCompletionSource.setException(task.getException());
        return null;
    }

    public static /* synthetic */ void r(Callable callable, Executor executor, final TaskCompletionSource taskCompletionSource) {
        try {
            ((Task) callable.call()).continueWith(executor, new Continuation() { // from class: K3.f
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return C0617g.q(taskCompletionSource, task);
                }
            });
        } catch (Exception e7) {
            taskCompletionSource.setException(e7);
        } catch (Throwable th) {
            taskCompletionSource.setException(new IllegalStateException("Unhandled throwable in callTask.", th));
        }
    }

    public static /* synthetic */ Void s(Runnable runnable) {
        runnable.run();
        return null;
    }

    public static /* synthetic */ void t(Throwable th) {
        if (!(th instanceof OutOfMemoryError)) {
            throw new RuntimeException("Internal error in Cloud Firestore (25.1.4).", th);
        }
        OutOfMemoryError outOfMemoryError = new OutOfMemoryError("Firestore (25.1.4) ran out of memory. Check your queries to make sure they are not loading an excessive amount of data.");
        outOfMemoryError.initCause(th);
        throw outOfMemoryError;
    }

    public final b h(d dVar, long j7, Runnable runnable) {
        b bVar = new b(dVar, System.currentTimeMillis() + j7, runnable);
        bVar.f(j7);
        return bVar;
    }

    public Task i(final Runnable runnable) {
        return j(new Callable() { // from class: K3.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C0617g.s(runnable);
            }
        });
    }

    public Task j(Callable callable) {
        return this.f3397a.m(callable);
    }

    public b k(d dVar, long j7, Runnable runnable) {
        if (this.f3399c.contains(dVar)) {
            j7 = 0;
        }
        b bVarH = h(dVar, j7, runnable);
        this.f3398b.add(bVarH);
        return bVarH;
    }

    public void l(Runnable runnable) {
        i(runnable);
    }

    public void m(Runnable runnable) {
        this.f3397a.n(runnable);
    }

    public Task n(Runnable runnable) {
        return this.f3397a.l(runnable);
    }

    public Executor o() {
        return this.f3397a;
    }

    public boolean p() {
        return this.f3397a.o();
    }

    public void u(final Throwable th) {
        this.f3397a.t();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: K3.c
            @Override // java.lang.Runnable
            public final void run() {
                C0617g.t(th);
            }
        });
    }

    public final void v(b bVar) {
        AbstractC0612b.d(this.f3398b.remove(bVar), "Delayed task not found.", new Object[0]);
    }

    public void w() {
        this.f3397a.s(0);
    }

    public void x() {
        Thread threadCurrentThread = Thread.currentThread();
        if (this.f3397a.f3407c != threadCurrentThread) {
            throw AbstractC0612b.a("We are running on the wrong thread. Expected to be on the AsyncQueue thread %s/%d but was %s/%d", this.f3397a.f3407c.getName(), Long.valueOf(this.f3397a.f3407c.getId()), threadCurrentThread.getName(), Long.valueOf(threadCurrentThread.getId()));
        }
    }
}
