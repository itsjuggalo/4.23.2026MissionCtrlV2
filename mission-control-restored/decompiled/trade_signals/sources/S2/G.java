package S2;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public abstract class G {

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f7488b;

        /* JADX INFO: renamed from: S2.G$a$a, reason: collision with other inner class name */
        public class C0107a extends AbstractRunnableC0898e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f7489a;

            public C0107a(Runnable runnable) {
                this.f7489a = runnable;
            }

            @Override // S2.AbstractRunnableC0898e
            public void a() {
                this.f7489a.run();
            }
        }

        public a(String str, AtomicLong atomicLong) {
            this.f7487a = str;
            this.f7488b = atomicLong;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(new C0107a(runnable));
            threadNewThread.setName(this.f7487a + this.f7488b.getAndIncrement());
            return threadNewThread;
        }
    }

    public class b extends AbstractRunnableC0898e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ExecutorService f7492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f7493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeUnit f7494d;

        public b(String str, ExecutorService executorService, long j8, TimeUnit timeUnit) {
            this.f7491a = str;
            this.f7492b = executorService;
            this.f7493c = j8;
            this.f7494d = timeUnit;
        }

        @Override // S2.AbstractRunnableC0898e
        public void a() {
            try {
                P2.g.f().b("Executing shutdown hook for " + this.f7491a);
                this.f7492b.shutdown();
                if (this.f7492b.awaitTermination(this.f7493c, this.f7494d)) {
                    return;
                }
                P2.g.f().b(this.f7491a + " did not shut down in the allocated time. Requesting immediate shutdown.");
                this.f7492b.shutdownNow();
            } catch (InterruptedException unused) {
                P2.g.f().b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f7491a));
                this.f7492b.shutdownNow();
            }
        }
    }

    public static void a(String str, ExecutorService executorService) {
        b(str, executorService, 2L, TimeUnit.SECONDS);
    }

    public static void b(String str, ExecutorService executorService, long j8, TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new b(str, executorService, j8, timeUnit), "Crashlytics Shutdown Hook for " + str));
    }

    public static ExecutorService c(String str) {
        ExecutorService executorServiceE = e(d(str), new ThreadPoolExecutor.DiscardPolicy());
        a(str, executorServiceE);
        return executorServiceE;
    }

    public static ThreadFactory d(String str) {
        return new a(str, new AtomicLong(1L));
    }

    public static ExecutorService e(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler));
    }
}
