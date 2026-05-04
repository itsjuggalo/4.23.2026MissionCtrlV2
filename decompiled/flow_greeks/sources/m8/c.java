package m8;

import j8.a0;
import j8.s;
import java.lang.Thread;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f16082a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends ScheduledThreadPoolExecutor implements AutoCloseable {
        public a(int i10, ThreadFactory threadFactory) {
            super(i10, threadFactory);
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
                c.this.g(th);
            }
        }

        @Override // java.lang.AutoCloseable
        public /* synthetic */ void close() {
            l3.a.a(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements ThreadFactory {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Thread.UncaughtExceptionHandler {
            public a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                c.this.g(th);
            }
        }

        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = c.this.e().newThread(runnable);
            a0 a0VarF = c.this.f();
            a0VarF.a(threadNewThread, "FirebaseDatabaseWorker");
            a0VarF.b(threadNewThread, true);
            a0VarF.c(threadNewThread, new a());
            return threadNewThread;
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    public c() {
        a aVar = new a(1, new b(this, null));
        this.f16082a = aVar;
        aVar.setKeepAliveTime(3L, TimeUnit.SECONDS);
    }

    public static String h(Throwable th) {
        if (th instanceof OutOfMemoryError) {
            return "Firebase Database encountered an OutOfMemoryError. You may need to reduce the amount of data you are syncing to the client (e.g. by using queries or syncing a deeper path). See https://firebase.google.com/docs/database/ios/structure-data#best_practices_for_data_structure and https://firebase.google.com/docs/database/android/retrieve-data#filtering_data";
        }
        if (th instanceof NoClassDefFoundError) {
            return "A symbol that the Firebase Database SDK depends on failed to load. This usually indicates that your project includes an incompatible version of another Firebase dependency. If updating your dependencies to the latest version does not resolve this issue, please file a report at https://github.com/firebase/firebase-android-sdk";
        }
        if (th instanceof e8.d) {
            return "";
        }
        return "Uncaught exception in Firebase Database runloop (" + e8.h.i() + "). If you are not already on the latest version of the Firebase SDKs, try updating your dependencies. Should this problem persist, please file a report at https://github.com/firebase/firebase-android-sdk";
    }

    @Override // j8.s
    public void a() {
        this.f16082a.setCorePoolSize(1);
    }

    @Override // j8.s
    public void b(Runnable runnable) {
        this.f16082a.execute(runnable);
    }

    @Override // j8.s
    public ScheduledFuture c(Runnable runnable, long j10) {
        return this.f16082a.schedule(runnable, j10, TimeUnit.MILLISECONDS);
    }

    public ScheduledExecutorService d() {
        return this.f16082a;
    }

    public ThreadFactory e() {
        return Executors.defaultThreadFactory();
    }

    public a0 f() {
        return a0.f13948a;
    }

    public abstract void g(Throwable th);
}
