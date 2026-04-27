package h3;

import e3.C1478g;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: h3.K, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1680K {

    /* JADX INFO: renamed from: h3.K$a */
    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f14766b;

        /* JADX INFO: renamed from: h3.K$a$a, reason: collision with other inner class name */
        public class C0245a extends AbstractRunnableC1690d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f14767a;

            public C0245a(Runnable runnable) {
                this.f14767a = runnable;
            }

            @Override // h3.AbstractRunnableC1690d
            public void a() {
                this.f14767a.run();
            }
        }

        public a(String str, AtomicLong atomicLong) {
            this.f14765a = str;
            this.f14766b = atomicLong;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(new C0245a(runnable));
            threadNewThread.setName(this.f14765a + this.f14766b.getAndIncrement());
            return threadNewThread;
        }
    }

    /* JADX INFO: renamed from: h3.K$b */
    public class b extends AbstractRunnableC1690d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ExecutorService f14770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f14771c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TimeUnit f14772d;

        public b(String str, ExecutorService executorService, long j7, TimeUnit timeUnit) {
            this.f14769a = str;
            this.f14770b = executorService;
            this.f14771c = j7;
            this.f14772d = timeUnit;
        }

        @Override // h3.AbstractRunnableC1690d
        public void a() {
            try {
                C1478g.f().b("Executing shutdown hook for " + this.f14769a);
                this.f14770b.shutdown();
                if (this.f14770b.awaitTermination(this.f14771c, this.f14772d)) {
                    return;
                }
                C1478g.f().b(this.f14769a + " did not shut down in the allocated time. Requesting immediate shutdown.");
                this.f14770b.shutdownNow();
            } catch (InterruptedException unused) {
                C1478g.f().b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f14769a));
                this.f14770b.shutdownNow();
            }
        }
    }

    public static void a(String str, ExecutorService executorService) {
        b(str, executorService, 2L, TimeUnit.SECONDS);
    }

    public static void b(String str, ExecutorService executorService, long j7, TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new b(str, executorService, j7, timeUnit), "Crashlytics Shutdown Hook for " + str));
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
