package n9;

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
import n9.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f16904c = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f16903b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f16902a = new c();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f16905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f16906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f16907c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ScheduledFuture f16908d;

        public void c() {
            g.this.t();
            ScheduledFuture scheduledFuture = this.f16908d;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                e();
            }
        }

        public final void d() {
            g.this.t();
            if (this.f16908d != null) {
                e();
                this.f16907c.run();
            }
        }

        public final void e() {
            n9.b.d(this.f16908d != null, "Caller should have verified scheduledFuture is non-null.", new Object[0]);
            this.f16908d = null;
            g.this.r(this);
        }

        public final void f(long j10) {
            this.f16908d = g.this.f16902a.schedule(new Runnable() { // from class: n9.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16933a.d();
                }
            }, j10, TimeUnit.MILLISECONDS);
        }

        public b(d dVar, long j10, Runnable runnable) {
            this.f16905a = dVar;
            this.f16906b = j10;
            this.f16907c = runnable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledThreadPoolExecutor f16910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f16911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Thread f16912c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends ScheduledThreadPoolExecutor implements AutoCloseable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f16914a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(int i10, ThreadFactory threadFactory, g gVar) {
                super(i10, threadFactory);
                this.f16914a = gVar;
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
                    } catch (ExecutionException e10) {
                        th = e10.getCause();
                    }
                }
                if (th != null) {
                    g.this.q(th);
                }
            }

            @Override // java.lang.AutoCloseable
            public /* synthetic */ void close() {
                l3.a.a(this);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class b implements Runnable, ThreadFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CountDownLatch f16916a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Runnable f16917b;

            public b() {
                this.f16916a = new CountDownLatch(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                n9.b.d(this.f16917b == null, "Only one thread may be created in an AsyncQueue.", new Object[0]);
                this.f16917b = runnable;
                this.f16916a.countDown();
                return c.this.f16912c;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f16916a.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                this.f16917b.run();
            }
        }

        public c() {
            b bVar = new b();
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(bVar);
            this.f16912c = threadNewThread;
            threadNewThread.setName("FirestoreWorker");
            threadNewThread.setDaemon(true);
            threadNewThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: n9.i
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread, Throwable th) {
                    g.this.q(th);
                }
            });
            a aVar = new a(1, bVar, g.this);
            this.f16910a = aVar;
            aVar.setKeepAliveTime(3L, TimeUnit.SECONDS);
            this.f16911b = false;
        }

        public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource, Callable callable) {
            try {
                taskCompletionSource.setResult(callable.call());
            } catch (Exception e10) {
                taskCompletionSource.setException(e10);
                throw new RuntimeException(e10);
            }
        }

        public static /* synthetic */ Void b(Runnable runnable) {
            runnable.run();
            return null;
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            if (!this.f16911b) {
                this.f16910a.execute(runnable);
            }
        }

        public final synchronized Task l(final Runnable runnable) {
            if (!o()) {
                Task taskM = m(new Callable() { // from class: n9.j
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return g.c.b(runnable);
                    }
                });
                this.f16911b = true;
                return taskM;
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(null);
            return taskCompletionSource.getTask();
        }

        public final Task m(final Callable callable) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            try {
                execute(new Runnable() { // from class: n9.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.c.a(taskCompletionSource, callable);
                    }
                });
            } catch (RejectedExecutionException unused) {
                v.e(g.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
            return taskCompletionSource.getTask();
        }

        public void n(Runnable runnable) {
            try {
                this.f16910a.execute(runnable);
            } catch (RejectedExecutionException unused) {
                v.e(g.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
        }

        public final synchronized boolean o() {
            return this.f16911b;
        }

        public final void p(int i10) {
            this.f16910a.setCorePoolSize(i10);
        }

        public final void q() {
            this.f16910a.shutdownNow();
        }

        public final synchronized ScheduledFuture schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f16911b) {
                return null;
            }
            return this.f16910a.schedule(runnable, j10, timeUnit);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

    public static /* synthetic */ void a(Callable callable, Executor executor, final TaskCompletionSource taskCompletionSource) {
        try {
            ((Task) callable.call()).continueWith(executor, new Continuation() { // from class: n9.f
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return g.d(taskCompletionSource, task);
                }
            });
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        } catch (Throwable th) {
            taskCompletionSource.setException(new IllegalStateException("Unhandled throwable in callTask.", th));
        }
    }

    public static /* synthetic */ Void b(Runnable runnable) {
        runnable.run();
        return null;
    }

    public static /* synthetic */ void c(Throwable th) {
        if (!(th instanceof OutOfMemoryError)) {
            throw new RuntimeException("Internal error in Cloud Firestore (26.0.2).", th);
        }
        OutOfMemoryError outOfMemoryError = new OutOfMemoryError("Firestore (26.0.2) ran out of memory. Check your queries to make sure they are not loading an excessive amount of data.");
        outOfMemoryError.initCause(th);
        throw outOfMemoryError;
    }

    public static /* synthetic */ Void d(TaskCompletionSource taskCompletionSource, Task task) {
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(task.getResult());
            return null;
        }
        taskCompletionSource.setException(task.getException());
        return null;
    }

    public static Task g(final Executor executor, final Callable callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: n9.e
            @Override // java.lang.Runnable
            public final void run() {
                g.a(callable, executor, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final b h(d dVar, long j10, Runnable runnable) {
        b bVar = new b(dVar, System.currentTimeMillis() + j10, runnable);
        bVar.f(j10);
        return bVar;
    }

    public Task i(final Runnable runnable) {
        return j(new Callable() { // from class: n9.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return g.b(runnable);
            }
        });
    }

    public Task j(Callable callable) {
        return this.f16902a.m(callable);
    }

    public b k(d dVar, long j10, Runnable runnable) {
        if (this.f16904c.contains(dVar)) {
            j10 = 0;
        }
        b bVarH = h(dVar, j10, runnable);
        this.f16903b.add(bVarH);
        return bVarH;
    }

    public void l(Runnable runnable) {
        i(runnable);
    }

    public void m(Runnable runnable) {
        this.f16902a.n(runnable);
    }

    public Task n(Runnable runnable) {
        return this.f16902a.l(runnable);
    }

    public Executor o() {
        return this.f16902a;
    }

    public boolean p() {
        return this.f16902a.o();
    }

    public void q(final Throwable th) {
        this.f16902a.q();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: n9.c
            @Override // java.lang.Runnable
            public final void run() {
                g.c(th);
            }
        });
    }

    public final void r(b bVar) {
        n9.b.d(this.f16903b.remove(bVar), "Delayed task not found.", new Object[0]);
    }

    public void s() {
        this.f16902a.p(0);
    }

    public void t() {
        Thread threadCurrentThread = Thread.currentThread();
        if (this.f16902a.f16912c != threadCurrentThread) {
            throw n9.b.a("We are running on the wrong thread. Expected to be on the AsyncQueue thread %s/%d but was %s/%d", this.f16902a.f16912c.getName(), Long.valueOf(this.f16902a.f16912c.getId()), threadCurrentThread.getName(), Long.valueOf(threadCurrentThread.getId()));
        }
    }
}
