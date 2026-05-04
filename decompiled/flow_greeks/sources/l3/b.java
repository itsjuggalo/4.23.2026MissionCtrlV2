package l3;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.a;
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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ExecutorService, AutoCloseable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f15311b = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f15312c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f15313a;

    /* JADX INFO: renamed from: l3.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0271b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f15314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ThreadFactory f15317d = new c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f15318e = e.f15332d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f15319f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f15320g;

        public C0271b(boolean z10) {
            this.f15314a = z10;
        }

        public b a() {
            if (TextUtils.isEmpty(this.f15319f)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f15319f);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f15315b, this.f15316c, this.f15320g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new d(this.f15317d, this.f15319f, this.f15318e, this.f15314a));
            if (this.f15320g != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new b(threadPoolExecutor);
        }

        public C0271b b(String str) {
            this.f15319f = str;
            return this;
        }

        public C0271b c(int i10) {
            this.f15315b = i10;
            this.f15316c = i10;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements ThreadFactory {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends Thread {
            public a(Runnable runnable) {
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
            return new a(runnable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadFactory f15322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f15324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f15325d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicInteger f15326e = new AtomicInteger();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f15327a;

            public a(Runnable runnable) {
                this.f15327a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f15325d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.f15327a.run();
                } catch (Throwable th) {
                    d.this.f15324c.a(th);
                }
            }
        }

        public d(ThreadFactory threadFactory, String str, e eVar, boolean z10) {
            this.f15322a = threadFactory;
            this.f15323b = str;
            this.f15324c = eVar;
            this.f15325d = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f15322a.newThread(new a(runnable));
            threadNewThread.setName("glide-" + this.f15323b + "-thread-" + this.f15326e.getAndIncrement());
            return threadNewThread;
        }
    }

    public b(ExecutorService executorService) {
        this.f15313a = executorService;
    }

    public static C0271b C() {
        return new C0271b(true).c(1).b("disk-cache");
    }

    public static b E() {
        return C().a();
    }

    public static C0271b H() {
        return new C0271b(false).c(e()).b(FirebaseAnalytics.Param.SOURCE);
    }

    public static b K() {
        return H().a();
    }

    public static b N() {
        return new b(new ThreadPoolExecutor(0, a.e.API_PRIORITY_OTHER, f15311b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new d(new c(), "source-unlimited", e.f15332d, false)));
    }

    public static int b() {
        return e() >= 4 ? 2 : 1;
    }

    public static int e() {
        if (f15312c == 0) {
            f15312c = Math.min(4, l3.c.a());
        }
        return f15312c;
    }

    public static C0271b o() {
        return new C0271b(true).c(b()).b("animation");
    }

    public static b u() {
        return o().a();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return this.f15313a.awaitTermination(j10, timeUnit);
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        l3.a.a(this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f15313a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return this.f15313a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return this.f15313a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f15313a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f15313a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f15313a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        return this.f15313a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return this.f15313a.submit(runnable);
    }

    public String toString() {
        return this.f15313a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j10, TimeUnit timeUnit) {
        return this.f15313a.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j10, TimeUnit timeUnit) {
        return this.f15313a.invokeAny(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return this.f15313a.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return this.f15313a.submit(callable);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f15329a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f15330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f15331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f15332d;

        /* JADX INFO: renamed from: l3.b$e$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0272b implements e {
            @Override // l3.b.e
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class c implements e {
            @Override // l3.b.e
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            C0272b c0272b = new C0272b();
            f15330b = c0272b;
            f15331c = new c();
            f15332d = c0272b;
        }

        void a(Throwable th);

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements e {
            @Override // l3.b.e
            public void a(Throwable th) {
            }
        }
    }
}
