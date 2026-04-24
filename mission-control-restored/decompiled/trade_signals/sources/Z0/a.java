package Z0;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ExecutorService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f9706b = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f9707c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f9708a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f9709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ThreadFactory f9712d = new c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f9713e = e.f9727d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f9714f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f9715g;

        public b(boolean z7) {
            this.f9709a = z7;
        }

        public a a() {
            if (TextUtils.isEmpty(this.f9714f)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f9714f);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f9710b, this.f9711c, this.f9715g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new d(this.f9712d, this.f9714f, this.f9713e, this.f9709a));
            if (this.f9715g != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new a(threadPoolExecutor);
        }

        public b b(String str) {
            this.f9714f = str;
            return this;
        }

        public b c(int i8) {
            this.f9710b = i8;
            this.f9711c = i8;
            return this;
        }
    }

    public static final class c implements ThreadFactory {

        /* JADX INFO: renamed from: Z0.a$c$a, reason: collision with other inner class name */
        public class C0159a extends Thread {
            public C0159a(Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        public c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0159a(runnable);
        }
    }

    public static final class d implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadFactory f9717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f9718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f9719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f9720d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicInteger f9721e = new AtomicInteger();

        /* JADX INFO: renamed from: Z0.a$d$a, reason: collision with other inner class name */
        public class RunnableC0160a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f9722a;

            public RunnableC0160a(Runnable runnable) {
                this.f9722a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f9720d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.f9722a.run();
                } catch (Throwable th) {
                    d.this.f9719c.a(th);
                }
            }
        }

        public d(ThreadFactory threadFactory, String str, e eVar, boolean z7) {
            this.f9717a = threadFactory;
            this.f9718b = str;
            this.f9719c = eVar;
            this.f9720d = z7;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f9717a.newThread(new RunnableC0160a(runnable));
            threadNewThread.setName("glide-" + this.f9718b + "-thread-" + this.f9721e.getAndIncrement());
            return threadNewThread;
        }
    }

    public a(ExecutorService executorService) {
        this.f9708a = executorService;
    }

    public static a B() {
        return r().a();
    }

    public static b D() {
        return new b(false).c(c()).b(FirebaseAnalytics.Param.SOURCE);
    }

    public static a E() {
        return D().a();
    }

    public static a K() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f9706b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new d(new c(), "source-unlimited", e.f9727d, false)));
    }

    public static int a() {
        return c() >= 4 ? 2 : 1;
    }

    public static int c() {
        if (f9707c == 0) {
            f9707c = Math.min(4, Z0.b.a());
        }
        return f9707c;
    }

    public static b e() {
        return new b(true).c(a()).b("animation");
    }

    public static a f() {
        return e().a();
    }

    public static b r() {
        return new b(true).c(1).b("disk-cache");
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j8, TimeUnit timeUnit) {
        return this.f9708a.awaitTermination(j8, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f9708a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return this.f9708a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return this.f9708a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f9708a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f9708a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f9708a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        return this.f9708a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return this.f9708a.submit(runnable);
    }

    public String toString() {
        return this.f9708a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j8, TimeUnit timeUnit) {
        return this.f9708a.invokeAll(collection, j8, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j8, TimeUnit timeUnit) {
        return this.f9708a.invokeAny(collection, j8, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return this.f9708a.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return this.f9708a.submit(callable);
    }

    public interface e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f9724a = new C0161a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f9725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f9726c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f9727d;

        public class b implements e {
            @Override // Z0.a.e
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        }

        public class c implements e {
            @Override // Z0.a.e
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            b bVar = new b();
            f9725b = bVar;
            f9726c = new c();
            f9727d = bVar;
        }

        void a(Throwable th);

        /* JADX INFO: renamed from: Z0.a$e$a, reason: collision with other inner class name */
        public class C0161a implements e {
            @Override // Z0.a.e
            public void a(Throwable th) {
            }
        }
    }
}
